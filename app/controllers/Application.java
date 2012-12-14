package controllers;

import java.net.MalformedURLException;
import java.net.URL;

import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.extractors.ArticleExtractor;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
  public static Result index() throws BoilerpipeProcessingException, MalformedURLException {
	  URL url = new URL("http://www.playframework.org/documentation/2.0.4/Anatomy");
	   // NOTE: Use ArticleExtractor unless DefaultExtractor gives better results for you
	   String text = ArticleExtractor.INSTANCE.getText(url);
    return ok(index.render(text));
  }
  
}