const bubblesort = (arr) => {
  let totalLoops = 0;

  for (let i = 0; i < arr.length - 1; i++) {
    let swap = false;
    for (let j = 0; j < arr.length; j++) {
      totalLoops++;
      if (arr[j] > arr[j + 1]) {
        [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]];
        swap = true;
      }
    }
    if (!swap) return { arr, totalLoops };
  }

  return { arr, totalLoops };
};

console.log(bubblesort([11, 2, 3, 4]));
