package technicalblog.service;
import org.springframework.stereotype.Service;
import technicalblog.model.Post;
import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {
    public ArrayList<Post> getAllPosts() {
        ArrayList<Post> list = new ArrayList<>();

        Post post = new Post();
        post.setTitle("Post 1");
        post.setBody("Post Body 1");
        post.setDate(new Date());

        Post post1 = new Post();
        post1.setTitle("Post 2");
        post1.setBody("Post Body 2");
        post1.setDate(new Date());

        Post post2 = new Post();
        post2.setTitle("Post 3");
        post2.setBody("Post Body 3");
        post2.setDate(new Date());

        list.add(post);
        list.add(post1);
        list.add(post2);

        return list;
    }
}
