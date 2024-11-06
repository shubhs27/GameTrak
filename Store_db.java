import java.sql.*;

public class Store_db {
    public static void main(String[] args) throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver"); //for loading driver
            System.out.println("Drivers loaded successfully!!");
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","shubh");
        System.out.println("Connection established!!");


        // create query
        Statement stmt=con.createStatement();

        String q1="insert into Games values('Elden Ring','G100',2022,'FromSoftware',9.9)";      // insert
        stmt.execute(q1);
        System.out.println("Query Executed (insert)");

        stmt.executeUpdate("insert into Games values('God of War','G101',2018,'Sony',9.5)");
        stmt.executeUpdate("insert into Games values('GTA V','G102',2013,'Rockstar',9.1)");
        stmt.executeUpdate("insert into Games values('Legend of Zelda','G103',2017,'Nintendo',9.8)");
        stmt.executeUpdate("insert into Games values('Ghost of Tsushima','G104',2020,'Sony',9.6)");


        stmt.executeUpdate("delete from Games where Title='Elden Ring'");      // delete
        System.out.println("Query Executed (delete)");


        stmt.executeUpdate("update Games set rating=9.6 where GameID='G101'");      // update
        System.out.println("Query Executed (update)");


        // create result set
        ResultSet rs=stmt.executeQuery("select * from Games");    // read
        while(rs.next()){
            String title= rs.getString("Title");
            String gameid= rs.getString("GameID");
            int year= rs.getInt("ReleaseYear");
            String publisher= rs.getString("Publisher");
            float rating= rs.getFloat("Rating");
            System.out.println("----------------------------------------------------");
            System.out.println(title+" "+gameid+" "+year+" "+publisher+" "+rating);
        }

        rs.close();
        stmt.close();
        con.close();
    }
}
