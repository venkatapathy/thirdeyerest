package org.thirdeye.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thirdeye.dao.DataDaoImpl;
import org.thirdeye.model.MeasuringPoints;
import org.thirdeye.model.Status;  
  

@Controller  
@RequestMapping("/measuringpoints")  

public class RestController {
	
	@Autowired  
	 DataDaoImpl dataDaoImpl=new DataDaoImpl();
	 /* Ger a single objct in Json form in Spring Rest Services */  
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET)  
	 public @ResponseBody  
	 List<MeasuringPoints> getEmployee(@PathVariable("id") String eid) {  
	  List<MeasuringPoints> measuringpoints = null;  
	  try {  
		  measuringpoints = dataDaoImpl.getEntityById(eid);  
	  
	  } catch (Exception e) {  
	   e.printStackTrace();  
	  }  
	  return measuringpoints;  
	 }
	 
	 @RequestMapping(value="/hello", method = RequestMethod.GET)
	 public @ResponseBody String getHello(){
		 return "[{\"mpId\":1,\"mpEId\":\"element\",\"mpName\":\"samplename\",\"mpType\":\"sampletype\"},{\"mpId\":1,\"mpEId\":\"element\",\"mpName\":\"samplename\",\"mpType\":\"sampletype\"}]";
	 }
	 
	 @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody  
	 Status addEmployee(@RequestBody MeasuringPoints measuringpoint) {  
		 try {  
			 	dataDaoImpl.addEntity(measuringpoint);  
			 	return new Status(1, "MeasuringPoint added Successfully !");  
		 } catch (Exception e) {  
	   // e.printStackTrace();  
			 e.printStackTrace(System.out);
			 return new Status(0, e.toString());
			 
		 }
	 }
}
