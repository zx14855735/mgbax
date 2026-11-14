package com.bytedance.sdk.openadsdk.core.ht;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.f.xj.xj;
import com.bytedance.sdk.openadsdk.core.pz;
import com.sigmob.sdk.base.common.a;
import io.dcloud.openapi.core.util.Const;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private static final Set<String> kd;
    public static final String xj = UUID.randomUUID().toString();
    public static AtomicInteger hf = new AtomicInteger(0);
    private static String u = "_create";
    public static final AtomicBoolean w = new AtomicBoolean(false);

    static {
        HashSet hashSet = new HashSet();
        kd = hashSet;
        hashSet.add("click_start");
        hashSet.add("download_start");
        hashSet.add(a.D);
        hashSet.add(a.F);
        hashSet.add("click");
        hashSet.add("show");
        vQWjFX();
    }

    private static void hf(Context context, boolean z) {
        if (context == null) {
            return;
        }
        int a2 = pz.hf().a();
        if (a2 <= 0 || a2 == Integer.MAX_VALUE) {
            a2 = 100;
        }
        int io2 = pz.hf().io();
        if (io2 > a2) {
            io2 = 5;
            a2 = 10;
        }
        com.bytedance.sdk.component.f.hf.xj.xj(new xj.C0111xj().w(com.bytedance.sdk.component.f.hf.u.hf.xj.xj(io2, a2)).xj(com.bytedance.sdk.component.f.hf.u.hf.xj.xj(1, a2)).hf(com.bytedance.sdk.component.f.hf.u.hf.xj.xj(1, a2)).hf(z).xj(Const.TYPE_CSJ).xj(context).xj(new d()).xj(f.xj).xj(pz.hf().q()).xj());
    }

    public static void u() {
        try {
            com.bytedance.sdk.component.f.hf.xj.hf(Const.TYPE_CSJ);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.u(u, e.getMessage());
        }
    }

    private static /* synthetic */ void vQWjFX() {
        char[] charArray = "ÍÁÃ\u0080ÉÏÃË\u0080ÌÁ×\u0080ÝÆËÂÂ\u0080äÀÇìÜÇÊÉË".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 174);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÍÂÇÀÇÚ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 174);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static com.bytedance.sdk.openadsdk.core.ht.w.xj w() {
        return g.xj;
    }

    public static void xj(Context context, boolean z) {
        if (w.compareAndSet(false, true) || com.bytedance.sdk.component.f.hf.xj.xj(Const.TYPE_CSJ)) {
            hf(context, z);
            com.bytedance.sdk.component.utils.f.xj().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ht.hf.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.component.f.hf.xj.u(Const.TYPE_CSJ);
                }
            }, com.bytedance.sdk.openadsdk.core.f.zg().c() ? 20000L : 30000L);
        }
    }

    public static void xj() {
        com.bytedance.sdk.component.f.hf.xj.xj(false, Const.TYPE_CSJ);
    }

    public static void xj(com.bytedance.sdk.component.f.hf.u.xj.xj xjVar, String str, int i) {
        if (com.bytedance.sdk.component.f.hf.xj.xj(Const.TYPE_CSJ)) {
            xj(pz.getContext(), com.bytedance.sdk.openadsdk.core.multipro.hf.w());
        }
        if (pz.hf().cu()) {
            return;
        }
        com.bytedance.sdk.component.f.hf.xj.xj(xjVar, Const.TYPE_CSJ);
    }

    private static void xj(String str, com.bytedance.sdk.component.f.hf.u.xj.xj xjVar) {
        if (pz.hf().jk()) {
            try {
                xjVar.w(com.bytedance.sdk.component.f.hf.w.xj.hf(str));
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.w(e.getMessage());
            }
        }
    }

    public static void xj(com.bytedance.sdk.openadsdk.core.am.xj xjVar, String str) {
        if (!pz.hf().cu() || kd.contains(str)) {
            com.bytedance.sdk.component.f.hf.u.xj.xj xjVar2 = new com.bytedance.sdk.component.f.hf.u.xj.xj(xjVar.u(), xjVar);
            xjVar2.hf(xjVar.y() ? (byte) 1 : (byte) 2);
            xjVar2.xj((byte) 0);
            xj(xjVar.w(), xjVar2);
            if (com.bytedance.sdk.component.f.hf.xj.xj(Const.TYPE_CSJ)) {
                xj(pz.getContext(), com.bytedance.sdk.openadsdk.core.multipro.hf.w());
            }
            com.bytedance.sdk.component.f.hf.xj.xj(xjVar2, Const.TYPE_CSJ);
        }
    }

    public static void hf() {
        com.bytedance.sdk.component.f.hf.xj.xj(f.xj, Const.TYPE_CSJ);
    }

    public static void xj(String str, List<String> list, boolean z, Map<String, String> map, JSONObject jSONObject) {
        if (list == null || list.size() == 0) {
            return;
        }
        list.size();
        if (com.bytedance.sdk.component.f.hf.xj.xj(Const.TYPE_CSJ)) {
            xj(pz.getContext(), com.bytedance.sdk.openadsdk.core.multipro.hf.w());
        }
        com.bytedance.sdk.component.f.hf.xj.xj(Const.TYPE_CSJ, str, xj(list, com.bytedance.sdk.openadsdk.core.a.tf.w(false)), z, map, jSONObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.Collection, java.util.List, java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.ArrayList] */
    public static List<String> xj(List<String> list, String str) {
        if (list != 0 && list.size() != 0 && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList((Collection) list);
            list = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                String str2 = (String) arrayList.get(i);
                if (!TextUtils.isEmpty(str2)) {
                    if (str2.contains("{OAID}") || str2.contains("__OAID__")) {
                        str2 = str2.replace("{OAID}", str).replace("__OAID__", str);
                    }
                    list.add(str2);
                }
            }
        }
        return list;
    }

    public static void xj(String str) {
        if (com.bytedance.sdk.component.f.hf.xj.xj(Const.TYPE_CSJ)) {
            xj(pz.getContext(), com.bytedance.sdk.openadsdk.core.multipro.hf.w());
        }
        com.bytedance.sdk.component.f.hf.xj.xj(Const.TYPE_CSJ, str);
    }
}
