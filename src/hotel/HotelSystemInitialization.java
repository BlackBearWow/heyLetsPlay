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
		   "reservation_num int NOT NULL AUTO_INCREMENT,"+	//자동으로 값이 증가함
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
		   "reservation_cancellation_num int NOT NULL AUTO_INCREMENT,"+	//자동으로 값이 증가함
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
			"insert into customer values('guest1', '" + Hash.SHA256("passwd6") + "', '나수영', '010-1111-1111', 'nsy1111@gmail.com');",
			"insert into customer values('guest2', '" + Hash.SHA256("passwd7") + "', '이모라', '010-1234-1171', 'emr1111@gmail.com');",
			"insert into customer values('guest3', '" + Hash.SHA256("passwd8") + "', '최영재', '010-5678-1311', 'cyj1111@gmail.com');",
			"insert into customer values('guest4', '" + Hash.SHA256("passwd9") + "', '전새롬', '010-3344-1181', 'jsr1111@gmail.com');",
			"insert into customer values('guest5', '" + Hash.SHA256("passwd10") + "', '나미리', '010-1566-1112', 'mmr1111@gmail.com');",
			
			"insert into hotel_owner values('owner1', '" + Hash.SHA256("passwd1") + "', '홍길동', '010-1111-1111', '123456-1234567');",
			"insert into hotel_owner values('owner2', '" + Hash.SHA256("passwd2") + "', '최주호', '010-1111-1111', '123456-1234567');",
			"insert into hotel_owner values('owner3', '" + Hash.SHA256("passwd3") + "', '차승윤', '010-1111-1111', '123456-1234567');",
			"insert into hotel_owner values('owner4', '" + Hash.SHA256("passwd4") + "', '전은재', '010-1111-1111', '123456-1234567');",
			"insert into hotel_owner values('owner5', '" + Hash.SHA256("passwd5") + "', '최준혁', '010-1111-1111', '123456-1234567');",
			
			"insert into hotel values('라발스 호텔 부산', '부산광역시 영도구 봉래나루로 82', '010-1111-1111', 5, 'owner1', '2015-10-29');",
			"insert into hotel values('속초 컨피네스 비치 호텔', '강원도 속초시 해오름로 171', '010-1111-1111', 5, 'owner2', '2015-11-09');",
			"insert into hotel values('신라스테이 삼성', '서울특별시 강남구 영동대로 506', '010-1111-1111', 5, 'owner3', '2016-03-20');",
			"insert into hotel values('호텔 아르떼', '경기도 수원시 팔달구 인계로108번길 37', '010-1111-1111', 5, 'owner4', '2016-05-11');",
			"insert into hotel values('힐튼 가든인 서울 강남', '서울특별시 서초구 강남대로 253', '010-1111-1111', 5, 'owner5', '2016-12-25');",
			
			"insert into room values('라발스 호텔 부산', 101, '2015-10-29', 2, 80000, 18);",
			"insert into room values('라발스 호텔 부산', 102, '2015-10-29', 2, 80000, 18);",
			"insert into room values('라발스 호텔 부산', 201, '2015-10-29', 2, 80000, 18);",
			"insert into room values('라발스 호텔 부산', 202, '2015-10-29', 2, 80000, 18);",
			"insert into room values('라발스 호텔 부산', 301, '2015-10-29', 2, 80000, 18);",
			"insert into room values('라발스 호텔 부산', 302, '2015-10-29', 2, 80000, 18);",
			"insert into room values('속초 컨피네스 비치 호텔', 101, '2015-11-09', 2, 120000, 22);",
			"insert into room values('속초 컨피네스 비치 호텔', 102, '2015-11-09', 2, 120000, 22);",
			"insert into room values('속초 컨피네스 비치 호텔', 103, '2015-11-09', 2, 120000, 22);",
			"insert into room values('신라스테이 삼성', 101, '2016-03-20', 3, 100000, 18);",
			"insert into room values('신라스테이 삼성', 102, '2016-03-20', 3, 100000, 18);",
			"insert into room values('호텔 아르떼', 101, '2016-05-11', 2, 100000, 16);",
			"insert into room values('호텔 아르떼', 102, '2016-05-11', 2, 100000, 16);",
			"insert into room values('호텔 아르떼', 201, '2016-05-11', 2, 100000, 16);",
			"insert into room values('호텔 아르떼', 202, '2016-05-11', 2, 100000, 16);",
			"insert into room values('힐튼 가든인 서울 강남', 101, '2016-12-25', 2, 90000, 20);",
			"insert into room values('힐튼 가든인 서울 강남', 102, '2016-12-25', 2, 90000, 20);",
			"insert into room values('힐튼 가든인 서울 강남', 103, '2016-12-25', 2, 90000, 20);",
			
			"insert into reservation(hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date, payment_type, number_of_people) values('라발스 호텔 부산', 101, 'guest1', '2022-03-01', '2022-07-22', '2022-07-23', '신용카드', 4);",
			"insert into reservation(hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date, payment_type, number_of_people) values('라발스 호텔 부산', 101, 'guest2', '2022-03-01', '2022-07-02', '2022-07-03', '신용카드', 4);",
			"insert into reservation(hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date, payment_type, number_of_people) values('속초 컨피네스 비치 호텔', 101, 'guest2', '2022-03-01', '2022-07-22', '2022-07-23', '신용카드', 4);",
			"insert into reservation(hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date, payment_type, number_of_people) values('속초 컨피네스 비치 호텔', 101, 'guest3', '2022-03-01', '2022-07-02', '2022-07-03', '신용카드', 4);",
			"insert into reservation(hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date, payment_type, number_of_people) values('신라스테이 삼성', 101, 'guest3', '2022-03-01', '2022-07-22', '2022-07-23', '신용카드', 4);",
			"insert into reservation(hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date, payment_type, number_of_people) values('신라스테이 삼성', 101, 'guest4', '2022-03-01', '2022-07-02', '2022-07-03', '신용카드', 4);",
			"insert into reservation(hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date, payment_type, number_of_people) values('호텔 아르떼', 101, 'guest4', '2022-03-01', '2022-07-22', '2022-07-23', '신용카드', 4);",
			"insert into reservation(hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date, payment_type, number_of_people) values('호텔 아르떼', 101, 'guest5', '2022-03-01', '2022-07-02', '2022-07-03', '신용카드', 4);",
			"insert into reservation(hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date, payment_type, number_of_people) values('힐튼 가든인 서울 강남', 101, 'guest5', '2022-03-01', '2022-07-22', '2022-07-23', '신용카드', 4);",
			"insert into reservation(hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date, payment_type, number_of_people) values('힐튼 가든인 서울 강남', 101, 'guest1', '2022-03-01', '2022-07-02', '2022-07-03', '신용카드', 4);",
			
			"insert into reservation_cancellation(cancellation_charge, cancellation_date, hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date , payment_type, number_of_people) values(20000, '2022-03-04', '라발스 호텔 부산', 101, 'guest1', '2022-03-01', '2022-03-22', '2022-03-23', '신용카드', 3);",
			"insert into reservation_cancellation(cancellation_charge, cancellation_date, hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date , payment_type, number_of_people) values(20000, '2022-03-04', '라발스 호텔 부산', 101, 'guest2', '2022-03-01', '2022-03-22', '2022-03-23', '신용카드', 3);",
			"insert into reservation_cancellation(cancellation_charge, cancellation_date, hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date , payment_type, number_of_people) values(25000, '2022-04-04', '속초 컨피네스 비치 호텔', 101, 'guest2', '2022-04-01', '2022-04-22', '2022-04-23', '신용카드', 3);",
			"insert into reservation_cancellation(cancellation_charge, cancellation_date, hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date , payment_type, number_of_people) values(25000, '2022-04-04', '속초 컨피네스 비치 호텔', 101, 'guest3', '2022-04-01', '2022-04-22', '2022-04-23', '신용카드', 3);",
			"insert into reservation_cancellation(cancellation_charge, cancellation_date, hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date , payment_type, number_of_people) values(25000, '2022-04-04', '신라스테이 삼성', 101, 'guest3', '2022-04-01', '2022-04-22', '2022-04-23', '신용카드', 3);",
			"insert into reservation_cancellation(cancellation_charge, cancellation_date, hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date , payment_type, number_of_people) values(25000, '2022-04-04', '신라스테이 삼성', 101, 'guest4', '2022-04-01', '2022-04-22', '2022-04-23', '신용카드', 3);",
			"insert into reservation_cancellation(cancellation_charge, cancellation_date, hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date , payment_type, number_of_people) values(25000, '2022-04-04', '호텔 아르떼', 101, 'guest4', '2022-04-01', '2022-04-22', '2022-04-23', '신용카드', 3);",
			"insert into reservation_cancellation(cancellation_charge, cancellation_date, hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date , payment_type, number_of_people) values(25000, '2022-04-04', '호텔 아르떼', 101, 'guest5', '2022-04-01', '2022-04-22', '2022-04-23', '신용카드', 3);",
			"insert into reservation_cancellation(cancellation_charge, cancellation_date, hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date , payment_type, number_of_people) values(25000, '2022-04-04', '힐튼 가든인 서울 강남', 101, 'guest5', '2022-04-01', '2022-04-22', '2022-04-23', '신용카드', 3);",
			"insert into reservation_cancellation(cancellation_charge, cancellation_date, hotel_name, room_num, c_id, reserve_date, start_date_of_use, end_of_use_date , payment_type, number_of_people) values(25000, '2022-04-04', '힐튼 가든인 서울 강남', 101, 'guest1', '2022-04-01', '2022-04-22', '2022-04-23', '신용카드', 3);",
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