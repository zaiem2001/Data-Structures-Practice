// 10 --> 6 --> 9

class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

class LinkedList {
  constructor(value) {
    const newNode = new Node(value, null);
    this.head = newNode;
    this.tail = this.head;
    this.length = 1;
  }

  append(value) {
    const newNode = new Node(value);
    this.tail.next = newNode;
    this.tail = newNode;
    this.length++;

    return this;
  }

  prepend(value) {
    const newNode = new Node(value);
    newNode.next = this.head;
    this.head = newNode;
    this.length++;

    return this;
  }

  insert(index, value) {
    if (index <= 0) return this.prepend(value);
    if (index >= this.length) return this.append(value);

    const newNode = new Node(value);
    const previousNode = this.traverseToIndex(index - 1);
    const nextNode = previousNode.next;

    previousNode.next = newNode;
    newNode.next = nextNode;

    this.length++;
  }

  remove(index) {
    const previousNode = this.traverseToIndex(index - 1);
    const deletionNode = previousNode.next;
    previousNode.next = deletionNode.next;

    this.length--;
    return this;
  }

  reverse() {
    let currentNode = this.head;
    let nextNode = this.head.next;

    this.tail = this.head;

    while (nextNode) {
      let temp = nextNode.next;
      nextNode.next = currentNode;
      currentNode = nextNode;
      nextNode = temp;
    }

    this.head.next = null;
    this.head = currentNode;

    return this;
  }

  reverse_2() {
    let currentNode = this.head;
    let prevNode = null;
    this.tail = this.head;

    while (currentNode) {
      let temp = currentNode.next;
      currentNode.next = prevNode;
      prevNode = currentNode;
      currentNode = temp;
    }

    this.head = prevNode;

    return this;
  }

  traverseToIndex(index) {
    let counter = 0;
    let currentNode = this.head;

    while (counter !== index) {
      currentNode = currentNode.next;
      counter++;
    }

    return currentNode;
  }

  printList() {
    const arr = [];
    let currentNode = this.head;

    while (currentNode) {
      arr.push(currentNode.value);
      currentNode = currentNode.next;
    }

    return arr;
  }

  getMid() {
    let mid = Math.ceil((this.length - 1) / 2);
    let node = this.head;

    while (mid) {
      node = node?.next;
      mid--;
    }

    return node;

    // NOTE: Another approach.
    // let slow = this.head;
    // let fast = this.head;

    // while (fast?.next?.next) {
    //   slow = slow.next;
    //   fast = fast?.next?.next;
    // }
    // return slow;
  }
}

const linkedList = new LinkedList(9);
linkedList.append(6);
linkedList.append(16);
linkedList.append(26);
linkedList.prepend(10);
linkedList.insert(2, 5);
// linkedList.insert(4, 7);
linkedList.remove(1);

console.log("BEFORE: " + linkedList.printList());
// linkedList.reverse();
linkedList.reverse_2();
console.log(JSON.stringify(linkedList, null, 2));
console.log(linkedList.printList());

console.log(linkedList.getMid());
