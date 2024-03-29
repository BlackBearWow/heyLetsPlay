<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*, hotel.*" %>
<!DOCTYPE html>
<%
//고객 로그인이 되어있지 않으면 index페이지로 돌아감
if((session.getAttribute("loginRight") == null) || (session.getAttribute("loginRight").equals("hotelOwner")))
	response.sendRedirect("index.jsp");
%>
<html lang="ko">
   <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>호텔 선택</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
      <!-- css 순서도 우선 순위에 영향을 미침 -->
      <link rel="stylesheet" href="style.css">
      <script src="hotelReserve.js"></script>
   </head>
   <body>
      <!-- 네비게이션 바-->
      <nav class="navbar">
         <div class="navbar__logo">
            <span>&#x2600;</span> <!-- &#x : 16진수 표기-->
            <a href="index.jsp">Hey!놀자</a>
         </div>
         <ul class="navbar__menu">
            <li><a href="customerHotelSelect.jsp">호텔선택</a></li>
            <li><a href="customerReservationCheck.jsp">예약내역확인</a></li>
            <li><a href="customerReservationCancellationCheck.jsp">취소내역확인</a></li>
         </ul>
         <div class="navbar__icons">
            <a href="systemLogOut.jsp">로그아웃</a>
         </div>
      </nav>
      
      <div class="row">
         <%
         DB.loadConnect();
         Vector<Hotel> hotels = DB.selectAllHotels();
         for(Hotel hotel : hotels){
        	 out.println("<div class='col-sm-3'>");
        	 out.println("	<div class='card'>");
    	     out.println("		<img class='card-img-top' src='img/"+hotel.get_hotel_name()+".jpg' style='' alt='Card image'>");
    	     out.println("		<div class='card-body'>");
    	     out.println("			<h5 class='card-title'>"+hotel.get_hotel_name()+"</h5>");
    	     out.println("		</div>");
    	     out.println("		<ul class='list-group list-group-flush'>");
    	     out.println("			<li class='list-group-item'>주소: "+hotel.get_address()+"</li>");
    	     out.println("			<li class='list-group-item'>전화번호: "+hotel.get_phone_num()+"</li>");
    	     out.println("			<li class='list-group-item'>별점: "+hotel.get_stars()+"</li>");
    	     out.println("			<li class='list-group-item'>업주: "+DB.getHotelOwnerNameByHostId(hotel.get_h_id())+"</li>");
    	     out.println("			<li class='list-group-item'>등록일: "+hotel.get_registration_date()+"</li>");
    	     out.println("		</ul>");
    	     out.println("		<div class='card-body'>");
    	     out.println("			<a onclick='selectHotel(\""+hotel.get_hotel_name()+"\");' class='btn btn-primary'>호텔 선택</a>");
    	     out.println("		</div>");
    	     out.println("	</div>");
    	     out.println("</div>");
         }
         %>
      </div>
   </body>
</html>