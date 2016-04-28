package aka.CarwashBoxServer.db.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

public class Order
{
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Integer id;

	//	@ManyToOne
	//	@JoinColumn(name="user_id")
	//	private User user;
	//
	//	@Column(name="ids")
	//	private String services;
	//
	//	@Column(name="date")
	//	private Long date;
	//
	//	@ManyToOne
	//	@JoinColumn(name="car_id")
	//	private Car car;
	//
	//	@Column(name="comment")
	//	private String comment;
	//
	//	//@formatter:off
	//	public Order(){ }
	//	public User getUser() { return this.user; }
	//	public void setUser(User user) { this.user = user; }
	//	public String getServices() { return services; }
	//	public void setServices(String services) { this.services = services; }
	//	public Long getDate() { return date; }
	//	public void setDate(Long date) { this.date = date; }
	//	public Car getCar() { return car; }
	//	public void setCar(Car car) { this.car = car; }
	//	public String getComment() { return this.comment; }
	//	public void setComment(String comment) { this.comment = comment; }
	//	//@formatter:on
}
