

function addPartyConfirm(){	
	var addPartyVal = jQuery(".userchecked").serialize().split('&');
	var userList = [];
	var partyDate = "";
	var partyTimes = "";
	
	for(var i in addPartyVal){
		userList.push( addPartyVal[i].split("=")[1] );
	}
					
	var addPartyDateVal = jQuery(".ADDDateTimes").serialize().split('&');
	for(var i in addPartyDateVal){
		var  splitLi = addPartyDateVal[i].split('=');
		if(splitLi[0]==='datetimes'){
			if(splitLi.length>1){
				partyDate =splitLi[1];
				console.log(partyDate);
			}	
			else{
				alert("please write date");
			}
		}
		if(splitLi[0]==='times'){
			if(splitLi.length>1){
				partyTimes = splitLi[1];
				console.log(partyTimes);
			}
			else{
				alert("please write times");				
			}
		}					
	}
	
	var partyData = {'datetimes' :partyDate,
			'times' : partyTimes,
			'user' : userList };
	console.log(userList);
	console.log(userList.length);
	if(partyDate.length > 1 &&  userList.length >1)
	{
		$.ajax({
			type:		"POST",
			url :		"http://localhost:8080/addParty",
			data:		JSON.stringify(partyData),
			contentType: "application/json; charset=UTF-8",
			dataType:	"json",
			success:function(){consle.log("success") }
				
			});			
		return true;	
	}
	else
	{
		return false;
	}	
}

function addPartyAjax(){
	if(confirm("정말 등록하시겠습니까 ?") == true){
        
		var confirmFlag = addPartyConfirm();
        if (confirmFlag==true)
        {
        	alert("등록되었습니다");
        	location.reload(true);
        }
        else
        {
        	alert("등록에 실패하였습니다.");
            location.reload(true);
            return true;	
        }      
    }
    else{
    	alert("취소 되었습니다");
    	location.reload(true);
        return false;
    }						
}
