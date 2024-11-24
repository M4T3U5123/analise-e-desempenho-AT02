const Node = require('./Node');

class LinkedList {
    constructor() {
        this.head = null;
    }

    add(value, position) {
        const newNode = new Node(value);

        if (!this.head) {
            this.head = newNode;
            return;
        }

        if (position === 0) {
            newNode.next = this.head;
            this.head = newNode;
            return;
        }

        let current = this.head;
        let index = 0;

        while (index < position - 1 && current.next) {
            current = current.next;
            index++;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    remove(value) {
        if (!this.head) return -1;

        if (this.head.value === value) {
            this.head = this.head.next;
            return 1;
        }

        let current = this.head;

        while (current.next && current.next.value !== value) {
            current = current.next;
        }

        if (current.next) {
            current.next = current.next.next;
            return 1;
        }

        return -1;
    }

    print() {
        const result = [];
        let current = this.head;

        while (current) {
            result.push(current.value);
            current = current.next;
        }

        console.log(result);
    }
}

module.exports = LinkedList;