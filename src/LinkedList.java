public class LinkedList<Type> {


    private LinkedList next;
    private Type value;
    private LinkedList root;

    public LinkedList() {
        root = this;
    }


    public LinkedList getNext() {
        return next;
    }

    public void setNext(LinkedList next) {
        if(next != null){
            this.next = next;
            this.next.root = root;
        }
    }

    public Type getValue() {
        return value;
    }

    public void setValue(Type value) {
        this.value = value;
    }


    public boolean checkCycle() {

        if (root == null || root.next == null) {
            return false;
        }

        LinkedList slow = root;
        LinkedList fast = root.next;

        while (slow != null && fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }

        }
        return false;
    }


    public LinkedList findByValue(Type value) {
        LinkedList current = root;
        while (current != null) {
            if (current.value == value) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

}
