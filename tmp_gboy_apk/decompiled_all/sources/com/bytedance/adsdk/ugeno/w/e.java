package com.bytedance.adsdk.ugeno.w;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum e {
    UNKNOWN_EVENT("UNKNOWN_EVENT", 0),
    TAP_EVENT("onTap", 1),
    LONG_TAP_EVENT("onLongTap", 2),
    SHAKE_EVENT("onShake", 3),
    TWIST_EVENT("onTwist", 18),
    SLIDE_EVENT("onSlide", 4),
    EXPOSURE_EVENT("onExposure", 5),
    SCROLL_EVENT("onScroll", 6),
    PULL_TO_REFRESH_EVENT("onPullToRefresh", 7),
    LOAD_MORE_EVENT("onLoadMore", 8),
    TIMER("onTimer", 9),
    DELAY("onDelay", 10),
    ANIMATION("onAnimation", 11),
    VIDEO_PROGRESS("onVideoProgress", 12),
    VIDEO_PAUSE("onVideoPause", 13),
    VIDEO_RESUME("onVideoResume", 14),
    VIDEO_FINISH("onVideoFinish", 15),
    VIDEO_PLAY("onVideoPlay", 16),
    DOWN_EVENT("onDown", 17),
    RENDER_SUCCESS("onRenderSuccess", 22);

    private int ht;
    private String pz;

    static {
        SMuqTB();
    }

    e(String str, int i) {
        this.pz = str;
        this.ht = i;
    }

    private static /* synthetic */ void SMuqTB() {
        char[] charArray = "\u001e\u0012\u0010S\u001a\u001c\u0010\u0018S\u001f\u0012\u0004S\u000e\u0015\u0018\u0011\u0011S7\u0013\u0014?\u000f\u0014\u0019\u001a\u0018".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '}');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001e\u0011\u0014\u0013\u0014\t".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '}');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public int getType() {
        return this.ht;
    }

    public static e xj(String str) {
        for (e eVar : values()) {
            if (eVar.pz.equals(str)) {
                return eVar;
            }
        }
        return UNKNOWN_EVENT;
    }
}
