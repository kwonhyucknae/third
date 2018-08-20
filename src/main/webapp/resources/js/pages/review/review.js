document.addEventListener("DOMContentLoaded", function() {
	let dpInfoId = document.querySelector("div.ct").getAttribute("data-dpInfoId");	
	review.getAllReview("/products/" + dpInfoId);
});


const review = {
		
		getAllReview : function(url){
			const REVIEW_PAGE = 1;
			ajaxHandler.sendAsGet(url)
			.then(displayInfoData => {
				return JSON.parse(displayInfoData);
			})
			.then(jsonDisplayInfoData => {
				console.log(jsonDisplayInfoData);
				reviewHandler.setReview(jsonDisplayInfoData.comments,REVIEW_PAGE);
				reviewHandler.setAvgScoreAndCount(jsonDisplayInfoData);
				reviewDisplay.setTitle(jsonDisplayInfoData.product);
				
			})
		}
}