package com.sanfotech.complexproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ApartmentHunt
{

    public static void main( String[] args )
    {
        HashSet<String> requirements = new HashSet<>();
        requirements.add( "SC" );
        requirements.add( "ST" );
        requirements.add( "G" );
        ArrayList<HashSet<String>> buildings = new ArrayList<>();
        HashSet<String> set1 = new HashSet<String>();
        set1.add( "SC" );
     

        HashSet<String> set2 = new HashSet<String>();
        set2.add( "G" );
        HashSet<String> set3 = new HashSet<String>();
        set3.add( "G" );
        set3.add( "SC" );
        HashSet<String> set4 = new HashSet<String>();
        set4.add( "SC" );
        HashSet<String> set5 = new HashSet<String>();
        set5.add( "SC" );
        set5.add( "ST" );
        buildings.add( set1 );
        buildings.add( set2 );
        buildings.add( set3 );
        buildings.add( set4 );
        buildings.add( set5 );
        System.out.println( getApartmentWithMinDistanceFromAllRequirementsOptimized( buildings, requirements ) );

    }

    // Time O(B^2R) Space O(B)
    private static int getApartmentWithMinDistanceFromAllRequirements( ArrayList<HashSet<String>> buildings,
        HashSet<String> requirements )
    {
        int lenBuilding = buildings.size();
        int lenRequirements = requirements.size();
        int[] farthestDistanceOfBuildingWithRequirements = new int[ lenBuilding ];
        Arrays.fill( farthestDistanceOfBuildingWithRequirements, Integer.MIN_VALUE );
        for( int i = 0; i < lenBuilding; i++ )
        {
            for( String req : requirements )
            {
                int minDistanceOfRequirementsFromCurBuilding = Integer.MAX_VALUE;
                for( int j = 0; j < lenBuilding; j++ )
                {

                    if( buildings.get( j ).contains( req ) )
                    {
                        if( minDistanceOfRequirementsFromCurBuilding > Math.abs( i - j ) )
                            minDistanceOfRequirementsFromCurBuilding = Math.abs( i - j );
                    }
                }

                farthestDistanceOfBuildingWithRequirements[i] =
                    Math.max( farthestDistanceOfBuildingWithRequirements[i], minDistanceOfRequirementsFromCurBuilding );
            }
        }

        return getBuildingIndexNearestToAllRequirements( farthestDistanceOfBuildingWithRequirements );

    }

    // Time O(BR) Space O(BR)
    private static int getApartmentWithMinDistanceFromAllRequirementsOptimized( ArrayList<HashSet<String>> buildings,
        HashSet<String> requirements )
    {
        int lenBuilding = buildings.size();

        int[][] minDistanceOfReqfromBuilding = new int[ requirements.size() ][ lenBuilding ];

        int cloesetReqIdx;
        int reqIndex = 0;
        for( String req : requirements )
        {
            int[] minDistanceOfReq = new int[ lenBuilding ];
            Arrays.fill( minDistanceOfReq, Integer.MAX_VALUE );
            cloesetReqIdx = Integer.MAX_VALUE;
            for( int i = 0; i < lenBuilding; i++ )
            {
                if( buildings.get( i ).contains( req ) )
                    cloesetReqIdx = i;

                minDistanceOfReq[i] = Math.min( Math.abs( cloesetReqIdx - i ), minDistanceOfReq[i] );
            }

            cloesetReqIdx = Integer.MAX_VALUE;
            for( int i = lenBuilding - 1; i >= 0; i-- )
            {
                if( buildings.get( i ).contains( req ) )
                    cloesetReqIdx = i;

                minDistanceOfReq[i] = Math.min( Math.abs( cloesetReqIdx - i ), minDistanceOfReq[i] );
            }

            minDistanceOfReqfromBuilding[reqIndex++] = minDistanceOfReq;

        }

        return getIndexOfBuildingNearestToAllReq( minDistanceOfReqfromBuilding );

    }

    private static int getIndexOfBuildingNearestToAllReq( int[][] minDistanceOfReqfromBuilding )
    {

        int lengthReq = minDistanceOfReqfromBuilding.length;
        int lengthBuilding = minDistanceOfReqfromBuilding[0].length;
        int minFromFarthestDistance = Integer.MAX_VALUE;
        int indexOfBuildingClosestToAllReq = 0;

        for( int i = 0; i < lengthBuilding; i++ )
        {
            int farthestDistanceOfRequirementFromAllBuildings = Integer.MIN_VALUE;

            for( int j = 0; j < lengthReq; j++ )
            {
                if( farthestDistanceOfRequirementFromAllBuildings < minDistanceOfReqfromBuilding[j][i] )
                {
                    farthestDistanceOfRequirementFromAllBuildings = minDistanceOfReqfromBuilding[j][i];
                }

            }

            if( minFromFarthestDistance > farthestDistanceOfRequirementFromAllBuildings )
            {
                minFromFarthestDistance = farthestDistanceOfRequirementFromAllBuildings;
                indexOfBuildingClosestToAllReq = i;
            }

        }
        return indexOfBuildingClosestToAllReq;
    }

    private static int getBuildingIndexNearestToAllRequirements( int[] farthestDistanceOfBuildingWithRequirements )
    {
        int indexOfBuildingWithMinDistanceFromAllReqs = Integer.MAX_VALUE;
        int minFarthestDistance = Integer.MAX_VALUE;
        for( int i = 0; i < farthestDistanceOfBuildingWithRequirements.length; i++ )
        {
            if( minFarthestDistance > farthestDistanceOfBuildingWithRequirements[i] )
            {
                minFarthestDistance = farthestDistanceOfBuildingWithRequirements[i];
                indexOfBuildingWithMinDistanceFromAllReqs = i;
            }
        }

        return indexOfBuildingWithMinDistanceFromAllReqs;
    }

}
