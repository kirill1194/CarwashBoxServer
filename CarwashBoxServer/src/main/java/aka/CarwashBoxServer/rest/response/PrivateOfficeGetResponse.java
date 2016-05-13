package aka.CarwashBoxServer.rest.response;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import aka.CarwashBoxServer.rest.response.components.CarGetComponentResponse;

@XmlRootElement
public class PrivateOfficeGetResponse extends BaseResponse
{
	private String name;
	@XmlAttribute(name="second_name")
	private String secondName;
	private String phone;
	private List<CarGetComponentResponse> cars;

	public PrivateOfficeGetResponse()
	{
		cars = new LinkedList<CarGetComponentResponse>();
	}


	//@formatter:off
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getSecondName() { return secondName; }
	public void setSecondName(String secondName) { this.secondName = secondName; }
	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
	public List<CarGetComponentResponse> getCars() { return cars; }
	public void setCars(List<CarGetComponentResponse> cars) { this.cars = cars; }
	//@formatter:on

	public void addCar(CarGetComponentResponse car)
	{
		cars.add(car);
	}

}
