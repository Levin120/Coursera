package com.coursera.week_2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class Solution {

	/**
	 * @param args
	 * @throws IOException
	 * @answer  
	 */
	public static void main(String[] args) throws IOException {
		String fileName = "D:\\Levin120\\Coursera\\algo-006\\week-2\\QuickSort.txt";
		//String fileName = "F:\\TDDOWNLOAD\\Algorithms Design and Analysis, Part 1\\QuickSort.txt";
		//String fileName = "F:\\TDDOWNLOAD\\Algorithms Design and Analysis, Part 1\\testInteger.txt";
		File file = new File(fileName);
		BufferedReader  reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int tempInteger = -1;
            int line = 0;
            int[] arr = new int[100005];
            int i = 0;
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
            while ((tempString = reader.readLine()) != null) {
            	// ��ʾ�к�
            	tempInteger = Integer.parseInt(tempString);
            	arr[i] = tempInteger;
                //System.out.println("line " + line + ": " + tempInteger);
                line++;
                i++;
            }
            //System.out.println(line);
            BigInteger inversionCount = null ;
            //System.out.println(inversionCount);
            QuickSortCount qs = new QuickSortCount();
            //BigInteger cnt1 = qs.sort1(arr, 0, line - 1);
            //System.out.println(cnt1);
            //BigInteger cnt2 = qs.sort2(arr, 0, line - 1);
            //System.out.println(cnt2);
            BigInteger cnt3 = qs.sort3(arr, 0, line - 1);
            System.out.println(cnt3);
            //int cnt = qs.quickSort(arr, 0, line - 1);
            //System.out.println(cnt);
            reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

	}

}
