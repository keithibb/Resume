import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user.model';
import { Reimbursement } from '../../model/reimbursement.model'
import { AuthService } from '../../services/auth.service';

import { RouterModule, Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  user: User;
  reim: Reimbursement;
 
  private author: string;
  private amount: number;
  private description: string;
 
  private type: string;
  constructor(private authService: AuthService, private route: Router) { }
  

  ngOnInit() {
    this.authService.getCurrentUser()
    .subscribe(data => { this.authService.user = data;
    if (this.authService.user !== null) {
      this.user = this.authService.user;
      this.GetReimb();
     
    } });
  }

GetReimb(){
  this.authService.getReimb(this.authService.user.username)
  .subscribe(data => { this.reim = data;
  });

}

    createReimb(){   
 
        this.authService.addReimb(this.amount, this.description, this.type, this.author)
        this.route.navigate(['user']);
              }
      }
    