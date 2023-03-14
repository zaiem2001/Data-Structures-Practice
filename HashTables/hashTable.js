/* Implementing Hashtable using JS

   for Example: Without collisons - [[[key, value]],[[key, value]],[[key, value]]] 
   for Example: With collisons - [[[key, value],[key, value]],[[key, value]]] 
*/

class HashTable {
  constructor(size = 4) {
    this.data = new Array(size);
  }

  _hash(key) {
    const PRIME_NUMBER = 31;
    const minIteration = Math.min(key, 100);

    let hash = 0;
    for (let i = 0; i < minIteration; i++) {
      hash = (hash + PRIME_NUMBER + key.charCodeAt(i) * i) % this.data.length;
    }

    return hash;
  }

  set(key, value) {
    const hashedKey = this._hash(key);

    if (!this.data[hashedKey]) {
      this.data[hashedKey] = [];
    }

    this.data[hashedKey].push([key, value]);

    return this.data;
  }

  get(key) {
    const hashedKey = this._hash(key);

    if (this.data[hashedKey]) {
      const arrItem = this.data[hashedKey].filter((item) => item[0] === key);

      return arrItem.length ? arrItem[0][1] : undefined;
    }

    return undefined;
  }

  keys() {
    const keysArr = [];

    this.data.forEach((item) => {
      if (item.length) {
        item.forEach((element) => {
          if (!keysArr.includes(element[0])) {
            keysArr.push(element[0]);
          }
        });
      }
    });

    return keysArr;
  }

  values() {
    const valuesArr = [];

    this.data.forEach((item) => {
      if (item.length) {
        item.forEach((element) => {
          if (!valuesArr.includes(element[1])) {
            valuesArr.push(element[1]);
          }
        });
      }
    });

    return valuesArr;
  }
}

const ht = new HashTable(30);

ht.set("pink", "#PINK");
ht.set("green", "#GREEN");
ht.set("yellow", "#YELLOW");

// console.log(ht.get("pink"));

console.log(ht.keys());
console.log(ht.values());
// console.log(JSON.stringify(ht));
