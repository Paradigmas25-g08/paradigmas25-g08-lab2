import parser.*;
import subscription.*;
import httprequest.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class FeedReaderMain {

    private static void printHelp(){
        System.out.println("Please, call this program in correct way: FeedReader [-ne]");
    }

    public static void main(String[] args) throws IOException, URISyntaxException{
        System.out.println("** FeedReader version 1.0 **");
        if (args.length == 0) {

            /* 
            Leer el archivo de suscription por defecto;
            Llamar al httpRequester para obtenr el feed del servidor
            Llamar al Parser especifico para extrar los datos necesarios por la aplicacion 
            Llamar al constructor de Feed
            LLamar al prettyPrint del Feed para ver los articulos del feed en forma legible y amigable para el usuario
            */

            SubscriptionParser parser = new SubscriptionParser();
            Subscription subs = parser.FileParser("./src/main/config/subscriptions.json");

            String Url = subs.getSingleSubscription(0).getUrl();
            String Param = subs.getSingleSubscription(0).getUrlParams(0);

            httpRequester requester = new httpRequester();
            String feedRss = requester.getFeedRss(Url, Param);




        } else if (args.length == 1){

            /* 
            Leer el archivo de suscription por defecto;
            Llamar al httpRequester para obtenr el feed del servidor
            Llamar al Parser especifico para extrar los datos necesarios por la aplicacion 
            Llamar al constructor de Feed
            Llamar a la heuristica para que compute las entidades nombradas de cada articulos del feed
            LLamar al prettyPrint de la tabla de entidades nombradas del feed.
             */

        }else {
            printHelp();
        }
    }

}
