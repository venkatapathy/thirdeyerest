package org.thirdeye.model;

import java.io.Serializable;  



import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;  

@Entity  
@Table(name = "measuringpoints") 
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MeasuringPoints implements Serializable	{
	 @Id  
	 @GeneratedValue(strategy = GenerationType.IDENTITY) 
	 @Column(name = "mpid", columnDefinition = "serial")  
	 private long mpId;  
	 
	 @Column(name = "mpeid")
	 private String mpEId;
	 @Column(name = "mpname")
	 private String mpName;
	 @Column(name = "mptype")
	 private String mpType;
	 
	 public long getMpId(){
		 return mpId;
	 }
	 
	 public void setMpId(long mpId){
		 this.mpId=mpId;
	 }
	 
	 public String getMpEId(){
		 return mpEId;
	 }
	 
	 public void setMpEId(String mpEId){
		 this.mpEId=mpEId;
	 }
	 
	 public String getMpName(){
		 return mpName;
	 }
	 
	 public void setMpName(String mpName){
		 this.mpName=mpName;
	 }
	 
	 public String getMpType(){
		 return mpType;
	 }
	 
	 public void setMpType(String mpType){
		 this.mpType=mpType;
	 }
	 
}
