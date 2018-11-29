package book;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Book {
    public String id;
    public String title;
    public String imageUrl;
    public String description;
    public String price;
    public List<String> author;

    public Book(String id, List<String> author,String title, String imageUrl, String description, String price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.imageUrl = imageUrl;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public List<String> getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public static Book convertFromJson(JSONObject json) {
        String id = json.getString("id");
        String title = json.getJSONObject("volumeInfo")
                .getString("title");
        JSONArray authorsJson = json.getJSONObject("volumeInfo")
                .getJSONArray("authors");

        ArrayList<String> authors = new ArrayList<>();

        for (int i = 0; i < authorsJson.length(); i++) {
            authors.add((String) authorsJson.get(i));
        }

        String description = json.getString("description");
        String price = json.getJSONObject("retailPrice")
                .getString("amount");

        return new Book(id, authors, title, "", description, price);
    }


}
