/*
* Add Events and functions to move the Ship and Win the game
*/

// Creates the Grid -- this should only occur after the DOM loads
document.addEventListener('DOMContentLoaded', () => {
    createGrid();
    document.querySelector('body').addEventListener('keyup', (event) => {
        if (event.key === 'ArrowRight') {
            moveShipRight();
<<<<<<< HEAD
        }
        if (event.key === 'ArrowLeft') {
            moveShipLeft();
        }
        if (event.key === 'ArrowUp') {
            moveShipUp();
        }
        if (event.key === 'ArrowDown') {
            moveShipDown();
        }
    })
});

function moveShipRight() {
    const ship = getShipLocation();
    const right = ship.nextElementSibling;
    moveShip(ship, right);
}

function moveShipLeft() {
    const ship = getShipLocation();
    const left = ship.previousElementSibling;
    moveShip(ship, left);
}

function moveShipDown() {
    const ship = getShipLocation();
    const down = getUpperOrLowerElementAtIndex(ship, ship.parentElement.nextElementSibling);
    moveShip(ship, down);
}

function moveShipUp() {
    const ship = getShipLocation();
    const up = getUpperOrLowerElementAtIndex(ship, ship.parentElement.previousElementSibling);
    moveShip(ship, up);
=======
        }    
        if (event.key === 'ArrowLeft') {
            moveShipLeft();
        }
        if (event.key === 'ArrowDown') {
            moveShipDown();
        }
        if (event.key === 'ArrowUp') {
            moveShipUp();
        }
    });
});

function moveShipUp() {
    const ship = getShipLocation();
    const up = getUpperOrLowerElementAtIndex(ship, ship.parentElement.previousElementSibling);
    moveShip(ship, up);
}

function moveShipDown() {
    const ship = getShipLocation();
    const down = getUpperOrLowerElementAtIndex(ship, ship.parentElement.nextElementSibling);

    moveShip(ship, down); 
}

function moveShipLeft() {
    const ship = getShipLocation();
    const left = ship.previousElementSibling;
    
    moveShip(ship, left);  
}

function moveShipRight() {
    const ship = getShipLocation();
    const right = ship.nextElementSibling;

    moveShip(ship, right);  
>>>>>>> 8b78e057775d418691169d51503e72c097c95e20
}

function moveShip(shipElement, newElement) {
    if (canMoveTo(shipElement, newElement)) {
        shipElement.classList.remove('boat');
<<<<<<< HEAD
        newElement.classList.add('boat');
    }
}

function canMoveTo(newElement) {
=======
        newElement.classList.add('boat');  
    }
}

function canMoveTo(shipElement, newElement) {
>>>>>>> 8b78e057775d418691169d51503e72c097c95e20
    if (newElement == null || newElement.classList.contains('pirate')) {
        return false;
    }
    if (isWin(newElement)) {
        win();
        return false;
    }
    return true;
}

function isWin(nextElement) {
    if (nextElement.classList.contains('treasure')) {
        return true;
    }
    return false;
}

function win() {
<<<<<<< HEAD
    const winText = document.getElementById('.announce');
    winText.classList.add('winText');
    winText.innerText = 'BRO YOU FUCKIN DID IT';
=======
    const winText = document.querySelector('.announce');
    winText.classList.add('winText');
    winText.innerText = "You Win!";
>>>>>>> 8b78e057775d418691169d51503e72c097c95e20
    getShipLocation().classList.remove('boat');
}

function getShipLocation() {
    return document.getElementById('frame').querySelector('.boat');
}

function getUpperOrLowerElementAtIndex(ship, newRow) {
    let elementAtIndex = null;
    if (newRow != null) {
        const index = getIndexOfElement(ship);
        elementAtIndex = newRow.childNodes[index];
    }
    return elementAtIndex;
}

function getIndexOfElement(element) {
    return Array.from(element.parentNode.children).indexOf(element);
}

/**
 * Reset the Game
 */
<<<<<<< HEAD

function resetGame() {
    const frame = document.getElementById('frame');
=======
function resetGame() {
    const frame  = document.getElementById('frame');
>>>>>>> 8b78e057775d418691169d51503e72c097c95e20
    frame.firstElementChild.firstElementChild.classList.add('boat');
    frame.lastElementChild.lastElementChild.classList.add('treasure');
}

/**
 * Creates the game grid
 */
<<<<<<< HEAD

=======
>>>>>>> 8b78e057775d418691169d51503e72c097c95e20
function createGrid() {
    const frame = document.getElementById('frame');
    // Add Code to create the game grid
    for (let i = 0; i < 10 ; i++) {
        buildRow(frame); 
    }
    resetGame();
}

/**
 * Builds the grid rows
 * @param {element} frame 
 */

function buildRow(frame) {
<<<<<<< HEAD
    // Add code to create rows
    const row = document.createElement('div');
    row.classList.add('row');
    frame.insertAdjacentElement('beforeend', row);
=======
   // Add code to create rows
   const row = document.createElement('div');
   row.classList.add('row');
   frame.insertAdjacentElement('beforeend', row);
>>>>>>> 8b78e057775d418691169d51503e72c097c95e20
    for (let i = 0; i < 10 ; i++) {
        buildSquare(row, i); 
    }    
}

/**
 * Builds the grid squares 
 * @param {element} row 
 * @param {int} count 
 */

function buildSquare(row, count) {
   // Add code to create the grid Squares
    const container = document.createElement('div');
    container.classList.add('square');

    // Randomly creates pirates, but not on the first elemment
    if (count > 0 && count < 9) {
        if ((Math.floor(Math.random() * 100) + 1) > 70) {
            // Add the pirates here
            container.classList.add('pirate');
        } 
    }
<<<<<<< HEAD
    row.insertAdjacentElement('beforeend', container)
}
=======
    row.insertAdjacentElement('beforeend', container);
}



>>>>>>> 8b78e057775d418691169d51503e72c097c95e20
