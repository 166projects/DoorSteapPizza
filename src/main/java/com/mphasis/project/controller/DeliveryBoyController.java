package com.mphasis.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.mphasis.project.bo.CustomerBo;
import com.mphasis.project.bo.DeliveryBoyBo;
import com.mphasis.project.bo.OrderBo;
import com.mphasis.project.bo.OrderItemsBo;

import com.mphasis.project.entities.Customer;
import com.mphasis.project.entities.DeliveryBoy;


import com.mphasis.project.entities.OrderItems;
import com.mphasis.project.entities.Orders;

@RestController
@RequestMapping("/deliveryboy")
public class DeliveryBoyController {

//DeliveryBoy
	
	@Autowired
	DeliveryBoyBo deliveryBoyBo;

	@RequestMapping(value="/signupdeliveryboy", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public void signUp(@RequestBody DeliveryBoy deliveryBoy) {
		
		deliveryBoyBo.signUp(deliveryBoy);
	}


	@RequestMapping(value="/logindeliveryboy/{did}/{dpass}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public DeliveryBoy login(@PathVariable("did")int did, @PathVariable("dpass")String dpass) {
		return deliveryBoyBo.login(did, dpass);
	}

	@RequestMapping(value="/updatedeliveryboy/{did}/{contactno}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	public void updateAdmin(@PathVariable("did")int did, @PathVariable("contactno")long contactno) {
		deliveryBoyBo.updateDeliveryBoy(did, contactno);
	}

	@RequestMapping(value="/changepassworddeliveryboy/{did}/{opass}/{npass}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	public void changePassword(@PathVariable("did")int did, @PathVariable("opass")String opass, @PathVariable("npass")String npass) {
		deliveryBoyBo.changePassword(did, opass, npass);	
	}

	@RequestMapping(value="/deletedeliveryboy/{did}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteAdmin(@PathVariable("did")int did) {
		deliveryBoyBo.deleteDeliveryBoy(did);
	}
	
//customer
	
@Autowired
CustomerBo customerBo;

	@RequestMapping(value="/getcustomerbyid/{cid}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer getById(@PathVariable("cid")String cid){
		return customerBo.getById(cid);
	}
	
//orders
	
@Autowired
OrderBo orderBo;

@RequestMapping(value="/getordersbyid/{oid}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public Orders getOrdersById(@PathVariable("oid")int oid){
	return orderBo.getOrdersById(oid);
}

@RequestMapping(value="/updatestatusbyid/{oid}/{status}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
public void updateStatusById(@PathVariable("oid")int oid, @PathVariable("status")String status) {
	orderBo.updateStatusById(oid,status);
}

//orderitems

@Autowired
OrderItemsBo orderItemsBo;

@RequestMapping(value="/getorderitemsbycid/{cid}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public List<OrderItems> getOrderItemsByCid(@PathVariable("cid")String cid){
	return orderItemsBo.getOrderItemsByCid(cid);
}
}
