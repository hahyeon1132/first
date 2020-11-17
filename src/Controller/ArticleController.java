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
		if (command.equals("article list")) {
			List<Article> articles = articleService.showArticleList();
			System.out.println("== 게시물 리스트 ==");
			System.out.printf("번호 / 작성 / 수정 / 작성자 / 제목 \n");
			for (Article article : articles) {
				System.out.printf("%d / %s / %s / %s / %s\n", article.id, article.rageDate, article.updateDate,
						article.memberid, article.title);
			}

		}else if(command.startsWith("article detail")) {
			int id = Integer.parseInt(command.split(" ")[2]);
			List<Article> articles = articleService.showArticleList();
			for(Article article : articles) {
				if(article.id == id) {
					System.out.printf("번호 : %d\n",article.id);
					System.out.printf("작성자 : %s\n",article.memberid);
					System.out.printf("제목 : %s\n",article.title);
					System.out.printf("내용 : %s\n",article.body);
					System.out.printf("최초작성일 : %s\n",article.rageDate);
					System.out.printf("최근변경일 : %s\n",article.updateDate);
				}
			}
		}
	}

}
