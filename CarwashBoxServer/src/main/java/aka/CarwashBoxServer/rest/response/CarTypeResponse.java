package aka.CarwashBoxServer.rest.response;

public class CarTypeResponse extends BaseResponse
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
