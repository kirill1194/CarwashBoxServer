package aka.CarwashBoxServer.rest.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BaseResponse
{
	private BaseResponseStatus status;

	public BaseResponse()
	{
		status = new BaseResponseStatus();
	}
	public void setStatusCode(Integer code)
	{
		status.setCode(code);
	}
	public void setStatusMessage(String message)
	{
		status.setMessage(message);
	}
	//@formatter:off
	public BaseResponseStatus getStatus() { return status; }


	public void setStatus(BaseResponseStatus status) { this.status = status; }
	//@formatter:on

}
