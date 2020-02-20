package com.designpattern.visitor;

public interface Visitor
{
    double visit(Liquor liquor);
    double visit(Tabacco tabacco);
    double visit(Necessity necessity);
}
