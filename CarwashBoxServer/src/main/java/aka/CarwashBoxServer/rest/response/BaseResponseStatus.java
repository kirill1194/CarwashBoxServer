package aka.CarwashBoxServer.rest.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BaseResponseStatus
{
	private Integer code;
	private String message;

	public BaseResponseStatus()
	{
		code = 0;
		message = "";
	}

	//@formatter:off
	public Integer getCode() { return code; }
	public void setCode(Integer code) { this.code = code; }
	public String getMessage() { return message; }
	public void setMessage(String message) { this.message = message; }
	//@formatter:on

}