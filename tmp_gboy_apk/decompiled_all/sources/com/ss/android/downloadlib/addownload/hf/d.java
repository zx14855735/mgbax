package com.ss.android.downloadlib.addownload.hf;

import android.content.SharedPreferences;
import com.ss.android.downloadlib.addownload.pl;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d {

    public static class xj {
        private static d xj = new d();

        static {
            gmsmaeH();
        }

        private static /* synthetic */ void gmsmaeH() {
            char[] charArray = "\u000e\u0002\u0000C\n\f\u0000\bC\u000f\u0002\u0014C\u001e\u0005\b\u0001\u0001C'\u0003\u0004/\u001f\u0004\t\n\b".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'm');
            }
            String str = new String(charArray);
            char[] charArray2 = "\u000e\u0001\u0004\u0003\u0004\u0019".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'm');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences w() {
        return com.bytedance.sdk.openadsdk.ats.u.xj(pl.getContext(), "sp_ad_download_event", 0);
    }

    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.xj.hf> hf() {
        ConcurrentHashMap<Long, com.ss.android.downloadad.api.xj.hf> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, ?> all = w().getAll();
        if (all != null) {
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                if (entry.getValue() != null) {
                    try {
                        Long valueOf = Long.valueOf(entry.getKey());
                        long longValue = valueOf.longValue();
                        com.ss.android.downloadad.api.xj.hf hf = com.ss.android.downloadad.api.xj.hf.hf(new JSONObject(String.valueOf(entry.getValue())));
                        if (longValue > 0 && hf != null) {
                            concurrentHashMap.put(valueOf, hf);
                        }
                    } catch (Exception e) {
                        com.bytedance.sdk.component.utils.pl.xj(e);
                    }
                }
            }
        }
        return concurrentHashMap;
    }

    public static d xj() {
        return xj.xj;
    }

    public void xj(com.ss.android.downloadad.api.xj.hf hfVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(hfVar);
        xj((Collection<com.ss.android.downloadad.api.xj.hf>) arrayList);
    }

    public synchronized void xj(final Collection<com.ss.android.downloadad.api.xj.hf> collection) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                com.ss.android.downloadlib.kd.xj().xj(new Runnable() { // from class: com.ss.android.downloadlib.addownload.hf.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SharedPreferences.Editor edit = d.this.w().edit();
                        for (com.ss.android.downloadad.api.xj.hf hfVar : collection) {
                            if (hfVar != null && hfVar.hf() != 0) {
                                edit.putString(String.valueOf(hfVar.hf()), hfVar.ss().toString());
                            }
                        }
                        edit.apply();
                    }
                }, true);
            }
        }
    }

    public void xj(final List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.ss.android.downloadlib.kd.xj().xj(new Runnable() { // from class: com.ss.android.downloadlib.addownload.hf.d.2
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = d.this.w().edit();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    edit.remove((String) it.next());
                }
                edit.apply();
            }
        }, true);
    }
}
