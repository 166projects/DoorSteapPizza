package com.mphasis.project.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.project.dao.FoodItemsDao;
import com.mphasis.project.entities.FoodItems;
@Service
public class FoodItemsBoImpl implements FoodItemsBo {
@Autowired
FoodItemsDao foodItemsDao;
	public void addFoodItems(FoodItems fooditems) {
		foodItemsDao.addFoodItems(fooditems);
		
	}

	public void updateFoodItems(FoodItems fooditems) {
		foodItemsDao.updateFoodItems(fooditems);
		
	}

	public void deleteFoodItems(int fid) {
		foodItemsDao.deleteFoodItems(fid);
		
	}
	

	public List<FoodItems> getFoodItems() {
		return foodItemsDao.getFoodItems();
	}

	public FoodItems getFoodItemsById(int fid) {
		return foodItemsDao.getFoodItemsById(fid);
	}

	public List<FoodItems> getFoodItemsByName(String fname) {
		return foodItemsDao.getFoodItemsByName(fname);
	}

	public int getFoodItemsCostById(int fid) {
		return foodItemsDao.getFoodItemsCostById(fid);
	}

	public List<FoodItems> getFoodItemsByCategory(String category) {
		return foodItemsDao.getFoodItemsByCategory(category);
		
	}

	public List<FoodItems> getFoodItemsByType(String type) {
		return foodItemsDao.getFoodItemsByType(type);
	}

	public List<FoodItems> getFoodItemsByRid(int rid) {
		return foodItemsDao.getFoodItemsByRid(rid);
	}

}
