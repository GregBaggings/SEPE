package com.cw.newspublisher;

import java.util.List;

public interface NewsDAO {
	public List<NewsArticle> findByTitle(String title);
	public void createNews(NewsArticle news);
	public void deleteNews(int newsId);
}
