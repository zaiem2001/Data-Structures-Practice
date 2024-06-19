// Select the smallest from the iteration and replaces with the index.
const selectionSort = (arr) => {
  for (let i = 0; i < arr.length; i++) {
    let smallest = arr[i];
    let smallestIdx = i;

    for (let j = i + 1; j < arr.length; j++) {
      //   console.log(smallest);
      if (arr[j] < smallest) {
        smallest = arr[j];
        smallestIdx = j;
      }
    }
    [arr[i], arr[smallestIdx]] = [arr[smallestIdx], arr[i]];
  }

  return arr;
};

console.log(selectionSort([6, 5, 3, 8, 7, 2, 0]));
