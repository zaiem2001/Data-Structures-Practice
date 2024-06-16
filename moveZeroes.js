// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

// Example 1:

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Example 2:

// Input: nums = [0]
// Output: [0]

const moveZeroes = (input) => {
  let left = 0;

  for (let right = 0; right < input.length; right++) {
    if (input[right] !== 0) {
      let temp = input[right];
      input[right] = input[left];
      input[left] = temp;

      //   Shortcut
      //   [input[left], input[right]] = [input[right], input[left]];

      left++;
    }
  }

  //   Brute Force:
  //   let zeroesCount = 0;
  //   input.forEach((element, index) => {
  //     if (element === 0) {
  //       zeroesCount++;
  //       input.splice(index, 1);
  //     }
  //   });

  //   for (let i = 0; i < zeroesCount; i++) {
  //     input.push(0);
  //   }

  return input;
};

console.log(moveZeroes([0, 1, 0, 3, 12]));
