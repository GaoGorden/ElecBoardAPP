package p.gordenyou.elecboardapp.unity;

/**
 * Created by James on 2017-07-10.
 */

public class SystemUser {
    //用户ID
    private static int UserId = 0;
    //登录用户名
    private static String LoginUser="";
    //用户类型
    private static int UserType = 0;
    //功能列表
    private static String FunList = "";
    //帐套
    private static String Account = "";
    //用户名称
    private static String UserName = "";

    public static int getUserId() {
        return UserId;
    }

    public static String GetLoginUser() {
        return LoginUser;
    }

    public static int GetUserType() {
        return UserType;
    }

    public static String GetAccount() {
        return Account;
    }

    public static String GetFunList() {
        return FunList;
    }

    public static String GetUserName() {
        return UserName;
    }

    public static void setUserId(int a) {
        SystemUser.UserId = a;
    }

    public static void setUserType(int Type) {
        SystemUser.UserType = Type;
    }

    public static void setAccount(String database) {
        SystemUser.Account = database;
    }

    public static void setFunList(String list) {
        SystemUser.FunList = list;
    }

    public static void setUserName(String name) {
        SystemUser.UserName = name;
    }

    public static void SetLoginUser(String LoginUser){
        SystemUser.LoginUser=LoginUser;
    }
}
