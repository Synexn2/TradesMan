package tradesman;

import java.util.Date;

public class Diary implements java.io.Serializable
{
    private int id;
	private Date startDate;
    private Date endDate;
    private String reason;
    
    public Diary(){
        //Constructor 
    }

    public boolean checkAvailability(Date jobDate){
        //Check diary to ensure the date is not booked
        //if booked, return false else return true
        return false;
    }
    
    public void setNonAvailability(Diary record){
        //Create a new Diary record   
    }
    
        //Get and set accessor methods
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate()
    {
        return startDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    public String getReason()
    {
        return reason;
    }

    public void setReason(String reason)
    {
        this.reason = reason;
    }
    
}
