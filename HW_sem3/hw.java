public class hw {
    private Node head;
    private Node tail;

    private class Node {
        private int value;
        private Node next;
        private Node previous;
    }

    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            node.next = head;
            head.previous = node;
        } else {
            tail = node;
        }
        head = node;
    }

    public void removeFirst() {
        if (head != null && head.next != null) {
            head.next.previous = null;
            head = head.next;
        } else {
            head = null;
            tail = null;
        }
    }

    public boolean contains(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    // public void addEnd(int value) {
    // Node newNode = new Node();
    // newNode.value = value;
    // if (head == null) {
    // head = newNode;
    // } else {
    // Node node = head;
    // while (node.next != null) {
    // node = node.next;
    // }
    // node.next = newNode;
    // }
    // }

    public void addEnd2(int value) {
        Node node = new Node();
        node.value = value;
        if (tail != null) {
            tail.next = node;
            node.previous = tail;
        } else {
            head = node;
        }
        tail = node;
    }

    // public void delLast() {
    // if (head != null) {
    // Node node = head;
    // while (node.next != null) {
    // if (node.next.next == null) {
    // node.next = null;
    // return;
    // }
    // node = node.next;
    // }
    // head = null;
    // }

    // }

    public void delLast2() {
        if (tail != null && tail.previous != null) {
            tail = tail.previous;
            tail.next = null;
        } else {
            head = null;
            tail = null;
        }

    }

    public void sort() {
        boolean needSort;
        do {
            needSort = false;
            Node node = head;
            while (node != null && node.next != null) {
                if (node.value > node.next.value) {
                    Node before = node.previous;
                    Node after = node.next.next;
                    Node current = node;
                    Node next = node.next;

                    current.next = after;
                    current.previous = next;
                    next.next = current;
                    next.previous = before;
                    if (before != null) {
                        before.next = next;
                    } else {
                        head = next;
                    }
                    if (after != null) {
                        after.previous = current;
                    } else {
                        tail = current;
                    }

                    needSort = true;
                }
                node = node.next;
            }
        } while (needSort);
    }

    public void reverse() {
        Node current = head;
        Node temp;

        while (current != null) {
            temp = current.next;
            current.next = current.previous;
            if (temp != null) {
                current.previous = temp;
                current = temp;
            } else {
                current.previous = null;
                current = null;
            }
        }

        temp = head;
        head = tail;
        tail = temp;
    }
}
