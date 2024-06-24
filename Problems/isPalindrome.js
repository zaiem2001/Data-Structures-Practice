// The other approach is to reverse the string and return reverse(string) === string;
const isPalindrome = (string) => {
  console.log({ string });

  if (!string.length) return true;
  if (string[0] !== string[string.length - 1]) return false;

  return isPalindrome(string.slice(1, string.length - 1));
};

console.log(isPalindrome(""));
