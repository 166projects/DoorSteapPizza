package com.mphasis.project.bo;

import java.util.List;

import com.mphasis.project.entities.Restaurants;

public interface RestaurantsBo {
                
                public void addRestaurants (Restaurants restaurants) throws Exception;
    public void updateRestaurants (Restaurants restaurants);
    public void deleteRestaurants(int rid);
    public Restaurants findRestaurantsById (int rid);
    public List<Restaurants> findRestaurantsByName (String rname);
    public List<Restaurants> getRestaurants();
 //   public List<Restaurants> restaurantsRatings (int ratings);
    public List<Restaurants> getRidByRname(String rname);  
}

