import parser.*;
import subscription.*;
import httpRequest.*;
import feed.*;
import namedEntity.heuristic.*;
import namedEntity.*;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.util.ArrayList;
import java.util.Map;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

public class FeedReaderMain {

    private static void printHelp(){
        System.out.println("Please, call this program in correct way: FeedReader [-ne]");
    }

    public static void main(String[] args) throws IOException, URISyntaxException, ParserConfigurationException, SAXException, ParseException{
        System.out.println("** FeedReader version 1.0 **");
        if (args.length == 0) {

            /* 
            Leer el archivo de suscription por defecto;
            Llamar al httpRequester para obtenr el feed del servidor
            Llamar al Parser especifico para extrar los datos necesarios por la aplicacion 
            Llamar al constructor de Feed
            LLamar al prettyPrint del Feed para ver los articulos del feed en forma legible y amigable para el usuario
            */

            SubscriptionParser subParser = new SubscriptionParser();
            Subscription subs = subParser.FileParser("./src/main/config/subscriptions.json");
            
            for (int i = 0; i < subs.getSubscriptionsList().size(); i++) {
                if(subs.getSingleSubscription(i).getUrlType().equals("rss")){
                    String Url = subs.getSingleSubscription(i).getUrl();
                    for (int j=0 ; j<subs.getSingleSubscription(i).getUrlParams().size(); j++){
                        String Param = subs.getSingleSubscription(i).getUrlParams(j);
                    
                        httpRequester requester = new httpRequester();
                        String feedRssString = requester.getFeedRss(Url, Param);
                
                        RssParser rssParser = new RssParser();
                        Feed rssFeed = rssParser.getFeed(feedRssString);
                        
                        rssFeed.prettyPrint();
                    }
                } else {
                    System.out.println("Caso reddit");
                }
            
            }






        } else if (args.length == 1){

            /* 
            Leer el archivo de suscription por defecto;
            Llamar al httpRequester para obtenr el feed del servidor
            Llamar al Parser especifico para extrar los datos necesarios por la aplicacion 
            Llamar al constructor de Feed
            Llamar a la heuristica para que compute las entidades nombradas de cada articulos del feed
            LLamar al prettyPrint de la tabla de entidades nombradas del feed.
             */

            SubscriptionParser subParser = new SubscriptionParser();
            Subscription subs = subParser.FileParser("./src/main/config/subscriptions.json");

            ArrayList<String> feedText = new ArrayList<>();
            QuickHeuristic heuristica = new QuickHeuristic();

            for (int i = 0; i < subs.getSubscriptionsList().size(); i++) {
                if(subs.getSingleSubscription(i).getUrlType().equals("rss")){
                    String Url = subs.getSingleSubscription(i).getUrl();
                    for (int j=0 ; j<subs.getSingleSubscription(i).getUrlParams().size(); j++){
                        String Param = subs.getSingleSubscription(i).getUrlParams(j);
                    
                        httpRequester requester = new httpRequester();
                        String feedRssString = requester.getFeedRss(Url, Param);
                
                        RssParser rssParser = new RssParser();
                        Feed rssFeed = rssParser.getFeed(feedRssString);
                        
                        feedText = rssFeed.getAllTextList();
                    }
                } else {
                    System.out.println("Caso reddit");
                }
            }

            List<String> entities = feedText.stream().filter(s -> heuristica.isEntity(s)).collect(Collectors.toList());

            System.out.println(entities);

        }else {
            printHelp();
        }
    }

}

