package aka.CarwashBoxServer.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Car")
public class Car
{
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Integer id;

	@Column(name="name", length=100)
	private String name;

	@Column(name="number")
	private String number;


	@ManyToOne()
	@JoinColumn(name="car_type_id")
	private CarType carType;

	//@formatter:off
	public Car(){ }

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getNumber() { return number; }
	public void setNumber(String number) { this.number = number; }
	public CarType getCarType() { return carType; }
	public void setCarType(CarType carType) { this.carType = carType; }
	//@formatter:on


}
