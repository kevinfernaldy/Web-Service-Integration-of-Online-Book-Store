package BookService;

import java.net.HttpURLConnection;
import HttpCon.*;
import org.json.JSONObject;


@WebService()
public class GetBooksByTitle {
	@WebMethod
	public static ListBook getBookByTitle(String book_title) throws Exception {
		String url_book = book_title.replace(" ", "+");
		String url = "https://www.googleapis.com/books/v1/volumes?q=" + url_book;
		
		String BooksResponseStr = HttpCon.HttpRequest.getRespondFrom(url);
//		System.out.println(BooksResponseStr);
		JSONObject jsonObj = new JSONObject(BooksResponseStr);
		BookResponse aBookResponse = BookResponse.toBookService(jsonObj);
		return aBookResponse.getItems();
	}
}
