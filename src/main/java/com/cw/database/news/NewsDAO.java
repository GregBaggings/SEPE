package com.cw.database.news;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewsDAO {

	
	private NewsRepository newsRepo;
	
	@Autowired
	public NewsDAO(NewsRepository newsRepo) {
		super();
		this.newsRepo = newsRepo;
	}

	public List<News> findByTitle(String title) {
		return newsRepo.findByTitle(title);
	}

	public void createNews(News news) {
		newsRepo.save(news);
	}

	public List<News> findTop5ByOrderByDateDecs() {
		return newsRepo.findTop5ByOrderByDateDesc();
	}

	public void deleteNews(int newsID) {
		newsRepo.delete(newsID);
	}

	public List<News> findAll() {
		return newsRepo.findAll();
	}
}
