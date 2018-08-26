class revWriteEvent {
	constructor(){
		this.imageFile;
		this.displayInfoId = document.querySelector("div.ct").getAttribute("data-displayInfoId");
		this.reviewContent = document.querySelector("div.review_contents");
		this.textArea = document.querySelector("textarea.review_textarea");
		this.totalTextCnt = document.querySelector("div.guide_review > span");
		this.uploadImage = document.querySelector("#reviewImageFileOpenInput");
        this.thumbImage = document.querySelector("img.item_thumb");
		this.imageItemDel = document.querySelector("span.ico_del");
		this.imageElement = document.querySelector("li.item");
		this.btnSection = document.querySelector("div.box_bk_btn");
		this.btnSection.querySelector("button").disabled = true;

	}
	
	addEventReviewContent() {
		this.reviewContent.addEventListener("click",(evt) => {
			if(evt.target.tagName === "A" || evt.target.tagName === "SPAN"){
				evt.target.closest("a").classList.add("hide");
				this.textArea.focus();
			}
		})
		
		this.textArea.addEventListener("blur",(evt) => {
			if(this.textArea.value === ""){
				evt.target.closest("div.review_contents").querySelector("a.review_write_info").classList.remove("hide");
			}
		})
		
		this.textArea.addEventListener("keyup",(evt) => {
			this.totalTextCnt.innerText = evt.target.value.length;
			valid.checkAllValid();
		})
	}
	
	addEventImageThumb(){
		this.uploadImage.addEventListener("change", (evt) => {
            const uploadImage = evt.target.files[0];
            if(!valid.checkImageValid(uploadImage)) { 
                alert("invalide image file type");
                return;
            }
            this.imageFile = uploadImage;
            this.thumbImage.src = window.URL.createObjectURL(uploadImage);
            let imageItem = evt.target.closest("div.review_write_footer_wrap").querySelector("li.item");
            imageItem.style.display = "inline-block";
        })
	}
	
	addEventDeleteThumb(){
		this.imageItemDel.addEventListener("click",(evt) => {
            this.imageElement.style.display = "none";
		})
	}
	
	addEventSendBtn(){
		this.btnSection.addEventListener("click",(evt) => {
			let formData = postForm.postFormatter();	
			ajaxHandler.sendFormDataAsPost("/api/reservationUserComments",formData)
			.then(returnData => {
				window.location.href = "/detail?id=" + this.displayInfoId;
			})
			
		})
	}
} 