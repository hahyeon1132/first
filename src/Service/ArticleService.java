package Service;

import java.util.List;

import Dao.ArticleDao;
import Dto.Article;

public class ArticleService {

	private ArticleDao articleDao;
	
	public ArticleService() {
		articleDao = new ArticleDao();
	}

	public List<Article> showArticleList() {
		return articleDao.showArticleList();
		
	}

	public Article detail(int id) {
		return articleDao.detail(id);
	}

	public void delet(int id) {
		articleDao.delet(id);
		
	}


	

	

}
