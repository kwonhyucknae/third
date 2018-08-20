const reservDis = new reservDisp();
const reservEven = new reservEvent();
const formatter = new textFormatter();

document.addEventListener("DOMContentLoaded", function() {
	
	let myEmailAddr = document.querySelector("div.ct").getAttribute("data-emailAddr");
	myreservation.getReservationInfo("/api/reservationInfos?reservationEmail=" + myEmailAddr);
	
	console.log(myEmailAddr);
});

const myreservation = {
		getReservationInfo : (url)=>{
			ajaxHandler.sendAsGet(url)
			.then(reservationInfo => {
				return JSON.parse(reservationInfo);
			})
			.then(jsonReservInfo => {
				console.log(jsonReservInfo);
				console.log(jsonReservInfo.items[0].reservationDate);
				console.log(new Date().getTime());
				reservDis.setCardItems(jsonReservInfo.items);
				reservEven.addEventCategoryTab();
				reservEven.addEventCancelBtn();
			})
		}
}