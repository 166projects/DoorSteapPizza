import { Component, OnInit } from '@angular/core';

import { first } from 'rxjs/operators';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { identifierModuleUrl } from '@angular/compiler';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';
@Component({
  selector: 'app-login-component',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  // model: any = {};
  cid:string;
  pass :string;
  // memberArray : Array<Member>
  member: Customer;
  returnUrl: string;
  //member : Member;
  isLoadingResults = true;
  // email:String;
  // password:String;
  ngOnInit() {
  }
  constructor(
    private customerservice: CustomerService, 
    private route: ActivatedRoute, 
    private router: Router
  ) {
   }
   logincustomer(): any{
     this.customerservice.logincustomer( this.cid, this.pass ).subscribe((data: any) => {
      this.member = data;

      //console.log(this.member);
      this.isLoadingResults = false;
      this.router.navigateByUrl('/homepage');
      // if(this.pass===this.member.password){
      //   this.router.navigateByUrl('http://localhost:8089/PizzaOrderingSystem/customer/logincustomer');
      // }
    });
console.log();
  }


}
