package aka.CarwashBoxServer.rest.request;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import aka.CarwashBoxServer.rest.validation.NotNullEmptyPar;
import aka.CarwashBoxServer.rest.validation.NotNullPar;



@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Order
{
	@NotNullEmptyPar(label="ids")
	private List<String> ids;
	@NotNullPar(label="meet")
	private Long meet;

	private String comment;

	@NotNullEmptyPar(label="token")
	private String token;


	//@formatter:off
	public Order() {}
	public List<String> getIds() { return ids; }
	public void setIds(List<String> ids) { this.ids = ids; }
	public Long getMeet() { return meet; }
	public void setMeet(Long meet) { this.meet = meet; }
	public String getComment() { return comment; }
	public void setComment(String comment) { this.comment = comment; }
	@XmlElement(required=true)
	public String getToken() { return token; }
	@XmlElement(required=true)
	public void setToken(String token) { this.token = token; }
	//@formatter:on
}
