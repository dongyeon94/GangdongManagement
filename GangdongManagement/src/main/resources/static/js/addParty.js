var userList = [];
var userNicknameList =[];
var partyDate = "";
var partyTimes = "";
var addPartyVal;

function addPartyConfirm()
{
	var partyData = {'datetimes' :partyDate,
			'times' : partyTimes,
			'user' : userList };

	if(partyDate.length > 1 &&  userList.length >1)
	{
		$.ajax
        ({
			type:		"POST",
			url :		"http://localhost:8080/addParty",
			data:		JSON.stringify(partyData),
			contentType: "application/json; charset=UTF-8",
			dataType:	"json",
			success:function(){ consle.log("success") }
		});
		return true;
	}
	else
	{
		return false;
	}
}

function addPartyAjax()
{
	addPartyVal = jQuery(".userchecked").serialize().split('&');

	for(var i in addPartyVal)
    {
		userList.push( addPartyVal[i].split("=")[1] );
	}

	var addPartyDateVal = jQuery(".ADDDateTimes").serialize().split('&');
	for(var i in addPartyDateVal)
    {
		var  splitLi = addPartyDateVal[i].split('=');

        if (splitLi.length >= 2)
        {
            if(splitLi[0] === 'datetimes')
            {
                partyDate = splitLi[1];
            }
            if(splitLi[0] === 'times')
            {
                partyTimes = splitLi[1];
            }
        }
        else
        {
            alert("등록에러, 입력을 확인해 주세요");
        }
	}

	var bResult = false;
	var msg = "";
	var confirmMessage = confirm("정말 등록하시겠습니까 ? \n"+ "날짜 : " + partyDate + " \n"+partyTimes+" 차 벙 \n" );

	if(true == confirmMessage)
	{
    	var confirmFlag = addPartyConfirm();

        if (true == confirmFlag)
        {
        	msg = "등록 되었습니다";
        }
        else
        {
        	msg = "등록 실패";
            bResult = true;
        }
    }
    else
    {
    	msg = "취소 되었습니디";
    }

    alert(msg);
    location.reload(true);
    return bResult;
}
