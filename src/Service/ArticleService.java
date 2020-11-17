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

	

}
