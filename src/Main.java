import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //teskarisni_top();
        Scanner scanner = new Scanner(System.in);
         String url = "https://61a076a2a6470200176133a3.mockapi.io/api/data/users";
        System.out.print("Isminggizni kiriting: ");
        String name = scanner.nextLine();
         String requestBody = "{\"name\":\""+name+"\"}";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type","application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            System.out.println("Status Code"+response.statusCode());
            System.out.println("Response body");
            System.out.println(response.body());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //getsurovi();


    }

    private static void getsurovi() {
        String url = "https://61a076a2a6470200176133a3.mockapi.io/api/data/users";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            System.out.println("Status Code"+response.statusCode());
            System.out.println("Response body");
            System.out.println(response.body());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void teskarisni_top() {
        long katta = 45689;
        long teskari=0;
        while (katta!=0){
            teskari=teskari*10+(katta%10);
            katta=katta/10;
        }
        System.out.println(teskari);
    }
}
