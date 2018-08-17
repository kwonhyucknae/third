class reservEvent {
	constructor(){
		this.categoryTab = document.querySelector("ul.summary_board");
		this.confirmSection = document.querySelector("li.card.confirmed");
		this.cancelSection = document.querySelector("li.card.used.cancel");
	}
	
	addEventCancelBtn(){
		this.confirmSection.addEventListener("click",(evt) => {
			if(evt.target.classList.contains("reserv_cancel")){
				let checkOk = confirm("취소하시겠습니까?");
				if(checkOk){
					this.cancelSection.appendChild(evt.target.closest("article.card_item"));
					evt.target.closest("div.booking_cancel").classList.add("hide");
					let reservInfoId = evt.target.closest("div.card_detail").querySelector("em.booking_number").innerText;
					reservInfoId = reservInfoId.replace("No.","");
					ajaxHandler.sendAsPut("/api/reservationInfos/"+reservInfoId);
				}
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
			selectedCategory = categoryItem.querySelector("em").innerText;
			
			if(selectedCategory === "전체"){
				reservDis.setAllItemVisible();
			}else if(selectedCategory === "이용예정"){
				reservDis.hideUsedAndCancel();
			}else if(selectedCategory === "이용완료"){
				reservDis.hideConfirmAndCancel();
			}else if(selectedCategory === "취소·환불"){
				reservDis.hideConfirmAndUsed();
			}
		})
	}
	
	
}