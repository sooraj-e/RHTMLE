package controllers;

import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.jackson.JsonNode;

import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.extractors.ArticleExtractor;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
  public static Result index(String extractUrl) throws BoilerpipeProcessingException, MalformedURLException {
	  URL url = new URL(extractUrl);
	   JsonNode text = Json.toJson(ArticleExtractor.INSTANCE.getText(url));
    return ok(index.render(text.asText()));
  }
  
}