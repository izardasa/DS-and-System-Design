import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.*;
import com.google.gson.*;

public class MovieTitles
{

    public static void main( String[] args ) throws IOException
    {
        Scanner s = new Scanner( System.in );
        String substr = s.next();

        String[] movies = getMovieTitles( substr );

        for( String movie : movies )
            System.out.println( movie );

    }

    static String[] getMovieTitles( String substr )
    {
        String query = "Title=" + substr;
        List<Movie> movies = new ArrayList<Movie>();

        try
        {
            MovieResponse movieHeader = sendGET( query );
            int totalPages = movieHeader.getTotal_pages();
            for( int i = 1; i <= totalPages; i++ )
            {
                query = "Title=" + substr + "&page=" + i;
                MovieResponse movieResponse = sendGET( query );
                movies.addAll( movieResponse.getData() );
            }
        }
        catch( Exception ex )
        {
            System.out.println( ex.getMessage() );
        }

        List<String> movieTitle = new ArrayList<String>();

        for( Movie m : movies )
        {
            movieTitle.add( m.getTitle() );
        }

        Collections.sort( movieTitle );
        String[] movienames = movieTitle.toArray( new String[ movieTitle.size() ] );
        return movienames;
    }

    private static MovieResponse sendGET( String query ) throws IOException
    {
        URL obj = new URL( "https://jsonmock.hackerrank.com/api/movies/search/?" + query );
        HttpURLConnection con = (HttpURLConnection)obj.openConnection();
        con.setRequestMethod( "GET" );
        int responseCode = con.getResponseCode();
        MovieResponse res = null;
        if( responseCode == HttpURLConnection.HTTP_OK )
        { // success
            BufferedReader in = new BufferedReader( new InputStreamReader( con.getInputStream() ) );
            String inputLine;
            StringBuffer response = new StringBuffer();

            while( ( inputLine = in.readLine() ) != null )
            {
                response.append( inputLine );
            }
            in.close();

            Gson gson = new Gson();
            res = gson.fromJson( response.toString(), MovieResponse.class );

            // print result
        }
        else
        {
            System.out.println( "GET request not worked" );
        }

        return res;

    }

}

class MovieResponse
{
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<Movie> data;

    public MovieResponse( int page, int per_page, int total, int total_pages, List<Movie> data )
    {
        super();
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
    }

    public MovieResponse()
    {
        super();
    }

    public int getPage()
    {
        return page;
    }

    public void setPage( int page )
    {
        this.page = page;
    }

    public int getPer_page()
    {
        return per_page;
    }

    public void setPer_page( int per_page )
    {
        this.per_page = per_page;
    }

    public int getTotal()
    {
        return total;
    }

    public void setTotal( int total )
    {
        this.total = total;
    }

    public int getTotal_pages()
    {
        return total_pages;
    }

    public void setTotal_pages( int total_pages )
    {
        this.total_pages = total_pages;
    }

    public List<Movie> getData()
    {
        return data;
    }

    public void setData( List<Movie> data )
    {
        this.data = data;
    }

}

class Movie
{
    private String Title;
    private String Year;
    private String imdbID;

    public String getTitle()
    {
        return Title;
    }

    public void setTitle( String title )
    {
        Title = title;
    }

    public String getYear()
    {
        return Year;
    }

    public void setYear( String year )
    {
        Year = year;
    }

    public Movie()
    {
        super();
    }

    public String getImdbID()
    {
        return imdbID;
    }

    public Movie( String title, String year, String imdbID )
    {
        super();
        Title = title;
        Year = year;
        this.imdbID = imdbID;
    }

    public void setImdbID( String imdbID )
    {
        this.imdbID = imdbID;
    }

}