const header = new headerHandler();

document.addEventListener("DOMContentLoaded", function() {
	let dpInfoId = document.querySelector("div.ct.main").getAttribute("data-dpInfoId");
	detail.getApiDataAboutDisplay("/products/" + dpInfoId);
	header.setHeaderEmail();
});

const detail ={
		
		getApiDataAboutDisplay : function(url){
			const DETAIL_PAGE = 0;
			
			ajaxHandler.sendAsGet(url)
			.then(displayInfoData => {
				return JSON.parse(displayInfoData);
			})
			.then(jsonDisplayInfoData => {
				detailDisplay.setImages(jsonDisplayInfoData);
				detailDisplay.setInfoByDisplay(jsonDisplayInfoData.product);
				detailDisplay.hideCommentMoreBtn(jsonDisplayInfoData.comments.length);
				detailEvent.addEventByNumberOfImages(jsonDisplayInfoData.productImages.length);
				detailEvent.addEventFolded();
				detailEvent.addEventTabAboutInfoAndLotation();
				reviewHandler.setReview(jsonDisplayInfoData.comments,DETAIL_PAGE);
				reviewHandler.setAvgScoreAndCount(jsonDisplayInfoData);
			}) 
		}
}
