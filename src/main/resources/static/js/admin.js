alert("admin connected");
function edit(k) {
		alert("++>> "+k);
	var parent = document.getElementById(k).parentElement.parentElement;
	for (var i = 1; i<parent.childElementCount; i++) {
		var v = parent.children[i].children[0].className;
		if(v.endsWith('pp')){
			if(parent.children[i].children[0].disabled == false){
				parent.children[i].children[0].disabled = true;
			}else{
				parent.children[i].children[0].disabled = false;
			}
		}
	}
	if(document.getElementById(k).innerHTML == 'Edit'){
		document.getElementById(k).innerHTML = 'Cancel';
		document.getElementById("s"+k).disabled = false;
	}else{
		document.getElementById(k).innerHTML = 'Edit';
		document.getElementById("s"+k).disabled = true;
	}
}