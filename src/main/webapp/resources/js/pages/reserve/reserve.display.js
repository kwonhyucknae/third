const formatter = new textFormatter();

class reservDisplay {
	constructor(){
		this.FIRST_ITEM = 0;
		this.titleElement = document.querySelector("div.top_title span.title");
		this.ticketBody = document.querySelector("div.ticket_body");
		this.detailInfo = document.querySelector("div.store_details");
		this.productImage = document.querySelector("ul.visual_img");
		this.ticketBodyTemplate = document.getElementById("ticket-body");
		this.displayInfoTemplate = document.getElementById("displayInfo");
		this.imageTemplate = document.getElementById("head-image");
		this.reservBtn = document.querySelector("div.bk_btn_wrap");
		this.reservBtn.querySelector("button").disabled = true;
	}
	
	setTitle(jsonDisplayProductData){
		this.titleElement.innerHTML = jsonDisplayProductData.description;
	}
	
	setTicketBody(jsonDisplayPrice) {
		
		for(let priceCount = 0; priceCount < jsonDisplayPrice.length; priceCount++){
			jsonDisplayPrice[priceCount].priceWithComma = formatter.convertMoneyWithCommaByText(jsonDisplayPrice[priceCount].price);
			this.ticketBody.innerHTML += Handlebars.compile(this.ticketBodyTemplate.innerText)(jsonDisplayPrice[priceCount]);
		}
	}
	
	setDisplayInfo(jsonDisplayData){
		jsonDisplayData.product.price = this.setPrice(jsonDisplayData.productPrices);
		this.detailInfo.innerHTML = Handlebars.compile(this.displayInfoTemplate.innerText)(jsonDisplayData.product);
	}
	
	setPrice(jsonDisplayPrice) {
		let priceText = "";
		
		for(let priceCount = 0; priceCount < jsonDisplayPrice.length; priceCount++){
			priceText += jsonDisplayPrice[priceCount].priceTypeName + " 타입 : " + jsonDisplayPrice[priceCount].price + "원 "; 
		}
		return formatter.convertMoneyWithCommaByText(priceText);
	}
	
	setHeadImage(jsonDisplayData){
		jsonDisplayData.product.lowPrice = this.checkHighOrLowDisplayPrice(jsonDisplayData.productPrices).get("low");
		jsonDisplayData.product.highPrice = this.checkHighOrLowDisplayPrice(jsonDisplayData.productPrices).get("high");
		
		this.productImage.innerHTML = Handlebars.compile(this.imageTemplate.innerText)(jsonDisplayData.product);
	}
	
	setOnTextColor(selectElement){
		selectElement.querySelector("a.ico_minus3").classList.remove("disabled");
		selectElement.querySelector("a.ico_minus3").style.cursor = "pointer";
		selectElement.querySelector("input.count_control_input").classList.remove("disabled");
		selectElement.querySelector("div.individual_price").classList.add("on_color");
	}
	
	setOffTextColor(selectElement){
		selectElement.querySelector("a.ico_minus3").classList.add("disabled");
		selectElement.querySelector("a.ico_minus3").style.cursor = "default";
		selectElement.querySelector("input.count_control_input").classList.add("disabled");
		selectElement.querySelector("div.individual_price").classList.remove("on_color");
	}
	
	setOnReserveBtn(){
		this.reservBtn.classList.remove("disable");
		this.reservBtn.querySelector("button").disabled = false;
	}
	setOffReserveBtn(){
		this.reservBtn.classList.add("disable");
		this.reservBtn.querySelector("button").disabled = true;
	}
	
	checkHighOrLowDisplayPrice(jsonPriceData){
		let lowPrice = jsonPriceData[this.FIRST_ITEM].price;
		let highPrice = jsonPriceData[this.FIRST_ITEM].price;
		let priceHighOrLow = new Map();
		
		for(let count = 0; count < jsonPriceData.length; count++){
			if(Number(lowPrice) > Number(jsonPriceData[count].price)){
				lowPrice = jsonPriceData[count].price;
			}
			if(Number(highPrice) < Number(jsonPriceData[count].price)){
				highPrice = jsonPriceData[count].price;
			}
		}
		
		priceHighOrLow.set("high",formatter.convertMoneyWithCommaByText(highPrice));
		priceHighOrLow.set("low",formatter.convertMoneyWithCommaByText(lowPrice));
		
		return priceHighOrLow;
	}
}

