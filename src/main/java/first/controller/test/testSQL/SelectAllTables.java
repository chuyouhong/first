package first.controller.test.testSQL;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectAllTables {
	public static void main(String[] args) throws Exception {
		String username="root";
		String password="mixiguoji123";
		String url="jdbc:mysql://121.40.33.21:3306/new_test";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url,username,password);
		conn.setAutoCommit(false);
		Statement stat = conn.createStatement();
		
		
		
//		获取数据库中的所有表名称
//		DatabaseMetaData dmd=conn.getMetaData();
//		String[] types={"TABLE"};
//		ResultSet rs = dmd.getTables(null, null, "%", null);
//		while(rs.next()){
//			System.out.println(rs.getString(3));
//		}
		
	}
}
