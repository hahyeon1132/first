package Dto;

public class Article {

	public Article(int id, String title, String body, String updatedate, String regdate, int memberid,
			int boardid) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.rageDate = regdate;
		this.updateDate = updatedate;
		this.memberid = memberid;
		this.boardid = boardid;
		
	}
	public int id;
	public String title;
	public String body;
	public int memberid;
	public int boardid;
	public String rageDate;
	public String updateDate;

}
