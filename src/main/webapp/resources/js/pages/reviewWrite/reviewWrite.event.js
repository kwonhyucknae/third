class revWriteEvent {
	constructor(){
		this.imageFile;
	}
	
	addEventReviewContent() {
		let reviewContent = document.querySelector("div.review_contents");
		let textArea = document.querySelector("textarea.review_textarea");
		reviewContent.addEventListener("click",(evt) => {
			if(evt.target.tagName === "A" || evt.target.tagName === "SPAN"){
				evt.target.closest("a").classList.add("hide");
				textArea.focus();
			}
		})
		
		textArea.addEventListener("blur",(evt) => {
			if(document.querySelector("textarea.review_textarea").value === ""){
				evt.target.closest("div.review_contents").querySelector("a.review_write_info").classList.remove("hide");
			}
		})
		
		textArea.addEventListener("keyup",(evt) => {
			document.querySelector("div.guide_review > span").innerText = evt.target.value.length;
		})
	}
	
	addEventImageThumb(){
		let uploadImage = document.querySelector("#reviewImageFileOpenInput");
		uploadImage.addEventListener("change", (evt) => {
            const image = evt.target.files[0];
//            if(!valideImageType(image)) { 
//                console.warn("invalide image file type");
//                return;
//            }
            this.imageFile = image;
            const thumbImage = document.querySelector(".item_thumb");
            thumbImage.src = window.URL.createObjectURL(image);
            let imageItem = evt.target.closest("div.review_write_footer_wrap").querySelector("li.item");
            imageItem.style.display = "inline-block";
        })
	}
	
	addEventDeleteThumb(){
		let imageItemDel = document.querySelector("span.ico_del");
		
		imageItemDel.addEventListener("click",(evt) => {
			let imageItem = document.querySelector("li.item");
            imageItem.style.display = "none";
		})
	}
	
	addEventSendBtn(){
		let btnSection = document.querySelector("div.box_bk_btn");
		btnSection.addEventListener("click",(evt) => {
			let uploadImage = this.imageFile;
			let params = postForm.postFormatter();
			ajaxHandler.sendImageFileAsPost("/api/reservationUserComments/image",uploadImage)
			
			ajaxHandler.sendAsPost("/api/reservationUserComments",params)
			.then(returnData => {
				console.log(returnData);
			})			
		})
	}
}