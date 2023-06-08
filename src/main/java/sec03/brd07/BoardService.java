package sec03.brd07;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardService {
	
	BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO=new BoardDAO();
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
	public List<Integer> removeArticle(int articleNO) {
		List<Integer> articleNOList=boardDAO.selectRemovedArticles(articleNO);
		boardDAO.deleteArticle(articleNO);
		return articleNOList;
		
	}
	public int addReply(ArticleVO article) {
		return boardDAO.insertNewArticle(article);
	}
	
	public Map listArticles(Map<String,Integer> pagingMap) {
		
		Map articleMap=new HashMap();
		List<ArticleVO> articlesList=boardDAO.selectAllArticles(pagingMap);
		int totArticles=boardDAO.selectTotArticles();
		articleMap.put("articlesList", articlesList);
		articleMap.put("totArticles", totArticles);
		
		return articleMap;
	}
	
	public List<ArticleVO> listArticles(){
		List<ArticleVO> articleList=boardDAO.selectAllArticles();
		return articleList;
	}

}
