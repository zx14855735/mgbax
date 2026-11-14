package com.bytedance.sdk.openadsdk.core.component.reward.kd;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.ra.c;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    public static String xj(String str) {
        if (!pl.w() || TextUtils.isEmpty(str)) {
            return str;
        }
        c cVar = new c(f.zg().x());
        StringBuilder sb = new StringBuilder(str);
        Iterator<String> it = cVar.hf().iterator();
        while (it.hasNext()) {
            if (sb.toString().contains(it.next())) {
                if (sb.toString().contains("?")) {
                    sb.append("&");
                    sb.append(cVar.xj());
                } else {
                    sb.append("?");
                    sb.append(cVar.xj());
                }
            }
        }
        return sb.toString();
    }
}
