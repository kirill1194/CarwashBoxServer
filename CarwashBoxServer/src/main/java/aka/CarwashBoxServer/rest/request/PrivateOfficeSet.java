package aka.CarwashBoxServer.rest.request;

import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import aka.CarwashBoxServer.rest.validation.NotNullEmptyPar;

@XmlRootElement
public class PrivateOfficeSet
{

	@NotNullEmptyPar(label = "name")
	private String name;
	@XmlAttribute(name="second_name")
	private String secondName;
	@NotNullEmptyPar(label = "phone")
	@Pattern(regexp = "^[0-9]{11}$", message = "{phone.valid}")
	private String phone;

	//@formatter:off
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getSecondName() { return secondName; }
	public void setSecondName(String secondName) { this.secondName = secondName; }
	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
	//@formatter:on
}
