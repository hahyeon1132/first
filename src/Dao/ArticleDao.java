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

			String sql = "SELECT * FROM Article ORDER BY id DESC";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String body = rs.getString("body");
				String updatedate = rs.getString("updatedate");
				String regdate = rs.getString("regdate");
				int memberid = rs.getInt("memberid");
				int boardid = rs.getInt("boardid");
				Article article = new Article(id, title, body, updatedate, regdate, memberid, boardid);

				articles.add(article);
			}

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

}
