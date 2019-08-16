package com.mphasis.project.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.mphasis.project.dao.RestaurantsDao;
import com.mphasis.project.entities.Restaurants;
@Service
public class RestaurantsBoImpl implements RestaurantsBo{
                
                @Autowired
                RestaurantsDao restaurantDao;

                public void addRestaurants(Restaurants restaurants) throws Exception {
                                
                                try {
                                if(restaurants.getRname().matches("[a-zA-Z]{5,}"))
                                	restaurantDao.addRestaurants(restaurants);
                                                else
                                                                throw new Exception("invalid pattern"); 
                                }
                                catch(Exception e)
                                {
                                                e.printStackTrace();
                    
                                }
                                                
                                
                }

                public void updateRestaurants(Restaurants restaurants) {
                	restaurantDao.updateRestaurants(restaurants);
                }

                public void deleteRestaurants(int rid) {
                	restaurantDao.deleteRestaurants(rid);
                                
                }

                public Restaurants findRestaurantsById(int rid) {
                         return restaurantDao.findRestaurantsById(rid);
                }

                public List<Restaurants> findRestaurantsByName(String rname) {
                
                                return restaurantDao.findRestaurantsByName(rname);
                }

                public List<Restaurants> getRestaurants() {
                                return restaurantDao.getRestaurants();
                }

             /*   public List<Restaurants> restaurantsRatings(int ratings){
                                
                              return  restaurantDao.restaurantsRatings(ratings);
                                
                              
                }*/

				public List<Restaurants> getRidByRname(String rname) {
					return restaurantDao.getRidByRname(rname);
				}

}
