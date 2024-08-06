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

const insertionSort2 = (arr) => {
  for (let i = 1; i < arr.length; i++) {
    let j = i;

    while (j > 0 && arr[j - 1] > arr[j]) {
      [arr[j - 1], arr[j]] = [arr[j], arr[j - 1]];
      j--;
    }
  }

  return arr;
};

console.log(insertionSort([3, 6, 5, 1, 60, 2, 4, 0]));
console.log(insertionSort2([3, 6, 5, 1, 60, 2, 4, 0]));
