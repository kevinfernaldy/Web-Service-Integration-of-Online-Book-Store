package BookService;

import java.net.HttpURLConnection;
import HttpCon.*;
import org.json.JSONObject;

@WebService()
public class DetailBook {
    public DetailBook() {

    }

    @WebMethod
    public BookDetail getDetailBook(String googlebook_id) {
        
        String url = "https://www.googleapis.com/books/v1/volumes/"+googlebook_id;
        RestReqHandler rest = new RestReqHandler();
        JSONObject obj = rest.get(url);


        String BooksResponseStr = HttpCon.HttpRequest.getRespondFrom(url);
//		System.out.println(BooksResponseStr);
		JSONObject jsonObj = new JSONObject(BooksResponseStr);
		BookResponse aBookResponse = BookResponse.toBookService(jsonObj);
		return aBookResponse.getItems();
    }
