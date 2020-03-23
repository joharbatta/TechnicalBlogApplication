package technicalblog.service;

import technicalblog.dao.userDAO;
import technicalblog.model.User;

public class userService {

  private userDAO userDAO=new userDAO();

      public boolean isValidUser(User user)
      {
          return userDAO.isValidUser(user);
      }
}
