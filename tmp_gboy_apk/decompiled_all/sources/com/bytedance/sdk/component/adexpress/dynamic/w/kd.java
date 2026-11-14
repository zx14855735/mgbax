package com.bytedance.sdk.component.adexpress.dynamic.w;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.a;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.n;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    public static final Map<String, Integer> xj;
    private String c;
    private String hf;
    private y kd;
    private String u;
    private String w;
    private y y;

    static {
        HashMap hashMap = new HashMap();
        xj = hashMap;
        hashMap.put("root", 8);
        hashMap.put("footer", 6);
        hashMap.put("empty", 6);
        hashMap.put("title", 0);
        hashMap.put(MediaFormat.KEY_SUBTITLE, 0);
        hashMap.put(n.l, 0);
        hashMap.put("score-count", 0);
        hashMap.put("text_star", 0);
        hashMap.put(a.b, 0);
        hashMap.put("tag-group", 17);
        hashMap.put("app-version", 0);
        hashMap.put("development-name", 0);
        hashMap.put("privacy-detail", 23);
        hashMap.put("image", 1);
        hashMap.put("image-wide", 1);
        hashMap.put("image-square", 1);
        hashMap.put("image-long", 1);
        hashMap.put("image-splash", 1);
        hashMap.put("image-cover", 1);
        hashMap.put("app-icon", 1);
        hashMap.put("icon-download", 1);
        hashMap.put("logoad", 4);
        hashMap.put("logounion", 5);
        hashMap.put("logo-union", 9);
        hashMap.put(PointCategory.DISLIKE, 3);
        hashMap.put("close", 3);
        hashMap.put("close-fill", 3);
        hashMap.put("webview-close", 22);
        hashMap.put("feedback-dislike", 12);
        hashMap.put("button", 2);
        hashMap.put("downloadWithIcon", 2);
        hashMap.put("downloadButton", 2);
        hashMap.put("fillButton", 2);
        hashMap.put("laceButton", 2);
        hashMap.put("cardButton", 2);
        hashMap.put("colourMixtureButton", 2);
        hashMap.put("arrowButton", 1);
        hashMap.put("download-progress-button", 2);
        hashMap.put("vessel", 6);
        hashMap.put("image-group", 6);
        hashMap.put("custom-component-vessel", 6);
        hashMap.put("carousel", 24);
        hashMap.put("carousel-vessel", 26);
        hashMap.put("leisure-interact", 25);
        hashMap.put("video-hd", 7);
        hashMap.put("video", 7);
        hashMap.put("video-vd", 7);
        hashMap.put("video-sq", 7);
        hashMap.put("muted", 10);
        hashMap.put("star", 11);
        hashMap.put("skip-countdowns", 19);
        hashMap.put("skip-with-countdowns-skip-btn", 21);
        hashMap.put("skip-with-countdowns-video-countdown", 13);
        hashMap.put("skip-with-countdowns-skip-countdown", 20);
        hashMap.put("skip-with-time", 14);
        hashMap.put("skip-with-time-countdown", 13);
        hashMap.put("skip-with-time-skip-btn", 15);
        hashMap.put("skip", 27);
        hashMap.put("timedown", 13);
        hashMap.put("icon", 16);
        hashMap.put("scoreCountWithIcon", 6);
        hashMap.put("split-line", 18);
        hashMap.put("creative-playable-bait", 0);
        hashMap.put("score-count-type-2", 0);
        hashMap.put("lottie", 28);
        hashMap.put("image-flip-slide", 29);
        vIScH();
    }

    private static /* synthetic */ void vIScH() {
        char[] charArray = "ËÇÅ\u0086ÏÉÅÍ\u0086ÊÇÑ\u0086ÛÀÍÄÄ\u0086âÆÁêÚÁÌÏÍ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 168);
        }
        String str = new String(charArray);
        char[] charArray2 = "ËÄÁÆÁÜ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 168);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public y c() {
        return this.y;
    }

    public String getType() {
        return this.hf;
    }

    public String hf() {
        return this.w;
    }

    public y kd() {
        return this.kd;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DynamicLayoutBrick{type='");
        sb.append(this.hf);
        sb.append("', data='");
        sb.append(this.w);
        sb.append("', value=");
        sb.append(this.kd);
        sb.append(", themeValue=");
        sb.append(this.y);
        sb.append(", dataExtraInfo='");
        return CtFAbx.B25kr6(sb, this.c, "'}");
    }

    public void u(String str) {
        this.c = str;
    }

    public String w() {
        return this.u;
    }

    public int xj() {
        if (TextUtils.isEmpty(this.hf)) {
            return 0;
        }
        if (this.hf.equals("logo")) {
            String str = this.hf + this.w;
            this.hf = str;
            if (str.contains("logoad")) {
                return 4;
            }
            if (this.hf.contains("logounion")) {
                return 5;
            }
        }
        Map<String, Integer> map = xj;
        if (map.get(this.hf) != null) {
            return map.get(this.hf).intValue();
        }
        return -1;
    }

    public int y() {
        return this.kd.ne();
    }

    public void hf(String str) {
        this.w = str;
    }

    public String u() {
        return this.c;
    }

    public void w(String str) {
        this.u = str;
    }

    public void hf(y yVar) {
        this.y = yVar;
    }

    public void xj(String str) {
        this.hf = str;
    }

    public void xj(y yVar) {
        this.kd = yVar;
    }
}
