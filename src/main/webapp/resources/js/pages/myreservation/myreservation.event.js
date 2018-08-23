class reservEvent {
	constructor(){
		this.categoryTab = document.querySelector("ul.summary_board");
		this.confirmSection = document.querySelector("li.card.confirmed");
		this.cancelSection = document.querySelector("li.card.used.cancel");
		this.cancelPopup = document.querySelector("div.popup_booking_wrapper");
	}
	
	addEventCancelBtn(){
		this.confirmSection.addEventListener("click",(evt) => {
			if(evt.target.closest("button").classList.contains("reserv_cancel")){
				let reservInfoId = evt.target.closest("div.card_detail").querySelector("em.booking_number").innerText;
				reservInfoId = reservInfoId.replace("No.","");
				let dataSet = {};
				dataSet.reservInfoId = reservInfoId;
				dataSet.description = evt.target.closest("div.card_detail").querySelector("h4.tit").innerText;
				dataSet.openingHours = evt.target.closest("div.card_detail").querySelector("em.item_dsc").innerText;
				document.querySelector("div.ct").setAttribute("data-checkCancelId",reservInfoId);
				
				reservDis.setOnCancelPopup(dataSet);
				
			}
		})
	}
	
	addEventCancelPopup(){
		this.cancelPopup.addEventListener("click",(evt) => {
			if(evt.target.closest("div").className === "btn_green"){
				let allConfirmArticle = this.confirmSection.querySelectorAll("article.card_item");
				let cancelArticle;
				let reservId;
				
				for(let article in allConfirmArticle){
					reservId= allConfirmArticle[article].querySelector("em.booking_number").innerText;
					reservId = reservId.replace("No.","");
					if(reservId === document.querySelector("div.ct").getAttribute("data-checkCancelId")){
						cancelArticle = allConfirmArticle[article];
						break;
					}
				}
				
				ajaxHandler.sendAsPut("/api/reservationInfos/"+reservId)
				.then(()=>{
					this.cancelSection.appendChild(cancelArticle);
				});
			
			}else if(evt.target.closest("div").className === "btn_gray"){
				reservDis.setOffCancelPopup();
			}
		})
	}
	
	addEventCategoryTab(){
		this.categoryTab.addEventListener("click",(evt) => {
			let beforeSelectedTab = document.querySelector("a.link_summary_board.on");
			let categoryItem = evt.target.closest("li.item")
			let selectedCategory = "";
			beforeSelectedTab.classList.remove("on");
			categoryItem.querySelector("a.link_summary_board").classList.add("on");
			selectedCategory = categoryItem.querySelector("i").className.replace("spr_book2 ","");
			console.log(selectedCategory);
			
			if(selectedCategory === "ico_book2"){
				reservDis.setAllItemVisible();
			}else if(selectedCategory === "ico_book_ss"){
				reservDis.hideUsedAndCancel();
			}else if(selectedCategory === "ico_check"){
				reservDis.hideConfirmAndCancel();
			}else if(selectedCategory === "ico_back"){
				reservDis.hideConfirmAndUsed();
			}
		})
	}
	
}