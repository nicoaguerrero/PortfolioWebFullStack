import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { proyect } from 'src/app/model/proyect.model';
import { ProyectService } from 'src/app/service/proyect.service';

@Component({
  selector: 'app-proyects',
  templateUrl: './proyects.component.html',
  styleUrls: ['./proyects.component.css']
})
export class ProyectsComponent implements OnInit {
  
  proyects:proyect[]=[];
  constructor(public proyectService: ProyectService) { }

  ngOnInit(): void {
    this.proyectService.getProyect().subscribe({
      next:(Response:proyect[]) =>{
        this.proyects=Response;
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    });
  }

}
