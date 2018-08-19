class starRate{
	constructor(){
		this.starRate = document.querySelector("div.rating");
		this.allInput = this.starRate.querySelectorAll("input");
	}
	
	insertStarRate(){
		this.starRate.addEventListener("click",(evt) => {
			if(evt.target.classList.contains("rating_rdo")){
				this.deleteStarRate();
				Array.from(this.allInput).some((element) => {
					element.classList.add("checked");
					element.checked = true;
					if(evt.target === element){
						this.starRate.setAttribute("data-value",element.value);
						return true;
					}
				})
			}
		})
	}
	
	deleteStarRate(){
		this.allInput.forEach((element) => {
			element.checked = false;
			element.className = "rating_rdo";
			element.classList.remove("checked");
		})
	}
}