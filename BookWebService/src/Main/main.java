package Main;

import BookService.BuyBookByID;
import BookService.GetBookByID;
import BookService.GetBooksByTitle;
import BookService.GetRecomendedBook;
import JsonBook.ListBook;
import Publisher.Publisher;


public class Main {
	public static void main(String[] args) throws Exception {
//		Book aBook = BookService.GetBookByID.getBookByID("zyTCAlFPjgYC");
		Publisher.getBookByIDPublisher();
		Publisher.getBookByTitlePublisher();
		Publisher.getRecomendedBookPublisher();
		Publisher.buyBookByIDPublisher();
		
		GetBooksByTitle service1 = new GetBooksByTitle();
		GetBookByID service2 = new GetBookByID();
		GetRecomendedBook s3 = new GetRecomendedBook();
		BuyBookByID s4 = new BuyBookByID();
		
//		ListBook aListBook= service1.getBookByTitle("asd");
//		Book aBook = service2.getBookByID("qGCWDgAAQBAJ");
//		ListBook bListBook = s3.getRecomendedBook("fiction");
//		System.out.println(bListBook.getListBook().size());
		
		String resp = s4.buyBookByID("id",1 , 1, "rek", "category", 30000.00);
		
		
	}
}
