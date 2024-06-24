const reverseInt = (int) => {
  let reverse = 0;
  const neg = int < 0 ? -1 : 1;
  int = Math.abs(int);

  while (int != 0) {
    let rem = int % 10;
    reverse = reverse * 10 + rem;
    int = Math.floor(int / 10);
  }

  return reverse * Math.sign(neg);
};

console.log(reverseInt(-5101));
