package BookService;

import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import HttpCon.HttpRequest;

@WebService
public class BuyBookByID {
	@WebMethod
	public String buyBookByID(@WebParam(name = "id") String id, @WebParam(name = "user") int user_id, @WebParam(name="amount")int amount, @WebParam(name="Rekening") String rek, @WebParam(name="category") String category, @WebParam(name="price") double price) throws IOException {
		String url = "http://localhost:8081/Transfer"; 
		Double totalPrice = amount*price;
		String param = rek + "_" + totalPrice.toString();
		
		String Response = "";
		try {
			Response = HttpRequest.sendPostTo(url, param);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			System.out.print(e.getStackTrace());
		}
		
		if (Response.equals("SUCCESS")) {
			try {
				// DB here
				return "SUCCESS";
			}catch (Exception e) {
				return ("DBFAIL" + e.getMessage());
			}
			
		} else {
			return "FAILED";
		}
//		Call transfer
		
	}
}
