package com.designpattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NonOwnerInvoicationHandler implements InvocationHandler {

	PersonBean person;

	public NonOwnerInvoicationHandler(PersonBean person) {
		this.person = person;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try {
			if (method.getName().startsWith("get"))
				return method.invoke(person, args);
			else if (method.getName().equalsIgnoreCase("setHotOrNot"))
				return method.invoke(person, args);
			else if (method.getName().startsWith("set"))
				throw new IllegalAccessException("Unauthorized access.");
		} catch (Exception ex) {
			System.err.print(ex.getMessage());
		}
		return null;
	}

}
