package feed;

import namedEntity.*;
import subscription.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

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


@Override
public String toString(){
return "Feed [siteName=" + getSiteName() + ", articleList=" + getArticleList() + "]";
}


public void heuristicPrint() {
  List<NamedEntity> allEntities = new ArrayList<NamedEntity>();
  for (Article a: this.getArticleList()){
    for (NamedEntity n: a.getNamedEntityList()){
      int index = IntStream.range(0, allEntities.size()).filter(j -> allEntities.get(j).getName().equals(n.getName())).findFirst().orElse(-1);

      if(index != -1){
        allEntities.get(index).incFrequency();
      } else {
        allEntities.add(n);
      }
    }
  }
  System.out.printf(
    "%-30s | %10s | %-20s%n", 
    "Name", "Frequency", "Category"
  );
  System.out.printf(
    "%-30s-+-%10s-+-%-20s%n", 
    "-".repeat(30), "-".repeat(10), "-".repeat(20)
  );
  
  for (NamedEntity e : allEntities) {
    System.out.printf(
        "%-30s | %10d | %-20s%n",
        e.getName(),
        e.getFrequency(),
        e.getCategory()
    );
    Counter person = new Counter("person");
    Counter country = new Counter("country");
    Counter city = new Counter("city");
    Counter address = new Counter("address");
    Counter organization = new Counter("organization");
    Counter product = new Counter("product");
    Counter event = new Counter("event");
    Counter date = new Counter("date");
    Counter other = new Counter("other");

    
  }
  System.out.println("Cantidad de entidades:" + allEntities.size());

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