package PrototypeDesignPattern;

public class PrototypeDemo
{

    public static void main( String[] args )
    {

        Employee employee1 = new Employee( 1001, "Sanjay Izardar" );
        
        employee1.loadData();
        System.out.println( employee1 );
        
        Employee employee2=null;
        try
        {
            employee2 = (Employee)employee1.clone();
        }
        catch( CloneNotSupportedException e )
        {
            System.out.println( "Clone not supported"+e.getMessage() );
        }
        
        System.out.println( "---------------------------" );
        System.out.println( "After prototyping employee" );
        System.out.println( "---------------------------" );
        System.out.println( employee2 );
    }

}
