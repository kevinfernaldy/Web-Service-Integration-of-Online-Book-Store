package BookService;

import java.net.HttpURLConnection;
import HttpCon.*;
import org.json.JSONObject;

public class getBooksByTitle {
	public static String getBookByTitle(String book_title) throws Exception {
		String url_book = book_title.replace(" ", "+");
		String url = "https://www.googleapis.com/books/v1/volumes?q=" + url_book;
		
		String Books = HttpCon.HttpRequest.getRespondFrom(url);
		System.out.println(Books);
		
		return Books;
	}
}
