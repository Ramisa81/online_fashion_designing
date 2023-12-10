// OtpGenerator.java
package Online_Fashion;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class OtpGenerator {

    private static final String OTP_FILE_PATH = "otp.txt";

    public static String generateOtp() {
        Random random = new Random();
        int otpValue = 100000 + random.nextInt(900000);
        return String.valueOf(otpValue);
    }

    public static void saveOtp(String otp) {
        try (FileWriter writer = new FileWriter(OTP_FILE_PATH)) {
            writer.write(otp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readOtp() {
        try {
            return new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(OTP_FILE_PATH))).trim();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}


