/*  1.  Given an array = [2,5,1,2,3,5,1,2,4];
        It should return 2 -> as 2 is the first recurring character

    2.  Given an array = [2,3,4,5];
        It should return undefined
*/

const getFirstRecurringChar = (inputArr) => {
  const map = new Map();
  let firstRecurringChar = undefined;

  if (!inputArr.length) return undefined;

  for (let i = 0; i < inputArr.length; i++) {
    if (map.has(inputArr[i])) {
      firstRecurringChar = inputArr[i];
      break;
    }

    map.set(inputArr[i], true);
  }

  return firstRecurringChar;
};

console.log(getFirstRecurringChar([2, 3, 4, 1, 5]));
