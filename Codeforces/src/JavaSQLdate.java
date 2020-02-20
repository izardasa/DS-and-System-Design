import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class JavaSQLdate
{

    public static void main( String[] args )
    {
        
    
    try
    {
        String str = "12/5/2069 11:37:04 AM";
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy hh:mm:ss aa");
        java.util.Date date = sdf.parse( str );
        Date sqlDate = new Date(date.getDate());
        System.out.println( sqlDate );
    }
    catch( Exception e )
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
       
        
    }
}
