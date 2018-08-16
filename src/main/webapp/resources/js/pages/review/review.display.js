let reviewDisplay = {
		
		setTitle : function(displayProductData){
			document.querySelector("div.top_title").innerHTML = Handlebars.compile(document.getElementById("top-title").innerText)(displayProductData);
		}
}