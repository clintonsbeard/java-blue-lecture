document.addEventListener('DOMContentLoaded', () => {
    createGrid();

    document.querySelector('body').addEventListener('keyup', (event) => {
        if (event.key === 'ArrowRight') {
            moveShipRight();
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

    document.getElementById('resetButton').addEventListener('click', (event) => {
        resetGame();
        event.preventDefault();
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

function moveShip(shipElement, newElement) {
    if (canMoveToElement(newElement)) {
        if (isWin(newElement)) {
            win();
        } 
        shipElement.classList.remove('boat');
        newElement.classList.add('boat');
    }
}

function getShipLocation() {
    return document.getElementById('frame').querySelector('.boat');
}

function getUpperOrLowerElementAtIndex(ship, newElement) {
    let elementAtIndex = null;
    if (newElement != null) {
        const index = getIndexOfElement(ship);
        elementAtIndex = newElement.childNodes[index];
    }
    return elementAtIndex;
}

function getIndexOfElement(element) {
    return Array.from(element.parentNode.children).indexOf(element);
}

function canMoveToElement(element) {
    if (element == null || element.classList.contains('pirate')) {
        return false;
    }
    return true;
}

function isWin(nextElement) {
    if (nextElement.classList.contains("treasure")) {
        return true;
    }
    return false;
}

function win() {
    const announce = document.querySelector('.announce');
    announce.classList.add('winText');
    announce.innerText = "You Win!";
    getShipLocation().classList.remove('boat');
}

function resetGame() {
    const ship = getShipLocation();
    if (ship != null) {
        ship.classList.remove('boat');
    }

    const announce = document.querySelector('.announce');
    if (announce.classList.contains('winText')) {
        announce.classList.remove('winText');
    }
    
    announce.innerText = "Play!";

    const frame = document.getElementById('frame');
    frame.firstElementChild.firstElementChild.classList.add('boat');
    frame.lastElementChild.lastElementChild.classList.add('treasure');
}

function createGrid() {
    const frame = document.getElementById('frame');
    
    for (let i = 0; i < 10 ; i++) {
        buildRow(frame); 
    }
    resetGame();
}

function buildRow(frame) {
    const row = document.createElement('div');
    row.classList.add('row');
    frame.insertAdjacentElement('beforeend', row);
    for (let i = 0; i < 10 ; i++) {
        buildSquare(row, i); 
    }    
}

function buildSquare(row, count) {
    const container = document.createElement('div');
    container.classList.add('square');

    if (count > 1 && count < 89) {
        if ((Math.floor(Math.random() * 100) + 1) > 85) {
            container.classList.add('pirate');
        } 
    }
    row.insertAdjacentElement('beforeend', container);
}



