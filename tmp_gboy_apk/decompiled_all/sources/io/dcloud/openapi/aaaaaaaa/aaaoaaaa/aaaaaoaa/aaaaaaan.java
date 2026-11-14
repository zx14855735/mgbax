package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa;

import BPw6Q8.ASJ6gh;
import J3FDQU.A2egSU;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.g;
import com.sigmob.sdk.archives.tar.e;
import com.sigmob.sdk.base.mta.PointType;
import io.dcloud.openapi.poly.base.utils.PrivacyManager;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaan {
    private static JSONObject aaaaaaaa = new JSONObject();
    private static boolean aaaaaaa0 = false;
    private static Map aaaaaaao = new HashMap();
    private static boolean aaaaaaac = false;

    static {
        IcvOey();
    }

    private static /* synthetic */ void IcvOey() {
        char[] charArray = "çëéªãåéáªæëýª÷ìáèèªÎêíÆöíàãá".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 132);
        }
        String str = new String(charArray);
        char[] charArray2 = "çèíêíð".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 132);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static JSONObject aaaaaaaa(Context context) {
        if (context == null) {
            return aaaaaaaa;
        }
        if (ASJ6gh.A2egSU(context, g.g) != 0 && ASJ6gh.A2egSU(context, g.h) != 0) {
            return aaaaaaaa;
        }
        if (!PrivacyManager.getInstance().aaaaaaac()) {
            return aaaaaaaa;
        }
        if (!io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.aaaaaaaa().aaaaaaaa(context)) {
            return aaaaaaaa;
        }
        if (aaaaaaa0) {
            return aaaaaaaa;
        }
        JSONObject jSONObject = new JSONObject();
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager != null) {
            try {
                Method declaredMethod = locationManager.getClass().getDeclaredMethod("getLastKnownLocation", String.class);
                declaredMethod.setAccessible(true);
                Location location = (Location) declaredMethod.invoke(locationManager, "gps");
                if (location == null && (location = (Location) declaredMethod.invoke(locationManager, "network")) == null) {
                    location = (Location) declaredMethod.invoke(locationManager, "passive");
                }
                if (location != null) {
                    Class<?> cls = Class.forName("android.location.Location");
                    Method method = cls.getMethod("getLongitude", null);
                    Method method2 = cls.getMethod("getLatitude", null);
                    Method method3 = cls.getMethod("getAccuracy", null);
                    Method method4 = cls.getMethod("getTime", null);
                    method.setAccessible(true);
                    jSONObject.put("lon", String.valueOf(method.invoke(location, null)));
                    method2.setAccessible(true);
                    jSONObject.put("lat", String.valueOf(method2.invoke(location, null)));
                    method3.setAccessible(true);
                    jSONObject.put("accuracy", String.valueOf(method3.invoke(location, null)));
                    method4.setAccessible(true);
                    jSONObject.put("ts", String.valueOf(method4.invoke(location, null)));
                }
            } catch (Exception unused) {
            }
        }
        aaaaaaaa = jSONObject;
        aaaaaaa0 = true;
        return jSONObject;
    }

    public static Map aaaaaaaa(Context context, String str) {
        int i;
        int i2;
        int i3;
        if (context == null) {
            return aaaaaaao;
        }
        if (ASJ6gh.A2egSU(context, g.g) != 0) {
            return aaaaaaao;
        }
        if (!PrivacyManager.getInstance().aaaaaaac()) {
            return aaaaaaao;
        }
        if (!io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.aaaaaaaa().aaaaaaaa(context)) {
            return aaaaaaao;
        }
        if (aaaaaaac) {
            return aaaaaaao;
        }
        if (TextUtils.isEmpty(str) || str.equals(PointType.SIGMOB_APP)) {
            i = 0;
            i2 = 0;
            i3 = 0;
        } else {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (!"03".equals(str) && !"05".equals(str)) {
                if ("01".equals(str) || "06".equals(str)) {
                    i = 3;
                } else {
                    i = (e.V.equals(str) || "02".equals(str) || "07".equals(str)) ? 1 : 4;
                }
                GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
                i3 = gsmCellLocation.getLac();
                i2 = gsmCellLocation.getCid();
            } else {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) telephonyManager.getCellLocation();
                i3 = cdmaCellLocation.getNetworkId();
                i2 = cdmaCellLocation.getBaseStationId() / 16;
                i = 2;
            }
        }
        HashMap hashMap = new HashMap();
        A2egSU.BNL6CD(i, hashMap, "carrier", i2, "cid");
        hashMap.put("lac", Integer.valueOf(i3));
        aaaaaaao = hashMap;
        aaaaaaac = true;
        return hashMap;
    }
}
