package hotel;

import java.sql.*;

public class HotelSystemInitialization
{	
	static String[] createDatabaseCreateTableSqls = {
		"drop database if exists hotelreserve;",
		"create database hotelreserve;",
		"use hotelreserve;",
		
		"drop table if exists ��;",
		"create table ��("+
			"G_ID varchar(40),"+
			"PW varchar(40),"+
			"�̸� varchar(40),"+
			"��ȭ��ȣ varchar(40),"+
			"�̸��� varchar(40),"+
			"primary key(G_ID)"+
		");",
		
		"drop table if exists ����;",
		"create table ����("+
		   "H_ID varchar(40),"+
		   "PW varchar(40),"+
		   "�̸� varchar(40),"+
		   "��ȭ��ȣ varchar(40),"+
		   "�ֹι�ȣ varchar(40),"+
		   "primary key(H_ID)"+
		");",
		
		"drop table if exists ȣ��;",
		"create table ȣ��("+
		   "ȣ���̸� varchar(40),"+
		   "�ּ� varchar(40),"+
		   "��ȭ��ȣ varchar(40),"+
		   "���� int,"+
		   "H_ID varchar(40),"+
		   "��ϳ�¥ date,"+
		   "primary key(ȣ���̸�)"+
		");",
		
		"drop table if exists ��;",
		"create table ��("+
		   "ȣ���̸� varchar(40),"+
		   "��ȣ�� int,"+
		   "��ϳ�¥ date,"+
		   "ħ�밳�� int,"+
		   "���� int,"+
		   "����� int,"+
		   "primary key(ȣ���̸�, ��ȣ��)"+
		");",
		
		"drop table if exists ����;",
		"create table ����("+
		   "�����ȣ int,"+
		   "ȣ���̸� varchar(40),"+
		   "��ȣ�� int,"+
		   "G_ID varchar(40),"+
		   "���೯¥ date,"+
		   "�������� date,"+
		   "��������� date,"+
		   "�������� varchar(40),"+
		   "�ο��� int,"+
		   "primary key(�����ȣ)"+
		");",
		
		"drop table if exists �������;",
		"create table �������("+
		   "������ҹ�ȣ int,"+
		   "����� int,"+
		   "��ҳ�¥ date,"+
		   "ȣ���̸� varchar(40),"+
		   "��ȣ�� int,"+
		   "G_ID varchar(40),"+
		   "���೯¥ date,"+
		   "�������� date,"+
		   "��������� date,"+
		   "�������� varchar(40),"+
		   "�ο��� int,"+
		   "primary key(������ҹ�ȣ)"+
		");"
	};
	
	public static void main(String[] args) {
		createInitialHotelDatabase();
		System.out.print("asdfasdf");
	}
	static void createInitialHotelDatabase() {
		DB.loadConnect("mysql");
		for (String sql : createDatabaseCreateTableSqls) {
			DB.executeAnyQuery(sql);
		}
	}
}