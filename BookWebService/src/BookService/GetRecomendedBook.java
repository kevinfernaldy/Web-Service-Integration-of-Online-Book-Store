package BookService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.json.JSONObject;
import JsonBook.BookResponse;
import JsonBook.ListBook;

@WebService
public class GetRecomendedBook {
	@WebMethod
	public ListBook getRecomendedBook(@WebParam(name="category") String category) throws Exception {
		String url = "https://www.googleapis.com/books/v1/volumes?q=subject:" + category;
		
		String BooksResponseStr = HttpCon.HttpRequest.getRespondFrom(url);
		System.out.println(BooksResponseStr);
		JSONObject jsonObj = new JSONObject(BooksResponseStr);
		BookResponse aBookResponse = BookResponse.toBookService(jsonObj);
		return aBookResponse.getItems();
		
	}
}
