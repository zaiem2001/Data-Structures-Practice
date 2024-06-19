const mergeSort = (arr) => {
  if (arr.length === 1) return arr;

  const splitIdx = Math.floor(arr.length / 2);
  const left = arr.slice(0, splitIdx);
  const right = arr.slice(splitIdx);

  return merge(mergeSort(left), mergeSort(right));
};

const merge = (left, right) => {
  const output = [];

  let lPointer = 1;
  let rightPointer = 1;
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
  }

  return output;
};

console.log(mergeSort([12, 3, 5, 1, 0, 7, 23]));
