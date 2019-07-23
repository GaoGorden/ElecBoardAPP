package p.gordenyou.elecboardapp.unity;

/**
 * Created by Administrator on 2017-07-10.
 */

public class FunList {
    //功能ID
    private static String FunId = "";
    //功能图片
    private static int ImageId = 0;
    //功能名称
    private static String FunName = "";
    public static String GetFunId() {
        return FunId;
    }
    public static int GetImagetId() {
        return ImageId;
    }
    public static String GetFunName() { return FunName; }
    public static void SetFunId(String a) {
        FunList.FunId = a;
    }
    public static void SetImageId(int a) {
        FunList.ImageId = a;
    }
    public static void SetFunName(String a) {
        FunList.FunName = a;
    }
}
