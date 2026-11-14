package com.octopus.ad.internal.network;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.baidu.mobads.sdk.internal.an;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.octopus.ad.AdRequest;
import com.octopus.ad.R;
import com.octopus.ad.internal.d;
import com.octopus.ad.internal.e;
import com.octopus.ad.internal.l;
import com.octopus.ad.internal.o;
import com.octopus.ad.internal.q;
import com.octopus.ad.internal.utilities.DeviceInfoUtil;
import com.octopus.ad.internal.utilities.HaoboLog;
import com.octopus.ad.internal.utilities.HashingFunctions;
import com.octopus.ad.internal.utilities.LocationInfoUtil;
import com.octopus.ad.internal.utilities.UserEnvInfoUtil;
import com.octopus.ad.internal.utilities.WebviewUtil;
import com.octopus.ad.internal.view.SplashAdViewImpl;
import com.octopus.ad.utils.ThreadUtils;
import com.octopus.ad.utils.b.f;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private SoftReference<e> f12502a;
    private String d;
    private d e;
    private String f;
    private int g;
    private long h;
    private HttpURLConnection i;
    private InputStream j;
    private OutputStream k;
    private static final ServerResponse c = new ServerResponse(true);
    public static final String b = HashingFunctions.md5("emulator");

    /* renamed from: com.octopus.ad.internal.network.a$a, reason: collision with other inner class name */
    public static final class C0411a {
        private Date d;
        private String e;
        private String h;
        private boolean j;

        /* renamed from: a, reason: collision with root package name */
        private final HashSet<String> f12505a = new HashSet<>();
        private final Bundle b = new Bundle();
        private final HashSet<String> c = new HashSet<>();
        private int f = -1;
        private boolean g = false;
        private int i = -1;

        public void a(String str) {
            this.f12505a.add(str);
        }

        public void b(String str) {
            this.c.add(str);
        }

        public void c(String str) {
            this.e = str;
        }

        public void d(String str) {
            this.h = str;
        }

        public void a(Class<? extends Object> cls, Bundle bundle) {
            this.b.putBundle(cls.getName(), bundle);
        }

        public void b(boolean z) {
            this.j = z;
        }

        public void a(Date date) {
            this.d = date;
        }

        public void a(int i) {
            this.f = i;
        }

        public void a(boolean z) {
            this.i = z ? 1 : 0;
        }
    }

    static {
        AAdR();
    }

    public a() {
    }

    private static /* synthetic */ void AAdR() {
        char[] charArray = "S_]\u001eWQ]U\u001eR_I\u001eCXU\\\\\u001ez^YrBYTWU".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '0');
        }
        String str = new String(charArray);
        char[] charArray2 = "S\\Y^YD".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '0');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void m() {
        f.c("OctopusAd_Time", "开始请求封装参数");
        this.h = System.currentTimeMillis();
        e eVar = this.f12502a.get();
        final Context j = q.a().j();
        if (j == null || eVar == null) {
            return;
        }
        d b2 = eVar.b();
        this.e = b2;
        if (b2 != null) {
            b2.b(this.h);
            o.a(new l("REQ", this.e.c(), this.e.e()));
            ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.octopus.ad.internal.network.a.1
                /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
                    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r9v27 java.lang.String, still in use, count: 2, list:
                      (r9v27 java.lang.String) from 0x029b: INVOKE (r9v27 java.lang.String) STATIC call: android.text.TextUtils.isEmpty(java.lang.CharSequence):boolean A[Catch: all -> 0x0105, Exception -> 0x012e, MD:(java.lang.CharSequence):boolean (c), TRY_LEAVE, WRAPPED] (LINE:77)
                      (r9v27 java.lang.String) from 0x02ac: PHI (r9v11 java.lang.String) = (r9v10 java.lang.String), (r9v27 java.lang.String) binds: [B:152:0x02aa, B:17:0x029f] A[DONT_GENERATE, DONT_INLINE]
                    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
                    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
                    	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:114)
                    	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
                    	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:45)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:67)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                    	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1093)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                    	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1093)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                    	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1093)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                    	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1093)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
                    	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:35)
                    	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:34)
                    	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
                    */
                /* JADX WARN: Removed duplicated region for block: B:101:0x073b A[Catch: Exception -> 0x0731, TryCatch #12 {Exception -> 0x0731, blocks: (B:96:0x071f, B:98:0x0727, B:99:0x0733, B:101:0x073b, B:102:0x0744, B:104:0x074c), top: B:95:0x071f }] */
                /* JADX WARN: Removed duplicated region for block: B:104:0x074c A[Catch: Exception -> 0x0731, TRY_LEAVE, TryCatch #12 {Exception -> 0x0731, blocks: (B:96:0x071f, B:98:0x0727, B:99:0x0733, B:101:0x073b, B:102:0x0744, B:104:0x074c), top: B:95:0x071f }] */
                /* JADX WARN: Removed duplicated region for block: B:107:? A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:129:0x06e7 A[Catch: Exception -> 0x06f1, TryCatch #11 {Exception -> 0x06f1, blocks: (B:127:0x06df, B:129:0x06e7, B:130:0x06f3, B:132:0x06fb, B:133:0x0704, B:135:0x070c), top: B:126:0x06df }] */
                /* JADX WARN: Removed duplicated region for block: B:132:0x06fb A[Catch: Exception -> 0x06f1, TryCatch #11 {Exception -> 0x06f1, blocks: (B:127:0x06df, B:129:0x06e7, B:130:0x06f3, B:132:0x06fb, B:133:0x0704, B:135:0x070c), top: B:126:0x06df }] */
                /* JADX WARN: Removed duplicated region for block: B:135:0x070c A[Catch: Exception -> 0x06f1, TRY_LEAVE, TryCatch #11 {Exception -> 0x06f1, blocks: (B:127:0x06df, B:129:0x06e7, B:130:0x06f3, B:132:0x06fb, B:133:0x0704, B:135:0x070c), top: B:126:0x06df }] */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0156  */
                /* JADX WARN: Removed duplicated region for block: B:151:0x02a2 A[Catch: Exception -> 0x012e, all -> 0x06a7, TRY_ENTER, TryCatch #2 {Exception -> 0x012e, blocks: (B:11:0x0148, B:14:0x0159, B:16:0x0297, B:18:0x02ad, B:20:0x02bd, B:21:0x02d8, B:23:0x02ff, B:24:0x0304, B:26:0x0362, B:28:0x036f, B:30:0x0378, B:31:0x0384, B:33:0x038a, B:36:0x0396, B:41:0x03eb, B:43:0x03fd, B:46:0x0404, B:47:0x0421, B:49:0x046c, B:50:0x047d, B:52:0x0506, B:72:0x052b, B:74:0x0537, B:75:0x054f, B:142:0x040d, B:145:0x041d, B:147:0x03b5, B:148:0x0302, B:149:0x02cb, B:151:0x02a2, B:167:0x0115, B:159:0x0135), top: B:7:0x004a }] */
                /* JADX WARN: Removed duplicated region for block: B:153:0x0158  */
                /* JADX WARN: Removed duplicated region for block: B:16:0x0297 A[Catch: all -> 0x0105, Exception -> 0x012e, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x012e, blocks: (B:11:0x0148, B:14:0x0159, B:16:0x0297, B:18:0x02ad, B:20:0x02bd, B:21:0x02d8, B:23:0x02ff, B:24:0x0304, B:26:0x0362, B:28:0x036f, B:30:0x0378, B:31:0x0384, B:33:0x038a, B:36:0x0396, B:41:0x03eb, B:43:0x03fd, B:46:0x0404, B:47:0x0421, B:49:0x046c, B:50:0x047d, B:52:0x0506, B:72:0x052b, B:74:0x0537, B:75:0x054f, B:142:0x040d, B:145:0x041d, B:147:0x03b5, B:148:0x0302, B:149:0x02cb, B:151:0x02a2, B:167:0x0115, B:159:0x0135), top: B:7:0x004a }] */
                /* JADX WARN: Removed duplicated region for block: B:66:0x0717  */
                /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:98:0x0727 A[Catch: Exception -> 0x0731, TryCatch #12 {Exception -> 0x0731, blocks: (B:96:0x071f, B:98:0x0727, B:99:0x0733, B:101:0x073b, B:102:0x0744, B:104:0x074c), top: B:95:0x071f }] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 1882
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.octopus.ad.internal.network.a.AnonymousClass1.run():void");
                }
            });
        }
    }

    public a(C0411a c0411a) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(int i) {
        if (i == 200) {
            return true;
        }
        HaoboLog.i(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.http_bad_status, i));
        return false;
    }

    public void a(e eVar) {
        f.c("OctopusAd_Time", "setDelegate");
        this.f12502a = new SoftReference<>(eVar);
        Context j = q.a().j();
        if (j != null) {
            DeviceInfoUtil.retrieveDeviceInfo(j);
            UserEnvInfoUtil.retrieveUserEnvInfo(j);
            LocationInfoUtil.refreshLocation(j);
            if (c.a(j).b(j)) {
                return;
            }
            a(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL);
            return;
        }
        a(MediationConstant.ErrorCode.ADN_AD_NO_CACHE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        e eVar = this.f12502a.get();
        if (eVar != null) {
            eVar.a(i);
        }
        HaoboLog.clearLastResponse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpURLConnection a(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(q.q);
        httpURLConnection.setReadTimeout(q.r);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod(an.b);
        return httpURLConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpURLConnection httpURLConnection, byte[] bArr) {
        httpURLConnection.setRequestProperty("User-Agent", q.a().k());
        httpURLConnection.setRequestProperty("Content-Type", an.d);
        httpURLConnection.setRequestProperty("Accept", an.d);
        String cookie = WebviewUtil.getCookie();
        if (!TextUtils.isEmpty(cookie)) {
            httpURLConnection.setRequestProperty(com.sigmob.sdk.base.e.f13172a, cookie);
        }
        httpURLConnection.setRequestProperty("Connect-Length", Integer.toString(bArr.length));
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        this.k = outputStream;
        outputStream.write(bArr);
        this.k.flush();
    }

    public void a(final ServerResponse serverResponse) {
        ThreadUtils.runOnUIThread(new Runnable() { // from class: com.octopus.ad.internal.network.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (serverResponse == null || a.this.e == null) {
                    HaoboLog.v(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.no_response));
                    a.this.a(80100);
                    a.this.a(false, "80100 response is null");
                    return;
                }
                if (serverResponse.u()) {
                    a.this.a(MediationConstant.ErrorCode.ADN_AD_RENDER_FAIL);
                    return;
                }
                Context j = q.a().j();
                String g = serverResponse.g();
                if (!TextUtils.isEmpty(g)) {
                    for (String str : g.split(",")) {
                        a.a(j, str);
                    }
                }
                if ("204".equals(a.this.d)) {
                    a.a(j, serverResponse.f());
                    a.this.a(80100);
                    a.this.a(false, "80100 response code is 204");
                    return;
                }
                e eVar = (e) a.this.f12502a.get();
                if (eVar != null) {
                    a.this.a(true, "");
                    eVar.a(serverResponse);
                } else {
                    a.this.a(80100);
                    a.this.a(false, "80100 adRequestDelegate is null");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        d dVar = this.e;
        if (dVar != null) {
            o.a(new l("TIMEOUT", dVar.c(), this.e.e(), System.currentTimeMillis() - this.e.h(), CtFAbx.BChYOn("80003 ", str)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str) {
        d dVar = this.e;
        if (dVar != null) {
            o.a(new l("RES", dVar.c(), this.e.e(), System.currentTimeMillis() - this.e.h(), z, str));
        }
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C0411a a2 = new AdRequest.Builder().build().a();
        SplashAdViewImpl splashAdViewImpl = new SplashAdViewImpl(context, new FrameLayout(context));
        splashAdViewImpl.setAdSlotId(str);
        splashAdViewImpl.setIsBoost(true);
        splashAdViewImpl.a(a2);
        splashAdViewImpl.c(true);
    }
}
