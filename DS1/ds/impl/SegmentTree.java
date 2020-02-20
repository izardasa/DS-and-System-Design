package ds.impl;

public class SegmentTree
{
    static int N = 100000;
    static int n;
    
    static int[] tree = new int[2*N];
    
    
    public static void buildTree(int[] arr)
    {
        n = arr.length;
        for(int i=0;i<n;i++)
            tree[n+i] = arr[i];
        
        for(int i=n-1;i>0;--i)
            tree[i] =Math.min( tree[i<<1],tree[i<<1|1]);
    }
    
    public static int query(int l, int r)
    {
        int res= Integer.MAX_VALUE;
        for(l+=n,r+=n;l<r;l>>=1,r>>=1)
        {
            if((l&1)>0)
                res=Math.min( res,tree[l++]);
            
            if((r&1)>0)
                res=Math.min( res,tree[--r]);
        }
        return res;
    }
    
    public static void update(int pos, int value)
    {
        tree[n+pos] = value;
        pos = n+ pos;
        for( int i= pos;i>1;i>>=1)
            tree[i>>1] =Math.min( tree[i],tree[i^1]);
    }

}
