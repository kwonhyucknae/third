class reserveEvent {
	
	constructor() {
		this.ticketBody = document.querySelector("div.ticket_body");
		this.totalCount =document.querySelector("#totalCount"); 
		this.name = document.querySelector("[name='name']");
		this.email = document.querySelector("[name='email']");
		this.tel = document.querySelector("[name='tel']");
		this.checkAgreeBtn = document.querySelector("input.chk_agree");
		this.reservBtn = document.querySelector("div.bk_btn_wrap");
		this.agreementFold = document.querySelector("div.section_booking_agreement");
	}
	
	addEventTicketBodyHandler(){
		this.ticketBody.addEventListener("click",function(evt){
			if(evt.target.classList.contains("ico_minus3")){
				this.addEventClickedMinusBtn(evt.target.closest("div.qty"));
			}
			if(evt.target.classList.contains("ico_plus3")){
				this.addEventClickedPlusBtn(evt.target.closest("div.qty"));
			}
		}.bind(this))
		
	}
	
	addEventClickedPlusBtn(selectElement){
		let inputBox = selectElement.querySelector("input");
		if(Number(inputBox.value) === 0){
			reservDisp.setOnTextColor(selectElement);
		}
		
		let price = selectElement.querySelector("span.price");
		let totalPrice = selectElement.querySelector("span.total_price");
		totalPrice.innerText = formatter.deleteComma(totalPrice) + formatter.deleteComma(price);
		totalPrice.innerText = formatter.convertMoneyWithComma(totalPrice);
		inputBox.value = Number(inputBox.value) + 1; 
		totalCount.innerText = Number(this.totalCount.innerText) + 1;
		this.checkAllValid();
	}
	
	addEventClickedMinusBtn(selectElement){
		let inputBox = selectElement.querySelector("input");
		if(Number(inputBox.value) === 1){
			reservDisp.setOffTextColor(selectElement);
		}
		
		if(Number(inputBox.value) !== 0){
			let price = selectElement.querySelector("span.price");
			let totalPrice = selectElement.querySelector("span.total_price");
			totalPrice.innerText = formatter.deleteComma(totalPrice) - formatter.deleteComma(price);
			totalPrice.innerText = formatter.convertMoneyWithComma(totalPrice);
			inputBox.value = Number(inputBox.value) - 1; 
			totalCount.innerText = Number(this.totalCount.innerText) - 1;
		}
		this.checkAllValid();
	}
	
	addEventCheckAgreeBtn(){
		let inputCheckBtn = document.querySelector("input.chk_agree");
		
		inputCheckBtn.addEventListener("click",function(evt){
			this.checkAllValid();
		}.bind(this))
	}
	
	addEventFormEffectiveness(){
		let checkNameData = this.checkFormEffectiveness(this.name, "name");
		let checkTelData = this.checkFormEffectiveness(this.tel, "tel");
		let checkEmailData = this.checkFormEffectiveness(this.email, "email");
	}
	
	addEventAgreementFold(){
		this.agreementFold.addEventListener("click",function(evt){
			if(evt.target.className === "btn_text"){
				if(evt.target.innerText === "보기"){
					let agreement = evt.target.closest("div.agreement");
					agreement.classList.add("open");
					agreement.querySelector("i.fn").classList.remove("fn-down2");
					agreement.querySelector("i.fn").classList.add("fn-up2");					
					evt.target.innerText = "접기";
				} else if(evt.target.innerText === "접기"){
					let agreement = evt.target.closest("div.agreement");
					agreement.classList.remove("open");
					agreement.querySelector("i.fn").classList.remove("fn-up2");
					agreement.querySelector("i.fn").classList.add("fn-down2");					
					evt.target.innerText = "보기";
				}
			}
		})
	}
	
	addEventReservationBtn(){
		let reservationBtn = document.querySelector(".bk_btn");
		reservationBtn.addEventListener("click",function(evt){
			let params = postFormat.postFormatter();
			console.log(params);
			ajaxHandler.sendAsPost("/api/reservationInfos",params)
			.then(returnData => {
				console.log(returnData);
				window.location.href = "/main";
			})
		})
	}
	
	checkFormEffectiveness(inputData,type){
		inputData.addEventListener("blur",function(evt){
			let inputDataValue = inputData.value;
			let valid = formatter.formEffectiveness(type).test(inputDataValue);
			if(valid){
				inputData.setAttribute("data-check", true);
				this.checkAllValid();
			}else{
				evt.target.closest("div").querySelector(".warning_msg").style.visibility = "visible";
				setTimeout(() => {
					evt.target.closest("div").querySelector(".warning_msg").style.visibility = "hidden";
				},2000)
				inputData.setAttribute("data-check", false);
				this.checkAllValid();
			}
			evt.stopPropagation();
		}.bind(this))
	}
	
	checkAllValid(){
		let checkName = this.name.getAttribute("data-check");
		let checkTel = this.tel.getAttribute("data-check");
		let checkEmail = this.email.getAttribute("data-check");
		let checkCount = Number(this.totalCount.innerText);
		let checkAgreeBtn = this.checkAgreeBtn.checked;
		
		if(checkName === "true" && checkTel === "true" && checkEmail === "true" && checkAgreeBtn === true && checkCount > 0){
			reservDisp.setOnReserveBtn();
		}else{
			reservDisp.setOffReserveBtn();
		}
	}
} 