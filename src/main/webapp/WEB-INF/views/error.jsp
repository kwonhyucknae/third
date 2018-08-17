<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="description"
	content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
<title>네이버 예약</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link href="<c:url value='/resources/css/style.css'/>"
	rel="stylesheet">
</head>
<body>
	<div id="container">
		<div class="header">
			<header class="header_tit">
				<h1 class="logo">
					<a href="./main" class="lnk_logo" title="네이버"> <span
						class="spr_bi ico_n_logo">네이버</span>
					</a> <a href="./main" class="lnk_logo" title="예약"> <span
						class="spr_bi ico_bk_logo">예약</span>
					</a>
				</h1>
				<c:choose>
			    	<c:when test="${empty cookie.loginEmail.value}">
			        	<a href="./bookingLogin" class="btn_my"> 
			        	<span class="viewReservation" title="예약확인"> 예약확인</span>
						</a>
				    </c:when>
				    <c:otherwise>
				        <a href="./myreservation" class="btn_my"> 
						<span class="viewReservation" title="예약확인">${cookie.loginEmail.value}</span>
						</a>
				    </c:otherwise>
				</c:choose>
			</header>
		</div>
		<hr>
		<div class="event">
		<br/>
			<div class="section_visual">
				<div class="group_visual cursor_none">
					<h1 class ="error_text"><c:out value='${errorCode}'/></h1>
					<h2 class = "error_text"><c:out value='${msg}'/></h2>
					<div class="container_visual">
						<div>
							<div class="container_visual">
								<ul class="visual_img">
								</ul>
							</div>
							<span class="nxt_fix" style="display: none;"></span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer>
		<div class="gototop">
			<a href="#" class="lnk_top"> <span class="lnk_top_text">TOP</span>
			</a>
		</div>
		<div class="footer">
			<p class="dsc_footer">네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및
				환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
			<span class="copyright">© NAVER Corp.</span>
		</div>
	</footer>
</body>
</html>