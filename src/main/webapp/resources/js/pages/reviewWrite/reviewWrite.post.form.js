class reviewPostForm {
	
	postFormatter(){
		let formData = new FormData();
		formData.append("productId",document.querySelector("div.ct").getAttribute("data-productId"));
		formData.append("reservationInfoId",document.querySelector("div.ct").getAttribute("data-reservId"));
		formData.append("score",document.querySelector("div.rating").getAttribute("data-value"));
		formData.append("comment",document.querySelector("textarea.review_textarea").value);
		
		if(reviewEven.imageFile !== undefined){
			formData.append("commentImageFile",reviewEven.imageFile);
		}
		
		return formData;
	}
} 