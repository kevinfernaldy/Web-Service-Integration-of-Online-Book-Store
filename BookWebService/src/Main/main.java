package Main;

//import JsonBook.Book;
import Publisher.Publisher;


public class Main {
	public static void main(String[] args) throws Exception {
//		Book aBook = BookService.GetBookByID.getBookByID("zyTCAlFPjgYC");
		Publisher.getBookByIDPublisher();
		Publisher.getBookByTitlePublisher();
		Publisher.getRecomendedBookPublisher();
		Publisher.buyBookByIDPublisher();

	}
}
