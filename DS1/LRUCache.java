import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {
	
	private Deque<Integer> dq;
	private HashSet<Integer> map;
	int cSize;
	public LRUCache(int size) {
		this.cSize = size;
		dq = new LinkedList<>();
		map = new HashSet<>();
	}
	
	public void refer(int x)
	{
		if(!map.contains(x))
		{
			if(this.cSize==dq.size())
			{
				int last = dq.removeLast();
				map.remove(last);
			}
		}
		else
		{
			Iterator<Integer> it = dq.iterator();
			while(it.hasNext())
			{
				if(it.next()==x)
				{
					dq.remove(x);
					break;
				}
			}
			
			
		}
		
		dq.push(x);
		map.add(x);
		
	}

	public void display(){
		Iterator<Integer> it= dq.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next()+" ");
		}
	}
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		cache.refer(1);
		cache.refer(2);
		cache.refer(6);
		cache.refer(1);
		cache.refer(1);
		cache.refer(2);
		cache.refer(1);
		cache.refer(2);
		cache.refer(1);
		cache.display();
		

	}

}
