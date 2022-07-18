import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { proyect } from '../model/proyect.model';

@Injectable({
  providedIn: 'root'
})
export class ProyectService {
  private url = 'http://localhost:8080/api/proyect/';

  constructor(private http:HttpClient) { }

  public getProyect(): Observable<proyect[]> {
    return this.http.get<proyect[]>(this.url + 'bring');
  }
}
