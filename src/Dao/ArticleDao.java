package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Dto.Article;

public class ArticleDao {

	public List<Article> showArticleList() {
		List<Article> articles = new ArrayList<>();
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/Java?serverTimezone=Asia/Seoul", "sbsst",
					"sbs123414");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return articles;
	}

	private List<Article> getAritlces() {
		List<Article> articles = new ArrayList<>();
		Article article = new Article();

		article.id = 1;
		article.title = "제목";
		article.body = "내용";
		article.memberid = 1;
		article.rageDate = "2020-11-17";
		article.updateDate = "2020-11-17";

		articles.add(article);

		return articles;
	}

}
