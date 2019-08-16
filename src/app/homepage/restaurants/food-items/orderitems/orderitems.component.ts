import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/customer.service';
import { Orderitems } from 'src/app/orderitems';

@Component({
  selector: 'app-orderitems',
  templateUrl: './orderitems.component.html',
  styleUrls: ['./orderitems.component.css']
})
export class OrderitemsComponent implements OnInit {

  constructor(private customerservice:CustomerService) { }

  ngOnInit() {
   
  }
 
 
}
