const detailDisplay = {
		
		setImages : function(displayInfoData){
			let description = displayInfoData.product.description;
			let imagesData = displayInfoData.productImages;
			let imageTemplate = document.getElementById("itemList").innerText;
			let changeTemplate = "";
			
			imagesData.forEach(function(prodImageData){
				prodImageData.description = description;
				changeTemplate += Handlebars.compile(imageTemplate)(prodImageData);
			})
			
			document.querySelector("ul.visual_img").innerHTML += changeTemplate;
		},
		
		setInfoByDisplay : function(productByDisplayId){
			document.querySelector("div.store_details").innerHTML += Handlebars.compile(document.getElementById("content").innerText)(productByDisplayId);
			document.querySelector("li.detail_info_lst").innerHTML += Handlebars.compile(document.getElementById("in-content").innerText)(productByDisplayId);
			document.querySelector("div.detail_location").innerHTML += Handlebars.compile(document.getElementById("location").innerText)(productByDisplayId);
		},
		
		setImageEndNumberText : function(){
			let imageSizeText = document.querySelector("div.figure_pagination span.off > span");
			imageSizeText.innerHTML = 1;
		},
		
		hideArrow : function(){
			document.querySelector("div.prev").className += " hide";
			document.querySelector("div.nxt").className += " hide";
		},
		
		hideCommentMoreBtn : function(displayCommentDataLength){
			const DETAIL_LIMIT = 3;
			if(displayCommentDataLength <= DETAIL_LIMIT){
				document.querySelector("a.btn_review_more").classList.add("hide");
			}
		}
		
}