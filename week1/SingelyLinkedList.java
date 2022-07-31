package week1;

public class SingelyLinkedList {
    static class Node {
        int data;
        Node Next;

        Node(int data) {
            this.data = data;
            this.Next = null;
        }
    }

    Node head = null;
    Node tail = null;
    int size = 0;

    public void addNode(int data) {
        // Constant time
        size++;
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.Next = newNode;
            tail = newNode;
        }
    }

    public int getSize() {
        return size;
    }

    public void PrintList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " , ");
            current = current.Next;
        }
    }

    public int getatAnyPoint(int pos) {
        if (head != null) {
            Node current = head;
            for (int i = 1; i < pos - 1; i++) {
                current = current.Next;

            }
            return current.data;
        }
        return -999999;
    }

}
