package com.octopus.ad.utils.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.sdk.internal.bn;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.octopus.ad.internal.l;
import com.octopus.ad.internal.o;
import com.octopus.ad.internal.q;
import com.octopus.ad.internal.utilities.DeviceInfo;
import com.octopus.ad.internal.utilities.JsonUtil;
import com.octopus.ad.internal.utilities.SPUtils;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Context f12700a;

    public b(Context context) {
        this.f12700a = context;
    }

    private void b() {
        try {
            String a2 = a();
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(a2);
            boolean jSONBoolean = JsonUtil.getJSONBoolean(jSONObject, "canGetPkg");
            boolean jSONBoolean2 = JsonUtil.getJSONBoolean(jSONObject, "getLauncherPkg", true);
            boolean jSONBoolean3 = JsonUtil.getJSONBoolean(jSONObject, "getBootId", true);
            q.a().b = jSONBoolean3;
            SPUtils.put(this.f12700a, "getBootId", Boolean.valueOf(jSONBoolean3));
            q.a().f12512a = JsonUtil.getJSONInt(jSONObject, "filterLevel");
            SPUtils.put(this.f12700a, MediationConstant.EXTRA_DURATION, Long.valueOf(jSONObject.optLong(MediationConstant.EXTRA_DURATION)));
            SPUtils.put(this.f12700a, "version", jSONObject.optString("version"));
            boolean jSONBoolean4 = JsonUtil.getJSONBoolean(jSONObject, "ipv6");
            q.a().d = jSONBoolean4;
            SPUtils.put(this.f12700a, "ipv6", Boolean.valueOf(jSONBoolean4));
            boolean jSONBoolean5 = JsonUtil.getJSONBoolean(jSONObject, "ssl");
            q.a().c = jSONBoolean5;
            SPUtils.put(this.f12700a, "ssl", Boolean.valueOf(jSONBoolean5));
            String jSONString = JsonUtil.getJSONString(jSONObject, "domain");
            if (!TextUtils.isEmpty(jSONString)) {
                JSONObject jSONObject2 = new JSONObject(jSONString);
                String jSONString2 = JsonUtil.getJSONString(jSONObject2, bn.g);
                if (!TextUtils.isEmpty(jSONString2)) {
                    q.a().e = jSONString2;
                    SPUtils.put(this.f12700a, bn.g, jSONString2);
                }
                String jSONString3 = JsonUtil.getJSONString(jSONObject2, "sdklog");
                if (!TextUtils.isEmpty(jSONString3)) {
                    q.a().f = jSONString3;
                    SPUtils.put(this.f12700a, "sdklog", jSONString3);
                }
            }
            JSONArray jSONArray = new JSONArray(jSONObject.optString(PointParamKey.DATA));
            ArrayList arrayList = new ArrayList();
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                    String optString = jSONObject3.optString("sid");
                    String optString2 = jSONObject3.optString("pkg");
                    boolean a3 = i.a(optString2);
                    if (!a3 && jSONBoolean2) {
                        a3 = i.d(this.f12700a, optString2);
                    }
                    if (!a3 && jSONBoolean) {
                        a3 = i.c(this.f12700a, optString2);
                    }
                    if (a3) {
                        arrayList.add(optString);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                String replace = arrayList.toString().replace("[", "").replace("]", "");
                SPUtils.put(this.f12700a, "codeList", replace);
                DeviceInfo.getInstance().appList = replace;
            }
            o.a(new l("CFG", q.a().i(), 1));
        } catch (Exception e) {
            o.a(new l("CFG", q.a().i(), 0));
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public String a() {
        String str = (String) SPUtils.get(this.f12700a, "responseBody", "zyeyJkdXJhdGlvbiI6ODY0MDAsImluaXRTbyI6ZmFsc2UsImdldEJvb3RJZCI6dHJ1ZSwiZGF0YSI6W3sicGtnIjoiY29tLmJhaWR1LnNlYXJjaGJveCIsInNpZCI6IjMifSx7InBrZyI6ImNvbS5jdWJpYy5hdXRvaG9tZSIsInNpZCI6IjIifSx7InBrZyI6ImNvbS5qaW5nZG9uZy5hcHAubWFsbCIsInNpZCI6IjEifSx7InBrZyI6ImNvbS50YW9iYW8udGFvYmFvIiwic2lkIjoiNCJ9LHsicGtnIjoiY29tLmF1dG9uYXZpLm1pbmltYXAiLCJzaWQiOiI1In0seyJwa2ciOiJjb20uYWxpYmFiYS5hbmRyb2lkLnJpbWV0Iiwic2lkIjoiNiJ9LHsicGtnIjoiY29tLlVDTW9iaWxlIiwic2lkIjoiNyJ9LHsicGtnIjoiY29tLmVnLmFuZHJvaWQuQWxpcGF5R3Bob25lIiwic2lkIjoiOCJ9LHsicGtnIjoiY29tLnNhbmt1YWkubWVpdHVhbiIsInNpZCI6IjkifSx7InBrZyI6ImNvbS5zaW5hLndlaWJvIiwic2lkIjoiMTAifSx7InBrZyI6ImNvbS50YW9iYW8ubGl0ZXRhbyIsInNpZCI6IjExIn0seyJwa2ciOiJjb20udG1hbGwud2lyZWxlc3MiLCJzaWQiOiIxMiJ9LHsicGtnIjoiY29tLnRhb2Jhby5saXZlIiwic2lkIjoiMTMifSx7InBrZyI6ImNvbS56aGlodS5hbmRyb2lkIiwic2lkIjoiMTQifSx7InBrZyI6ImNvbS50ZW5jZW50LmthcmFva2UiLCJzaWQiOiIxNSJ9LHsicGtnIjoiY29tLnF1YXJrLmJyb3dzZXIiLCJzaWQiOiIxNiJ9LHsicGtnIjoiY29tLnNzLmFuZHJvaWQudWdjLmF3ZW1lIiwic2lkIjoiMTcifSx7InBrZyI6Im1lLmVsZSIsInNpZCI6IjE4In0seyJwa2ciOiJjb20uUXVuYXIiLCJzaWQiOiIxOSJ9LHsicGtnIjoiY29tLnh1bm1lbmcucGluZHVvZHVvIiwic2lkIjoiMjAifSx7InBrZyI6ImNvbS5zbWlsZS5naWZtYWtlciIsInNpZCI6IjIxIn0seyJwa2ciOiJjb20ua3VhaXNob3UubmVidWxhIiwic2lkIjoiMjIifSx7InBrZyI6ImNvbS5zZHUuZGlkaS5wc25nZXIiLCJzaWQiOiIyMyJ9LHsicGtnIjoiY29tLmRpZGFwaW5jaGUuYm9va2luZyIsInNpZCI6IjI0In0seyJwa2ciOiJhaXIudHYuZG91eXUuYW5kcm9pZCIsInNpZCI6IjI1In0seyJwa2ciOiJjb20ueGluZ2luLnhocyIsInNpZCI6IjI2In0seyJwa2ciOiJjb20uamQuanJhcHAiLCJzaWQiOiIyNyJ9LHsicGtnIjoiY29tLnlvdWt1LnBob25lIiwic2lkIjoiMjgifSx7InBrZyI6ImNvbS5vcHBvLnN0b3JlIiwic2lkIjoiMjkifSx7InBrZyI6ImNvbS5oZXl0YXAubWFya2V0Iiwic2lkIjoiMzAifSx7InBrZyI6ImNvbS5tZncucm9hZGJvb2siLCJzaWQiOiIzMSJ9LHsicGtnIjoiY29tLnNoaXpodWFuZy5kdWFwcCIsInNpZCI6IjMyIn0seyJwa2ciOiJjb20uYWNoaWV2by52aXBzaG9wIiwic2lkIjoiMzMifSx7InBrZyI6ImNvbS50YW91Lm1haW1haSIsInNpZCI6IjM0In0seyJwa2ciOiJjb20uc2Fua3VhaS5tZWl0dWFuLnRha2VvdXRuZXciLCJzaWQiOiIzNSJ9LHsicGtnIjoiY29tLnNzLmFuZHJvaWQudWdjLmF3ZW1lLmxpdGUiLCJzaWQiOiIzNiJ9LHsicGtnIjoiY29tLmFuanVrZS5hbmRyb2lkLmFwcCIsInNpZCI6IjM3In0seyJwa2ciOiJjb20uc3MuYW5kcm9pZC5hcnRpY2xlLm5ld3MiLCJzaWQiOiIzOCJ9LHsicGtnIjoiY29tLnRhb2Jhby5pZGxlZmlzaCIsInNpZCI6IjM5In0seyJwa2ciOiJjb20udWNtb2JpbGUubGl0ZSIsInNpZCI6IjQwIn0seyJwa2ciOiJjb20ueXVuY2VudGVjaG5vbG9neS5nb2Q0c29uZ3MiLCJzaWQiOiI0MSJ9LHsicGtnIjoiY29tLmZ6eWNpbmMuY2hhcmdpbmdlYXJudHJlYXN1cmUiLCJzaWQiOiI0MiJ9LHsicGtnIjoiY29tLnl1bmNlbnRlY2x0ZC5icm93c2luZ2hpZ2giLCJzaWQiOiI0MyJ9LHsicGtnIjoiY29tLm5uZGNpbmMuZ3Vlc3Npbmdzb25nbmFtZSIsInNpZCI6IjQ0In0seyJwa2ciOiJjb20uZ3JlZW5wb2ludC5hbmRyb2lkLm1jMTAwODYuYWN0aXZpdHkiLCJzaWQiOiI0NSJ9LHsicGtnIjoiY29tLnd1ZGFva291LmhpcHBvIiwic2lkIjoiNDYifSx7InBrZyI6ImNvbS5jYWluaWFvLndpcmVsZXNzIiwic2lkIjoiNDcifSx7InBrZyI6ImNvbS50YW9iYW8udHJscCIsInNpZCI6IjQ4In0seyJwa2ciOiJjb20ua2FvbGEiLCJzaWQiOiI0OSJ9LHsicGtnIjoiY29tLnRhb2Jhby5tb2JpbGUuZGlwZWwiLCJzaWQiOiI1MCJ9LHsicGtnIjoiY29tLnN1bmluZy5tb2JpbGUuZWJ1eSIsInNpZCI6IjUxIn0seyJwa2ciOiJjbi5hbWF6b24ubVNob3AuYW5kcm9pZCIsInNpZCI6IjUyIn0seyJwa2ciOiJjb20udGhlc3RvcmUubWFpbiIsInNpZCI6IjUzIn0seyJwa2ciOiJjb20uTW9iaWxlVGlja2V0Iiwic2lkIjoiNTQifSx7InBrZyI6ImNvbS5zaHVxaS5jb250cm9sbGVyIiwic2lkIjoiNTUifSx7InBrZyI6ImNvbS50YW9iYW8ubW9iaWxlLmRpcGVpIiwic2lkIjoiNTYifSx7InBrZyI6ImNvbS5xaXlpLnZpZGVvIiwic2lkIjoiNTcifSx7InBrZyI6ImN0cmlwLmFuZHJvaWQudmlldyIsInNpZCI6IjU4In0seyJwa2ciOiJjb20ubmV0ZWFzZS5jbG91ZG11c2ljIiwic2lkIjoiNTkifSx7InBrZyI6ImNvbS50aWFueWFuY2hhLnNreWV5ZSIsInNpZCI6IjYwIn0seyJwa2ciOiJjb20ua214cy5yZWFkZXIiLCJzaWQiOiI2MSJ9LHsicGtnIjoiY29tLnRhb2Jhby50cmlwIiwic2lkIjoiNjIifSx7InBrZyI6ImNvbS5hbGliYWJhLndpcmVsZXNzLmxzdHJldGFpbGVyIiwic2lkIjoiNjMifSx7InBrZyI6ImNvbS5tbWJhbmcubmVpZ2hib3Job29kIiwic2lkIjoiNjQifSx7InBrZyI6ImNvbS55YXlhLnpvbmUiLCJzaWQiOiI2NSJ9LHsicGtnIjoiY29tLmFsaWJhYmEud2lyZWxlc3MiLCJzaWQiOiI2NiJ9LHsicGtnIjoiY29tLmF1dG9uYXZpLm1pbmltYXAuY3VzdG9tIiwic2lkIjoiNjcifSx7InBrZyI6ImNvbS5rd2FpLnRoYW5vcyIsInNpZCI6IjY4In0seyJwa2ciOiJjb20ubGlhbmppYS5iZWlrZSIsInNpZCI6IjY5In0seyJwa2ciOiJjb20uYmFua2NvbW0uQmFua2NvbW0iLCJzaWQiOiI4MiJ9LHsicGtnIjoiY29tLnRhb2Jhby5ldGFvIiwic2lkIjoiODMifSx7InBrZyI6ImNvbS5kdW93YW4ubW9iaWxlIiwic2lkIjoiODQifSx7InBrZyI6ImNvbS5uZXRlYXNlLnlhbnh1YW4iLCJzaWQiOiI4NSJ9XSwiY2FuR2V0UGtnIjpmYWxzZSwiaXB2NiI6ZmFsc2UsImRvbWFpbiI6IntcInNka2xvZ1wiOlwiaHR0cDovL3Nka2xvZy56aGFuZ3l1eWlkb25nLmNuXCIsXCJzZGtcIjpcImh0dHA6Ly9zZGsuemhhbmd5dXlpZG9uZy5jblwifSIsInZlcnNpb24iOiIxNzQ1NTYxNDg2MzkwIiwic3NsIjpmYWxzZSwiZmlsdGVyTGV2ZWwiOjB9");
        return str != null ? new String(Base64.decode(str.substring(2), 0)) : "";
    }

    @Override // java.lang.Runnable
    public void run() {
        b();
    }
}
