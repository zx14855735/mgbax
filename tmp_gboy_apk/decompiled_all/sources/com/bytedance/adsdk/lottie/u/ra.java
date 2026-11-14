package com.bytedance.adsdk.lottie.u;

import android.graphics.Rect;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bytedance.adsdk.lottie.d;
import com.bytedance.adsdk.lottie.model.layer.f;
import com.bytedance.adsdk.lottie.y;
import com.kuaishou.weapon.p0.t;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.qq.e.comm.adevent.AdEventType;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ra {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0058 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0042 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void hf(android.util.JsonReader r5, com.bytedance.adsdk.lottie.y.hf r6) {
        /*
            r5.beginObject()     // Catch: java.io.IOException -> L63
        L3:
            boolean r0 = r5.hasNext()     // Catch: java.io.IOException -> L63
            if (r0 == 0) goto L5f
            java.lang.String r0 = r5.nextName()     // Catch: java.io.IOException -> L63
            int r1 = r0.hashCode()     // Catch: java.io.IOException -> L63
            r2 = 3239(0xca7, float:4.539E-42)
            r3 = 1
            r4 = 2
            if (r1 == r2) goto L35
            r2 = 3276(0xccc, float:4.59E-42)
            if (r1 == r2) goto L2b
            r2 = 107027(0x1a213, float:1.49977E-40)
            if (r1 == r2) goto L21
            goto L3f
        L21:
            java.lang.String r1 = "lel"
            boolean r0 = r0.equals(r1)     // Catch: java.io.IOException -> L63
            if (r0 == 0) goto L3f
            r0 = 2
            goto L40
        L2b:
            java.lang.String r1 = "fr"
            boolean r0 = r0.equals(r1)     // Catch: java.io.IOException -> L63
            if (r0 == 0) goto L3f
            r0 = 0
            goto L40
        L35:
            java.lang.String r1 = "el"
            boolean r0 = r0.equals(r1)     // Catch: java.io.IOException -> L63
            if (r0 == 0) goto L3f
            r0 = 1
            goto L40
        L3f:
            r0 = -1
        L40:
            if (r0 == 0) goto L58
            if (r0 == r3) goto L51
            if (r0 == r4) goto L4a
            r5.skipValue()     // Catch: java.io.IOException -> L63
            goto L3
        L4a:
            org.json.JSONArray r0 = u(r5)     // Catch: java.io.IOException -> L63
            r6.c = r0     // Catch: java.io.IOException -> L63
            goto L3
        L51:
            java.lang.String r0 = r5.nextString()     // Catch: java.io.IOException -> L63
            r6.y = r0     // Catch: java.io.IOException -> L63
            goto L3
        L58:
            int r0 = r5.nextInt()     // Catch: java.io.IOException -> L63
            r6.kd = r0     // Catch: java.io.IOException -> L63
            goto L3
        L5f:
            r5.endObject()     // Catch: java.io.IOException -> L63
            return
        L63:
            r5 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.u.ra.hf(android.util.JsonReader, com.bytedance.adsdk.lottie.y$hf):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ec A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00df A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.List<com.bytedance.adsdk.lottie.d.hf> kd(android.util.JsonReader r9) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.u.ra.kd(android.util.JsonReader):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static org.json.JSONArray u(android.util.JsonReader r8) {
        /*
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            r8.beginArray()     // Catch: java.lang.Exception -> L3e
        L8:
            boolean r1 = r8.hasNext()     // Catch: java.lang.Exception -> L3e
            if (r1 == 0) goto L6f
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L3e
            r1.<init>()     // Catch: java.lang.Exception -> L3e
            r0.put(r1)     // Catch: java.lang.Exception -> L3e
            r8.beginObject()     // Catch: java.lang.Exception -> L3e
        L19:
            boolean r2 = r8.hasNext()     // Catch: java.lang.Exception -> L3e
            if (r2 == 0) goto L6b
            java.lang.String r2 = r8.nextName()     // Catch: java.lang.Exception -> L3e
            int r3 = r2.hashCode()     // Catch: java.lang.Exception -> L3e
            r4 = 3324(0xcfc, float:4.658E-42)
            r5 = 1
            java.lang.String r6 = "hd"
            java.lang.String r7 = "vid"
            if (r3 == r4) goto L40
            r4 = 116753(0x1c811, float:1.63606E-40)
            if (r3 == r4) goto L36
            goto L48
        L36:
            boolean r2 = r2.equals(r7)     // Catch: java.lang.Exception -> L3e
            if (r2 == 0) goto L48
            r2 = 0
            goto L49
        L3e:
            r8 = move-exception
            goto L73
        L40:
            boolean r2 = r2.equals(r6)     // Catch: java.lang.Exception -> L3e
            if (r2 == 0) goto L48
            r2 = 1
            goto L49
        L48:
            r2 = -1
        L49:
            if (r2 == 0) goto L5e
            if (r2 == r5) goto L51
            r8.skipValue()     // Catch: java.lang.Exception -> L3e
            goto L19
        L51:
            int r2 = r8.nextInt()     // Catch: java.lang.Exception -> L3e org.json.JSONException -> L59
            r1.put(r6, r2)     // Catch: java.lang.Exception -> L3e org.json.JSONException -> L59
            goto L19
        L59:
            r2 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r2)     // Catch: java.lang.Exception -> L3e
            goto L19
        L5e:
            java.lang.String r2 = r8.nextString()     // Catch: java.lang.Exception -> L3e org.json.JSONException -> L66
            r1.put(r7, r2)     // Catch: java.lang.Exception -> L3e org.json.JSONException -> L66
            goto L19
        L66:
            r2 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r2)     // Catch: java.lang.Exception -> L3e
            goto L19
        L6b:
            r8.endObject()     // Catch: java.lang.Exception -> L3e
            goto L8
        L6f:
            r8.endArray()     // Catch: java.lang.Exception -> L3e
            goto L76
        L73:
            com.bytedance.sdk.component.utils.pl.xj(r8)
        L76:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.u.ra.u(android.util.JsonReader):org.json.JSONArray");
    }

    private static String[] w(JsonReader jsonReader) {
        String[] strArr = null;
        try {
            jsonReader.beginArray();
            strArr = new String[3];
            for (int i = 0; i < 3; i++) {
                if (jsonReader.hasNext()) {
                    strArr[i] = jsonReader.nextString();
                }
            }
            jsonReader.endArray();
            return strArr;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return strArr;
        }
    }

    public static com.bytedance.adsdk.lottie.y xj(JsonReader jsonReader) {
        int i;
        y.u uVar;
        float xj = com.bytedance.adsdk.lottie.kd.d.xj();
        LongSparseArray<com.bytedance.adsdk.lottie.model.layer.f> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        SparseArray<com.bytedance.adsdk.lottie.model.u> sparseArray = new SparseArray<>();
        y.u uVar2 = new y.u();
        y.hf hfVar = new y.hf();
        y.w wVar = new y.w();
        y.xj xjVar = new y.xj();
        com.bytedance.adsdk.lottie.y yVar = new com.bytedance.adsdk.lottie.y();
        jsonReader.beginObject();
        float f = 0.0f;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (jsonReader.hasNext()) {
            float f4 = xj;
            String nextName = jsonReader.nextName();
            nextName.getClass();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1408207997:
                    i = i2;
                    if (nextName.equals("assets")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1109732030:
                    i = i2;
                    if (nextName.equals("layers")) {
                        c = 1;
                        break;
                    }
                    break;
                case -865448777:
                    i = i2;
                    if (nextName.equals("globalEvent")) {
                        c = 2;
                        break;
                    }
                    break;
                case 104:
                    i = i2;
                    if (nextName.equals("h")) {
                        c = 3;
                        break;
                    }
                    break;
                case TTVideoEngine.PLAYER_BUFFERING_DATA_OF_MILLISECONDS /* 118 */:
                    i = i2;
                    if (nextName.equals(t.c)) {
                        c = 4;
                        break;
                    }
                    break;
                case 119:
                    i = i2;
                    if (nextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
                        c = 5;
                        break;
                    }
                    break;
                case 3208:
                    i = i2;
                    if (nextName.equals("dl")) {
                        c = 6;
                        break;
                    }
                    break;
                case 3276:
                    i = i2;
                    if (nextName.equals("fr")) {
                        c = 7;
                        break;
                    }
                    break;
                case 3292:
                    i = i2;
                    if (nextName.equals("gc")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 3367:
                    i = i2;
                    if (nextName.equals("ip")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 3553:
                    i = i2;
                    if (nextName.equals("op")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 3002509:
                    i = i2;
                    if (nextName.equals("area")) {
                        c = 11;
                        break;
                    }
                    break;
                case 94623709:
                    i = i2;
                    if (nextName.equals("chars")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 97615364:
                    i = i2;
                    if (nextName.equals("fonts")) {
                        c = '\r';
                        break;
                    }
                    break;
                case 110364485:
                    i = i2;
                    if (nextName.equals("timer")) {
                        c = 14;
                        break;
                    }
                    break;
                case 839250809:
                    i = i2;
                    if (nextName.equals("markers")) {
                        c = 15;
                        break;
                    }
                    break;
                default:
                    i = i2;
                    break;
            }
            switch (c) {
                case 0:
                    uVar = uVar2;
                    xj(jsonReader, yVar, hashMap, hashMap2);
                    uVar2 = uVar;
                    xj = f4;
                    i2 = i;
                    break;
                case 1:
                    uVar = uVar2;
                    xj(jsonReader, yVar, arrayList, longSparseArray);
                    uVar2 = uVar;
                    xj = f4;
                    i2 = i;
                    break;
                case 2:
                    uVar = uVar2;
                    xj(jsonReader, wVar);
                    uVar2 = uVar;
                    xj = f4;
                    i2 = i;
                    break;
                case 3:
                    i2 = jsonReader.nextInt();
                    xj = f4;
                    break;
                case 4:
                    uVar = uVar2;
                    String[] split = jsonReader.nextString().split("\\.");
                    if (!com.bytedance.adsdk.lottie.kd.d.xj(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        yVar.xj("Lottie only supports bodymovin >= 4.4.0");
                    }
                    uVar2 = uVar;
                    xj = f4;
                    i2 = i;
                    break;
                case 5:
                    i3 = jsonReader.nextInt();
                    xj = f4;
                    i2 = i;
                    break;
                case 6:
                    str = jsonReader.nextString();
                    xj = f4;
                    i2 = i;
                    break;
                case 7:
                    uVar2 = uVar2;
                    f3 = (float) jsonReader.nextDouble();
                    xj = f4;
                    i2 = i;
                    break;
                case '\b':
                    uVar = uVar2;
                    xj(jsonReader, hfVar);
                    uVar2 = uVar;
                    xj = f4;
                    i2 = i;
                    break;
                case '\t':
                    uVar2 = uVar2;
                    f = (float) jsonReader.nextDouble();
                    xj = f4;
                    i2 = i;
                    break;
                case '\n':
                    uVar = uVar2;
                    f2 = ((float) jsonReader.nextDouble()) - 0.01f;
                    uVar2 = uVar;
                    xj = f4;
                    i2 = i;
                    break;
                case 11:
                    xj(jsonReader, xjVar);
                    uVar = uVar2;
                    uVar2 = uVar;
                    xj = f4;
                    i2 = i;
                    break;
                case '\f':
                    xj(jsonReader, yVar, sparseArray);
                    uVar = uVar2;
                    uVar2 = uVar;
                    xj = f4;
                    i2 = i;
                    break;
                case '\r':
                    xj(jsonReader, hashMap3);
                    uVar = uVar2;
                    uVar2 = uVar;
                    xj = f4;
                    i2 = i;
                    break;
                case 14:
                    xj(jsonReader, uVar2);
                    uVar = uVar2;
                    uVar2 = uVar;
                    xj = f4;
                    i2 = i;
                    break;
                case 15:
                    xj(jsonReader, arrayList2);
                    uVar = uVar2;
                    uVar2 = uVar;
                    xj = f4;
                    i2 = i;
                    break;
                default:
                    jsonReader.skipValue();
                    uVar = uVar2;
                    uVar2 = uVar;
                    xj = f4;
                    i2 = i;
                    break;
            }
        }
        float f5 = xj;
        jsonReader.endObject();
        yVar.xj(new Rect(0, 0, (int) (i3 * f5), (int) (i2 * f5)), f, f2, f3, arrayList, longSparseArray, hashMap, hashMap2, sparseArray, hashMap3, arrayList2, uVar2, str, hfVar, wVar, xjVar);
        return yVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.bytedance.adsdk.lottie.d.hf.xj y(android.util.JsonReader r5) {
        /*
            com.bytedance.adsdk.lottie.d$hf$xj r0 = new com.bytedance.adsdk.lottie.d$hf$xj     // Catch: java.lang.Exception -> L4f
            r0.<init>()     // Catch: java.lang.Exception -> L4f
            r5.beginObject()     // Catch: java.lang.Exception -> L4f
        L8:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Exception -> L4f
            if (r1 == 0) goto L4b
            java.lang.String r1 = r5.nextName()     // Catch: java.lang.Exception -> L4f
            int r2 = r1.hashCode()     // Catch: java.lang.Exception -> L4f
            r3 = 99
            r4 = 1
            if (r2 == r3) goto L2a
            r3 = 3706(0xe7a, float:5.193E-42)
            if (r2 == r3) goto L20
            goto L34
        L20:
            java.lang.String r2 = "tn"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Exception -> L4f
            if (r1 == 0) goto L34
            r1 = 0
            goto L35
        L2a:
            java.lang.String r2 = "c"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Exception -> L4f
            if (r1 == 0) goto L34
            r1 = 1
            goto L35
        L34:
            r1 = -1
        L35:
            if (r1 == 0) goto L44
            if (r1 == r4) goto L3d
            r5.skipValue()     // Catch: java.lang.Exception -> L4f
            goto L8
        L3d:
            java.lang.String r1 = r5.nextString()     // Catch: java.lang.Exception -> L4f
            r0.hf = r1     // Catch: java.lang.Exception -> L4f
            goto L8
        L44:
            int r1 = r5.nextInt()     // Catch: java.lang.Exception -> L4f
            r0.xj = r1     // Catch: java.lang.Exception -> L4f
            goto L8
        L4b:
            r5.endObject()     // Catch: java.lang.Exception -> L4f
            return r0
        L4f:
            r5 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r5)
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.u.ra.y(android.util.JsonReader):com.bytedance.adsdk.lottie.d$hf$xj");
    }

    private static Map<String, Object> hf(JsonReader jsonReader) {
        HashMap hashMap = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            if (nextName.equals("lel")) {
                hashMap.put("lel", u(jsonReader));
            } else if (!nextName.equals("lottie_back")) {
                jsonReader.skipValue();
            } else {
                JSONObject jSONObject = new JSONObject();
                hashMap.put("lottie_back", jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    nextName2.getClass();
                    if (nextName2.equals(LiveConfigKey.HIGH)) {
                        try {
                            jSONObject.putOpt(LiveConfigKey.HIGH, Integer.valueOf(jsonReader.nextInt()));
                            jSONObject.putOpt(PointParamKey.VID, "lottie_back");
                        } catch (JSONException e) {
                            com.bytedance.sdk.component.utils.pl.xj(e);
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            }
        }
        jsonReader.endObject();
        Object remove = hashMap.remove("lottie_back");
        if (remove instanceof JSONObject) {
            Object obj = hashMap.get("lel");
            if (obj instanceof JSONArray) {
                ((JSONArray) obj).put(remove);
            } else {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(remove);
                hashMap.put("lel", jSONArray);
            }
        }
        return hashMap;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0066 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0047 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void xj(android.util.JsonReader r6, com.bytedance.adsdk.lottie.y.xj r7) {
        /*
            r6.beginObject()     // Catch: java.lang.Exception -> L71
        L3:
            boolean r0 = r6.hasNext()     // Catch: java.lang.Exception -> L71
            if (r0 == 0) goto L6d
            java.lang.String r0 = r6.nextName()     // Catch: java.lang.Exception -> L71
            int r1 = r0.hashCode()     // Catch: java.lang.Exception -> L71
            r2 = 104(0x68, float:1.46E-43)
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == r2) goto L3a
            switch(r1) {
                case 119: goto L30;
                case 120: goto L26;
                case 121: goto L1c;
                default: goto L1b;
            }     // Catch: java.lang.Exception -> L71
        L1b:
            goto L44
        L1c:
            java.lang.String r1 = "y"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L71
            if (r0 == 0) goto L44
            r0 = 1
            goto L45
        L26:
            java.lang.String r1 = "x"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L71
            if (r0 == 0) goto L44
            r0 = 0
            goto L45
        L30:
            java.lang.String r1 = "w"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L71
            if (r0 == 0) goto L44
            r0 = 2
            goto L45
        L3a:
            java.lang.String r1 = "h"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L71
            if (r0 == 0) goto L44
            r0 = 3
            goto L45
        L44:
            r0 = -1
        L45:
            if (r0 == 0) goto L66
            if (r0 == r5) goto L5f
            if (r0 == r4) goto L58
            if (r0 == r3) goto L51
            r6.skipValue()     // Catch: java.lang.Exception -> L71
            goto L3
        L51:
            java.lang.String r0 = r6.nextString()     // Catch: java.lang.Exception -> L71
            r7.u = r0     // Catch: java.lang.Exception -> L71
            goto L3
        L58:
            java.lang.String r0 = r6.nextString()     // Catch: java.lang.Exception -> L71
            r7.w = r0     // Catch: java.lang.Exception -> L71
            goto L3
        L5f:
            java.lang.String r0 = r6.nextString()     // Catch: java.lang.Exception -> L71
            r7.hf = r0     // Catch: java.lang.Exception -> L71
            goto L3
        L66:
            java.lang.String r0 = r6.nextString()     // Catch: java.lang.Exception -> L71
            r7.xj = r0     // Catch: java.lang.Exception -> L71
            goto L3
        L6d:
            r6.endObject()     // Catch: java.lang.Exception -> L71
            return
        L71:
            r6 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.u.ra.xj(android.util.JsonReader, com.bytedance.adsdk.lottie.y$xj):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0045 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void xj(android.util.JsonReader r7, com.bytedance.adsdk.lottie.y.w r8) {
        /*
            r0 = 0
            r1 = 1
            r7.beginObject()     // Catch: java.lang.Exception -> L92
        L5:
            boolean r2 = r7.hasNext()     // Catch: java.lang.Exception -> L92
            if (r2 == 0) goto L8e
            java.lang.String r2 = r7.nextName()     // Catch: java.lang.Exception -> L92
            int r3 = r2.hashCode()     // Catch: java.lang.Exception -> L92
            r4 = 3239(0xca7, float:4.539E-42)
            r5 = 2
            r6 = -1
            if (r3 == r4) goto L38
            r4 = 107027(0x1a213, float:1.49977E-40)
            if (r3 == r4) goto L2e
            r4 = 3237004(0x31648c, float:4.536009E-39)
            if (r3 == r4) goto L24
            goto L42
        L24:
            java.lang.String r3 = "inel"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> L92
            if (r2 == 0) goto L42
            r2 = 0
            goto L43
        L2e:
            java.lang.String r3 = "lel"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> L92
            if (r2 == 0) goto L42
            r2 = 2
            goto L43
        L38:
            java.lang.String r3 = "el"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> L92
            if (r2 == 0) goto L42
            r2 = 1
            goto L43
        L42:
            r2 = -1
        L43:
            if (r2 == 0) goto L5b
            if (r2 == r1) goto L54
            if (r2 == r5) goto L4d
            r7.skipValue()     // Catch: java.lang.Exception -> L92
            goto L5
        L4d:
            org.json.JSONArray r2 = u(r7)     // Catch: java.lang.Exception -> L92
            r8.w = r2     // Catch: java.lang.Exception -> L92
            goto L5
        L54:
            java.lang.String r2 = r7.nextString()     // Catch: java.lang.Exception -> L92
            r8.xj = r2     // Catch: java.lang.Exception -> L92
            goto L5
        L5b:
            int[] r2 = new int[]{r6, r6}     // Catch: java.lang.Exception -> L92
            int[][] r3 = new int[r1][]     // Catch: java.lang.Exception -> L92
            r3[r0] = r2     // Catch: java.lang.Exception -> L92
            r8.hf = r3     // Catch: java.lang.Exception -> L92
            r7.beginArray()     // Catch: java.lang.Exception -> L92
            boolean r2 = r7.hasNext()     // Catch: java.lang.Exception -> L92
            if (r2 == 0) goto L89
            r7.beginArray()     // Catch: java.lang.Exception -> L92
            r2 = 0
        L72:
            if (r2 >= r5) goto L86
            boolean r3 = r7.hasNext()     // Catch: java.lang.Exception -> L92
            if (r3 == 0) goto L84
            int[][] r3 = r8.hf     // Catch: java.lang.Exception -> L92
            r3 = r3[r0]     // Catch: java.lang.Exception -> L92
            int r4 = r7.nextInt()     // Catch: java.lang.Exception -> L92
            r3[r2] = r4     // Catch: java.lang.Exception -> L92
        L84:
            int r2 = r2 + r1
            goto L72
        L86:
            r7.endArray()     // Catch: java.lang.Exception -> L92
        L89:
            r7.endArray()     // Catch: java.lang.Exception -> L92
            goto L5
        L8e:
            r7.endObject()     // Catch: java.lang.Exception -> L92
            return
        L92:
            r7 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.u.ra.xj(android.util.JsonReader, com.bytedance.adsdk.lottie.y$w):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void xj(android.util.JsonReader r7, com.bytedance.adsdk.lottie.y.hf r8) {
        /*
            r7.beginObject()     // Catch: java.lang.Exception -> L92
        L3:
            boolean r0 = r7.hasNext()     // Catch: java.lang.Exception -> L92
            if (r0 == 0) goto L8e
            java.lang.String r0 = r7.nextName()     // Catch: java.lang.Exception -> L92
            int r1 = r0.hashCode()     // Catch: java.lang.Exception -> L92
            r2 = 3139(0xc43, float:4.399E-42)
            r3 = 1
            r4 = 2
            r5 = 3
            r6 = 4
            if (r1 == r2) goto L53
            r2 = 3232(0xca0, float:4.529E-42)
            if (r1 == r2) goto L49
            r2 = 3571(0xdf3, float:5.004E-42)
            if (r1 == r2) goto L3f
            r2 = 3666(0xe52, float:5.137E-42)
            if (r1 == r2) goto L35
            r2 = 98713(0x18199, float:1.38326E-40)
            if (r1 == r2) goto L2b
            goto L5d
        L2b:
            java.lang.String r1 = "cpf"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L92
            if (r0 == 0) goto L5d
            r0 = 4
            goto L5e
        L35:
            java.lang.String r1 = "se"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L92
            if (r0 == 0) goto L5d
            r0 = 0
            goto L5e
        L3f:
            java.lang.String r1 = "pc"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L92
            if (r0 == 0) goto L5d
            r0 = 3
            goto L5e
        L49:
            java.lang.String r1 = "ee"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L92
            if (r0 == 0) goto L5d
            r0 = 2
            goto L5e
        L53:
            java.lang.String r1 = "be"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L92
            if (r0 == 0) goto L5d
            r0 = 1
            goto L5e
        L5d:
            r0 = -1
        L5e:
            if (r0 == 0) goto L86
            if (r0 == r3) goto L7e
            if (r0 == r4) goto L77
            if (r0 == r5) goto L70
            if (r0 == r6) goto L6c
            r7.skipValue()     // Catch: java.lang.Exception -> L92
            goto L3
        L6c:
            hf(r7, r8)     // Catch: java.lang.Exception -> L92
            goto L3
        L70:
            int r0 = r7.nextInt()     // Catch: java.lang.Exception -> L92
            r8.u = r0     // Catch: java.lang.Exception -> L92
            goto L3
        L77:
            java.util.Map r0 = hf(r7)     // Catch: java.lang.Exception -> L92
            r8.w = r0     // Catch: java.lang.Exception -> L92
            goto L3
        L7e:
            java.util.Map r0 = hf(r7)     // Catch: java.lang.Exception -> L92
            r8.hf = r0     // Catch: java.lang.Exception -> L92
            goto L3
        L86:
            int r0 = r7.nextInt()     // Catch: java.lang.Exception -> L92
            r8.xj = r0     // Catch: java.lang.Exception -> L92
            goto L3
        L8e:
            r7.endObject()     // Catch: java.lang.Exception -> L92
            return
        L92:
            r7 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.u.ra.xj(android.util.JsonReader, com.bytedance.adsdk.lottie.y$hf):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0101 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0109 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0111 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ab A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void xj(android.util.JsonReader r6, com.bytedance.adsdk.lottie.y.u r7) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.u.ra.xj(android.util.JsonReader, com.bytedance.adsdk.lottie.y$u):void");
    }

    private static void xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar, List<com.bytedance.adsdk.lottie.model.layer.f> list, LongSparseArray<com.bytedance.adsdk.lottie.model.layer.f> longSparseArray) {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.lottie.model.layer.f xj = ht.xj(jsonReader, yVar);
            if (xj.p() == f.xj.IMAGE) {
                i++;
            }
            list.add(xj);
            longSparseArray.put(xj.kd(), xj);
            if (i > 4) {
                com.bytedance.adsdk.lottie.kd.kd.hf("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar, Map<String, List<com.bytedance.adsdk.lottie.model.layer.f>> map, Map<String, com.bytedance.adsdk.lottie.d> map2) {
        char c;
        int i = 2;
        int i2 = -1;
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            String str3 = null;
            String str4 = null;
            List<d.hf> list = null;
            String str5 = null;
            int[][] iArr = null;
            JSONArray jSONArray = null;
            String str6 = null;
            String str7 = null;
            d.xj xjVar = null;
            int i3 = 0;
            int i4 = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.getClass();
                switch (nextName.hashCode()) {
                    case -1109732030:
                        if (nextName.equals("layers")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case -847116302:
                        if (nextName.equals("ugen_v")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 104:
                        if (nextName.equals("h")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case AdEventType.AD_TICK /* 112 */:
                        if (nextName.equals(t.b)) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 117:
                        if (nextName.equals(t.i)) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 119:
                        if (nextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case 3239:
                        if (nextName.equals(t.n)) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case 3355:
                        if (nextName.equals(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a)) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case 3633:
                        if (nextName.equals("rc")) {
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case 3695:
                        if (nextName.equals("tc")) {
                            c = '\t';
                            break;
                        }
                        c = 65535;
                        break;
                    case 107027:
                        if (nextName.equals("lel")) {
                            c = '\n';
                            break;
                        }
                        c = 65535;
                        break;
                    case 107902:
                        if (nextName.equals(TKDownloadReason.KSAD_TK_MD5)) {
                            c = 11;
                            break;
                        }
                        c = 65535;
                        break;
                    case 112793:
                        if (nextName.equals("rel")) {
                            c = '\f';
                            break;
                        }
                        c = 65535;
                        break;
                    case 3237004:
                        if (nextName.equals("inel")) {
                            c = '\r';
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            com.bytedance.adsdk.lottie.model.layer.f xj = ht.xj(jsonReader, yVar);
                            longSparseArray.put(xj.kd(), xj);
                            arrayList.add(xj);
                        }
                        jsonReader.endArray();
                        i = 2;
                        i2 = -1;
                        break;
                    case 1:
                        str7 = jsonReader.nextString();
                        break;
                    case 2:
                        i4 = jsonReader.nextInt();
                        break;
                    case 3:
                        str2 = jsonReader.nextString();
                        break;
                    case 4:
                        str3 = jsonReader.nextString();
                        break;
                    case 5:
                        i3 = jsonReader.nextInt();
                        break;
                    case 6:
                        str5 = jsonReader.nextString();
                        break;
                    case 7:
                        str = jsonReader.nextString();
                        break;
                    case '\b':
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                            i = 2;
                            i2 = -1;
                            break;
                        } else {
                            d.xj xjVar2 = new d.xj();
                            jsonReader.beginObject();
                            xj(jsonReader, xjVar2);
                            jsonReader.endObject();
                            xjVar = xjVar2;
                            break;
                        }
                    case '\t':
                        jsonReader.beginArray();
                        list = kd(jsonReader);
                        jsonReader.endArray();
                        break;
                    case '\n':
                        jSONArray = u(jsonReader);
                        break;
                    case 11:
                        str6 = jsonReader.nextString();
                        break;
                    case '\f':
                        str4 = jsonReader.nextString();
                        break;
                    case '\r':
                        int[][] iArr2 = {new int[]{i2, i2}};
                        jsonReader.beginArray();
                        if (jsonReader.hasNext()) {
                            jsonReader.beginArray();
                            for (int i5 = 0; i5 < i; i5++) {
                                if (jsonReader.hasNext()) {
                                    iArr2[0][i5] = jsonReader.nextInt();
                                }
                            }
                            jsonReader.endArray();
                        }
                        jsonReader.endArray();
                        iArr = iArr2;
                        break;
                    default:
                        jsonReader.skipValue();
                        i = 2;
                        i2 = -1;
                        break;
                }
            }
            jsonReader.endObject();
            if (str2 != null) {
                com.bytedance.adsdk.lottie.d dVar = new com.bytedance.adsdk.lottie.d(i3, i4, str, str2, str3, str4, list, str5, iArr, jSONArray, str6, str7, xjVar);
                map2.put(dVar.p(), dVar);
            } else {
                map.put(str, arrayList);
            }
            i = 2;
            i2 = -1;
        }
        jsonReader.endArray();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0079 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0030 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void xj(android.util.JsonReader r4, com.bytedance.adsdk.lottie.d.xj r5) {
        /*
        L0:
            boolean r0 = r4.hasNext()     // Catch: java.lang.Exception -> L81
            if (r0 == 0) goto L80
            java.lang.String r0 = r4.nextName()     // Catch: java.lang.Exception -> L81
            int r1 = r0.hashCode()     // Catch: java.lang.Exception -> L81
            r2 = -2128704353(0xffffffff811e8c9f, float:-2.9120907E-38)
            r3 = 1
            if (r1 == r2) goto L23
            r2 = 3308(0xcec, float:4.635E-42)
            if (r1 == r2) goto L19
            goto L2d
        L19:
            java.lang.String r1 = "gs"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L81
            if (r0 == 0) goto L2d
            r0 = 1
            goto L2e
        L23:
            java.lang.String r1 = "is_secondary"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L81
            if (r0 == 0) goto L2d
            r0 = 0
            goto L2e
        L2d:
            r0 = -1
        L2e:
            if (r0 == 0) goto L79
            if (r0 == r3) goto L36
            r4.skipValue()     // Catch: java.lang.Exception -> L81
            goto L0
        L36:
            android.util.JsonToken r0 = r4.peek()     // Catch: java.lang.Exception -> L81
            android.util.JsonToken r1 = android.util.JsonToken.NULL     // Catch: java.lang.Exception -> L81
            if (r0 != r1) goto L42
            r4.nextNull()     // Catch: java.lang.Exception -> L81
            goto L0
        L42:
            com.bytedance.adsdk.lottie.d$xj$xj r0 = new com.bytedance.adsdk.lottie.d$xj$xj     // Catch: java.lang.Exception -> L81
            r0.<init>()     // Catch: java.lang.Exception -> L81
            r5.xj = r0     // Catch: java.lang.Exception -> L81
            r4.beginObject()     // Catch: java.lang.Exception -> L81
        L4c:
            boolean r0 = r4.hasNext()     // Catch: java.lang.Exception -> L81
            if (r0 == 0) goto L75
            java.lang.String r0 = r4.nextName()     // Catch: java.lang.Exception -> L81
            int r1 = r0.hashCode()     // Catch: java.lang.Exception -> L81
            r2 = 114(0x72, float:1.6E-43)
            if (r1 == r2) goto L5f
            goto L71
        L5f:
            java.lang.String r1 = "r"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L81
            if (r0 == 0) goto L71
            com.bytedance.adsdk.lottie.d$xj$xj r0 = r5.xj     // Catch: java.lang.Exception -> L81
            double r1 = r4.nextDouble()     // Catch: java.lang.Exception -> L81
            float r1 = (float) r1     // Catch: java.lang.Exception -> L81
            r0.xj = r1     // Catch: java.lang.Exception -> L81
            goto L4c
        L71:
            r4.skipValue()     // Catch: java.lang.Exception -> L81
            goto L4c
        L75:
            r4.endObject()     // Catch: java.lang.Exception -> L81
            goto L0
        L79:
            boolean r0 = r4.nextBoolean()     // Catch: java.lang.Exception -> L81
            r5.hf = r0     // Catch: java.lang.Exception -> L81
            goto L0
        L80:
            return
        L81:
            r4 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.u.ra.xj(android.util.JsonReader, com.bytedance.adsdk.lottie.d$xj):void");
    }

    private static void xj(JsonReader jsonReader, Map<String, com.bytedance.adsdk.lottie.model.w> map) {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            if (!nextName.equals("list")) {
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.lottie.model.w xj = am.xj(jsonReader);
                    map.put(xj.hf(), xj);
                }
                jsonReader.endArray();
            }
        }
        jsonReader.endObject();
    }

    private static void xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar, SparseArray<com.bytedance.adsdk.lottie.model.u> sparseArray) {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.lottie.model.u xj = g.xj(jsonReader, yVar);
            sparseArray.put(xj.hashCode(), xj);
        }
        jsonReader.endArray();
    }

    private static void xj(JsonReader jsonReader, List<com.bytedance.adsdk.lottie.model.y> list) {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            float f = 0.0f;
            String str = null;
            float f2 = 0.0f;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.getClass();
                switch (nextName) {
                    case "cm":
                        str = jsonReader.nextString();
                        break;
                    case "dr":
                        f2 = (float) jsonReader.nextDouble();
                        break;
                    case "tm":
                        f = (float) jsonReader.nextDouble();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            list.add(new com.bytedance.adsdk.lottie.model.y(str, f, f2));
        }
        jsonReader.endArray();
    }
}
