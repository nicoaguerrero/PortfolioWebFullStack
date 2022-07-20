import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JwtDto } from '../model/jwt-dto.model';
import { user } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  authURL = 'https://portfoliobknd.herokuapp.com/api/';

  constructor(private httpClient:HttpClient) { }

  public login(user:user): Observable<JwtDto>{
    return this.httpClient.post<JwtDto>(this.authURL + 'login', user);
  }
}
