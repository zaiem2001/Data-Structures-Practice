const anagrams = (s1, s2) => {
  if (!s1.length || !s2.length) return false;

  const enchaned_s1 = removeNonChars(s1);
  const enhanced_s2 = removeNonChars(s2);

  if (enchaned_s1.length !== enhanced_s2.length) return false;

  const freq = {};

  for (let char of enchaned_s1) {
    freq[char] = freq[char] + 1 || 1;
  }

  for (let char of enhanced_s2) {
    if (!freq[char]) return false;
    else freq[char]--;
  }

  return true;
};

const removeNonChars = (s) => s.replace(/[^\w]/g, "").toLowerCase();

console.log(anagrams("Hi there!", "iH Theer"));
