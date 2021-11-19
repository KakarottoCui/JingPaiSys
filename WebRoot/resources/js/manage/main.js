function switchSysBar(){
	if(switchPoint.innerText==3){
		switchPoint.innerText=4
		document.all("frmtitle").style.display="none"
	}else{
		switchPoint.innerText=3
		document.all("frmtitle").style.display=""
	}
}

function switchSysBarInfo(){
	switchPoint.innerText=3
	document.all("frmtitle").style.display=""
}

$(document).ready(function(){
	$(".sort dt").click(function(){
		if($(this).hasClass('current')){
			$(this).removeClass('current');
			$(this).next('dd').hide();
		}else{
			$(this).addClass('current');
			$(this).next('dd').show();
		}
	});
});