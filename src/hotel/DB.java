package hotel;

import java.sql.*;

public class DB
{
	static  Connection con = null;
	static String URL = "jdbc:mysql://localhost:3306/" ;
	
	//DB�ε��ϴ� �Լ�. �����ϸ� true �����ϸ� false�� ��ȯ
	public static boolean loadConnect(String database)
	{
		try { Class.forName("com.mysql.jdbc.Driver");} 
		catch ( java.lang.ClassNotFoundException e ) {
			System.err.println("Driver load ����: " + e.getMessage() );
			e.printStackTrace();                      
		}
		try {
			   con  = DriverManager.getConnection(URL + database, "root", "onlyroot");
			   return true;
		} 
		catch( SQLException e ) { System.err.println("conn ����:" + e.getMessage() ); }
		return false;
	}
	
	//��� sql�� �����ϴ� �޼ҵ�
	public static void executeAnyQuery(String sql) 
	{
		try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.execute(sql);
		} catch(SQLException ex ) {
			System.err.println("\n SQL execute error in executeAnyQuery(): " + ex.getMessage() );
			System.out.println("��������: " + sql);
			ex.printStackTrace();
		}
	}
	
	//��� insert���� �����ϴ� �޼ҵ�
	public static void insertAnyQuery(String sql) 
	{
		try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.executeUpdate(sql);	
		} catch(SQLException ex ) {
			System.err.println("\n SQL executeUpdate error in insertAnyQuery(): " + ex.getMessage() );
			System.out.println("��������: " + sql);
			ex.printStackTrace();
		}
	}
	
	//ȸ������ customer ������ db�� �����ϴ� �޼ҵ� 
	public static int insertCustomer(Customer customer)
	{
		int cnt = 0;
		try {
			PreparedStatement prStmt;
			prStmt = con.prepareStatement("insert into customer values(?, ?, ?, ?, ?);" );
			prStmt.setString(1, customer.c_id);
			prStmt.setString(2, customer.passwd);
			prStmt.setString(3, customer.name);
			prStmt.setString(4, customer.cellphone);
			prStmt.setString(5, customer.email);
			cnt = prStmt.executeUpdate();
		} catch(SQLException ex ) {
			System.err.println("\n SQL executeUpdate error in insertCustomer(): " + ex.getMessage() );
			ex.printStackTrace();
		}
		return cnt;
	}
}