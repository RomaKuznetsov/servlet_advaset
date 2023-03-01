package connection;

import java.util.Properties;

class PropertyMySQL {
    private static final String password = "DaemonTools";
    private static final String user = "root";

    private static String URL = "jdbc:mysql://localhost/world?useUnicode=true&serverTimezone=UTC";
    //      jdbc:mysql://localhost/db?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false
    private static String URL_ITSGOOD_RU = "jdbc:mysql://localhost/itsgood_ru?useUnicode=true&serverTimezone=UTC";
   private static Properties property;

    public static Properties createProperty() {
        property = new Properties();
        property.put("user", user);
        property.put("password", password);
        property.put("autoReconnect", "true");
        property.put("characterEncoding", "UTF-8");
        property.put("useUnicode", "true");
        property.put("useSSL", "true");
        return property;

    }
public static String setMyURL() {
   return URL_ITSGOOD_RU;
}
}
