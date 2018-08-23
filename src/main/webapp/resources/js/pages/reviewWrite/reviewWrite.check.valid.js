class checkValid {
	
	checkImageValid(image){
		const result = (
			[ 'image/jpeg',
			  'image/png',
			  'image/jpg' 
			].indexOf(image.type) > -1);
		return result;
	}
	
	checkAllValid(){
		let starRateValid = Number(reviewStar.starRate.getAttribute("data-value")) > 0;
		let textAreaValid = Number(reviewEven.textArea.value.length) >= 5;
		
		if(starRateValid && textAreaValid){
			reviewEven.btnSection.querySelector("button").disabled = false;
			reviewEven.btnSection.querySelector("button").classList.remove("disable");
		}else{
			reviewEven.btnSection.querySelector("button").disabled = true;
			reviewEven.btnSection.querySelector("button").classList.add("disable");
		}
	}
}