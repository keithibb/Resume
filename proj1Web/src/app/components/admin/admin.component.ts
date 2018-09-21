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
  // private resolver: string;
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

  onSelect(reimbbId: number){
    this.reimbbId = reimbbId;
    console.log(reimbbId)
  }

Approve(){
  this.status = "APPROVED";
  if (this.reimbbId === undefined) {
    alert('Please select a row');
  } else { this.authService.updateReimb(this.reimbbId, this.authService.user.username, this.status)
      .subscribe(data => {
        this.getAllReimb();
    });
  }
}

Deny() {
  this.status = "DENIED";
  if (this.reimbbId === undefined) {
    alert('Please select a row');
  } else { this.authService.updateReimb(this.reimbbId, this.authService.user.username, this.status)
      .subscribe(data => {
        this.getAllReimb();
    });
  }
}
}