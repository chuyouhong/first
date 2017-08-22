package first.controller.test.testSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionMysql {
	public static void main(String[] args) throws Exception {
		String url="jdbc:mysql://121.40.33.21:3306/new_test";
		String username="root";
		String password="mixiguoji123";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement stat = conn.createStatement();
		ResultSet rt = stat.executeQuery("select * from item");
		while(rt.next()){
			System.out.println(rt.getString("id"));
//			System.out.println(rt.getString(2));
//			System.out.println(rt.getString(3));
		}
	//	int rt1 = stat.executeUpdate("update item set gender=3 where id=1");
		
//		PreparedStatement pre = conn.prepareStatement("select * from item where id = ? ;");
//		pre.setInt(1, 2);
//		ResultSet q = pre.executeQuery();
//		while(q.next()){
//			System.out.println(q.getString("id"));
//			System.out.println(q.getString(2));
//			System.out.println(q.getString(3));
//		}
	}

}
