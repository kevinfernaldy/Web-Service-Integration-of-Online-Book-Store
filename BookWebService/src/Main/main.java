package Main;
import org.json.JSONObject;

import BookService.getBooksByTitle;

public class main {
	public static void main(String[] args) throws Exception {
		String book_title = "Web";
		String ret = BookService.getBooksByTitle.getBookByTitle(book_title);
		JSONObject jsonObj = new JSONObject(ret);
	}
}
