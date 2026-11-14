package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaac {
    private static String[] aaaaaaaa = {"sdcard/Android/data/com.bluestacks.home", "sdcard/Android/data/com.bluestacks.settings", "sdcard/Android/data/com.microvirt.guide", "sdcard/Android/data/com.microvirt.launcher2"};

    public static class aaaaaaa0 {
        public String aaaaaaa0;
        public int aaaaaaaa;

        public aaaaaaa0(int i, String str) {
            this.aaaaaaaa = i;
            this.aaaaaaa0 = str;
        }
    }

    public static class aaaaaaao {
        private static final aaaaaaac aaaaaaaa = new aaaaaaac();

        static {
            ESILdqS();
        }

        private static /* synthetic */ void ESILdqS() {
            char[] charArray = "åéë¨áçëã¨äéÿ¨õîãêê¨ÌèïÄôïâáã".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 134);
            }
            String str = new String(charArray);
            char[] charArray2 = "åêïèïò".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 134);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    static {
        OrtH();
    }

    private static /* synthetic */ void OrtH() {
        char[] charArray = "\u0004\b\nI\u0000\u0006\n\u0002I\u0005\b\u001eI\u0014\u000f\u0002\u000b\u000bI-\t\u000e%\u0015\u000e\u0003\u0000\u0002".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'g');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0004\u000b\u000e\t\u000e\u0013".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'g');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private String aaaaaaa0(String str) {
        String aaaaaaaa2 = aaaaaaaa(str);
        if (TextUtils.isEmpty(aaaaaaaa2)) {
            return null;
        }
        return aaaaaaaa2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006d, code lost:
    
        if (r4.equals("cancro") == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaac.aaaaaaa0 aaaaaaac() {
        /*
            r7 = this;
            r0 = 2
            r1 = 1
            r2 = 0
            java.lang.String r3 = "ro.hardware"
            java.lang.String r3 = r7.aaaaaaa0(r3)
            if (r3 != 0) goto L12
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaac$aaaaaaa0 r0 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaac$aaaaaaa0
            r1 = 0
            r0.<init>(r2, r1)
            return r0
        L12:
            java.util.Locale r4 = java.util.Locale.ENGLISH
            java.lang.String r4 = r3.toLowerCase(r4)
            r4.getClass()
            r5 = -1
            int r6 = r4.hashCode()
            switch(r6) {
                case -1367724016: goto L67;
                case -822798509: goto L5c;
                case 109271: goto L51;
                case 3570999: goto L46;
                case 3613077: goto L3b;
                case 100361430: goto L30;
                case 937844646: goto L25;
                default: goto L23;
            }
        L23:
            r2 = -1
            goto L70
        L25:
            java.lang.String r2 = "android_x86"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L2e
            goto L23
        L2e:
            r2 = 6
            goto L70
        L30:
            java.lang.String r2 = "intel"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L39
            goto L23
        L39:
            r2 = 5
            goto L70
        L3b:
            java.lang.String r2 = "vbox"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L44
            goto L23
        L44:
            r2 = 4
            goto L70
        L46:
            java.lang.String r2 = "ttvm"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L4f
            goto L23
        L4f:
            r2 = 3
            goto L70
        L51:
            java.lang.String r2 = "nox"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L5a
            goto L23
        L5a:
            r2 = 2
            goto L70
        L5c:
            java.lang.String r2 = "vbox86"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L65
            goto L23
        L65:
            r2 = 1
            goto L70
        L67:
            java.lang.String r6 = "cancro"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L70
            goto L23
        L70:
            switch(r2) {
                case 0: goto L74;
                case 1: goto L74;
                case 2: goto L74;
                case 3: goto L74;
                case 4: goto L74;
                case 5: goto L74;
                case 6: goto L74;
                default: goto L73;
            }
        L73:
            goto L75
        L74:
            r0 = 1
        L75:
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaac$aaaaaaa0 r1 = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaac$aaaaaaa0
            r1.<init>(r0, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaac.aaaaaaac():io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaac$aaaaaaa0");
    }

    private aaaaaaa0 aaaaaaae() {
        String aaaaaaa02 = aaaaaaa0("ro.board.platform");
        if (aaaaaaa02 == null) {
            return new aaaaaaa0(0, null);
        }
        return new aaaaaaa0(aaaaaaa02.toLowerCase(Locale.ENGLISH).contains("android") ? 1 : 2, aaaaaaa02);
    }

    private aaaaaaa0 aaaaaaan() {
        String aaaaaaa02 = aaaaaaa0("ro.product.model");
        if (aaaaaaa02 == null) {
            return new aaaaaaa0(0, null);
        }
        String lowerCase = aaaaaaa02.toLowerCase(Locale.ENGLISH);
        return new aaaaaaa0((lowerCase.contains("google_sdk") || lowerCase.contains("emulator") || lowerCase.contains("android sdk built for x86")) ? 1 : 2, aaaaaaa02);
    }

    private aaaaaaa0 aaaaaaao() {
        String aaaaaaa02 = aaaaaaa0("ro.build.flavor");
        if (aaaaaaa02 == null) {
            return new aaaaaaa0(0, null);
        }
        String lowerCase = aaaaaaa02.toLowerCase(Locale.ENGLISH);
        return new aaaaaaa0((lowerCase.contains("vbox") || lowerCase.contains("sdk_gphone")) ? 1 : 2, aaaaaaa02);
    }

    private aaaaaaa0 aaaaaaau() {
        String aaaaaaa02 = aaaaaaa0("ro.product.manufacturer");
        if (aaaaaaa02 == null) {
            return new aaaaaaa0(0, null);
        }
        String lowerCase = aaaaaaa02.toLowerCase(Locale.ENGLISH);
        return new aaaaaaa0((lowerCase.contains("genymotion") || lowerCase.contains("netease")) ? 1 : 2, aaaaaaa02);
    }

    public static aaaaaaa0 aaaaaaav() {
        int i = 0;
        int i2 = 0;
        int i3 = 2;
        while (true) {
            String[] strArr = aaaaaaaa;
            if (i >= strArr.length) {
                break;
            }
            if (A2egSU.BPw6Q8(strArr[i])) {
                i2++;
            } else {
                i3 = 0;
            }
            if (i2 > 2) {
                break;
            }
            i++;
        }
        return new aaaaaaa0(i2 != 1 ? i2 != 2 ? i3 : 1 : 0, "PkgName");
    }

    public static final aaaaaaac aaaaaaeo() {
        return aaaaaaao.aaaaaaaa;
    }

    public boolean aaaaaaaa(Context context) {
        int i;
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        int i2 = aaaaaaac().aaaaaaaa;
        if (i2 == 0) {
            i = 1;
        } else {
            if (i2 == 1) {
                return true;
            }
            i = 0;
        }
        int i3 = aaaaaaav().aaaaaaaa;
        if (i3 == 0) {
            i++;
        } else if (i3 == 1) {
            return true;
        }
        int i4 = aaaaaaao().aaaaaaaa;
        if (i4 == 0) {
            i++;
        } else if (i4 == 1) {
            return true;
        }
        int i5 = aaaaaaan().aaaaaaaa;
        if (i5 == 0) {
            i++;
        } else if (i5 == 1) {
            return true;
        }
        int i6 = aaaaaaau().aaaaaaaa;
        if (i6 == 0) {
            i++;
        } else if (i6 == 1) {
            return true;
        }
        int i7 = aaaaaaa0().aaaaaaaa;
        if (i7 == 0) {
            i++;
        } else if (i7 == 1) {
            return true;
        }
        int i8 = aaaaaaae().aaaaaaaa;
        if (i8 == 0) {
            i++;
        } else if (i8 == 1) {
            return true;
        }
        int i9 = aaaaaaaa().aaaaaaaa;
        if (i9 == 0) {
            i += 2;
        } else if (i9 == 1) {
            return true;
        }
        if (!aaaaaaao(context)) {
            i++;
        }
        if (!aaaaaaa0(context)) {
            i++;
        }
        return i > 3;
    }

    private aaaaaaac() {
    }

    private aaaaaaa0 aaaaaaa0() {
        String aaaaaaa02 = aaaaaaa0("ro.product.board");
        if (aaaaaaa02 == null) {
            return new aaaaaaa0(0, null);
        }
        String lowerCase = aaaaaaa02.toLowerCase(Locale.ENGLISH);
        return new aaaaaaa0((lowerCase.contains("android") || lowerCase.contains("goldfish")) ? 1 : 2, aaaaaaa02);
    }

    private boolean aaaaaaao(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    private boolean aaaaaaa0(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
    }

    private String aaaaaaaa(String str) {
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
            if (invoke != null) {
                return (String) invoke;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private aaaaaaa0 aaaaaaaa() {
        String aaaaaaa02 = aaaaaaa0("gsm.version.baseband");
        if (aaaaaaa02 == null) {
            return new aaaaaaa0(0, null);
        }
        return new aaaaaaa0(aaaaaaa02.contains("1.0.0.0") ? 1 : 2, aaaaaaa02);
    }
}
