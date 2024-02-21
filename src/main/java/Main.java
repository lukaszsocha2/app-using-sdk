import com.box.sdk.BoxConfig;
import com.box.sdk.BoxDeveloperEditionAPIConnection;
import com.box.sdk.BoxFolder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {

    public static final String JWT_CONFIG_PATH = "config.json";

    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader(JWT_CONFIG_PATH);
        BoxConfig boxConfig = BoxConfig.readFrom(reader);
        BoxDeveloperEditionAPIConnection api = BoxDeveloperEditionAPIConnection.getAppEnterpriseConnection(boxConfig);

        BoxFolder.Info folderInfo = new BoxFolder(api, "0").getInfo();
        System.out.println(folderInfo.getName());
    }
}
