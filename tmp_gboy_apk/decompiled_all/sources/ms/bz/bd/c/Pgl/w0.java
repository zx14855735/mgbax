package ms.bz.bd.c.Pgl;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.graphics.Point;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.czhj.sdk.common.Constants;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import ms.bz.bd.c.Pgl.k1;
import ms.bz.bd.c.Pgl.pbly;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class w0 {

    final class pblb extends pbly.pgla {
        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object A4TApA(String str, Object obj) {
            Context context = pblv.f14062A4TApA.f14063A2egSU;
            a1.A2egSU();
            return null;
        }
    }

    final class pblc extends pbly.pgla {
        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object A4TApA(String str, Object obj) {
            Context context = pblv.f14062A4TApA.f14063A2egSU;
            a1 A2egSU2 = a1.A2egSU();
            String str2 = a1.f14005A4TApA;
            if (str2 == null) {
                return A2egSU2.f14007A2egSU;
            }
            A2egSU2.getClass();
            return str2;
        }
    }

    final class pbld extends pbly.pgla {
        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object A4TApA(String str, Object obj) {
            String str2;
            String string;
            Context context = pblv.f14062A4TApA.f14063A2egSU;
            String str3 = "null_";
            if (context == null) {
                return null;
            }
            try {
                string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
            } catch (Throwable th) {
                try {
                    str2 = "null_" + th.getMessage();
                } catch (Throwable unused) {
                }
            }
            if (!TextUtils.isEmpty(string)) {
                if (string.contains("/")) {
                    str2 = string.split("/")[0];
                    str3 = str2;
                } else {
                    str3 = string;
                }
            }
            StringBuilder sb = new StringBuilder(str3);
            try {
                Iterator<InputMethodInfo> it = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList().iterator();
                while (it.hasNext()) {
                    String packageName = it.next().getPackageName();
                    String str4 = context.getPackageManager().getApplicationInfo(packageName, 0).sourceDir;
                    if (!TextUtils.isEmpty(packageName) && sb.indexOf(packageName) < 0) {
                        sb.append("[<!>]");
                        sb.append(str4);
                    }
                }
            } catch (Throwable unused2) {
            }
            return sb.toString();
        }
    }

    final class pble extends pbly.pgla {
        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object A4TApA(String str, Object obj) {
            try {
                Display defaultDisplay = ((WindowManager) pblv.f14062A4TApA.f14063A2egSU.getSystemService("window")).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                i1.f14014A2egSU = point.x;
                i1.f14015A4TApA = point.y;
            } catch (Throwable unused) {
            }
            return i1.f14014A2egSU + "*" + i1.f14015A4TApA;
        }
    }

    final class pblf extends pbly.pgla {
        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object A4TApA(String str, Object obj) {
            return "np";
        }
    }

    final class pblg extends pbly.pgla {
        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object A4TApA(String str, Object obj) {
            return "np";
        }
    }

    final class pblh extends pbly.pgla {
        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object A4TApA(String str, Object obj) {
            TelephonyManager telephonyManager;
            Context context = pblv.f14062A4TApA.f14063A2egSU;
            synchronized (h1.class) {
                String str2 = h1.f14012A2egSU;
                if (str2 != null) {
                    return q1.A2egSU(str2);
                }
                try {
                    telephonyManager = (TelephonyManager) context.getSystemService("phone");
                } catch (Throwable unused) {
                }
                if (telephonyManager == null) {
                    throw new NullPointerException("null TM");
                }
                Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(pbla.A2egSU("6765744465766963654964")), new Class[0]);
                declaredMethod.setAccessible(true);
                h1.f14012A2egSU = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
                return q1.A2egSU(h1.f14012A2egSU);
            }
        }
    }

    final class pbli extends pbly.pgla {
        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object A4TApA(String str, Object obj) {
            TelephonyManager telephonyManager;
            Context context = pblv.f14062A4TApA.f14063A2egSU;
            synchronized (h1.class) {
                String str2 = h1.f14012A2egSU;
                if (str2 != null) {
                    return q1.A2egSU(str2);
                }
                try {
                    telephonyManager = (TelephonyManager) context.getSystemService("phone");
                } catch (Throwable unused) {
                }
                if (telephonyManager == null) {
                    throw new NullPointerException("null TM");
                }
                Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(pbla.A2egSU("676574537562736372696265724964")), new Class[0]);
                declaredMethod.setAccessible(true);
                h1.f14013A4TApA = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
                return q1.A2egSU(h1.f14013A4TApA);
            }
        }
    }

    final class pblj extends pbly.pgla {
        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object A4TApA(String str, Object obj) {
            int i;
            String str2;
            String str3;
            String str4 = ms.bz.bd.c.Pgl.pblh.f14041A2egSU;
            JSONObject jSONObject = new JSONObject();
            try {
                HashMap A2egSU2 = ms.bz.bd.c.Pgl.pblh.A2egSU();
                String str5 = ms.bz.bd.c.Pgl.pblh.f14048AZOQYO;
                try {
                    i = new File((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "53512a", new byte[]{107, 34, 95, 86, 66, 114, com.sigmob.sdk.archives.tar.e.K, 4, 109, 98, 33, 34, 9, 86, 20, 101, 34, 23, 105, 46, 39, 33, com.sigmob.sdk.archives.tar.e.Q, 10})).listFiles(ms.bz.bd.c.Pgl.pblh.f14049AZkASS).length;
                } catch (Throwable unused) {
                    i = -1;
                }
                jSONObject.put(str5, i);
                String str6 = null;
                try {
                    str2 = (String) A2egSU2.get(ms.bz.bd.c.Pgl.pblh.f14041A2egSU);
                } catch (Throwable unused2) {
                    str2 = null;
                }
                jSONObject.put(ms.bz.bd.c.Pgl.pblh.f14044ADYaiT, str2 == null ? "" : str2.trim());
                try {
                    str3 = (String) A2egSU2.get(ms.bz.bd.c.Pgl.pblh.f14042A4TApA);
                } catch (Throwable unused3) {
                    str3 = null;
                }
                jSONObject.put(ms.bz.bd.c.Pgl.pblh.AMqCpz, str3 == null ? "" : str3.trim());
                jSONObject.put(ms.bz.bd.c.Pgl.pblh.f14046ASJ6gh, ms.bz.bd.c.Pgl.pblh.A4TApA((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "932a51", new byte[]{com.sigmob.sdk.archives.tar.e.T, 34, com.sigmob.sdk.archives.tar.e.S, 6, 69, 34, 63, 4, 106, com.sigmob.sdk.archives.tar.e.J, 45, 34, 14, 6, 19, com.sigmob.sdk.archives.tar.e.M, 46, 23, 110, 126, 43, 33, 84, 90, 9, com.sigmob.sdk.archives.tar.e.N, 47, 66, 44, com.sigmob.sdk.archives.tar.e.J, 56, 36, 71, 7, 15, com.sigmob.sdk.archives.tar.e.O, 117, 17, 115, 36, 33, 63, 71, 26, com.sigmob.sdk.archives.tar.e.M, 43, 59, 10, 92, com.sigmob.sdk.archives.tar.e.O, 58, com.sigmob.sdk.archives.tar.e.L, 80})));
                jSONObject.put(ms.bz.bd.c.Pgl.pblh.f14047AYUAbz, ms.bz.bd.c.Pgl.pblh.A4TApA((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "81a9e0", new byte[]{102, 32, 11, 94, 21, 35, 62, 6, 57, 106, 44, 32, 93, 94, 67, com.sigmob.sdk.archives.tar.e.L, 47, 21, 61, 38, 42, 35, 7, 2, 89, com.sigmob.sdk.archives.tar.e.O, 46, 64, Byte.MAX_VALUE, 106, 57, 38, 20, 95, 95, com.sigmob.sdk.archives.tar.e.N, 116, 19, 32, 124, 32, 61, 20, 66, 101, 42, com.sigmob.sdk.archives.tar.e.J, 30, 15, 111, 59, com.sigmob.sdk.archives.tar.e.N, 3})));
                try {
                    str6 = (String) A2egSU2.get(ms.bz.bd.c.Pgl.pblh.f14043A5SV6n);
                } catch (Throwable unused4) {
                }
                jSONObject.put(ms.bz.bd.c.Pgl.pblh.f14045ARc23Z, str6 != null ? str6.trim() : "");
            } catch (Throwable unused5) {
            }
            String jSONObject2 = jSONObject.toString();
            return TextUtils.isEmpty(jSONObject2) ? (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "672691", new byte[]{60, 40}) : jSONObject2.trim();
        }
    }

    final class pblk extends pbly.pgla {
        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object A4TApA(String str, Object obj) {
            int i;
            List list;
            Context context = pblv.f14062A4TApA.f14063A2egSU;
            JSONArray jSONArray = new JSONArray();
            if (context == null) {
                return jSONArray.toString();
            }
            String str2 = null;
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                Method declaredMethod = wifiManager.getClass().getDeclaredMethod(new String(pbla.A2egSU("6765745363616e526573756c7473")), new Class[0]);
                list = declaredMethod != null ? (List) declaredMethod.invoke(wifiManager, new Object[0]) : null;
            } catch (Throwable unused) {
            }
            if (list == null || list.size() <= 0) {
                return jSONArray.toString();
            }
            Collections.sort(list, new k1.pgla());
            for (i = 0; i < list.size() && i < 10; i++) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ss", q1.A2egSU(((ScanResult) list.get(i)).SSID));
                    jSONObject.put("bs", q1.A2egSU(((ScanResult) list.get(i)).BSSID));
                    jSONArray.put(jSONObject);
                } catch (JSONException unused2) {
                }
            }
            str2 = jSONArray.toString();
            return str2 == null ? "[]" : str2.trim();
        }
    }

    final class pbll extends pbly.pgla {
        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object A4TApA(String str, Object obj) {
            String str2;
            String AzWtSf2;
            String str3 = Constants.FAIL;
            String str4 = "null";
            String str5 = null;
            try {
                WifiInfo connectionInfo = ((WifiManager) pblv.f14062A4TApA.f14063A2egSU.getSystemService("wifi")).getConnectionInfo();
                Class<?> cls = connectionInfo.getClass();
                Method declaredMethod = cls.getDeclaredMethod(new String(pbla.A2egSU("6765744253534944")), new Class[0]);
                declaredMethod.setAccessible(true);
                String str6 = (String) declaredMethod.invoke(connectionInfo, new Object[0]);
                try {
                    Method declaredMethod2 = cls.getDeclaredMethod(new String(pbla.A2egSU("67657453534944")), new Class[0]);
                    declaredMethod2.setAccessible(true);
                    str2 = (String) declaredMethod2.invoke(connectionInfo, new Object[0]);
                    try {
                        Method declaredMethod3 = cls.getDeclaredMethod(new String(pbla.A2egSU("676574497041646472657373")), new Class[0]);
                        declaredMethod3.setAccessible(true);
                        String num = Integer.toString(((Integer) declaredMethod3.invoke(connectionInfo, new Object[0])).intValue());
                        String A2egSU2 = q1.A2egSU(str2);
                        String A2egSU3 = q1.A2egSU(str6);
                        String A2egSU4 = q1.A2egSU(num);
                        StringBuilder sb = new StringBuilder();
                        sb.append((A2egSU3 == null || A2egSU3.length() <= 0) ? "null" : A2egSU3.trim());
                        sb.append("[<!>]");
                        if (A2egSU2 != null && A2egSU2.length() > 0) {
                            str4 = A2egSU2.trim();
                        }
                        sb.append(str4);
                        sb.append("[<!>]");
                        if (A2egSU4 != null && A2egSU4.length() > 0) {
                            str3 = A2egSU4.trim();
                        }
                        AzWtSf2 = CtFAbx.B25kr6(sb, str3, "[<!>]");
                    } catch (Throwable unused) {
                        str5 = str6;
                        String A2egSU5 = q1.A2egSU(str2);
                        String A2egSU6 = q1.A2egSU(str5);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append((A2egSU6 == null || A2egSU6.length() <= 0) ? "null" : A2egSU6.trim());
                        sb2.append("[<!>]");
                        if (A2egSU5 != null && A2egSU5.length() > 0) {
                            str4 = A2egSU5.trim();
                        }
                        AzWtSf2 = A2egSU.AzWtSf(sb2, str4, "[<!>]", Constants.FAIL, "[<!>]");
                        return AzWtSf2.trim();
                    }
                } catch (Throwable unused2) {
                    str2 = null;
                }
            } catch (Throwable unused3) {
                str2 = null;
            }
            return AzWtSf2.trim();
        }
    }

    final class pblm extends pbly.pgla {
        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object A4TApA(String str, Object obj) {
            String str2;
            String string;
            Context context = pblv.f14062A4TApA.f14063A2egSU;
            String str3 = "null_";
            if (context == null) {
                return null;
            }
            try {
                string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
            } catch (Throwable th) {
                try {
                    str2 = "null_" + th.getMessage();
                } catch (Throwable unused) {
                }
            }
            if (!TextUtils.isEmpty(string)) {
                if (string.contains("/")) {
                    str2 = string.split("/")[0];
                    str3 = str2;
                } else {
                    str3 = string;
                }
            }
            StringBuilder sb = new StringBuilder(str3);
            try {
                Iterator<InputMethodInfo> it = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList().iterator();
                while (it.hasNext()) {
                    String packageName = it.next().getPackageName();
                    if (!TextUtils.isEmpty(packageName) && sb.indexOf(packageName) < 0) {
                        sb.append("[<!>]");
                        sb.append(packageName);
                    }
                }
            } catch (Throwable unused2) {
            }
            return sb.toString();
        }
    }

    final class pgla extends pbly.pgla {
        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object A4TApA(String str, Object obj) {
            return null;
        }
    }

    public static void A2egSU() {
        pbly.A2egSU(268435457, new pble());
        pbly.A2egSU(268435458, new pblf());
        pbly.A2egSU(268435459, new pblg());
        pbly.A2egSU(268435460, new pblh());
        pbly.A2egSU(268435461, new pbli());
        pbly.A2egSU(268435462, new pblj());
        pbly.A2egSU(268435463, new pblk());
        pbly.A2egSU(268435464, new pbll());
        pbly.A2egSU(268435465, new pblm());
        pbly.A2egSU(268435466, new pgla());
        pbly.A2egSU(268435467, new pblb());
        pbly.A2egSU(268435468, new pblc());
        pbly.A2egSU(268435469, new pbld());
    }
}
