package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

import org.testng.annotations.Test;

public class TestSample {

//	 @Test(groups="google")
	public void testGoogle() {

		boolean[] bool = new boolean[34];
		int num = 1;
		while (num <= 6) {
			int index = (int) (Math.random() * (32) + 1);
			if (bool[index]) {
				continue;
			} else {
				System.out.println("ºìÉ«ºÅÂë==" + index);
				bool[index] = true;
				num++;
			}
		}

		int index = (int) (Math.random() * (15) + 1);
		System.out.println("À¶É«ºÅÂë==" + index);
		 			 
		
	}
	 
	 public List deepCopy(List src) throws IOException, ClassNotFoundException{                            
	       ByteArrayOutputStream byteOut = new ByteArrayOutputStream();                                
	       ObjectOutputStream out = new ObjectOutputStream(byteOut);                                   
	       out.writeObject(src);                                                                       
	       ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());              
	       ObjectInputStream in =new ObjectInputStream(byteIn);                                        
	       List dest = (List)in.readObject();                                                          
	       return dest;                                                                                
	   }                                                                                               

	 @Test(groups="google")
	public void testGoogle1() {
//		boolean[] bool = new boolean[35];
//
//		boolean[] bool1 = new boolean[12];
//		int num = 1;
//		int num1 = 1;
//		while (num <= 5) {
//			int index = (int) (Math.random() * (34) + 1);
//			if (bool[index]) {
//				continue;
//			} else {
//				System.out.println("ºìÉ«ºÅÂë==" + index);
//				bool[index] = true;
//				num++;
//			}
//		}
//
//		while (num1 <= 2) {
//			int index = (int) (Math.random() * (11) + 1);
//			if (bool1[index]) {
//				continue;
//			} else {
//				System.out.println("À¶É«ºÅÂë==" + index);
//				bool1[index] = true;
//				num1++;
//			}
//		}
		
		
		String arch = System.getProperty("sun.arch.data.model");
		System.out.println(arch); 

	}


}
