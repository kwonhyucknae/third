class textFormatter {
	
	formEffectiveness(type){
		if(type === "tel"){
			return (/^\d{3}-\d{3,4}-\d{4}$/);
		}else if(type === "email"){
			return (/^[\w+_]\w+@\w+\.\w+$/);
		}else if(type === "name"){
			return (/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣|a-z0-9_]{4,17}/);
		}
	}
	
	deleteComma(priceElement){
		return Number(priceElement.innerText.replace(/,/gi,""))
	}
	
	convertMoneyWithComma(priceElement){
		return priceElement.innerText.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	} 
	
	convertMoneyWithCommaByText(priceText){
		return priceText.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	}
}
