package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.baidu.mobads.sdk.internal.cb;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.a.ws;
import com.bytedance.sdk.openadsdk.core.dk;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.ra.ne;
import com.bytedance.sdk.openadsdk.core.ra.tj;
import com.bytedance.sdk.openadsdk.core.ra.vl;
import com.bytedance.sdk.openadsdk.core.ra.wn;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import com.czhj.sdk.common.Constants;
import com.kwad.sdk.api.model.AdnName;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class et implements dk<com.bytedance.sdk.openadsdk.core.am.xj> {
    private final Context hf;
    private AtomicLong kd = new AtomicLong(0);
    private static final AtomicInteger w = new AtomicInteger(0);
    public static Map<String, Long> xj = new ConcurrentHashMap();
    private static final AtomicInteger u = new AtomicInteger(0);

    public static class hf {
        public final boolean hf;
        public final int xj;

        private hf(int i, boolean z) {
            this.xj = i;
            this.hf = z;
        }

        public static hf xj(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new hf(jSONObject.optInt("error_code"), jSONObject.optBoolean("result"));
        }
    }

    public static class u {
        public final boolean hf;
        public final vl w;
        public final int xj;

        private u(int i, boolean z, vl vlVar) {
            this.xj = i;
            this.hf = z;
            this.w = vlVar;
        }

        public static u xj(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int optInt = jSONObject.optInt(PluginConstants.KEY_ERROR_CODE);
            boolean optBoolean = jSONObject.optBoolean("verify");
            JSONObject optJSONObject = jSONObject.optJSONObject(PointParamKey.DATA);
            vl vlVar = new vl();
            if (optJSONObject != null) {
                try {
                    vlVar.xj(optJSONObject.optInt(MediationConstant.KEY_REASON));
                    vlVar.hf(optJSONObject.optInt("corp_type"));
                    vlVar.w(optJSONObject.optInt(MediationConstant.REWARD_AMOUNT));
                    vlVar.xj(optJSONObject.optString(MediationConstant.REWARD_NAME));
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.pl.xj(th);
                }
            }
            return new u(optInt, optBoolean, vlVar);
        }
    }

    public static class w {
        public final String hf;
        public final wn w;
        public final int xj;

        private w(int i, String str, wn wnVar) {
            this.xj = i;
            this.hf = str;
            this.w = wnVar;
        }

        public static w xj(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int optInt = jSONObject.optInt(PluginConstants.KEY_ERROR_CODE);
            String optString = jSONObject.optString("message");
            JSONObject optJSONObject = jSONObject.optJSONObject(PointParamKey.DATA);
            wn wnVar = new wn();
            if (optJSONObject != null) {
                try {
                    wnVar.xj(optJSONObject.optBoolean("is_open"));
                    wnVar.xj(optJSONObject.optString("req_id"));
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.pl.xj(th);
                }
            }
            return new w(optInt, optString, wnVar);
        }
    }

    public static class xj {
        final String c;
        final String d;
        public final com.bytedance.sdk.openadsdk.core.ra.xj f;
        final long hf;
        final String kd;
        final ArrayList<Integer> tf;
        final int u;
        final long w;
        final int xj;
        final int y;

        private xj(String str, int i, int i2, String str2, int i3, String str3, com.bytedance.sdk.openadsdk.core.ra.xj xjVar, long j, long j2, ArrayList<Integer> arrayList) {
            this.xj = i;
            this.u = i2;
            this.kd = str2;
            this.c = str3;
            this.f = xjVar;
            this.d = str;
            this.y = i3;
            this.hf = j;
            this.w = j2;
            this.tf = arrayList;
        }

        public static xj xj(JSONObject jSONObject) {
            return xj(jSONObject, null, null);
        }

        public static xj xj(JSONObject jSONObject, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, tj tjVar) {
            Object obj;
            String optString = jSONObject.optString("did");
            int optInt = jSONObject.optInt("processing_time_ms");
            long optLong = jSONObject.optLong("s_receive_ts");
            long optLong2 = jSONObject.optLong("s_send_ts");
            int optInt2 = jSONObject.optInt("status_code");
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString(PointParamKey.REQUEST_ID);
            int optInt3 = jSONObject.optInt(MediationConstant.KEY_REASON);
            Pair<com.bytedance.sdk.openadsdk.core.ra.xj, ArrayList<Integer>> xj = com.bytedance.sdk.openadsdk.core.xj.xj(jSONObject, hfVar, tjVar, optLong2);
            if (xj != null && (obj = xj.first) != null) {
                ((com.bytedance.sdk.openadsdk.core.ra.xj) obj).xj(jSONObject.optLong("request_after"));
            }
            return xj == null ? new xj(optString, optInt, optInt2, optString2, optInt3, optString3, null, optLong, optLong2, null) : new xj(optString, optInt, optInt2, optString2, optInt3, optString3, (com.bytedance.sdk.openadsdk.core.ra.xj) xj.first, optLong, optLong2, (ArrayList) xj.second);
        }
    }

    static {
        EomCzJx();
    }

    public et(Context context) {
        this.hf = context;
    }

    private static /* synthetic */ void EomCzJx() {
        char[] charArray = "\u0095\u0099\u009bØ\u0091\u0097\u009b\u0093Ø\u0094\u0099\u008fØ\u0085\u009e\u0093\u009a\u009aØ¼\u0098\u009f´\u0084\u009f\u0092\u0091\u0093".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 246);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0095\u009a\u009f\u0098\u009f\u0082".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 246);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private boolean hf(int i) {
        return i == 3 || i == 4;
    }

    private boolean w(String str) {
        if (com.bytedance.sdk.openadsdk.core.zg.w.w()) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.zg.w.hf(str)) {
            return false;
        }
        String u2 = com.bytedance.sdk.openadsdk.core.zg.w.u();
        if (!TextUtils.isEmpty(u2)) {
            com.bytedance.sdk.openadsdk.core.ht.am.xj(u2, System.currentTimeMillis(), true);
        }
        return true;
    }

    public void kd(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final tj tjVar, final int i, dk.hf hfVar2) {
        final com.bytedance.sdk.openadsdk.core.xj.xj xjVar = new com.bytedance.sdk.openadsdk.core.xj.xj(hfVar2);
        com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("bid_p_f") { // from class: com.bytedance.sdk.openadsdk.core.et.21
            @Override // java.lang.Runnable
            public void run() {
                et.this.xj(hfVar, tjVar, i, xjVar, "/api/ad/union/server_bidding/pre_fetch/", 1);
            }
        });
    }

    public void u(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, tj tjVar, int i, dk.hf hfVar2) {
        hf(hfVar, tjVar, i, hfVar2, "/api/ad/union/sdk/get_ads/", 5);
    }

    private boolean hf(String str) {
        if (com.bytedance.sdk.openadsdk.core.zg.w.xj()) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.zg.w.xj(str)) {
            return false;
        }
        String hf2 = com.bytedance.sdk.openadsdk.core.zg.w.hf();
        if (!TextUtils.isEmpty(hf2)) {
            com.bytedance.sdk.openadsdk.core.ht.am.xj(hf2, System.currentTimeMillis(), false);
        }
        return true;
    }

    private boolean u(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        return hfVar != null && hfVar.c() == 320 && hfVar.y() == 640;
    }

    private void u(String str) {
        com.bytedance.sdk.component.d.hf.w w2 = com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().w();
        w2.xj(str);
        w2.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.et.17
            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar) {
            }

            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.dk
    public void w(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final tj tjVar, final int i, dk.hf hfVar2) {
        final com.bytedance.sdk.openadsdk.core.xj.xj xjVar = new com.bytedance.sdk.openadsdk.core.xj.xj(hfVar2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("bid_g_m") { // from class: com.bytedance.sdk.openadsdk.core.et.22
                @Override // java.lang.Runnable
                public void run() {
                    et.this.xj(hfVar, tjVar, i, xjVar, "/api/ad/union/server_bidding/get_materials/", 3);
                }
            });
        } else {
            xj(hfVar, tjVar, i, xjVar, "/api/ad/union/server_bidding/get_materials/", 3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.dk
    public void hf(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final tj tjVar, final int i, dk.hf hfVar2) {
        final com.bytedance.sdk.openadsdk.core.xj.xj xjVar = new com.bytedance.sdk.openadsdk.core.xj.xj(hfVar2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("bid_pre") { // from class: com.bytedance.sdk.openadsdk.core.et.12
                @Override // java.lang.Runnable
                public void run() {
                    et.this.xj(hfVar, tjVar, i, xjVar, "/api/ad/union/server_bidding/pre_cache/", 2);
                }
            });
        } else {
            xj(hfVar, tjVar, i, xjVar, "/api/ad/union/server_bidding/pre_cache/", 2);
        }
    }

    private static String w(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        String io2 = f.zg().io();
        String y = f.zg().y();
        f.zg().hf((String) null);
        String ht = hfVar != null ? hfVar.ht() : null;
        if (TextUtils.isEmpty(io2)) {
            return xj(ht, y);
        }
        try {
            if (!TextUtils.isEmpty(io2) && io2.contains("game_adapter_did")) {
                io2 = xj(new JSONArray(io2)).toString();
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        if (TextUtils.isEmpty(ht)) {
            return xj(io2, y);
        }
        HashSet hashSet = new HashSet();
        try {
            JSONArray jSONArray = new JSONArray(ht);
            int length = jSONArray.length();
            boolean z = false;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String optString = jSONObject.optString("name", null);
                    if (TextUtils.equals("is_shake_ads", optString)) {
                        if (TextUtils.equals(y, Constants.FAIL)) {
                            jSONObject.put("value", Constants.FAIL);
                            f.zg().hf(Constants.FAIL);
                        } else {
                            f.zg().hf(jSONObject.optString("value"));
                        }
                        z = true;
                    }
                    hashSet.add(optString);
                }
            }
            try {
                JSONArray jSONArray2 = new JSONArray(io2);
                int length2 = jSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                    if (jSONObject2 != null) {
                        String optString2 = jSONObject2.optString("name", null);
                        if (!hashSet.contains(optString2)) {
                            if (TextUtils.equals("is_shake_ads", optString2)) {
                                if (TextUtils.equals(y, Constants.FAIL)) {
                                    jSONObject2.put("value", Constants.FAIL);
                                    f.zg().hf(Constants.FAIL);
                                } else {
                                    f.zg().hf(jSONObject2.optString("value"));
                                }
                                z = true;
                            }
                            jSONArray.put(jSONObject2);
                        }
                    }
                }
                if (!z) {
                    jSONArray = hf(jSONArray, y);
                }
                return xj(xj(jSONArray), y).toString();
            } catch (Throwable unused) {
                return xj(ht, y);
            }
        } catch (Throwable unused2) {
            return xj(io2, y);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(45:0|1|(3:144|145|(1:147)(40:148|4|(2:8|(1:(1:11)(1:12))(1:13))|14|(2:(1:19)|(1:23))(2:138|(1:143))|24|25|(2:133|134)|(2:28|(3:30|31|32)(1:130))(1:132)|33|(1:35)|36|(1:126)|42|(1:46)|47|(1:49)(1:125)|50|(1:52)|53|(1:55)|56|(1:58)(1:124)|59|(14:63|64|(10:66|(1:70)|(1:74)|75|(1:77)|78|79|(1:81)(1:85)|(1:83)|84)|86|87|(1:122)(1:91)|92|(1:94)|95|(1:98)|99|(4:101|(3:103|(1:105)(1:110)|106)(1:111)|107|(1:109))|(1:113)(4:116|(1:118)|119|(1:121))|114)|123|64|(0)|86|87|(1:89)|122|92|(0)|95|(1:98)|99|(0)|(0)(0)|114))|3|4|(3:6|8|(0)(0))|14|(0)(0)|24|25|(0)|(0)(0)|33|(0)|36|(1:38)|126|42|(2:44|46)|47|(0)(0)|50|(0)|53|(0)|56|(0)(0)|59|(15:63|64|(0)|86|87|(0)|122|92|(0)|95|(0)|99|(0)|(0)(0)|114)|123|64|(0)|86|87|(0)|122|92|(0)|95|(0)|99|(0)|(0)(0)|114|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x00c3, code lost:
    
        r17 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0342 A[Catch: all -> 0x03c1, TryCatch #0 {all -> 0x03c1, blocks: (B:145:0x0017, B:148:0x0022, B:6:0x0031, B:8:0x0037, B:11:0x0043, B:12:0x0048, B:13:0x004c, B:17:0x0054, B:19:0x0058, B:21:0x005d, B:23:0x0065, B:44:0x00ef, B:46:0x00f7, B:47:0x00fc, B:50:0x012b, B:52:0x0165, B:53:0x0181, B:55:0x01a5, B:56:0x01aa, B:59:0x01b7, B:64:0x01d5, B:66:0x01e4, B:68:0x01ee, B:70:0x01f4, B:72:0x01fb, B:74:0x0201, B:75:0x020a, B:77:0x0214, B:78:0x0221, B:81:0x022f, B:83:0x0246, B:84:0x024f, B:85:0x0236, B:86:0x027f, B:89:0x02ac, B:91:0x02af, B:92:0x02b6, B:94:0x02de, B:95:0x02e3, B:98:0x0327, B:99:0x0337, B:101:0x0342, B:103:0x0369, B:106:0x0373, B:107:0x0388, B:109:0x038c, B:111:0x037b, B:113:0x0398, B:118:0x03a1, B:119:0x03aa, B:121:0x03b4, B:141:0x007a, B:143:0x007e, B:3:0x0027), top: B:144:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0398 A[Catch: all -> 0x03c1, TryCatch #0 {all -> 0x03c1, blocks: (B:145:0x0017, B:148:0x0022, B:6:0x0031, B:8:0x0037, B:11:0x0043, B:12:0x0048, B:13:0x004c, B:17:0x0054, B:19:0x0058, B:21:0x005d, B:23:0x0065, B:44:0x00ef, B:46:0x00f7, B:47:0x00fc, B:50:0x012b, B:52:0x0165, B:53:0x0181, B:55:0x01a5, B:56:0x01aa, B:59:0x01b7, B:64:0x01d5, B:66:0x01e4, B:68:0x01ee, B:70:0x01f4, B:72:0x01fb, B:74:0x0201, B:75:0x020a, B:77:0x0214, B:78:0x0221, B:81:0x022f, B:83:0x0246, B:84:0x024f, B:85:0x0236, B:86:0x027f, B:89:0x02ac, B:91:0x02af, B:92:0x02b6, B:94:0x02de, B:95:0x02e3, B:98:0x0327, B:99:0x0337, B:101:0x0342, B:103:0x0369, B:106:0x0373, B:107:0x0388, B:109:0x038c, B:111:0x037b, B:113:0x0398, B:118:0x03a1, B:119:0x03aa, B:121:0x03b4, B:141:0x007a, B:143:0x007e, B:3:0x0027), top: B:144:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004c A[Catch: all -> 0x03c1, TryCatch #0 {all -> 0x03c1, blocks: (B:145:0x0017, B:148:0x0022, B:6:0x0031, B:8:0x0037, B:11:0x0043, B:12:0x0048, B:13:0x004c, B:17:0x0054, B:19:0x0058, B:21:0x005d, B:23:0x0065, B:44:0x00ef, B:46:0x00f7, B:47:0x00fc, B:50:0x012b, B:52:0x0165, B:53:0x0181, B:55:0x01a5, B:56:0x01aa, B:59:0x01b7, B:64:0x01d5, B:66:0x01e4, B:68:0x01ee, B:70:0x01f4, B:72:0x01fb, B:74:0x0201, B:75:0x020a, B:77:0x0214, B:78:0x0221, B:81:0x022f, B:83:0x0246, B:84:0x024f, B:85:0x0236, B:86:0x027f, B:89:0x02ac, B:91:0x02af, B:92:0x02b6, B:94:0x02de, B:95:0x02e3, B:98:0x0327, B:99:0x0337, B:101:0x0342, B:103:0x0369, B:106:0x0373, B:107:0x0388, B:109:0x038c, B:111:0x037b, B:113:0x0398, B:118:0x03a1, B:119:0x03aa, B:121:0x03b4, B:141:0x007a, B:143:0x007e, B:3:0x0027), top: B:144:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a8 A[Catch: all -> 0x00c3, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x00c3, blocks: (B:25:0x0081, B:28:0x00a8), top: B:24:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cf A[Catch: all -> 0x00be, TryCatch #3 {all -> 0x00be, blocks: (B:32:0x00b8, B:33:0x00c9, B:35:0x00cf, B:36:0x00d4, B:38:0x00da, B:40:0x00e0, B:126:0x00e6), top: B:31:0x00b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ef A[Catch: all -> 0x03c1, TRY_ENTER, TryCatch #0 {all -> 0x03c1, blocks: (B:145:0x0017, B:148:0x0022, B:6:0x0031, B:8:0x0037, B:11:0x0043, B:12:0x0048, B:13:0x004c, B:17:0x0054, B:19:0x0058, B:21:0x005d, B:23:0x0065, B:44:0x00ef, B:46:0x00f7, B:47:0x00fc, B:50:0x012b, B:52:0x0165, B:53:0x0181, B:55:0x01a5, B:56:0x01aa, B:59:0x01b7, B:64:0x01d5, B:66:0x01e4, B:68:0x01ee, B:70:0x01f4, B:72:0x01fb, B:74:0x0201, B:75:0x020a, B:77:0x0214, B:78:0x0221, B:81:0x022f, B:83:0x0246, B:84:0x024f, B:85:0x0236, B:86:0x027f, B:89:0x02ac, B:91:0x02af, B:92:0x02b6, B:94:0x02de, B:95:0x02e3, B:98:0x0327, B:99:0x0337, B:101:0x0342, B:103:0x0369, B:106:0x0373, B:107:0x0388, B:109:0x038c, B:111:0x037b, B:113:0x0398, B:118:0x03a1, B:119:0x03aa, B:121:0x03b4, B:141:0x007a, B:143:0x007e, B:3:0x0027), top: B:144:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0165 A[Catch: all -> 0x03c1, TryCatch #0 {all -> 0x03c1, blocks: (B:145:0x0017, B:148:0x0022, B:6:0x0031, B:8:0x0037, B:11:0x0043, B:12:0x0048, B:13:0x004c, B:17:0x0054, B:19:0x0058, B:21:0x005d, B:23:0x0065, B:44:0x00ef, B:46:0x00f7, B:47:0x00fc, B:50:0x012b, B:52:0x0165, B:53:0x0181, B:55:0x01a5, B:56:0x01aa, B:59:0x01b7, B:64:0x01d5, B:66:0x01e4, B:68:0x01ee, B:70:0x01f4, B:72:0x01fb, B:74:0x0201, B:75:0x020a, B:77:0x0214, B:78:0x0221, B:81:0x022f, B:83:0x0246, B:84:0x024f, B:85:0x0236, B:86:0x027f, B:89:0x02ac, B:91:0x02af, B:92:0x02b6, B:94:0x02de, B:95:0x02e3, B:98:0x0327, B:99:0x0337, B:101:0x0342, B:103:0x0369, B:106:0x0373, B:107:0x0388, B:109:0x038c, B:111:0x037b, B:113:0x0398, B:118:0x03a1, B:119:0x03aa, B:121:0x03b4, B:141:0x007a, B:143:0x007e, B:3:0x0027), top: B:144:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a5 A[Catch: all -> 0x03c1, TryCatch #0 {all -> 0x03c1, blocks: (B:145:0x0017, B:148:0x0022, B:6:0x0031, B:8:0x0037, B:11:0x0043, B:12:0x0048, B:13:0x004c, B:17:0x0054, B:19:0x0058, B:21:0x005d, B:23:0x0065, B:44:0x00ef, B:46:0x00f7, B:47:0x00fc, B:50:0x012b, B:52:0x0165, B:53:0x0181, B:55:0x01a5, B:56:0x01aa, B:59:0x01b7, B:64:0x01d5, B:66:0x01e4, B:68:0x01ee, B:70:0x01f4, B:72:0x01fb, B:74:0x0201, B:75:0x020a, B:77:0x0214, B:78:0x0221, B:81:0x022f, B:83:0x0246, B:84:0x024f, B:85:0x0236, B:86:0x027f, B:89:0x02ac, B:91:0x02af, B:92:0x02b6, B:94:0x02de, B:95:0x02e3, B:98:0x0327, B:99:0x0337, B:101:0x0342, B:103:0x0369, B:106:0x0373, B:107:0x0388, B:109:0x038c, B:111:0x037b, B:113:0x0398, B:118:0x03a1, B:119:0x03aa, B:121:0x03b4, B:141:0x007a, B:143:0x007e, B:3:0x0027), top: B:144:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01cf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01e4 A[Catch: all -> 0x03c1, TryCatch #0 {all -> 0x03c1, blocks: (B:145:0x0017, B:148:0x0022, B:6:0x0031, B:8:0x0037, B:11:0x0043, B:12:0x0048, B:13:0x004c, B:17:0x0054, B:19:0x0058, B:21:0x005d, B:23:0x0065, B:44:0x00ef, B:46:0x00f7, B:47:0x00fc, B:50:0x012b, B:52:0x0165, B:53:0x0181, B:55:0x01a5, B:56:0x01aa, B:59:0x01b7, B:64:0x01d5, B:66:0x01e4, B:68:0x01ee, B:70:0x01f4, B:72:0x01fb, B:74:0x0201, B:75:0x020a, B:77:0x0214, B:78:0x0221, B:81:0x022f, B:83:0x0246, B:84:0x024f, B:85:0x0236, B:86:0x027f, B:89:0x02ac, B:91:0x02af, B:92:0x02b6, B:94:0x02de, B:95:0x02e3, B:98:0x0327, B:99:0x0337, B:101:0x0342, B:103:0x0369, B:106:0x0373, B:107:0x0388, B:109:0x038c, B:111:0x037b, B:113:0x0398, B:118:0x03a1, B:119:0x03aa, B:121:0x03b4, B:141:0x007a, B:143:0x007e, B:3:0x0027), top: B:144:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02ac A[Catch: all -> 0x03c1, TRY_ENTER, TryCatch #0 {all -> 0x03c1, blocks: (B:145:0x0017, B:148:0x0022, B:6:0x0031, B:8:0x0037, B:11:0x0043, B:12:0x0048, B:13:0x004c, B:17:0x0054, B:19:0x0058, B:21:0x005d, B:23:0x0065, B:44:0x00ef, B:46:0x00f7, B:47:0x00fc, B:50:0x012b, B:52:0x0165, B:53:0x0181, B:55:0x01a5, B:56:0x01aa, B:59:0x01b7, B:64:0x01d5, B:66:0x01e4, B:68:0x01ee, B:70:0x01f4, B:72:0x01fb, B:74:0x0201, B:75:0x020a, B:77:0x0214, B:78:0x0221, B:81:0x022f, B:83:0x0246, B:84:0x024f, B:85:0x0236, B:86:0x027f, B:89:0x02ac, B:91:0x02af, B:92:0x02b6, B:94:0x02de, B:95:0x02e3, B:98:0x0327, B:99:0x0337, B:101:0x0342, B:103:0x0369, B:106:0x0373, B:107:0x0388, B:109:0x038c, B:111:0x037b, B:113:0x0398, B:118:0x03a1, B:119:0x03aa, B:121:0x03b4, B:141:0x007a, B:143:0x007e, B:3:0x0027), top: B:144:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02de A[Catch: all -> 0x03c1, TryCatch #0 {all -> 0x03c1, blocks: (B:145:0x0017, B:148:0x0022, B:6:0x0031, B:8:0x0037, B:11:0x0043, B:12:0x0048, B:13:0x004c, B:17:0x0054, B:19:0x0058, B:21:0x005d, B:23:0x0065, B:44:0x00ef, B:46:0x00f7, B:47:0x00fc, B:50:0x012b, B:52:0x0165, B:53:0x0181, B:55:0x01a5, B:56:0x01aa, B:59:0x01b7, B:64:0x01d5, B:66:0x01e4, B:68:0x01ee, B:70:0x01f4, B:72:0x01fb, B:74:0x0201, B:75:0x020a, B:77:0x0214, B:78:0x0221, B:81:0x022f, B:83:0x0246, B:84:0x024f, B:85:0x0236, B:86:0x027f, B:89:0x02ac, B:91:0x02af, B:92:0x02b6, B:94:0x02de, B:95:0x02e3, B:98:0x0327, B:99:0x0337, B:101:0x0342, B:103:0x0369, B:106:0x0373, B:107:0x0388, B:109:0x038c, B:111:0x037b, B:113:0x0398, B:118:0x03a1, B:119:0x03aa, B:121:0x03b4, B:141:0x007a, B:143:0x007e, B:3:0x0027), top: B:144:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0325 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject xj(com.bytedance.sdk.openadsdk.zg.w.w.hf r26, com.bytedance.sdk.openadsdk.core.ra.tj r27, int r28, boolean r29, int r30) {
        /*
            Method dump skipped, instructions count: 962
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.et.xj(com.bytedance.sdk.openadsdk.zg.w.w.hf, com.bytedance.sdk.openadsdk.core.ra.tj, int, boolean, int):org.json.JSONObject");
    }

    private void hf(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final tj tjVar, final int i, dk.hf hfVar2, String str, final int i2) {
        final com.bytedance.sdk.openadsdk.core.ra.hf hfVar3;
        final dk.hf hfVar4;
        Throwable th;
        com.bytedance.sdk.openadsdk.core.ra.hf hfVar5 = new com.bytedance.sdk.openadsdk.core.ra.hf();
        hfVar5.xj(hfVar);
        try {
            hfVar3 = hfVar5;
            hfVar4 = hfVar2;
            if (xj(hfVar, hfVar5, hfVar2, i2 == 5, tjVar, i)) {
                return;
            }
            try {
                com.bytedance.sdk.component.d.hf.kd xj2 = xj(hfVar, tjVar, i, hfVar4, str, i2, hfVar3);
                if (xj2 == null) {
                    try {
                        hfVar3.xj(-15);
                        hfVar4.xj(-15, c.xj(-15), hfVar3);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        xj(th, hfVar3, hfVar4);
                    }
                }
                try {
                    try {
                        com.bytedance.sdk.component.d.xj.xj xjVar = new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.et.18
                            @Override // com.bytedance.sdk.component.d.xj.xj
                            public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar6) {
                                et.this.xj(uVar, hfVar6, hfVar3, hfVar4, hfVar, tjVar, i, i2);
                            }

                            @Override // com.bytedance.sdk.component.d.xj.xj
                            public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                                et.this.xj(uVar, iOException, hfVar3, hfVar4);
                            }
                        };
                        hfVar3 = hfVar3;
                        hfVar4 = hfVar4;
                        xj2.xj(xjVar);
                        com.bytedance.sdk.openadsdk.core.u.xj().w();
                        xj();
                    } catch (Throwable th3) {
                        th = th3;
                        hfVar3 = hfVar3;
                        hfVar4 = hfVar4;
                        th = th;
                        xj(th, hfVar3, hfVar4);
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            hfVar3 = hfVar5;
            hfVar4 = hfVar2;
        }
    }

    private JSONObject hf(com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar, List<com.bytedance.sdk.openadsdk.zg.w.hf.y> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("action", PointCategory.DISLIKE);
            jSONObject2.put("timestamp", System.currentTimeMillis());
            jSONObject2.put("ad_sdk_version", ai.u);
            com.bytedance.sdk.openadsdk.qt.hf.xj(this.hf, jSONObject2);
            if (hfVar != null) {
                jSONObject2.put(BaseConstants.EVENT_LABEL_EXTRA, hfVar.u());
                if (hfVar.hf() == null) {
                    hfVar.xj(AdnName.OTHER);
                }
                jSONObject2.put("dislike_source", hfVar.hf());
            }
            String xj2 = xj(list);
            if (xj2 != null) {
                jSONObject2.put("comment", xj2);
                list.clear();
            } else {
                jSONObject2.put("comment", (Object) null);
            }
            jSONObject2.put("filter_words", hf(list));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("actions", jSONArray);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONArray hf(List<com.bytedance.sdk.openadsdk.zg.w.hf.y> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator<com.bytedance.sdk.openadsdk.zg.w.hf.y> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().xj());
            }
            return jSONArray;
        }
        return new JSONArray();
    }

    private static String hf(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        String w2 = w(hfVar);
        Map<String, Object> x = f.zg().x();
        if (x != null && !x.isEmpty()) {
            try {
                JSONArray jSONArray = TextUtils.isEmpty(w2) ? new JSONArray() : new JSONArray(w2);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String optString = optJSONObject != null ? optJSONObject.optString("name") : "";
                    if (!TextUtils.isEmpty(optString) && x.containsKey(optString)) {
                        x.remove(optString);
                    }
                }
                for (Map.Entry<String, Object> entry : x.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("name", entry.getKey());
                        jSONObject.put("value", entry.getValue());
                        jSONArray.put(jSONObject);
                    }
                }
                return xj(jSONArray).toString();
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        }
        return w2;
    }

    private static JSONArray hf(JSONArray jSONArray, String str) {
        JSONObject jSONObject;
        try {
            if (TextUtils.equals(Constants.FAIL, str)) {
                jSONObject = new JSONObject();
                jSONObject.put("name", "is_shake_ads");
                jSONObject.put("value", Constants.FAIL);
                f.zg().hf(Constants.FAIL);
            } else {
                jSONObject = null;
            }
            if (jSONObject != null) {
                if (jSONArray != null && jSONArray.length() > 0) {
                    jSONArray.put(jSONArray.length(), jSONObject);
                    return jSONArray;
                }
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(0, jSONObject);
                return jSONArray2;
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(ne neVar, String str, String str2, final dk.w wVar, int i, long j) {
        JSONObject xj2 = xj(neVar, str, str2);
        com.bytedance.sdk.component.d.hf.kd hf2 = com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().hf();
        if (i == 1) {
            hf2.xj(neVar.c());
        } else {
            hf2.xj(neVar.xj());
        }
        hf2.xj(xj2);
        hf2.kd(new HashMap());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.bytedance.sdk.component.utils.f.xj().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.et.10
            @Override // java.lang.Runnable
            public void run() {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                wVar.xj(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN, "time out!");
            }
        }, j);
        hf2.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.et.11
            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                if (hfVar == null) {
                    wVar.xj(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_BUFLEN, "response is null!");
                    return;
                }
                if (!hfVar.f()) {
                    wVar.xj(hfVar.xj(), hfVar.hf());
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(hfVar.u());
                    String optString = jSONObject.optString("message");
                    int optInt = jSONObject.optInt("status", -1);
                    if (optInt != 200) {
                        wVar.xj(optInt, optString);
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject(PointParamKey.DATA);
                    if (optJSONObject != null) {
                        wVar.xj(optJSONObject);
                        return;
                    }
                    wVar.xj(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, optString + ", data is null!");
                } catch (Throwable th) {
                    wVar.xj(MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, th.getMessage());
                }
            }

            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                wVar.xj(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, iOException.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(JSONObject jSONObject, final dk.w<com.bytedance.sdk.component.d.hf> wVar) {
        String xj2 = wo.xj("/api/ad/union/sdk/apply_coupon/v2", false);
        ws wsVar = new ws(com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().y());
        wsVar.xj(xj2);
        wsVar.w(jSONObject, "coupon_apply");
        wsVar.kd(new HashMap());
        wsVar.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.et.16
            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                dk.w wVar2 = wVar;
                if (wVar2 != null) {
                    wVar2.xj(hfVar);
                }
            }

            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                dk.w wVar2 = wVar;
                if (wVar2 != null) {
                    wVar2.xj(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, iOException.getMessage());
                }
            }
        });
    }

    private void xj(JSONObject jSONObject, tj tjVar) {
        JSONArray jSONArray;
        if (tjVar == null || (jSONArray = tjVar.kd) == null) {
            return;
        }
        try {
            jSONObject.put("source_temai_product_ids", jSONArray);
        } catch (Exception unused) {
        }
    }

    private void xj(com.bytedance.sdk.openadsdk.core.ra.hf hfVar, long j, long j2, long j3, long j4) {
        if (hfVar == null) {
            return;
        }
        hfVar.xj(j);
        hfVar.hf(j3);
        hfVar.w(j2);
        hfVar.u(j4);
    }

    private boolean xj(String str, tj tjVar) {
        float u2 = com.bytedance.sdk.openadsdk.core.w.kd.xj().u();
        if (tjVar != null && tjVar.u == 2 && u2 > 0.0f) {
            return w(str);
        }
        return hf(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.dk
    public void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final tj tjVar, final int i, dk.hf hfVar2) {
        final com.bytedance.sdk.openadsdk.core.xj.xj xjVar = new com.bytedance.sdk.openadsdk.core.xj.xj(hfVar2);
        xjVar.xj(i);
        if ((i != 3 || !com.bytedance.sdk.openadsdk.core.component.splash.kd.xj(hfVar)) && Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.tf.c.kd(new com.bytedance.sdk.component.tf.d("get_ad") { // from class: com.bytedance.sdk.openadsdk.core.et.1
                @Override // java.lang.Runnable
                public void run() {
                    et.this.u(hfVar, tjVar, i, xjVar);
                }
            });
        } else {
            u(hfVar, tjVar, i, xjVar);
        }
    }

    public com.bytedance.sdk.openadsdk.core.z.hf xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, com.bytedance.sdk.openadsdk.core.ra.hf hfVar2, tj tjVar, int i, int i2, dk.hf hfVar3) {
        com.bytedance.sdk.openadsdk.core.z.hf hf2;
        com.bytedance.sdk.openadsdk.tools.hf.xj(hfVar);
        boolean z = i2 == 5;
        tjVar.xj("buildAdBodyReady", z);
        JSONObject xj2 = xj(hfVar, tjVar, i, false, i2);
        tjVar.xj("doBuildAdBody", z);
        if (xj2 == null) {
            hfVar2.xj(-9);
            hfVar3.xj(-9, c.xj(-9), hfVar2);
            return null;
        }
        String jSONObject = xj2.toString();
        if (i2 == 5) {
            long currentTimeMillis = System.currentTimeMillis();
            hf2 = com.bytedance.sdk.openadsdk.core.w.y.xj().xj(jSONObject);
            tjVar.xj("encrypt", System.currentTimeMillis() - currentTimeMillis, z);
        } else {
            hf2 = com.bytedance.sdk.openadsdk.core.w.y.xj().hf(jSONObject);
        }
        if (hf2 == null) {
            hfVar2.xj(-9);
            hfVar3.xj(-9, c.xj(-9), hfVar2);
            return null;
        }
        hf2.xj(xj2);
        return hf2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, tj tjVar, int i, dk.hf hfVar2, String str, int i2) {
        hf(hfVar, tjVar, i, hfVar2, str, i2);
    }

    private boolean xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, com.bytedance.sdk.openadsdk.core.ra.hf hfVar2, dk.hf hfVar3, boolean z, tj tjVar, int i) {
        if (hfVar3 == null) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.j.d.xj()) {
            hfVar2.xj(1000);
            hfVar3.xj(1000, "广告请求开关已关闭,请联系穿山甲管理员", hfVar2);
            return true;
        }
        if (!z) {
            return false;
        }
        tjVar.xj("execGetAdReady", z);
        if (!TextUtils.isEmpty(hfVar.pz()) && tjVar.u <= 0) {
            xj(hfVar2, hfVar, hfVar3, tjVar, i);
            com.bytedance.sdk.openadsdk.core.ht.hf.xj();
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (xj(hfVar.u(), tjVar)) {
            hfVar2.xj(-8);
            hfVar3.xj(-8, c.xj(-8), hfVar2);
            u.incrementAndGet();
            com.bytedance.sdk.openadsdk.core.ht.hf.xj();
            return true;
        }
        tjVar.xj("checkCallFreq", System.currentTimeMillis() - currentTimeMillis, z);
        return false;
    }

    private void xj(com.bytedance.sdk.openadsdk.core.ra.hf hfVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar2, final dk.hf hfVar3, tj tjVar, int i) {
        hfVar.w(2);
        hfVar.xj(hfVar2.pz());
        try {
            boolean z = false;
            JSONObject xj2 = com.bytedance.sdk.openadsdk.core.w.y.xj(new JSONObject(hfVar2.pz()), false, true);
            if (xj2 == null) {
                xj(hfVar3, hfVar);
                return;
            }
            xj xj3 = xj.xj(xj2, hfVar2, tjVar);
            hfVar.xj(xj3.tf);
            yo.xj(xj3.d);
            int i2 = xj3.u;
            if (i2 != 20000) {
                hfVar.xj(i2);
                hfVar3.xj(xj3.u, "reason: " + xj3.y + "  message: " + xj3.kd, hfVar);
                return;
            }
            com.bytedance.sdk.openadsdk.core.ra.xj xjVar = xj3.f;
            if (xjVar == null) {
                xj(hfVar3, hfVar);
                return;
            }
            xjVar.xj(xj2);
            List<com.bytedance.sdk.openadsdk.core.ra.ws> hf2 = xj3.f.hf();
            if (hf2 != null) {
                ArrayList arrayList = new ArrayList(hf2);
                for (com.bytedance.sdk.openadsdk.core.ra.ws wsVar : hf2) {
                    com.bytedance.sdk.openadsdk.core.ra.ws xj4 = com.bytedance.sdk.openadsdk.core.a.kd.xj(wsVar.en(), i);
                    if (xj4 != null) {
                        arrayList.remove(wsVar);
                        xj4.q(wsVar.co());
                        arrayList.add(xj4);
                    } else if (wsVar.l()) {
                        final String str = xj3.c;
                        if (!TextUtils.isEmpty(str) && tjVar != null) {
                            tjVar.xj(str);
                        }
                        final String u2 = hfVar2.u();
                        final String xj5 = wo.xj(hfVar2);
                        pz.xj().w(hfVar2, tjVar, i, new dk.hf() { // from class: com.bytedance.sdk.openadsdk.core.et.19
                            @Override // com.bytedance.sdk.openadsdk.core.dk.hf
                            public void xj(int i3, String str2, com.bytedance.sdk.openadsdk.core.ra.hf hfVar4) {
                                com.bytedance.sdk.openadsdk.core.ht.am.xj().xj(i3, str2, str, u2, xj5);
                                hfVar3.xj(i3, str2, hfVar4);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.dk.hf
                            public void xj(com.bytedance.sdk.openadsdk.core.ra.xj xjVar2, com.bytedance.sdk.openadsdk.core.ra.hf hfVar4) {
                                com.bytedance.sdk.openadsdk.core.ht.am.xj().xj(0, cb.o, str, u2, xj5);
                                hfVar3.xj(xjVar2, hfVar4);
                            }
                        });
                        z = true;
                    }
                }
                if (z) {
                    return;
                } else {
                    xj3.f.xj(arrayList);
                }
            }
            hfVar3.xj(xj3.f, hfVar);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.w("NetApiImpl", "get ad error: ", th);
            xj(hfVar3, hfVar);
        }
    }

    private com.bytedance.sdk.component.d.hf.kd xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, tj tjVar, int i, dk.hf hfVar2, String str, int i2, com.bytedance.sdk.openadsdk.core.ra.hf hfVar3) {
        byte[] bytes;
        Map<String, String> xj2;
        com.bytedance.sdk.openadsdk.core.z.hf xj3 = xj(hfVar, hfVar3, tjVar, i, i2, hfVar2);
        if (xj3 == null) {
            return null;
        }
        String xj4 = wo.xj(str, true);
        com.bytedance.sdk.component.d.hf.kd hf2 = com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().hf();
        String xj5 = com.bytedance.sdk.openadsdk.c.w.xj(hf2, xj4);
        hf2.xj(xj5);
        if (xj3.xj() != null) {
            com.bytedance.sdk.openadsdk.c.w.xj(xj3.xj(), 0);
        }
        if (i2 == 5) {
            if (xj3.u() != null) {
                JSONObject u2 = xj3.u();
                hf2.xj(u2);
                bytes = u2.toString().getBytes(StandardCharsets.UTF_8);
                hf2.xj(false);
            } else {
                if (xj3.w() == null) {
                    return null;
                }
                bytes = xj3.w();
                hf2.xj("application/octet-stream", bytes);
                hf2.xj(true);
            }
        } else {
            JSONObject u3 = xj3.u();
            hf2.xj(u3);
            bytes = u3.toString().getBytes(StandardCharsets.UTF_8);
        }
        boolean z = i2 == 5;
        tjVar.xj("doHttpReqSignReady", z);
        com.bytedance.sdk.openadsdk.xj.xj.xj xj6 = com.bytedance.sdk.openadsdk.xj.xj.xj.xj(true);
        tjVar.xj("MSInst", z);
        Map<String, String> xj7 = xj6.xj(xj5, bytes);
        tjVar.xj("doHttpReqSign", z);
        if (xj7 == null) {
            xj7 = new HashMap<>();
        }
        if (i2 == 5 && (xj2 = com.bytedance.sdk.openadsdk.tools.hf.xj(hfVar.u())) != null) {
            xj7.putAll(xj2);
        }
        com.bytedance.sdk.openadsdk.core.a.a.xj(xj7);
        Map<String, String> kd = xj3.kd();
        hf2.hf("User-Agent", com.bytedance.sdk.openadsdk.core.a.tf.g());
        if (kd != null) {
            xj7.putAll(kd);
        }
        if (xj7.size() > 0) {
            for (Map.Entry<String, String> entry : xj7.entrySet()) {
                hf2.hf(entry.getKey(), entry.getValue());
            }
        }
        hf2.kd(xj(bytes, kd, xj3));
        tjVar.xj("appendHeader", z);
        return hf2;
    }

    private Map<String, Object> xj(byte[] bArr, Map<String, String> map, com.bytedance.sdk.openadsdk.core.z.hf hfVar) {
        HashMap hashMap = new HashMap();
        try {
            com.bytedance.sdk.openadsdk.core.z.xj xjVar = new com.bytedance.sdk.openadsdk.core.z.xj();
            xjVar.f(System.currentTimeMillis());
            xjVar.d(bArr == null ? 0L : bArr.length);
            xjVar.w(hfVar.hf());
            if (map != null) {
                xjVar.xj(map.get("x-pglcypher"));
            }
            xjVar.xj(hfVar.xj());
            com.bytedance.sdk.component.u.xj hf2 = com.bytedance.sdk.openadsdk.core.a.dk.hf();
            xjVar.hf(hf2 != null ? hf2.getSpecificArmorLoadStatus() : 0);
            xjVar.xj(pz.hf().zb());
            hashMap.put("load_time_model", xjVar);
        } catch (Exception unused) {
        }
        return hashMap;
    }

    private void xj() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.kd.get() >= 30000) {
            this.kd.set(currentTimeMillis);
            com.bytedance.sdk.component.utils.f.xj().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.et.20
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.j.f.xj((com.bytedance.sdk.openadsdk.core.j.kd) null).w();
                }
            }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException, com.bytedance.sdk.openadsdk.core.ra.hf hfVar, dk.hf hfVar2) {
        com.bytedance.sdk.openadsdk.core.ht.hf.xj();
        if (iOException != null) {
            hfVar.xj(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN);
            hfVar2.xj(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN, iOException.getMessage(), hfVar);
            com.bytedance.sdk.component.utils.pl.xj("NetApiImpl", "onFailure: ", Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE));
        }
    }

    private void xj(Throwable th, com.bytedance.sdk.openadsdk.core.ra.hf hfVar, dk.hf hfVar2) {
        if (hfVar2 != null) {
            hfVar.xj(TTAdConstant.INIT_LOCAL_FAIL_CODE);
            hfVar2.xj(TTAdConstant.INIT_LOCAL_FAIL_CODE, th.getMessage(), hfVar);
            com.bytedance.sdk.component.utils.pl.w("NetApiImpl", " msg = ", th.getMessage());
        }
    }

    private void xj(com.bytedance.sdk.component.d.hf hfVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar2, int i, tj tjVar, dk.hf hfVar3, com.bytedance.sdk.openadsdk.core.ra.hf hfVar4, com.bytedance.sdk.component.d.hf.u uVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str;
        String str2;
        xj xjVar;
        tj tjVar2 = tjVar;
        String str3 = "auction_price";
        if (hfVar != null) {
            if (hfVar.f()) {
                et etVar = this;
                try {
                    com.bytedance.sdk.openadsdk.core.z.xj xj2 = etVar.xj(uVar);
                    long currentTimeMillis = System.currentTimeMillis();
                    String u2 = hfVar.u();
                    hfVar4.xj(u2);
                    LogAdapter logAdapter = LogAdapter.xj;
                    if (logAdapter != null) {
                        logAdapter.u("NetApiImpl", "response:");
                        LogAdapter.xj.u("NetApiImpl", u2);
                    }
                    JSONObject jSONObject3 = new JSONObject(u2);
                    int optInt = jSONObject3.optInt("status_code");
                    String optString = new JSONObject(hfVar2.pz()).optString("auction_price");
                    int i2 = 20000;
                    if (optInt != 20000) {
                        if (optInt == 40046) {
                            hfVar4.xj(optInt);
                            hfVar3.xj(40046, c.xj(optInt), hfVar4);
                            return;
                        }
                        return;
                    }
                    JSONObject optJSONObject = jSONObject3.optJSONObject("adms");
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        JSONObject jSONObject4 = new JSONObject(optJSONObject.optString(keys.next()));
                        jSONObject4.put(str3, optString);
                        JSONObject xj3 = com.bytedance.sdk.openadsdk.core.w.y.xj(jSONObject4, false, true);
                        if (xj3 == null) {
                            xj(hfVar3, hfVar4);
                            return;
                        }
                        xj xj4 = xj.xj(xj3, hfVar2, tjVar2);
                        hfVar4.xj(xj4.tf);
                        int i3 = xj4.u;
                        if (i3 != i2) {
                            hfVar4.xj(i3);
                            hfVar3.xj(xj4.u, "reason: " + xj4.y + "  message: " + xj4.kd, hfVar4);
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.ra.xj xjVar2 = xj4.f;
                        if (xjVar2 == null) {
                            xj(hfVar3, hfVar4);
                            return;
                        }
                        xjVar2.xj(xj3);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (tjVar2 != null) {
                            jSONObject2 = xj3;
                            str2 = str3;
                            xjVar = xj4;
                            jSONObject = optJSONObject;
                            str = optString;
                            etVar.xj(hfVar4, xj2.d() - tjVar2.c, xj4.xj, currentTimeMillis - xj2.d(), currentTimeMillis2 - currentTimeMillis);
                        } else {
                            jSONObject = optJSONObject;
                            jSONObject2 = xj3;
                            str = optString;
                            str2 = str3;
                            xjVar = xj4;
                        }
                        hfVar3.xj(xjVar.f, hfVar4);
                        com.bytedance.sdk.openadsdk.hf.hf.xj().xj(jSONObject2);
                        i2 = 20000;
                        etVar = this;
                        str3 = str2;
                        tjVar2 = tjVar;
                        optString = str;
                        optJSONObject = jSONObject;
                    }
                    return;
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.pl.w("NetApiImpl", "get ad error: ", th);
                    xj(hfVar3, hfVar4);
                    return;
                }
            }
            int xj5 = hfVar.xj();
            String hf2 = hfVar.hf();
            hfVar4.xj(xj5);
            hfVar3.xj(xj5, hf2, hfVar4);
        }
    }

    private void xj(com.bytedance.sdk.component.d.hf hfVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar2, int i, tj tjVar, dk.hf hfVar3, com.bytedance.sdk.openadsdk.core.ra.hf hfVar4) {
        if (hfVar != null) {
            try {
                JSONArray optJSONArray = new JSONObject(hfVar.u()).optJSONArray(com.sigmob.sdk.base.db.a.f13169a);
                if (optJSONArray == null || optJSONArray.length() == 0) {
                    if (hfVar3 != null) {
                        hfVar3.xj(-9, c.xj(-9), hfVar4);
                        return;
                    }
                    return;
                }
                int z = pz.hf().z();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.getJSONObject(i2).optJSONObject("creative");
                    if (optJSONObject != null) {
                        JSONObject xj2 = com.bytedance.sdk.openadsdk.core.w.y.xj(new JSONObject(optJSONObject.optString("adm")), false, true);
                        if (xj2 == null && hfVar3 != null) {
                            hfVar3.xj(-9, c.xj(-9), hfVar4);
                        } else {
                            xj xj3 = xj.xj(xj2, hfVar2, tjVar);
                            com.bytedance.sdk.openadsdk.core.a.kd.xj(xj3.f, i, z);
                            if (hfVar3 != null) {
                                hfVar3.xj(xj3.f, hfVar4);
                            }
                        }
                    } else if (hfVar3 != null) {
                        hfVar3.xj(-9, c.xj(-9), hfVar4);
                    }
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
                if (hfVar3 != null) {
                    hfVar3.xj(-9, c.xj(-9), hfVar4);
                }
            }
        }
    }

    private com.bytedance.sdk.openadsdk.core.z.xj xj(com.bytedance.sdk.component.d.hf.u uVar) {
        try {
            Object obj = uVar.w().get("load_time_model");
            if (obj instanceof com.bytedance.sdk.openadsdk.core.z.xj) {
                com.bytedance.sdk.openadsdk.core.z.xj xjVar = (com.bytedance.sdk.openadsdk.core.z.xj) obj;
                xjVar.w(true);
                return xjVar;
            }
        } catch (Throwable unused) {
        }
        return new com.bytedance.sdk.openadsdk.core.z.xj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar, com.bytedance.sdk.openadsdk.core.ra.hf hfVar2, dk.hf hfVar3, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar4, tj tjVar, int i, int i2) {
        dk.hf hfVar5;
        String str;
        com.bytedance.sdk.openadsdk.core.z.xj xjVar;
        long length;
        int i3;
        JSONObject xj2;
        boolean z;
        boolean z2;
        xj xjVar2;
        tj tjVar2;
        et etVar;
        long length2;
        final JSONObject jSONObject;
        final boolean z3;
        if (hfVar == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!hfVar.f()) {
            int xj3 = hfVar.xj();
            String hf2 = hfVar.hf();
            hfVar2.xj(xj3);
            hfVar3.xj(xj3, hf2, hfVar2);
            com.bytedance.sdk.openadsdk.core.y.hf.hf();
            return;
        }
        if (i2 == 1) {
            xj(hfVar, hfVar4, i, tjVar, hfVar3, hfVar2);
            return;
        }
        if (i2 == 3) {
            xj(hfVar, hfVar4, i, tjVar, hfVar3, hfVar2, uVar);
            return;
        }
        com.bytedance.sdk.openadsdk.core.ra.hf hfVar6 = hfVar2;
        com.bytedance.sdk.openadsdk.core.z.xj xj4 = xj(uVar);
        xj4.y(currentTimeMillis);
        com.bytedance.sdk.openadsdk.core.ht.hf.xj();
        try {
            final String u2 = hfVar.u();
            if (i2 == 5) {
                byte[] tf = hfVar.tf();
                Pair<Boolean, JSONObject> xj5 = com.bytedance.sdk.openadsdk.core.w.y.xj(hfVar, "get_ads", true);
                JSONObject jSONObject2 = (JSONObject) xj5.second;
                boolean booleanValue = ((Boolean) xj5.first).booleanValue();
                if (booleanValue) {
                    length2 = TextUtils.isEmpty(u2) ? 0L : u2.getBytes(StandardCharsets.UTF_8).length;
                    hfVar6.xj(u2);
                } else {
                    length2 = tf == null ? 0L : tf.length;
                }
                if (LogAdapter.xj == null || jSONObject2 == null) {
                    xjVar = xj4;
                    jSONObject = jSONObject2;
                    z3 = booleanValue;
                } else {
                    z3 = booleanValue;
                    xjVar = xj4;
                    jSONObject = jSONObject2;
                    com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("logAdapter") { // from class: com.bytedance.sdk.openadsdk.core.et.23
                        @Override // java.lang.Runnable
                        public void run() {
                            Object obj;
                            try {
                                String str2 = "";
                                if (z3) {
                                    str2 = u2;
                                } else {
                                    Pair<Integer, JSONObject> xj6 = com.bytedance.sdk.openadsdk.core.w.y.xj().xj(jSONObject.toString(), false);
                                    if (xj6 != null && (obj = xj6.second) != null) {
                                        str2 = ((JSONObject) obj).toString();
                                    }
                                }
                                if (LogAdapter.xj == null || TextUtils.isEmpty(str2)) {
                                    return;
                                }
                                LogAdapter.xj.u("NetApiImpl", "response:");
                                LogAdapter.xj.u("NetApiImpl", str2);
                            } catch (Exception e) {
                                com.bytedance.sdk.component.utils.pl.w(e.getMessage());
                            }
                        }
                    });
                }
                xj2 = jSONObject;
                length = length2;
                z = z3;
                i3 = 0;
            } else {
                xjVar = xj4;
                hfVar6.xj(u2);
                LogAdapter logAdapter = LogAdapter.xj;
                if (logAdapter != null) {
                    logAdapter.u("NetApiImpl", "response:");
                    LogAdapter.xj.u("NetApiImpl", u2);
                }
                JSONObject jSONObject3 = new JSONObject(u2);
                length = TextUtils.isEmpty(u2) ? 0L : u2.getBytes(StandardCharsets.UTF_8).length;
                i3 = 0;
                xj2 = com.bytedance.sdk.openadsdk.core.w.y.xj(jSONObject3, false, true);
                z = false;
            }
            com.bytedance.sdk.openadsdk.core.z.xj xjVar3 = xjVar;
            xjVar3.c(length);
            if (xj2 == null) {
                xj(hfVar3, hfVar6);
                return;
            }
            com.bytedance.sdk.openadsdk.c.w.hf(xj2, i3);
            xj xj6 = xj.xj(xj2, hfVar4, tjVar);
            hfVar6.xj(xj6.tf);
            yo.xj(xj6.d);
            int i4 = xj6.u;
            if (i4 != 20000) {
                hfVar6.xj(i4);
                hfVar6.hf(xj6.y);
                hfVar3.xj(xj6.u, "reason: " + xj6.y + "  message: " + xj6.kd, hfVar6);
                return;
            }
            com.bytedance.sdk.openadsdk.core.ra.xj xjVar4 = xj6.f;
            if (xjVar4 == null) {
                xj(hfVar3, hfVar6);
                return;
            }
            xjVar4.xj(xj2);
            xjVar3.hf(System.currentTimeMillis());
            if (tjVar == null) {
                hfVar5 = hfVar3;
                str = "NetApiImpl";
                z2 = z;
                xjVar2 = xj6;
                tjVar2 = tjVar;
                etVar = this;
            } else {
                long d = xjVar3.d() - tjVar.c;
                long j = xj6.xj;
                hfVar5 = hfVar3;
                z2 = z;
                tjVar2 = tjVar;
                str = "NetApiImpl";
                xjVar2 = xj6;
                etVar = this;
                try {
                    etVar.xj(hfVar6, d, j, xjVar3.y() - xjVar3.d(), xjVar3.hf() - xjVar3.y());
                    hfVar6 = hfVar6;
                } catch (Throwable th) {
                    th = th;
                    hfVar6 = hfVar6;
                    com.bytedance.sdk.component.utils.pl.w(str, "get ad error: ", th);
                    xj(hfVar5, hfVar6);
                }
            }
            try {
                hfVar5.xj(xjVar2.f, hfVar6);
                for (com.bytedance.sdk.openadsdk.core.ra.ws wsVar : xjVar2.f.hf()) {
                    if (tjVar2 != null) {
                        wsVar.io(tjVar2.hf());
                        wsVar.rz().xj(tjVar2.xj);
                        wsVar.rz().hf(1);
                    }
                    if (com.bytedance.sdk.openadsdk.kd.xj.xj(wsVar)) {
                        com.bytedance.sdk.openadsdk.upie.hf.xj().xj(etVar.hf, com.bytedance.sdk.openadsdk.kd.xj.d(wsVar));
                    }
                }
                if (xjVar3.pl() && xjVar2.f.hf() != null && !xjVar2.f.hf().isEmpty()) {
                    com.bytedance.sdk.openadsdk.core.ra.ws wsVar2 = xjVar2.f.hf().get(0);
                    com.bytedance.sdk.openadsdk.core.u.xj().xj(wsVar2);
                    String hf3 = wo.hf(i);
                    xjVar3.hf(i2 != 5);
                    xjVar3.xj(i2 != 5 || z2);
                    xjVar3.kd(hfVar.kd());
                    xjVar3.u(hfVar.y());
                    xjVar3.xj(xjVar2.xj);
                    com.bytedance.sdk.component.hf.xj.p p = hfVar.p();
                    if (p != null) {
                        xjVar3.tf(p.xj);
                        xjVar3.p(p.hf);
                        xjVar3.pl(p.w);
                        xjVar3.g(p.u);
                        xjVar3.am(p.kd);
                    }
                    etVar.xj(tjVar2, wsVar2, hf3, xjVar3);
                }
                com.bytedance.sdk.openadsdk.hf.hf.xj().xj(xj2);
                com.bytedance.sdk.openadsdk.core.y.hf.hf();
            } catch (Throwable th2) {
                th = th2;
                com.bytedance.sdk.component.utils.pl.w(str, "get ad error: ", th);
                xj(hfVar5, hfVar6);
            }
        } catch (Throwable th3) {
            th = th3;
            hfVar5 = hfVar3;
            str = "NetApiImpl";
        }
    }

    private void xj(tj tjVar, com.bytedance.sdk.openadsdk.core.ra.ws wsVar, String str, com.bytedance.sdk.openadsdk.core.z.xj xjVar) {
        long j;
        long j2;
        if (pz.hf().gh() && xjVar != null) {
            JSONObject jSONObject = new JSONObject();
            if (tjVar != null) {
                try {
                    if (tjVar.c > 0) {
                        jSONObject.put("client_start_time", xjVar.d() - tjVar.c);
                        j = xjVar.hf() - tjVar.c;
                    } else {
                        j = 0;
                    }
                    if (tjVar.f > 0) {
                        jSONObject.put("real_user_duration", xjVar.hf() - tjVar.f);
                        jSONObject.put("switch_st1_time", tjVar.c - tjVar.f);
                    }
                    j2 = j;
                } catch (Exception unused) {
                    return;
                }
            } else {
                j2 = 0;
            }
            jSONObject.put("net_send_time", xjVar.kd() - xjVar.d());
            jSONObject.put("net_rcv_time", xjVar.u() - xjVar.kd());
            jSONObject.put("net_callback_time", xjVar.y() - xjVar.u());
            jSONObject.put("network_time", xjVar.y() - xjVar.d());
            jSONObject.put("sever_time", xjVar.xj());
            jSONObject.put("client_end_time", xjVar.hf() - xjVar.y());
            if (xjVar.tf() > 0) {
                jSONObject.put("req_body_length", xjVar.tf());
            }
            if (xjVar.f() > 0) {
                jSONObject.put("res_body_length", xjVar.f());
            }
            if (!TextUtils.isEmpty(xjVar.p())) {
                jSONObject.put("x-pglcypher", xjVar.p());
            }
            jSONObject.put("cypher_v", xjVar.yo());
            jSONObject.put("armor_s", xjVar.v());
            long w2 = xjVar.w();
            if (w2 > 0) {
                jSONObject.put("raw_req_length", w2);
            }
            int i = 1;
            jSONObject.put("sdk_parallel_load", 1);
            jSONObject.put("net_module", com.bytedance.sdk.openadsdk.core.w.w.xj().y());
            if (!xjVar.c()) {
                i = 2;
            }
            jSONObject.put("has_base64", i);
            jSONObject.put("req_build_opt", com.bytedance.sdk.openadsdk.core.w.w.xj().c());
            jSONObject.put("is_boost", com.bytedance.sdk.openadsdk.core.u.xj.u());
            jSONObject.put("opt_config", String.valueOf(pz.hf().az()));
            jSONObject.put("report_index", w.getAndIncrement());
            if (xjVar.zg() > 0) {
                jSONObject.put("net_whqueue", xjVar.am() - xjVar.g());
                jSONObject.put("net_wtqueue", xjVar.qt() - xjVar.am());
                jSONObject.put("net_oconn", xjVar.e() - xjVar.zg());
                jSONObject.put("net_bconn", xjVar.zg() - xjVar.qt());
            }
            try {
                JSONObject xj2 = tjVar.am.xj(-1L);
                Iterator<String> keys = xj2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next)) {
                        jSONObject.put(next, xj2.opt(next));
                    }
                }
            } catch (Exception unused2) {
            }
            com.bytedance.sdk.openadsdk.core.am.u.xj(wsVar, str, "load_ad_time", j2, jSONObject);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.dk
    public void xj(com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar, List<com.bytedance.sdk.openadsdk.zg.w.hf.y> list) {
        JSONObject hf2;
        if (com.bytedance.sdk.openadsdk.core.j.d.xj() && (hf2 = hf(hfVar, list)) != null) {
            ws wsVar = new ws(com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().y());
            wsVar.xj(wo.f("/api/ad/union/dislike_event/"));
            wsVar.w(hf2, PointCategory.DISLIKE);
            wsVar.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.et.24
                @Override // com.bytedance.sdk.component.d.xj.xj
                public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar2) {
                }

                @Override // com.bytedance.sdk.component.d.xj.xj
                public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                }
            });
        }
    }

    private String xj(List<com.bytedance.sdk.openadsdk.zg.w.hf.y> list) {
        if (list.get(0).xj().equals("0:00")) {
            return list.get(0).hf();
        }
        return null;
    }

    public static void xj(dk.hf hfVar, com.bytedance.sdk.openadsdk.core.ra.hf hfVar2) {
        hfVar2.xj(-1);
        hfVar.xj(-1, c.xj(-1), hfVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(dk.kd kdVar) {
        kdVar.xj(-1, c.xj(-1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(dk.u uVar) {
        uVar.xj(-1, c.xj(-1));
    }

    private JSONObject xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, int i) {
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject();
        try {
            xj(jSONObject, "keywords", f.zg().dk());
            jSONObject.put("protection_of_minors", f.zg().tj());
            if (!com.bytedance.sdk.openadsdk.core.w.u.xj().c(i)) {
                com.bytedance.sdk.openadsdk.qt.hf.u(this.hf, jSONObject);
            }
            String hf2 = hf(hfVar);
            String xj2 = com.bytedance.sdk.openadsdk.core.w.u.xj().xj(hfVar.u(), "");
            if (!TextUtils.isEmpty(xj2)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("name", "dynamic_slot_ab_extra");
                jSONObject2.putOpt("value", xj2);
                if (TextUtils.isEmpty(hf2)) {
                    jSONArray = new JSONArray();
                } else {
                    jSONArray = new JSONArray(hf2);
                }
                jSONArray.put(jSONObject2);
                String jSONArray2 = jSONArray.toString();
                if (!TextUtils.equals("[]", jSONArray2)) {
                    xj(jSONObject, PointParamKey.DATA, jSONArray2);
                    return jSONObject;
                }
            } else if (!TextUtils.equals("[]", hf2)) {
                xj(jSONObject, PointParamKey.DATA, hf2);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static JSONArray xj(JSONArray jSONArray, String str) {
        JSONObject jSONObject;
        if (str != null) {
            try {
                jSONObject = new JSONObject();
                jSONObject.put("name", "can_use_sensor");
                jSONObject.put("value", str);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            if (jSONArray != null && jSONArray.length() > 0) {
                jSONArray.put(jSONArray.length(), jSONObject);
                return jSONArray;
            }
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(0, jSONObject);
            return jSONArray2;
        }
        return jSONArray;
    }

    private static String xj(String str, String str2) {
        if (str2 != null) {
            if (TextUtils.isEmpty(str)) {
                JSONArray hf2 = hf(xj((JSONArray) null, str2), str2);
                if (hf2 == null) {
                    return null;
                }
                return hf2.toString();
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                boolean z = false;
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null && TextUtils.equals(optJSONObject.optString("name"), "is_shake_ads")) {
                        if (TextUtils.equals(Constants.FAIL, str2)) {
                            optJSONObject.put("value", Constants.FAIL);
                            f.zg().hf(Constants.FAIL);
                        } else {
                            f.zg().hf(optJSONObject.optString("value"));
                        }
                        z = true;
                    }
                }
                if (!z) {
                    jSONArray = hf(jSONArray, str2);
                }
                JSONArray xj2 = xj(jSONArray, str2);
                if (xj2 != null) {
                    return xj2.toString();
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        }
        return str;
    }

    private static JSONArray xj(JSONArray jSONArray) {
        if (ai.c() && jSONArray != null && jSONArray.length() != 0) {
            JSONArray jSONArray2 = new JSONArray();
            int length = jSONArray.length();
            JSONObject jSONObject = null;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    String optString = jSONObject2.optString("name", null);
                    if (!"device_id".equals(optString)) {
                        if ("game_adapter_did".equals(optString)) {
                            jSONObject = jSONObject2;
                        } else {
                            jSONArray2.put(jSONObject2);
                        }
                    }
                }
            }
            if (jSONObject != null) {
                jSONObject.put("name", "device_id");
                jSONArray2.put(jSONObject);
                return jSONArray2;
            }
        }
        return jSONArray;
    }

    private void xj(JSONObject jSONObject, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    private JSONObject xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, int i, tj tjVar) {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, hfVar.u());
            jSONObject.put(MediationConstant.KEY_GM_PRIME_RIT, hfVar.v());
            jSONObject.put("show_seq", hfVar.yo());
            jSONObject.put("adtype", i);
            jSONObject.put("themeStatus", f.zg().wn());
            jSONObject.put("download_type", 0);
            jSONObject.put("show_time", com.bytedance.sdk.openadsdk.core.qt.w.kd().xj(hfVar.u()));
            if (!TextUtils.isEmpty(hfVar.xj()) || !TextUtils.isEmpty(hfVar.hf()) || !TextUtils.isEmpty(hfVar.w()) || com.bytedance.sdk.openadsdk.tools.hf.xj()) {
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(hfVar.xj())) {
                    jSONObject2.put(MediationConstant.EXTRA_ADID, hfVar.xj());
                }
                if (!TextUtils.isEmpty(hfVar.hf())) {
                    jSONObject2.put("creative_id", hfVar.hf());
                }
                if (hfVar.w() != null) {
                    jSONObject2.put(n.m, hfVar.w());
                }
                com.bytedance.sdk.openadsdk.tools.hf.xj(jSONObject2, hfVar.u());
                jSONObject.put("preview_ads", jSONObject2);
            }
            if (com.bytedance.sdk.openadsdk.tools.hf.xj() && f.zg().wa()) {
                com.bytedance.sdk.openadsdk.tools.hf.hf(jSONObject, hfVar.u());
            }
            f.u nb = f.zg().nb();
            if (nb != null && wo.d().equals("com.pangolin_demo.toutiao")) {
                nb.xj(jSONObject);
            }
            int i2 = 1;
            if (i == 3 || i == 4) {
                if (tjVar != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("publisher_timeout_control", tjVar.d);
                    jSONObject3.put("time_out_control", tjVar.tf);
                    jSONObject3.put("time_out", tjVar.p);
                    jSONObject.put("tmax", jSONObject3);
                }
                jSONObject.put("splash_button_type", 1);
            }
            if (tjVar != null) {
                jSONObject.put("render_method", tjVar.y);
                int i3 = tjVar.y;
                if (i3 == 1) {
                    if (u(hfVar)) {
                        xj(i, jSONObject);
                    } else {
                        xj(jSONObject, "accepted_size", hfVar.y(), hfVar.c());
                    }
                } else if (i3 == 2) {
                    if (hfVar.f() > 0.0f && hfVar.d() > 0.0f) {
                        xj(jSONObject, "accepted_size", r.w(this.hf, hfVar.f()), r.w(this.hf, hfVar.d()));
                    }
                    if (u(hfVar)) {
                        xj(i, jSONObject);
                    } else {
                        xj(jSONObject, "accepted_size", hfVar.y(), hfVar.c());
                    }
                }
            } else {
                jSONObject.put("render_method", 1);
                xj(jSONObject, "accepted_size", hfVar.y(), hfVar.c());
            }
            jSONObject.put("ptpl_ids", com.bytedance.sdk.openadsdk.core.w.hf.xj().xj(hfVar.u(), i));
            jSONObject.put("ptpl_ids_v3", com.bytedance.sdk.openadsdk.core.w.hf.xj().hf(hfVar.u(), i));
            jSONObject.put("pos", wo.kd(i));
            jSONObject.put("is_support_dpl", hfVar.tf());
            jSONObject.put("if_support_render_control", hfVar.p() ? 1 : 0);
            jSONObject.put("support_icon_style", (ai.w < 5900 || !hfVar.io()) ? 0 : 1);
            if (i == 3 || i == 4) {
                jSONObject.put("splash_load_type", pz.hf().d(wo.hf(hfVar)));
            }
            if (i == 1 || i == 2) {
                jSONObject.put("is_origin_ad", true);
            }
            if (tjVar != null && (obj = tjVar.f10415pl) != null) {
                jSONObject.put("session_params", obj);
            }
            int pl2 = hfVar.pl();
            if (i == 7) {
                if (com.bytedance.sdk.openadsdk.core.ra.j.xj()) {
                    jSONObject.put("insert_ad_control", 1);
                    jSONObject.put("insert_ad_req_num", com.bytedance.sdk.openadsdk.core.ra.j.kd());
                }
                if (com.bytedance.sdk.openadsdk.core.ra.j.w()) {
                    jSONObject.put("refresh_ad_control", 1);
                    jSONObject.put("refresh_ad_req_num", com.bytedance.sdk.openadsdk.core.ra.j.c());
                }
                if (com.bytedance.sdk.openadsdk.core.ra.j.u()) {
                    jSONObject.put("force_refresh_ad_control", 1);
                    jSONObject.put("refresh_ad_req_num", com.bytedance.sdk.openadsdk.core.ra.j.c());
                }
                pl2 = 1;
            }
            if (i == 8) {
                boolean zg = pz.hf().zg(hfVar.u());
                boolean xj2 = com.bytedance.sdk.openadsdk.core.zg.u.xj(hfVar.u());
                if (!zg) {
                    jSONObject.put("refresh_control", 0);
                } else if (xj2) {
                    jSONObject.put("refresh_control", 0);
                    com.bytedance.sdk.openadsdk.core.ht.am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.et.2
                        @Override // com.bytedance.sdk.openadsdk.p.xj.xj
                        public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                            JSONObject jSONObject4 = new JSONObject();
                            try {
                                jSONObject4.put("cid", "");
                            } catch (JSONException e) {
                                com.bytedance.sdk.component.utils.pl.xj(e);
                            }
                            return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("refresh_max").hf(jSONObject4.toString());
                        }
                    }, "refresh_max");
                } else {
                    jSONObject.put("refresh_control", 1);
                    jSONObject.put("refresh_ad_req_num", pz.hf().mg());
                }
                if (com.bytedance.sdk.openadsdk.core.ra.j.hf()) {
                    jSONObject.put("insert_ad_control", 1);
                    jSONObject.put("insert_ad_req_num", com.bytedance.sdk.openadsdk.core.ra.j.y());
                }
            } else {
                i2 = pl2;
            }
            if (tjVar != null && tjVar.kd != null) {
                i2 = hfVar.pl();
            }
            jSONObject.put(PointParamKey.AD_COUNT, i2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void xj(int i, JSONObject jSONObject) {
        if (hf(i)) {
            xj(jSONObject, "accepted_size", r.u(this.hf), r.kd(this.hf));
        } else {
            xj(jSONObject, "accepted_size", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
    }

    private void xj(JSONObject jSONObject, String str, int i, int i2) {
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            if (i > 0 && i2 > 0) {
                jSONObject2.put(MediaFormat.KEY_WIDTH, i);
                jSONObject2.put(MediaFormat.KEY_HEIGHT, i2);
            } else {
                jSONObject2.put(MediaFormat.KEY_WIDTH, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK);
                jSONObject2.put(MediaFormat.KEY_HEIGHT, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            }
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private void xj(JSONObject jSONObject, String str, float f, float f2) {
        if (f <= 0.0f || f2 < 0.0f) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put(MediaFormat.KEY_WIDTH, (int) f);
            jSONObject2.put(MediaFormat.KEY_HEIGHT, (int) f2);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.dk
    public void xj(JSONObject jSONObject, final dk.kd kdVar) {
        if (!com.bytedance.sdk.openadsdk.core.j.d.xj()) {
            if (kdVar != null) {
                kdVar.xj(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
        } else {
            if (jSONObject == null || kdVar == null) {
                return;
            }
            ws wsVar = new ws(com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().y());
            wsVar.xj(wo.f("/api/ad/union/sdk/reward_video/reward/"));
            wsVar.w(jSONObject, "verify");
            wsVar.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.et.3
                @Override // com.bytedance.sdk.component.d.xj.xj
                public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                    if (hfVar != null) {
                        if (!hfVar.f()) {
                            String xj2 = c.xj(-2);
                            int xj3 = hfVar.xj();
                            if (!hfVar.f() && !TextUtils.isEmpty(hfVar.hf())) {
                                xj2 = hfVar.hf();
                            }
                            kdVar.xj(xj3, xj2);
                            return;
                        }
                        try {
                            Object obj = com.bytedance.sdk.openadsdk.core.w.y.xj(hfVar, "verify", false).second;
                            u xj4 = u.xj(obj != null ? (JSONObject) obj : new JSONObject(hfVar.u()));
                            int i = xj4.xj;
                            if (i != 20000) {
                                kdVar.xj(i, c.xj(i));
                                return;
                            } else if (xj4.w == null) {
                                et.this.xj(kdVar);
                                return;
                            } else {
                                kdVar.xj(xj4);
                                return;
                            }
                        } catch (Exception e) {
                            com.bytedance.sdk.component.utils.pl.xj(e);
                        }
                    }
                    et.this.xj(kdVar);
                }

                @Override // com.bytedance.sdk.component.d.xj.xj
                public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                    kdVar.xj(-2, iOException.getMessage());
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.dk
    public void xj(JSONObject jSONObject, final dk.u uVar) {
        if (!com.bytedance.sdk.openadsdk.core.j.d.xj()) {
            if (uVar != null) {
                uVar.xj(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
        } else {
            if (jSONObject == null || uVar == null) {
                return;
            }
            JSONObject xj2 = com.bytedance.sdk.component.utils.xj.xj(jSONObject);
            com.bytedance.sdk.component.d.hf.kd hf2 = com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().hf();
            hf2.xj(wo.f("/api/ad/union/sdk/reward_video/live_room/reward"));
            hf2.w(xj2.toString());
            hf2.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.et.4
                @Override // com.bytedance.sdk.component.d.xj.xj
                public void xj(com.bytedance.sdk.component.d.hf.u uVar2, com.bytedance.sdk.component.d.hf hfVar) {
                    if (hfVar != null) {
                        if (!hfVar.f() || TextUtils.isEmpty(hfVar.u())) {
                            String xj3 = c.xj(-2);
                            int xj4 = hfVar.xj();
                            if (!hfVar.f() && !TextUtils.isEmpty(hfVar.hf())) {
                                xj3 = hfVar.hf();
                            }
                            uVar.xj(xj4, xj3);
                            return;
                        }
                        try {
                            JSONObject jSONObject2 = new JSONObject(hfVar.u());
                            String w2 = jSONObject2.optInt("cypher", -1) == 3 ? com.bytedance.sdk.component.utils.xj.w(jSONObject2.optString("message")) : null;
                            if (!TextUtils.isEmpty(w2)) {
                                try {
                                    jSONObject2 = new JSONObject(w2);
                                } catch (Throwable unused) {
                                }
                            }
                            w xj5 = w.xj(jSONObject2);
                            int i = xj5.xj;
                            if (i != 20000) {
                                uVar.xj(i, c.xj(i));
                                return;
                            } else if (xj5.w == null) {
                                et.this.xj(uVar);
                                return;
                            } else {
                                uVar.xj(xj5);
                                return;
                            }
                        } catch (JSONException e) {
                            com.bytedance.sdk.component.utils.pl.xj(e);
                        }
                    }
                    et.this.xj(uVar);
                }

                @Override // com.bytedance.sdk.component.d.xj.xj
                public void xj(com.bytedance.sdk.component.d.hf.u uVar2, IOException iOException) {
                    uVar.xj(-2, iOException.getMessage());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ce  */
    @Override // com.bytedance.sdk.openadsdk.core.dk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String xj(com.bytedance.sdk.openadsdk.zg.w.w.hf r12, boolean r13, int r14) {
        /*
            r11 = this;
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            com.bytedance.sdk.openadsdk.core.ra.tj r4 = new com.bytedance.sdk.openadsdk.core.ra.tj
            r4.<init>()
            com.bytedance.sdk.openadsdk.core.ra r8 = r4.am
            int r0 = r12.jk()
            r9 = 3
            if (r9 != r0) goto L19
            long r2 = java.lang.System.currentTimeMillis()
            r4.c = r2
        L19:
            r0 = 2
            if (r13 == 0) goto L1e
            r4.y = r0
        L1e:
            int r13 = r12.zg()
            r10 = 1
            if (r10 == r13) goto L2b
            int r13 = r12.zg()
            if (r0 != r13) goto L2d
        L2b:
            r4.y = r0
        L2d:
            int r13 = r4.y
            if (r13 == r0) goto L41
            com.bytedance.sdk.openadsdk.core.j.tf r13 = com.bytedance.sdk.openadsdk.core.pz.hf()
            java.lang.String r2 = r12.u()
            boolean r13 = r13.tf(r2)
            if (r13 == 0) goto L41
            r4.y = r0
        L41:
            int r13 = r12.jk()
            if (r13 <= 0) goto L4d
            int r13 = r12.jk()
            r5 = r13
            goto L53
        L4d:
            if (r14 <= 0) goto L51
            r5 = r14
            goto L53
        L51:
            r13 = 0
            r5 = 0
        L53:
            r6 = 1
            r7 = 4
            r2 = r11
            r3 = r12
            org.json.JSONObject r12 = r2.xj(r3, r4, r5, r6, r7)
            java.lang.String r13 = "adbody_time"
            r8.hf(r13)
            r11.xj(r3, r4, r5)
            java.lang.String r13 = "prefetch_time"
            r8.hf(r13)
            org.json.JSONObject r13 = new org.json.JSONObject
            r13.<init>()
            java.lang.String r0 = "User-Agent"
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.a.tf.g()     // Catch: java.lang.Exception -> L86
            r13.putOpt(r0, r3)     // Catch: java.lang.Exception -> L86
            java.lang.String r0 = "request_headers_time"
            r8.hf(r0)     // Catch: java.lang.Exception -> L86
            java.lang.String r0 = "header"
            r1.putOpt(r0, r13)     // Catch: java.lang.Exception -> L86
            java.lang.String r13 = "bid_request"
            r1.putOpt(r13, r12)     // Catch: java.lang.Exception -> L86
            goto L8b
        L86:
            r0 = move-exception
            r12 = r0
            com.bytedance.sdk.component.utils.pl.xj(r12)
        L8b:
            java.lang.String r12 = r1.toString()
            com.bytedance.sdk.openadsdk.core.w.y r13 = com.bytedance.sdk.openadsdk.core.w.y.xj()
            android.util.Pair r12 = r13.xj(r12, r10)
            java.lang.String r13 = "encry_time"
            r8.hf(r13)
            com.bytedance.sdk.openadsdk.core.ht.am r13 = com.bytedance.sdk.openadsdk.core.ht.am.xj()     // Catch: java.lang.Throwable -> La4
            r13.xj(r14, r8)     // Catch: java.lang.Throwable -> La4
            goto La5
        La4:
        La5:
            java.lang.String r13 = ""
            if (r12 == 0) goto Lc0
            java.lang.Object r14 = r12.second
            if (r14 == 0) goto Lb5
            org.json.JSONObject r14 = (org.json.JSONObject) r14
            java.lang.String r13 = "message"
            java.lang.String r13 = r14.optString(r13)
        Lb5:
            java.lang.Object r12 = r12.first
            if (r12 == 0) goto Lc0
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            goto Lc1
        Lc0:
            r12 = 3
        Lc1:
            if (r12 == r9) goto Lce
            java.lang.String r12 = java.lang.String.valueOf(r13)
            java.lang.String r13 = "0000000004"
            java.lang.String r12 = r13.concat(r12)
            return r12
        Lce:
            java.lang.String r12 = java.lang.String.valueOf(r13)
            java.lang.String r13 = "0000000003"
            java.lang.String r12 = r13.concat(r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.et.xj(com.bytedance.sdk.openadsdk.zg.w.w.hf, boolean, int):java.lang.String");
    }

    private boolean xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, tj tjVar, int i) {
        boolean xj2 = pz.hf().xj(hfVar.u());
        if (xj2) {
            kd(hfVar, tjVar, i, new dk.hf() { // from class: com.bytedance.sdk.openadsdk.core.et.5
                @Override // com.bytedance.sdk.openadsdk.core.dk.hf
                public void xj(int i2, String str, com.bytedance.sdk.openadsdk.core.ra.hf hfVar2) {
                    com.bytedance.sdk.openadsdk.core.ht.am.xj().xj(i2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.dk.hf
                public void xj(com.bytedance.sdk.openadsdk.core.ra.xj xjVar, com.bytedance.sdk.openadsdk.core.ra.hf hfVar2) {
                    com.bytedance.sdk.openadsdk.core.ht.am.xj().xj(0);
                }
            });
        }
        return xj2;
    }

    private void xj(boolean z, JSONObject jSONObject, String str) {
        String xj2 = com.bytedance.sdk.openadsdk.core.component.reward.xj.xj.xj.xj().xj(z, str);
        String str2 = Constants.FAIL;
        String str3 = null;
        if (xj2 != null && !TextUtils.isEmpty(xj2)) {
            if (TextUtils.equals(xj2, Constants.FAIL)) {
                str3 = Constants.FAIL;
            } else if (TextUtils.equals(xj2, "1")) {
                str3 = "1";
            } else {
                JSONObject jSONObject2 = new JSONObject(xj2);
                jSONObject.putOpt("cache_info", jSONObject2);
                str2 = jSONObject2.optString("req_id");
            }
        }
        com.bytedance.sdk.openadsdk.core.ht.am.xj().xj(str, str2, str3, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.dk
    public String xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        return xj(hfVar, false, -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.dk
    public void xj(String str, String str2, final dk.xj xjVar) {
        if (!com.bytedance.sdk.openadsdk.core.j.d.xj()) {
            if (xjVar != null) {
                xjVar.xj(false, -1L, 0L);
                return;
            }
            return;
        }
        if (str == null || str2 == null || xjVar == null) {
            return;
        }
        JSONObject xj2 = com.bytedance.sdk.openadsdk.core.kd.hf.w.xj(str, str2);
        ws wsVar = new ws(com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().y());
        String f = wo.f("/api/ad/union/sdk/material/check/");
        try {
            if (TextUtils.isEmpty(new URL(f).getQuery())) {
                f = f + "?abort_aes=1";
            } else {
                f = f + "&abort_aes=1";
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        wsVar.xj(f);
        wsVar.w(xj2, "check_ad");
        wsVar.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.et.6
            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                long j;
                boolean z;
                if (hfVar != null) {
                    if (!hfVar.f()) {
                        xjVar.xj(false, hfVar.xj() != 0 ? hfVar.xj() : -1L, hfVar.d());
                        return;
                    }
                    if (hfVar.u() != null) {
                        try {
                            hf xj3 = hf.xj(new JSONObject(hfVar.u()));
                            r1 = xj3.xj;
                            j = r1;
                            z = xj3.hf;
                        } catch (JSONException e2) {
                            com.bytedance.sdk.component.utils.pl.xj(e2);
                        }
                        xjVar.xj(z, j, hfVar.d());
                    }
                    j = r1;
                    z = false;
                    xjVar.xj(z, j, hfVar.d());
                }
            }

            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                xjVar.xj(false, 0L, 0L);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.dk
    public void xj(JSONObject jSONObject, final com.bytedance.sdk.openadsdk.core.kd.hf.hf hfVar) {
        if (hfVar == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        ws wsVar = new ws(com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().y());
        String f = wo.f("/api/ad/union/sdk/material/cali/");
        try {
            if (TextUtils.isEmpty(new URL(f).getQuery())) {
                f = f + "?abort_aes=1";
            } else {
                f = f + "&abort_aes=1";
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        wsVar.xj(f);
        wsVar.w(jSONObject, "checkAndCorrectAd");
        wsVar.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.et.7
            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar2) {
                long j;
                if (hfVar2 != null) {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (hfVar2.f()) {
                        try {
                            Object obj = com.bytedance.sdk.openadsdk.core.w.y.xj(hfVar2, "checkAndCorrectAd", false).second;
                            com.bytedance.sdk.openadsdk.core.kd.hf.u uVar2 = null;
                            JSONObject jSONObject2 = obj != null ? (JSONObject) obj : null;
                            if (jSONObject2 != null) {
                                try {
                                    uVar2 = com.bytedance.sdk.openadsdk.core.kd.hf.u.xj(jSONObject2);
                                    j = uVar2 != null ? uVar2.xj : -1L;
                                } catch (Exception e2) {
                                    com.bytedance.sdk.component.utils.pl.xj(e2);
                                }
                                hfVar.xj(uVar2, j, currentTimeMillis2);
                                return;
                            }
                            j = -1;
                            hfVar.xj(uVar2, j, currentTimeMillis2);
                            return;
                        } catch (Exception unused) {
                        }
                    }
                    hfVar.xj(null, hfVar2.xj() != 0 ? hfVar2.xj() : -1L, currentTimeMillis2);
                }
            }

            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                hfVar.xj(null, -1L, 0L);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.dk
    public com.bytedance.sdk.component.adexpress.xj.w.xj xj(int i) {
        String rg;
        if (!com.bytedance.sdk.openadsdk.core.j.d.xj()) {
            return null;
        }
        if (i == 2) {
            rg = pz.hf().t();
        } else {
            rg = pz.hf().rg();
        }
        if (TextUtils.isEmpty(rg)) {
            return null;
        }
        com.bytedance.sdk.component.d.hf.w w2 = com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().w();
        w2.xj(com.bytedance.sdk.openadsdk.core.a.a.hf(rg));
        com.bytedance.sdk.component.d.hf xj2 = w2.xj();
        if (xj2 != null) {
            try {
                if (xj2.f()) {
                    if (i == 2) {
                        return com.bytedance.sdk.openadsdk.core.ugeno.y.hf.kd(xj2.u());
                    }
                    return com.bytedance.sdk.component.adexpress.xj.w.xj.u(xj2.u());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dk
    public com.bytedance.sdk.openadsdk.core.ra.u xj(final com.bytedance.sdk.openadsdk.core.ra.ws wsVar, String str) {
        String str2;
        String str3;
        Object obj;
        if (wsVar != null) {
            str2 = wsVar.ka();
            com.bytedance.sdk.openadsdk.core.ra.kd vh = wsVar.vh();
            com.bytedance.sdk.openadsdk.core.ra.y ut = wsVar.ut();
            str3 = ut != null ? ut.g() : null;
            if (TextUtils.isEmpty(str3) && vh != null) {
                str3 = vh.u();
            }
            Map<String, Object> pu = wsVar.pu();
            if (TextUtils.isEmpty(str3) && pu != null && (obj = pu.get("ad_package_name")) != null) {
                str3 = obj.toString();
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = wsVar.hf;
            }
        } else {
            str2 = null;
            str3 = null;
        }
        com.bytedance.sdk.component.d.hf.w w2 = com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().w();
        w2.xj("https://" + pz.hf().k() + "/customer/api/app/pkg_info");
        w2.xj("convert_id", str2);
        w2.xj(n.p, str3);
        w2.xj("download_url", com.bytedance.sdk.openadsdk.x.f.hf(str));
        StringBuilder sb = new StringBuilder();
        A2egSU.BIYEnU(sb, str2, "_", str3, "_");
        sb.append(str);
        String sb2 = sb.toString();
        com.bytedance.sdk.openadsdk.core.ra.u xj2 = com.bytedance.sdk.openadsdk.core.pl.xj.xj(sb2);
        if (xj2 != null) {
            return xj2;
        }
        final com.bytedance.sdk.component.d.hf[] hfVarArr = {null};
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        w2.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.et.8
            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                hfVarArr[0] = hfVar;
                countDownLatch.countDown();
            }

            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(final com.bytedance.sdk.component.d.hf.u uVar, final IOException iOException) {
                countDownLatch.countDown();
                com.bytedance.sdk.openadsdk.core.ht.am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.et.8.1
                    @Override // com.bytedance.sdk.openadsdk.p.xj.xj
                    public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                        JSONObject jSONObject = new JSONObject();
                        com.bytedance.sdk.component.d.hf.u uVar2 = uVar;
                        if (uVar2 != null) {
                            jSONObject.putOpt("net_extra", uVar2.u());
                        }
                        IOException iOException2 = iOException;
                        if (iOException2 != null) {
                            jSONObject.putOpt("io_error", iOException2.getMessage());
                        }
                        com.bytedance.sdk.openadsdk.core.ht.xj.hf<com.bytedance.sdk.openadsdk.core.ht.xj.hf> hf2 = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf();
                        com.bytedance.sdk.openadsdk.core.ra.ws wsVar2 = wsVar;
                        return hf2.f(wsVar2 != null ? wsVar2.jf() : "").xj("pkg_info_failed").hf(jSONObject.toString());
                    }
                }, "pkg_info_failed");
            }
        });
        try {
            countDownLatch.await(2L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        try {
            com.bytedance.sdk.component.d.hf hfVar = hfVarArr[0];
            if (hfVar != null && hfVar.f() && !TextUtils.isEmpty(hfVarArr[0].u()) && new JSONObject(hfVarArr[0].u()).optInt(PluginConstants.KEY_ERROR_CODE, -1) == 0) {
                com.bytedance.sdk.openadsdk.core.ra.u uVar = new com.bytedance.sdk.openadsdk.core.ra.u(new JSONObject(hfVarArr[0].u()));
                com.bytedance.sdk.openadsdk.core.pl.xj.xj(sb2, uVar);
                return uVar;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dk
    public void xj(final ne neVar, final String str, final String str2, final dk.w wVar, final int i, final long j) {
        if (wVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("get_wlink") { // from class: com.bytedance.sdk.openadsdk.core.et.9
                @Override // java.lang.Runnable
                public void run() {
                    et.this.hf(neVar, str, str2, wVar, i, j);
                }
            });
        } else {
            hf(neVar, str, str2, wVar, i, j);
        }
    }

    private JSONObject xj(ne neVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adv_id", neVar.w());
            jSONObject.put("site_id", neVar.u());
            jSONObject.put("page_url", str);
            jSONObject.put("log_extra", str2);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dk
    public void xj(String str) {
        u(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.dk
    public void xj(final JSONObject jSONObject, final dk.w<com.bytedance.sdk.component.d.hf> wVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.tf.c.xj().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.et.13
                @Override // java.lang.Runnable
                public void run() {
                    et.this.hf(jSONObject, (dk.w<com.bytedance.sdk.component.d.hf>) wVar);
                }
            });
        } else {
            hf(jSONObject, wVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.dk
    public void xj(final Function<SparseArray<Object>, Object> function) {
        com.bytedance.sdk.component.d.hf.kd hf2 = com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().hf();
        hf2.xj("https://" + f.zg().gh() + "/ad_union_qa/sdk/query_config_list");
        hf2.hf("x-pglcypher", "4");
        hf2.hf("x-ad-sdk-version", ai.u);
        hf2.hf("x-plugin-version", "7.1.3.2");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PluginConstants.KEY_APP_ID, f.zg().pz());
            jSONObject.put("os", "android");
            jSONObject.put("ad_sdk_version", ai.u);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.3.2");
        } catch (Throwable unused) {
        }
        byte[] xj2 = com.bytedance.sdk.openadsdk.core.a.g.xj(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
        final com.bytedance.sdk.component.u.xj hf3 = com.bytedance.sdk.openadsdk.core.a.dk.hf();
        if (hf3 == null) {
            xj(function, -4, "armor service init fail");
        } else {
            hf2.xj("application/octet-stream", hf3.encrypt(xj2));
            hf2.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.et.14
                @Override // com.bytedance.sdk.component.d.xj.xj
                public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                    Function function2 = function;
                    if (function2 == null || hfVar == null) {
                        et.this.xj((Function<SparseArray<Object>, Object>) function2, -1, "response is null");
                        return;
                    }
                    String hf4 = com.bytedance.sdk.openadsdk.core.a.g.hf((TextUtils.equals(hfVar.w().get("content-type"), "application/octet-stream") || TextUtils.equals(hfVar.w().get("x-pglcypher"), "4")) ? hf3.decrypt(hfVar.tf()) : hfVar.u().getBytes());
                    if (TextUtils.isEmpty(hf4)) {
                        et.this.xj((Function<SparseArray<Object>, Object>) function, -3, "response unGzipStr is null");
                        return;
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject(hf4);
                        int optInt = jSONObject2.optInt(PluginConstants.KEY_ERROR_CODE, -1);
                        String optString = jSONObject2.optString("message");
                        if (optInt != 0) {
                            et.this.xj((Function<SparseArray<Object>, Object>) function, optInt, optString);
                            return;
                        }
                        String optString2 = jSONObject2.optString(PointParamKey.DATA);
                        if (TextUtils.isEmpty(optString2)) {
                            et.this.xj((Function<SparseArray<Object>, Object>) function, optInt, "response data is empty");
                        } else {
                            et.this.xj((Function<SparseArray<Object>, Object>) function, optString2);
                        }
                    } catch (JSONException unused2) {
                        et.this.xj((Function<SparseArray<Object>, Object>) function, -1, "response create json error");
                    }
                }

                @Override // com.bytedance.sdk.component.d.xj.xj
                public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                    et.this.xj((Function<SparseArray<Object>, Object>) function, -2, "response onFailure");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(Function<SparseArray<Object>, Object> function, String str) {
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(10000).xj(Void.class).xj(0, str).hf());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(Function<SparseArray<Object>, Object> function, int i, String str) {
        if (function != null) {
            function.apply(A2egSU.AZOQYO(10001, Void.class).xj(0, Integer.valueOf(i)).xj(1, str).hf());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.dk
    public void xj(final Map<String, Object> map, final Function<SparseArray<Object>, Object> function) {
        if (map == null || map.size() == 0) {
            return;
        }
        com.bytedance.sdk.component.d.hf.kd hf2 = com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().hf();
        hf2.xj("https://" + f.zg().gh() + "/ad_union_qa/sdk/get_ad_config");
        hf2.hf("x-pglcypher", "4");
        hf2.hf("x-ad-sdk-version", ai.u);
        hf2.hf("x-plugin-version", "7.1.3.2");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PluginConstants.KEY_APP_ID, f.zg().pz());
            jSONObject.put("os", "android");
            jSONObject.put("ad_sdk_version", ai.u);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.3.2");
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            byte[] xj2 = com.bytedance.sdk.openadsdk.core.a.g.xj(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
            final com.bytedance.sdk.component.u.xj hf3 = com.bytedance.sdk.openadsdk.core.a.dk.hf();
            if (hf3 == null) {
                xj(function, -4, "armor service init fail");
            } else {
                hf2.xj("application/octet-stream", hf3.encrypt(xj2));
                hf2.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.et.15
                    @Override // com.bytedance.sdk.component.d.xj.xj
                    public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                        String hf4;
                        int i = -1;
                        if (hfVar == null) {
                            et.this.xj((Function<SparseArray<Object>, Object>) function, -1, "response is null");
                            return;
                        }
                        String str = hfVar.w().get("content-type");
                        String str2 = hfVar.w().get("x-pglcypher");
                        String str3 = "";
                        if (TextUtils.equals(str, "application/octet-stream") || TextUtils.equals(str2, "4")) {
                            hf4 = com.bytedance.sdk.openadsdk.core.a.g.hf(hf3.decrypt(hfVar.tf()));
                            if (TextUtils.isEmpty(hf4)) {
                                str3 = "data is null";
                            } else {
                                PluginValueSet hf5 = com.bytedance.sdk.openadsdk.zg.w.hf(function);
                                if (!TextUtils.isEmpty(hf4) && function != null && hf5 != null && TextUtils.equals((CharSequence) hf5.objectValue(0, String.class), "GetAdConfigImpl")) {
                                    f.zg().xj(new f.u(map, hf4));
                                }
                                i = 0;
                            }
                        } else {
                            try {
                                JSONObject jSONObject2 = new JSONObject(hfVar.u());
                                i = jSONObject2.optInt(PluginConstants.KEY_ERROR_CODE);
                                String optString = jSONObject2.optString("message");
                                try {
                                    str3 = jSONObject2.optString(PointParamKey.DATA);
                                    PluginValueSet hf6 = com.bytedance.sdk.openadsdk.zg.w.hf(function);
                                    if (!TextUtils.isEmpty(str3) && function != null && hf6 != null && TextUtils.equals((CharSequence) hf6.objectValue(0, String.class), "GetAdConfigImpl")) {
                                        f.zg().xj(new f.u(map, str3));
                                    }
                                } catch (JSONException unused) {
                                }
                                String str4 = str3;
                                str3 = optString;
                                hf4 = str4;
                            } catch (JSONException unused2) {
                                hf4 = "";
                            }
                        }
                        if (i == 0) {
                            et.this.xj((Function<SparseArray<Object>, Object>) function, hf4);
                        } else {
                            et.this.xj((Function<SparseArray<Object>, Object>) function, i, str3);
                        }
                    }

                    @Override // com.bytedance.sdk.component.d.xj.xj
                    public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                        et.this.xj((Function<SparseArray<Object>, Object>) function, -2, "response onFailure");
                    }
                });
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
