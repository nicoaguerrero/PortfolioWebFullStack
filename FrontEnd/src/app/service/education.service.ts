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

  public createEducation(education:education): Observable<education[]> {
    return this.http.post<education[]>(this.url + 'create', education);
  }

  public deleteEducation(id:number): Observable<void> {
    return this.http.delete<void>(this.url + 'delete/' + id);
  }

  public editEducation(education:education): Observable<education> {
    return this.http.put<education>(this.url + 'edit', education);
  }
}
