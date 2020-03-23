package technicalblog.dao;

import technicalblog.model.Post;
import technicalblog.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class userDAO {

    public boolean isValidUser(User user)
    {
        String name=user.getUsername();
        String pass=user.getPassword();
        boolean flag=false;
        try{
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://localhost:5432/technicalblog";
            String uname="postgres";
            String pwd="admin";
            Connection con= DriverManager.getConnection(url,uname,pwd);

            Statement stmt=con.createStatement();
            String q="select * from users";
            ResultSet rs=stmt.executeQuery(q);

            while(rs.next())
            {
               if(rs.getString(1).equals(name) && rs.getString(2).equals(pass))
               {
                   flag=true;
                   System.out.println("ar");
               }
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }

        return flag;

    }

}
