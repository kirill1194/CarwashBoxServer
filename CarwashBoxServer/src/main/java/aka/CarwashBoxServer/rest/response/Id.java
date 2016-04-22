package aka.CarwashBoxServer.rest.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Id
{
	private Integer id;

	//@formatter:off
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	//@formatter:on

}
