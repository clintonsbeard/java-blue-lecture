/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 */

function returnOne() {
  return 1;
}

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */

function printToConsole(value) {
  console.log(value);
}

/**
 * Multiply two numbers together. But what happens of we don't pass
 * a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 */

 function multiplyTogether(firstParameter, secondParameter) {
  return firstParameter * secondParameter;
 }

/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */

function multiplyNoUndefined(firstParameter = 0, secondParameter = 0) {
  return firstParameter * secondParameter;
 }

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */

function scopeTest() {
  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;

  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;
  }

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }
}

/**
 * Take the details of a person and create an English readable sentence that uses
 * the provided information, separated by the defined separator, or the default separator ', '
 *
 * @param {string} name the name of the person being described
 * @param {number} age the age of the person
 * @param {string[]} [listOfQuirks] a list of funny quirks about the person
 * @param {string} [separator = ', '] the string used to separate the quirks
 * @returns {string} the combined descriptive string
 */

function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  return description + listOfQuirks.join(separator);
}

/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */

function sumAllNumbers(numbersToSum) {
  return numbersToSum.reduce(
    (sum, number) => {
      return sum + number;
    }
  );
}

function sumAllNumbers(numbersToSum) {
  return numbersToSum.reduce(function
    (sum, number) {
      return sum + number;
    }
  );
}

/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */

function allDivisibleByThree(numbersToFilter) {
  return numbersToFilter.filter(
    (element) => {
      return element % 3 === 0;
    }
  );
}