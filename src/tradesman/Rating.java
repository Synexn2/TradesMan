package tradesman;

import java.util.Vector;

public class Rating implements java.io.Serializable
{
    private int id;
	private String tradesmanPin;
    private String customerName;
    private String remarks;
    private int score;
    
    //Constructor
    public Rating(){
        
    }
    
    public void rateTradesman(Rating rating){
        //Create a new rating record
    }
    
    public Vector getCustomerRatings(){
        //Retrieve a list of all ratings records
        return new Vector();
    }
    
    public double getCummulativeRating(){
        double cumm = 0;
        //Compute all customer rating for a tradesman
        //Store result in variable cumm
        
        return cumm;
    }
    
        //Get and set accessor methods

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTradesmanPin()
    {
        return tradesmanPin;
    }

    public void setTradesmanPin(String tradesmanPin)
    {
        this.tradesmanPin = tradesmanPin;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    } 
    
}
