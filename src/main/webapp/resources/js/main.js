const URL = "/reservation/products";
const MAIN_START =1;
const CATEGORY_CLICK = 2;
const READ_MORE_CLICK = 3;
const DATA_LIMIT = 4;

let categoryNum = 0;
let itemStartElement;
let count = 0;

function makeCategory(data){
	let categoryTab = document.querySelector(".tab_lst_min");
	let categoryTemplate = document.getElementById("categoryItem").innerHTML;
	let categoryHTML = "";
	
	for(let dataNum = 0; dataNum < data.size;dataNum++){
		categoryHTML += categoryTemplate.replace(/{id}/gi,data.items[dataNum].id).replace(
				/{name}/gi,data.items[dataNum].name);
	}
	
	categoryTab.insertAdjacentHTML('beforeend',categoryHTML);
}


function slideShow(promotionItemsLength){
	let promotionImg = document.querySelector(".visual_img");
	let promotionLength = promotionItemsLength;
	
	setTimeout(()=>{ 
		promotionImg.style.transform='scale(1)';
		promotionImg.style.transition='right 0.5s ease-out';
		promotionImg.style.right = parseInt(promotionImg.style.right)+parseInt(promotionImg.clientWidth)+'px';
		count++;
		if(count >= promotionLength){
			count=0;
			promotionImg.style.transition='';
			promotionImg.style.right = '0px';
		}
		requestAnimationFrame(slideShow(promotionItemsLength));
	},1500)	
}

function makePromotion(data){
	
	let promotionImgHTML = document.querySelector(".visual_img");
	let promotionTemplate = document.getElementById("promotionItem").innerHTML;
	let promotionHTML = "";
	for(let dataNum = 0; dataNum < data.items.length; dataNum++){
		promotionHTML += promotionTemplate.replace(/{productId}/gi,data.items[dataNum].productId).replace(
				/{productImageId}/gi,data.items[dataNum].productImageId);
	
	}
	promotionImgHTML.style.right='0px';
	promotionImgHTML.innerHTML += promotionHTML;
	slideShow(data.items.length);
}


function makeProductItems(data,clickType) {
	let productTemplate = document.getElementById("itemList").innerHTML;
	let totalCount = document.querySelector(".event_lst_txt .pink");
	let leftSideItem = document.querySelector(".wrap_event_box ul:nth-child(even)");
	let rightSideItem = document.querySelector(".wrap_event_box ul:nth-child(odd)");
	let leftHTML = "";
	let rightHTML = "";
	
	for (let dataNum = 0; dataNum < data.products.length; dataNum++) {
		if (dataNum % 2 === 0) {
			rightHTML += productTemplate.replace(/{id}/gi, data.products[dataNum].id).replace(
					/{description}/gi, data.products[dataNum].description).replace(
					/{placeName}/gi, data.products[dataNum].placeName).replace(
					/{content}/gi, data.products[dataNum].content);
		} else {
			leftHTML += productTemplate.replace(/{id}/gi, data.products[dataNum].id).replace(
					/{description}/gi, data.products[dataNum].description).replace(
					/{placeName}/gi, data.products[dataNum].placeName).replace(
					/{content}/gi, data.products[dataNum].content);
		}		
	}

	switch(clickType){
	case MAIN_START:
		rightSideItem.innerHTML = rightHTML;
		leftSideItem.innerHTML = leftHTML;
		totalCount.innerText = data.totalCount+"개";
		break;
	case CATEGORY_CLICK:
		rightSideItem.innerHTML = rightHTML;
		leftSideItem.innerHTML = leftHTML;
		totalCount.innerText = data.totalCount+"개";
		itemStartElement.setAttribute('data-count',0);
		itemStartElement.style.display="block";
		break;
	case READ_MORE_CLICK:
		rightSideItem.insertAdjacentHTML('beforeend',rightHTML);
		leftSideItem.insertAdjacentHTML('beforeend',leftHTML);
		if(Number(itemStartElement.getAttribute('data-count')) + data.products.length >= data.totalCount){
			itemStartElement.style.display = "none";
		}
		break;
	}
}

function getCategoryAjax(categoryURL){
	let xhr = new XMLHttpRequest();
	xhr.addEventListener("load", function() {
		let data = JSON.parse(xhr.responseText);
		makeCategory(data);
	});
	xhr.open("GET", categoryURL);
	xhr.send();
}


function getPromotionAjax(promotionURL){
	let xhr = new XMLHttpRequest();
	xhr.addEventListener("load", function() {
		let data = JSON.parse(xhr.responseText);
		makePromotion(data);
	});
	xhr.open("GET", promotionURL);
	xhr.send();
}


function getProductItemsAjax(productURL,clickType) {
	let xhr = new XMLHttpRequest();
	xhr.addEventListener("load", function() {
		let data = JSON.parse(xhr.responseText);
		makeProductItems(data,clickType);
	});
	xhr.open("GET", productURL);
	xhr.send();
}


window.onload = function() {
	let tabMenu = document.querySelector(".event_tab_lst");
	let readMoreBtn = document.querySelector(".more .btn");
	
	getCategoryAjax("/reservation/categories");
	
	getProductItemsAjax(URL + "?categoryId=0",MAIN_START);
	
	getPromotionAjax("/reservation/promotions");
	
	tabMenu.addEventListener("click", function(evt) {
		let categoryElement = evt.target.closest('li');
		categoryNum = categoryElement.getAttribute('data-category');
		getProductItemsAjax(URL + "?categoryId=" + categoryNum,CATEGORY_CLICK); 
	});
	
	readMoreBtn.addEventListener("click",function(evt){
		itemStartElement = evt.target.closest('button');
		let itemStartNum = Number(itemStartElement.getAttribute('data-count')) + DATA_LIMIT;
		itemStartElement.setAttribute('data-count',itemStartNum);
		getProductItemsAjax(URL+ "?categoryId=" + categoryNum + "&start=" + itemStartNum,READ_MORE_CLICK);
	});
	
}
