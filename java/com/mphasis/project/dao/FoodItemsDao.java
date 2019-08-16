package com.mphasis.project.dao;

import java.util.List;

import com.mphasis.project.entities.FoodItems;

public interface FoodItemsDao {
	public void addFoodItems(FoodItems fooditems);
	public void updateFoodItems(FoodItems fooditems);
	public void deleteFoodItems(int fid);
	public List<FoodItems> getFoodItems();
	public FoodItems getFoodItemsById(int fid);
	public List<FoodItems> getFoodItemsByName(String fname);
	public int getFoodItemsCostById(int fid);
	public List<FoodItems> getFoodItemsByCategory(String category);
	public List<FoodItems> getFoodItemsByType(String type);
	public List<FoodItems> getFoodItemsByRid(int rid);
}
