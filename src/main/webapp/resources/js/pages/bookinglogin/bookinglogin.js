const formatter = new textFormatter();

document.addEventListener("DOMContentLoaded", function() {
	bookingLogin.setLoginBtnOff();
	bookingLogin.checkEmailValid();
});

const bookingLogin = {
		checkEmailValid : ()=>{
			let loginInput = document.querySelector("[name='login_email']");
			
			loginInput.addEventListener("blur",(evt) => {
				let valid = formatter.formEffectiveness("email").test(loginInput.value);
				if(valid === false){
					evt.target.closest("div").querySelector("div.warning_msg").style.visibility = "visible";
					setTimeout(() => {
						evt.target.closest("div").querySelector("div.warning_msg").style.visibility = "hidden";
					},2000)
					bookingLogin.setLoginBtnOff();
				}
			})
			
			loginInput.addEventListener("keyup",(evt) => {
				let valid = formatter.formEffectiveness("email").test(loginInput.value);
				if(valid){
					bookingLogin.setLoginBtnOn();
				}
			})
		},
		
		setLoginBtnOn : ()=>{
			let loginBtn = document.querySelector("button.login_btn");
			loginBtn.classList.remove("disabled");
			loginBtn.disabled = false;
		},
		
		setLoginBtnOff : ()=>{
			let loginBtn = document.querySelector("button.login_btn");
			loginBtn.classList.add("disabled");
			loginBtn.disabled = true;
		}
}