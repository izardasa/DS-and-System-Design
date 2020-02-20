package com.sanfotech.stringsearch;

public class PatternMatcher
{

    public static String[] getPatternString( String word, String pattern )
    {
        int wL = word.length();
        int pL = pattern.length();
        if( wL < pL )
            return new String[]{ null, null };

        String newPattern = getNewPattern( pattern );
        boolean isPatternChanged = pattern.charAt( 0 ) != newPattern.charAt( 0 );
        Integer[] countXY = new Integer[  ] {0,0};
        int yPosition = getCountXYAndYPosition( newPattern, countXY );

        
        String[] xy = new String[ 2 ];
        String x;
        String y;
        for( int i = 1; i < wL; i++ )
        {
            if( yPosition != -1 )
            {
                int xLength = 0;
                double yLength = 0;
                xLength = i;
                yLength = (double)( wL - xLength * countXY[0] ) / (double)( countXY[1] );
                if( yLength <= 0 || yLength % 1 != 0 )
                    continue;
                else
                {
                    x = word.substring( 0, xLength );
                    y = word.substring( yPosition*xLength, yPosition*xLength + (int)yLength );
                    String potentialMatch = buildStringFromPattern( newPattern, x, y );
                    if( potentialMatch.equals( word ) )
                    {
                        if( !isPatternChanged )
                        {
                            xy = new String[]{ x, y };
                        }
                        else
                        {
                            xy = new String[]{ y, x };
                        }
                        break;

                    }

                }
            }
            else
            {
                double xLength  = (double)wL/(double)(countXY[0]);
                if(xLength<=0 || xLength%1!=0)
                    xy = new String[] {null, null};
                else
                {
                    x = word.substring( 0,(int)xLength );
                    String potentialMatch = buildStringFromPattern( newPattern, x, null );
                    if(potentialMatch.equals( word ))
                    {
                        if(!isPatternChanged)
                            xy = new String[] {x,null};
                        else
                            xy = new String[]{null,x};
                    }
                        
                }
            }
        }
        return xy;
    }

    private static String buildStringFromPattern( String pattern, String x, String y )
    {
        StringBuilder sb = new StringBuilder();
        for( int i = 0; i < pattern.length(); i++ )
        {
            if( pattern.charAt( i ) == 'x' )
                sb.append( x );
            else
                sb.append( y );

        }
        return sb.toString();
    }

    private static int getCountXYAndYPosition( String word, Integer[] countXY )
    {

        int yPosition = -1;
        for( int i = 0; i < word.length(); i++ )
        {
            if( word.charAt( i ) == 'x' )
                countXY[0]++;
            else
            {
                countXY[1]++;
                if( yPosition == -1 )
                    yPosition = i;
            }
        }
        return yPosition;
    }

    private static String getNewPattern( String pattern )
    {
        char[] patternChars = pattern.toCharArray();
        if( pattern.charAt( 0 ) == 'x' )
            return pattern;
        else
        {

            for( int i = 0; i < patternChars.length; i++ )
            {
                if( patternChars[i] == 'x' )
                    patternChars[i] = 'y';
                else
                    patternChars[i] = 'x';
            }

        }
        return new String( patternChars );

    }

    public static void main( String[] args )
    {
       String[] patternString = getPatternString("gogogogogo","yyyyy");
       for(String str : patternString)
           System.out.println( str );

    }

}
