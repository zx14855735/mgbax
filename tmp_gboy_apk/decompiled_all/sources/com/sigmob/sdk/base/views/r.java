package com.sigmob.sdk.base.views;

import android.graphics.Color;
import android.graphics.Paint;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public static final int f13321a = Color.rgb(77, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 239);
    public static final int b = Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO);

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final int f13322a = 60;
        public static final int b = 0;
        public static final int c = 5;
        public static final int d = -1;
        public static final float e = 8.0f;
        public static final Paint.Cap f = Paint.Cap.ROUND;

        static {
            dFLzgwF();
        }

        private static /* synthetic */ void dFLzgwF() {
            char[] charArray = "¼°²ñ¸¾²ºñ½°¦ñ¬·º³³ñ\u0095±¶\u009d\u00ad¶»¸º".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 223);
            }
            String str = new String(charArray);
            char[] charArray2 = "¼³¶±¶«".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 223);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final int f13323a = 2;
        public static final int b = 4;
        public static final int c = -1;
        public static final int d = 128;
        public static final Paint.Style e;
        public static final int f;
        public static final int g = 255;
        public static final Paint.Style h;

        static {
            Paint.Style style = Paint.Style.FILL;
            e = style;
            f = r.f13321a;
            h = style;
            uegUN();
        }

        private static /* synthetic */ void uegUN() {
            char[] charArray = "¸´¶õ¼º¶¾õ¹´¢õ¨³¾··õ\u0091µ²\u0099©²¿¼¾".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 219);
            }
            String str = new String(charArray);
            char[] charArray2 = "¸·²µ²¯".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 219);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    static {
        mRjfDW();
    }

    private static /* synthetic */ void mRjfDW() {
        char[] charArray = "ýñó°ùÿóû°üñç°íöûòò°Ôð÷Üì÷úùû".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 158);
        }
        String str = new String(charArray);
        char[] charArray2 = "ýò÷ð÷ê".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 158);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
