var expanded = false;

function showCheckboxes(id) {
  var checkboxes = document.getElementById(id).childNodes[1];
  if (!expanded) {
    checkboxes.style.display = "block";
    expanded = true;
  } else {
    checkboxes.style.display = "none";
    expanded = false;
  }
}