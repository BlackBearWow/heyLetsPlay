package hotel;

public class HotelSystemInitialization
{	
	static String[] createDatabaseCreateTableSqls = {
		"drop database if exists hotelreserve;",
		"create database hotelreserve;",
		"use hotelreserve;",
		
		"drop table if exists customer;",
		"create table customer("+
			"c_id varchar(40) NOT NULL,"+
			"passwd varchar(70) NOT NULL,"+
			"name varchar(40) NOT NULL,"+
			"cellphone varchar(40) NOT NULL,"+
			"email varchar(40) NOT NULL,"+
			"primary key(c_id)"+
		") DEFAULT CHARACTER SET UTF8;",
		
		"drop table if exists hotel_owner;",
		"create table hotel_owner("+
		   "h_id varchar(40) NOT NULL,"+
		   "passwd varchar(70) NOT NULL,"+
		   "name varchar(40) NOT NULL,"+
		   "cellphone varchar(40) NOT NULL,"+
		   "registration_number varchar(40) NOT NULL,"+
		   "primary key(h_id)"+
		") DEFAULT CHARACTER SET UTF8;",
		
		"drop table if exists hotel;",
		"create table hotel("+
		   "hotel_name varchar(40) NOT NULL,"+
		   "address varchar(40) NOT NULL,"+
		   "phone_num varchar(40) NOT NULL,"+
		   "stars int NOT NULL,"+
		   "h_id varchar(40) NOT NULL,"+
		   "registration_date date NOT NULL,"+
		   "primary key(hotel_name)"+
		") DEFAULT CHARACTER SET UTF8;",
		
		"drop table if exists room;",
		"create table room("+
		   "hotel_name varchar(40) NOT NULL,"+
		   "room_num int NOT NULL,"+
		   "registration_date date NOT NULL,"+
		   "bed_num int NOT NULL,"+
		   "price int NOT NULL,"+
		   "room_area int NOT NULL,"+
		   "primary key(hotel_name, room_num)"+
		") DEFAULT CHARACTER SET UTF8;",
		
		"drop table if exists reservation;",
		"create table reservation("+
		   "reservation_num int NOT NULL AUTO_INCREMENT,"+	//���� �ڵ� ������
		   "hotel_name varchar(40) NOT NULL,"+
		   "room_num int NOT NULL,"+
		   "c_id varchar(40) NOT NULL,"+
		   "reserve_date date NOT NULL,"+
		   "start_date_of_use date NOT NULL,"+
		   "end_of_use_date date NOT NULL,"+
		   "payment_type varchar(40) NOT NULL,"+
		   "number_of_people int NOT NULL,"+
		   "primary key(reservation_num)"+
		") DEFAULT CHARACTER SET UTF8;",
		
		"drop table if exists reservation_cancellation;",
		"create table reservation_cancellation("+
		   "reservation_cancellation_num int NOT NULL AUTO_INCREMENT,"+	//���� �ڵ� ������
		   "cancellation_charge int NOT NULL,"+
		   "cancellation_date date NOT NULL,"+
		   "hotel_name varchar(40) NOT NULL,"+
		   "room_num int NOT NULL,"+
		   "c_id varchar(40) NOT NULL,"+
		   "reserve_date date NOT NULL,"+
		   "start_date_of_use date NOT NULL,"+
		   "end_of_use_date date NOT NULL,"+
		   "payment_type varchar(40) NOT NULL,"+
		   "number_of_people int NOT NULL,"+
		   "primary key(reservation_cancellation_num)"+
		") DEFAULT CHARACTER SET UTF8;"
	};
	static String[] insertDefaultDataSqls= {
			"insert into customer values('guest1', '" + Hash.SHA256("passwd6") + "', '������', '010-1111-1111', 'nsy1111@gmail.com');",
			"insert into customer values('guest2', '" + Hash.SHA256("passwd7") + "', '�̸��', '010-1234-1171', 'emr1111@gmail.com');",
			"insert into customer values('guest3', '" + Hash.SHA256("passwd8") + "', '�ֿ���', '010-5678-1311', 'cyj1111@gmail.com');",
			"insert into customer values('guest4', '" + Hash.SHA256("passwd9") + "', '������', '010-3344-1181', 'jsr1111@gmail.com');",
			"insert into customer values('guest5', '" + Hash.SHA256("passwd10") + "', '���̸�', '010-1566-1112', 'mmr1111@gmail.com');",
			
			"insert into hotel_owner values('owner1', '" + Hash.SHA256("passwd1") + "', 'ȫ�浿', '010-1111-1111', '123456-1234567');",
			"insert into hotel_owner values('owner2', '" + Hash.SHA256("passwd2") + "', '����ȣ', '010-1111-1111', '123456-1234567');",
			"insert into hotel_owner values('owner3', '" + Hash.SHA256("passwd3") + "', '������', '010-1111-1111', '123456-1234567');",
			"insert into hotel_owner values('owner4', '" + Hash.SHA256("passwd4") + "', '������', '010-1111-1111', '123456-1234567');",
			"insert into hotel_owner values('owner5', '" + Hash.SHA256("passwd5") + "', '������', '010-1111-1111', '123456-1234567');",
			
			"insert into hotel values('��߽� ȣ�� �λ�', '�λ걤���� ������ ��������� 82', '010-1111-1111', 5, 'owner1', '2015-10-29');",
			"insert into hotel values('��ư ������ ���� ����', '����Ư���� ���ʱ� ������� 253', '010-1111-1111', 5, 'owner2', '2015-11-09');",
			"insert into hotel values('���� ���ǳ׽� ��ġ ȣ��', '������ ���ʽ� �ؿ����� 171', '010-1111-1111', 5, 'owner3', '2016-03-20');",
			"insert into hotel values('�Ŷ����� �Ｚ', '����Ư���� ������ ������� 506', '010-1111-1111', 5, 'owner4', '2016-05-11');",
			"insert into hotel values('ȣ�� �Ƹ���', '��⵵ ������ �ȴޱ� �ΰ��108���� 37', '010-1111-1111', 5, 'owner5', '2016-12-25');",
			
			"insert into room values('��߽� ȣ�� �λ�', 101, '2015-10-29', 2, 80000, 18);",
			"insert into room values('��߽� ȣ�� �λ�', 102, '2015-10-29', 2, 80000, 18);",
			"insert into room values('��߽� ȣ�� �λ�', 201, '2015-10-29', 2, 80000, 18);",
			"insert into room values('��߽� ȣ�� �λ�', 202, '2015-10-29', 2, 80000, 18);",
			"insert into room values('��߽� ȣ�� �λ�', 301, '2015-10-29', 2, 80000, 18);",
			"insert into room values('��߽� ȣ�� �λ�', 302, '2015-10-29', 2, 80000, 18);",
			"insert into room values('��ư ������ ���� ����', 101, '2015-11-09', 2, 120000, 22);",
			"insert into room values('��ư ������ ���� ����', 102, '2015-11-09', 2, 120000, 22);",
			"insert into room values('��ư ������ ���� ����', 103, '2015-11-09', 2, 120000, 22);",
			"insert into room values('���� ���ǳ׽� ��ġ ȣ��', 101, '2016-03-20', 3, 100000, 18);",
			"insert into room values('���� ���ǳ׽� ��ġ ȣ��', 102, '2016-03-20', 3, 100000, 18);",
			"insert into room values('�Ŷ����� �Ｚ', 101, '2016-05-11', 2, 100000, 16);",
			"insert into room values('�Ŷ����� �Ｚ', 102, '2016-05-11', 2, 100000, 16);",
			"insert into room values('�Ŷ����� �Ｚ', 201, '2016-05-11', 2, 100000, 16);",
			"insert into room values('�Ŷ����� �Ｚ', 202, '2016-05-11', 2, 100000, 16);",
			"insert into room values('ȣ�� �Ƹ���', 101, '2016-12-25', 2, 90000, 20);",
			"insert into room values('ȣ�� �Ƹ���', 102, '2016-12-25', 2, 90000, 20);",
			"insert into room values('ȣ�� �Ƹ���', 103, '2016-12-25', 2, 90000, 20);",
			
			"insert into reservation(hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date, payment_type, number_of_people) values('��߽� ȣ�� �λ�', 101, 'guest1', '2022-03-01', '2022-07-22', '2022-07-23', '�ſ�ī��', 4);",
			"insert into reservation(hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date, payment_type, number_of_people) values('��߽� ȣ�� �λ�', 101, 'guest2', '2022-03-01', '2022-07-02', '2022-07-03', '�ſ�ī��', 4);",
			"insert into reservation(hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date, payment_type, number_of_people) values('��ư ������ ���� ����', 101, 'guest2', '2022-03-01', '2022-07-22', '2022-07-23', '�ſ�ī��', 4);",
			"insert into reservation(hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date, payment_type, number_of_people) values('��ư ������ ���� ����', 101, 'guest3', '2022-03-01', '2022-07-02', '2022-07-03', '�ſ�ī��', 4);",
			"insert into reservation(hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date, payment_type, number_of_people) values('���� ���ǳ׽� ��ġ ȣ��', 101, 'guest3', '2022-03-01', '2022-07-22', '2022-07-23', '�ſ�ī��', 4);",
			"insert into reservation(hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date, payment_type, number_of_people) values('���� ���ǳ׽� ��ġ ȣ��', 101, 'guest4', '2022-03-01', '2022-07-02', '2022-07-03', '�ſ�ī��', 4);",
			"insert into reservation(hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date, payment_type, number_of_people) values('�Ŷ����� �Ｚ', 101, 'guest4', '2022-03-01', '2022-07-22', '2022-07-23', '�ſ�ī��', 4);",
			"insert into reservation(hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date, payment_type, number_of_people) values('�Ŷ����� �Ｚ', 101, 'guest5', '2022-03-01', '2022-07-02', '2022-07-03', '�ſ�ī��', 4);",
			"insert into reservation(hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date, payment_type, number_of_people) values('ȣ�� �Ƹ���', 101, 'guest5', '2022-03-01', '2022-07-22', '2022-07-23', '�ſ�ī��', 4);",
			"insert into reservation(hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date, payment_type, number_of_people) values('ȣ�� �Ƹ���', 101, 'guest1', '2022-03-01', '2022-07-02', '2022-07-03', '�ſ�ī��', 4);",
			
			"insert into reservation_cancellation(cancellation_charge, cancellation_date, hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date , payment_type, number_of_people) values(20000, '2022-03-04', '��߽� ȣ�� �λ�', 101, 'guest1', '2022-03-01', '2022-03-22', '2022-03-23', '�ſ�ī��', 3);",
			"insert into reservation_cancellation(cancellation_charge, cancellation_date, hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date , payment_type, number_of_people) values(20000, '2022-03-04', '��߽� ȣ�� �λ�', 101, 'guest2', '2022-03-01', '2022-03-22', '2022-03-23', '�ſ�ī��', 3);",
			"insert into reservation_cancellation(cancellation_charge, cancellation_date, hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date , payment_type, number_of_people) values(25000, '2022-04-04', '��ư ������ ���� ����', 101, 'guest2', '2022-04-01', '2022-04-22', '2022-04-23', '�ſ�ī��', 3);",
			"insert into reservation_cancellation(cancellation_charge, cancellation_date, hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date , payment_type, number_of_people) values(25000, '2022-04-04', '��ư ������ ���� ����', 101, 'guest3', '2022-04-01', '2022-04-22', '2022-04-23', '�ſ�ī��', 3);",
			"insert into reservation_cancellation(cancellation_charge, cancellation_date, hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date , payment_type, number_of_people) values(25000, '2022-04-04', '���� ���ǳ׽� ��ġ ȣ��', 101, 'guest3', '2022-04-01', '2022-04-22', '2022-04-23', '�ſ�ī��', 3);",
			"insert into reservation_cancellation(cancellation_charge, cancellation_date, hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date , payment_type, number_of_people) values(25000, '2022-04-04', '���� ���ǳ׽� ��ġ ȣ��', 101, 'guest4', '2022-04-01', '2022-04-22', '2022-04-23', '�ſ�ī��', 3);",
			"insert into reservation_cancellation(cancellation_charge, cancellation_date, hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date , payment_type, number_of_people) values(25000, '2022-04-04', '�Ŷ����� �Ｚ', 101, 'guest4', '2022-04-01', '2022-04-22', '2022-04-23', '�ſ�ī��', 3);",
			"insert into reservation_cancellation(cancellation_charge, cancellation_date, hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date , payment_type, number_of_people) values(25000, '2022-04-04', '�Ŷ����� �Ｚ', 101, 'guest5', '2022-04-01', '2022-04-22', '2022-04-23', '�ſ�ī��', 3);",
			"insert into reservation_cancellation(cancellation_charge, cancellation_date, hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date , payment_type, number_of_people) values(25000, '2022-04-04', 'ȣ�� �Ƹ���', 101, 'guest5', '2022-04-01', '2022-04-22', '2022-04-23', '�ſ�ī��', 3);",
			"insert into reservation_cancellation(cancellation_charge, cancellation_date, hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date , payment_type, number_of_people) values(25000, '2022-04-04', 'ȣ�� �Ƹ���', 101, 'guest1', '2022-04-01', '2022-04-22', '2022-04-23', '�ſ�ī��', 3);",
	};
	public static void main(String[] args){
		createInitialHotelDatabase();
		insertDefaultData();
		System.out.println("db initialized");
	}
	static void createInitialHotelDatabase() {
		DB.loadConnect("mysql");
		for (String sql : createDatabaseCreateTableSqls) {
			DB.executeAnyQuery(sql);
		}
	}
	static void insertDefaultData() {
		DB.loadConnect("hotelreserve");
		for (String sql : insertDefaultDataSqls) {
			DB.insertAnyQuery(sql);
		}
	}
}