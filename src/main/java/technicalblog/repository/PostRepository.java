package technicalblog.repository;

import org.springframework.stereotype.Repository;
import technicalblog.model.Post;

import javax.persistence.*;
import java.util.List;

@Repository
public class PostRepository
{
    @PersistenceUnit(unitName="techblog")
    private EntityManagerFactory emf;
    public List<Post> getAllPosts()
    {
        EntityManager em=emf.createEntityManager();
        TypedQuery<Post> query = em.createQuery("SELECT p from Post p", Post.class);
        List<Post> resultList = query.getResultList();
        return resultList;
    }
    public Post getLatestPost()
    {
        EntityManager em=emf.createEntityManager();
        return em.find(Post.class,3);
    }
    //create post
    public Post createPost(Post newPost) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(newPost);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }

        return newPost;
    }
    //get post
    public Post getPost(Integer postId) {
        EntityManager em = emf.createEntityManager();
        return em.find(Post.class, postId);
    }
    //update post
    public void updatePost(Post updatedPost) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(updatedPost);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }
    }
    //delete
    public void deletePost(Integer postId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Post post = em.find(Post.class, postId);
            em.remove(post);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }
    }
}