class Node {
    Integer value;
    Node ref;

    Node(Integer value, Node node) {
        this.value = value;
        this.ref = node;
    }
}

class SinglyLinkedList {

    private Node headNode;

    void add(Integer value) {
        if (this.headNode == null){
            headNode = new Node(value, null);
            return;
        }

        Node tempNode = this.headNode;

        while (tempNode.ref != null) {
            tempNode = tempNode.ref;
        }

        tempNode.ref = new Node(value, null);
    }

    void insert(int index, Integer value) {
        int count = 0;
        Node tempNode = this.headNode;

        while (count < index - 1) {
            if (tempNode == null) return;
            tempNode = tempNode.ref;
            count += 1;
        }

        if (tempNode == null) return;

        tempNode.ref = new Node(value, tempNode.ref);
    }

    void delete(int index) {
        if (this.headNode == null) return;
        if (index == 0) {
            this.headNode = headNode.ref;
            return;
        }

        int count = 0;
        Node tempNode = this.headNode;

        while (count < index - 1) {
            if (tempNode == null) return;
            tempNode = tempNode.ref;
            count += 1;
        }

        if (tempNode == null || tempNode.ref == null) return;

        Node nextNode = tempNode.ref;
        tempNode.ref = nextNode.ref;

    }

    Integer valueAtIndex(int index) {
        if(this.headNode == null) return null;

        int count = 0;
        Node tempNode = this.headNode;

        while(count < index) {
            if(tempNode == null) return null;
            tempNode = tempNode.ref;
            count += 1;
        }

        if (tempNode == null) return null;

        return tempNode.value;
    }

}
