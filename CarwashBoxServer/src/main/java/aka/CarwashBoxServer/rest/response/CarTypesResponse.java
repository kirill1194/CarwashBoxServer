package aka.CarwashBoxServer.rest.response;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import aka.CarwashBoxServer.rest.response.components.CarTypesComponentResponse;

@XmlRootElement
public class CarTypesResponse extends BaseResponse
{
	private List<CarTypesComponentResponse> carTypes;

	//@formatter:off
	public CarTypesResponse() { carTypes = new LinkedList<CarTypesComponentResponse>(); }
	public void setCarTypes(List<CarTypesComponentResponse> carTypes) { this.carTypes = carTypes; }
	public List<CarTypesComponentResponse> getCarTypes() { return this.carTypes; }
	public void addCarType(CarTypesComponentResponse carType) { carTypes.add(carType); }
	public void addAllCarTypes(Collection<CarTypesComponentResponse> collection) { carTypes.addAll(collection); }
	//@formatter:on
}
