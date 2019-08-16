package com.mphasis.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.project.bo.AdminBo;
import com.mphasis.project.bo.CustomerBo;
import com.mphasis.project.bo.DeliveryBoyBo;
import com.mphasis.project.bo.FoodItemsBo;
import com.mphasis.project.bo.LocationBo;
import com.mphasis.project.bo.OrderBo;
import com.mphasis.project.bo.RestaurantsBo;
import com.mphasis.project.bo.ToppingBo;
import com.mphasis.project.entities.Admin;
import com.mphasis.project.entities.Customer;
import com.mphasis.project.entities.DeliveryBoy;
import com.mphasis.project.entities.FoodItems;
import com.mphasis.project.entities.Location;
import com.mphasis.project.entities.Orders;
import com.mphasis.project.entities.Restaurants;
import com.mphasis.project.entities.Topping;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
//Admin
	
@Autowired
AdminBo adminBo;

@RequestMapping(value="/signupadmin", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
public void signUp(@RequestBody Admin admin) {
	adminBo.signUp(admin);
}


@RequestMapping(value="/loginadmin/{aid}/{pass}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public Admin login(@PathVariable("aid")String aid, @PathVariable("pass")String pass) {
	return adminBo.login(aid, pass);
}

@RequestMapping(value="/updateadmin/{aid}/{contactno}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
public void updateAdmin(@PathVariable("aid")String aid, @PathVariable("contactno")long contactno) {
	adminBo.updateAdmin(aid, contactno);
}

@RequestMapping(value="/changepasswordadmin/{aid}/{opass}/{npass}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
public void changePassword(@PathVariable("aid")String aid, @PathVariable("opass")String opass, @PathVariable("npass")String npass) {
	adminBo.changePassword(aid, opass, npass);	
}

@RequestMapping(value="/deleteadmin/{aid}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
public void deleteAdmin(@PathVariable("aid")String aid) {
	adminBo.deleteAdmin(aid);
}

//FoodItems

@Autowired
FoodItemsBo foodItemsBo;

@RequestMapping(value="/addfooditems", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
public void addFoodItems(@RequestBody FoodItems fooditems) {
	foodItemsBo.addFoodItems(fooditems);
}

@RequestMapping(value="/updatefooditems", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
public void updateFoodItems(@RequestBody FoodItems fooditems) {
	foodItemsBo.updateFoodItems(fooditems);
}

@RequestMapping(value="/deletefooditems/{fid}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
public void deleteFoodItems(@PathVariable("fid")int fid) {
	foodItemsBo.deleteFoodItems(fid);
}

@RequestMapping(value="/getfooditems", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<FoodItems> getAll(){
	return foodItemsBo.getFoodItems();
}

@RequestMapping(value="/getfooditemsbyid/{fid}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public FoodItems getFoodItemsById(@PathVariable("fid")int fid){
	return foodItemsBo.getFoodItemsById(fid);
}

@RequestMapping(value="/getfooditemsbyname/{fname}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<FoodItems> getFoodItemsByName(@PathVariable("fname")String fname){
	return foodItemsBo.getFoodItemsByName(fname);
}

@RequestMapping(value="/getfooditemscostbyid/{fid}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public int getFoodItemsCostById(@PathVariable("fid")int fid){
	return foodItemsBo.getFoodItemsCostById(fid);
}


//Restaurants

@Autowired
RestaurantsBo restaurantsBo;

@RequestMapping(value="/addrestaurants", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
public void addRestaurants(@RequestBody Restaurants restaurants) {
	try {
		restaurantsBo.addRestaurants(restaurants);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

@RequestMapping(value="/updaterestaurants", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
public void updateRestaurants(@RequestBody Restaurants restaurants) {
	restaurantsBo.updateRestaurants(restaurants);
}

@RequestMapping(value="/deleterestaurants/{rid}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
public void deleteRestaurants(@PathVariable("rid")int rid) {
	restaurantsBo.deleteRestaurants(rid);
}

@RequestMapping(value="/findrestaurantsbyid/{rid}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public Restaurants findRestaurantsById(@PathVariable("rid")int rid){
	return restaurantsBo.findRestaurantsById(rid);
}

@RequestMapping(value="/findrestaurantsbyname/{rname}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<Restaurants> findRestaurantsByName(@PathVariable("rname")String rname){
	return restaurantsBo.findRestaurantsByName(rname);
}

@RequestMapping(value="/getrestaurants", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<Restaurants> getRestaurants(){
	return restaurantsBo.getRestaurants();
}

/*@RequestMapping(value="/restaurantsratings/{ratings}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<Restaurants> restaurantsRatings(@PathVariable("ratings")int ratings){
	return restaurantsBo.restaurantsRatings(ratings);
}*/

//Location

@Autowired
LocationBo locationBo;

@RequestMapping(value="/addlocation", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
public void addLocation(@RequestBody Location location) {
	locationBo.addLocation(location);
}

@RequestMapping(value="/deletelocation/{lid}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
public void deleteLocation(@PathVariable("lid")int lid) {
	locationBo.deleteLocation(lid);
}

@RequestMapping(value="/findlocationbyid/{lid}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public Location findLocationById(@PathVariable("lid")int lid){
	return locationBo.findLocationById(lid);
}

@RequestMapping(value="/findlocationbyname/{lname}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<Location> findLocationByName(@PathVariable("lname")String lname){
	return locationBo.findLocationByName(lname);
}

@RequestMapping(value="/getlocation", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<Location> getLocation(){
	return locationBo.getLocation();
}

//OrderItems

/*@Autowired
OrderItemsBo orderItemsBo;

@RequestMapping(value="/getorderitemsbycid/{cid}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<OrderItems> getOrderItemsByCid(@PathVariable("cid")String cid){
	return orderItemsBo.getOrderItemsByCid(cid);
}*/

//Orders

@Autowired
OrderBo orderBo;

@RequestMapping(value="/updatestatusbyidadmin/{oid}/{status}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
public void updateStatusById(@PathVariable("oid")int oid, @PathVariable("status")String status) {
	orderBo.updateStatusById(oid,status);
}

@RequestMapping(value="/getallorders", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<Orders> getAllOrders(){
	return orderBo.getAllOrders();
}


//Toppings

@Autowired
ToppingBo toppingBo;

@RequestMapping(value="/addtoppings", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
public void addToppings(@RequestBody Topping toppings) {
	toppingBo.addToppings(toppings);
}

//DeliveryBoy

@Autowired
DeliveryBoyBo deliveryBoyBo;

@RequestMapping(value="/getalldeliveryboys", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<DeliveryBoy> getAllDeliveryBoys(){
	return deliveryBoyBo.getAll();
}

//Customer

@Autowired
CustomerBo customerBo;

@RequestMapping(value="/getallcustomers", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<Customer> getAllCustomers(){
	return customerBo.getAll();
}


}
