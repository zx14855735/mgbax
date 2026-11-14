package com.kuaishou.weapon.p0;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kuaishou.weapon.p0.p;
import io.dcloud.openapi.core.util.Const;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class o {
    public static s a(JSONObject jSONObject) {
        p b = b(jSONObject);
        if (b == null) {
            return null;
        }
        int a2 = b.a();
        String l = b.l();
        String j = b.j();
        boolean z = b.d() == 1;
        boolean z2 = b.h() == 1;
        int e = b.e();
        String c = b.c();
        String f = b.f();
        String b2 = b.b();
        PackageInfo packageInfo = new PackageInfo();
        try {
            packageInfo.packageName = f;
            packageInfo.versionName = l;
            ApplicationInfo applicationInfo = new ApplicationInfo();
            if (!TextUtils.isEmpty(f) && !TextUtils.isEmpty(b2) && b2.startsWith(".")) {
                applicationInfo.name = f + b2;
                applicationInfo.className = f + b2;
            }
            applicationInfo.theme = b.i();
            packageInfo.applicationInfo = applicationInfo;
            List<p.a> m = b.m();
            if (m != null && m.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < m.size(); i++) {
                    ActivityInfo activityInfo = new ActivityInfo();
                    activityInfo.name = m.get(i).c();
                    activityInfo.theme = m.get(i).b();
                    activityInfo.labelRes = m.get(i).a();
                    if (!TextUtils.isEmpty(activityInfo.name)) {
                        arrayList.add(activityInfo);
                    }
                }
                if (arrayList.size() > 0) {
                    packageInfo.activities = (ActivityInfo[]) arrayList.toArray(new ActivityInfo[arrayList.size()]);
                }
            }
        } catch (Throwable unused) {
        }
        s sVar = new s(packageInfo, a2, f, l, j, c);
        sVar.v = z;
        sVar.x = e;
        int a3 = b.k() == null ? 0 : b.k().a();
        int b3 = b.k() == null ? -1 : b.k().b();
        sVar.t = a3;
        sVar.u = b3;
        sVar.s = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT > 29 && z2) {
            z2 = b.g() == 1;
        }
        sVar.y = z2;
        return sVar;
    }

    private static p b(JSONObject jSONObject) {
        try {
            p pVar = new p();
            pVar.a(jSONObject.optInt("wk"));
            pVar.a(jSONObject.optString("wan"));
            pVar.b(jSONObject.optString(Const.TYPE_WM));
            pVar.b(jSONObject.optInt("wo"));
            pVar.c(jSONObject.optInt("wpr"));
            pVar.c(jSONObject.optString(bi.q));
            pVar.e(jSONObject.optInt("ws", 1));
            pVar.d(jSONObject.optInt("wh", 0));
            pVar.f(jSONObject.optInt("wt"));
            pVar.d(jSONObject.optString("wu"));
            pVar.e(jSONObject.optString("wv"));
            JSONArray jSONArray = jSONObject.getJSONArray("wa");
            ArrayList arrayList = null;
            for (int i = 0; i < jSONArray.length(); i++) {
                p.a aVar = new p.a();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                aVar.a(jSONObject2.optInt(t.k));
                aVar.b(jSONObject2.optInt(com.kwad.components.core.s.t.TAG));
                aVar.a(jSONObject2.getString("n"));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(aVar);
            }
            pVar.a(arrayList);
            p.b bVar = new p.b();
            JSONObject jSONObject3 = jSONObject.getJSONObject("we");
            bVar.a(jSONObject3.optInt(MediationConstant.EXTRA_DURATION));
            bVar.b(jSONObject3.optInt("network"));
            pVar.a(bVar);
            return pVar;
        } catch (Exception unused) {
            return null;
        }
    }
}
