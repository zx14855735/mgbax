package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.views.r;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaeo;
import io.dcloud.openapi.core.adapter.IAdAdapter;
import io.dcloud.openapi.core.module.DCBaseAOL;
import java.io.File;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaaa {

    public static class aaaaaaa0 {
        private double aaaaaaa0;
        private double aaaaaaaa;
        private String aaaaaaao;

        public String aaaaaaaa() {
            return this.aaaaaaao;
        }

        public void aaaaaaaa(double d, double d2, String str) {
            this.aaaaaaaa = d;
            this.aaaaaaa0 = d2;
            this.aaaaaaao = str;
        }

        public boolean aaaaaaaa(double d) {
            return d >= this.aaaaaaaa && d < this.aaaaaaa0;
        }
    }

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa$aaaaaaaa, reason: collision with other inner class name */
    public static class C0540aaaaaaaa {
        public int aaaaaaa0;
        public boolean aaaaaaaa = true;
        public List aaaaaaac;
        public int aaaaaaao;
    }

    public static void aaaaaaa0(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        aaaaaaaa(context, Boolean.valueOf(Integer.parseInt(str) == 1));
    }

    private static void aaaaaaaa(Context context, Boolean bool) {
        try {
            aaaaaaeo.aaaaaaaa((bool.booleanValue() ? "1" : Constants.FAIL).getBytes(), 0, CtFAbx.AcNBzu(aaaaaaau(context).replaceAll("/ad/", "/"), "AdEnable.dat"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean aaaaaaac(Context context) {
        try {
            String aaaaaaan = aaaaaaan(context);
            return aaaaaaan == null ? aaaaaaa0(context).booleanValue() : "1".equals(aaaaaaan.replaceAll("\n", ""));
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static String aaaaaaan(Context context) {
        String AcNBzu2 = CtFAbx.AcNBzu(aaaaaaau(context).replaceAll("/ad/", "/"), "AdEnable.dat");
        try {
            if (aaaaaaeo.aaaaaaaa(AcNBzu2)) {
                return new String(aaaaaaeo.aaaaaaau(AcNBzu2));
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String aaaaaaao(Context context) {
        return io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaau.aaaaaaaa(context, "_s_c_a_r", "servertime");
    }

    private static String aaaaaaau(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            return "/sdcard/Android/data/" + context.getPackageName() + "/cache/ad/";
        }
        return externalCacheDir.getAbsolutePath() + "/ad/";
    }

    private static Boolean aaaaaaa0(Context context) {
        try {
            return Boolean.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), r.b.d).metaData.getBoolean("DCLOUD_AD_SPLASH", false));
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    public static String aaaaaaa0(DCBaseAOL dCBaseAOL) {
        IAdAdapter aaaaaaa02;
        if (!dCBaseAOL.aaaaoaaa() || (aaaaaaa02 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aacaaaaa.aaaaaaaa.aaaaaaa0().aaaaaaa0(dCBaseAOL.getType())) == null) {
            return null;
        }
        return aaaaaaa02.getSDKVersion();
    }

    public static void aaaaaaaa(Context context, String str, String str2) {
        JSONObject jSONObject;
        String aaaaaaaa = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaau.aaaaaaaa(context, "_s_c_a_r", str);
        try {
            if (TextUtils.isEmpty(aaaaaaaa)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(aaaaaaaa);
            }
            if (jSONObject.has(str2)) {
                jSONObject.put(str2, jSONObject.optInt(str2) + 1);
            } else {
                jSONObject.put(str2, 1);
            }
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaau.aaaaaaaa(context, "_s_c_a_r", str, jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    public static void aaaaaaaa(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("_s_c_a_r", 0).edit();
        edit.clear();
        edit.apply();
    }

    public static void aaaaaaaa(Context context, String str) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaau.aaaaaaaa(context, "_s_c_a_r", "servertime", str);
    }

    public static boolean aaaaaaaa(long j, long j2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(j);
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTimeInMillis(j2);
        return gregorianCalendar.get(1) == gregorianCalendar2.get(1) && gregorianCalendar.get(2) == gregorianCalendar2.get(2) && gregorianCalendar.get(5) == gregorianCalendar2.get(5);
    }

    public static List aaaaaaaa(Context context, List list, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3;
        String str2;
        int i;
        aaaaaaau.aaaaaaaa(String.valueOf(str) + "---STA---" + list.toString());
        if (jSONObject != null && jSONObject.length() > 0 && list.size() > 1) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!list.contains(next)) {
                    keys.remove();
                } else if (jSONObject.optInt(next) <= 0) {
                    keys.remove();
                }
            }
            ArrayList arrayList = new ArrayList(aaaaaaaa(jSONObject));
            if (list.size() != arrayList.size()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String str3 = (String) it.next();
                    if (!arrayList.contains(str3)) {
                        arrayList.add(str3);
                    }
                }
            }
            list = arrayList;
        }
        aaaaaaau.aaaaaaaa(String.valueOf(str) + "---PRE---" + list.toString());
        if (jSONObject2 != null && jSONObject2.length() > 0 && list.size() > 1) {
            try {
                jSONObject3 = new JSONObject(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaau.aaaaaaaa(context, "_s_c_a_r", str));
            } catch (Exception unused) {
                jSONObject3 = null;
            }
            boolean z = true;
            int i2 = 0;
            while (jSONObject3 != null && z && i2 < list.size()) {
                i2++;
                JSONArray optJSONArray = jSONObject2.optJSONArray((String) list.get(0));
                if (optJSONArray != null && optJSONArray.length() > 1) {
                    str2 = optJSONArray.optString(0);
                    i = optJSONArray.optInt(1);
                } else {
                    str2 = "";
                    i = 0;
                }
                if (i > jSONObject3.optInt(str2) || i == 0) {
                    z = false;
                } else {
                    list.add((String) list.remove(0));
                }
            }
        }
        aaaaaaau.aaaaaaaa(String.valueOf(str) + "---AFT---" + list.toString());
        return list;
    }

    private static List aaaaaaaa(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && jSONObject.length() != 0) {
            if (jSONObject.length() == 1) {
                arrayList.add(jSONObject.keys().next());
                return arrayList;
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < jSONObject.length(); i++) {
                arrayList2.add(new aaaaaaa0());
            }
            while (arrayList2.size() > 1) {
                aaaaaaa0 aaaaaaaa = aaaaaaaa(arrayList2, aaaaaaaa(jSONObject, arrayList2));
                if (aaaaaaaa != null) {
                    jSONObject.remove(aaaaaaaa.aaaaaaaa());
                    arrayList2.remove(aaaaaaaa);
                    arrayList.add(aaaaaaaa.aaaaaaaa());
                }
            }
            arrayList.add(((aaaaaaa0) arrayList2.get(0)).aaaaaaaa());
        }
        return arrayList;
    }

    private static int aaaaaaaa(JSONObject jSONObject, ArrayList arrayList) {
        Iterator<String> keys = jSONObject.keys();
        int i = 0;
        int i2 = 0;
        while (keys.hasNext()) {
            String next = keys.next();
            double d = i;
            i += jSONObject.optInt(next);
            ((aaaaaaa0) arrayList.get(i2)).aaaaaaaa(d, i, next);
            i2++;
        }
        return i;
    }

    private static aaaaaaa0 aaaaaaaa(ArrayList arrayList, int i) {
        double random = Math.random() * i;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            aaaaaaa0 aaaaaaa0Var = (aaaaaaa0) obj;
            if (aaaaaaa0Var.aaaaaaaa(random)) {
                return aaaaaaa0Var;
            }
        }
        return null;
    }

    public static void aaaaaaaa(List list) {
        if (list.size() > 1) {
            for (int i = 0; i < list.size() - 1; i++) {
                int i2 = 0;
                while (i2 < (list.size() - i) - 1) {
                    int i3 = i2 + 1;
                    if (((DCBaseAOL) list.get(i3)).aeaaaaaa() > ((DCBaseAOL) list.get(i2)).aeaaaaaa()) {
                        DCBaseAOL dCBaseAOL = (DCBaseAOL) list.get(i2);
                        list.set(i2, (DCBaseAOL) list.get(i3));
                        list.set(i3, dCBaseAOL);
                    }
                    i2 = i3;
                }
            }
        }
    }

    public static C0540aaaaaaaa aaaaaaaa(int i, List... listArr) {
        int aeaaaaaa;
        int i2;
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (List list : listArr) {
            arrayList.addAll(list);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        aaaaaaaa(arrayList);
        ArrayList arrayList2 = new ArrayList();
        if (arrayList.size() > i) {
            arrayList2.addAll(arrayList.subList(0, i));
            List<DCBaseAOL> subList = arrayList.subList(i, arrayList.size());
            aeaaaaaa = ((DCBaseAOL) arrayList2.get(0)).aeaaaaaa();
            i2 = ((DCBaseAOL) subList.get(0)).aeaaaaaa();
            for (DCBaseAOL dCBaseAOL : subList) {
                if (dCBaseAOL.isSlotSupportBidding()) {
                    dCBaseAOL.biddingFail(aeaaaaaa, i2, 2);
                }
            }
        } else {
            arrayList2.addAll(arrayList);
            aeaaaaaa = ((DCBaseAOL) arrayList2.get(0)).aeaaaaaa();
            i2 = 0;
        }
        int size = arrayList2.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                z = true;
                break;
            }
            Object obj = arrayList2.get(i3);
            i3++;
            if (!((DCBaseAOL) obj).isSlotSupportBidding()) {
                break;
            }
        }
        C0540aaaaaaaa c0540aaaaaaaa = new C0540aaaaaaaa();
        c0540aaaaaaaa.aaaaaaaa = z;
        c0540aaaaaaaa.aaaaaaa0 = aeaaaaaa;
        c0540aaaaaaaa.aaaaaaao = i2;
        c0540aaaaaaaa.aaaaaaac = arrayList2;
        return c0540aaaaaaaa;
    }

    public static String aaaaaaaa(DCBaseAOL dCBaseAOL) {
        IAdAdapter aaaaaaa02;
        if (!dCBaseAOL.aaaaoaaa() || (aaaaaaa02 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aacaaaaa.aaaaaaaa.aaaaaaa0().aaaaaaa0(dCBaseAOL.getType())) == null) {
            return null;
        }
        return aaaaaaa02.getAdapterSDKVersion();
    }
}
