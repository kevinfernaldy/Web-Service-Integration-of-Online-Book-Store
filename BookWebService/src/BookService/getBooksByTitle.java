package BookService;

import JsonBook.BookResponse;
import JsonBook.ListBook;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.JSONObject;

@WebService
public class GetBooksByTitle {
	@WebMethod
	public ListBook getBookByTitle(String book_title) throws Exception {
		String url_book = book_title.replace(" ", "+");
		String url = "https://www.googleapis.com/books/v1/volumes?q=" + url_book;
		
		String BooksResponseStr = HttpCon.HttpRequest.getRespondFrom(url);
//		System.out.println(BooksResponseStr);
		JSONObject jsonObj = new JSONObject(BooksResponseStr);
		BookResponse aBookResponse = BookResponse.toBookService(jsonObj);
		return aBookResponse.getItems();
	}
}
