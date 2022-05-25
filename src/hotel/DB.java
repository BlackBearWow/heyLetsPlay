package hotel;

import java.sql.*;

public class DB
{
	static  Connection con = null;
	static String URL = "jdbc:mysql://localhost:3306/" ;
	
	//�Ű������� ���޵��� ���� loadConnect�� hotelreserve�� �⺻���� �����Ѵ�. java���� �⺻�Ű������� ���� ������ ���� �޼ҵ带 ��������.
	public static boolean loadConnect() {
		return loadConnect("hotelreserve");
	}
	
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
			PreparedStatement prStmt = con.prepareStatement("insert into customer values(?, ?, ?, ?, ?);", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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
	
	//������ �α����ϸ� Customer��ü�� ��ȯ��. ������ null��ȯ
	public static Customer selectCustomer(String id, String passwd) {
		try {
			PreparedStatement prStmt = con.prepareStatement("select * from customer where c_id = ? and passwd = ?;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prStmt.setString(1, id);
			prStmt.setString(2, Hash.SHA256(passwd));
			ResultSet rs = prStmt.executeQuery();
			if(rs.wasNull() == true)
				return null;
			return new Customer(id, passwd, "asdf", "asdf", "asd");
		} catch(SQLException ex ) {
			System.err.println("\n SQL executeUpdate error in insertCustomer(): " + ex.getMessage() );
			ex.printStackTrace();
		}
		return null;
	}
	
	//������ �α����ϸ� Customer��ü�� ��ȯ��. ������ null��ȯ
	public static hotelOwner selectHotelOwner(String id, String passwd) {
		try {
			PreparedStatement prStmt = con.prepareStatement("select * from hotel_owner where h_id = ? and passwd = ?;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prStmt.setString(1, id);
			prStmt.setString(2, Hash.SHA256(passwd));
			ResultSet rs = prStmt.executeQuery();
			rs.last();
			if(rs.getRow() == 0)
				return null;
			return new hotelOwner(id, passwd, "asdf", "asdf", "asd");
		} catch(SQLException ex ) {
			System.err.println("\n SQL executeUpdate error in insertCustomer(): " + ex.getMessage() );
			ex.printStackTrace();
		}
		return null;
	}
}