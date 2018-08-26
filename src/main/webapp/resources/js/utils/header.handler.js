class headerHandler{
	constructor(){
		this.header = document.querySelector("div.header");
		this.headerText = document.querySelector("span.viewReservation");
	}
	
	getCookieEmail(){
		let cookieEmail = this.header.getAttribute("data-cookie");
		return cookieEmail;
	}
	
	setHeaderEmail(){
		let cookie = this.getCookieEmail();
		if(cookie !== ""){
			this.headerText.innerText = cookie;
		}
	}
}