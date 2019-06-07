package tradesman;

//@SuppressWarnings("serial")
public class User implements java.io.Serializable
{
    //The attributes were made protected so that the subclasses can have access to them since they are inherited
    private ApplicationDAO appDAO = new ApplicationDAO();
    private int id;
	private String userName;
    private String password;
	private String firstName;
    private String lastName;
    private String phoneNumber;
    private String streetName;
    private String city;
    private String county;
	private String postcode;
    private String country;
    

	 private  String email ;
	 //private double hourlyrate;
	 private byte picture ;
	 //private String tradetype;
	 //private String skillset;
	 //private String reference;
	 //private String previousjobs;
	 private String pin;
	 private String busydates;
	 
	 
	 public User(){
	        //Constructor 
	    }
	    
	    public User(int id, String userName, String password, String firstName, String lastName, String phoneNumber,
				String streetName, String city, String county, String postcode, String country, String email) {
			super();
			this.id = id;
			this.userName = userName;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			this.phoneNumber = phoneNumber;
			this.streetName = streetName;
			this.city = city;
			this.county = county;
			this.postcode = postcode;
			this.country = country;
			this.email = email;
		}

	    
	    public User(String userName, String password, String firstName, String lastName, String phoneNumber,
				String streetName, String city, String county, String postcode, String country, String email) {
			super();
			this.userName = userName;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			this.phoneNumber = phoneNumber;
			this.streetName = streetName;
			this.city = city;
			this.county = county;
			this.postcode = postcode;
			this.country = country;
			this.email = email;
			
			System.out.println("An instance of a user created with username of: "+userName);
		}

	 
	 public User(String email, double hourlyrate, byte picture, String tradetype, String skillset, String reference,
			String previousjobs, String pin, String busydates) {
		super();
		//this.email = email;
		//this.hourlyrate = hourlyrate;
		this.picture = picture;
		//this.tradetype = tradetype;
		//this.skillset = skillset;
		//this.reference = reference;
		//this.previousjobs = previousjobs;
		this.pin = pin;
		this.busydates = busydates;
	}


	public User(int id, String userName, String password, String firstName, String lastName, String phoneNumber,
			String streetName, String city, String county, String postcode, String country, String email,
			double hourlyrate, byte picture, String tradetype, String skillset, String reference, String previousjobs,
			String pin, String busydates) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.streetName = streetName;
		this.city = city;
		this.county = county;
		this.postcode = postcode;
		this.country = country;
		this.email = email;
		//this.hourlyrate = hourlyrate;
		this.picture = picture;
		//this.tradetype = tradetype;
		//this.skillset = skillset;
		//this.reference = reference;
		//this.previousjobs = previousjobs;
		this.pin = pin;
		this.busydates = busydates;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}



	public byte getPicture() {
		return picture;
	}


	public void setPicture(byte picture) {
		this.picture = picture;
	}



	public String getPin() {
		return pin;
	}


	public void setPin(String pin) {
		this.pin = pin;
	}


	public String getBusydates() {
		return busydates;
	}


	public void setBusydates(String busydates) {
		this.busydates = busydates;
	}

	
    
    
 
    public User login(String userName, String password){
        //Check to ensure user exist
        //if exist, return true else return false
        return    appDAO.login(userName, password);
    }
    
    public void logout(){
        //log current user out
        
    }
    
    public void register(User newUser){
        //Create new tradesman
        appDAO.register(newUser);
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser(String userName){
        //retrieve user details
        return new User();
    }
    
    //Get and set accessor methods

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getStreetName()
    {
        return streetName;
    }

    public void setStreetName(String streetName)
    {
        this.streetName = streetName;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCounty()
    {
        return county;
    }

    public void setCounty(String county)
    {
        this.county = county;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

    
}
