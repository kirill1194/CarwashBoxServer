package aka.CarwashBoxServer.rest.response.components;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ServiceEntity
{
	private String id;
	private String title;
	private String picture;
	private String shDiscript;
	private String lnDiscript;
	private String time;
	private double cost;

	//@formatter:off
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getTitle() { return title; }
	public void setTitle(String title) {this.title = title; }
	public String getPicture() {return picture; }
	public void setPicture(String picture) {this.picture = picture; }
	public String getShDiscript() {return shDiscript; }
	public void setShDiscript(String shDiscript) { this.shDiscript = shDiscript; }
	public String getLnDiscript() { return lnDiscript; }
	public void setLnDiscript(String lnDiscript) { this.lnDiscript = lnDiscript; }
	public String getTime() { return time; }
	public void setTime(String time) { this.time = time; }
	public double getCost() { return cost; }
	public void setCost(double cost) { this.cost = cost; }
	//formatter:on

}
