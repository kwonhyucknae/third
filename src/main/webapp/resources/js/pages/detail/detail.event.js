const detailEvent = {
		
		addEventByNumberOfImages : function(imagesLength){
			if(imagesLength === 1){
				detailDisplay.hideArrow();
				detailDisplay.setImageEndNumberText();
			}else{
				animation.addEventButtonSlideImage(imagesLength);
			}
		},
		
		addEventFolded : function(){
			$("a.bk_more._open").click(()=>{
				$("a.bk_more._open").css("display","none");
				$("a.bk_more._close").css("display","block");
				$("div.store_details.close3").attr("class","store_details");
			});
			$("a.bk_more._close").click(()=>{
				$("a.bk_more._close").css("display","none");
				$("a.bk_more._open").css("display","block");
				$("div.store_details").attr("class","store_details close3");
			})
		},
		
		addEventTabAboutInfoAndLotation : function(){
			let infoTab = document.querySelector("ul.info_tab_lst");
			
			infoTab.addEventListener("click",function(evt){
				if(evt.target.tagName === "A" || evt.target.tagName === "SPAN"){
					let clickedClosestLi = evt.target.closest("li");
					document.querySelector("a.anchor.active").classList.remove("active");
					evt.target.closest("a").classList.add("active");
					
					if(clickedClosestLi.classList.contains("_detail")){
						document.querySelector("div.detail_area").classList.remove("hide");
						document.querySelector("div.detail_location").classList.add("hide");
					}else if(clickedClosestLi.classList.contains("_path")){
						document.querySelector("div.detail_area").classList.add("hide");
						document.querySelector("div.detail_location").classList.remove("hide");
					}
				}
			});
		}

}