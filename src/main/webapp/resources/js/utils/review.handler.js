const reviewHandler = {
		
		setReview : function(displayComments,type){
			const DETAIL_PAGE = 0;
			const DETAIL_PAGE_LIMIT = 3;
			const COMMENT_HAS_NOT_IMG = 0;
						
			let commentSize = displayComments.length;
			let reviewLocation = document.querySelector("ul.list_short_review");
			
			if(type === DETAIL_PAGE){
				commentSize = Math.min(commentSize,DETAIL_PAGE_LIMIT);
			}
			
			
			for(let commentNum = 0; commentNum < commentSize; commentNum++){
				displayComments[commentNum].score = Number(displayComments[commentNum].score).toFixed(1);
				displayComments[commentNum].reservationEmail = reviewHandler.setEmailEncryption(displayComments[commentNum].reservationEmail);
				displayComments[commentNum].reservationDate = reviewHandler.setDateFormat(displayComments[commentNum].reservationDate);
				if(displayComments[commentNum].userCommentImages.length === COMMENT_HAS_NOT_IMG){
					reviewLocation.innerHTML += Handlebars.compile(document.getElementById("review-no-image").innerText)(displayComments[commentNum]);
				}else{
					reviewLocation.innerHTML += Handlebars.compile(document.getElementById("review-with-image").innerText)(displayComments[commentNum]);
				}
			}
		},
		
		setAvgScoreAndCount : function(displayInfoData){
			let gradeArea = document.querySelector("div.grade_area");
			displayInfoData.avgScorePercent = (displayInfoData.avgScore/5.0)*100;
			gradeArea.innerHTML = Handlebars.compile(document.getElementById("score-count").innerText)(displayInfoData);
			
		},
		
		setEmailEncryption : function(emailData){
			return emailData.substring(0,4)+"****";

		},
		
		setDateFormat : function(dateData){
			let date = new Date(dateData);
			date = date.toLocaleDateString().replace(/\s/g, "");
			return date;
		}
}