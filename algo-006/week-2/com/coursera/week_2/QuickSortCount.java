package com.coursera.week_2;

import java.math.BigInteger;

public class QuickSortCount {
	
	public int quickSort(int arr[], int low, int high) {
		int l = low;
		int r = high;
		int cnt = 0;
		if(l < r)
			cnt = r - l;
		if(l < r)  
	    {  
	        int i = l, j = r, x = arr[l];  
	        while (i < j)  
	        {  
	            while(i < j && arr[j] >= x)
	                j--;    
	            if(i < j)   
	                arr[i++] = arr[j];  
	              
	            while(i < j && arr[i] < x)
	                i++;    
	            if(i < j)   
	                arr[j--] = arr[i];  
	        }  
	        arr[i] = x;  
	        cnt += quickSort(arr, l, i - 1); // µÝ¹éµ÷ÓÃ   
	        cnt += quickSort(arr, i + 1, r);  
	    }
		return cnt;
	}
	
	public BigInteger sort1(int arr[], int low, int high) {
		int l = low;
		int h = high;
		int povit = arr[low];
		BigInteger cnt = BigInteger.ZERO;
		cnt = cnt.add(BigInteger.valueOf(high - low));
		while(l < h) {
			while(arr[h] >= povit && l < h ) 
			{
				h--;
				//cnt = cnt.add(BigInteger.ONE);
			}
			if(l < h) {
				int temp = arr[h];
				arr[h] = arr[l];
				arr[l] = temp;
				l++;
			}
			
			while(arr[l] <= povit && l < h)
			{
				l++;
				//cnt = cnt.add(BigInteger.ONE);
			}
			if(l < h) {
				int temp = arr[h];
				arr[h] = arr[l];
				arr[l] = temp;
				h--;
			}
		}
		
		//print(arr);
		//System.out.println("l=" + (l + 1) + " h=" + (h + 1) + " povit=" + povit);
		if(l > low)
			cnt = cnt.add(sort1(arr, low, h - 1));
		if(h < high)
			cnt = cnt.add(sort1(arr, l + 1, high));
		return cnt;
	}
	
	public BigInteger sort2(int arr[], int low, int high) {
		int l = low;
		int h = high;
		int povit = arr[high];
		BigInteger cnt = BigInteger.ZERO;
		cnt = cnt.add(BigInteger.valueOf(high - low));
		while(l < h) {
			
			while(l < h && arr[l] <= povit)
			{
				l++;
				//cnt = cnt.add(BigInteger.ONE);
			}
			if(l < h) {
				int temp = arr[h];
				arr[h] = arr[l];
				arr[l] = temp;
				h--;
			}
			
			while(l < h && arr[h] >= povit) 
			{
				h--;
				//cnt = cnt.add(BigInteger.ONE);
			}
			if(l < h) {
				int temp = arr[h];
				arr[h] = arr[l];
				arr[l] = temp;
				l++;
			}
		}
	
		if(l > low)
			cnt = cnt.add(sort2(arr, low, h - 1));
		if(h < high)
			cnt = cnt.add(sort2(arr, l + 1, high));
		return cnt;
	}
	
	public BigInteger sort3(int arr[], int low, int high) {
		int l = low;
		int h = high;
		int povit = arr[(high - low) / 2];
		BigInteger cnt = BigInteger.ZERO;
		cnt = cnt.add(BigInteger.valueOf(high - low));
		while(l < h) {
			while(l < h && arr[l] >= povit) 
			{
				l++;
				//cnt = cnt.add(BigInteger.ONE);
			}
			if(l < h) {
				int temp = arr[h];
				arr[h] = arr[l];
				arr[l] = temp;
				l++;
			}
			
			while(l < h && arr[h] <= povit)
			{
				h--;
				//cnt = cnt.add(BigInteger.ONE);
			}
			if(l < h) {
				int temp = arr[h];
				arr[h] = arr[l];
				arr[l] = temp;
				h--;
			}
		}
	
		if(l > low)
			cnt = cnt.add(sort3(arr, low, h - 1));
		if(h < high)
			cnt = cnt.add(sort3(arr, l + 1, high));
		return cnt;
	}

}
