import java.util.Map;
import java.util.TreeMap;

public class Config {
    private static Map<String, String> makeUser(String user) {
        Map<String, String> map = new TreeMap<>();
        String home = String.format("/home/%s", user);
        String privateKey = String.format("%s/.ssh/id_ed25519", home);
        String publicKey = String.format("%s.pub", privateKey);
        map.put("home", home);
        map.put("privateKey", privateKey);
        map.put("publicKey", publicKey);
        return map;
    }

    public static String work() {
        StringBuilder result = new StringBuilder();
        result.append("[\n {\n");
        for (Map.Entry<String, String> entry : makeUser("ivan").entrySet())
            result.append("  ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        result.append(" },\n {\n");
        for (Map.Entry<String, String> entry : makeUser("maxim").entrySet())
            result.append("  ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        result.append(" }\n");
        result.append("]");
        return result.toString();
    }
}
