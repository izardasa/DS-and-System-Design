package com.designpattern.publisherobserver;

public interface Subject {
	void Attach(Observer o);

	void Detach(Observer o);

	void Notify();
}
