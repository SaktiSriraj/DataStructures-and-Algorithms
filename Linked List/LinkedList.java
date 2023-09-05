public class LinkedList {
    Node head;
    private int size;
    LinkedList(){
        this.size=0;
    }
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
            size++;
        }
    }

    //add first
    public void addFirst(int data){
        Node newNode = new Node(data);
        if (head==null){
            head=newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    //add last
    public void addLast(int data){
        Node newNode = new Node(data);
        if (head==null){
            head=newNode;
            return;
        }

        Node currNode = head;
        while(currNode.next!=null){
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    public void addIdx(int idx, int data){
        if(idx<0 || idx>=size)
            System.out.println("Invalid args");
        else if(idx==0)
            addFirst(data);
        else if(idx==size-1)
            addLast(data);
        else{
            Node newNode = new Node(data);
            Node temp = head;
            for(int i = 0; i<idx-1; i++)
                temp = temp.next;
            newNode.next = temp.next;
            temp.next=newNode;
        }
        size++;
    }

    //delete first
    public void deleteFirst(){
        if(head==null){
            System.out.println("The list is empty");
            return;
        }
        size--;
        head=head.next;
    }

    //delete last
    public void deleteLast(){
        if(head==null){
            System.out.println("The list is empty");
            return;
        }
        size--;
        if(head.next==null){
            head=null;
            return;
        }
        Node secLast = head;
        Node lastNode = head.next;
        while(lastNode.next!=null){
            lastNode = lastNode.next;
            secLast = secLast.next;
        }
        secLast.next = null;
    }

    //delete from index
    public void deleteAtIdx(int idx){
        if(idx<0 || idx >=size)
            System.out.println("Invalid Args");
        else if(idx==0)
            deleteFirst();
        else if(idx==(size-1))
            deleteLast();
        else{
            Node temp = head;
            for(int i=0;i<idx-1;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }
        size--;
    }

    //print list
    public void printList(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while (currNode!=null){
            System.out.print(currNode.data + " -> ");
            currNode=currNode.next;
        }
        System.out.println("NULL");
    }

    public int getSize(){
        return size;
    }

    
    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.printList();

        ll.addLast(3);
        ll.addLast(4);
        ll.printList();

        ll.addFirst(0);
        ll.addLast(5);
        ll.printList();

        ll.addIdx(3,10);
        ll.printList();

        ll.deleteFirst();
        ll.printList();

        ll.deleteLast();
        ll.printList();

        System.out.println("Size = " + ll.getSize());

        ll.deleteAtIdx(2);
        ll.printList();

        ll.addFirst(0);
        ll.addLast(5);
        ll.reverseIterate();
        ll.printList();

        ll.head = ll.reverseRecursive(ll.head);
        ll.printList();
    }

    //reverse a linked list using the iterative algorithm
    public void reverseIterate(){
        if(head==null || head.next==null){
            return;
        }
        Node prev = head;
        Node curr = head.next;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;

            //update
            prev = curr;
            curr = next;
        }
        head.next=null;
        head = prev;
    }

    //reverse the linked list recursively
    public Node reverseRecursive(Node head){
        if(head==null || head.next==null) {
            return head;
        }
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    //removing nth node from end
    public Node removeNthFromEnd(Node head, int n){
        if(head.next==null){
            return null;
        }
        int s=0;
        Node curr=head;
        while (curr!=null){
            curr=curr.next;
            s++;
        }

        if(n==s){
            return head.next;
        }

        int idxToSearch = s - n;
        Node prev=head;
        int i=0;
        while(i<idxToSearch){
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return head;

    }

    //check if the LinkedList is Palindrome
    public boolean isPalindrome(Node head){
        if(head == null || head.next==null)
            return true;
        Node middle = findMid(head);
        Node secHalfStart = reverseRecursive(middle.next);

        Node firstHalf = head;

        while(secHalfStart!=null){
            if(firstHalf.data != secHalfStart.data)
                return false;
            firstHalf = firstHalf.next;
            secHalfStart = secHalfStart.next;
        }
        return true;
    }

    //Find the middle Node
    public Node findMid(Node head) {
        Node hare = head;
        Node turtle = head;

        while(hare.next!=null && hare.next.next!=null){
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }

    //Check if the LinkedList has cycle
    public boolean hasCycle(Node head){
        if(head==null)
            return false;
        Node hare = head;
        Node turtle = head;

        while(hare!=null && hare.next!=null){
            hare = hare.next.next;
            turtle = turtle.next;

            if(turtle==hare)
                return true;
        }
        return false;
    }

    //Reverse K-groups of the linked list
    public Node reverseKGroups(Node head,int k ){
        if(head==null)
            return null;
        Node next=null;
        Node curr=head;
        Node prev=null;
        int c=0;

        while(curr!=null && c<k){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            c++;
        }
        if(head!=null)
            head.next=reverseKGroups(next,k);

        return prev;
    }

    //Remove Loop from Linkedlist
    public void removeLoop(Node head){
        if(head==null || head.next==null)
            return;
        Node slow=head.next ,fast=head.next.next;

        while(fast!=null && fast.next!=null){
            if(slow==fast)
                break;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow == fast){
            slow = head;
            if (slow == fast) {
                while(fast.next!=slow)
                    fast=fast.next;
                fast.next=null;
            } else {
                while(slow.next!=fast.next){
                    slow = slow.next;
                    fast = fast.next;
                }
                fast.next=null;
            }
        }
    }
}