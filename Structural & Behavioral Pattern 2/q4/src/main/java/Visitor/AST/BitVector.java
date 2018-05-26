package Visitor.AST;

import Visitor.AST.ArrayIterator;
import Visitor.AST.BitVector;
import Visitor.AST.IBitVector;
import Visitor.AST.Iterator;

/**
 * @author VAIBHAV
 * this class implements the BitSet operations
 *
 */
public class BitVector implements IBitVector{
	
	private int[] bitvectorarray = new int[0];
    int bytecount;
	int setpos;
	int vector=0;
	int len;
	
	/**
	 * @see IBitVector#get(int)
	 * return boolean
	 * it returns true if the given bit value is set
	 */
	public boolean get(int i) {
		int shiftval = bitvectorarray[i/32];
		shiftval=shiftval>>>i; 
		return (shiftval & 1) == 1;
		
	}

	/** 
	 * @param i
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
		Iterator<Integer> itr = b.iterator();
		while(itr.hasAnotherElement()) {
			set(itr.nextElement());
		}
	}

	/**
	 * @return int
	 * @see IBitVector#size()
	 * returns the number of bits set in the bitvector array
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
	 * @return Iterator<Integer>
	 * returns an object of ArrayIterator class
	 */
	public Iterator<Integer> iterator() {
		int[] bitsetarray = reversebitgen();
		Integer[] newArray = new Integer[bitsetarray.length];
		int i = 0;
		for (int value : bitsetarray) {
		    newArray[i++] = Integer.valueOf(value);
		}
		return new ArrayIterator<>(newArray);
	}
	
	/**
	 * used to determine the bits set for a given set of integers
	 * @return int array
	 */
	public int[] reversebitgen() {
		int[] bitsetarray = new int[1];
		int index=0;
		int count=0;
		int pos=0;
		int value;
		int size=bitvectorarray.length;
		while(size>index) {
			value=bitvectorarray[index];
			count=index*32;
			while(value!=0) {
				if((value&1)==1)
				{
					int[] temp = new int[pos+1];
					System.arraycopy(bitsetarray, 0, temp, 0, bitsetarray.length);
					bitsetarray = temp;
					bitsetarray[pos++]=count;
				}
				count++;
				value=value>>>1;
			}
			index++;
		}
		return bitsetarray;
	}

	
	/**
	 * @param capacity
	 */
	private void resize(int capacity)
    {
        int[] tmp = new int[capacity];
        System.arraycopy(bitvectorarray, 0, tmp, 0, bitvectorarray.length);        
        bitvectorarray = tmp;
    }

	
}
