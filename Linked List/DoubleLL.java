
import java.util.Scanner;

class doubleLL_node {
	int info;
	doubleLL_node next, prev;
}

public class DoubleLL {
	static doubleLL_node head = null, tail = null; // list empty

	static void create() {
		doubleLL_node p = new doubleLL_node();
		System.out.println("enter info:");
		Scanner sc = new Scanner(System.in);
		p.info = sc.nextInt();
		p.next = p.prev = null;
		head = tail = p;

		System.out.println("Do you want to continue: y/Y");
		char choice = sc.next().charAt(0);
		while (choice == 'y' || choice == 'Y') {
			doubleLL_node q = new doubleLL_node();
			System.out.println("enter info:");
			q.info = sc.nextInt();
			q.next = null;

			p.next = q; // connection bet p & q is established
			q.prev = p; // connection bet p & q is established
			tail = q; // make the q as tail
			p = q;
			System.out.println("Do you want to continue: y/Y");
			choice = sc.next().charAt(0);
		}
		print();
	}

	static void print() {
		if (head == null)
			System.out.println("List is empty/underflow");
		else {
			doubleLL_node d = head;
			System.out.println("List is:");
			while (d != null) {
				System.out.print(d.info + " ---> ");
				d = d.next;
			}
		}
	}

	static void reverse_back_print() {
		if (tail == null)
			System.out.println("List is empty/underflow");
		else {
			doubleLL_node d = tail;
			System.out.println("List is:");
			while (d != null) {
				System.out.print(d.info + " ---> ");
				d = d.prev;
			}
		}
	}

	static void search() {
		Scanner sc = new Scanner(System.in);
		if (head == null)
			System.out.println("list is empty/underflow");
		else {
			doubleLL_node s = head;
			int i = 1, flag = 0;
			System.out.println("enter element to search:");
			int item = sc.nextInt();
			while (s != null) {
				if (item == s.info) {
					System.out.println("element found at location " + i);
					flag = 0;
					break;
				} else {
					flag = 1;
				}
				s = s.next;
				i++;
			}
			if (flag == 1)
				System.out.println("element not found");
		}
	}

	static int count() {
		int c = 0;
		if (head == null)
			System.out.println("list is empty/underflow");
		else {
			doubleLL_node s = head;
			while (s != null) {
				s = s.next;
				c++;
			}
		}
		return c;
	}

	static void insert() {
		doubleLL_node p = new doubleLL_node();
		int end = count(); // storing the total no. of nodes
		Scanner sc = new Scanner(System.in);
		System.out.println("enter new doubleLL_node info:");
		p.info = sc.nextInt();
		System.out.println("enter the location to insert:");
		int loc = sc.nextInt();
		if (loc == 1){ // insert at front
			head.prev = p;
			p.next = head;
			p.prev = null;
			head = p;
		} else if (loc == (end + 1)){ // insert at end
			tail.next = p;
			p.prev = tail;
			p.next = null;
			tail = p;
		} else if (loc > (end + 1))
			System.out.println("can't insert after list ends");
		else { // insert at location other than front & end
			doubleLL_node s = head;
			for (int i = 1; i < loc - 1 && s.next != null; i++) {
				s = s.next;
			}
			p.next = s.next;
			s.next.prev = p;
			s.next = p;
			p.prev = s;
		}
		print();
	}

	static void delete() {
		if (head == null)
			System.out.println("list empty/underflow");
		else if (head.next == null){ // if list contains only a single doubleLL_node
			System.out.println("doubleLL_node deleted: " + head.info);
			head = tail = null;
		} else {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter location to delete:");
			int loc = sc.nextInt();
			int end = count();

			if (loc == 1) {// delete at front
				System.out.println("doubleLL_node deleted: " + head.info);
				head = head.next;
				head.prev = null;
			} else if (loc == end){ // delete at end
				System.out.println("doubleLL_node deleted: " + tail.info);
				tail = tail.prev;
				tail.next = null;
			} else{ // delete at any position
				doubleLL_node s = head;
				doubleLL_node q = new doubleLL_node();
				for (int i = 1; i < loc && s.next != null; i++) {
					q = s;
					s = s.next;
				}
				q.next = s.next;
				s.next.prev = q;
				System.out.println("doubleLL_node deleted: " + s.info);
			}
		}
		print();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n****MENU*****");
			System.out.println("0:Exit");
			System.out.println("1:Creation");
			System.out.println("2:Insert at any position");
			System.out.println("3:Delete at any position");
			System.out.println("4:Reverse/Back_display the list");
			System.out.println("5:Search an element");
			System.out.println("6:Count the list");
			System.out.println("ENTER CHOICE FROM MENU:");
			int choice = sc.nextInt();
			switch (choice) {
				case 0:
					System.exit(0);
				case 1:
					create();
					break;
				case 2:
					insert();
					break;
				case 3:
					delete();
					break;
				case 4:
					reverse_back_print();
					break;
				case 5:
					search();
					break;
				case 6:
					int c = count();
					System.out.println("Total number of nodes = " + c);
					break;
				default:
					System.out.println("Wrong choice");sc.close();
			}
		}
		
	}
}
