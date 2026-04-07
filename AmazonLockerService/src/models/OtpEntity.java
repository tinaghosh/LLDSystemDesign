package models;

import java.time.Instant;

public class OtpEntity {
    private String otpHash;
    private Instant expiryTime;
    private int attempts;
    private boolean verified;

    public OtpEntity(String otpHash, Instant expiryTime) {
        this.otpHash = otpHash;
        this.expiryTime = expiryTime;
        this.attempts = 0;
        this.verified = false;
    }

    public String getOtpHash() {
        return otpHash;
    }

    public void setOtpHash(String otpHash) {
        this.otpHash = otpHash;
    }

    public Instant getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Instant expiryTime) {
        this.expiryTime = expiryTime;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
