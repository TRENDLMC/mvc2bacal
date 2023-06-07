package sec03.brd05;

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
	
	public ArticleVO viewArticle(int articleNO) {
		ArticleVO article=null;
		article=boardDAO.selectArticles(articleNO);
		return article;
		
	}
	public void modArticle(ArticleVO article) {
		boardDAO.updateArticle(article);
	}

}
