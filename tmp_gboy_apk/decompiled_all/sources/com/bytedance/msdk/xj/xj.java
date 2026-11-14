package com.bytedance.msdk.xj;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.bytedance.msdk.core.hf;
import com.bytedance.msdk.f.dk;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class xj {
    public static String xj(String str, String str2, String str3) {
        return (!TextUtils.isEmpty(str3) && (TextUtils.equals(str, "gdt") || TextUtils.equals(str, MediationConstant.ADN_PANGLE))) ? CtFAbx.AlLFFp(str2, "_", str3) : str2;
    }

    public static String xj(String str, String str2) {
        String[] split;
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        if (TextUtils.equals(str, MediationConstant.ADN_PANGLE)) {
            String[] split2 = str2.split("message:");
            if (split2 != null && split2.length > 0) {
                String str3 = split2[0];
                if (!TextUtils.isEmpty(str3) && (split = str3.trim().split(":")) != null && split.length >= 2) {
                    String str4 = split[1];
                    if (!TextUtils.isEmpty(str4)) {
                        return str4.trim();
                    }
                }
            }
            return "";
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        char[] charArray = str2.toCharArray();
        int i = 0;
        while (true) {
            if (i >= charArray.length) {
                break;
            }
            char c = charArray[i];
            if (c >= '0' && c <= '9') {
                sb.append(c);
                if (i == charArray.length - 1) {
                    arrayList.add(sb.toString());
                    break;
                }
            } else if (sb.length() > 0) {
                arrayList.add(sb.toString());
                sb.delete(0, sb.length());
            }
            if (arrayList.size() > 0) {
                return (String) arrayList.get(0);
            }
            i++;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb2.append((String) it.next());
            sb2.append("_");
        }
        if (sb2.length() > 0) {
            sb2.delete(sb2.length() - 1, sb2.length());
        }
        return sb2.toString();
    }

    public static boolean xj() {
        boolean w = dk.w(hf.getContext());
        boolean hf = dk.hf(hf.getContext());
        if (hf.hf().pl()) {
            return w || hf;
        }
        return false;
    }
}
