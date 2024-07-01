import { LinkedList } from "../LinkedList/LinkedList.js";

// Given a linkedlist and m and n values, return the list with
// only the portion of m and n in the list shud be reversed.
const linkedListMNReversal = (head, m, n) => {
  let counter = 1;
  let start = head;
  let currentNode = head;

  while (counter < m) {
    start = currentNode;
    currentNode = currentNode.next;
    counter++;
  }

  if (m === 1) start = null;

  let newList = null;
  const tail = currentNode;

  while (counter <= n && counter >= m) {
    let temp = currentNode.next;
    currentNode.next = newList;
    newList = currentNode;
    currentNode = temp;
    counter++;
  }

  if (start) {
    start.next = newList;
  }
  tail.next = currentNode;

  if (m > 1) return head;
  else newList;
};

const myList = new LinkedList(1);
myList.append(2);
myList.append(3);
myList.append(4);
myList.append(5);

console.log("Before.");
console.log(myList.printList());
linkedListMNReversal(myList.head, 2, 4);
console.log("After");
console.log(myList.printList());
