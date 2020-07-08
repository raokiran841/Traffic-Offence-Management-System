
var d = new Date();
var x = d.toLocaleDateString();
var str = x.split("/");
document.getElementById("time").value = str[1] + "-" + getMnth(str[0]) + "-" + getYr(str[2]);

var user = document.getElementById("user").textContent;
document.getElementById("report").value = user;



function setPenalty(sel) {
	var msg = sel.options[sel.selectedIndex].text;
	document.getElementById("penaltyPerOffType").value = msg;
	document.getElementById("penalty").value = getValue(msg);
	var val = document.getElementById("penalty").value;
}
function getValue(item) {
	let obj = {
		"General offences" : 100,
		"Driving vehicles without valid licence" : 300,
		"Driving at excessive speed" : 200,
		"Driving dangerously" : 500,
		"Racing and trials of speed without permission" : 300,
		"Talking on mobile phone while driving" : 200,
		"Driving uninsured vehicle" : 300,
		"Driving when mentally or physically unfit to drive" : 100
	}
	return obj[item];
}


function getYr(a) {
	return parseInt(a) % 100;
}
function getMnth(num) {
	var obj = {
		1 : "JAN",
		2 : "FEB",
		3 : "MAR",
		4 : "APR",
		5 : "MAY",
		6 : "JUN",
		7 : "JUL",
		8 : "AUG",
		9 : "SEP",
		10 : "OCT",
		11 : "NOV",
		12 : "DEC"
	}
	return obj[num];
}