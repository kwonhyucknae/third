const ajaxHandler = {
	sendAsGet : function(url){
		
		return new Promise((resolve, reject) => {
			const xhr = new XMLHttpRequest();
			xhr.open("GET", url);
			xhr.onload = () => resolve(xhr.responseText);
			xhr.onerror = () => reject(xhr.statusText);
			xhr.send();
		})
	},	

	sendAsPost : function(url, params){
		return new Promise((resolve, reject) => {
			const xhr = new XMLHttpRequest();
			xhr.open("POST", url);
			xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
			xhr.onload = () => resolve(xhr.responseText);
			xhr.onerror = () => reject(xhr.statusText);
			
			xhr.send(JSON.stringify(params));
		})
	},
	
	sendAsPut : function(url){
		
		return new Promise((resolve, reject) => {
			const xhr = new XMLHttpRequest();
			xhr.open("PUT", url);
			xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
			xhr.onload = () => resolve(xhr.responseText);
			xhr.onerror = () => reject(xhr.statusText);
			xhr.send();
		})
	}
};