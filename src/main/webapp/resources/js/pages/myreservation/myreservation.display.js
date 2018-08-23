class reservDisp {
	
	constructor() {
		this.NOT_CANCEL_RESERV = 0;
		this.CANCEL_RESERV = 1;
		this.cardConfirmSection = document.querySelector("li.card.confirmed");
		this.cardUsedSection = document.querySelector("li.card.used");
		this.cardCancelSection = document.querySelector("li.card.used.cancel");
		this.confirmCardTemplate = document.getElementById("confirm-card-item");
		this.usedCardTemplate = document.getElementById("used-card-item");
		this.cancelCardTemplate = document.getElementById("cancel-card-item");
		this.categoryTab = document.querySelector("ul.summary_board");
		this.cancelPopup = document.querySelector("div.popup_booking_wrapper");
	}
	
	setCardItems(ReservInfo){
		let nowDate = new Date();
		let allCount = 0;
		let confirmCount = 0;
		let usedCount = 0;
		let cancelCount = 0;
		
		ReservInfo.forEach((element)=>{
			element.sumPrice = formatter.convertMoneyWithCommaByText(element.sumPrice);
			if(Number(element.cancelFlag) === this.CANCEL_RESERV){
				cancelCount++;
				this.cardCancelSection.innerHTML += Handlebars.compile(this.cancelCardTemplate.innerText)(element);
			}
			else if(Number(element.cancelFlag) === this.NOT_CANCEL_RESERV && element.reservationDate < nowDate.getTime()){
				usedCount++;
				this.cardUsedSection.innerHTML += Handlebars.compile(this.usedCardTemplate.innerText)(element);
				
			}else{
				confirmCount++;
				this.cardConfirmSection.innerHTML += Handlebars.compile(this.confirmCardTemplate.innerText)(element);
			}
			allCount++;	
		});
		
		this.categoryTab.querySelector("li.item:nth-child(1) span.figure").innerText = allCount;
		this.categoryTab.querySelector("li.item:nth-child(2) span.figure").innerText = confirmCount;
		this.categoryTab.querySelector("li.item:nth-child(3) span.figure").innerText = usedCount;
		this.categoryTab.querySelector("li.item:nth-child(4) span.figure").innerText = cancelCount;
	}
	
	setOnCancelPopup(dataSet){
		this.cancelPopup.querySelector("h1.pop_tit span").innerText = dataSet.description;
		this.cancelPopup.querySelector("small.sm").innerText = dataSet.openingHours;
		this.cancelPopup.style.display = "block";
		
	}
	
	setOffCancelPopup(){
		this.cancelPopup.style.display = "none";
	}
	
	hideUsedAndCancel(){
		this.cardConfirmSection.classList.remove("hide");
		this.cardUsedSection.classList.add("hide");
		this.cardCancelSection.classList.add("hide");
	}
	
	hideConfirmAndCancel(){
		this.cardConfirmSection.classList.add("hide");
		this.cardUsedSection.classList.remove("hide");
		this.cardCancelSection.classList.add("hide");
	}
	
	hideConfirmAndUsed(){
		this.cardConfirmSection.classList.add("hide");
		this.cardUsedSection.classList.add("hide");
		this.cardCancelSection.classList.remove("hide");
	}
	
	setAllItemVisible(){
		this.cardConfirmSection.classList.remove("hide");
		this.cardUsedSection.classList.remove("hide");
		this.cardCancelSection.classList.remove("hide");
	}
}