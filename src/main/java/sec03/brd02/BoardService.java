package sec03.brd02;

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
	
	public void addArticle(ArticleVO articel) {
		boardDAO.insertNewArticle(articel);
	}

}
