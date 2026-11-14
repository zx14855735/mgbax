package com.kwad.components.core.request.model;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.l.a.d;
import com.kwad.sdk.l.a.e;
import com.kwad.sdk.l.a.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bj;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.cd;
import com.kwad.sdk.utils.r;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class b implements com.kwad.sdk.core.b {
    private String Mk;
    private int QI;
    private int aaX;
    private String aaY;
    private Long aaZ;
    private Long aba;
    private Long abb;
    private Long abc;
    private String abd;
    private String abe;
    private long abg;
    private String abh;
    private long abi;
    private String abk;
    private String abl;
    private boolean abm;
    private List<a> abn;
    private f abo;
    private d abp;
    private com.kwad.sdk.l.a.b abq;
    private List<e> abr;
    private List<cd.a> abf = new CopyOnWriteArrayList();
    private int abj = -1;
    private float screenBrightness = -1.0f;
    private int QL = -1;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int abs = -1;
        public int abt = -1;
        public int abu = -1;
        public int streamType;

        private a(int i) {
            this.streamType = i;
        }

        public static List<a> aF(Context context) {
            int streamMinVolume;
            ArrayList arrayList = new ArrayList();
            if (context != null && !com.kwad.sdk.core.config.e.ai(256L)) {
                try {
                    AudioManager audioManager = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO);
                    if (audioManager != null) {
                        for (int i = 0; i <= 5; i++) {
                            a aVar = new a(i);
                            int bn = bn(i);
                            aVar.abu = audioManager.getStreamVolume(bn);
                            aVar.abs = audioManager.getStreamMaxVolume(bn);
                            if (Build.VERSION.SDK_INT >= 28) {
                                streamMinVolume = audioManager.getStreamMinVolume(bn);
                                aVar.abt = streamMinVolume;
                            }
                            arrayList.add(aVar);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return arrayList;
        }

        private static int bn(int i) {
            if (i == 0) {
                return 0;
            }
            int i2 = 1;
            if (i != 1) {
                i2 = 2;
                if (i != 2) {
                    i2 = 3;
                    if (i != 3) {
                        i2 = 4;
                        if (i != 4) {
                            i2 = 5;
                            if (i != 5) {
                                return 0;
                            }
                        }
                    }
                }
            }
            return i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041 A[Catch: Exception -> 0x0044, TryCatch #0 {Exception -> 0x0044, blocks: (B:5:0x001e, B:7:0x0024, B:13:0x0037, B:15:0x0041, B:19:0x0048, B:23:0x004e, B:26:0x0054), top: B:4:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void aE(android.content.Context r7) {
        /*
            r6 = this;
            r0 = 512(0x200, double:2.53E-321)
            boolean r0 = com.kwad.sdk.core.config.e.ai(r0)
            if (r0 == 0) goto L9
            goto L5a
        L9:
            android.content.IntentFilter r0 = new android.content.IntentFilter
            r0.<init>()
            java.lang.String r1 = "android.intent.action.ACTION_POWER_CONNECTED"
            r0.addAction(r1)
            java.lang.String r1 = "android.intent.action.ACTION_POWER_DISCONNECTED"
            r0.addAction(r1)
            java.lang.String r1 = "android.intent.action.BATTERY_CHANGED"
            r0.addAction(r1)
            r1 = 0
            android.content.Intent r7 = r7.registerReceiver(r1, r0)     // Catch: java.lang.Exception -> L44
            if (r7 == 0) goto L5a
            java.lang.String r0 = "status"
            r1 = -1
            int r0 = r7.getIntExtra(r0, r1)     // Catch: java.lang.Exception -> L44
            r2 = 0
            r3 = 1
            r4 = 2
            if (r0 == r4) goto L36
            r5 = 5
            if (r0 != r5) goto L34
            goto L36
        L34:
            r0 = 0
            goto L37
        L36:
            r0 = 1
        L37:
            r6.abm = r0     // Catch: java.lang.Exception -> L44
            java.lang.String r0 = "plugged"
            int r7 = r7.getIntExtra(r0, r1)     // Catch: java.lang.Exception -> L44
            if (r7 != r4) goto L46
            r6.QL = r3     // Catch: java.lang.Exception -> L44
            return
        L44:
            r7 = move-exception
            goto L57
        L46:
            if (r7 != r3) goto L4b
            r6.QL = r4     // Catch: java.lang.Exception -> L44
            return
        L4b:
            r0 = 4
            if (r7 != r0) goto L52
            r7 = 3
            r6.QL = r7     // Catch: java.lang.Exception -> L44
            return
        L52:
            if (r7 != 0) goto L5a
            r6.QL = r2     // Catch: java.lang.Exception -> L44
            return
        L57:
            com.kwad.sdk.core.d.c.printStackTrace(r7)
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.request.model.b.aE(android.content.Context):void");
    }

    private static Context getContext() {
        return ServiceProvider.Re();
    }

    public static b tS() {
        b bVar = new b();
        bVar.aaX = br.TJ();
        bVar.aaY = AbiUtil.cy(getContext());
        bVar.QI = br.ed(getContext());
        bVar.aaZ = Long.valueOf(br.ee(getContext()));
        bVar.aba = Long.valueOf(br.ea(getContext()));
        bVar.abb = Long.valueOf(br.TG());
        bVar.abc = Long.valueOf(br.TH());
        bVar.abd = bd.dF(getContext());
        bVar.abe = bd.dG(getContext());
        bVar.abf.addAll(bd.o(getContext(), 15));
        bVar.abg = br.TO();
        bVar.abi = br.TP();
        bVar.abl = br.TQ();
        bVar.abk = br.TR();
        bVar.Mk = br.TS();
        bVar.abh = br.TT();
        Context context = getContext();
        if (context != null) {
            bVar.abj = br.el(context);
            bVar.abn = new CopyOnWriteArrayList(a.aF(context));
            bVar.aE(context);
        }
        bVar.abp = r.RF();
        bVar.abq = bd.QD();
        bVar.abr = bj.Tp().Tq();
        bVar.abo = bd.QE();
        return bVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "cpuCount", this.aaX);
        aa.putValue(jSONObject, "cpuAbi", this.aaY);
        aa.putValue(jSONObject, "batteryPercent", this.QI);
        aa.putValue(jSONObject, "totalMemorySize", this.aaZ.longValue());
        aa.putValue(jSONObject, "availableMemorySize", this.aba.longValue());
        aa.putValue(jSONObject, "totalDiskSize", this.abb.longValue());
        aa.putValue(jSONObject, "availableDiskSize", this.abc.longValue());
        aa.putValue(jSONObject, "imsi", this.abd);
        aa.putValue(jSONObject, "iccid", this.abe);
        aa.putValue(jSONObject, "wifiList", this.abf);
        aa.putValue(jSONObject, "bootTime", this.abg);
        aa.putValue(jSONObject, "romName", this.Mk);
        aa.putValue(jSONObject, "romVersion", this.abh);
        aa.putValue(jSONObject, "romBuildTimestamp", this.abi);
        aa.putValue(jSONObject, "ringerMode", this.abj);
        aa.putValue(jSONObject, "audioStreamInfo", this.abn);
        aa.putValue(jSONObject, "baseBandVersion", this.abk);
        aa.putValue(jSONObject, "fingerPrint", this.abl);
        aa.putValue(jSONObject, "screenBrightness", this.screenBrightness);
        aa.putValue(jSONObject, "isCharging", this.abm);
        aa.putValue(jSONObject, "chargeType", this.QL);
        f fVar = this.abo;
        if (fVar != null) {
            aa.a(jSONObject, "simCardInfo", fVar);
        }
        d dVar = this.abp;
        if (dVar != null) {
            aa.a(jSONObject, "environmentInfo", dVar);
        }
        com.kwad.sdk.l.a.b bVar = this.abq;
        if (bVar != null) {
            aa.a(jSONObject, "baseStationInfo", bVar);
        }
        List<e> list = this.abr;
        if (list != null) {
            aa.putValue(jSONObject, "sensorEventInfoList", list);
        }
        return jSONObject;
    }
}
