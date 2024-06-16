// Given two sorted arrays, return a new sorted array.

const mergeSortedArrays = (left, right) => {
  // Edge cases for empty arrays

  let lPointer = 1;
  let rightPointer = 1;
  const output = [];
  let leftVal = left[0];
  let rightVal = right[0];

  while (leftVal || rightVal) {
    if (rightVal === undefined || leftVal < rightVal) {
      output.push(leftVal);
      leftVal = left[lPointer];
      lPointer++;
    } else {
      output.push(rightVal);
      rightVal = right[rightPointer];
      rightPointer++;
    }
    // ------------------------------------------------
    // Another approach
    // if (leftVal === undefined && rightVal === undefined) {
    //   break;
    // }
    // if (leftVal === undefined) {
    //   output.push(rightVal);
    //   rightPointer++;
    //   continue;
    // }
    // if (rightVal === undefined) {
    //   output.push(leftVal);
    //   lPointer++;
    //   continue;
    // }
    // if (leftVal === rightVal) {
    //   output.push(leftVal);
    //   output.push(rightVal);
    //   rightPointer++;
    //   lPointer++;
    // } else if (leftVal < rightVal) {
    //   output.push(leftVal);
    //   lPointer++;
    // } else {
    //   output.push(rightVal);
    //   rightPointer++;
    // }
  }

  return output;
};

console.log(mergeSortedArrays([1, 2, 6, 7], [0, 2, 4, 6, 8, 14]));
