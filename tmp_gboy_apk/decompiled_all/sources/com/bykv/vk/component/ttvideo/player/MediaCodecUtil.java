package com.bykv.vk.component.ttvideo.player;

import android.util.Pair;
import com.bytedance.sdk.component.utils.pl;
import com.sigmob.sdk.archives.tar.e;
import com.sigmob.sdk.base.views.r;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class MediaCodecUtil {
    private static final Map<String, Integer> DOLBY_VISION_STRING_TO_LEVEL;
    private static final Map<String, Integer> DOLBY_VISION_STRING_TO_PROFILE;
    private static final Pattern PROFILE_PATTERN = Pattern.compile("^\\D?(\\d+)$");
    private static final String TAG = "MediaCodecUtil";

    static {
        HashMap hashMap = new HashMap();
        DOLBY_VISION_STRING_TO_LEVEL = hashMap;
        hashMap.put("01", 1);
        hashMap.put("02", 2);
        hashMap.put("03", 4);
        hashMap.put("04", 8);
        hashMap.put("05", 16);
        hashMap.put("06", 32);
        hashMap.put("07", 64);
        Integer valueOf = Integer.valueOf(r.b.d);
        hashMap.put("08", valueOf);
        hashMap.put("09", 256);
        HashMap hashMap2 = new HashMap();
        DOLBY_VISION_STRING_TO_PROFILE = hashMap2;
        hashMap2.put(e.V, 1);
        hashMap2.put("01", 2);
        hashMap2.put("02", 4);
        hashMap2.put("03", 8);
        hashMap2.put("04", 16);
        hashMap2.put("05", 32);
        hashMap2.put("06", 64);
        hashMap2.put("07", valueOf);
        hashMap2.put("08", 256);
        hashMap2.put("09", 512);
        zWDSLB();
    }

    public static String getDolbyCodecs(int i, int i2) {
        String str;
        if (i == 4 || i == 5 || i == 7) {
            str = "dvhe";
        } else if (i == 8) {
            str = "hev1";
        } else {
            if (i != 9) {
                return null;
            }
            str = "avc3";
        }
        return str + ".0" + i + ".0" + i2;
    }

    public static Pair<Integer, Integer> getDolbyVisionProfileAndLevel(String str, String[] strArr) {
        if (strArr.length < 3) {
            pl.hf(TAG, "Ignoring malformed Dolby Vision codec string: ".concat(String.valueOf(str)));
            return null;
        }
        Matcher matcher = PROFILE_PATTERN.matcher(strArr[1]);
        if (!matcher.matches()) {
            pl.hf(TAG, "Ignoring malformed Dolby Vision codec string: ".concat(String.valueOf(str)));
            return null;
        }
        String group = matcher.group(1);
        Integer num = DOLBY_VISION_STRING_TO_PROFILE.get(group);
        if (num == null) {
            pl.hf(TAG, "Unknown Dolby Vision profile string: ".concat(String.valueOf(group)));
            return null;
        }
        String str2 = strArr[2];
        Integer num2 = DOLBY_VISION_STRING_TO_LEVEL.get(str2);
        if (num2 != null) {
            return new Pair<>(num, num2);
        }
        pl.hf(TAG, "Unknown Dolby Vision level string: ".concat(String.valueOf(str2)));
        return null;
    }

    private static /* synthetic */ void zWDSLB() {
        char[] charArray = "ÎÂÀ\u0083ÊÌÀÈ\u0083ÏÂÔ\u0083ÞÅÈÁÁ\u0083çÃÄïßÄÉÊÈ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 173);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÎÁÄÃÄÙ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 173);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
