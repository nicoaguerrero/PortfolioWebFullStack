import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { skill } from 'src/app/model/skill.model';

@Injectable({
  providedIn: 'root'
})
export class SkillService {

  private url = 'https://portfoliobknd.herokuapp.com/api/skill/';

  constructor(private http:HttpClient) { }

  public getSkill(): Observable<skill[]> {
    return this.http.get<skill[]>(this.url + 'bring');
  }

  public createSkill(skill:skill): Observable<skill[]> {
    return this.http.post<skill[]>(this.url + 'create', skill);
  }

  public deleteSkill(id:number): Observable<void> {
    return this.http.delete<void>(this.url + 'delete/' + id);
  }

  public editSkill(skill:skill): Observable<skill> {
    return this.http.put<skill>(this.url + 'edit', skill);
  }
}
