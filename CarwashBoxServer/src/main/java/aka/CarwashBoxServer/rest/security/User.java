package aka.CarwashBoxServer.rest.security;

public class User
{
	private String phone;
	private String pass;
	private Integer id;

	//@formatter:off
	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
	public String getPass() { return pass; }
	public void setPass(String pass) { this.pass = pass; }
	public Integer getId() { return this.id; }
	public void setId(Integer id) { this.id = id; }
	//@formatter:on

}
