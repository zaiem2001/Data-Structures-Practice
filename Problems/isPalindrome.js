// The other approach is to reverse the string and return reverse(string) === string;
const isPalindrome = (string) => {
  console.log({ string });

  if (!string.length) return true;
  if (string[0] !== string[string.length - 1]) return false;

  return isPalindrome(string.slice(1, string.length - 1));
};

const isPalindrome2 = (string, i = 0) => {
  if (i >= string.length / 2) return true;

  if (string[i] !== string[string.length - i - 1]) return false;

  return isPalindrome2(string, i + 1);
};

console.log(isPalindrome(""));
console.log(isPalindrome2("madam"));
