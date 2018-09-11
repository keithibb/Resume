
import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { RouterModule, Router } from '@angular/router';
import { User } from '../../model/user.model';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private username: string;
  private password: string;
  user: User;



  constructor(private authService: AuthService, private route: Router) { }

  ngOnInit() {

  }

  login() {
  if (this.username == null || this.password == null) {
    alert('Please give me data');
  } else {
    this.authService.login(this.username, this.password)
    .subscribe(user => { this.authService.user = user;
    if (this.authService.user.userole == 'EMPLOYEE') {
      this.route.navigate(['user']);
    } else if (this.authService.user.userole == 'FINANCE MANAGER') {
      this.route.navigate(['admin']);
    } else {
      error =>{ alert('Please Try Again');
    }
    }
    });
    }
  }
}
