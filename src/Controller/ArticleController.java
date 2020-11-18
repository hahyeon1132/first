package Controller;

import java.util.List;
import java.util.Scanner;
import Container.Container;
import Dto.Article;
import Service.ArticleService;

public class ArticleController {

	private ArticleService articleService;
	private Scanner sc;

	public ArticleController() {
		articleService = new ArticleService();
		sc = Container.scanner;
	}

	public void articleController(String command) {
		if (command.equals("article list")) {
			list();
		} else if (command.startsWith("article detail ")) {
			detail(command);
		}else if(command.startsWith("article delet ")) {
			delet(command);
		}else if(command.equals("article write")) {
			write();
		}

	}

	private void write() {
		System.out.println("== 게시글 작성 ==");
		System.out.println("제목 : ");
		String title = sc.nextLine();
		System.out.println("내용 : ");
		String body = sc.nextLine();
		
		articleService.write(title,body);
		
		
		
	}

	private void delet(String command) {
		int id = Integer.parseInt(command.split(" ")[2]);
		Article article = articleService.detail(id);
		if(article ==null) {
			System.out.println("해당 게시글은 존재하지 않습니다");
			return;
		}
		
		articleService.delet(id);
		System.out.printf("%d번 게시글을 삭제했습니다.\n",id);
		
		
	}

	private void detail(String command) {
		int id = Integer.parseInt(command.split(" ")[2]);
		Article articles = articleService.detail(id);
		if(articles == null) {
			System.out.printf("%d번 게시글은 존재하지 않습니다.\n",id);
			return;
		}
		System.out.printf("번호 : %d\n",articles.id);
		System.out.printf("생성자 : %d\n",articles.memberid);
		System.out.printf("생성날자 : %s\n",articles.rageDate);
		System.out.printf("수정날자 : %s\n",articles.updateDate);
		System.out.printf("제목 : %s\n",articles.title);
		System.out.printf("내용 : %s\n",articles.body);
		
		
		
	}

	private void list() {
		List<Article> articles = articleService.showArticleList();
		System.out.println("== 게시물 리스트 ==");
		System.out.printf("번호 / 작성 / 수정 / 작성자 / 제목 \n");
		for (Article article : articles) {
			System.out.printf("%d / %s / %s / %s / %s\n", article.id, article.rageDate, article.updateDate,
					article.memberid, article.title);

		}

	}
}
