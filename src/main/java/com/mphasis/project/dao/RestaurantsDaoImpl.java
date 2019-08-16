package com.mphasis.project.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.project.entities.FoodItems;
import com.mphasis.project.entities.Restaurants;

@Repository
@Transactional
public class RestaurantsDaoImpl implements RestaurantsDao {
                
                
                @Autowired
                SessionFactory sessionFactory;

                public void addRestaurants(Restaurants restaurants) {
                                try {
                                Session session=sessionFactory.openSession();
                                Transaction tr=session.beginTransaction();
                                
                                session.save(restaurants);
                                tr.commit();
                                }
                                catch(Exception e)
                                {
                                                e.printStackTrace();
                                }
                                
                }

                public void updateRestaurants(Restaurants restaurants) {
                                try {
                                Session session=sessionFactory.openSession();
                                Transaction tr=session.beginTransaction();
                                
                                session.update(restaurants);
                                tr.commit();
                                }
                                catch(Exception e)
                                {
                                                e.printStackTrace();
                                }
                                
                }

                public void deleteRestaurants(int rid) {
                                try {
                                Session session=sessionFactory.openSession();
                                Transaction tr=session.beginTransaction();
                                Restaurants s=(Restaurants) session.get(Restaurants.class, rid);
                                session.delete(s);
                                tr.commit();
                                }
                                catch(Exception e)
                                {
                                                e.printStackTrace();
                                }
                                
                }

                public Restaurants findRestaurantsById(int rid) {
                                Restaurants restaurants=null;
                                try {
                                
                                Session session=sessionFactory.openSession();
                                Transaction tr=session.beginTransaction();
                     restaurants=(Restaurants) session.get(Restaurants.class, rid);
                                tr.commit();
                                }
                                catch(Exception e)
                                {
                                                e.printStackTrace();
                                }
                                return restaurants;
                }

                public List<Restaurants> findRestaurantsByName(String rname) {
                             
                                
                                Session session=sessionFactory.openSession();
                                Transaction tr=session.beginTransaction();
                                 Criteria cr= session.createCriteria(Restaurants.class);
                                 cr.add(Restrictions.eq("rname", rname));
                                 List<Restaurants> restaurants=cr.list();
                                tr.commit();
                                
                                
                                return restaurants;
                }

                public List<Restaurants> getRestaurants() {
                                List<Restaurants> restaurants=null;
                                try {
                                Session session=sessionFactory.openSession();
                                Transaction tr=session.beginTransaction();
                                restaurants=session.createCriteria(Restaurants.class).list();
                                }
                                catch(Exception e)
                                {
                                  e.printStackTrace();
                                }
                                return restaurants;
                }

          /*      public List<Restaurants> restaurantsRatings(int ratings) {
                              
                                Session session=sessionFactory.openSession();
                                Transaction tr=session.beginTransaction();
                                List<Restaurants> restaurants= (List<Restaurants>) session.get(Restaurants.class, ratings);
                                tr.commit();
                             
                                return restaurants;
                }*/

				public List<Restaurants> getRidByRname(String rname) {
					 Session session=sessionFactory.openSession();
                     Transaction tr=session.beginTransaction();
                     SQLQuery query = session.createSQLQuery("select rid from Restaurants where rname=:rname");
                     query.setParameter("rname", rname);
                     tr.commit();
                     session.close();
             		return  (List<Restaurants>) query.uniqueResult();
				}
                



}
