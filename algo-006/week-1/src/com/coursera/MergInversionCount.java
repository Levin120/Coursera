package com.coursera;

import java.math.BigInteger;

public class MergInversionCount {
	public static BigInteger count(int[] array, int p, int r) {  
		BigInteger inversionCount = BigInteger.ZERO;  
        if (p < r) {  
            int mid = (p + r) / 2;  
            /*inversionCount += count(array, p, mid);  
            inversionCount += count(array, mid+1, r);  
            inversionCount += mergeInversion(array, p, mid, r);  */
            inversionCount = inversionCount.add(count(array, p, mid));
            inversionCount = inversionCount.add(count(array, mid+1, r));
            inversionCount = inversionCount.add(mergeInversion(array, p, mid, r));
        }  
        return inversionCount;  
    }  
  
    private static BigInteger mergeInversion(int[] array, int p, int mid, int r) {  
    	BigInteger inversionCount = BigInteger.ZERO;  
        int[] temp = new int[r-p+1];  
        if(array.length < r)  
            return inversionCount;  
        int left = p;  
        int right = mid + 1;  
        int storeIndex = 0;  
        while(left <= mid && right <= r)  
        {  
            if(array[left] > array[right])  
            {  
                //inversionCount += mid-left+1; //当前right存在逆序数，数目等于mid-left+1  
            	inversionCount = inversionCount.add(BigInteger.valueOf(mid-left+1));
            	temp[storeIndex] = array[right];  
                right++;  
            }  
            else  
            {  
                temp[storeIndex] = array[left];  
                left++;  
            }  
            storeIndex++;  
        }  
        if(left <= mid)  
        {  
            for(int i = left; i <= mid; i++)  
            {  
                temp[storeIndex] = array[i];  
                storeIndex++;  
            }  
        }  
        if(right <= r)  
        {  
            for(int i = right; i <= r; i++)  
            {  
                temp[storeIndex] = array[i];  
                storeIndex++;  
            }  
        }  
          
        for(int i = p; i <= r; i++)  
        {  
            array[i] = temp[i-p];  
              
        }  
        return inversionCount;  
    }  
  
}  
