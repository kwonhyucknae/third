class formPost {
	
	postFormatter(){
		let params ={};
		params.productId = document.querySelector("div.preview_txt").getAttribute("data-id");
		params.displayInfoId = document.querySelector("div.ct").getAttribute("data-dpInfoId");
		params.reservationName = document.getElementById("name").value;
		params.reservationTel = document.querySelector("[name='tel']").value;
		params.reservationEmail = document.querySelector("[name='email']").value;
		params.reservationDate = this.getReservationDate();
		params.prices = this.getPrices();
		return params;
	}
	
	getPrices(){
		let inputPrice = document.getElementsByName("price_cnt");
		let prices = [];
		
		inputPrice.forEach((element) => {
			let priceIdAndCount = {};
			priceIdAndCount.productPriceId = element.getAttribute("data-priceId");
			priceIdAndCount.count = element.value;
			prices.push(priceIdAndCount);
		})
		
		return prices;
	}
	
	getReservationDate(){
		const YEAR = 0;
		const MONTH =1;
		const DAY = 2;
		let dateFormat = document.querySelector("p.inline_txt").innerText;
		let localDate = dateFormat.substring(0,dateFormat.indexOf(",",0)).split(".");
		
		return [localDate[YEAR],localDate[MONTH],localDate[DAY]].join('-');
	}
}