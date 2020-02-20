package ds.impl;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap
{
    private List<Bucket> hashMap;
    private static final int MAP_SIZE=2069;
    
    public MyHashMap()
    {
        hashMap = new ArrayList<Bucket>();
        
        for(int i=0;i<MAP_SIZE;i++)
        {
            hashMap.add( new Bucket() );
        }
    }
    
    public void put(int key, int value)
    {
        Bucket bucket = hashMap.get( key%MAP_SIZE );
        bucket.put( key, value );
    }
    
    public void remove(int key)
    {
        Bucket bucket = hashMap.get( key%MAP_SIZE );
        bucket.remove( key );
    }
    
    public int get(int key)
    {
        Bucket bucket = hashMap.get( key%MAP_SIZE );
        return bucket.get( key );
    }
    public static void main( String[] args )
    {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put( 1, 1 );
        hashMap.put( 2, 2 );
        System.out.println( hashMap.get( 1 ) );
        System.out.println( hashMap.get( 3 ) );
        hashMap.put( 2, 1 );
       System.out.println(  hashMap.get( 2 ) );
        hashMap.remove( 2 );
        System.out.println( hashMap.get( 2 ) );
        

    }

}

class Pair<K,V>
{
    public K key;
    public V value;
    
    public Pair(K key, V value)
    {
        this.key  = key;
        this.value = value;
    }
}

class Bucket
{
    List<Pair<Integer,Integer>> bucket;
    
    public Bucket()
    {
        bucket = new java.util.LinkedList<Pair<Integer,Integer>>();
    }
    
    public void put(int key, int value)
    {
        boolean found =false;
        for(Pair<Integer, Integer> pair: bucket)
        {
            if(pair.key.equals( key ))
            {
                pair.value = value;
                found = true;
                break;
            }
        }
        if(!found)
            bucket.add(new Pair( key,value) );
    }
    
    public void remove(int key)
    {
        for(Pair<Integer, Integer> pair: bucket)
        {
            if(pair.key.equals( key ))
            {
                bucket.remove(pair);
                break;
            }
        }
    }
    
    public int get(int key)
    {
        for(Pair<Integer, Integer> pair: bucket)
        {
            if(pair.key.equals( key ))
                return pair.value;
        }
        
        return -1;
    }
}




