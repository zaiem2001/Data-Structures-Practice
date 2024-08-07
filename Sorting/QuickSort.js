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

const pivotHelper2 = (arr, start, end) => {
  let pivot = arr[start];
  let i = 0;
  let j = end;

  while (i <= j) {
    if (pivot < arr[i]) {
      if (pivot > arr[j]) {
        [arr[i], arr[j]] = [arr[j], arr[i]];
      } else j--;
    } else {
      i++;
    }
  }

  [arr[start], arr[j]] = [arr[j], arr[start]];
  return j;
};

const quickSort = (arr, left = 0, right = arr.length - 1) => {
  if (left < right) {
    // const pivotIndex = pivotHelper(arr, left, right);
    const pivotIndex = pivotHelper2(arr, left, right);

    //   Left
    quickSort(arr, left, pivotIndex - 1);
    //   Right
    quickSort(arr, pivotIndex + 1, right);
  }

  return arr;
};

const arr = [4, 2, 6, 10, 9];
// console.log(pivotHelper(arr));

console.log(quickSort(arr));
