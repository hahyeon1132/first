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
		System.out.println("== 게시물 리스트 ==");
		System.out.printf("번호 / 작성 / 수정 / 작성자 / 제목 \n");
		for(Article articles : article) {
		System.out.printf("%d / %s / %s / %s / %s\n",articles.id,articles.rageDate,articles.updateDate,articles.memberid,articles.title);
		}
	}

}
