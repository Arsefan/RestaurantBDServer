package settings;

import java.io.Serializable;

/**
 * Created by Arsefan on 05.11.2015.
 */
public class Settings implements Serializable{
    public static String LOGIN;
    public static String PASSWORD;
    public static int PORT;
    public static String HOST;

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static void setPASSWORD(String PASSWORD) {
        Settings.PASSWORD = PASSWORD;
    }

    public static int getPORT() {
        return PORT;
    }

    public static void setPORT(int PORT) {
        Settings.PORT = PORT;
    }

    public static String getHOST() {
        return HOST;
    }

    public static void setHOST(String HOST) {
        Settings.HOST = HOST;
    }

    public static String getLOGIN() {
        return LOGIN;
    }

    public static void setLOGIN(String LOGIN) {
        Settings.LOGIN = LOGIN;
    }
}
