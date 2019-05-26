package Models;

public class UserStatic {

    private static String userId;
    private static String username = "";
    private static String email="";
    private static String userType="";
    private static String isActive="";


    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        UserStatic.userId = userId;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UserStatic.username = username;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        UserStatic.email = email;
    }

    public static String getUserType() {
        return userType;
    }

    public static void setUserType(String userType) {
        UserStatic.userType = userType;
    }

    public static String getIsActive() {
        return isActive;
    }

    public static void setIsActive(String isActive) {
        UserStatic.isActive = isActive;
    }



}
