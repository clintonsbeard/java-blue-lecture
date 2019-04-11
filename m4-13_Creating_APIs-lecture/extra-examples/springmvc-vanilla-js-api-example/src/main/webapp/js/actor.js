document.addEventListener('DOMContentLoaded', () => {
	
	const searchForm = document.querySelector("form");
	
	searchForm.addEventListener('submit', event => {
		const searchTerm = document.querySelector("input[name='search']").value;
		loadActors(searchTerm);
		//console.table(actorList);	
		event.preventDefault();
	});

});

function loadActors(searchTerm) {
	
	fetch("http://localhost:8080/API-vanilla-JS-Example/api/actors?searchTerm=" + searchTerm)
		.then( response => {
			return response.json();
		})
		.then( actors => {
			addActorsToPage(actors);	
		})
		.catch( err => console.error(err));
}

function addActorsToPage(actorList) {
	const table = document.querySelector("table");
	
	// Delete All rows, but the first one (the header)
	for(var i = 1;i<table.rows.length;){
        table.deleteRow(i);
    }
	
	actorList.forEach(actor => {
		let row = table.insertRow(-1);
		let cell = row.insertCell(0);
		cell.innerText =  actor.firstName + " " + actor.lastName;
	});
}



