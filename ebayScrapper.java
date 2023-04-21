import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class EbayScraper {
    public static void main(String[] args) throws IOException {
        String[] searchTerms = {"item1", "item2", "item3"}; 
        int maxPrice = 50;

        // Scrape the search results
        String url = "https://www.ebay.com/sch/i.html?_nkw=" + String.join("+", searchTerms) 
                + "&_sop=12&_udhi=" + maxPrice;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        Scanner scanner = new Scanner(con.getInputStream());
        StringBuffer response = new StringBuffer();
        while (scanner.hasNext()) {
            response.append(scanner.nextLine());
        }
        scanner.close();
        Document doc = Jsoup.parse(response.toString());
        Elements items = doc.select("div.s-item__wrapper");
        for (Element item : items) {
            String name = item.select("h3.s-item__title").text();
            String listingType = item.select("span.s-item__purchase-options-with-icon").text();
            String price = item.select("span.s-item__price").text();
           
        }
    }
}
