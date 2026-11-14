package com.octopus.ad.model;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class g {

    public enum a {
        ADP_UNKNOWN(0),
        ADP_REWARD(1),
        ADP_SPLASH(2),
        ADP_INTERSTITIAL(3),
        ADP_BANNER(4),
        ADP_FULL_SCREEN(5),
        ADP_NATIVE(6),
        ADP_DRAW(7);

        private final int i;

        static {
            XYGX();
        }

        a(int i) {
            this.i = i;
        }

        private static /* synthetic */ void XYGX() {
            char[] charArray = "YUW\u0014][W_\u0014XUC\u0014IR_VV\u0014pTSxHS^]_".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ ':');
            }
            String str = new String(charArray);
            char[] charArray2 = "YVSTSN".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ ':');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public static a a(int i) {
            switch (i) {
                case 0:
                    return ADP_UNKNOWN;
                case 1:
                    return ADP_REWARD;
                case 2:
                    return ADP_SPLASH;
                case 3:
                    return ADP_INTERSTITIAL;
                case 4:
                    return ADP_BANNER;
                case 5:
                    return ADP_FULL_SCREEN;
                case 6:
                    return ADP_NATIVE;
                case 7:
                    return ADP_DRAW;
                default:
                    return null;
            }
        }
    }

    public enum b {
        DEVICE_UNKNOWN(0),
        DEVICE_PHONE(1),
        DEVICE_FLAT(2),
        DEVICE_WEAR(3),
        DEVICE_PC(4),
        DEVICE_OTHER(5);

        private final int g;

        static {
            ROOTXP();
        }

        b(int i) {
            this.g = i;
        }

        private static /* synthetic */ void ROOTXP() {
            char[] charArray = "Û×Õ\u0096ßÙÕÝ\u0096Ú×Á\u0096ËÐÝÔÔ\u0096òÖÑúÊÑÜßÝ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 184);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÛÔÑÖÑÌ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 184);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public enum c {
        ISP_UNKNOWN(0),
        ISP_CN_MOBILE(1),
        ISP_CN_UNICOM(2),
        ISP_CN_TEL(3),
        ISP_OTHER(4);

        private final int f;

        static {
            sOaGUMl();
        }

        c(int i) {
            this.f = i;
        }

        private static /* synthetic */ void sOaGUMl() {
            char[] charArray = "+'%f/)%-f*'1f; -$$f\u0002&!\n:!,/-".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'H');
            }
            String str = new String(charArray);
            char[] charArray2 = "+$!&!<".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'H');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public final int a() {
            return this.f;
        }

        public static c a(int i) {
            if (i == 0) {
                return ISP_UNKNOWN;
            }
            if (i == 1) {
                return ISP_CN_MOBILE;
            }
            if (i == 2) {
                return ISP_CN_UNICOM;
            }
            if (i == 3) {
                return ISP_CN_TEL;
            }
            if (i != 4) {
                return null;
            }
            return ISP_OTHER;
        }
    }

    public enum d {
        NET_UNKNOWN(0),
        NET_3G(1),
        NET_4G(2),
        NET_5G(3),
        NET_WIFI(4),
        NET_OTHER(5),
        NET_2G(6);

        private final int h;

        static {
            gezln();
        }

        d(int i2) {
            this.h = i2;
        }

        private static /* synthetic */ void gezln() {
            char[] charArray = "·»¹ú³µ¹±ú¶»\u00adú§¼±¸¸ú\u009eº½\u0096¦½°³±".toCharArray();
            int length = charArray.length;
            for (int i2 = 0; i2 < length; i2++) {
                charArray[i2] = (char) (charArray[i2] ^ 212);
            }
            String str = new String(charArray);
            char[] charArray2 = "·¸½º½ ".toCharArray();
            int length2 = charArray2.length;
            for (int i3 = 0; i3 < length2; i3++) {
                charArray2[i3] = (char) (charArray2[i3] ^ 212);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public final int a() {
            return this.h;
        }

        public static d a(int i2) {
            switch (i2) {
                case 0:
                    return NET_UNKNOWN;
                case 1:
                    return NET_3G;
                case 2:
                    return NET_4G;
                case 3:
                    return NET_5G;
                case 4:
                    return NET_WIFI;
                case 5:
                    return NET_OTHER;
                case 6:
                    return NET_2G;
                default:
                    return null;
            }
        }
    }

    public enum e {
        PLATFORM_UNKNOWN(0),
        PLATFORM_IOS(1),
        PLATFORM_ANDROID(2),
        PLATFORM_OTHER(3);

        private final int e;

        static {
            FhKbbF();
        }

        e(int i) {
            this.e = i;
        }

        private static /* synthetic */ void FhKbbF() {
            char[] charArray = "\u0010\u001c\u001e]\u0014\u0012\u001e\u0016]\u0011\u001c\n]\u0000\u001b\u0016\u001f\u001f]9\u001d\u001a1\u0001\u001a\u0017\u0014\u0016".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 's');
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0010\u001f\u001a\u001d\u001a\u0007".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 's');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public enum f {
        RENDER_UNKNOWN(0),
        RENDER_VIDEO(1),
        RENDER_PIC(2),
        RENDER_H5(3),
        RENDER_JSON(4),
        RENDER_VAST_VIDEO(5);

        private final int g;

        static {
            fOuk();
        }

        f(int i) {
            this.g = i;
        }

        public static f a(int i) {
            if (i == 0) {
                return RENDER_UNKNOWN;
            }
            if (i == 1) {
                return RENDER_VIDEO;
            }
            if (i == 2) {
                return RENDER_PIC;
            }
            if (i == 3) {
                return RENDER_H5;
            }
            if (i == 4) {
                return RENDER_JSON;
            }
            if (i != 5) {
                return null;
            }
            return RENDER_VAST_VIDEO;
        }

        private static /* synthetic */ void fOuk() {
            char[] charArray = "!-/l%#/'l -;l1*'..l\b,+\u00000+&%'".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'B');
            }
            String str = new String(charArray);
            char[] charArray2 = "!.+,+6".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'B');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    /* renamed from: com.octopus.ad.model.g$g, reason: collision with other inner class name */
    public enum EnumC0424g {
        REQ_UNKNOWN(0),
        REQ_AD(1),
        REQ_WIFI_PRELOAD(2);

        private final int d;

        static {
            DAilBO();
        }

        EnumC0424g(int i) {
            this.d = i;
        }

        private static /* synthetic */ void DAilBO() {
            char[] charArray = "\b\u0004\u0006E\f\n\u0006\u000eE\t\u0004\u0012E\u0018\u0003\u000e\u0007\u0007E!\u0005\u0002)\u0019\u0002\u000f\f\u000e".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'k');
            }
            String str = new String(charArray);
            char[] charArray2 = "\b\u0007\u0002\u0005\u0002\u001f".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'k');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public enum h {
        SCREEN_DIRECTION_UNKOWN(0),
        PORTRAIT(1),
        LANDSCAPE(2);

        private final int d;

        static {
            vQyO();
        }

        h(int i) {
            this.d = i;
        }

        public static h a(int i) {
            if (i == 0) {
                return SCREEN_DIRECTION_UNKOWN;
            }
            if (i == 1) {
                return PORTRAIT;
            }
            if (i != 2) {
                return null;
            }
            return LANDSCAPE;
        }

        private static /* synthetic */ void vQyO() {
            char[] charArray = "íáã éïãë ìá÷ ýæëââ ÄàçÌüçêéë".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 142);
            }
            String str = new String(charArray);
            char[] charArray2 = "íâçàçú".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 142);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public enum i {
        SRC_UNKNOWN(0),
        SRC_APP(1),
        SRC_WAP(2),
        SRC_PC(3),
        SRC_TEST(4);

        private final int f;

        static {
            KnVt();
        }

        i(int i) {
            this.f = i;
        }

        private static /* synthetic */ void KnVt() {
            char[] charArray = "¦ª¨ë¢¤¨ ë§ª¼ë¶\u00ad ©©ë\u008f«¬\u0087·¬¡¢ ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 197);
            }
            String str = new String(charArray);
            char[] charArray2 = "¦©¬«¬±".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 197);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }
}
