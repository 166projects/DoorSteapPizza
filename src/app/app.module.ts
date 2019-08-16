import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageComponent } from './homepage/homepage.component';
import { RestaurantsComponent } from './homepage/restaurants/restaurants.component';
import { Routes, RouterModule } from '@angular/router';
import { CustomerService } from './customer.service';
import { FoodItemsComponent } from './homepage/restaurants/food-items/food-items.component';
import { FoodcountComponent } from './homepage/restaurants/food-items/foodcount/foodcount.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './homepage/profile/profile.component';
import { OrderitemsComponent } from './homepage/restaurants/food-items/orderitems/orderitems.component';
import { SignupComponent } from './signup/signup.component';
//import { SignupComponent } from './signup/signup.component';





const appRoutes : Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'homepage', component: HomepageComponent},
  {path: 'homepage/getrestaurants', component: RestaurantsComponent},
  {path : 'getrestaurants/fooditems', component: FoodItemsComponent},
  {path : 'foodcount', component: FoodcountComponent},
  {path: 'homepage/profile', component: ProfileComponent},
  {path: 'homepage/login', component: LoginComponent},
  {path: 'getrestaurants/fooditems/orderitems', component: OrderitemsComponent}
  //{path: '', redirectTo: '/restaurants', pathMatch: 'full'}

];
@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    RestaurantsComponent,
    FoodItemsComponent,
  FoodcountComponent,
  LoginComponent,
 ProfileComponent,
 OrderitemsComponent,
 SignupComponent,
 
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [CustomerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
