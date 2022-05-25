package hotel;

import java.sql.*;
import java.util.*;

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
			rs.next();
			String name = rs.getString("name");
			String cellphone = rs.getString("cellphone");
			String email = rs.getString("email");
			if(rs.wasNull())
				return null;
			return new Customer(id, passwd, name, cellphone, email);
		} catch(SQLException ex ) {
			System.err.println("\n SQL error in selectCustomer(): " + ex.getMessage() );
			ex.printStackTrace();
		}
		return null;
	}
	
	//������ �α����ϸ� Customer��ü�� ��ȯ��. ������ null��ȯ
	public static HotelOwner selectHotelOwner(String id, String passwd) {
		try {
			PreparedStatement prStmt = con.prepareStatement("select * from hotel_owner where h_id = ? and passwd = ?;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prStmt.setString(1, id);
			prStmt.setString(2, Hash.SHA256(passwd));
			ResultSet rs = prStmt.executeQuery();
			rs.next();
			String name = rs.getString("name");
			String cellphone = rs.getString("cellphone");
			String registration_number = rs.getString("registration_number");
			if(rs.wasNull())
				return null;
			return new HotelOwner(id, passwd, name, cellphone, registration_number);
		} catch(SQLException ex ) {
			System.err.println("\n SQL error in selectHotelOwner(): " + ex.getMessage() );
			ex.printStackTrace();
		}
		return null;
	}
	
	//��� ȣ���� ��ȯ�ϴ� �޼ҵ�
	public static Vector<Hotel> selectAllHotels() {
		try {
			PreparedStatement prStmt = con.prepareStatement("select * from hotel;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = prStmt.executeQuery();
			Vector<Hotel> hotels = new Vector<Hotel>();
			while(rs.next()) {
				String hotel_name = rs.getString("hotel_name");
				String address = rs.getString("address");
				String phone_num = rs.getString("phone_num");
				int stars = rs.getInt("stars");
				String h_id = rs.getString("h_id");
				String registration_date = rs.getString("registration_date");
				Hotel hotel = new Hotel(hotel_name, address, phone_num, stars, h_id, registration_date);
				hotels.add(hotel);
			}
			return hotels;
		} catch(SQLException ex ) {
			System.err.println("\n SQL error in selectAllHotels(): " + ex.getMessage() );
			ex.printStackTrace();
		}
		return null;
	}
	
	//id�� ȣ�ڿ����� �̸��� ��ȯ�ϴ� �޼ҵ�
	public static String getHotelOwnerNameByHostId(String id) {
		try {
			PreparedStatement prStmt = con.prepareStatement("select name from hotel_owner where h_id = ?;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prStmt.setString(1, id);
			ResultSet rs = prStmt.executeQuery();
			rs.next();
			return rs.getString("name");
		} catch(SQLException ex ) {
			System.err.println("\n SQL error in selectAllHotels(): " + ex.getMessage() );
			ex.printStackTrace();
		}
		return null;
	}
	
	//��� ȣ���� ��ȯ�ϴ� �޼ҵ�
	public static Vector<Room> selectRooms(String hotelname) {
		try {
			PreparedStatement prStmt = con.prepareStatement("select * from room where hotel_name = ?;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prStmt.setString(1, hotelname);
			ResultSet rs = prStmt.executeQuery();
			Vector<Room> rooms = new Vector<Room>();
			while(rs.next()) {
				String hotel_name = rs.getString("hotel_name");
				int room_num = rs.getInt("room_num");
				String registration_date = rs.getString("registration_date");
				int bed_num = rs.getInt("bed_num");
				int price = rs.getInt("price");
				int room_area = rs.getInt("room_area");
				Room room = new Room(hotel_name, room_num, registration_date, bed_num, price, room_area);
				rooms.add(room);
			}
			return rooms;
		} catch(SQLException ex ) {
			System.err.println("\n SQL error in selectAllHotels(): " + ex.getMessage() );
			ex.printStackTrace();
		}
		return null;
	}
	
	//id�� ȣ�ڿ����� �̸��� ��ȯ�ϴ� �޼ҵ�
	public static String getHotelOwnerNameByHotelName(String hotel_name) {
		try {
			PreparedStatement prStmt = con.prepareStatement("select name from hotel_owner, hotel where hotel_owner.h_id = hotel.h_id and hotel_name = ?;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prStmt.setString(1, hotel_name);
			ResultSet rs = prStmt.executeQuery();
			rs.next();
			return rs.getString("name");
		} catch(SQLException ex ) {
			System.err.println("\n SQL error in selectAllHotels(): " + ex.getMessage() );
			ex.printStackTrace();
		}
		return null;
	}
}