const pivotHelper = (arr, start = 0, end = arr.length - 1) => {
  let pivot = arr[start];
  let swapIdx = start;

  for (let i = start + 1; i <= end; i++) {
    if (pivot > arr[i]) {
      swapIdx++;
      [arr[i], arr[swapIdx]] = [arr[swapIdx], arr[i]];
    }
  }

  [arr[start], arr[swapIdx]] = [arr[swapIdx], arr[start]];

  return swapIdx;
};

const quickSort = (arr, left = 0, right = arr.length - 1) => {
  if (left < right) {
    const pivotIndex = pivotHelper(arr, left, right);

    //   Left
    quickSort(arr, left, pivotIndex - 1);
    //   Right
    quickSort(arr, pivotIndex + 1, right);
  }

  return arr;
};

const arr = [5, 2, 1, 8, 4, 7, 6, 3];
// console.log(pivotHelper(arr));

console.log(quickSort(arr));
