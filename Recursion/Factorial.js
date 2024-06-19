const fact_iterative = (number) => {
  let output = 1;

  for (let i = number; i >= 1; i--) {
    output = output * i;
  }

  return output;
};

console.log(fact_iterative(1));

const fact_recursive = (number) => {
  if (number === 0 || number === 1) return 1;

  return number * fact_recursive(number - 1);
};

console.log(fact_recursive(50));
