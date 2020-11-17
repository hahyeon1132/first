package Controller;

import java.util.List;

import Dto.Article;
import Service.ArticleService;

public class ArticleController {

	private ArticleService articleService;
	
	public ArticleController() {
		articleService = new ArticleService();
	}

	public void articleController(String command) {
		List<Article> article = articleService.showArticleList();
		System.out.println(article);
		
	}

}
