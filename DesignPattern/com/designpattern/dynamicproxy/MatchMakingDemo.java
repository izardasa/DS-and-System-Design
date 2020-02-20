package com.designpattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MatchMakingDemo {

	public static void main(String[] args) {
		MatchMakingDemo demo = new MatchMakingDemo();

		demo.drive();

	}

	private void drive() {
		PersonBean person = getPersonBeanFromDB();

		System.out.println("For Owner Proxy");
		PersonBean ownerProxy = getOwnerProxy(person);
		System.out.println(ownerProxy.getName());
		ownerProxy.setAge(29);
		System.out.println(ownerProxy.getAge());
		try {
			ownerProxy.setHotOrNot(4);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println(ownerProxy.getHotOrNot());

		System.out.println("For nonowner proxy");
		PersonBean nonOwnerProxy = getNonOwnerProxy(person);
		System.out.println(nonOwnerProxy.getName());
		try {
			nonOwnerProxy.setName("Arjun");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println(nonOwnerProxy.getName());
		nonOwnerProxy.setHotOrNot(5);
		System.out.println(nonOwnerProxy.getHotOrNot());

	}

	PersonBean getOwnerProxy(PersonBean person) {
		PersonBean newProxyInstance = (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
				new Class[] { PersonBean.class }, new OwnerInvoicationHandler(person));

		return newProxyInstance;
	}

	PersonBean getNonOwnerProxy(PersonBean person) {
		PersonBean newProxyInstance = (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
				new Class[] { PersonBean.class }, new NonOwnerInvoicationHandler(person));

		return newProxyInstance;
	}

	static PersonBean getPersonBeanFromDB() {
		PersonBeanImpl personBean = new PersonBeanImpl();
		personBean.setAge(24);
		personBean.setCity("Raigarh");
		personBean.setName("Sanjay");
		personBean.setHotOrNot(5);
		return personBean;
	}
}
