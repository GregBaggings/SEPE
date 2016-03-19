package com.cw.newspublisher;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<News, Integer>{

	List<News> findByTitle(String title);
	List<News> findTop5ByOrderByDateDesc();
}
