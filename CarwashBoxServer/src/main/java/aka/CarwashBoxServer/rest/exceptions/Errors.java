package aka.CarwashBoxServer.rest.exceptions;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Errors
{
	public static final int PHONE_ALREADY_EXIST = 101;
	public static final int PHONE_NOT_EXIST = 102;
	public static final int PHONE_OR_PASS_IS_INCARRACT = 103;

	public static final int PASS_INCORRET = 201;

	public static final int CAR_TYPE_NOT_EXIST = 301;

	public static final int CAR_NOT_EXIST = 401;

	public static Map<Integer, String> map;
	static
	{
		Map<Integer, String> m = new TreeMap<Integer, String>();
		m.put(PHONE_ALREADY_EXIST, "Такой телефон уже зарегистрирован");
		m.put(PHONE_NOT_EXIST, "Пользователя с этим телефоном не существует");
		m.put(PHONE_OR_PASS_IS_INCARRACT, "Неверный пароль или телефон");
		m.put(PASS_INCORRET, "Неверный пароль");
		m.put(CAR_TYPE_NOT_EXIST, "Типа машины с таким id не существует");
		m.put(CAR_NOT_EXIST, "Машина с таким id  нет");

		map = Collections.unmodifiableMap(m);
	}

	public static String getMessage(int code)
	{
		return map.get(code);
	}
}
