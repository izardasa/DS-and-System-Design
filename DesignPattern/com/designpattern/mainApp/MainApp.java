package com.designpattern.mainApp;

import com.designpattern.publisherobserver.Mail;
import com.designpattern.publisherobserver.Person;
import com.designpattern.publisherobserver.PostOffice;

public class MainApp {

	public static void main(String[] args) {
		PostOffice postOffice= new PostOffice();
			Person chris= new Person("Chris");
			Person john= new Person("John");
			Mail m= new Mail("Chris","Mail 4 u","You've got a secret lover.");
			postOffice.Attach(chris);
			postOffice.Attach(john);
			postOffice.addMail(m);

	}

}
