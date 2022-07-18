import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { user } from 'src/app/model/user.model';
import { AuthService } from 'src/app/service/auth.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  isLogged = false;
  isLogginFail = false;
  user!: user;
  email!: string;
  password!: string;
  errorMessage!: string;

  constructor(private tokenService: TokenService, private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    if(this.tokenService.getToken()){
      this.isLogged = true;
      this.isLogginFail = false;
    }
  }

  onLogin():void{
    this.user = new user(this.email, this.password);
    this.authService.login(this.user).subscribe({
      next: (data) => {
        this.isLogged = true;
        this.isLogginFail = false;
        this.tokenService.setToken(data.accessToken);
        this.tokenService.setEmail(data.email);
        this.router.navigate(['']);
      },
      error: (error) => {
        this.isLogged = false;
        this.isLogginFail = true;
        this.errorMessage = error.message;
        console.log(this.errorMessage);
      }
    });
  }

}
