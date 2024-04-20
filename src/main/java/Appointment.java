import java.time.LocalDate;

public class Appointment implements Comparable<Appointment> {
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String issue;
    private int triageLvl;
    private String docName;

    /**
     * Constructs a new Appointment object with default values for all fields
     *
     * All strings will be empty, date will be set to current date, int will be 0
     */
    public Appointment(String john, String doe, LocalDate now, String checkup, LocalDate nowed, int i, String s) {
    }

    /**
     * Constructs a new Appointment object with specific fields
     *
     * All strings will be empty, date will be set to current date, int will be 0
     */
    public Appointment(String firstName, String lastName, LocalDate dob, String issue, int triageLvl, String docName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.issue = issue;
        this.triageLvl = triageLvl;
        this.docName = docName;
    }

    /**
     * Get first name of patient
     *
     * @return String pFirstname, the first name of the patient
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get last name of patient
     *
     * @return String pLastname, the last name of the patient
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get Date of birth of patient
     *
     * @return localDate pDOB, the date of birth of patient
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * Get issue of patient
     *
     * @return issue, String of the issue patient has
     */
    public String getIssue() {
        return issue;
    }

    /**
     * Get Triage level
     *
     * @return triageLvl, int of triage level for patients issue
     */
    public int getTriageLvl() {
        return triageLvl;
    }

    /**
     * Get doctors name
     *
     * @return docName, string of doctors name
     */
    public String getDocName() {
        return docName;
    }

    /**
     * Sets the first name of patient to parameter
     *@param firstName, the new name
     * @return pFirstName, the string updated first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name of patient to parameter
     *@param lastName, the new name
     * @return pLastName, the string updated last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Set the value of patients DOB
     * @param  pDOB, the new date of birth
     * @return pDob, the updated date of birth for patient
     */
    public void setDob(LocalDate pDOB) {
        this.dob = dob;
    }

    /**
     * Set the value of issue of patient
     * @param issue
     * @return issue, the updated string issue of patient
     */
    public void setIssue(String issue) {
        this.issue = issue;
    }

    /**
     * Set the triage Level of patient
     * @param  triageLvl
     * @return triageLvl, updated int triage level of patient
     */
    public void setTriageLvl(int triageLvl) {
        this.triageLvl = triageLvl;
    }

    /**
     * Set the doctors name
     * @param  docName
     * @return docName, the updated string doctors name
     */
    public void setDocName(String docName) {
        this.docName = docName;
    }

    /**
     * Gets the Appointment object displayed as a string
     *
     * @return String representation of the object
     */
    @Override
    public String toString() {
        return "Appointment{" + "firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", issue=" + issue + ", triageLvl=" + triageLvl + ", docName=" + docName + '}';
    }

    /**
     * Compares this object to a particular object to see if equal
     * @param o, object to compare with
     * @return boolean, true if object equals specified object, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Appointment)) {
            return false;
        }
        Appointment appointment = (Appointment) o;
        return triageLvl == appointment.triageLvl &&
                firstName.equals(appointment.firstName) &&
                lastName.equals(appointment.lastName) &&
                dob.equals(appointment.dob) &&
                issue.equals(appointment.issue) &&
                docName.equals(appointment.docName);
    }
    
    @Override
    public int compareTo(Appointment other) {
        if (this.triageLvl != other.triageLvl) {
            return Integer.compare(this.triageLvl, other.triageLvl);
        } else {
            return this.dob.compareTo(other.dob);
        }
    }
}
