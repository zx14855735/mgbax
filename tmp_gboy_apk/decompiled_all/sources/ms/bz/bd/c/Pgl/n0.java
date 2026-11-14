package ms.bz.bd.c.Pgl;

import Qn9ulQ.A5SV6n;
import Qn9ulQ.ADYaiT;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import ms.bz.bd.c.Pgl.pblu;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class n0 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static volatile boolean f14028A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final ConcurrentHashMap f14029A4TApA = new ConcurrentHashMap();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final CopyOnWriteArraySet f14030A5SV6n = new CopyOnWriteArraySet();

    public interface pgla {
    }

    static {
        PzcNi();
    }

    public static synchronized m0 A2egSU() {
        synchronized (n0.class) {
            if (!f14028A2egSU) {
                return null;
            }
            SparseArray sparseArray = pbly.f14067A2egSU;
            Object a2 = com.volcengine.mobsecBiz.matrix.pgla.a(67108866, 0, 0L, "1371", null);
            if (a2 == null) {
                return null;
            }
            pblu pbluVar = (pblu) f14029A4TApA.get("1371");
            if (pbluVar == null) {
                return null;
            }
            return new m0(pbluVar, pblv.f14062A4TApA.f14063A2egSU, ((Long) a2).longValue());
        }
    }

    public static synchronized void A4TApA() {
        synchronized (n0.class) {
            if (pblv.f14062A4TApA.f14063A2egSU != null) {
                pblu pbluVar = (pblu) f14029A4TApA.get("1371");
                if (A2egSU() != null && pbluVar != null) {
                    f14030A5SV6n.addAll(pbluVar.f14061AZkASS);
                    A5SV6n A2egSU2 = ADYaiT.A2egSU();
                    if (A2egSU2 != null) {
                        A2egSU2.A2egSU((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3856e8", new byte[]{29, com.sigmob.sdk.archives.tar.e.K, 72, 75, 78, 16, 34, 28, 116, 105, com.sigmob.sdk.archives.tar.e.H, 46}));
                    }
                }
            }
        }
    }

    public static synchronized void A5SV6n(Context context) {
        Context context2;
        synchronized (n0.class) {
            if (!f14028A2egSU) {
                Context applicationContext = context.getApplicationContext();
                pblv pblvVar = pblv.f14062A4TApA;
                if (applicationContext != null) {
                    pblvVar.getClass();
                    context2 = applicationContext.getApplicationContext();
                } else {
                    context2 = null;
                }
                pblvVar.f14063A2egSU = context2;
                e1.A2egSU(applicationContext);
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a3d8a5", new byte[]{62, 60, 4});
                pbly.A2egSU(16777218, new j());
                pbly.A2egSU(16777217, new u());
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "955618", new byte[]{102, 58, 66});
                pbly.A2egSU(16777219, new f0());
                pbly.A2egSU(16777221, new g0());
                pbly.A2egSU(16777222, new h0());
                pbly.A2egSU(16777223, new i0());
                pbly.A2egSU(16777224, new j0());
                pbly.A2egSU(16777225, new k0());
                pbly.A2egSU(16777226, new l0());
                pbly.A2egSU(16777228, new pblz());
                pbly.A2egSU(16777232, new a());
                pbly.A2egSU(16777233, new b());
                pbly.A2egSU(16777235, new c());
                pbly.A2egSU(16777238, new d());
                pbly.A2egSU(16777239, new e());
                pbly.A2egSU(16777241, new f());
                pbly.A2egSU(16777242, new g());
                pbly.A2egSU(16777243, new h());
                pbly.A2egSU(16777244, new i());
                pbly.A2egSU(16777245, new k());
                pbly.A2egSU(16777246, new l());
                pbly.A2egSU(16777247, new m());
                pbly.A2egSU(16777248, new n());
                pbly.A2egSU(16777249, new o());
                pbly.A2egSU(16777250, new p());
                pbly.A2egSU(16777251, new q());
                pbly.A2egSU(16777240, new r());
                pbly.A2egSU(16777252, new s());
                pbly.A2egSU(16777253, new t());
                pbly.A2egSU(16777254, new v());
                pbly.A2egSU(16777255, new w());
                pbly.A2egSU(16777256, new x());
                pbly.A2egSU(16777257, new y());
                pbly.A2egSU(16777258, new z());
                pbly.A2egSU(16777259, new a0());
                pbly.A2egSU(16777261, new b0());
                pbly.A2egSU(16777266, new c0());
                pbly.A2egSU(16777272, new d0());
                pbly.A2egSU(33554435, new e0());
                v0.A4TApA();
                w0.A2egSU();
                com.volcengine.mobsecBiz.matrix.pgla.a(16777219, 0, 0L, null, applicationContext);
                f14028A2egSU = true;
            }
        }
    }

    public static synchronized boolean ADYaiT(Context context, pblu.pgla pglaVar) {
        synchronized (n0.class) {
            try {
                if (context == null) {
                    throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "074801", new byte[]{34, 58, 73, com.sigmob.sdk.archives.tar.e.S, 10, 62, 39, 86, 102, com.sigmob.sdk.archives.tar.e.T, com.sigmob.sdk.archives.tar.e.L, 57, 67, 12, 1, 41, 39, 86, com.sigmob.sdk.archives.tar.e.T, 109, 97, 59, 82, 64, 3}));
                }
                if (pglaVar == null) {
                    throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1649cb", new byte[]{35, 59, 73, 75, 85, 114, 114, 20, 106, 124, 44, com.sigmob.sdk.archives.tar.e.H, 7, 67, com.sigmob.sdk.archives.tar.e.Q, 97, 114, 21, 96, 41, 46, 33, 75, 65}));
                }
                String str = pglaVar.f14054A4TApA;
                if (str.length() <= 0) {
                    throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1497c9", new byte[]{33, 38, 90, 106, com.sigmob.sdk.archives.tar.e.R, 110, 63, 0, 123, 115, 96, com.sigmob.sdk.archives.tar.e.L, 79, 3, 79, 43, 38}));
                }
                if (!f14028A2egSU) {
                    synchronized (n0.class) {
                        try {
                            if (!f14028A2egSU) {
                                A5SV6n(context);
                                f14028A2egSU = true;
                            }
                        } finally {
                        }
                    }
                }
                if (f14029A4TApA.containsKey(str)) {
                    return false;
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(pblu.A2egSU(""));
                jSONArray.put(pblu.A2egSU(pglaVar.f14055A5SV6n));
                jSONArray.put(pblu.A2egSU(pglaVar.f14054A4TApA));
                jSONArray.put(pblu.A2egSU(pglaVar.f14056ADYaiT));
                jSONArray.put(pblu.A2egSU(n1.f14031A2egSU));
                jSONArray.put(pblu.A2egSU(""));
                jSONArray.put(pblu.A2egSU(pglaVar.f14053A2egSU));
                jSONArray.put(pblu.A2egSU(""));
                jSONArray.put(pblu.A2egSU(""));
                jSONArray.put(pblu.A2egSU(""));
                jSONArray.put(String.valueOf(pglaVar.f14057ARc23Z));
                jSONArray.put(String.valueOf(-1));
                jSONArray.put(String.valueOf(pglaVar.f14058ASJ6gh));
                JSONArray jSONArray2 = new JSONArray();
                for (Map.Entry entry : pglaVar.f14059AYUAbz.entrySet()) {
                    if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                        jSONArray2.put(pblu.A2egSU(entry.getKey()));
                        jSONArray2.put(pblu.A2egSU(entry.getValue()));
                    }
                }
                jSONArray.put(jSONArray2);
                JSONArray jSONArray3 = new JSONArray();
                for (Map.Entry entry2 : pglaVar.f14060AZOQYO.entrySet()) {
                    if (!TextUtils.isEmpty((CharSequence) entry2.getKey())) {
                        if (((String) entry2.getKey()).equals("kOA1") && TextUtils.equals((CharSequence) entry2.getValue(), "1")) {
                            a1.f14005A4TApA = pglaVar.AMqCpz;
                        }
                        jSONArray3.put(pblu.A2egSU(entry2.getKey()));
                        jSONArray3.put(pblu.A2egSU(entry2.getValue()));
                    }
                }
                jSONArray.put(jSONArray3);
                String jSONArray4 = jSONArray.toString();
                SparseArray sparseArray = pbly.f14067A2egSU;
                if (!((Boolean) com.volcengine.mobsecBiz.matrix.pgla.a(67108865, 0, 0L, jSONArray4, null)).booleanValue()) {
                    return false;
                }
                f14029A4TApA.put(str, pglaVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static /* synthetic */ void PzcNi() {
        char[] charArray = "!-/l%#/'l -;l1*'..l\b,+\u00000+&%'".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'B');
        }
        String str = new String(charArray);
        char[] charArray2 = "!.+,+6".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'B');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
