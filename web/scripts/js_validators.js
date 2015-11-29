function callServlet(form, button) {
    var href = "/person?action=" + button.text;

    var checkedItems = "";
    var items = form.getElementsByClassName('checkbox');
    for (var i = 0; i < items.length; i++) {
        var elt = items[ i ];
        if (elt.checked) {
            checkedItems += elt.value + ",";
        }
    }
    if(checkedItems != "") {
        button.href = href + "&personId=[" + checkedItems + "]";
    } else {
        alert("pls, check any item to " + button.text );
    }

}

function selectRow(checkbox, event) {
}


function selectAllChecks(form, checkbox) {

    document.getElementById()
    form.getElementById("ad").style.color

    var items = form.getElementsByClassName('checkbox');
    if (checkbox.checked) {
        for (var i = 0; i < items.length; i++) {
            var elt = items[ i ];
            if (!elt.checked) {
                elt.checked = true;
            }
        }
    }
    else {
        for (var i = 0; i < items.length; i++) {
            var elt = items[ i ];
            if (elt.checked) {
                elt.checked = false;
            }
        }
    }
}


function js_validator(){

}