package aka.CarwashBoxServer.rest.request;

import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

import aka.CarwashBoxServer.rest.validation.NotNullEmptyPar;
import aka.CarwashBoxServer.rest.validation.NotNullPar;

@XmlRootElement
public class CarAdd
{

	private static final String abc ="ETUOPAHKXCBM" +
			"etuopahkxcbm" +
			"ЕТУОРАНКХСВМ" +
			"етуоранкхсвм";
	public static final String pattern = "^["+abc+"]{1}[0-9]{3}["+abc+"]{2}$";
	//@formatter:on

	@NotNullEmptyPar(label = "name")
	private String name;

	@NotNullPar(label = "type")
	private Integer type;

	@NotNullEmptyPar(label = "number")
	@Pattern(regexp = pattern, message = "{number.valid}")
	private String number;

	//@formatter:off
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public Integer getType() { return type; }
	public void setType(Integer type) { this.type = type; }
	public String getNumber() { return number; }
	public void setNumber(String number) { this.number = number; }
	//@formatter:on

}
