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
	
	sendImageFileAsPost : function(url, images){
		return new Promise((resolve, reject) => {
			const xhr = new XMLHttpRequest();
			let formData = new FormData();
			formData.append("file",images);
			
			xhr.open("POST", url);
			xhr.onload = () => resolve(xhr.responseText);
			xhr.onerror = () => reject(xhr.statusText);
			
			xhr.send(formData);
		})
	},
	
	sendAsTest : function(url, params){
		return new Promise((resolve, reject) => {
			const xhr = new XMLHttpRequest();
			
			xhr.open("POST", url);
//			xhr.setRequestHeader('Content-type','multipart/form-data; boundary=something');
			xhr.onload = () => resolve(xhr.responseText);
			xhr.onerror = () => reject(xhr.statusText);
			
			xhr.send(params);
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