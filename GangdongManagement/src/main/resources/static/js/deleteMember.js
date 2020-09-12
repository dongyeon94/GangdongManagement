
function deleteMemberConfirm(){
	var deleteMemberVal = jQuery(".deleteUser").serialize().split('&');
	var userList = [];
	
	for(var i in deleteMemberVal){
		userList.push( deleteMemberVal[i].split("=")[1] );
	}
	console.log(userList);
	var MemberData = {'member' :userList};
		$.ajax({
		type:		"POST",
		url :		"http://localhost:8080/deleteUser",
		data:		JSON.stringify(MemberData),
		contentType: "application/json; charset=UTF-8",
		dataType:	"json",
		success:function(){consle.log("success") }					
	});		
}

function deleteMemberAjax(){
		
	if(confirm("정말 삭제하시겠습니까 ?\n   ") == true){
        alert("삭제되었습니다");
        deleteMemberConfirm();
        location.reload(true);
        return true;
    }
    else{
    	alert("취소 되었습니다");
    	location.reload(true);
        return false;
    }

}

