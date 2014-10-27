package com.coursera;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

import com.couresa.MergInversionCount;

public class Solution {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String fileName = "F:\\IntegerArray.txt";
		
		File file = new File(fileName);
		BufferedReader  reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int tempInteger = -1;
            int line = 1;
            int[] arr = new int[100005];
            int i = 0;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
            	// 显示行号
            	tempInteger = Integer.parseInt(tempString);
            	arr[i] = tempInteger;
                //System.out.println("line " + line + ": " + tempInteger);
                line++;
                i++;
            }
            System.out.println(line);
            BigInteger inversionCount = MergInversionCount.count(arr, 0, line - 2);
            System.out.println(inversionCount);
            reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
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
