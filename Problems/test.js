// Contains common problems

const findCommon = (s1, s2) => {
  const mergedArr = s1.concat(s2);

  return [...new Set(mergedArr)];
};

console.log(
  findCommon(["Ava", "Emma", "Olivia"], ["Olivia", "Sophia", "Emma"])
);
