const binarySearch = (arr, val) => {
  let left = 0;
  let right = arr.length - 1;

  while (left <= right) {
    let mid = Math.ceil(left + right / 2);

    if (arr[mid] === val) return true;

    if (val < arr[mid]) right = mid - 1;
    else left = mid + 1;
  }

  return false;
};

console.log(binarySearch([1, 4, 6, 7, 9, 10, 11, 23], 4));
