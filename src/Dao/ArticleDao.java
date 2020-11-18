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
	String mysqlserver = "jdbc:mysql://127.0.0.1/Java?serverTimezone=Asia/Seoul";
	String serverId = "sbsst";
	String serverPw = "sbs123414";

	public List<Article> showArticleList() {
		List<Article> articles = new ArrayList<>();
		Connection con = null;
		try {
			con = DriverManager.getConnection(mysqlserver, serverId, serverPw);
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

	public Article detail(int id) {
		Article article = null;
		Connection con = null;

		try {
			con = DriverManager.getConnection(mysqlserver, serverId, serverPw);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = "SELECT * FROM Article WHERE id=?";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				int Id = rs.getInt("id");
				String redDate = rs.getString("regDate");
				String updateDate = rs.getString("updateDate");
				String title = rs.getString("title");
				String body = rs.getString("body");
				int memberId = rs.getInt("memberId");
				int boardId = rs.getInt("boardId");
				article = new Article(Id, title, body, updateDate, redDate, memberId, boardId);

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return article;
	}

	public void delet(int id) {
		Connection con = null;
		int garvige=0;

		try {
			con = DriverManager.getConnection(mysqlserver, serverId, serverPw);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		String sql = "DELETE FROM Article WHERE id=?";

		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			garvige = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
