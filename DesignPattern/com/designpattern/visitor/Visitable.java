package com.designpattern.visitor;

public interface Visitable
{
    double accept(Visitor visitor);
}
