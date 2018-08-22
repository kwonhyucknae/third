class formPost {
	constructor(){
		this.productId = 1;
		this.reservationName = document.getElementById("name");
		this.reservationTel = "011";
		this.reservationEmail = "1@c";
		this.todayDate = new Date();
		this.inputPrice = document.getElementsByName("price_cnt");
	}
	
	postFormatter(){
		let params ={};
		params.productId = document.querySelector("div.preview_txt").getAttribute("data-id");
		params.displayInfoId = document.querySelector("div.ct").getAttribute("data-dpInfoId");
		params.reservationName = document.getElementById("name").value;
		params.reservationTel = document.querySelector("[name='tel']").value;
		params.reservationEmail = document.querySelector("[name='email']").value;
		params.reservationDate = this.getReservationDate();
		params.prices = this.getPrices();
		console.log("params",params);
		return params;
	}
	
	getPrices(){
		let prices = [];
		
		for(let priceNum = 0; priceNum < this.inputPrice.length; priceNum++){
			let priceIdAndCount = {};
			priceIdAndCount.productPriceId = this.inputPrice[priceNum].getAttribute("data-priceId");
			priceIdAndCount.count = this.inputPrice[priceNum].value;
			prices.push(priceIdAndCount);
		}
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