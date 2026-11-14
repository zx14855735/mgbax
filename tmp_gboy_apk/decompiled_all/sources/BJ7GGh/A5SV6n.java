package BJ7GGh;

import android.util.SparseIntArray;
import com.qq.e.comm.adevent.AdEventType;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final SparseIntArray f1342A2egSU;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1342A2egSU = sparseIntArray;
        sparseIntArray.append(98, 64);
        sparseIntArray.append(75, 65);
        sparseIntArray.append(84, 8);
        sparseIntArray.append(85, 9);
        sparseIntArray.append(87, 10);
        sparseIntArray.append(88, 11);
        sparseIntArray.append(94, 12);
        sparseIntArray.append(93, 13);
        sparseIntArray.append(65, 14);
        sparseIntArray.append(64, 15);
        sparseIntArray.append(60, 16);
        sparseIntArray.append(62, 52);
        sparseIntArray.append(61, 53);
        sparseIntArray.append(66, 2);
        sparseIntArray.append(68, 3);
        sparseIntArray.append(67, 4);
        sparseIntArray.append(103, 49);
        sparseIntArray.append(104, 50);
        sparseIntArray.append(72, 5);
        sparseIntArray.append(73, 6);
        sparseIntArray.append(74, 7);
        sparseIntArray.append(55, 67);
        sparseIntArray.append(0, 1);
        sparseIntArray.append(89, 17);
        sparseIntArray.append(90, 18);
        sparseIntArray.append(71, 19);
        sparseIntArray.append(70, 20);
        sparseIntArray.append(108, 21);
        sparseIntArray.append(111, 22);
        sparseIntArray.append(AdEventType.AD_RENDER_SUCCESS, 23);
        sparseIntArray.append(106, 24);
        sparseIntArray.append(110, 25);
        sparseIntArray.append(107, 26);
        sparseIntArray.append(105, 55);
        sparseIntArray.append(AdEventType.AD_TICK, 54);
        sparseIntArray.append(80, 29);
        sparseIntArray.append(95, 30);
        sparseIntArray.append(69, 44);
        sparseIntArray.append(82, 45);
        sparseIntArray.append(97, 46);
        sparseIntArray.append(81, 47);
        sparseIntArray.append(96, 48);
        sparseIntArray.append(58, 27);
        sparseIntArray.append(57, 28);
        sparseIntArray.append(99, 31);
        sparseIntArray.append(76, 32);
        sparseIntArray.append(101, 33);
        sparseIntArray.append(100, 34);
        sparseIntArray.append(102, 35);
        sparseIntArray.append(78, 36);
        sparseIntArray.append(77, 37);
        sparseIntArray.append(79, 38);
        sparseIntArray.append(83, 39);
        sparseIntArray.append(92, 40);
        sparseIntArray.append(86, 41);
        sparseIntArray.append(63, 42);
        sparseIntArray.append(59, 43);
        sparseIntArray.append(91, 51);
        sparseIntArray.append(AdEventType.AD_ZOOM_OUT_PLAY_FINISH, 66);
        qOIg();
    }

    private static /* synthetic */ void qOIg() {
        char[] charArray = "BNL\u000fF@LD\u000fCNX\u000fRIDMM\u000fkOHcSHEFD".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '!');
        }
        String str = new String(charArray);
        char[] charArray2 = "BMHOHU".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '!');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
