package aka.CarwashBoxServer.rest.response.components;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CarType
{
	private String type;
	private Integer id;

	//@formatter:off
	public String getType() { return type; }
	public void setType(String type) { this.type = type; }
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	//@formatter:on

}
