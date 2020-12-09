

$(function () {
  	var isLogined = false;

	if(!isLogined){
		$("a#viewlist").hide();
		$("a#login").show();
		}else{
		$("a#viewlist").show();
		$("a#login").hide();	
		}

});

function clickNavHome() {
    $(".main").load("jsp/home.jsp");
}

function clickNavList() {
    $(".main").load("jsp/viewlist.jsp");
}

function clickNavLogin() {
    location.replace("./login")
}