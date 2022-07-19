import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { skill } from 'src/app/model/skill.model';
import { SkillService } from 'src/app/service/skill.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {

  skills:skill[]=[];
  languages:skill[]=[];
  deleteSkill:skill | undefined;
  editSkill:skill | undefined;
  isLogged = false;
  constructor(public skillService: SkillService, private tokenService: TokenService) { }

  ngOnInit(): void {
    this.getSkills();
    
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }
  }

  public getSkills():void{
    this.skillService.getSkill().subscribe({
      next:(Response:skill[]) =>{
        this.skills=Response.filter(t=>t.language === false);
        this.languages = Response.filter(t=>t.language === true);
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    });
  }

  public onModalEvent(event:String, skill?:skill):void{
    switch(event){
      case 'edit': 
        this.editSkill=skill;
        break;
      case 'delete': 
        this.deleteSkill=skill;
        break;
    }
  }

  public onCreateSkill(addForm: NgForm){
    document.getElementById('create-skill-form')?.click();
    this.skillService.createSkill(addForm.value).subscribe({
      next:(Response:skill[]) =>{
        console.log(Response);
        this.getSkills();
        addForm.resetForm();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
        addForm.reset();
      }
    });
  }

  public onEditSkill(skill: skill){
    this.skillService.editSkill(skill).subscribe({
      next:(Response:skill) =>{
        console.log(Response);
        this.getSkills();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

  public onDeleteSkill(idSkill: number):void{
    this.skillService.deleteSkill(idSkill).subscribe({
      next:(Response:void) =>{
        console.log(Response);
        this.getSkills();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

}


