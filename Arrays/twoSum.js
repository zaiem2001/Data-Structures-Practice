const twoSum = (array, target) => {
  // Brute force
  //   for (let i = 0; i < array.length; i++) {
  //     for (let j = 1; j < array.length; j++) {
  //       if (array[i] + array[j] === target) return [i, j];
  //     }
  //   }

  const hashMap = new Map();

  for (let i = 0; i < array.length; i++) {
    const diff = target - array[i];
    let key = hashMap.get(diff);

    if (key !== undefined) {
      return [key, i];
    } else {
      hashMap.set(array[i], i);
    }
  }

  return -1;
};

console.log(twoSum([11, 15, 2, 7], 9));
