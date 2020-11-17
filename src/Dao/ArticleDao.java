package Dao;

import java.util.ArrayList;
import java.util.List;

import Dto.Article;

public class ArticleDao {
	List<Article> articles;
	int lastID;
	public ArticleDao() {
		articles = new ArrayList<>();
		lastID = 0;
	
	}
	public List<Article> showArticleList() {
		Article article = new Article();
		
		article.id = lastID + 1;
		article.title = "제목";
		article.body = "내용";
		article.memberid = 1;
		article.rageDate = "2020-11-17";
		article.updateDate= "2020-11-17";
		
		articles.add(article);
		lastID = article.id;
		
		return articles;
	}

}
