
import java.sql.*;

public class JDBC {
	public static void main(String[] args) {
	 
try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:8889/CompteBancaire","root","root");
//	PreparedStatement ps=conn.prepareStatement("select*client");
//	ResultSet rs=ps.executeQuery();
//	while(rs.next()){
//		System.out.println(rs.getInt(""))
//	}
//	System.out.println("JDBC.main()");
}
catch(Exception e){
	e.printStackTrace();
}
	}

}
