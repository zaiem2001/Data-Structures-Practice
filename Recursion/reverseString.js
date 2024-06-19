const reverseString = (string) => {
  if (string.length === 1) return string;

  return reverseString(string.slice(1)) + string[0];
};

console.log(reverseString("The quick brown fox jumps over the lazy dog."));

const reverseString_iterative = (str) => str.split("").reverse().join("");

console.log("ITERATIVE!");
console.log(
  reverseString_iterative("The quick brown fox jumps over the lazy dog.")
);
