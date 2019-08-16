package com.mphasis.project.dao;

import java.util.List;

import com.mphasis.project.entities.Location;

public interface LocationDao {

                public void addLocation (Location location);
    public void deleteLocation(int lid);
    public Location findLocationById (int lid);
    public List<Location> findLocationByName (String lname);
    public List<Location> getLocation();
                
                
                
                
}
