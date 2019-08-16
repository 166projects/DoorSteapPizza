import { Component, OnInit } from '@angular/core';
import { Restaurants } from 'src/app/restaurants';
import { CustomerService } from 'src/app/customer.service';
import { FoodItems } from 'src/app/food-items';
import { Router, RouterModule,ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-restaurants',
  templateUrl: './restaurants.component.html',
  styleUrls: ['./restaurants.component.css']
})
export class RestaurantsComponent implements OnInit {
  ngOnInit() {
    this.getrestaurants();
    }

  constructor(private customerservice:CustomerService, private route : Router, private router : ActivatedRoute){}
  restaurants: Restaurants[];
  fooditems: FoodItems[];

  getrestaurants(): any {
  return this.customerservice.getRestaurants().subscribe((data: any) => {
  this.restaurants = data;console.log(this.restaurants)});
  }
  
  getfooditems(): any {
    this.route.navigateByUrl("/getrestaurants/fooditems");
    }
  
  

}
