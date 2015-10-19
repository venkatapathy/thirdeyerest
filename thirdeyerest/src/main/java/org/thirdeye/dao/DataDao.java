package org.thirdeye.dao;

import java.util.List; 

import org.thirdeye.model.MeasuringPoints;

public interface DataDao {

	public List<MeasuringPoints> getEntityById(String eid) throws Exception;
	public boolean addEntity(MeasuringPoints measuringpoints) throws Exception; 
}
