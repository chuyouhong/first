package first.controller.test.testSQL;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class GetMysqlVerson {
	public static void main(String[] args) throws Exception {
		String username="root";
		String password="mixiguoji123";
		String url="jdbc:mysql://121.40.33.21:3306/new_test";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url,username,password);
		DatabaseMetaData dmd=conn.getMetaData();
		System.out.println("数据库名称："+dmd.getDatabaseProductName());
		System.out.println("数据库版本："+ dmd.getDatabaseProductVersion());
		System.out.println("数据库名称："+ dmd.getUserName());
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("select * from item where id=1");
		ResultSetMetaData md = rs.getMetaData();
		int count=md.getColumnCount();
		System.out.println("所查的表名："+md.getTableName(1));
		System.out.println("字段数量："+count);
		for(int i=0;i<count;i++){
		//	System.out.println(md.getTableName(i));
			System.out.println("第"+(i+1)+"个字段名称是："+md.getColumnName(i+1));
		//	System.out.println(md.getColumnType(i));
		//	System.out.println(md.isNullable(i));
		}
	}

}
