const mainEvent = {
		
		addEventReadMoreBtn : function(url){
			let readMoreBtn = document.querySelector("div.more .btn");
			
			readMoreBtn.addEventListener("click",function(evt){
				let itemStartElement = evt.target.closest("button");
				let itemStartNum = itemStartElement.getAttribute("data-count");
				let categoryTab = document.querySelector("ul.event_tab_lst");
				let categoryNum = categoryTab.getAttribute("data-clickedCategory");
				
				ajaxHandler.sendAsGet(url + "?categoryId=" + categoryNum + "&start=" + itemStartNum)
				.then(productData => {
					return JSON.parse(productData);
				})
				.then(jsonProductData => {
					mainDisplay.setProductItems(jsonProductData);
				});
			});
		},
		
		addEventCategoryClick : function(url){
			let tabMenu = document.querySelector("ul.event_tab_lst");
			let totalCount = document.querySelector("p.event_lst_txt .pink");
			
			tabMenu.addEventListener("click", function(evt) {
				if(evt.target.tagName === "A" || evt.target.tagName === "SPAN"){
					let categoryElement = evt.target.closest("li");
					let categoryTab = evt.target.closest("ul");
					let clickedTab = evt.target.closest("a");
					let categoryId = categoryElement.getAttribute("data-category");
					
					categoryTab.setAttribute("data-clickedCategory",categoryId);
					mainDisplay.productDataInit();
					mainEvent.changeActiveTab(clickedTab);
					
					ajaxHandler.sendAsGet(url + "?categoryId=" + categoryId)
					.then(productData=>{
						return JSON.parse(productData);
					})
					.then(jsonProductData=>{
						mainDisplay.setProductItems(jsonProductData);
						totalCount.innerText = jsonProductData.totalCount+"개";
					});
				}
			});
		},
		
		changeActiveTab : function(clickedTab){
			let beforeClickedTab = document.querySelector("li .active");
			beforeClickedTab.className = "anchor";
			clickedTab.className = "anchor active";
		}
		
}