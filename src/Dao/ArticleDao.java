package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

		}
		try {

			String sql = "SELECT * FROM Article LIMIT 1";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			Article article = new Article();
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String body = rs.getString("body");
			String updatedate = rs.getString("updatedate");
			String regdate = rs.getString("regdate");
			int memberid = rs.getInt("memberid");
			int boardid = rs.getInt("boardid");
			
			article.id = id;
			article.title = title;
			article.body = body;
			article.updateDate = updatedate;
			article.rageDate = regdate;
			article.memberid = memberid;
			article.boardid = boardid;
			articles.add(article);
			
			

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		finally {
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
