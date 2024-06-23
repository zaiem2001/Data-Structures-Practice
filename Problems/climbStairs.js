// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step
const fib = () => {
  const cache = {};

  return function m_fib(n) {
    if (cache[n]) return cache[n];

    if (n < 2) return n;

    cache[n] = m_fib(n - 1) + m_fib(n - 2);

    return cache[n];
  };
};

const climbStairs = (n) => {
  const re_f = fib();
  return re_f(n + 1);
};

console.log(climbStairs(5));
