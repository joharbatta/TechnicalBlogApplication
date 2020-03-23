package technicalblog.dao;
import org.springframework.stereotype.Service;
import technicalblog.model.Post;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
@Service
public class postDAO {

    public ArrayList<Post> getAllPosts() {
        ArrayList<Post> list = new ArrayList<>();

        try{
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://localhost:5432/technicalblog";
            String uname="postgres";
            String pwd="admin";
            Connection con= DriverManager.getConnection(url,uname,pwd);

            Statement stmt=con.createStatement();
            String q="select * from posts";
            ResultSet rs=stmt.executeQuery(q);
            while(rs.next())
            {
//                    System.out.println(rs.getInt(1)+" : "+rs.getString (2)+" : "+rs.getString(3)+" :"+rs.getDate(4));
                Post post = new Post();
                post.setTitle(rs.getString(2));
                post.setBody(rs.getString (3));
                post.setDate(rs.getDate(4));
                list.add(post);
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
        return list;
    }
}
