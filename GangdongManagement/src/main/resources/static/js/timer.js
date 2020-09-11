
checkTime();
function checkTime()
{
	var d = new Date(); 
	var currentDate = d.getFullYear() + "년 " + ( d.getMonth() + 1 ) + "월 " + d.getDate() + "일"; 
	var currentTime = d.getHours() + "시 " + d.getMinutes() + "분 " + d.getSeconds() + "초"; 
	var result = document.getElementById("today-time"); 
	result.innerHTML =  currentDate +  currentTime;			 
}		
setInterval("checkTime()",1000);
document.getElementById("currentMonth").innerHTML = ( new Date().getMonth() + 1 ) + "월 ";

