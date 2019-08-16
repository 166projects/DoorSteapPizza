import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/customer';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from '../customer.service';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  cname:String;
  password :String;
  address :String;
  contact_number :number;
  customer= new Customer();
  returnurl :String;
  

  ngOnInit(){
    //throw new Error("Method not implemented.");
  }
  // customer: Customer;
  
  constructor(
    private customerservice: CustomerService,
    private route: ActivatedRoute, 
    private router: Router,
    ) {
     }
     signupcustomer(): void{
this.customer = {
  'cid' : "s001",
'cname' : this.customer.cname,
'password' : this.customer.password,
'address' : this.customer.address,
'contact_number' : this.customer.contact_number,

};
     // console.log("signup");
       this.customerservice.signupcustomer(this.customer).subscribe((data: any) => {
        this.customer = data;
        this.router.navigateByUrl('login');
      },(err: any)=>{
        console.log(err);
      });

    }
    

}
