document.addEventListener("DOMContentLoaded", function() {
	getCategoryItems();
	getProductItems("/reservation/products");
});


function sendAjax(url){
	return new Promise((resolve, reject) => {
	   const xhr = new XMLHttpRequest();
	   xhr.open("GET", url);
	   xhr.onload = () => resolve(xhr.responseText);
	   xhr.onerror = () => reject(xhr.statusText);
	   xhr.send();
  });
}


function getCategoryItems(){
	sendAjax("/reservation/categories")
	.then(categoryData => {
		return JSON.parse(categoryData);
	})
	.then(jsonParseData=>{
		makeCategory(jsonParseData);
		addEventCategory();
	});
	
}

function makeCategory(data){
	let categoryTab = document.querySelector(".tab_lst_min");
	let categoryTemplate = document.getElementById("categoryItem").innerHTML;
	let categoryHTML = "";
	
	for(let dataNum = 0; dataNum < data.size;dataNum++){
		console.log("dataid="+data.items[dataNum].id);
		categoryHTML += categoryTemplate.replace(/{id}/gi,data.items[dataNum].id).replace(
				/{name}/gi,data.items[dataNum].name);
	}
	
	categoryTab.insertAdjacentHTML('beforeend',categoryHTML);
}

function addEventCategory(){
	let tabMenu = document.querySelector(".event_tab_lst");
	
	tabMenu.addEventListener("click", function(evt) {
		let categoryElement = evt.target.closest('li');
		categoryNum = categoryElement.getAttribute('data-category');
		getProductItemsAjax(URL + "?categoryId=" + categoryNum,CATEGORY_CLICK); 
	});
}


function getProductItems(url){
	sendAjax(url)
	.then(productsData => {
		return JSON.parse(productsData);
	})
	.then(jsonParseData=>{
//		makeProductItems(jsonParseData);
		readMoreBtnAddEvent(jsonParseData);
	})
}

function getProductItemsByCategory(url){
	
}

function productsOfTemplate(data){
	let productTemplate = document.getElementById("itemList").innerHTML;
	console.log(data);
	
	productTemplate.replace(/{id}/gi, data.id).replace(
			/{description}/gi, data.description).replace(
			/{placeName}/gi, data.placeName).replace(
			/{content}/gi, data.content);
	
	return productTemplate;
}

function makeProductItems(data){
	let totalCount = document.querySelector(".event_lst_txt .pink");
	let leftHTML = "";
	let rightHTML = "";
	let getProductInfoMap = new Map();
	
	for (let dataNum = 0; dataNum < data.products.length; dataNum++) {
		if(dataNum % 2 === 0){
			rightHTML += productsOfTemplate(data.products[dataNum]);
		}else{
			leftHTML += productsOfTemplate(data.products[dataNum]);
		}
	}
	
	getProductInfoMap.set("rightHTML",rightHTML);
	getProductInfoMap.set("leftHTML",leftHTML);
	getProductInfoMap.set("productLength",data.products.length);
	getProductInfoMap.set("displayInfoSize",data.totalCount);
	
	return getProductInfoMap;
}

function AddEventreadMoreBtn(data){
	let readMoreBtn = document.querySelector(".more .btn");
	
	readMoreBtn.addEventListener("click",function(evt){
		itemStartElement = evt.target.closest('button');
		let itemStartNum = Number(itemStartElement.getAttribute('data-count')) + DATA_LIMIT;
		itemStartElement.setAttribute('data-count',itemStartNum);
		getProductItemsAjax(URL+ "?categoryId=" + categoryNum + "&start=" + itemStartNum,READ_MORE_CLICK);
	});
	
	
	let leftSideItem = document.querySelector(".wrap_event_box ul:nth-child(even)");
	let rightSideItem = document.querySelector(".wrap_event_box ul:nth-child(odd)");
	
	let getProductInfoMap = makeProductItems(data);
	
	rightSideItem.insertAdjacentHTML('beforeend',getProductInfoMap.get("rightHTML"));
	leftSideItem.insertAdjacentHTML('beforeend',getProductInfoMap.get("leftHTML"));
	
	changeProductStartNum(getProductInfoMap.get("productLength"));
}

function changeProductStartNum(countNum){
	let startDataCount = document.querySelector(".more .btn");
	
	startDataCount.setAttribute('data-count',Number(startDataCount.getAttribute('data-count'))+countNum);
	console.log(startDataCount.getAttribute('data-count'));
}
