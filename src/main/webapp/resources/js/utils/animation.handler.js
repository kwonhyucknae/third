const animation = {
		promotionImgHTML : document.querySelector("ul.visual_img"),
		promotionLength : 0,
		slideCount : 0,
		
		addEventInfiniteSlide : function(jsonPromotionData){
			let promotionTemplate = document.getElementById("promotionItem").innerHTML;
			
			jsonPromotionData.forEach((element) => {
				animation.promotionImgHTML.innerHTML += Handlebars.compile(promotionTemplate)(element);
			})
			
			animation.promotionImgHTML.style.right="0px";
			animation.promotionLength = jsonPromotionData.length;
			let firstVisualImage = document.querySelector("ul.visual_img li:nth-child(1)");
			let cloneNode = firstVisualImage.cloneNode(true);
			animation.promotionImgHTML.appendChild(cloneNode);
			
			animation.slideShow();
		},
		
		slideShow : function(){
			setTimeout(()=>{
				animation.promotionImgHTML.style.transition="right 0.5s ease-out";
				animation.promotionImgHTML.style.right = parseInt(animation.promotionImgHTML.style.right)+parseInt(animation.promotionImgHTML.clientWidth)+"px";
				animation.slideCount++;
				if(animation.slideCount > animation.promotionLength){
					animation.slideCount = 0;
					animation.promotionImgHTML.style.transition="";
					animation.promotionImgHTML.style.right = "0px";
				}
				requestAnimationFrame(animation.slideShow);
			},1500)	
		},
		
		addEventButtonSlideImage : function(productImgLength){
			const FIRST_IMG = 0;
			const LAST_IMG = productImgLength * 100;
			let visualImg = document.querySelector("ul.visual_img");
			let cloneNode = document.querySelector("ul.visual_img li:nth-child(1)").cloneNode(true);
			visualImg.appendChild(cloneNode);
			let translateNumber = FIRST_IMG;
			
			document.querySelector("div.nxt").addEventListener("click",function(evt){
				if(translateNumber === LAST_IMG){
					visualImg.style.transition = '';
					visualImg.style.transform = "translate("+FIRST_IMG+"%)";
					translateNumber = FIRST_IMG;
				}
				setTimeout(()=>{
					translateNumber += 100;
					visualImg.style.transition = "all 0.5s ease-in";
					visualImg.style.transform = "translate(-"+translateNumber+"%)";
					animation.changeImgStartNumberText();
				},150)
			})
			
			document.querySelector("div.prev").addEventListener("click",function(evt){
				if(translateNumber === FIRST_IMG){
					visualImg.style.transition = "";
					visualImg.style.transform = "translate(-"+LAST_IMG+"%)";
					translateNumber = LAST_IMG;
				}
				setTimeout(()=>{
					translateNumber -= 100;
					let visualImg = document.querySelector("ul.visual_img");
					visualImg.style.transition = "all 0.5s ease-out";
					visualImg.style.transform = "translate(-"+translateNumber+"%)";
					animation.changeImgStartNumberText();
				},150)
			})
		},
		
		changeImgStartNumberText : function(){
			let nowImageNumber = document.querySelector("div.figure_pagination .num");
			let maxImageNumber = document.querySelector("div.figure_pagination .off > span");
			
			if(Number(maxImageNumber.innerText) > Number(nowImageNumber.innerText)){
				nowImageNumber.innerHTML = Number(nowImageNumber.innerText) + 1;
			}else{
				nowImageNumber.innerHTML = Number(nowImageNumber.innerText) - 1;
			}
		}
		
}
