package com.cw.newspublisher;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<NewsArticle, Integer>{

	List<NewsArticle> findByTitle(String title);
	List<NewsArticle> findTop5ByOrderByDateDesc();
	
}
