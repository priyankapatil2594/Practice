package gamerecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.sql.Connection;

public class Gamedetails {
	private List <String []> Headers = new ArrayList<>();
	private List <String []> entries = new ArrayList<>();
	
	public List<String[]> getHeaders() {
		return Headers;
	}

	public List<String[]> getEntries() {
		return entries;
	}

   //static String fileurl="D:\\Priyanka Software Class\\GameProject\\gamefilesmall.csv";
	  
	public static List<String[]> readFileInfo()throws Exception {
		
		  FileReader fr= new FileReader("D:\\Priyanka Software Class\\GameProject\\gamefilesmall.csv");
		
		  BufferedReader br = new BufferedReader(fr);
		  
		  List <String []> listofvalues = new ArrayList<>();
		    String line;
	    	 //read next line
		    while ((line= br.readLine())!= null) {
				String[] values =line.split("\\|");
				//System.out.println(Arrays.toString(values));
			     listofvalues.add(values);
                }	 
		    
//		 	  Iterator<String[]> itr=listofvalues.iterator();		    
//		    while(itr.hasNext()) {
//		    	String[]dumyarray =itr.next();	    	
//	    	System.out.println(Arrays.toString(dumyarray));
		    
		          br.close();
		           return listofvalues;
	}
	
	  private void Seperatearrays(List<String[]>list) { 		
	    Iterator<String[]> itr = list.iterator();
		while(itr.hasNext()) {
			String [] seperaterows =  itr.next();
			if(Integer.parseInt( seperaterows[0].trim()) == 0)
			{
				Headers.add( seperaterows);
			}
			else {
				entries.add( seperaterows);
				 }
		}
}
	  
	   public static void main(String[] args)throws Exception {
	   List<String []> result= Gamedetails.readFileInfo();
          Gamedetails gm= new Gamedetails();
	         gm.Seperatearrays(result);
//     Iterator<String[]>itr=gm.entries.iterator();
//    while(itr.hasNext()) {
//    	 System.out.println(Arrays.toString(itr.next()));
//     }
	         List<String []> h=gm.Headers;
	         List<String []> e= gm.entries;
	         
	         Connection con= PerformDBAction.getDataBaseConnetion();
	         PerformDBAction.InsertdatatoDB(h,e,con);
	         
           }
	   
}




   