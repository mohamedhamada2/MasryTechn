package com.nglah.masrytechn.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "user")

public class UserModel implements Serializable {


    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "access_token")
    private String accessToken = "";

    @ColumnInfo(name = "expires_in")
    @SerializedName("expiresIn")
    private String expiresIn;

    @SerializedName("refresh_token")
    @ColumnInfo(name = "refreshToken")
    private String refreshToken;

    @SerializedName("isActive")
    @ColumnInfo(name = "active")
    private int active = 0;

    @SerializedName("id")
    @ColumnInfo(name = "id")
    private Integer id;
    @SerializedName("userName")
    @ColumnInfo(name = "userName")
    private String UserName;

    @SerializedName("userType")
    @ColumnInfo(name = "userType")
    private Integer userType;

    @SerializedName("email")
    @ColumnInfo(name = "email")
    private String Email;

    @SerializedName("phone")
    @ColumnInfo(name = "phone")
    private String Phone;

    @SerializedName("location")
    @ColumnInfo(name = "location")
    private String location;

    @SerializedName("imageUrl")
    @ColumnInfo(name = "image")
    private String imageUrl;

    @SerializedName("loginType")
    @ColumnInfo(name = "loginType")
    private Integer loginType;

    @SerializedName("category_id")
    @ColumnInfo(name = "category_id")
    private String categoryId;

    private int detailsId;

    @Ignore
    public static UserModel loggedInUser = null;

    public UserModel() {
    }

    // Getter and Setter


    @NonNull
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(@NonNull String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoginType() {
        return loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public int getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(int detailsId) {
        this.detailsId = detailsId;
    }
}
