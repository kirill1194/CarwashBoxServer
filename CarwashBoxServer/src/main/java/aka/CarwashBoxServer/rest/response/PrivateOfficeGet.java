package aka.CarwashBoxServer.rest.response;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import aka.CarwashBoxServer.rest.response.components.CarGet;

@XmlRootElement
public class PrivateOfficeGet
{
	private String name;
	@XmlAttribute(name="second_name")
	private String secondName;
	private String phone;
	private List<CarGet> cars;

	public PrivateOfficeGet()
	{
		cars = new LinkedList<CarGet>();
	}


	//@formatter:off
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getSecondName() { return secondName; }
	public void setSecondName(String secondName) { this.secondName = secondName; }
	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
	public List<CarGet> getCars() { return cars; }
	public void setCars(List<CarGet> cars) { this.cars = cars; }
	//@formatter:on

	public void addCar(CarGet car)
	{
		cars.add(car);
	}

}
