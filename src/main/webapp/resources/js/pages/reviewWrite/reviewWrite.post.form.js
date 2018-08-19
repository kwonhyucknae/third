class reviewPostForm {
	constructor(){
		
	}
	
	postFormatter(){
		let params = {};
		params.productId = 1;
		params.reservationInfoId = 1;
		params.score = document.querySelector("div.rating").getAttribute("data-value");
		params.comment = document.querySelector("textarea.review_textarea").value;
		console.log(reviewEven.imageFile);
		params.userCommentImages=this.imageFormatter();
		return params;
	}
	
	imageFormatter(){
		let test = []
		let params = {};
		params.reservationInfoId = 1;
		params.fileName = reviewEven.imageFile.name;
		params.modifyDate = reviewEven.imageFile.lastModifiedDate;
		params.contentType = reviewEven.imageFile.type;
		console.log(params);
		test.push(params);
		return test;
	}
}