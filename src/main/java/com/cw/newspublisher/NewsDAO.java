package com.cw.newspublisher;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewsDAO {

	@Autowired
	private NewsRepository newsRepo;

	public List<NewsArticle> findByTitle(String title) {
		return newsRepo.findByTitle(title);
	}

	public void createNews(NewsArticle news) {
		newsRepo.save(news);
	}

	public List<NewsArticle> findTop5ByOrderByDateDecs() {
		return newsRepo.findTop5ByOrderByDateDesc();
	}

	public void deleteNews(int newsID) {
		newsRepo.delete(newsID);
	}
}
