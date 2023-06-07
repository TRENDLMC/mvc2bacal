package sec03.brd03;

import java.util.List;

public class BoardService {
	
	BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO=new BoardDAO();
	}
	
	public List<ArticleVO> listArticles(){
		List<ArticleVO> articleList=boardDAO.selectAllArticles();
		return articleList;
	}
	
	public int addArticle(ArticleVO articel) {
		return boardDAO.insertNewArticle(articel);
	}

}
