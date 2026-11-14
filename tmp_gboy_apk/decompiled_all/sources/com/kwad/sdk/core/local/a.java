package com.kwad.sdk.core.local;

import android.content.Context;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.request.model.f;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a {
    private static volatile a aIL;
    public static ThreadLocal<SimpleDateFormat> aIM = new ThreadLocal<SimpleDateFormat>() { // from class: com.kwad.sdk.core.local.a.1
        private static SimpleDateFormat Jp() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }

        @Override // java.lang.ThreadLocal
        public final /* synthetic */ SimpleDateFormat initialValue() {
            return Jp();
        }
    };

    static {
        zGGy();
    }

    public static a Jk() {
        if (aIL == null) {
            synchronized (a.class) {
                try {
                    if (aIL == null) {
                        aIL = new a();
                    }
                } finally {
                }
            }
        }
        return aIL;
    }

    public static boolean Jl() {
        List<f> dO = dO(15);
        if (dO.size() == 0) {
            return true;
        }
        long j = -1;
        int i = 0;
        for (f fVar : dO) {
            i += fVar.count;
            long j2 = fVar.aNw;
            if (j2 > j) {
                j = j2;
            }
        }
        c.d("AdCounter", "onBind localCountCheck: allCount: " + i + ", lastShowTime: " + j);
        if (i > Jn()) {
            return false;
        }
        return (Jo() * 1000) + j <= System.currentTimeMillis();
    }

    public static List<f> Jm() {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return null;
        }
        String string = getString("ksadsdk_local_ad_task_info_adstyle_data");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(string);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                f fVar = new f();
                fVar.parseJson(jSONObject);
                arrayList.add(fVar);
            }
        } catch (Exception unused) {
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f fVar2 = (f) it.next();
            if (a(fVar2)) {
                arrayList2.add(fVar2);
            }
        }
        return arrayList2;
    }

    private static int Jn() {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return 30;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getInt("reward_aggregation_max_per_day", 30);
    }

    private static long Jo() {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return 1200L;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getLong("reward_aggregation_min_interval", 1200L);
    }

    private static void R(String str, String str2) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putString(str, str2).apply();
    }

    private static boolean a(f fVar) {
        long j = fVar.aNw;
        if (j <= 0) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = aIM.get();
        return simpleDateFormat.format(new Date(j)).equals(simpleDateFormat.format(new Date()));
    }

    public static void cl(AdTemplate adTemplate) {
        if (adTemplate.watched) {
            c.d("AdCounter", "startWatchAd this ad has been watched.");
        } else {
            cm(adTemplate);
        }
    }

    private static void cm(AdTemplate adTemplate) {
        List<f> list;
        int ez = e.ez(adTemplate);
        int el = e.el(adTemplate);
        List<f> Jm = Jm();
        if (Jm != null && Jm.size() != 0) {
            Iterator<f> it = Jm.iterator();
            while (true) {
                if (!it.hasNext()) {
                    Jm.add(new f(el, ez, 1, System.currentTimeMillis()));
                    list = Jm;
                    break;
                }
                f next = it.next();
                if (next.adStyle == el && next.taskType == ez) {
                    next.count++;
                    list = Jm;
                    if (!a(next)) {
                        next.count = 1;
                        next.aG(System.currentTimeMillis());
                        list = Jm;
                    }
                }
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new f(el, ez, 1, System.currentTimeMillis()));
            list = arrayList;
        }
        R("ksadsdk_local_ad_task_info_adstyle_data", aa.S(list).toString());
        adTemplate.watched = true;
    }

    private static List<f> dO(int i) {
        ArrayList arrayList = new ArrayList();
        List<f> Jm = Jm();
        if (Jm != null && Jm.size() != 0) {
            for (f fVar : Jm) {
                if (15 == fVar.adStyle) {
                    arrayList.add(fVar);
                }
            }
        }
        return arrayList;
    }

    public static void e(int i, long j) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putInt("reward_aggregation_max_per_day", i).putLong("reward_aggregation_min_interval", j).apply();
    }

    private static String getString(String str) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getString(str, null);
        } catch (Throwable th) {
            c.printStackTrace(th);
            return null;
        }
    }

    private static /* synthetic */ void zGGy() {
        char[] charArray = "\u0086\u008a\u0088Ë\u0082\u0084\u0088\u0080Ë\u0087\u008a\u009cË\u0096\u008d\u0080\u0089\u0089Ë¯\u008b\u008c§\u0097\u008c\u0081\u0082\u0080".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 229);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0086\u0089\u008c\u008b\u008c\u0091".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 229);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
