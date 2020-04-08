package technicalblog.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.model.Post;
import technicalblog.repository.PostRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> getAllPosts() {
        return repository.getAllPosts();
    }
    public Post getOnePost() {
        return repository.getLatestPost();

    }
    public void createPost(Post newPost) {
        newPost.setDate(new Date());
        repository.createPost(newPost);
        System.out.println("New Post: "+newPost);
    }
    public Post getPost(Integer postId) {
        return repository.getPost(postId);
    }
    public void updatePost(Post updatedPost) {
        updatedPost.setDate(new Date());
        repository.updatePost(updatedPost);
    }

//    public ArrayList<Post> getAllPosts() {
//        ArrayList<Post> list = new ArrayList<>();
//
//        Post post = new Post();
//        post.setTitle("Post 1");
//        post.setBody("Post Body 1");
//        post.setDate(new Date());
//
//        Post post1 = new Post();
//        post1.setTitle("Post 2");
//        post1.setBody("Post Body 2");
//        post1.setDate(new Date());
//
//        Post post2 = new Post();
//        post2.setTitle("Post 3");
//        post2.setBody("Post Body 3");
//        post2.setDate(new Date());
//
//        list.add(post);
//        list.add(post1);
//        list.add(post2);
//
//        return list;
   // }
}
