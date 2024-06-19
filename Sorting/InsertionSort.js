const insertionSort = (arr) => {
  let j;
  for (let i = 1; i < arr.length; i++) {
    let currentVal = arr[i];
    for (j = i - 1; j >= 0 && arr[j] > currentVal; j--) {
      arr[j + 1] = arr[j];
    }
    arr[j + 1] = currentVal;
  }

  return arr;
};

console.log(insertionSort([3, 6, 5, 1, 60, 2, 4, 0]));
