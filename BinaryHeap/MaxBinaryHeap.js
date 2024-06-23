class MaxBinaryHeap {
  constructor() {
    this.values = [];
  }

  insert(value) {
    this.values.push(value);
    if (this.values.length === 1) return this;

    return this.bubbleUp();
  }

  extractMax() {
    const root = this.values[0];
    this.values[0] = this.values.pop();

    this.sinkDown();

    return root;
  }

  sinkDown() {
    let parentIndex = 0;

    while (true) {
      let maxChildIndex = this.calculateMaxChildIndex(parentIndex);

      if (this.values[parentIndex] < this.values[maxChildIndex]) {
        [this.values[maxChildIndex], this.values[parentIndex]] = [
          this.values[parentIndex],
          this.values[maxChildIndex],
        ];
        parentIndex = maxChildIndex;
      } else break;
    }
  }

  calculateMaxChildIndex(parentIndex) {
    let leftChild = 2 * parentIndex + 1;
    let rightChild = 2 * parentIndex + 2;
    let maxChildIndex =
      this.values[leftChild] > this.values[rightChild] ? leftChild : rightChild;
    return maxChildIndex;
  }

  bubbleUp() {
    let childIndex = this.values.length - 1;
    let parentIndex = this.getParentIndex(childIndex);

    while (true) {
      let parentElem = this.values[parentIndex];
      let childElem = this.values[childIndex];

      if (parentElem < childElem) {
        [this.values[childIndex], this.values[parentIndex]] = [
          this.values[parentIndex],
          this.values[childIndex],
        ];

        childIndex = parentIndex;
        parentIndex = this.getParentIndex(childIndex);
      } else break;
    }

    return this;
  }

  getParentIndex(childIndex) {
    return Math.floor((childIndex - 1) / 2);
  }
}

const mBH = new MaxBinaryHeap();

[10, 12, 21, 201, 100, 11, 32].forEach((n) => mBH.insert(n));

mBH.extractMax();
// mBH.insert(100);
// mBH.insert(19);
// mBH.insert(36);
// mBH.insert(200);

console.log(mBH);

// For priority queue, create a node class {value, priority} and
// adjust the heap based on the priority.
