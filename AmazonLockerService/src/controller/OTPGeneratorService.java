package controller;

import models.OtpEntity;
import models.OtpGenerator;
import java.security.MessageDigest;
import java.time.Instant;
import java.util.Base64;
import java.util.concurrent.ConcurrentHashMap;

public class OTPGeneratorService{

    public static final int MAX_ATTEMPTS = 3;
    public static final int EXPIRY_SECONDS = 60*60*24*3;

    ConcurrentHashMap<String, OtpEntity> OtpStore = new ConcurrentHashMap<>();

    public static String hashOtp(String otp){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte hash[] = messageDigest.digest(otp.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException("Error Hashing OTP");
        }
    }

    public String generateOtp(String userId){
        String otp = OtpGenerator.generateOTP();
        String hashOtp = hashOtp(otp);
        OtpEntity otpEntity = new OtpEntity(hashOtp, Instant.now().plusSeconds(EXPIRY_SECONDS));
        OtpStore.put(userId,otpEntity);
        return otp;
    }

   public boolean verifyOtp(String userId, String inputOtp){
        OtpEntity otpEntity = OtpStore.get(userId);

        if(otpEntity == null)
            return false;

        //Time is after Expiry
        if(Instant.now().isAfter(otpEntity.getExpiryTime())){
            OtpStore.remove(userId);
            System.out.println("Time is after Expiry");
            return false;
        }

        //Maximum trial reached
        if(otpEntity.getAttempts()>=MAX_ATTEMPTS){
            OtpStore.remove(userId);
            System.out.println("Maximum trial reached");
            return false;
        }
        otpEntity.setAttempts(otpEntity.getAttempts()+1);
        String inputHash = hashOtp(inputOtp);
        if(inputHash.equals(otpEntity.getOtpHash())){
            otpEntity.setVerified(true);
            OtpStore.remove(userId);
            System.out.println("OTP Matched");
            return true;
        }
      return false;
   }
}
