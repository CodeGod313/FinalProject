import java.util.ResourceBundle;

public class Testik {
    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        String url = resourceBundle.getString("db.url");
        System.out.println(url);
    }
}