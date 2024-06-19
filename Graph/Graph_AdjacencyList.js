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
}

const graph = new Graph_AList();
graph.addVertex("0");
graph.addVertex("1");
graph.addVertex("2");
graph.addVertex("3");
graph.addVertex("4");
graph.addVertex("5");
graph.addVertex("6");
graph.addEdge("3", "1");
graph.addEdge("3", "4");
graph.addEdge("4", "2");
graph.addEdge("4", "5");
graph.addEdge("1", "2");
graph.addEdge("1", "0");
graph.addEdge("0", "2");
graph.addEdge("6", "5");

console.log(graph);

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
