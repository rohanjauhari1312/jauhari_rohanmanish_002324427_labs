/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analytics;

/**
 *
 * @author harshalneelkamal
 */

import java.util.Map;
import model.Comment;
import model.Post;
import model.User;
import data.DataStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;



public class AnalysisHelper {
    //Find Average number of likes per comment.
    //TODO
    public void getAverageLikesPerComments() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        int likeNo = 0;
        int commentNo = comments.size();
        for (Comment c : comments.values()) {
            likeNo += c.getLikes();
        }
        
        System.out.println("Q1 - Average likes per comments: " + likeNo / commentNo);
            
    }
    public void getMaxLikeCommentPost () {
                DataStore data = DataStore.getInstance () ;

                Comment cmtMaxLikes = null;
        for (Comment c : data.getComments () .values ()) {
            if (cmtMaxLikes == null) {
                cmtMaxLikes = c;
            }
            if (c. getLikes () > cmtMaxLikes.getLikes ()) {
                cmtMaxLikes = c;
            }
        }
        int postid = cmtMaxLikes.getPostId () ;
        System.out.println("Q2 - post with max likes per comment " + data.getPosts ().get (postid).toString ());
        }
    
    public void getmaxCmtPosts () {
        DataStore data = DataStore.getInstance () ;
        Post maxCmtPosts = null;
        for (Post p:data.getPosts().values()){
            if (maxCmtPosts == null) {
                maxCmtPosts = p;
            }
        if (p.getComments ().size () > maxCmtPosts.getComments ().size ()) {
        maxCmtPosts = p;
        }
        }
        System.out.println("Q3 - post with max comments " + maxCmtPosts.getPostId () ) ;
}

    public void getPassiveUsers () {
                HashMap<Integer, Integer> postNos = new HashMap<Integer, Integer> () ;

        DataStore data = DataStore. getInstance () ;
        for (Post p: data.getPosts () . values ()) {
            int userId = p.getUserId () ;
            if (postNos. containsKey (userId) ) {
                postNos.put (userId, postNos.get (userId) + 1);
            } else {
                postNos.put(userId, 1) ;
            }
        }
        ArrayList<User> users = new ArrayList (data.getUsers ().values () ) ;
        Collections.sort (users, new UserMapComparator (postNos)) ;
        System.out.println("Q4 - Users with least posts are: ");
        
        for (int i = 0; i < 5; i++) {
            System.out.println(users.get (i) +", - Post count: " + postNos.get (users.get (i) .getId() )) ;
        
        }
        
    }
    
    public void getPassiveCommentUsers () {
                HashMap<Integer, Integer> commentNos = new HashMap<Integer, Integer> () ;

        DataStore data = DataStore. getInstance () ;
        for (Comment c : data.getComments () . values ()) {
            int userId = c.getUserId () ;
            if (commentNos.containsKey (userId)) {
                commentNos. put (userId, commentNos. get (userId) + 1);
            } else {
                commentNos. put (userId, 1) ;
            }
        }
        ArrayList<User> users = new ArrayList (data. getUsers () .values ()) ;
        Collections.sort(users, new UserMapComparator (commentNos) ) ;
        System.out.println("Q5 - Users with least comments are: ");
        for (int i = 0; i < 5; i++) {
            System.out.println (users.get (i) + " ,- Comment count: " + commentNos.get (users.get (i) .getId()) );
        }
        
        
    }
    
    public void getPassiveAndActiveOverallUsers () {
            HashMap<Integer, Integer> totalNos = new HashMap<Integer, Integer>();

    DataStore data = DataStore. getInstance () ;
    for (Comment c: data.getComments () . values ()) {
        int userId = c.getUserId () ;
        if (totalNos .containsKey (userId)) {
            totalNos. put (userId, totalNos.get (userId) + 1 + c. getLikes ()) ;
        } else {
            totalNos. put (userId, 1 + c. getLikes ()) ;
        }
    }
    for (Post p : data. getPosts () . values ()) {
        int userId = p.getUserId () ;
        if (totalNos. containsKey (userId)) {
            totalNos. put (userId, totalNos. get (userId) + 1);
        } else {
            totalNos .put (userId, 1);
        } 
    }
    ArrayList<User> users = new ArrayList (data.getUsers () .values ()) ;
    Collections.sort (users, new UserMapComparator (totalNos) ) ;

    System.out.println("Q6 - Passive users are:" ) ;
    for (int i = 0; i < 5; i++) {
        System.out.println (users.get (i) + ", - Overall count: " + totalNos. get (users.get (i) .getId()) );
    }

    System.out.println("Q7 - Active users are: ");
    for (int i = 0; i < users.size()-6; i++) {
        System.out.println(users.get (i) + ", - Overall count: " + totalNos.get (users.get (i).getId ()));
    }

    }
}
