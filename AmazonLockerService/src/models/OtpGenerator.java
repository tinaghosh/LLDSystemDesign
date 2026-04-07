package models;

import java.security.SecureRandom;

public class OtpGenerator {

    private static final SecureRandom randomNumberGenerator = new SecureRandom();
    private static final int OTP_LENGTH = 6;


    public static String generateOTP(){
       int otp =  randomNumberGenerator.nextInt((int) Math.pow(10, OTP_LENGTH));
       return String.format("%0" + OTP_LENGTH + "d", otp);
    }
}
