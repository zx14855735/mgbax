package com.bytedance.sdk.openadsdk.core.qt;

import ADYaiT.CtFAbx;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.pz;
import com.kwad.components.core.s.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u implements Comparable<u> {
    private long am;
    private int c;
    private final String hf;
    private int kd;
    private int w;
    private final ArrayList<Long> xj = new ArrayList<>();
    private final ArrayList<Long> u = new ArrayList<>();
    private final ArrayList<Long> y = new ArrayList<>();
    private final ArrayList<Long> f = new ArrayList<>();
    private final HashMap<String, kd> d = new HashMap<>();
    private int tf = 0;
    private int p = 0;

    /* renamed from: pl, reason: collision with root package name */
    private final HashMap<String, kd> f10392pl = new HashMap<>();
    private int g = 0;

    public u(String str) {
        this.hf = str;
    }

    private void hf(JSONArray jSONArray) {
        int i;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        List<Integer> uj = pz.hf().uj();
        if (uj != null) {
            int i2 = 0;
            while (i2 < uj.size()) {
                int intValue = uj.get(i2).intValue();
                long j = elapsedRealtime - (intValue * 60000);
                Iterator<String> it = this.f10392pl.keySet().iterator();
                long j2 = 0;
                while (it.hasNext()) {
                    HashSet hashSet3 = hashSet;
                    HashSet hashSet4 = hashSet2;
                    kd kdVar = this.f10392pl.get(it.next());
                    if (kdVar != null) {
                        j2 += kdVar.xj(j, elapsedRealtime);
                    }
                    hashSet2 = hashSet4;
                    hashSet = hashSet3;
                }
                HashSet hashSet5 = hashSet;
                HashSet hashSet6 = hashSet2;
                if (j2 != 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(t.TAG, "lpstay_".concat(String.valueOf(intValue)));
                    jSONObject.put(com.kuaishou.weapon.p0.t.c, j2);
                    jSONArray.put(jSONObject);
                }
                i2++;
                hashSet2 = hashSet6;
                hashSet = hashSet5;
            }
        }
        HashSet hashSet7 = hashSet;
        HashSet hashSet8 = hashSet2;
        if (uj != null) {
            for (int i3 = 0; i3 < uj.size(); i3++) {
                int intValue2 = uj.get(i3).intValue();
                long j3 = elapsedRealtime - (intValue2 * 60000);
                Iterator<String> it2 = this.d.keySet().iterator();
                long j4 = 0;
                while (it2.hasNext()) {
                    kd kdVar2 = this.d.get(it2.next());
                    if (kdVar2 != null) {
                        i = intValue2;
                        StringBuilder B2KMhB2 = CtFAbx.B2KMhB("startTime is ", j3, " currentTime is ");
                        B2KMhB2.append(elapsedRealtime);
                        pl.xj("FeatureCalc", B2KMhB2.toString());
                        long xj = kdVar2.xj(j3, elapsedRealtime);
                        pl.xj("FeatureCalc", "duration is ".concat(String.valueOf(xj)));
                        j4 += xj;
                    } else {
                        i = intValue2;
                    }
                    intValue2 = i;
                }
                int i4 = intValue2;
                if (j4 != 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(t.TAG, "vstay_".concat(String.valueOf(i4)));
                    jSONObject2.put(com.kuaishou.weapon.p0.t.c, j4);
                    jSONArray.put(jSONObject2);
                }
                Iterator it3 = hashSet7.iterator();
                while (it3.hasNext()) {
                    this.f10392pl.remove((String) it3.next());
                }
                Iterator it4 = hashSet8.iterator();
                while (it4.hasNext()) {
                    this.d.remove((String) it4.next());
                }
            }
        }
        if (pz.hf().sv() && this.tf != 0) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(t.TAG, "vstay_0");
            jSONObject3.put(com.kuaishou.weapon.p0.t.c, this.tf);
            jSONArray.put(jSONObject3);
        }
        if (pz.hf().sv() && this.g != 0) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(t.TAG, "lpstay_0");
            jSONObject4.put(com.kuaishou.weapon.p0.t.c, this.g);
            jSONArray.put(jSONObject4);
        }
        if (this.p != 0) {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(t.TAG, "v30p");
            jSONObject5.put(com.kuaishou.weapon.p0.t.c, this.p);
            jSONArray.put(jSONObject5);
        }
    }

    public void xj(String str, String str2) {
        kd kdVar;
        kd kdVar2;
        kd kdVar3;
        kd kdVar4;
        kd kdVar5;
        kd kdVar6;
        str.getClass();
        switch (str) {
            case "landingContinue":
                if (!TextUtils.isEmpty(str2) && (kdVar = this.f10392pl.get(str2)) != null) {
                    kdVar.u(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingPause":
                if (!TextUtils.isEmpty(str2) && (kdVar2 = this.f10392pl.get(str2)) != null) {
                    kdVar2.w(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingStart":
                if (!TextUtils.isEmpty(str2)) {
                    kd kdVar7 = this.f10392pl.get(str2);
                    if (kdVar7 == null) {
                        kdVar7 = new kd();
                        this.f10392pl.put(str2, kdVar7);
                    }
                    kdVar7.xj(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "feed_over":
            case "feed_break":
                if (!TextUtils.isEmpty(str2) && (kdVar3 = this.d.get(str2)) != null && kdVar3.xj() != kd.kd) {
                    kdVar3.hf(SystemClock.elapsedRealtime());
                    if (pz.hf().sv()) {
                        this.tf = (int) (kdVar3.xj(this.am, SystemClock.elapsedRealtime()) + this.tf);
                        break;
                    }
                }
                break;
            case "show":
                this.xj.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (pz.hf().sv()) {
                    this.w++;
                    break;
                }
                break;
            case "click":
                this.u.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (pz.hf().sv()) {
                    this.kd++;
                    break;
                }
                break;
            case "feed_continue":
                if (!TextUtils.isEmpty(str2) && (kdVar4 = this.d.get(str2)) != null) {
                    kdVar4.u(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "feed_pause":
                if (!TextUtils.isEmpty(str2) && (kdVar5 = this.d.get(str2)) != null) {
                    kdVar5.w(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingFinish":
                if (!TextUtils.isEmpty(str2) && (kdVar6 = this.f10392pl.get(str2)) != null && kdVar6.xj() != kd.kd) {
                    kdVar6.hf(SystemClock.elapsedRealtime());
                    if (pz.hf().sv()) {
                        this.g = (int) (kdVar6.xj(this.am, SystemClock.elapsedRealtime()) + this.g);
                        break;
                    }
                }
                break;
            case "videoPercent30":
                if (pz.hf().sv()) {
                    this.p++;
                    break;
                }
                break;
            case "dislike":
                this.f.add(Long.valueOf(SystemClock.elapsedRealtime()));
                break;
            case "play_start":
                this.y.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (pz.hf().sv()) {
                    this.c++;
                }
                if (!TextUtils.isEmpty(str2)) {
                    kd kdVar8 = this.d.get(str2);
                    if (kdVar8 == null) {
                        kdVar8 = new kd();
                        this.d.put(str2, kdVar8);
                    }
                    kdVar8.xj(SystemClock.elapsedRealtime());
                    break;
                }
                break;
        }
    }

    public JSONArray xj() {
        JSONArray jSONArray = new JSONArray();
        try {
            xj(jSONArray);
            hf(jSONArray);
            return jSONArray;
        } catch (Throwable th) {
            pl.w(th.getMessage());
            return jSONArray;
        }
    }

    private void xj(String str, JSONArray jSONArray, ArrayList<Long> arrayList, List<Integer> list, long j) {
        int size = arrayList.size() - 1;
        Iterator<Integer> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            long j2 = j - (intValue * 60000);
            while (size >= 0 && arrayList.get(size).longValue() >= j2) {
                i++;
                size--;
            }
            if (i != 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(t.TAG, str + intValue);
                jSONObject.put(com.kuaishou.weapon.p0.t.c, i);
                jSONArray.put(jSONObject);
            }
        }
        while (size >= 0) {
            arrayList.remove(0);
            size--;
        }
    }

    public void hf() {
        this.am = SystemClock.elapsedRealtime();
        this.p = 0;
        this.kd = 0;
        this.w = 0;
        this.g = 0;
        this.tf = 0;
        this.c = 0;
    }

    private void xj(JSONArray jSONArray) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        xj("show_", jSONArray, this.xj, pz.hf().uj(), elapsedRealtime);
        xj("click_", jSONArray, this.u, pz.hf().uj(), elapsedRealtime);
        xj("play_", jSONArray, this.y, pz.hf().uj(), elapsedRealtime);
        xj("dis_", jSONArray, this.f, pz.hf().uj(), elapsedRealtime);
        if (pz.hf().sv() && this.w != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(t.TAG, "show_0");
            jSONObject.put(com.kuaishou.weapon.p0.t.c, this.w);
            jSONArray.put(jSONObject);
        }
        if (pz.hf().sv() && this.kd != 0) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(t.TAG, "click_0");
            jSONObject2.put(com.kuaishou.weapon.p0.t.c, this.kd);
            jSONArray.put(jSONObject2);
        }
        if (!pz.hf().sv() || this.c == 0) {
            return;
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(t.TAG, "play_0");
        jSONObject3.put(com.kuaishou.weapon.p0.t.c, this.c);
        jSONArray.put(jSONObject3);
    }

    @Override // java.lang.Comparable
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public int compareTo(u uVar) {
        return uVar.w - this.w;
    }
}
