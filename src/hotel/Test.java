package hotel;

import java.util.Vector;

//�׽�Ʈ�� �ڹ� ����
public class Test
{
	public static void main(String[] args)
	{
		System.out.println("2022-05-22".compareTo("2022-05-22"));
		System.out.println("2022-05-23".compareTo("2022-05-22"));
		System.out.println("2022-05-20".compareTo("2022-05-22") > 0);
		
		DB.loadConnect();
		System.out.println(DB.selectRoomByHotelNameAndRoomNum("�Ŷ����� �Ｚ", 101));
		Vector<Reservation> reservations = DB.selectReservationsByRoom(DB.selectRoomByHotelNameAndRoomNum("�Ŷ����� �Ｚ", 101));
		for(Reservation r: reservations)
		{
			System.out.println(r);
		}
	}
}