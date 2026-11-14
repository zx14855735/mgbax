package com.fl.saas.config.utils;

import android.content.Context;
import android.text.TextUtils;
import com.fl.saas.config.oaid.DeviceID;
import com.fl.saas.config.oaid.IGetter;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class OaidUtils {
    private static boolean isCanUseOAID = true;
    private static String oaid = "";

    public static String getOaid() {
        return oaid;
    }

    public static void init() {
        try {
            if (isCanUseOAID && TextUtils.isEmpty(oaid)) {
                oaid = SPUtil.getInstance().getString("oaid", "");
                Context context = DeviceUtil.getContext();
                if (context == null) {
                    return;
                }
                load(context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isIsCanUseOAID() {
        return isCanUseOAID;
    }

    private static void load(Context context) {
        try {
            DeviceID.getOAID(context, new IGetter() { // from class: com.fl.saas.config.utils.OaidUtils.1
                @Override // com.fl.saas.config.oaid.IGetter
                public void onOAIDGetComplete(String str) {
                    if (TextUtils.isEmpty(OaidUtils.oaid) || !OaidUtils.oaid.equals(str)) {
                        String unused = OaidUtils.oaid = str;
                        SPUtil.getInstance().putString("oaid", str);
                    }
                    LogcatUtil.d("YdSDK", "oaid: " + OaidUtils.oaid);
                }

                @Override // com.fl.saas.config.oaid.IGetter
                public void onOAIDGetError(Exception exc) {
                    LogcatUtil.d("YdSDK", "oaidGetError: " + exc.getMessage());
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setIsCanUseOAID(boolean z) {
        isCanUseOAID = z;
    }

    public static void setOaid(String str) {
        oaid = str;
    }
}
