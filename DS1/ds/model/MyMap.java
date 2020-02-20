package ds.model;

public class MyMap<K,V> {

	int capacity = 1<<2;
	int size = 0;
	Entry<K,V>[] buckets;

	public MyMap(){
		buckets = new Entry[capacity];
	}
	
	public int getSize(){
		return size;
	}
	public int getBucketSize()
	{
		return capacity;
	}
	public void put(K key, V value)
	{
		Entry<K,V> entry = new Entry<>(key,value,null);
		
		int bucket = key.hashCode()%getBucketSize();
		
		Entry<K,V> existingEntry = buckets[bucket];
		
		if(existingEntry!=null)
		{
			if(existingEntry.getKey().equals(key))
			{
				existingEntry.setValue(value);
				return;
			}
			else
			{
				while(existingEntry.getNext()!=null)
				{
					if(existingEntry.getKey().equals(key))
					{
						existingEntry.setValue(value);
						return;
					}
					
					existingEntry = existingEntry.getNext();
				}
				existingEntry.setNext(entry);
			}
			
		}
		else
		{
			buckets[bucket] = entry;
			
		}
		size++;
		
	}
	
	public V get(K key)
	{
		int bucket = key.hashCode()%getBucketSize();
		Entry<K,V>  entry = buckets[bucket];
		
		while(entry!=null)
		{
			if(entry.getKey().equals(key))
				return entry.getValue(); 
			
			entry = entry.getNext();
			
		}
		
		return null;
		
		
	}
}
