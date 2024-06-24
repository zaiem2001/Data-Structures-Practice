// TODO: FIX ERROR.

const spiral = (n) => {
  const result = new Array(n).fill([]);
  let counter = 1;
  let startRow = 0,
    startCol = 0;
  let endRow = n - 1,
    endCol = n - 1;

  while (startRow <= endRow && startCol <= endCol) {
    // top Row
    for (let i = startCol; i <= endCol; i++) {
      result[startRow][i] = counter;
      counter++;
    }

    startRow++;
    // right col
    for (let i = startRow; i <= endRow; i++) {
      result[i][endCol] = counter;
      counter++;
    }

    endCol--;

    for (let i = endCol; i >= startCol; i--) {
      result[endRow][i] = counter;
      counter++;
    }

    endRow--;

    for (let i = endRow; i >= startRow; i--) {
      result[i][startCol] = counter;
      counter++;
    }

    startCol++;
  }

  return result;
};

console.log(spiral(2));
