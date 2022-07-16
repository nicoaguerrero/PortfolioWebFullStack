import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { education } from 'src/app/model/education.model';
import { EducationService } from 'src/app/service/education.service';

@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: ['./education.component.css']
})
export class EducationComponent implements OnInit {

  educations:education[]=[];
  deleteEducation:education | undefined;
  editEducation:education | undefined;
  constructor(public educationService: EducationService) { }

  ngOnInit(): void {
    this.getEducations();
  }

  public getEducations():void{
    this.educationService.getEducation().subscribe({
      next:(Response:education[]) =>{
        this.educations=Response;
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    });
  }

  public onModalEvent(event:String, education?:education):void{
    switch(event){
      case 'edit': 
        this.editEducation=education;
        break;
      case 'delete': 
        this.deleteEducation=education;
        break;
    }
  }

  
  public onCreateEducation(addForm: NgForm){
    document.getElementById('create-education-form')?.click();
    this.educationService.createEducation(addForm.value).subscribe({
      next:(Response:education[]) =>{
        console.log(Response);
        this.getEducations();
        addForm.resetForm();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
        addForm.reset();
      }
    });
  }

  public onEditEducation(education: education){
    this.educationService.editEducation(education).subscribe({
      next:(Response:education) =>{
        console.log(Response);
        this.getEducations();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

  public onDeleteEducation(idEdu: number):void{
    this.educationService.deleteEducation(idEdu).subscribe({
      next:(Response:void) =>{
        console.log(Response);
        this.getEducations();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

}
