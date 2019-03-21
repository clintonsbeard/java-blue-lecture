const colors = document.getElementById("colors");
colors.addEventListener("click", event => {
  if (event.target.nodeName.toLowerCase() === "li") {
    event.target.style.backgroundColor = event.target.innerText;
  }
});

function addOrange() {
	const orange = document.createElement('li');
	orange.innerText = 'Orange';
	colors.appendChild(orange);
}

document.addEventListener('DOMContentLoaded', () => {
	const button = document.getElementById('btnAddOrange');
	button.addEventListener('click', addOrange);
});