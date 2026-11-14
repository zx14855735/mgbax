package RD2OKB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AaHO0E extends AZkASS {
    public static int ADYaiT(List list) {
        RXb0Sz.ARc23Z.AMqCpz(list, "<this>");
        return list.size() - 1;
    }

    public static List AMqCpz(Object... objArr) {
        if (objArr.length <= 0) {
            return B9tovu.f7846AcNBzu;
        }
        List asList = Arrays.asList(objArr);
        RXb0Sz.ARc23Z.ADYaiT(asList, "asList(...)");
        return asList;
    }

    public static ArrayList ARc23Z(Object... objArr) {
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new AMqCpz(objArr, true));
    }
}
