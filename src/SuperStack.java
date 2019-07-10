import java.util.*;

public class SuperStack {
	LinkedList<Long> stack1;
	HashMap<Integer, Integer> numToAdd; 
	int count;
	
    public SuperStack(){
        stack1 = new LinkedList<>();
        numToAdd = new HashMap<Integer, Integer>();
        count = 0;
        //stack2 = new LinkedList<>();
    }

    public void push(long x) {
        stack1.addFirst(x);
        count++;
        System.out.println(stack1.peek());
        return;
    }

    public void pop() {
        if (count == 0) {
            System.out.println("Empty");
            return;
        }
        stack1.poll();
        count--;
        if (count == 0) {
            System.out.println("Empty");
            return;
        } else {
        	if(numToAdd.containsKey(count - 1)) {
        		stack1.set(0, stack1.peek() + numToAdd.get(count - 1));
        		numToAdd.remove(count - 1);
        	}
        		
            System.out.println(stack1.peek());
            return;
        }
    }

    public void inc(int number, int addnumber) {
        if (count == 0) {
            System.out.println("Empty");
            return;
        }
        for (int i = 0; i < number && i < count; i++) {
            if(numToAdd.containsKey(i))
            	numToAdd.put(i, numToAdd.get(i) + addnumber);
            else
            	numToAdd.put(i, addnumber);
        }
        if(number >= count) {
    		stack1.set(0, stack1.peek() + numToAdd.get(count - 1));
    		numToAdd.remove(count - 1);
        }
        System.out.println(stack1.peek());
    }

	
	public static void main(String[] args) {
	    SuperStack supstack = new SuperStack();
	    supstack.push(4);
	    supstack.pop();
	    supstack.push(3);
	    supstack.push(5);
	    supstack.inc(2, 3);
	    supstack.pop();
	    
	    System.out.println('c'-'a');
	    
//	    if (operations == null || operations.length == 0) {
//            System.out.println("EMPTY");
//            return;
//        }
//        LinkedList<Integer> list = new LinkedList<>();
//        for (int i = 0; i < operations.length; i++) {
//            String current = operations[i];
//            if (current.equals("pop")) {
//                list.removeLast();
//            } else {
//                if (current.startsWith("push")) {
//                    list.addLast(Integer.parseInt(current.split(" ")[1]));
//                } else {
//                    int e = Integer.parseInt(current.split(" ")[1]);
//                    int k = Integer.parseInt(current.split(" ")[2]);
//                    ListIterator<Integer> listIterator = list.listIterator();
//                    int j = 1;
//                    while (listIterator.hasNext()) {
//                        if (j > e)
//                            break;
//                        listIterator.set(listIterator.next() + k);
//                        j++;
//                    }
//                }
//            }
//            if (list.isEmpty())
//                System.out.println("EMPTY");
//            else
//                System.out.println(list.getLast());
//
//        }


	}
}
