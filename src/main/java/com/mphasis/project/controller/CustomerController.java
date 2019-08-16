package com.mphasis.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mphasis.project.bo.CreditCardDetailsBo;
import com.mphasis.project.bo.CustomerBo;
import com.mphasis.project.bo.FoodItemsBo;
import com.mphasis.project.bo.LocationBo;
import com.mphasis.project.bo.OrderBo;
import com.mphasis.project.bo.OrderItemsBo;
import com.mphasis.project.bo.RestaurantsBo;
import com.mphasis.project.bo.ToppingBo;
import com.mphasis.project.entities.CreditCardDetails;
import com.mphasis.project.entities.Customer;
import com.mphasis.project.entities.FoodItems;
import com.mphasis.project.entities.Location;
import com.mphasis.project.entities.OrderItems;
import com.mphasis.project.entities.Orders;
import com.mphasis.project.entities.Restaurants;
import com.mphasis.project.entities.Topping;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	
//customer
	
	 @Autowired
	 CustomerBo customerBo;
	
	 
	 //@SuppressWarnings("unchecked")
	@RequestMapping(value="/customers",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	 public List<Customer> getAll(){
     	List<Customer> customers=customerBo.getAll();
     	
     	    return customers;
     }
	 
	 @RequestMapping(value="/signupcustomer", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
     public void signUp(@RequestBody Customer customer){
		 System.out.println(customer.getAddress());
     	customerBo.signUp(customer);
       
     }
	 
	 @RequestMapping(value="/logincustomer/{cid}/{pass}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	 public Customer login(@PathVariable("cid")String cid, @PathVariable("pass")String pass) throws Exception{
			 return customerBo.login(cid, pass);
		 
	 }
	 
	 @RequestMapping(value="/changepasswordcustomer/{cid}/{opass}/{npass}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
     public void changePassword(@PathVariable("cid")String cid, @PathVariable("opass")String opass, @PathVariable("npass")String npass) {
            customerBo.changePassword(cid, opass, npass);    
      }

	 
	 @RequestMapping(value="/editcustomer", method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
     public void updateCustomer(@RequestBody Customer customer) {
		 
		 customerBo.editCustomer(customer); 
		 
	}
	 
	 
	 @RequestMapping(value="/getcustomerbyid/{id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
     public Customer getCustomer(@PathVariable("id") String cid) {
		
   	     return customerBo.getById(cid);
         
	 }
	 
	 
//creditcarddetails
	 
	 @Autowired
	 CreditCardDetailsBo creditCardDetailsBo;
	 
	 
	 
	 @RequestMapping(value="/creditcards",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	 public List<CreditCardDetails> getAllCCDetails(){
     	List<CreditCardDetails> details=creditCardDetailsBo.getAllDetails();
     	
     	    return details;
     }
	 
	 
	 @RequestMapping(value="/addccd", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
     public void addDetails(@RequestBody CreditCardDetails ccdd){
     		
		 creditCardDetailsBo.insertCreditCardDetails(ccdd);
			
     }
	 
	 
	 @RequestMapping(value="/deleteccd/{card_no}", method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
     public void deleteCCDetails(@PathVariable("card_no") long card_no) {
		
		 creditCardDetailsBo.removeCreditCardDetails(card_no);
        
	     }
	 
//fooditems

@Autowired
FoodItemsBo foodItemsBo;

@RequestMapping(value="/getfooditems", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<FoodItems> getFoodItems(){
	return foodItemsBo.getFoodItems();
}
	
@RequestMapping(value="/getfooditemsbyname/{fname}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<FoodItems> getFoodItemsByName(@PathVariable("fname")String fname){
	return foodItemsBo.getFoodItemsByName(fname);
}

@RequestMapping(value="/getfooditemsbycategory/{category}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<FoodItems> getFoodItemsByCategory(@PathVariable("category")String category){
	return foodItemsBo.getFoodItemsByCategory(category);
}

@RequestMapping(value="/getfooditemsbytype/{type}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<FoodItems> getFoodItemsByType(@PathVariable("type")String type){
	return foodItemsBo.getFoodItemsByType(type);
}

@RequestMapping(value="/getfooditemsbyrid/{rid}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<FoodItems> getFoodItemsByRid(@PathVariable("rid")int rid){
	return foodItemsBo.getFoodItemsByRid(rid);
}

//location

@Autowired
LocationBo locationBo;

@RequestMapping(value="/findlocationbyname/{lname}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<Location> findLocationByName(@PathVariable("lname")String lname){
	return locationBo.findLocationByName(lname);
}

@RequestMapping(value="/getlocation", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<Location> getLocation(){
	return locationBo.getLocation();
}

//orders

@Autowired
OrderBo orderBo;

@RequestMapping(value="/insertorders", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
public void insertOrders(@RequestBody Orders orders) {
	double totalCost=orderBo.getTotalCost(orders.getOid());
	orders.setTotalCost(totalCost);
	orderBo.insertOrders(orders);
}

@RequestMapping(value="/getordersbyid/{oid}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public Orders getOrdersById(@PathVariable("oid")int oid){
	return orderBo.getOrdersById(oid);
}

//orderitems

@Autowired
OrderItemsBo orderItemsBo;

@RequestMapping(value="/insertorderitems", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
public void insertOrderItems(@RequestBody OrderItems orderItems) {
	FoodItems fi=orderItems.getFooditems();
	int fid=fi.getFid();
	double cost = orderItemsBo.getTotalPrice(fid);
	orderItems.setCost(cost);
	orderItemsBo.insertOrderItems(orderItems);
}

@RequestMapping(value="/updateorderitems", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
public void updateOrderItems(@RequestBody OrderItems orderItems) {
	orderItemsBo.updateOrderItems(orderItems);
}

@RequestMapping(value="/gettotalprice/{fid}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public double getTotalPrice(@PathVariable("fid")int fid){
	return orderItemsBo.getTotalPrice(fid);
}

@RequestMapping(value="/getallorderitems", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<OrderItems> getAllOrderItems(){
	return orderItemsBo.getAllOrderItems();
}

//restaurants`

@Autowired
RestaurantsBo restaurantsBo;

@RequestMapping(value="/getrestaurantsbyname/{rname}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<Restaurants> findRestaurantsByName(@PathVariable("rname")String rname){
	return restaurantsBo.findRestaurantsByName(rname);
}

@RequestMapping(value="/getrestaurants", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<Restaurants> getRestaurants(){
	return restaurantsBo.getRestaurants();
}

/*@RequestMapping(value="/restaurantsratings/{ratings}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<Restaurants> restaurantsRatings(@PathVariable("ratings")int ratings) throws Exception{
	return restaurantsBo.restaurantsRatings(ratings);
}*/


//topping

@Autowired
ToppingBo toppingBo;

@RequestMapping(value="/addtoppings", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
public void addToppings(@RequestBody Topping topping) {
	toppingBo.addToppings(topping);
}

@RequestMapping(value="/gettoppings", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<Topping> getToppings(){
	return toppingBo.getToppings();
}



}
