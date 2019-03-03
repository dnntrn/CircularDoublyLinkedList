

import project2.CircularDoublyLinkedList;

/**
 * This is a simple tester class for project 2 to test my implementation
 * of a CircularDoublyLinkedList
 *
 *@author Deanna Tran
 */
public class Tester {

	public static void main(String[] args) throws CloneNotSupportedException {

		//create an empty list
		CircularDoublyLinkedList<String> list = new CircularDoublyLinkedList<>();

		//print an empty list (should work because toString method is overrided)
		System.out.println(list);

		//add and remove elements
		list.addFirst("A");
		list.addLast("B");

		System.out.println(list);

		list.removeLast();

    System.out.println(list);

		list.removeFirst();

    System.out.println(list);


    //add alphabet to the list
		for (int i = 0; i < 13; i++) {
			list.addLast((char)('N' + i) + "");
      list.addFirst((char)('M' - i) + "");
		}

		System.out.println( list );

    //clear the list
		for (int i = 0; i < 13; i++) {
			list.removeFirst();
			list.removeLast();
		}

		System.out.println(list);



		//populate a list and create its clone
		for (int i = 0; i < 5; i++) {
			list.addFirst((char)('Z' - i) + "");
		}

		CircularDoublyLinkedList<String> list_clone = list.clone();

		if (!list.equals(list_clone)) {
			System.out.println("PROBLEM: list and clone not equal. Check clone() method.");
		}

    System.out.println();
    System.out.println("Next two lists should equal: ");
		System.out.println("og list: " + list);
		System.out.println("list clone: " + list_clone);
    System.out.println();

		list.removeFirst();
		list.addLast("K");
		list_clone.set(3, "M");


		if (list.equals(list_clone)) {
			System.out.println("PROBLEM: list and its clone should no longer be equal. Check clone() method.");
		}

    System.out.println();
    System.out.println("Next two lists should not equal: ");
    System.out.println("og list: " + list);
		System.out.println("list clone: " + list_clone);
    System.out.println();

		//rotate the list in both directions
		list.rotate();

		System.out.println(list);

		list.rotateBackward();
		list.rotateBackward();
		list.rotateBackward();
		list.rotateBackward();

		System.out.println(list);


	}

}
