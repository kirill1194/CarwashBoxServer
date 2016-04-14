package aka.CarwashBoxServer.service;

import java.util.LinkedList;
import java.util.List;

import aka.CarwashBoxServer.rest.response.entity.ServiceEntity;

public class ServicesService
{
	public List<ServiceEntity> getServices()
	{
		ServiceEntity s1 = new ServiceEntity();
		s1.setCost(200.0);
		s1.setId("1");
		s1.setLnDiscript("Трали Вали пол апреля проебали");
		s1.setPicture("http://img1.joyreactor.cc/pics/post/full/anon-Картинка-2191131.jpeg");
		s1.setShDiscript("Траливали");
		s1.setTime("20");
		s1.setTitle("Название");

		ServiceEntity s2 = new ServiceEntity();
		s2.setCost(100.0);
		s2.setId("2");
		s2.setLnDiscript("А не слишком ли много у нас описаний???");
		s2.setPicture("http://img1.joyreactor.cc/pics/post/full/anon-Картинка-2191131.jpeg");
		s2.setShDiscript("Короткое описание");
		s2.setTime("120");
		s2.setTitle("Название2");

		LinkedList<ServiceEntity> result = new LinkedList<ServiceEntity>();
		result.add(s1);
		result.add(s2);

		return result;
	}
}
