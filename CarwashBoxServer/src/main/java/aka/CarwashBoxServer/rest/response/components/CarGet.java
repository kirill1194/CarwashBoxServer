package aka.CarwashBoxServer.rest.response.components;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CarGet
{

	private String name;
	private Integer id;
	private Integer type;
	@XmlAttribute(name="type_name")
	private String typeName;
	private String number;

	//@formatter:off
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public Integer getType() { return type; }
	public void setType(Integer type) { this.type = type; }
	public String getTypeName() { return typeName; }
	public void setTypeName(String typeName) { this.typeName = typeName; }
	public String getNumber() { return number; }
	public void setNumber(String number) { this.number = number; }
	//@formatter:on
}
