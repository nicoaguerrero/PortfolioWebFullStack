import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { education } from 'src/app/model/education.model';
import { EducationService } from 'src/app/service/education.service';

@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: ['./education.component.css']
})
export class EducationComponent implements OnInit {

  educations:education[]=[];
  constructor(public educationService: EducationService) { }

  ngOnInit(): void {
    this.educationService.getEducation().subscribe({
      next:(Response:education[]) =>{
        this.educations=Response;
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    });
  }

}
