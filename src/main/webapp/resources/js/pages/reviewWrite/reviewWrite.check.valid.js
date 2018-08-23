class checkValid {
	
	constructor(){
		
	}
	
	checkImageValid(image){
		const result = (
			[
			  'image/png',
			  'image/jpg' 
			].indexOf(image.type) > -1);
		return result;
	}
	
	checkAllValid(){
		
	}
}