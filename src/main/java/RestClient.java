import org.springframework.web.client.RestTemplate;

public class RestClient {
    public static String ApiRequest(){
        final String apiUrl = "https://api.github.com/users/grigoryan-m/events";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(apiUrl, String.class);
    }
}
