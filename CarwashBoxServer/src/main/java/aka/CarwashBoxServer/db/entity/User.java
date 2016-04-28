package aka.CarwashBoxServer.db.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Users")
public class User
{
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Integer id;

	@Column(name = "first_name", length = 45)
	private String firstName;

	@Column(name = "second_name", length = 45)
	private String secondName;

	@Column(name = "phone", length = 45, nullable = false)
	private String phone;

	@Column(name = "access_token", length = 45, nullable = false)
	private String accessToken;

	@Column(name="pass", length=45, nullable=false)
	private String pass;


	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private List<Car> cars;

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private List<Order> orders;



	//@formatter:off
	public User(){ cars = new LinkedList<Car>(); orders = new LinkedList<Order>();}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public String getSecondName() { return secondName; }
	public void setSecondName(String secondName) { this.secondName = secondName; }
	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
	public String getAccessToken() { return accessToken; }
	public void setAccessToken(String accessToken) { this.accessToken = accessToken; }
	public String getPass() { return this.pass; }
	public void setPass(String pass) { this.pass = pass; }
	public List<Car> getCars() { return cars; }
	public void setCars(List<Car> cars) { this.cars = cars; }
	public void addCar(Car car) { this.cars.add(car); }
	//@formatter:on

	public User( String firstName, String secondName, String phone, String accessToken )
	{
		this.firstName = firstName;
		this.secondName = secondName;
		this.phone = phone;
		this.accessToken = accessToken;
	}

}
