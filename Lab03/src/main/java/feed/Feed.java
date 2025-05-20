package feed;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Arrays;

/*Esta clase modela la lista de articulos de un determinado feed*/
public class Feed {
	String siteName;
	List<Article> articleList;
	
	public Feed(String siteName) {
		super();
		this.siteName = siteName;
		this.articleList = new ArrayList<Article>();
	}

	public String getSiteName(){
		return siteName;
	}
	
	public void setSiteName(String siteName){
		this.siteName = siteName;
	}
	
	public List<Article> getArticleList(){
		return articleList;
	}
	
	public void setArticleList(List<Article> articleList){
		this.articleList = articleList;
	}
	
	public void addArticle(Article a){
		this.getArticleList().add(a);
	}
	
	public Article getArticle(int i){
		return this.getArticleList().get(i);
	}

	public int getNumberOfArticles(){
		return this.getArticleList().size();
	}
	
	public ArrayList<String> getAllTextList(){
		ArrayList<String> textList = new ArrayList<>();
		for (int i = 0; i < this.getArticleList().size(); i++){
			Article tmp = this.getArticle(i);
			String text = tmp.getText() + " " + tmp.getTitle();
			textList.addAll(Arrays.asList(text.split("[:\\.\\,\\s+\\’]")));
		}
		return textList;
	}

	@Override
	public String toString(){
		return "Feed [siteName=" + getSiteName() + ", articleList=" + getArticleList() + "]";
	}
	

	public void prettyPrint(){
		for (Article a: this.getArticleList()){
			a.prettyPrint();
		}
		
	}
	
	public static void main(String[] args) {
		  Article a1 = new Article("This Historically Black University Created Its Own Tech Intern Pipeline",
			  "A new program at Bowie State connects computing students directly with companies, bypassing an often harsh Silicon Valley vetting process",
			  new Date(),
			  "https://www.nytimes.com/2023/04/05/technology/bowie-hbcu-tech-intern-pipeline.html"
			  );
		 
		  Article a2 = new Article("This Historically Black University Created Its Own Tech Intern Pipeline",
				  "A new program at Bowie State connects computing students directly with companies, bypassing an often harsh Silicon Valley vetting process",
				  new Date(),
				  "https://www.nytimes.com/2023/04/05/technology/bowie-hbcu-tech-intern-pipeline.html"
				  );
		  
		  Article a3 = new Article("This Historically Black University Created Its Own Tech Intern Pipeline",
				  "A new program at Bowie State connects computing students directly with companies, bypassing an often harsh Silicon Valley vetting process",
				  new Date(),
				  "https://www.nytimes.com/2023/04/05/technology/bowie-hbcu-tech-intern-pipeline.html"
				  );
		  
		  Feed f = new Feed("nytimes");
		  f.addArticle(a1);
		  f.addArticle(a2);
		  f.addArticle(a3);

		  f.prettyPrint();
		  
	}
	
}
