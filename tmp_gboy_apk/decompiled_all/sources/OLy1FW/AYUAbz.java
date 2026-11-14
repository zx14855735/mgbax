package OLy1FW;

import ADYaiT.CtFAbx;
import LLiCI0.BChYOn;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.sigmob.sdk.base.views.r;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static byte f6366A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final A5SV6n f6367A4TApA = new A5SV6n(1, "android");

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final B4ZgIw.ARc23Z f6368A5SV6n = new B4ZgIw.ARc23Z(11);

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final AzWtSf f6369ADYaiT = new AzWtSf(2, 0);

    public static byte[] A2egSU(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
    }

    public static void A4TApA(Activity activity, int i) {
        View peekDecorView;
        Context context;
        activity.getTheme().applyStyle(i, true);
        Window window = activity.getWindow();
        Resources.Theme theme = (window == null || (peekDecorView = window.peekDecorView()) == null || (context = peekDecorView.getContext()) == null) ? null : context.getTheme();
        if (theme != null) {
            theme.applyStyle(i, true);
        }
    }

    public static byte[] A5SV6n(char c) {
        return new byte[]{(byte) (c & 255), (byte) ((c >> '\b') & 255)};
    }

    public static int ADYaiT(int i, int i2) {
        return BV3sI0.A2egSU.AMqCpz(i, (Color.alpha(i) * i2) / 255);
    }

    public static byte[] AMqCpz(Activity activity, Map map) {
        A5SV6n a5SV6n;
        if (map.entrySet().isEmpty()) {
            throw new IllegalArgumentException("No color resources provided for harmonization.");
        }
        A5SV6n a5SV6n2 = new A5SV6n(127, activity.getPackageName());
        HashMap hashMap = new HashMap();
        A2egSU a2egSU = null;
        for (Map.Entry entry : map.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            String resourceEntryName = activity.getResources().getResourceEntryName(((Integer) entry.getKey()).intValue());
            A2egSU a2egSU2 = new A2egSU(intValue, ((Integer) entry.getValue()).intValue(), resourceEntryName);
            if (!activity.getResources().getResourceTypeName(((Integer) entry.getKey()).intValue()).equals("color")) {
                throw new IllegalArgumentException(CtFAbx.AzWtSf(CtFAbx.B3GDIM("Non color resource found: name=", resourceEntryName, ", typeId="), a2egSU2.f6337A4TApA & 255));
            }
            byte b = a2egSU2.f6336A2egSU;
            if (b == 1) {
                a5SV6n = f6367A4TApA;
            } else {
                if (b != Byte.MAX_VALUE) {
                    throw new IllegalArgumentException(CtFAbx.ARc23Z(b, "Not supported with unknown package id: "));
                }
                a5SV6n = a5SV6n2;
            }
            if (!hashMap.containsKey(a5SV6n)) {
                hashMap.put(a5SV6n, new ArrayList());
            }
            ((List) hashMap.get(a5SV6n)).add(a2egSU2);
            a2egSU = a2egSU2;
        }
        byte b2 = a2egSU.f6337A4TApA;
        f6366A2egSU = b2;
        if (b2 == 0) {
            throw new IllegalArgumentException("No color resources found for harmonization.");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ArrayList arrayList = new ArrayList();
        int size = hashMap.size();
        ARc23Z aRc23Z = new ARc23Z(false, new String[0]);
        for (Map.Entry entry2 : hashMap.entrySet()) {
            List list = (List) entry2.getValue();
            Collections.sort(list, f6368A5SV6n);
            arrayList.add(new A4TApA((A5SV6n) entry2.getKey(), list));
        }
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((A4TApA) it.next()).A2egSU();
        }
        int i2 = aRc23Z.f6361AcNBzu + 12 + i;
        byteArrayOutputStream.write(AcNBzu((short) 2));
        byteArrayOutputStream.write(AcNBzu((short) 12));
        byteArrayOutputStream.write(A2egSU(i2));
        byteArrayOutputStream.write(A2egSU(size));
        aRc23Z.A2egSU(byteArrayOutputStream);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            A4TApA a4TApA = (A4TApA) it2.next();
            a4TApA.f6340A2egSU.A2egSU(byteArrayOutputStream);
            A5SV6n a5SV6n3 = a4TApA.f6341A4TApA;
            byteArrayOutputStream.write(A2egSU(a5SV6n3.f6344A2egSU));
            char[] charArray = a5SV6n3.f6345A4TApA.toCharArray();
            for (int i3 = 0; i3 < 128; i3++) {
                if (i3 < charArray.length) {
                    byteArrayOutputStream.write(A5SV6n(charArray[i3]));
                } else {
                    byteArrayOutputStream.write(A5SV6n((char) 0));
                }
            }
            byteArrayOutputStream.write(A2egSU(MediaPlayer.MEDIA_PLAYER_OPTION_UPDATE_TIMESTAMP_MODE));
            byteArrayOutputStream.write(A2egSU(0));
            ARc23Z aRc23Z2 = a4TApA.f6342A5SV6n;
            byteArrayOutputStream.write(A2egSU(aRc23Z2.f6361AcNBzu + MediaPlayer.MEDIA_PLAYER_OPTION_UPDATE_TIMESTAMP_MODE));
            byteArrayOutputStream.write(A2egSU(0));
            byteArrayOutputStream.write(A2egSU(0));
            aRc23Z2.A2egSU(byteArrayOutputStream);
            a4TApA.f6343ADYaiT.A2egSU(byteArrayOutputStream);
            ASJ6gh aSJ6gh = a4TApA.AMqCpz;
            aSJ6gh.f6362A2egSU.A2egSU(byteArrayOutputStream);
            byteArrayOutputStream.write(new byte[]{f6366A2egSU, 0, 0, 0});
            byteArrayOutputStream.write(A2egSU(aSJ6gh.f6363A4TApA));
            for (int i4 : aSJ6gh.f6364A5SV6n) {
                byteArrayOutputStream.write(A2egSU(i4));
            }
            BChYOn bChYOn = aSJ6gh.f6365ADYaiT;
            ((ADYaiT) bChYOn.f4726A4TApA).A2egSU(byteArrayOutputStream);
            byteArrayOutputStream.write(new byte[]{f6366A2egSU, 0, 0, 0});
            byteArrayOutputStream.write(A2egSU(bChYOn.f4725A2egSU));
            int[] iArr = (int[]) bChYOn.f4728ADYaiT;
            byteArrayOutputStream.write(A2egSU((iArr.length * 4) + 84));
            byteArrayOutputStream.write((byte[]) bChYOn.f4727A5SV6n);
            for (int i5 : iArr) {
                byteArrayOutputStream.write(A2egSU(i5));
            }
            for (AMqCpz aMqCpz : (AMqCpz[]) bChYOn.AMqCpz) {
                aMqCpz.getClass();
                byteArrayOutputStream.write(AcNBzu((short) 8));
                byteArrayOutputStream.write(AcNBzu((short) 2));
                byteArrayOutputStream.write(A2egSU(aMqCpz.f6349A2egSU));
                byteArrayOutputStream.write(AcNBzu((short) 8));
                byteArrayOutputStream.write(new byte[]{0, 28});
                byteArrayOutputStream.write(A2egSU(aMqCpz.f6350A4TApA));
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] ARc23Z(short s) {
        return s > 127 ? new byte[]{(byte) ((127 & (s >> 8)) | r.b.d), (byte) (s & 255)} : new byte[]{(byte) (s & 255)};
    }

    public static int ASJ6gh(int i, View view) {
        Context context = view.getContext();
        TypedValue ADYaiT2 = P3rngT.A4TApA.ADYaiT(view.getContext(), i, view.getClass().getCanonicalName());
        int i2 = ADYaiT2.resourceId;
        return i2 != 0 ? BPw6Q8.ASJ6gh.A4TApA(context, i2) : ADYaiT2.data;
    }

    public static int AYUAbz(Context context, int i, int i2) {
        Integer num;
        TypedValue A2egSU2 = P3rngT.A4TApA.A2egSU(context, i);
        if (A2egSU2 != null) {
            int i3 = A2egSU2.resourceId;
            num = Integer.valueOf(i3 != 0 ? BPw6Q8.ASJ6gh.A4TApA(context, i3) : A2egSU2.data);
        } else {
            num = null;
        }
        return num != null ? num.intValue() : i2;
    }

    public static int AZOQYO(Context context, int i, String str) {
        TypedValue ADYaiT2 = P3rngT.A4TApA.ADYaiT(context, i, str);
        int i2 = ADYaiT2.resourceId;
        return i2 != 0 ? BPw6Q8.ASJ6gh.A4TApA(context, i2) : ADYaiT2.data;
    }

    public static boolean AZkASS(int i) {
        if (i == 0) {
            return false;
        }
        ThreadLocal threadLocal = BV3sI0.A2egSU.f1481A2egSU;
        double[] dArr = (double[]) threadLocal.get();
        if (dArr == null) {
            dArr = new double[3];
            threadLocal.set(dArr);
        }
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d = red / 255.0d;
        double pow = d < 0.04045d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d);
        double d2 = green / 255.0d;
        double pow2 = d2 < 0.04045d ? d2 / 12.92d : Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
        double d3 = blue / 255.0d;
        double pow3 = d3 < 0.04045d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.1805d * pow3) + (0.3576d * pow2) + (0.4124d * pow)) * 100.0d;
        double d4 = ((0.0722d * pow3) + (0.7152d * pow2) + (0.2126d * pow)) * 100.0d;
        dArr[1] = d4;
        dArr[2] = ((pow3 * 0.9505d) + (pow2 * 0.1192d) + (pow * 0.0193d)) * 100.0d;
        return d4 / 100.0d > 0.5d;
    }

    public static int AaHO0E(float f, int i, int i2) {
        return BV3sI0.A2egSU.A5SV6n(BV3sI0.A2egSU.AMqCpz(i2, Math.round(Color.alpha(i2) * f)), i);
    }

    public static byte[] AcNBzu(short s) {
        return new byte[]{(byte) (s & 255), (byte) ((s >> 8) & 255)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void CkWxaO() {
        char[] charArray = "«§¥æ¯©¥\u00adæª§±æ» \u00ad¤¤æ\u0082¦¡\u008aº¡¬¯\u00ad".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 200);
        }
        String str = new String(charArray);
        char[] charArray2 = "«¤¡¦¡¼".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 200);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
