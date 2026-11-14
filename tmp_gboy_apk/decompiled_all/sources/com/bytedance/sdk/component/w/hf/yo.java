package com.bytedance.sdk.component.w.hf;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class yo {
    public final String[] xj;

    public yo(xj xjVar) {
        List<String> list = xjVar.xj;
        this.xj = (String[]) list.toArray(new String[list.size()]);
    }

    public boolean equals(Object obj) {
        return (obj instanceof yo) && Arrays.equals(((yo) obj).xj, this.xj);
    }

    public int hashCode() {
        return Arrays.hashCode(this.xj);
    }

    public String hf(int i) {
        return this.xj[(i * 2) + 1];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int xj2 = xj();
        for (int i = 0; i < xj2; i++) {
            sb.append(xj(i));
            sb.append(": ");
            sb.append(hf(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    public Map<String, List<String>> w() {
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

    public String xj(String str) {
        return xj(this.xj, str);
    }

    public static final class xj {
        final List<String> xj = new ArrayList(20);

        private void u(String str, String str2) {
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
                    throw new IllegalArgumentException(com.bytedance.sdk.component.w.hf.xj.w.xj("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException(CtFAbx.BI9f7h("value for name ", str, " == null"));
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char charAt2 = str2.charAt(i2);
                if ((charAt2 <= 31 && charAt2 != '\t') || charAt2 >= 127) {
                    throw new IllegalArgumentException(com.bytedance.sdk.component.w.hf.xj.w.xj("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }

        public xj hf(String str, String str2) {
            this.xj.add(str);
            this.xj.add(str2.trim());
            return this;
        }

        public xj w(String str, String str2) {
            try {
                u(str, str2);
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
            hf(str);
            hf(str, str2);
            return this;
        }

        public xj xj(String str) {
            int indexOf = str.indexOf(":", 1);
            return indexOf != -1 ? hf(str.substring(0, indexOf), str.substring(indexOf + 1)) : str.startsWith(":") ? hf("", str.substring(1)) : hf("", str);
        }

        public xj hf(String str) {
            int i = 0;
            while (i < this.xj.size()) {
                if (str.equalsIgnoreCase(this.xj.get(i))) {
                    this.xj.remove(i);
                    this.xj.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public xj xj(String str, String str2) {
            try {
                u(str, str2);
            } catch (Throwable unused) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i = 0; i < length; i++) {
                            char charAt = str2.charAt(i);
                            if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                                sb.append(URLEncoder.encode(String.valueOf(charAt), "UTF-8"));
                            } else {
                                sb.append(charAt);
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
            return hf(str, str2);
        }

        public yo xj() {
            return new yo(this);
        }
    }

    public List<String> hf(String str) {
        int xj2 = xj();
        ArrayList arrayList = null;
        for (int i = 0; i < xj2; i++) {
            if (str.equalsIgnoreCase(xj(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(hf(i));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.EMPTY_LIST;
    }

    public int xj() {
        return this.xj.length / 2;
    }

    private yo(String[] strArr) {
        this.xj = strArr;
    }

    public String xj(int i) {
        return this.xj[i * 2];
    }

    private static String xj(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static yo xj(String... strArr) {
        if (strArr != null) {
            if (strArr.length % 2 == 0) {
                String[] strArr2 = (String[]) strArr.clone();
                for (int i = 0; i < strArr2.length; i++) {
                    String str = strArr2[i];
                    if (str != null) {
                        strArr2[i] = str.trim();
                    } else {
                        throw new IllegalArgumentException("Headers cannot be null");
                    }
                }
                for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
                    String str2 = strArr2[i2];
                    String str3 = strArr2[i2 + 1];
                    if (str2.length() == 0 || str2.indexOf(0) != -1 || str3.indexOf(0) != -1) {
                        throw new IllegalArgumentException(CtFAbx.AmA8tU("Unexpected header: ", str2, ": ", str3));
                    }
                }
                return new yo(strArr2);
            }
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        throw new NullPointerException("namesAndValues == null");
    }

    public xj hf() {
        xj xjVar = new xj();
        Collections.addAll(xjVar.xj, this.xj);
        return xjVar;
    }
}
