class reviewPostForm {
	constructor(){
		
	}
	
	postFormatter(){
		let params = {};
		params.productId = document.querySelector("div.ct").getAttribute("data-productId");
		params.reservationInfoId = document.querySelector("div.ct").getAttribute("data-reservId");
		params.score = document.querySelector("div.rating").getAttribute("data-value");
		params.comment = document.querySelector("textarea.review_textarea").value;
		console.log(reviewEven.imageFile);
		params.userCommentImages=this.imageFormatter();
		return params;
	}
	
	imageFormatter(){
		let userCommentImage = []
		let params = {};
		params.reservationInfoId = document.querySelector("div.ct").getAttribute("data-reservId");
		params.fileName = reviewEven.imageFile.name;
		params.modifyDate = reviewEven.imageFile.lastModifiedDate;
		params.contentType = reviewEven.imageFile.type;
		console.log(params);
		userCommentImage.push(params);
		return userCommentImage;
	}
} 