const mainDisplay = {
		setCategory : function(categoryData){
			let categoryTab = document.querySelector("ul.tab_lst_min");
			let categoryTemplate = document.getElementById("categoryItem").innerHTML;
			
			categoryData.items.forEach((element) => {
				categoryTab.innerHTML += Handlebars.compile(categoryTemplate)(element);
			})
		},
		
		setProductItems : function(productData){
			let totalCount = document.querySelector("p.event_lst_txt .pink");
			let productTemplate = document.getElementById("itemList").innerHTML;
			let leftSideItem = document.querySelector("div.wrap_event_box ul:nth-child(even)");
			let rightSideItem = document.querySelector("div.wrap_event_box ul:nth-child(odd)");
			let dataStartElement = document.querySelector("div.more .btn");

			productData.products.forEach((element,index) => {
				if(index % 2 === 0){
					rightSideItem.innerHTML += Handlebars.compile(productTemplate)(element);
				}else{
					leftSideItem.innerHTML += Handlebars.compile(productTemplate)(element);
				}
			})
					
			dataStartElement.setAttribute("data-count",Number(dataStartElement.getAttribute("data-count"))+productData.products.length);
			if(Number(dataStartElement.getAttribute("data-count")) === productData.totalCount){
				dataStartElement.style.display = "none";
			}
		},
		
		productDataInit : function(){
			let leftSideItem = document.querySelector("div.wrap_event_box ul:nth-child(even)");
			let rightSideItem = document.querySelector("div.wrap_event_box ul:nth-child(odd)");
			let dataStartElement = document.querySelector("div.more .btn");
			
			leftSideItem.innerHTML="";
			rightSideItem.innerHTML="";
			
			dataStartElement.setAttribute("data-count",0);
			dataStartElement.style.display="block";
		}
		
}