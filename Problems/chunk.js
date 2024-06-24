const chunk = (arr, size) => {
  const res = [];
  let startIndex = 0;
  let endIndex = size;

  while (true) {
    if (startIndex > arr.length - 1 && endIndex > arr.length - 1) break;

    res.push(arr.slice(startIndex, endIndex));
    startIndex = endIndex;
    endIndex = startIndex + size;
  }

  return res;
};

console.log(chunk([1, 2, 3, 4, 5], 10));
