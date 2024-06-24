const maxChar = (string) => {
  const freq = countFrequency(string);
  console.log(freq);
  let max = 0;
  let maxChar = "";

  for (let key in freq) {
    if (freq[key] > max) {
      max = freq[key];
      maxChar = key;
    }
  }

  return { max, maxChar };
};

const countFrequency = (string) => {
  const freq = {};

  for (let char of string) {
    freq[char] = freq[char] + 1 || 1;
  }

  return freq;
};

console.log(maxChar("abccb"));
