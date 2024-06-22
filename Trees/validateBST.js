import { BinarySearchTree } from "./BinarySearchTree.js";

const Bst = new BinarySearchTree();

Bst.insert(9);
Bst.insert(4);
Bst.insert(20);
Bst.insert(170);
Bst.insert(15);
Bst.insert(1);
Bst.insert(6);

const validateBST = (root) => {
  if (!root) return false;

  const validate = (node, lower, upper) => {
    if (!node) return true;

    if (node.value <= lower || node.value >= upper) return false;

    return (
      validate(node.left, lower, node.value) &&
      validate(node.right, node.value, upper)
    );
  };

  return validate(root, -Infinity, Infinity);
};

console.log(validateBST(Bst.root));
