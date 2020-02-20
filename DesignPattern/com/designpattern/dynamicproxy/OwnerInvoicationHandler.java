package com.designpattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class OwnerInvoicationHandler implements InvocationHandler {

	PersonBean person;

	public OwnerInvoicationHandler(PersonBean person) {
		this.person = person;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try {
			if (method.getName().startsWith("get"))
				return method.invoke(person, args);
			else if (method.getName().equalsIgnoreCase("setHotOrNot"))
				throw new IllegalAccessException("Unauthorized access");
			else if (method.getName().startsWith("set"))
				return method.invoke(person, args);
		} catch (Exception ex) {
			System.err.print(ex.getMessage());
		}
		return null;
	}

}
