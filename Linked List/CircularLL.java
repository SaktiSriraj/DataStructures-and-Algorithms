import java.util.Scanner;
class circularLL_node
{
	int info;
	circularLL_node next;
}
public class CircularLL {
	static circularLL_node head = null, tail = null;   // list empty

	static void create()	{
		circularLL_node p = new circularLL_node();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter info:");
		p.info = sc.nextInt();
		head = tail = p; // p is the head & tail now
		p.next =  head;
				
		System.out.println("Do you want to continue: y/Y");
		char choice = sc.next().charAt(0);
		while(choice == 'y' || choice == 'Y')		{
			circularLL_node q = new circularLL_node();
			System.out.println("enter info:");
			q.info = sc.nextInt();
			p.next = q;  // connection between p & q is established
			q.next = head;  // connection between q & head is established
			tail = q;  // q is tail now
			p = q;
			System.out.println("Do you want to continue: y/Y");
		    choice = sc.next().charAt(0);
		}
		print();
	}
	static void print(){
		if(head == null)
			System.out.println("List is empty/underflow");
		else
		{
			circularLL_node d =  head;
			System.out.println("List is:");
			do
			{
				System.out.print(d.info+" ---> ");
				d = d.next;
			}while(d!=tail.next);
		}
	}
	static void insert(){
		circularLL_node p = new circularLL_node();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter new circularLL_node info to insert:");
		p.info = sc.nextInt();
		System.out.println("enter the location for insertion:");
		int loc = sc.nextInt();
		int end = count(); // finding end of the list
		if (loc == 1) // insert at beginning
		{
			p.next=head;
			tail.next = p;
			head=p;
		}
		else if(loc==(end+1)){ // insert at end
		
			tail.next= p;
			p.next = head;
			tail = p;
		}
		else{// insert at any location other than front & end
		
			circularLL_node d = head;
			for(int i=1;i<loc-1; i++)
			{  d=d.next;  }
			p.next= d.next;
			d.next=p;
		}
		print();
	}
	static void delete(){
		if(head == null)
			System.out.println("list empty/underflow");
		else if(head.next == head){// if list contains only a single circularLL_node
			System.out.println("Deleting:  " + head.info);
			head = tail = null;
			print();
		}
		else{
			Scanner sc = new Scanner(System.in);
		   	System.out.println("enter the location to delete:");
			int loc = sc.nextInt();
		   	int end = count(); // finding end of the list
		   	if(loc == 1){ // delete at front
		    
		    	System.out.println("Deleting:  " + head.info);
		    	head=head.next;
		    	tail.next = head;
			}
			else{  // delete at any position other than front
				
				circularLL_node d = head;
				circularLL_node q= new circularLL_node();
				for(int i=1; i<loc; i++){
					q=d;
					d=d.next;
				}
				System.out.println("Deleting:  " + d.info);
				q.next = d.next;
				if(loc==end)  // delete at end is included
					tail=q;
			}
		   	print();
		}
	}
	static void search(){
		Scanner sc = new Scanner(System.in);
		if(head==null)
			System.out.println("list is empty/underflow");
		else{
			circularLL_node d = head;
			int i = 1, flag=0;
			System.out.println("enter element to search:");
			int item = sc.nextInt();
			do{
				if(item == d.info)
				{
					System.out.println("element found at location " + i);
					flag = 0;
					break;
				}
				else {flag = 1;}
				d = d.next;
				i++;
			}while(d!=tail.next);
			if(flag==1)
				System.out.println("element not found");
		}
	}
	
	static int count(){
		int c = 0;
		circularLL_node d = head;
		if(d == null)
			System.out.println("list is empty/underflow");
		else{
			do{
				d = d.next;
				c++;
			}while(d!=tail.next);
		}
		return c;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("\n****MENU*****");
			System.out.println("0:Exit");
			System.out.println("1:Creation");
			System.out.println("2:Insert at any position");
			System.out.println("3:Delete at any position");
			System.out.println("4:Search an element");
			System.out.println("5:Count the list");
			System.out.println("ENTER CHOICE FROM MENU:");
			int choice=sc.nextInt();
			switch(choice){
				case 0: System.exit(0);
				case 1:	create(); break;
				case 2: insert(); break;
				case 3: delete(); break;
				case 4: search(); break;
				case 5: int c = count();
						System.out.println("Total number of nodes = " + c);
						break;
				default:
					System.out.println("Wrong choice");
			}
		}
	}
}