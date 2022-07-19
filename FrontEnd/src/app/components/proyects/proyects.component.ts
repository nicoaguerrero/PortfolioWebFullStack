import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { proyect } from 'src/app/model/proyect.model';
import { ProyectService } from 'src/app/service/proyect.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-proyects',
  templateUrl: './proyects.component.html',
  styleUrls: ['./proyects.component.css']
})
export class ProyectsComponent implements OnInit {
  
  proyects:proyect[]=[];
  deleteProyect:proyect | undefined;
  editProyect:proyect | undefined;
  isLogged = false;
  constructor(public proyectService: ProyectService, private tokenService: TokenService) { }

  ngOnInit(): void {
    this.getProyects();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }
  }

  public getProyects():void{
    this.proyectService.getProyect().subscribe({
      next:(Response:proyect[]) =>{
        this.proyects=Response;
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    });
  }

  public onModalEvent(event:String, proyect?:proyect):void{
    switch(event){
      case 'edit': 
        this.editProyect=proyect;
        break;
      case 'delete': 
        this.deleteProyect=proyect;
        break;
    }
  }

  public onCreateProyect(addForm: NgForm){
    document.getElementById('create-proyect-form')?.click();
    this.proyectService.createProyect(addForm.value).subscribe({
      next:(Response:proyect[]) =>{
        console.log(Response);
        this.getProyects();
        addForm.resetForm();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
        addForm.reset();
      }
    });
  }

  public onEditProyect(proyect: proyect){
    this.proyectService.editProyect(proyect).subscribe({
      next:(Response:proyect) =>{
        console.log(Response);
        this.getProyects();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

  public onDeleteProyect(idProyect: number):void{
    this.proyectService.deleteProyect(idProyect).subscribe({
      next:(Response:void) =>{
        console.log(Response);
        this.getProyects();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

}
