var refinfo=document.referrer;
/*許可するファイルのみ記載します*/
var permission = new Array('dmin','ddProduct','DeleteProductAction');
var total = 0;
console.log('refinfo:'+refinfo);
if (refinfo){

	for(var i=0;i < permission.length;i++){
		total += (refinfo.indexOf(permission[i]));
		console.log('total:'+total);
	}
	total = total*(-1);

	if(total == permission.length || (refinfo.indexOf('GoLoginAction') != -1)){
		window.location.href="home.jsp";
	}
	}else{
	window.location.href="home.jsp";
}