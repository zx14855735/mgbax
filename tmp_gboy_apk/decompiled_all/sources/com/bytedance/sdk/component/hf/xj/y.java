package com.bytedance.sdk.component.hf.xj;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class y {
    private final String[] xj;

    public static final class xj {
        final List<String> xj = new ArrayList(20);

        private void w(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt <= ' ' || charAt >= 127) {
                    throw new IllegalArgumentException(com.bytedance.sdk.component.hf.xj.hf.tf.xj("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException(CtFAbx.BI9f7h("value for name ", str, " == null"));
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char charAt2 = str2.charAt(i2);
                if ((charAt2 <= 31 && charAt2 != '\t') || charAt2 >= 127) {
                    throw new IllegalArgumentException(com.bytedance.sdk.component.hf.xj.hf.tf.xj("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }

        public xj hf(String str, String str2) {
            try {
                w(str, str2);
            } catch (Throwable unused) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i = 0; i < length; i++) {
                            char charAt = str2.charAt(i);
                            if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                                sb.append(charAt);
                            } else {
                                sb.append(URLEncoder.encode(String.valueOf(charAt), "UTF-8"));
                            }
                        }
                        str2 = sb.toString();
                    } catch (UnsupportedEncodingException e) {
                        com.bytedance.sdk.component.utils.pl.xj(e);
                        return this;
                    }
                }
                return this;
            }
            return xj(str, str2);
        }

        public y xj() {
            return new y(this);
        }

        public xj xj(String str, String str2) {
            this.xj.add(str);
            this.xj.add(str2.trim());
            return this;
        }
    }

    public y(String[] strArr) {
        this.xj = strArr;
    }

    public String hf(int i) {
        return this.xj[(i * 2) + 1];
    }

    public int xj() {
        return this.xj.length / 2;
    }

    public Map<String, List<String>> hf() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int xj2 = xj();
        for (int i = 0; i < xj2; i++) {
            String lowerCase = xj(i).toLowerCase(Locale.US);
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(hf(i));
        }
        return treeMap;
    }

    public String xj(int i) {
        return this.xj[i * 2];
    }

    public y(xj xjVar) {
        List<String> list = xjVar.xj;
        this.xj = (String[]) list.toArray(new String[list.size()]);
    }
}
