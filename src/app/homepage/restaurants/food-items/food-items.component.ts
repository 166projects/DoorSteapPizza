import { Component, OnInit } from '@angular/core';
import { FoodItems } from 'src/app/food-items';
import { CustomerService } from 'src/app/customer.service';
import { Restaurants } from 'src/app/restaurants';

@Component({
  selector: 'app-food-items',
  templateUrl: './food-items.component.html',
  styleUrls: ['./food-items.component.css']
})
export class FoodItemsComponent implements OnInit {
  ngOnInit() {
  this.getFoodItem();
  }
  restaurants: Restaurants[];
  fooditems: FoodItems[];

  constructor(private customerservice:CustomerService) {}

  getFoodItem(){
    return this.customerservice.getFoodItems().subscribe((data: any) => {
      this.fooditems = data;
      console.log(this.fooditems)});
   
   }

   
   selectedFoodItemsCountRadioButton: string = 'All';
   getTotalCount(): number 
   {
     return this.fooditems.length;
   }
   getTotalNonVegCount(): number 
   {
     return this.fooditems.filter(s=>s.category === 'NonVeg').length;
   }
   getTotalVegCount(): number 
   {
     return this.fooditems.filter(s=>s.category === 'Veg').length;
   }
   onFoodItemsCountRadioButtonChange(selectedRadioButtonValue: string): void
   {
   this.selectedFoodItemsCountRadioButton = selectedRadioButtonValue;
   }
}
