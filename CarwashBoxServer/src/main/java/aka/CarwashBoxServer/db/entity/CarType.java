package aka.CarwashBoxServer.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Car_type")
public class CarType
{
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Integer id;

	@Column(name = "type", length = 100)
	private String type;

	//@formatter:off
	public CarType(){ }

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public String getType() { return type; }
	public void setType(String type) { this.type = type; }
	//@formatter:on

}
