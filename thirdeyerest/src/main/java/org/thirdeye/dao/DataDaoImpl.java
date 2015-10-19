package org.thirdeye.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.thirdeye.model.MeasuringPoints;

public class DataDaoImpl implements DataDao {  
	  
	 @Autowired  
	 SessionFactory sessionFactory;  
	  
	 Session session = null;  
	 Transaction tx = null;  
	  
	 @Override  
	 public List<MeasuringPoints> getEntityById(String eid) throws Exception {  
		  session = sessionFactory.openSession(); 
		  List <MeasuringPoints> mlist= session.createQuery("FROM MeasuringPoints M where M.mpEId='"+eid+"'").list();
		  return mlist; 
		    
		 }  
	 
	 @Override
	 public boolean addEntity(MeasuringPoints measuringpoints) throws Exception{
		 session = sessionFactory.openSession(); 
		 tx = session.beginTransaction();  
		  session.save(measuringpoints);  
		  tx.commit();  
		  session.close();
		  return false;
	 }
}