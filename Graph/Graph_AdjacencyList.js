class Graph_AList {
  constructor() {
    this.numberOfNodes = 0;
    this.adjacencyList = {};
  }

  addVertex(value) {
    if (this.adjacencyList[value]) return "Node Already Exists!";

    this.adjacencyList[value] = [];
    this.numberOfNodes++;
  }

  addEdge(node1, node2) {
    if (!this.adjacencyList[node1] || !this.adjacencyList[node2])
      return "Invalid Nodes!";

    if (this.adjacencyList[node1].includes(node2))
      return "Edge already present!";

    this.adjacencyList[node1].push(node2);
    this.adjacencyList[node2].push(node1);

    return this;
  }

  depthFirstSearch_R(start) {
    if (!this.adjacencyList[start]) return "Invalid vertex!";
    const list = [];
    const visited = {};
    list.push(start);
    visited[start] = true;

    const traverse = (vertex) => {
      if (!vertex) return;

      this.adjacencyList[vertex].forEach((v) => {
        if (!visited[v] && this.adjacencyList[v].length) {
          list.push(v);
          visited[v] = true;
          return traverse(v);
        }
      });
    };

    traverse(start);
    return list;
  }

  depthFirstSearch_I(start) {
    if (!start) return false;
    const list = [];
    const stack = [];
    const visited = {};
    visited[start] = true;
    stack.push(start);

    while (stack.length) {
      const neighbour = stack.pop();
      list.push(neighbour);

      this.adjacencyList[neighbour].forEach((n) => {
        if (!visited[n] && this.adjacencyList[n].length) {
          stack.push(n);
          visited[n] = true;
        }
      });
    }
    return list;
  }

  breadthFirstSearch_I(start) {
    if (!start) return false;
    const list = [];
    const visited = {};
    const queue = [start];
    visited[start] = true;

    while (queue.length) {
      const currentNode = queue.shift();
      list.push(currentNode);

      this.adjacencyList[currentNode].forEach((n) => {
        if (!visited[n] && this.adjacencyList[n].length) {
          queue.push(n);
          visited[n] = true;
        }
      });
    }

    return list;
  }
}

const graph = new Graph_AList();
graph.addVertex("A");
graph.addVertex("B");
graph.addVertex("C");
graph.addVertex("D");
graph.addVertex("E");
graph.addVertex("F");
graph.addEdge("A", "B");
graph.addEdge("A", "C");
graph.addEdge("B", "D");
graph.addEdge("C", "E");
graph.addEdge("D", "E");
graph.addEdge("D", "F");
graph.addEdge("E", "F");

console.log(graph);
console.log(graph.depthFirstSearch_R("A"));
console.log(graph.depthFirstSearch_I("A"));
console.log(graph.breadthFirstSearch_I("D"));

// NOTE: 0 is connected to 2 and vice-versa, similarly;
//       2 is connected to 3 and 3 to 2, two is connected to 1 and 1 to 2
// EdgeList-- >
//   [
//     [0, 2],
//     [2, 3],
//     [2, 1],
//     [1, 3],
//   ];

// ---------------

// at index 0 which means node with value 0 is connected to 2 [0,0,1,0];.
// Similarly index 1 means node with value 1 is connected to 2 and 3
// Adjacent_Matrix-- >
//   [
//     [0, 0, 1, 0],
//     [0, 0, 1, 1],
//     [1, 1, 0, 1],
//     [0, 1, 1, 0],
//   ];

// ----------------

// 0 is connected to 2; 1 is connected to 2 and 3.
// Adjacent_List-- > { 0: [2], 1: [2, 3], 2: [0, 1, 3], 3: [1, 2] };
