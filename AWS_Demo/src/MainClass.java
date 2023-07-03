import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class MainClass {
    public static void main(String[] args) {
                try {
                    // Create a new HTTP server listening on port 8000
                    HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

                    // Define a context for the server
                    server.createContext("/", exchange -> {
                        // Define the response content type and status code
                        exchange.getResponseHeaders().set("Content-Type", "text/html");
                        exchange.sendResponseHeaders(200, 0);

                        // Get the output stream and write the HTML content
                        OutputStream responseBody = exchange.getResponseBody();
                        String htmlContent = "<html><body><h1>Hello World!!</h1></body></html>";
                        responseBody.write(htmlContent.getBytes());
                        responseBody.close();
                    });

                    // Start the server
                    server.start();

                    System.out.println("Server started on port 8000.");
                } catch (IOException e) {
                    e.printStackTrace();
                }

    }
}
