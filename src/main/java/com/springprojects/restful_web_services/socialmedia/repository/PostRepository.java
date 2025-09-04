
package com.springprojects.restful_web_services.socialmedia.repository;

import com.springprojects.restful_web_services.socialmedia.model.Post;
import com.springprojects.restful_web_services.socialmedia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
