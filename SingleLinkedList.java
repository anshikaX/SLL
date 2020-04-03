import java.util.Scanner;
public class SingleLinkedList
{
    static Node head=null;
    static Node tail=null;
    static Scanner sc = new Scanner(System.in);

    //Creating a linked list
    public void createSingleLinkedList()
    {
        System.out.println("Enter the number of nodes");
        int n=sc.nextInt();

        for(int i=0;i<n;i++)
        {
            Node temp = new Node();
            System.out.println("Enter the value in a node");
            int value = sc.nextInt();
            temp.data = value;

            if (head == null)
            {
                head = temp;
                tail = temp;
            }
            else
                {
                tail.next = temp;
                tail = temp;
            }
        }

    }

    //Traversal of Single Linked List
    public void display()
    {
        Node currentNode = head;
        while(currentNode!=null )
        {
            System.out.println(currentNode.data + " ");
            currentNode=currentNode.next;
        }
    }

    //Insertion of a node at start,end and beginning position
    public void insertNode()
    {
        Node temp = new Node();
        System.out.println("\n1.Insert in the beginning \n2.Insert at the specified position \n3.Insert at the end of the list");
        int choice = sc.nextInt();

        switch(choice)
        {
            case 1:
                System.out.println("Enter the value in a node");
                int value1 = sc.nextInt();
                temp.data = value1;
                if (head == null)
                {
                    head = temp;
                    tail = temp;
                }
                else
                    {
                    temp.next = head;
                    head = temp;
                }
                break;

            case 2:
                System.out.println("Enter the value in a node");
                int value2 = sc.nextInt();
                temp.data = value2;
                System.out.println("Enter the position where you want to create a node");
                int position = sc.nextInt();

                if(position==1)
                {
                    temp.next = head;
                    head = temp;

                }
                else
                    {
                    Node currentNode = head;
                    int counter = 1;
                    while (currentNode != null)
                    {
                        if (counter == position - 1)
                        {
                            break;
                        }
                        currentNode = currentNode.next;
                        counter = counter + 1;

                    }
                    if (currentNode != null)
                    {
                        temp.next = currentNode.next;         //Temp node gets the address of it's next node
                        currentNode.next = temp;              //Current Node gets the address of temp node to make a link
                        if (currentNode == tail)
                        {
                            tail = temp;
                        }
                    }
                    else
                        {
                        System.out.println("Invalid position!!");
                    }
                    break;
                }


            case 3:
                System.out.println("Enter the value in a node");
                int value3 = sc.nextInt();
                temp.data=value3;
                if(head==null)
                {
                    head=temp;
                    tail=temp;
                }
                else
                {
                    tail.next=temp;
                    tail=temp;
                }
                break;

            default:
                System.out.println("Invalid choice!!  \n\n Please select a suitable choice ");
                insertNode();

        }

    }

    //Searching for a given value in a node
    public void search()
    {
        System.out.println("Enter the value that you want to search");
        int value=sc.nextInt();
        Node currentNode = head;
        int counter=1;
        while(currentNode!=null)
        {
            if(currentNode.data==value)
            {
                System.out.println("Value found!!");
                System.out.println("Value is: " +currentNode.next + " and it's position is: " +counter);
                break;
            }
            counter++;
            currentNode=currentNode.next;
        }
        if(currentNode==null)
        {
            System.out.println("Value doesn't exist in the linked.");
        }

    }

    //Deleting of node from SingleLinkedList which has a given value
    public void delete()
    {
        System.out.println("\n1. Delete the node from the beginning of the list. \n2.Delete the node at the specific position. \n3.Delete the node from the end of the list.");
        int choice = sc.nextInt();

        switch(choice)
        {
            case 1:
                if(head==null)
                {
                    System.out.println("There is no node.Linked list doesn't exist!");
                }
                else if(head==tail)   //There is just one node who's reference is with head and tail.To destroy the link,update head and tail with null
                {
                    head=null;
                    tail=null;
                }
                else                //More than one node's case
                {
                    head = head.next;
                }
                break;

            case 2:
                System.out.println("Enter the position of the node that you want to delete");
                int pos=sc.nextInt();
                if(head==null)
                {
                    System.out.println("Linked list doesn't exist!!!");
                }
                else if(head!=tail && pos==1)
                {
                    head=head.next;
                }
                else
                    {
                    Node current_node=head;
                    int counter=1;
                    while(current_node!=null)
                    {
                        if(counter==pos-1)
                        {
                            break;
                        }
                        current_node=current_node.next;
                        counter++;
                    }
                    if(current_node!=null)
                    {
                        current_node.next=current_node.next.next;
                        if(current_node==tail)
                        {
                            tail=current_node;
                        }
                    }
                    else
                        {
                        System.out.println(" Invalid position");
                    }
                }
                break;

            case 3:
                if(head==null)
                {
                    System.out.println("Linked list doesn't exits.");
                }
                else if(head==tail)   //If there is just one node that is the last node.
                {
                    head=null;
                    tail=null;

                }
                else                 //If there are more than one node
                {
                    Node currentNode = head;
                    while (currentNode.next != tail)
                    {
                        currentNode = currentNode.next;

                    }
                    currentNode.next = null;
                    tail = currentNode;
                }
                break;

                default:
                System.out.println("Invalid Choice!!  \n\n Please select suitable option");
                delete();

        }

    }

    //Deleting entire Linked list
    public void deleteSLL()
    {
        System.out.println("\n\n Deleting Linked list...");
        head=null;
        tail=null;
        System.out.println("Linked list deleted successfully");
    }


}