import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { person } from 'src/app/model/person.model';

@Injectable({
  providedIn: 'root'
})
export class PersonService {
  url = 'http://localhost:8080/person/';

  constructor(private http: HttpClient) { }

  public getPerson(): Observable<person> {
    return this.http.get<person>(this.url + 'bring/profile');
  }
}
