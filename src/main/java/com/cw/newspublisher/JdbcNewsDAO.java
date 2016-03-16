package com.cw.newspublisher;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcNewsDAO implements NewsDAO {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<NewsArticle> findByTitle(String title) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "SELECT * from NEWS WHERE NAME = "+title;
		 
		List<NewsArticle> news = new ArrayList<NewsArticle>();
		
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql, new Object[] { title });
		for (Map<String, Object> row : rows) {
			NewsArticle article = new NewsArticle();
			article.setNewsId((Integer)(row.get("NEWSID")));
			article.setDate((Date)row.get("DATE"));
			article.setTitle((String)row.get("TITLE"));
			article.setContent((String)row.get("CONTENT"));
			news.add(article);
		}
		return news;
	}

	public void createNews(NewsArticle news) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "INSERT INTO NEWS " + "( DATE, TITLE, CONTENT) VALUES ( ?, ?, ?)";
		jdbcTemplate.update(sql, news.getDate(),news.getTitle(),news.getContent());

	}

	public void deleteNews(int newsId) {
JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sql = "DELETE FROM NEWS WHERE NEWSID= ?";
		
		Object[] params = new Object[] { newsId };
		jdbcTemplate.update(sql,params);

	}

}
