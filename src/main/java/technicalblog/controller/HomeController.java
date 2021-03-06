package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technicalblog.dao.postDAO;
import technicalblog.model.Post;
import technicalblog.service.PostService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

//    @Autowired
//    private PostService postService;
//    @Autowired
//    private postDAO postDAO;
//    @RequestMapping("/")
//    public String getAllPosts(Model model)
//    {
//        ArrayList<Post> posts=postDAO.getAllPosts();
//        model.addAttribute("posts",posts);
//        return "index";
//    }

    @Autowired
    private PostService postService;
    @RequestMapping("/")
    public String getAllPosts(Model model) {

        List<Post> posts = postService.getAllPosts();

        model.addAttribute("posts", posts);

        return "index";
    }
}
