package tradesman;

import java.util.Vector;

public class Trade implements java.io.Serializable
{

	private ApplicationDAO appDAO = new ApplicationDAO();
    private int id;
	private String name;
    private String description;
    
    public Trade(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

    public Trade(int id, String name) {
		super();
		this.name = name;
		this.id = id;
	}
	//Constructor
    public Trade(){
        
    }
    
    
    public Trade getTrade(String name){
        //Retrieve a Trade record
        return new Trade();
    }
    
    public Vector getAllTrade(){
        //Retrieve a List of all Trades
        return new Vector();
    }
    
        //Get and set accessor methods

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTradeName(int tradeId)
    {
        return appDAO.getTradeName(tradeId);
    }
	
	public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
    public void createTrade()
    {
    	appDAO.createTrade(this);
    }
     
    public Vector<Trade> getTrades()
    {
    	
    	return appDAO.getTrades();
    }
}
