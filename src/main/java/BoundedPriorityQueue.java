public class BoundedPriorityQueue extends MyLinkedList{
 private int capacity;
 private String docName;
    public  BoundedPriorityQueue (int capacity, String docName){
        super(); // pass the capacity of th superclass
        this.capacity = capacity;
        this.docName = docName;
    }

    /**
     * adds the appointment to the queue if queue is not full and
     * if appointment is for doctor the queue belongs to
     * @param appointment the appointment to be added to the queue
     * @return true if the appointment is successfully added, false otherwise
     */
    @Override
    public boolean add(Appointment appointment) {
        if (size() >= capacity || !appointment.getDocName().equalsIgnoreCase(docName)) {
            return false;  // Queue is full or appointment is for a different doctor
        }
        return super.add(appointment);
    }

}


