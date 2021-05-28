package gamerecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
public class PerformDBAction {
	
	static String url = "jdbc:mysql://localhost:3306/studentdb";
	static String userName = "root";
	static String password = "pihu@1234";
	static String driverClassPath = "com.mysql.jdbc.Driver";

	public static Connection getDataBaseConnetion() {
		Connection con = null;
		try {
			Class.forName(driverClassPath);
			con = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}

	public static void InsertdatatoDB(List<String[]> header, List<String[]>entry, Connection con)throws Exception{		
		String headerindex;
		String[]entrylist;
		String values="";
		String coloumns="";
		String[]coloumnlist;
		String preparestmt;
		
		for(int i=0; i<entry.size(); i++) {
		    values="";
			coloumns="";			
			entrylist=entry.get(i);
			headerindex=entrylist[0];
			//System.out.println(headerindex);
			for(int j=1;j<entrylist.length;j++) {
				//System.out.println(entrylist[j]);
				if (j< entrylist.length-1) 
				{
					values=values.concat("\'").concat(entrylist[j].trim()).concat("\'").concat(" , ");
				}
				else
				{
					values=values.concat("\'").concat(entrylist[j].trim()).concat("\'");
				}
			}
			//System.out.println(headerindex);
			coloumnlist=header.get(Integer.parseInt(headerindex.trim())-1);
			
			for(int k=1;k<coloumnlist.length;k++) {
				if (k<coloumnlist.length -1 ) 
				{
					coloumns= coloumns.concat(coloumnlist[k].trim().replace(" ", "")).concat(",");
				}
				else 
				{
					coloumns= coloumns.concat(coloumnlist[k].trim().replace(" ", ""));
				}
			}
			//System.out.println(coloumns);
			preparestmt="insert into spindemo(RecordType,".concat(coloumns).concat(")values(").concat(headerindex).concat(" , ").concat(values).concat(")");
			
			System.out.println(preparestmt);
			
			Statement stmt = con.createStatement();
			int affectedrow = stmt.executeUpdate(preparestmt);
			System.out.println("row affected : " + affectedrow);
			
		}
  }

}
