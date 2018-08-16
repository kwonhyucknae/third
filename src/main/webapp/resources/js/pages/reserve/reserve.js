const reservDisp = new reservDisplay();
const reservEvent = new reserveEvent();
const postFormat = new formPost();

document.addEventListener("DOMContentLoaded", function() {
	
	let dpInfoId = document.querySelector("div.ct").getAttribute("data-dpInfoId");
	main.getDisplayInfo("/products/" + dpInfoId);
	
	console.log(document.getElementById("name").value);
});

const main = {
		getDisplayInfo : (url) => {
			ajaxHandler.sendAsGet(url)
			.then(displayInfoData => {
				return JSON.parse(displayInfoData);
			})
			.then(jsonParsedDisplayInfoData => {
				reservDisp.setDisplayInfo(jsonParsedDisplayInfoData);
				reservDisp.setTicketBody(jsonParsedDisplayInfoData.productPrices);
				reservDisp.setHeadImage(jsonParsedDisplayInfoData);
				reservDisp.setTitle(jsonParsedDisplayInfoData.product);
				reservEvent.addEventCheckAgreeBtn();
				reservEvent.addEventTicketBodyHandler();
				reservEvent.addEventAgreementFold();
				reservEvent.addEventFormEffectiveness();
				reservEvent.addEventReservationBtn();
				postFormat.getPrices();
			});
		}
}