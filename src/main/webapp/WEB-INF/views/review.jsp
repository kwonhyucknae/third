<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
<title>네이버 예약</title>
<link href="./resources/css/style.css" rel="stylesheet">
</head>
<body>
	<div id="container">
		<div class="ct" data-dpInfoId = "${displayProductInfoId}">
			<div class="ct_wrap">
				<div class="top_title"></div>
			</div>
			<div class="section_review_list" style="padding:0;">
				<div class="review_box">
					<h3 class="title_h3">예매자 한줄평</h3>
					<div class="short_review_area">
						<div class="grade_area">
							<!-- [D] 별점 graph_value는 퍼센트 환산하여 width 값을 넣어줌 -->
						</div>
						<ul class="list_short_review">

						</ul>
					</div>
					<p class="guide">
						<i class="spr_book2 ico_bell"></i> <span>네이버 예약을 통해 실제 방문한 이용자가 남긴 평가입니다.</span>
					</p>
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
			<p class="dsc_footer">네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및 환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
			<span class="copyright">© NAVER Corp.</span>
		</div>
	</footer>
	<script type="rv-template" id="top-title">
		<a href="./detail?id={{displayInfoId}}" class="btn_back" title="이전 화면으로 이동"> <i class="fn fn-backward1"></i>
		</a>
		<h2 class="title" style="padding:0;margin:0">
		<span class="title">{{description}}</span>
		</h2>
	</script>

	<script type="rv-template" id="review-with-image">
    	<li class="list_item">
        	<div>
            	<div class="review_area">
                	<div class="thumb_area">
                     	<a href="#" class="thumb" title="이미지 크게 보기"> <img width="90" height="90" class="img_vertical_top" src="./commentImage/{{reservationInfoId}}" alt="리뷰이미지"> </a> <span class="img_count" style="display:none;">1</span>                                                </div>
                        <h4 class="resoc_name"></h4>
                        <p class="review">{{comment}}</p>
                    </div>
                	<div class="info_area">
            			<div class="review_info"> 
							<span class="grade">{{score}}</span> 
							<span class="name">{{reservationEmail}}</span> 
							<span class="date">{{reservationDate}} 방문</span> 
						</div>
                    </div>
             </div>
        </li>
    </script>
    <script type="rv-template" id="review-no-image">
        <li class="list_item">
            <div>
                <div class="review_area no_img">
                    <h4 class="resoc_name"></h4>
                    <p class="review">{{comment}}</p>
                </div>
                 <div class="info_area">
                    <div class="review_info"> 
						<span class="grade">{{score}}</span> 
						<span class="name">{{reservationEmail}}</span> 
						<span class="date">{{reservationDate}} 방문</span> 
					</div>
                   </div>
            </div>
       	</li>
    </script>
    <script type="rv-template" id="score-count">
    	<span class="graph_mask"> <em class="graph_value" style="width: {{avgScorePercent}}%;"></em> </span>
    	<strong class="text_value"> <span>{{avgScore}}</span> <em class="total">5.0</em> </strong>
    	<span class="join_count"><em class="green">{{comments.length}}</em> 등록</span>
    </script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.11/handlebars.min.js"></script>
	<script type="text/javascript" src="./resources/js/utils/ajax.handler.js"></script>
	<script type="text/javascript" src="./resources/js/utils/review.handler.js"></script>
	<script type="text/javascript" src="./resources/js/pages/review/review.display.js"></script>
	<script type="text/javascript" src="./resources/js/pages/review/review.js"></script>
</body>

</html>