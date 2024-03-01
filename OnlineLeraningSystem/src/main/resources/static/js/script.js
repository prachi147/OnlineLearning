console.log("this is scipt file")

const toggleSidebar = () => {
	if($(".sidebar").is(":visible")){
		// true
		// hide the side bar
		$(".sidebar").css("display","none");
		$(".content").css("margine-left","0%");
	}
	
	else{
		// false 
		// show sidebar
		$(".sidebar").css("display","block");
		$(".content").css("margine-left","20%");
		
	}
}