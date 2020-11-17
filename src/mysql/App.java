
package mysql;
import java.util.Scanner;

import Container.Container;
import Controller.ArticleController;
import Service.ArticleService;

public class App {
	Scanner sc;
	
	private ArticleController ArticleController;
	
	public App() {
		sc = Container.scanner;
		ArticleController = new ArticleController();
	}
	
	public void run() {
		while(true) {
			System.out.println("명령어 : ");
			String command = sc.nextLine();
			if(command.startsWith("article")) {
				ArticleController.articleController(command);
			}
			
		}
		
		
	}

}
