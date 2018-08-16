const mainDisplay = {
		setCategory : function(categoryData){
			let categoryTab = document.querySelector("ul.tab_lst_min");
			let categoryTemplate = document.getElementById("categoryItem").innerHTML;
			
			for(let dataNum = 0; dataNum < categoryData.size; dataNum++){
				categoryTab.innerHTML += Handlebars.compile(categoryTemplate)(categoryData.items[dataNum]);
			}
			
		},
		
		setProductItems : function(productData){
			let totalCount = document.querySelector("p.event_lst_txt .pink");
			let productTemplate = document.getElementById("itemList").innerHTML;
			let leftSideItem = document.querySelector("div.wrap_event_box ul:nth-child(even)");
			let rightSideItem = document.querySelector("div.wrap_event_box ul:nth-child(odd)");
			let dataStartElement = document.querySelector("div.more .btn");

			
			for (let dataNum = 0; dataNum < productData.products.length; dataNum++) {
				if(dataNum % 2 === 0){
					rightSideItem.innerHTML += Handlebars.compile(productTemplate)(productData.products[dataNum]);
				}else{
					leftSideItem.innerHTML += Handlebars.compile(productTemplate)(productData.products[dataNum]);
				}
			}
					
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