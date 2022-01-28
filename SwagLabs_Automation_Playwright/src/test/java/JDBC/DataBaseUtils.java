package JDBC;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;
import java.sql.Connection;

public class DataBaseUtils {

	private ResultSet rs;
	public String dburl = "", dbusername = "", dbpwd = "";
	//String host="localhost";

	@Test
	public void connectToDatabase() throws SQLException, ClassNotFoundException{
		String host="localhost";
		String port= "3306";

		Connection conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/Qadbt","root" ,"root");
		Statement s=conn.createStatement();
		rs= s.executeQuery("select * from AddressInfo");
		while(rs.next()) {
			System.out.println(rs.getString("fname"));
			System.out.println(rs.getString("lname"));
		}


	}
}
