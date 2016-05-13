package aka.CarwashBoxServer.rest.response.components;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ServiceComponentResponse
{
	private Integer id;
	private String title;
	private String picture;
	private String shDiscript;
	private String lnDiscript;
	private Integer time;
	private Double cost;

	//@formatter:off
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public String getTitle() { return title; }
	public void setTitle(String title) {this.title = title; }
	public String getPicture() {return picture; }
	public void setPicture(String picture) {this.picture = picture; }
	public String getShDiscript() {return shDiscript; }
	public void setShDiscript(String shDiscript) { this.shDiscript = shDiscript; }
	public String getLnDiscript() { return lnDiscript; }
	public void setLnDiscript(String lnDiscript) { this.lnDiscript = lnDiscript; }
	public Integer getTime() { return time; }
	public void setTime(Integer time) { this.time = time; }
	public Double getCost() { return cost; }
	public void setCost(Double cost) { this.cost = cost; }
	//formatter:on

}
