import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { person } from 'src/app/model/person.model';
import { PersonService } from 'src/app/service/person.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {
  person: person = new person('','','','','','');
  number:number = 0;
  isLogged = false;
  constructor(public personService: PersonService, private tokenService: TokenService) { }

  ngOnInit(): void {
    this.personService.getPerson().subscribe(data => {this.person = data});
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }
  }

  public onEditPerson(person: person){
    this.personService.editPerson(person).subscribe({
      next:(Response:person) =>{
        console.log(Response);
        this.personService.getPerson().subscribe(data => {this.person = data});
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

  public changeNumber(newNumber:number){
    this.number = newNumber;
  }

}
