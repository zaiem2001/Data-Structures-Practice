const removeDuplicates = (nums) => {
  let left = 0;

  for (let right = 1; right < nums.length; right++) {
    if (nums[right] !== nums[left]) {
      nums[left + 1] = nums[right];
      left++;
    }
  }

  return { left: left + 1, nums };
};

console.log(removeDuplicates([0, 0, 1, 1, 1, 2, 2, 3, 3, 4]));
console.log(removeDuplicates([1, 1, 3]));
