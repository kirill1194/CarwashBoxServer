package aka.CarwashBoxServer.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Services")
public class Service
{
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Integer id;

	@Column(name="title", length=100, nullable=false)
	private String title;

	@Column(name="picture")
	private String picture;

	@Column(name="short_discription")
	private String shDiscription;

	@Column(name="long_discription")
	private String lnDiscription;

	@Column(name="cost", nullable=false)
	private Double cost;


	//@formatter:off
	public Service(){ }

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getPicture() { return picture; }
	public void setPicture(String picture) { this.picture = picture; }
	public String getShDiscription() { return shDiscription; }
	public void setShDiscription(String shDiscription) { this.shDiscription = shDiscription; }
	public String getLnDiscription() { return lnDiscription; }
	public void setLnDiscription(String lnDiscription) { this.lnDiscription = lnDiscription; }
	public Double getCost() { return cost;}
	public void setCost(Double cost) { this.cost = cost; }
	//@formatter:on
}
