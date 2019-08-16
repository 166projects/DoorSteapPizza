
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Customer } from 'src/app/customer';
import { CustomerService } from 'src/app/customer.service';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  // customerId: string;
cId:string;
  currentUser: Customer;
  customerList: Customer;

  ngOnInit() {
    this.getcustomerbyid(this.cId);
  }
  constructor(
    private customerservice: CustomerService,
    private route: Router, private router: ActivatedRoute
  ) {
    this.currentUser = this.customerservice.currentUserValue;
    this.cId = this.currentUser.cid;
  }
  getcustomerbyid(cId: string): any {
    console.log(this.currentUser);
    return this.customerservice.getCustomerbyid(cId).subscribe((data: any) => {
      this.customerList = data;
      console.log(this.customerList);
    });

  }



}
