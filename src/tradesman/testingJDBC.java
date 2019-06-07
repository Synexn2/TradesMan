package tradesman;


import java.sql.*;

public class testingJDBC {

	public testingJDBC() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 /**
         * 3306 is the default port for MySQL in XAMPP. Note both the 
         * MySQL server and Apache must be running. 
         */
        String url = "jdbc:mysql://localhost:3306/";
        
        /**
         * The MySQL user.
         */
        String user = "root";
        
        /**
         * Password for the above MySQL user. If no password has been 
         * set (as is the default for the root user in XAMPP's MySQL),
         * an empty string can be used.
         */
        String password = "";
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);
            
            Statement stt = con.createStatement();
            
            /**
             * Create and select a database for use. 
             */
           // stt.execute("CREATE DATABASE IF NOT EXISTS test");
            stt.execute("USE tradesman");
            
            /**
             * Create an example table
             */
            /*stt.execute("DROP TABLE IF EXISTS people");
            stt.execute("CREATE TABLE people (" +
                    "id BIGINT NOT NULL AUTO_INCREMENT,"
                    + "fname VARCHAR(25),"
                    + "lname VARCHAR(25),"
                    + "PRIMARY KEY(id)"
                    + ")");*/
            
            /**
             * Add entries to the example table
             */
            stt.execute("INSERT INTO trade (category, name, description) VALUES" + 
                    "('House Hold / Construction', 'Plumbing', 'House hold plumbing skills')");
            
            /**
             * Query people entries with the lname 'Bloggs'
             */
            //ResultSet res = stt.executeQuery("SELECT * FROM trade WHERE lname = 'Bloggs'");
            ResultSet res = stt.executeQuery("SELECT * FROM trade");
            
            /**
             * Iterate over the result set from the above query
             */
            while (res.next())
            {
                System.out.println(res.getString("category") + " " + res.getString("name") + " " + res.getString("description"));
            }
            System.out.println("");
            
            /**
             * Same as the last query, but using a prepared statement. 
             * Prepared statements should be used when building query strings
             * from user input as they protect against SQL injections
             */
            /*PreparedStatement prep = con.prepareStatement("SELECT * FROM people WHERE lname = ?");
            prep.setString(1, "Bloggs");
            
            res = prep.executeQuery();
            while (res.next())
            {
                System.out.println(res.getString("fname") + " " + res.getString("lname"));
            }*/
            
            /**
             * Free all opened resources
             */
            res.close();
            stt.close();
            //prep.close();
            con.close();
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

	}

}
