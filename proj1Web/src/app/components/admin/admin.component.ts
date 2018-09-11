import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user.model';
import { Reimbursement } from '../../model/reimbursement.model'
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  user: User;
  reim: Reimbursement[];
  
  private reimbbId: number;
  private resolver: string;
  private status: string;
  

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.authService.getCurrentUser().subscribe(data => {
      this.authService.user = data;
    if (this.authService.user !== null) {
      this.user = this.authService.user;
      this.getAllReimb();
    }
    });
  }

  getAllReimb(){
    this.authService.getAllReimb()
    .subscribe(data => {this.reim = data;
    });
  }
  updateReimb(){
    this.authService.updateReimb(this.reimbbId, this.resolver, this.status)

  }
}