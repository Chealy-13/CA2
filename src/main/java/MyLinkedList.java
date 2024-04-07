

public class MyLinkedList {

        private static Node head;
        private static Node tail;
        private static int numElements;
        private static final int MAX_SIZE = 10;

        public MyLinkedList(){
            head = null;
            numElements = 0;
        }


//1. A method called size() that takes no parameters & returns the number of Songs currently stored in your list.

        /**
         * Returns the num of songs currently in the list
         *
         * @return size of the list
         */
        public int size() {
            return numElements;
        }

//2. A method called get() that takes one parameter, an int representing the position from which data should be
//    retrieved. The position should be validated and invalid positions handled accordingly.
//    If the position is valid, the method should return the data (a Song) in the position specified.

        /**
         * Returns song at specific position in list
         *
         * @param pos of song to returned
         * @return song/element at position
         * @throws IndexOutOfBoundsException if the index is out of range i.e below 0 or too big for list size
         */
        public Appointment get(int pos) {
            if (pos < 0 || pos >= numElements) {
                throw new IndexOutOfBoundsException("Index out of bounds: " + pos);
            } else {
                Node current = head;
                for (int i = 0; i < pos; i++) {
                    current = current.next;
                }
                return (Appointment) current.data;
            }
        }


//4. A method called add() that takes a single parameter,
// a Song to be added to the end of the list.

//+ random gen Q1
//Your linkedlist should be implemented as a bounded list, i.e. limited in size.
//You should include the appropriate method or methods to facilitate this,
//and the logic of your class should uphold this requirement throughout.

        /**
         * Adds new song to end of the list
         * @param appointment to be added
         * @return true if song added and false if list is full
         */
        public boolean add(Appointment appointment) {
            if (numElements >= MAX_SIZE){
                return false;//if the list is already full then do not add new song
            }
            Node newNode = new Node(appointment);
            if (tail == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            numElements++;
            return true;
        }

//5.A method called isEmpty() that takes no parameters.
//This should return a boolean indicating if there is data
//currently stored in the list
        /**
         * returns true or false depending on if list is empty or not
         * @return true if list empty, false otherwise
         */
        public boolean isEmpty() {
            return numElements == 0;
        }

//6. A method called tail() that takes no parameters.
// This should return the last element in the list.
        /**
         * returns last element in the list
         * @return last element in the list or null if list is empty
         */
        public Appointment tail() {
            if (tail == null) {
                return null;
            }
            return (Appointment) tail.data;
        }




        protected static class Node<E> {
            private E data;
            private Node<E> next;

            public Node(E data) {
                this.data = data;
                this.next = null;
            }

            public void add(E element) {
                Node<E> newNode = new Node<>(element);
                if (head == null) {
                    head = newNode;
                } else {
                    Node<E> current = head;
                    while (current.next != null) {
                        current = current.next;
                    }
                    current.next = newNode;
                }
                numElements++;
            }

//            public void setNext(Node next) {
//                this.next = next;
//            }
//
//            public Node getNext() {
//                return this.next;
//            }
//
//            public void setData(Song data) {
//                this.data = data;
//            }
//
//            public Song getData() {
//                return this.data;
//            }
        }
    }

