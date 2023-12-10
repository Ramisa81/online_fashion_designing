package Online_Fashion;

import java.util.prefs.Preferences;

public class UserData {
    private static Preferences preferences = Preferences.userNodeForPackage(UserData.class);

    public static String getName() {
        return preferences.get("name", "");
    }

    public static void setName(String name) {
        preferences.put("name", name);
    }

    public static String getPhone() {
        return preferences.get("phone", "");
    }

    public static void setPhone(String phone) {
        preferences.put("phone", phone);
    }

    public static String getDob() {
        return preferences.get("dob", "");
    }

    public static void setDob(String dob) {
        preferences.put("dob", dob);
    }

    public static String getId() {
        return preferences.get("id", "");
    }

    public static void setId(String id) {
        preferences.put("id", id);
    }

    public static String getAddress() {
        return preferences.get("address", "");
    }

    public static void setAddress(String address) {
        preferences.put("address", address);
    }
}
