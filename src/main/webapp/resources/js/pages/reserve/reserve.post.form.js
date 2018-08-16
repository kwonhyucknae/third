class formPost {
	constructor(){
		this.productId = 1;
		this.reservationName = document.getElementById("name");
		this.reservationTel = "011";
		this.reservationEmail = "1@c";
		this.todayDate = new Date();
//		this.prices = [{productPriceId : 1,count : 1}];
		this.inputPrice = document.getElementsByName("price_cnt");
	}
	
	postFormatter(){
		console.log(document.getElementById("name"));
		console.log(document.querySelector("[name='tel']"));
		let params ={};
		params.productId = document.querySelector("div.preview_txt").getAttribute("data-id");
		params.reservationName = document.getElementById("name").value;
		params.reservationTel = document.querySelector("[name='tel']").value;
		params.reservationEmail = document.querySelector("[name='email']").value;
		params.reservationDate = this.randomDate(this.todayDate.getTime(),this.todayDate.getTime() + (1000*60*60*24*5));
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
	
	randomDate(startDate,endDate){
//		let endDate = new Date();
//		endDate.setDate(endDate.getDate() + 5);
		
		return new Date(startDate + Math.random() * (endDate - startDate)).toJSON().slice(0, 10);
	}
}