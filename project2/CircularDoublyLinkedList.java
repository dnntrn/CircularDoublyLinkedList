package project2;


/**
 * This class represents a CircularDoublyLinkedList.
 * Every CircularDoublyLinkedList has a String representing the linkedList itself.
 * They also have a head, tail, and size.
 * This class implements Cloneable and overrides the clone() method. It has methods that allow the program to
 * set an element in the linkedList, add Nodes, remove Nodes, and get values from the linkedList.
 *
 * This class also has a nested private class representing the Nodes.
 *
 * @author Deanna Tran
 *
 */
public class CircularDoublyLinkedList<E> implements Cloneable{


	/**
	 * This is a nested private class representing a Node; it is for internal usage only.
	 * Every node has an element value, previous Node, and next Node.
	 * This class has methods that allows the program to return and set Nodes and elements.
	 *
	 */
	private static class Node<E>{
		private E element;
		private Node<E> prev;
		private Node<E> next;


		/**
		 * Constructs a Node and sets data fields to element, prev, and next
		 *
		 * @param e generic type representing the element of that node
		 * @param b generic node type representing the previous node that the current node points to
		 * @param a generic node type representing the next node that the current node points to
		 *
		 */
		public Node(E e, Node<E> b, Node<E> a) {
			element = e;
			prev = b;
			next = a;

		}


		/**
		 * Method gets element value
		 *
		 * @return element returns generic type that represents the element in the current node
		 *
		 */
		public E getElement(){
			return element;
		}


		/**
		 * Method sets the element value
		 *
		 * @param element generic type representing the new element value to
		 * change the current element value to
		 *
		 */
		public void setElement(E element) {
			this.element = element;
		}


		/**
		 * Method that sets the next node
		 *
		 * @param n generic node type that represents the new node to make current node point to
		 *
		 */
		public void setNext(Node <E> n) {
			next = n;
		}


		/**
		 * Method gets next value
		 *
		 * @return next returns generic node type that represents the node that is after the current node
		 * in the linkedList
		 *
		 */
		public Node<E> getNext() {
			return next;
		}


		/**
		 * Method that sets the previous node
		 *
		 * @param n generic node type that represents the new node to make current node point to
		 *
		 */
		public void setPrev(Node <E> n) {
			prev = n;
		}


		/**
		 * Method gets next value
		 *
		 * @return prev returns generic node type that represents the node that is before the current node
		 * in the linkedList
		 *
		 */
		public Node<E> getPrev() {
			return prev;
		}
	//end of nested private Node class
	}







	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;


	/**
	 *Constructs the CircularDoublyLinkedList
	 *
	 */
	public CircularDoublyLinkedList (){

	}


	/**
	 * Method returns the size of the current lnkedList
	 *
	 * @return size returns the size of the linkedList
	 *
	 */
	public int size () {
		return size;

	}


	/**
	 * Method that checks whether the linkedList is empty
	 *
	 * @return true or false returns true if the linkedList is empty, if not, returns false
	 *
	 */
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}


	/**
	 * Method that adds a node with a specified element to the beginning of the linkedList
	 *
	 * @param element generic type that represents the element value for the new added node
	 *
	 */
	public void addFirst(E element) {
		Node <E> newest = new Node<> (element, null, null);
		if (this.isEmpty()) {
			//make single node point to itself
			head = newest;
			head.setPrev(head);
			head.setNext(head);
			tail = head;
			tail.setNext(head);
		} else {
			newest.setNext(head);
			head.setPrev(newest);
			newest.setPrev(tail);
			tail.setNext(newest);
			head = newest;
		}

		size += 1;
	}


	/**
	 * Method that adds a node with a specified element to the end of the linkedList
	 *
	 * @param element generic type that represents the element value for the new added node
	 *
	 */
	public void addLast(E element) {
		Node<E> newest = new Node<>(element, null, null);
		if (this.isEmpty()) {
			//make single node point to itself
			head = newest;
			head.setPrev(head);
			head.setNext(head);
			tail = head;
			tail.setNext(head);
		} else {
			tail.setNext(newest);
			newest.setPrev(tail);
			head.setPrev(newest);
			newest.setNext(head);
			tail = newest;
		}
		size += 1;
	}


	/**
	 * Method that returns the element value of the first node of the linkedList
	 *
	 * @return generic type that represents the element value of the first node in the linkedList
	 *
	 */
	public E first(){
		if (this.isEmpty()) {
			return null;
		}

		return head.getElement();
	}


	/**
	 * Method that returns the element value of the last node of the linkedList
	 *
	 * @return generic type that represents the element value of the last node in the linkedList
	 *
	 */
	public E last(){
		if (this.isEmpty()) {
			return null;
		}

		return tail.getElement();
	}


	/**
	 * Method that gets the element value of the node in the provided index parameter
	 *
	 * @param index index integer value representing the index of the node in the
	 * linkedList where the element value should be returned
	 * @return cur.getElement() returns the element value of the node in the specified index
	 * @throws IndexOutOfBoundsException the out of bounds exception occurs when
	 * the index is greater than the size of the linkedList or less than zero
	 *
	 */
	public E get(int index) throws IndexOutOfBoundsException{
		if ((index >= size) || (index < 0)){
			throw new IndexOutOfBoundsException ("Invalid Index. Too big or too small for list.");
		}

		int counter = 0;
		Node <E> cur = head;

		while (counter != index) {
			cur = cur.getNext();
			counter += 1;
		}

		return cur.getElement();
	}


	/**
	 * Method that sets the element value of the node in the provided index parameter
	 *
	 * @param index index integer value representing the index of the node in the
	 * linkedList where the element value should be changed
	 * @param element element value that the current element value in the specified node should be changed to
	 * @return temp returns the element value that was previously in the specified position before the change
	 * @throws IndexOutOfBoundsException the out of bounds exception occurs when
	 * the index is greater than the size of the linkedList or less than zero
	 *
	 */
	 public E set(int index, E element) throws IndexOutOfBoundsException{
		if ((index >= size) || (index < 0)) {
			throw new IndexOutOfBoundsException("The index is out of bounds.");
		}

		Node <E> cur = head;
		int counter = 0;

		while(counter < index) {
			cur = cur.getNext();
			counter += 1;
		}

		E temp = cur.getElement();
		cur.setElement(element);
		return temp;
	}


	/**
	 * Method that moves the first element of the list to the end of the list
	 *
	 */
	public void rotate() {
		if (!this.isEmpty() && size > 1) {
			tail = head;
			head = head.getNext();
		}

	}


	/**
	 * Method that moves the last element of the list to the beginning of the list
	 *
	 */
	public void rotateBackward() {
		if (!this.isEmpty() && size > 1) {
			head = tail;
			tail = tail.getPrev();
		}

	}


	/**
	 * Method that removes the first node in the linkedList
	 *
	 * @return remove.getElement() returns the element value of the removed node
	 */
	public E removeFirst() {
		Node<E> remove = head;
		if (this.isEmpty()) {
			return null;
		}

		head = head.getNext();
		tail.setNext(head);
		size -=1;
		return remove.getElement();
	}


	/**
	 * Method that removes the last node in the linkedList
	 *
	 * @return remove.getElement() returns the element value of the removed node
	 */
	public E removeLast() {
		Node<E> remove = tail;
		if (this.isEmpty()) {
			return null;
		}

		head.setPrev(tail.getPrev());
		tail = tail.getPrev();
		tail.setNext(head);
		size -=1;
		return remove.getElement();
	}


	/**
	 * Method that overrides the clone() method from the Object class, and creates a copy of the current linkedList
	 *
	 * @return other returns the CircularDoublyLinkedList<E> duplicate of the original CircularDoublyLinkedList<E>
	 *
	 */
	@Override
	public CircularDoublyLinkedList<E> clone() throws CloneNotSupportedException {
		@SuppressWarnings("unchecked")
		CircularDoublyLinkedList<E> other =  (CircularDoublyLinkedList<E>) super.clone();
		if (!this.isEmpty()) {
			other.head = new Node<> (head.getElement(), null, null);
			Node <E> walk = head.getNext();
			Node <E> otherTail = other.head;

			while (walk != head) {
				Node <E> newest = new Node<> (walk.getElement(), null, null);
				otherTail.setNext(newest);
				newest.setPrev(otherTail);
				otherTail = newest;
				walk = walk.getNext();
			}

			other.head.setPrev(otherTail);
			other.tail = otherTail;
			otherTail.setNext(other.head);
		}

		return other;
	}


	/**
	 * Method that checked whether the current linkedList and a  specified linkedList are equal in size
	 * and order of elements
	 *
	 * @param o Object type variable that represents the specified linkedList that the current linkedList
	 * will be compared to
	 * @return  true or false returns true if the linkedList equal, and false if they don't equal
	 *
	 */
	@Override
	public boolean equals (Object o) {
		if (!(o instanceof CircularDoublyLinkedList)) {
			return false;
		}

		@SuppressWarnings("unchecked")
		CircularDoublyLinkedList <E> parameter = (CircularDoublyLinkedList <E>) o;
		if (parameter.size != this.size) {
			return false;
		}

		int counter = 0;
		Node <E> cur = head;
		Node <E> paramCur = parameter.head;

		while (counter < size) {
			if (!cur.getElement().equals(paramCur.getElement())) {
				return false;
			}

			cur = cur.getNext();
			paramCur = paramCur.getNext();
			counter += 1;
		}

		return true;
	}


	/**
	 * Method that overrides the toString method in the Object class
	 *
	 * @return str.toString() returns a String representation of the linkedList
	 *
	 */
	@Override
	public String toString() {
		Node<E> cur = new Node<> (null, null, null);
		cur = head;
		int counter = 0;
		StringBuilder str = new StringBuilder("[");
		while (counter < size) {
			str.append (cur.getElement());
			if (cur != tail) {
				str.append(", ");
			}

			cur = cur.getNext();
			counter += 1;
		}
		str.append ("]");
		return str.toString();
	}


	/**
	 * Method that adds a node using the provided index
	 * @param element generic type that represents the element value for the new added node
	 * @param index integer value that represents the index where the new node should be added
	 * @throws IndexOutOfBoundsException the out of bounds exception occurs if the index
	 * is less than zero or greater than the size of the linkedList
	 *
	 */
	//Note: this is my own method that I created. It was not required in the homework specs.
	public void addByIndex(E element, int index) throws IndexOutOfBoundsException{
		Node<E> newest = new Node<>(element, null, null);
		if ((index > size) || (index < 0) ) {
			throw new IndexOutOfBoundsException ("Invalid Index. Too big or too small for list.");

		} else if (index == size) {
			this.addLast(element);

		} else {
			int counter = 0;
			Node <E> cur = new Node<> (null, null, null);

			while (counter < index) {
				cur = head;
				cur = cur.getNext();
				counter += 1;
			}

			if (counter == index) {
				newest.setNext(cur);
				newest.setPrev(cur.getPrev());
				cur.setPrev(newest);
				cur.getPrev().setNext(newest);

			}
			size += 1;
		}
	}
}
