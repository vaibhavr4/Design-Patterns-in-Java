package Bitvector.a;


/**
 * @author VAIBHAV
 * this class implements the operations of the BitSet
 * such as set,get, copy and size
 *
 */
public class BitVector implements IBitVector{
	
	private int[] bitvectorarray = new int[1];
    int bytecount;
	int setpos;
	int vector=0;
	int len;
	
	/**
	 * @see IBitVector#get(int)
	 * returns true if given bit is set
	 */
	public boolean get(int i) {
		int shiftval = bitvectorarray[i/32];
		shiftval=shiftval>>>i; 
		return (shiftval & 1) == 1;
		
	}

	/**
	 * @see IBitVector#set(int)
	 * sets the bit at the given position
	 */
	public void set(int i) {
		bytecount = i/32;
		len = bitvectorarray.length;
		if(len > bytecount)
		{
			bitShift(bytecount,i);
		}
		else
		{
			resize(bytecount+1);
			bitShift(bytecount,i);					
		}
			
	}
	
	/**
	 * @param bytecount
	 * @param i
	 * used to perform OR operation to shift bits during set
	 */
	public void bitShift(int bytecount,int i)
	{
		vector= bitvectorarray[0];	
		setpos= i%32;
		vector = bitvectorarray[bytecount] | (1<<setpos);
		bitvectorarray[bytecount]=vector;
	}

	/**
	 * @see IBitVector#clear(int)
	 * used to clear the bit at a given position
	 */
	public void clear(int i) {
			int shiftval = bitvectorarray[i/32];
			shiftval = shiftval & (~(1<<i));
			bitvectorarray[i/32] = shiftval;
	
	}

	/**
	 * @see IBitVector#copy(BitVector)
	 * copies one bit vector array to another
	 */
	public void copy(BitVector b) {
		if(this.bitvectorarray.length<b.bitvectorarray.length)
		{
			resize(b.bitvectorarray.length);
			for(int i=0; i<b.bitvectorarray.length; i++)
				this.bitvectorarray[i] |= b.bitvectorarray[i];
		}
		else
			for(int i=0; i<b.bitvectorarray.length; i++)
				this.bitvectorarray[i] |= b.bitvectorarray[i];
		
	}

	/**
	 * @return int
	 * @see IBitVector#size()
	 * returns the size of the number of bits set in bit vector array
	 */
	public int size() {
		len = bitvectorarray.length;
		int shiftval;
		int count = 0;
		for(int i=0; i < len; i++)
		{
			shiftval = bitvectorarray[i];
			while(shiftval!=0) 
			{
				if((shiftval & 1) == 1) 
					count++;    
				shiftval = shiftval>>>1;
			}
		}
		return count;
	}

	/**
	 * @see IBitVector#iterator()
	 * yet to be implemented
	 */
	public Iterator<Integer> iterator() {
		
		return null;
	}
	
	/**
	 * @param capacity
	 * used to resize the array dynamically
	 */
	private void resize(int capacity)
    {
        int[] tmp = new int[capacity];
        System.arraycopy(bitvectorarray, 0, tmp, 0, bitvectorarray.length);        
        this.bitvectorarray = tmp;
    }
	
}
