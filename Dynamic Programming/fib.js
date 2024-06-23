let calculations = 0;
const fib = () => {
  let cache = {};

  return function m_fib(n) {
    calculations++;

    if (n in cache) return cache[n];

    if (n < 2) return n;

    cache[n] = m_fib(n - 1) + m_fib(n - 2);

    return cache[n];
  };
};

const memoized_fib = fib();
console.log(memoized_fib(50));
console.log({ calculations });
