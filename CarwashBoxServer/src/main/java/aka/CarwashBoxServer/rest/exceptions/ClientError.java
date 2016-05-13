package aka.CarwashBoxServer.rest.exceptions;

public class ClientError extends RuntimeException
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int code;

	public ClientError(int code)
	{
		this.code = code;
	}

	//@formatter:off
	public int getCode() { return code; }
	public void setCode(int code) { this.code = code; }
	//@formatter:on

}
