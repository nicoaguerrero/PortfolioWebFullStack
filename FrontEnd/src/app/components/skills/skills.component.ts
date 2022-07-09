import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { skill } from 'src/app/model/skill.model';
import { SkillService } from 'src/app/service/skill.service';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {

  skills:skill[]=[];
  languages:skill[]=[];
  constructor(public skillService: SkillService) { }

  ngOnInit(): void {
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

}


