import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class Program {

    public static void main(String[] args) throws Exception {
        String item = args[0].toLowerCase();
        int quantity = Integer.parseInt(args[1]);
        String url = "http://iitdac.met.edu/shop/" + item;
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(new URI(url))
                        .GET()
                        .header("Accept", "text/plain")
                        .build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() == 200){
            String message = response.body();
            var info = ItemInfo.parse(message);
            if(quantity <= info.stock()){
                System.out.printf("Total Payment: %.2f%n", 1.18 * quantity * info.price());
            }else{
                System.out.println("Item out of stock!");
            }
        }else{
            System.out.println("Item not sold!");
        }

    }
}