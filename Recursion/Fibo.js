const fibonacciSeq = (number) => {
  let sequence = "0,1,";
  let preVal = 0;
  let currentVal = 1;

  for (let i = 1; i < number; i++) {
    const total = currentVal + preVal;

    sequence += total + ",";
    preVal = currentVal;
    currentVal = total;
  }

  return { sequence, indexVal: currentVal };
};

console.log(fibonacciSeq(10));

const fibonacciRec = (n) => {
  if (n === 0) return 0;
  if (n === 1) return 1;

  return fibonacciRec(n - 1) + fibonacciRec(n - 2);
};

console.log("RECURSIVE -->", fibonacciRec(10));
