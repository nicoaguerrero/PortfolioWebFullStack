import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { experience } from 'src/app/model/experience.model';

@Injectable({
  providedIn: 'root'
})
export class ExperienceService {
  private url = 'http://localhost:8080/experience/';

  constructor(private http:HttpClient) { }

  public getExperience(): Observable<experience[]> {
    return this.http.get<experience[]>(this.url + 'bring');
  }
}
