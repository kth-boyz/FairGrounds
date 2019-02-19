package FairGrounds.Domain;

public interface ExpertiseProfileDTO {

    public Person getPerson();

    public Expertise getExpertise();

    public long getYearsOfEx();

    public void setPerson(Person personId);

    public void setExpertise(Expertise expertise);

    public void setYearsOfEx(long yearsOfEx);



}
