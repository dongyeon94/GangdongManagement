
function addMemberConfirm(){
	var addMemberVal = jQuery(".addMember").serialize();	
	var MemberData = {'member' :addMemberVal};
					
		$.ajax({
		type:		"POST",
		url :		"http://localhost:8080/signup",
		data:		JSON.stringify(MemberData),
		contentType: "application/json; charset=UTF-8",
		dataType:	"json",
		success:function(){consle.log("success") }					
	});		
}

function addMemberAjax(){
		
	if(confirm("정말 등록하시겠습니까 ?") == true){
		addMemberConfirm();
        alert("등록되었습니다");
        location.reload(true);
        return true;
    }
    else{
    	alert("취소 되었습니다");
    	location.reload(true);
        return false;
    }

}
