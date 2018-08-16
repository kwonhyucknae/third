document.addEventListener("DOMContentLoaded", function() {
	
	main.getCategoryItems("/categories");
	main.getProductItems("/products");
	main.getPromotionItems("/promotions");
	
});

const main = {
		getCategoryItems : function(url){
			ajaxHandler.sendAsGet(url)
			.then(categoryData => {
				return JSON.parse(categoryData);
			})
			.then(jsonParseData => {
				mainDisplay.setCategory(jsonParseData);
			});
		},
		
		getProductItems : function(url){
			let totalCount = document.querySelector("p.event_lst_txt .pink");
			
			ajaxHandler.sendAsGet(url)
			.then(productsData => {
				return JSON.parse(productsData);
			})
			.then(jsonProductData=>{
				mainDisplay.setProductItems(jsonProductData);
				totalCount.innerText = jsonProductData.totalCount+"개";
			})
			mainEvent.addEventReadMoreBtn(url);
			mainEvent.addEventCategoryClick(url);
		},
		
		getPromotionItems : function(url){
			ajaxHandler.sendAsGet(url)
			.then(promotionData=>{		
				return JSON.parse(promotionData);
			})
			.then(jsonPromotionData=>{
				animation.addEventInfiniteSlide(jsonPromotionData.items);
			})
		}
		
}


