package tradesman;

import java.util.Vector;

public class Tradesman extends User
{
	private ApplicationDAO appDAO = new ApplicationDAO();
    private int id;
    //private String email;
    private double hourlyRate;
   // private byte picture;
    private int tradeType;
    private String skillSet;
    private String reference;
    private String previousJobs;
   // private String pin;
    //private Diary busyDates;
    private int userId;
    
   
    
    public Tradesman(int id, double hourlyRate, int tradeType, String skillSet, String reference, String previousJobs, int userId) {
		super();
		this.hourlyRate = hourlyRate;
		this.tradeType = tradeType;
		this.skillSet = skillSet;
		this.reference = reference;
		this.previousJobs = previousJobs;
		this.userId = userId;
	}
    
    public Tradesman(int id, String userName, String password, String firstName, String lastName, String phoneNumber,
			String streetName, String city, String county, String postcode, String country, String email) {
		super(id,userName,  password,  firstName,  lastName,  phoneNumber,
				 streetName,  city,  county,  postcode,  country, email);
	}

	public Tradesman() {
		super();
	}


	public void createProfile(){ 
        //Create a new Tradesman profile record
		appDAO.createProfile(this);
    }
	
	public Vector getProfile(int userId){
		return appDAO.getProfile(userId);
	}
    
    public void editProfile(Tradesman tradesman){
        //Edit an existing Tradesman profile record
    }
    
    public void deleteProfile(Tradesman tradesman){
        //Delete an existing Tradesman profile record
    }
    
    public Vector getTradesMen(String searchParameter){
    	
    	return appDAO.getTradesMen(searchParameter);
    }
    
    public Tradesman getTradesman(String email){
        //retrieve a Tradesman record
        
        return new Tradesman();
    }
    
    public Vector getAllTradesman(){
        //retrieve a list of all existing Tradesman
        
        return new Vector();
    }
    
        //Get and set accessor methods
    
    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	

    public double getHourlyRate()
    {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate)
    {
        this.hourlyRate = hourlyRate;
    }

    

    public int getTradeType()
    {
        return tradeType;
    }

    public void setTradeType(int tradeType)
    {
        this.tradeType = tradeType;
    }

    public String getSkillSet()
    {
        return skillSet;
    }

    public void setSkillSet(String skillSet)
    {
        this.skillSet = skillSet;
    }

    public String getReference()
    {
        return reference;
    }

    public void setReference(String reference)
    {
        this.reference = reference;
    }

    public String getPreviousJobs()
    {
        return previousJobs;
    }

    public void setPreviousJobs(String previousJobs)
    {
        this.previousJobs = previousJobs;
    }

    

}
