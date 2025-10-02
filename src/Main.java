import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /**Hammaga salom bu 4 ta so'rov Iqtisodiyot universiteti 4-kurs ATT-61/22 va ATT-62/22
        guruhlar uchun MockApi server yaratib shu 4 ta so'rovni ishlatib ko'rish uchun yozildi.
        Agar kimdir sinab kurmoqchi bulsa Api ni urniga uzi Api yaratib ishlatib kursa buladi.
        koddagi kamchilik sifatli kod emas 4 ta so'rovni ishlatgandan keyin kodlarni
        sifatli va soddalashtirish talabalarga vazifa bo'ladi!!!**/
        postSorov();
        getsurovi();
        putSorovi();
        deletSorov();


    }

    private static void deletSorov() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Qaysi id ni o'chirmoqchisiz?: ");
        String id = scanner.nextLine();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://61a076a2a6470200176133a3.mockapi.io/api/data/users/"+id))
                .header("Content-Type","application/json")//shart ham emas uzi
                .DELETE()
                .build();
        //so'rovni junatish
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Server javobi: "+response.body());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void putSorovi() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Qaysi id ni yangilamoqchisiz?: ");
        String id = scanner.nextLine();
        System.out.print("Yangi nomni kiring: ");
        String newName = scanner.nextLine();
        String putjson = "{\"name\":\""+newName+"\"}";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://61a076a2a6470200176133a3.mockapi.io/api/data/users/"+id))
                .header("Content-Type","application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(putjson))
                .build();
        //so'rovni junatish
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Server javobi: "+response.body());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void postSorov() {
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
