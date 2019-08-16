package com.mphasis.project.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.mphasis.project.dao.LocationDao;
import com.mphasis.project.entities.Location;

@Service
public class LocationBoImpl implements LocationBo{

                @Autowired
                LocationDao locationDao;
                
                
                public void addLocation(Location location) {
                                try {
                                locationDao.addLocation(location);
                                }
                                catch(Exception e)
                                {
                       
                                	e.printStackTrace();
                                }
                                
                }

                public void deleteLocation(int lid) {
                                try {
                                	locationDao.deleteLocation(lid);
                                }
                                catch(Exception e)
                                {
                                                e.printStackTrace();
                                }
                                
                }

                public Location findLocationById(int lid) {
                                Location c=null;
                                try {
                                c= locationDao.findLocationById(lid);
                                
                                }
                                catch(Exception e)
                                {
                                                e.printStackTrace();
                                }
                                return c;
                }

                public List<Location> findLocationByName(String lname) {
                                return locationDao.findLocationByName(lname);
                }

                public List<Location> getLocation() {
                                return locationDao.getLocation();
                }

}
