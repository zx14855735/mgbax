package com.ss.android.downloadlib.addownload.xj;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.pl;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class hf {
    public void hf(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        com.bytedance.sdk.openadsdk.ats.u.xj(pl.getContext(), str, 0).edit().putString(str2, "").apply();
    }

    public CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.hf.xj> xj(String str, String str2) {
        CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.hf.xj> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String string = com.bytedance.sdk.openadsdk.ats.u.xj(pl.getContext(), str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    com.ss.android.downloadlib.addownload.hf.xj xj = com.ss.android.downloadlib.addownload.hf.xj.xj(jSONObject.optJSONObject(keys.next()));
                    if (xj != null) {
                        copyOnWriteArrayList.add(xj);
                    }
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        return copyOnWriteArrayList;
    }

    public void xj(String str, String str2, CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.hf.xj> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<com.ss.android.downloadlib.addownload.hf.xj> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.ss.android.downloadlib.addownload.hf.xj next = it.next();
                if (next != null) {
                    jSONObject.put(String.valueOf(next.hf), next.xj());
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        com.bytedance.sdk.openadsdk.ats.u.xj(pl.getContext(), str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }
}
