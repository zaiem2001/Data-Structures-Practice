class Node {
  constructor(value, weight) {
    this.value = value;
    this.weight = weight;
  }
}

class WeightedGraph {
  constructor() {
    this.adjacencyList = {};
    this.numberOfNodes = 0;
  }

  addVertex(value) {
    if (this.adjacencyList[value]) return "Node already exists!";

    this.adjacencyList[value] = [];
    this.numberOfNodes++;
  }

  addEdge(v1, v2, weight) {
    if (!this.adjacencyList[v1] || !this.adjacencyList[v2])
      return "Invalid vertices";

    if (this.adjacencyList[v1].find((edge) => edge.value === v2))
      return "Edge already exists!";

    this.adjacencyList[v1].push(this.getNode(v2, weight));
    this.adjacencyList[v2].push(this.getNode(v1, weight));

    return this;
  }

  getNode(v, weight) {
    return new Node(v, weight);
  }
}

const wg = new WeightedGraph();

wg.addVertex("A");
wg.addVertex("B");
wg.addVertex("C");
wg.addVertex("D");
wg.addVertex("E");
wg.addVertex("F");

wg.addEdge("A", "B", 4);
wg.addEdge("A", "C", 2);
wg.addEdge("B", "E", 3);
wg.addEdge("C", "D", 2);
wg.addEdge("C", "F", 4);
wg.addEdge("D", "E", 3);
wg.addEdge("D", "F", 1);
wg.addEdge("E", "F", 1);

console.log(JSON.stringify(wg, null, 2));
