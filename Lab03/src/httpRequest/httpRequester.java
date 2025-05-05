package httpRequest;

import java.net.HttpURLConnection;


/* Esta clase se encarga de realizar efectivamente el pedido de feed al servidor de noticias
 * Leer sobre como hacer una http request en java
 * https://www.baeldung.com/java-http-request
 * */

public class httpRequester {
	
	public String getFeedRss(String urlFeed){

		//Creamos la conexion y realizamos la peticion a traves de ella. 
		String feedRssXml = null;
		URL url = new URL(urlFeed); 
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "application/json");
		int status = con.getResponseCode();
		
		Reader streamReader = null;

		//Chequeamos el estatus de la respuesta
		if(status > 299){
			streamReader = new InputStreamReader(con.getErrorStreamReader());
		}else{
			streamReader = new InputStreamReader(con.getInputStream());
		}

		//Comenzamos leemos la respuesta y la asignamos a content
		BuferedReader in = new BuferedReader(streamReader);
		String inputLine = null;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
    		content.append(inputLine);
		}

		return feedRssXml;
	}

	public String getFeedReedit(String urlFeed) {
		String feedReeditJson = null;
		return feedReeditJson;
	}

}
