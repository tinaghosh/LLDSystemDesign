package models.product;

import models.account.Account;
import models.account.AuthenticatedUser;

public class ProductReviews {

    private double rating;
    private String reviewComments;
    private byte[] image;
    private AuthenticatedUser reviewedBy;

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getReviewComments() {
        return reviewComments;
    }

    public void setReviewComments(String reviewComments) {
        this.reviewComments = reviewComments;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public AuthenticatedUser getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(AuthenticatedUser reviewedBy) {
        this.reviewedBy = reviewedBy;
    }
}
