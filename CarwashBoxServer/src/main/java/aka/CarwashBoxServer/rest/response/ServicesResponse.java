package aka.CarwashBoxServer.rest.response;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import aka.CarwashBoxServer.rest.response.components.ServiceComponentResponse;

public class ServicesResponse extends BaseResponse
{
	public List<ServiceComponentResponse> services;

	//@formatter:off
	public ServicesResponse() { services = new LinkedList<ServiceComponentResponse>(); }
	public List<ServiceComponentResponse> getServices() { return this.services; }
	public void setServices(List<ServiceComponentResponse> services) { this.services = services; }
	public void addService(ServiceComponentResponse service) { this.services.add(service); }
	public void addAllServices(Collection<ServiceComponentResponse> collection) { this.services.addAll(collection); }

}
