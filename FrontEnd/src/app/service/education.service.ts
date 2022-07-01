import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { education } from 'src/app/model/education.model';

@Injectable({
  providedIn: 'root'
})
export class EducationService {
  private url = 'http://localhost:8080/education/';

  constructor(private http:HttpClient) { }

  public getEducation(): Observable<education[]> {
    return this.http.get<education[]>(this.url + 'bring');
  }
}
