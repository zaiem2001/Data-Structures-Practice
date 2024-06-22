class Node {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

class BinarySearchTree {
  constructor(value) {
    this.root = null;
  }

  insert(value) {
    const newNode = new Node(value);

    if (!this.root) {
      this.root = newNode;
    } else {
      let currentNode = this.root;

      while (true) {
        if (value < currentNode.value) {
          if (currentNode.left === null) {
            currentNode.left = newNode;
            break;
          }
          currentNode = currentNode.left;
        } else {
          if (currentNode.right === null) {
            currentNode.right = newNode;
            break;
          }
          currentNode = currentNode.right;
        }
      }
    }

    return this;
  }

  lookup(value) {
    if (!this.root) return false;

    let currentNode = this.root;
    while (true) {
      if (currentNode.value === value) return true;

      if (value < currentNode.value) {
        if (!currentNode.left) break;
        currentNode = currentNode.left;
      } else {
        if (!currentNode.right) break;
        currentNode = currentNode.right;
      }
    }

    return false;
  }

  remove(value) {
    if (!this.root) return false;

    let currentNode = this.root;
    let parentNode = null;

    while (currentNode) {
      if (value < currentNode.value) {
        parentNode = currentNode;
        currentNode = currentNode.left;
      } else if (value > currentNode.value) {
        parentNode = currentNode;
        currentNode = currentNode.right;
      } else if (value === currentNode.value) {
        // 1. There is no Right child of the target element
        if (!currentNode.right) {
          console.log(currentNode);
          console.log(parentNode);

          if (!parentNode) {
            this.root = currentNode.left;
          } else {
            if (currentNode.value < parentNode.value) {
              parentNode.left = currentNode.left;
            } else {
              parentNode.right = currentNode.left;
            }
          }
          break;
          // 2. There is a Right child but no left child of the target element.
        } else if (!currentNode.right.left) {
          const leftNode = currentNode.left;
          if (!parentNode) {
            this.root = leftNode;
          }

          if (currentNode.value < parentNode.value) {
            parentNode.left = currentNode.right;
            parentNode.left.left = leftNode;
          } else {
            parentNode.right = currentNode.right;
            parentNode.right.left = leftNode;
          }
          break;
        }
        // 3. There is a Right child and a Left child.
        else if (currentNode.right.left) {
          // TODO
          console.log("Feature yet to implement");
          break;
        }
      }
    }

    return this;
  }

  breadthFirstSearch() {
    const queue = [];
    const list = [];
    queue.push(this.root);

    while (queue.length) {
      const currentNode = queue.shift();
      // console.log({ currentNode });
      list.push(currentNode.value);

      if (currentNode.left) {
        queue.push(currentNode.left);
      }
      if (currentNode.right) {
        queue.push(currentNode.right);
      }
    }

    return list;
  }

  depthFirstSearchInorder() {
    return traverseInorder(this.root, []);
  }

  depthFirstSearchPreorder() {
    return traversePreorder(this.root, []);
  }

  depthFirstSearchPostOrder() {
    return traversePostorder(this.root, []);
  }
}

const traversePostorder = (node, list) => {
  if (node.left) traversePostorder(node.left, list);
  if (node.right) traversePostorder(node.right, list);

  list.push(node.value);

  return list;
};

const traverseInorder = (node, list) => {
  if (node.left) traverseInorder(node.left, list);
  list.push(node.value);
  if (node.right) traverseInorder(node.right, list);

  return list;
};

const traversePreorder = (node, list) => {
  list.push(node.value);

  if (node.left) traversePreorder(node.left, list);
  if (node.right) traversePreorder(node.right, list);

  return list;
};

const Bst = new BinarySearchTree();

Bst.insert(9);
Bst.insert(4);
Bst.insert(20);
Bst.insert(170);
Bst.insert(15);
Bst.insert(1);
Bst.insert(6);
// Bst.remove(9);

// console.log(Bst.lookup(170));
// console.log(JSON.stringify(Bst, null, 2));
// console.log(Bst.breadthFirstSearch());
// console.log(Bst.depthFirstSearchInorder());
// console.log(Bst.depthFirstSearchPreorder());
// console.log(Bst.depthFirstSearchPostOrder());

// const test = {
//   root: {
//     value: 9,
//     left: {
//       value: 4,
//       left: {
//         value: 1,
//         left: null,
//         right: null,
//       },
//       right: null,
//     },
//     right: {
//       value: 20,
//       left: {
//         value: 15,
//         left: null,
//         right: null,
//       },
//       right: {
//         value: 170,
//         left: null,
//         right: null,
//       },
//     },
//   },
// };

export { BinarySearchTree };
