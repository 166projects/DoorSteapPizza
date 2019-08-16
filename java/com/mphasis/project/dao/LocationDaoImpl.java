package com.mphasis.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.project.entities.Location;

@Repository

public class LocationDaoImpl implements LocationDao{

                @Autowired
                SessionFactory sessionFactory;
                
                
                public void addLocation(Location location) {
                                try {
                                Session session=sessionFactory.openSession();
                                Transaction tr=session.beginTransaction();
                                
                                session.save(location);
                                tr.commit();
                                }
                                catch(Exception e)
                                {
                                                e.printStackTrace();
                                }
                                                
                                
                }

                public void deleteLocation(int lid) {
                                try {
                                Session session=sessionFactory.openSession();
                                Transaction tr=session.beginTransaction();
                                Location l=(Location) session.get(Location.class, lid);
                                session.delete(l);
                                tr.commit();
                                }
                                catch(Exception e)
                                {
                                                e.printStackTrace();
                                }
                                                
                                
                }

                public Location findLocationById(int lid) {
                                Location s=null;
                                try {
                                Session session=sessionFactory.openSession();
                                Transaction tr=session.beginTransaction();
                                s=(Location) session.get(Location.class, lid);
                                tr.commit();
                                }
                                catch(Exception e)
                                {
                                                e.printStackTrace();
                                }
                                
                                return s;
                }

                public List<Location> findLocationByName(String lname) {
                               
                                Session session=sessionFactory.openSession();
                                Transaction tr=session.beginTransaction();
                                Criteria cr= session.createCriteria(Location.class);
                                cr.add(Restrictions.eq("lname", lname));
                                List<Location> locations=cr.list();
                                tr.commit();
                               
                                
                                return locations;
                }

                
                public List<Location> getLocation() {
                                Session session=sessionFactory.openSession();
                                Transaction tr=session.beginTransaction();
                                List<Location> location=session.createCriteria(Location.class).list();
                                return location;
                }

}
