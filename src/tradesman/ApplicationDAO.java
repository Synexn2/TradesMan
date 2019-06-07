package tradesman;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.apache.catalina.Session;






public class ApplicationDAO {
	
	static Connection connection ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationDAO dao = new ApplicationDAO();
		 connection = dao.getConnection();
		
		
		System.out.println("the connection is: "+connection);
		//dao.closeConnection(connection);
	}

	public Connection getConnection(){
		
		String url = "jdbc:mysql://localhost:3306/";
		Connection connection =  null ;
		 try{
			 System.out.println("trying class");
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
			 System.out.println("found class");
			 
			 
			 connection = DriverManager.getConnection(url, "root", "");
			 
		 }
		 
		 catch (Exception e)
	     {
	         e.printStackTrace();
	         System.out.println("failed class forname: "+e.getMessage());
	     }
		 
		 return connection;
		
	}
	 
	public void closeConnection(Connection connection)
	{
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void updateProfile(User user){
		
		String sql = "UPDATE user SET reference=?,hourlyRate=?,"
				+ "previousJobs=?,"
				+ "pin=?,skillSet=?"
				+ " WHERE userName = ? and password = ?";
		
		Connection conn = getConnection(); 
		
		System.out.println("Output Form Username Value : "+user.getUserName());
		System.out.println("connection is : "+conn);
		
		try{
			
			PreparedStatement statement = conn.prepareStatement(sql);
			//statement.setString(1, user.getEmail());
			//statement.setString(1, user.getReference());
			//statement.setDouble(2, user.getHourlyrate());
			//statement.setString(3, user.getPreviousjobs());
			//statement.setString(5, user.getTradetype());
			//statement.setString(4, user.getPin());
			//statement.setString(5, user.getSkillset());
			//statement.setByte(8, user.getPicture());
			statement.setString(6, user.getUserName());
			statement.setString(7, user.getPassword());
			
			statement.execute("USE tradesman");
			statement.execute();
			
		}
		catch(Exception e){
			
			System.out.println("Updating user Profile error: "+e.getMessage());
		}
		finally{
			
			closeConnection(conn);
			System.out.println("Connection closed for registering");
		}
		
	}
	
	
	private boolean checkIfUserExists(User user){
		
		String sql = "select * from user where userName = ?";
		Connection conn = getConnection();
		try{
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getUserName());
			statement.execute("USE tradesman");
			statement.execute();
			
			ResultSet results = statement.executeQuery();
			if(results.next() == false)
			{
			   return false;
			}
		}
		
       catch(Exception e){
			
			System.out.println("Registering user error: "+e.getMessage());
		}
		finally{
			
			closeConnection(conn);
			System.out.println("Connection closed for registering");
		}
		return true;
	} 
	
	public void register(User user){
		
		if(checkIfUserExists(user) == false)
		{
			
			String sql = "INSERT INTO user ( userName, password, firstName, lastName, phoneNumber, streetName, city, county, postcode, country, email) VALUES "
					+ "(?,?,?,"
					+ "?,?,?,?,?,"
					+ "?,?,?)";
			
			Connection conn = getConnection(); 
			
			System.out.println("Output Form Username Value : "+user.getUserName());
			System.out.println("connection is : "+conn);
			
			try{
				
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, user.getUserName());
				statement.setString(2, user.getPassword());
				statement.setString(3, user.getFirstName());
				statement.setString(4, user.getLastName());
				statement.setString(5, user.getPhoneNumber());
				statement.setString(6, user.getStreetName());
				statement.setString(7, user.getCity());
				statement.setString(8, user.getCounty());
				statement.setString(9, user.getPostcode());
				statement.setString(10, user.getCountry());
				statement.setString(11, user.getEmail());
				
				statement.execute("USE tradesman");
				statement.execute();
				
			}
			catch(Exception e){
				
				System.out.println("Registering user error: "+e.getMessage());
			}
			finally{
				
				closeConnection(conn);
				System.out.println("Connection closed for registering");
			}
		}
		
	}

	
	public void createProfile(Tradesman tradesman){
		
		//if(checkIfUserExists(user) == false)
		//{
			
		
			String sql = "INSERT INTO profile (hourlyRate, tradeId, skillSet, reference, previousJobs, userId) VALUES "
					+ "(?,?,?,?,?,?)";
			
			Connection conn = getConnection(); 
			
			//System.out.println("Output Form Username Value : "+tradesman.getUserName());
			//System.out.println("connection is : "+conn);
			
			try{
				
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setDouble(1, tradesman.getHourlyRate());
				statement.setInt(2, tradesman.getTradeType());
				statement.setString(3, tradesman.getSkillSet());
				statement.setString(4, tradesman.getReference());
				statement.setString(5, tradesman.getPreviousJobs());
				statement.setInt(6, tradesman.getUserId());
				
				statement.execute("USE tradesman");
				statement.execute();
				
			}
			catch(Exception e){
				
				System.out.println("Registering user error: "+e.getMessage());
			}
			finally{
				
				closeConnection(conn);
				System.out.println("Connection closed for registering");
			}
		//}
		
	}

	
	
	public User login(String username,String password){
		
		String sql= "select * from user where userName=? and password=?";
		Connection conn = getConnection(); 
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.execute("USE tradesman");
			ResultSet results = statement.executeQuery();
			if(results.next())
			{
			    username = results.getString("userName");
			    password = results.getString("password");
				 int id = results.getInt("id");
			     String firstName = results.getString("firstName");
			     String lastName = results.getString("lastName");
			     String phoneNumber = results.getString("phoneNumber");
			     String streetName = results.getString("streetName");
			     String city =  results.getString("city");
			     String county =  results.getString("county");
			     String postcode = results.getString("postcode");
			     String country = results.getString("country");
			     String email = results.getString("email");
				
			    User user = new User(id, username,  password,  firstName,  lastName,  phoneNumber,
						 streetName,  city,  county,  postcode,  country, email);
			     System.out.println("User "+username);
			     return user;
				//double price = results.getDouble("price");
				//app = new Application(id, name, price);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeConnection(conn);
		}
		return new User();
	}
	
      public void createTrade(Trade trade){
		
		//if(checkIfUserExists(user) == false)
		//{
			
		
			String sql = "INSERT INTO trade (name,description) VALUES "
					+ "(?,?)";
			
			Connection conn = getConnection(); 
			
			//System.out.println("Output Form Username Value : "+tradesman.getUserName());
			//System.out.println("connection is : "+conn);
			
			try{
				
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, trade.getName());
				statement.setString(2, trade.getDescription());
			
				statement.execute("USE tradesman");
				statement.execute();
				
			}
			catch(Exception e){
				
				System.out.println("Registering user error: "+e.getMessage());
			}
			finally{
				
				closeConnection(conn);
				System.out.println("Connection closed for registering");
			}
		//}
		
	}

	public Vector getTrades()
	{
		String sql= "select * from trade";
		Vector<Trade> trades = new Vector<>();
		Connection conn = getConnection(); 
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.execute("USE tradesman");
			ResultSet results = statement.executeQuery();
			
			while(results.next())
			{
				int id = results.getInt("id");
				String name = results.getString("name");
				
				Trade trade = new Trade(id,name);
				trades.add(trade);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeConnection(conn);
		}
		
		return trades;
	}
	
	
	public Vector getProfile(int uId)
	{
		String sql= "SELECT *, name from profile inner join trade on profile.tradeId = trade.id where profile.userId = ?";
		Vector<Tradesman> profile = new Vector<>();
		Connection conn = getConnection(); 
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, uId);
			statement.execute("USE tradesman");
			ResultSet results = statement.executeQuery();
			
			while(results.next())
			{
					int id = results.getInt("id");
				    double hourlyRate = results.getDouble("hourlyRate");
				    int tradeType= results.getInt("tradeId");
				    String skillSet = results.getString("skillSet");
				    String reference = results.getString("reference");
				    String previousJobs = results.getString("previousJobs");
				    int userId= results.getInt("userId");
					
					Tradesman tradesman = new Tradesman( id,  hourlyRate,  tradeType,  skillSet,  reference,  previousJobs,  userId);
					profile.add(tradesman);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeConnection(conn);
		}
		
		return profile;
	}
	
	public String getTradeName(int tradeId){
		String sql= "SELECT name from trade where id = ?";
		//String profile = new ();
		Connection conn = getConnection(); 
		String name = "";
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, tradeId);
			statement.execute("USE tradesman");
			ResultSet results = statement.executeQuery();
			
			while(results.next())
			{
					
				    name = results.getString("name");
					
					//Tradesman tradesman = new Tradesman( id,  hourlyRate,  tradeType,  skillSet,  reference,  previousJobs,  userId);
					//profile.add(tradesman);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeConnection(conn);
		}
		
		return name;
	}
	
	
	
	public Vector getTradesMen(String searchParameter){
	
		/*SELECT user.* from user,profile,trade where
		trade.id=profile.tradeId and 
		user.id = profile.userId
		and trade.name like '%plum%'*/
		
		String sql= "SELECT user.*,hourlyRate from user,profile,trade "
				+ "where trade.id=profile.tradeId "
				+ "and user.id = profile.userId "
				+ "and trade.name like ?";
		
		Vector<Tradesman> tradesman = new Vector<>();
		Connection conn = getConnection(); 
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "%"+searchParameter+"%");
			statement.execute("USE tradesman");
			ResultSet results = statement.executeQuery();
			
			while(results.next())
			{
					
				int id = results.getInt("id");
			     String firstName = results.getString("firstName");
			     String lastName = results.getString("lastName");
			     String username = results.getString("userName");
			     String password = results.getString("password");

			     Double hourlyRate = results.getDouble("hourlyRate");
			     String phoneNumber = results.getString("phoneNumber");
			     String streetName = results.getString("streetName");
			     String city =  results.getString("city");
			     String county =  results.getString("county");
			     String postcode = results.getString("postcode");
			     String country = results.getString("country");
			     String email = results.getString("email");
				
			     Tradesman u = new Tradesman(id,username,  password,  firstName,  lastName,  phoneNumber,
						 streetName,  city,  county,  postcode,  country, email);
			     u.setHourlyRate(hourlyRate);
			     tradesman.add(u);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeConnection(conn);
		}
		
		return tradesman;
	}
		
	//}
	
	
	
	
}
