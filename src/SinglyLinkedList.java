public class SinglyLinkedList {

    Node header;

    SinglyLinkedList(){
        header = new Node();
    }

    static class Node{
        int data;
        Node next = null;
    }

    void append(int d){
        Node end = new Node();
        end.data = d;
        Node n = header;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    void delete(int d){
        Node n = header;
        while(n.next != null){
            if(n.next.data == d){
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    void retrieve(){
        Node n = header.next;

        while(n.next != null){
            System.out.println("data => "+n.data);
            n = n.next;
        }
        System.out.println("data => "+n.data);
    }


}

