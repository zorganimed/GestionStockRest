package com.sid.ams.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sid.ams.entities.Article;

@RepositoryRestResource
@CrossOrigin("*")
public interface ArticleRepository extends JpaRepository<Article, Long>{

}
