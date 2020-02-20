package com.designpattern.visitor;

import java.text.DecimalFormat;

public class TaxVisitor implements Visitor
{

    DecimalFormat df = new DecimalFormat("#.##");
    
    @Override
    public double visit( Liquor liquor )
    {
        return liquor.getPrice()*1.10;
    }

    @Override
    public double visit( Tabacco tabacco )
    {
        return tabacco.getPrice()*1.23;
        
    }

    @Override
    public double visit( Necessity necessity )
    {
        return necessity.getPrice()*1.42;
        
    }

}
