<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*, hotel.*" %>
<%request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html lang="ko">
   <head>
   </head>
   <body>
   <%
   request.setCharacterEncoding("utf-8");
   int cancellation_charge = Integer.parseInt(request.getParameter("cancellation_charge"));
   
   java.util.Date date = new java.util.Date();
   java.sql.Date todayDate = new java.sql.Date(date.getTime());
   String cancellation_date = todayDate.toString();	//현재 날짜
   
   String hotel_name = request.getParameter("hotel_name");
   int room_num = Integer.parseInt(request.getParameter("room_num"));
   String start_date_of_use = request.getParameter("start_date_of_use");
   String end_of_use_date = request.getParameter("end_of_use_date");
   String payment_type = request.getParameter("payment_type");
   int number_of_people = Integer.parseInt(request.getParameter("number_of_people"));
   String reserve_date = request.getParameter("reserve_date");
   
   ReservationCancellation reservationCancellation = new ReservationCancellation(cancellation_charge, cancellation_date, hotel_name, room_num, ((Customer)session.getAttribute("customer")).get_c_id(), reserve_date, start_date_of_use, end_of_use_date, payment_type, number_of_people);
   DB.loadConnect();
   int cnt1 = DB.insertReservationCancellation(reservationCancellation);
   int cnt2 = DB.deleteReservation(hotel_name, room_num, ((Customer)session.getAttribute("customer")).get_c_id(), start_date_of_use);
   if((cnt1 == 1) && (cnt2 == 1)) {
	   response.sendRedirect("customerReservationCancellationCheck.jsp");
   }
   else {
	   out.print("<script>alert('오류가 발생했습니다'); window.history.go(-1);</script>"); return;
   }
   %>
   </body>
</html>