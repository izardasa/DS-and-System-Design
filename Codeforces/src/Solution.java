import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    Map<Integer,Integer> map ;
    Deque<Integer> dq;
    int capacity;
    public Solution(int capacity) {
        map = new HashMap<Integer,Integer>();
        dq = new LinkedList<Integer>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key))
            return map.get(key);
            
        return -1;
    }
    
    public void set(int key, int value) {
        if(!map.containsKey(key))
        {
            if(dq.size()==capacity)
            {
                dq.remove(key);
                map.remove(key);
            }
            
        }
        else
        {
            map.remove(dq.removeLast());
        }
        dq.addFirst(key);
        map.put(key, value);
    }
    
    public static void main(String[] args)
    {
        
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        Solution solution = new Solution( n );
        for(int i=0;i<n;i++)
        {
            int key = s.nextInt();
            int value = s.nextInt();
            solution.set( key, value );
        }
        
      System.out.println(   solution.get( 6 ) );
      System.out.println(   solution.get( 5 ) );
      System.out.println(   solution.get( 1 ) );
      System.out.println(   solution.get( 2 ) );
        
    }
}
