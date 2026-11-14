package com.fl.saas.base.bidding;

import com.fl.saas.config.utils.LogcatUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract /* synthetic */ class A4TApA {
    public static int A2egSU(Object... objArr) {
        C2SBiddingECPM c2SBiddingECPM;
        String stringBuffer;
        if (objArr.length == 0) {
            stringBuffer = "C2S Bid Ad but ad Object is empty";
        } else {
            StringBuffer stringBuffer2 = new StringBuffer("C2S Bid Ad but all fail:");
            int length = objArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    c2SBiddingECPM = null;
                    break;
                }
                Object obj = objArr[i];
                if (obj instanceof C2SBiddingECPM) {
                    c2SBiddingECPM = (C2SBiddingECPM) obj;
                    break;
                }
                if (obj != null) {
                    stringBuffer2.append(obj.getClass().getSimpleName());
                    stringBuffer2.append(";");
                }
                i++;
            }
            if (c2SBiddingECPM != null) {
                return c2SBiddingECPM.getC2SBiddingECPM();
            }
            LogcatUtil.e("YdSDK-C2SBiddingECPM", "C2S Bid Ad but ad Object is null");
            stringBuffer = stringBuffer2.toString();
        }
        LogcatUtil.e("YdSDK-C2SBiddingECPM", stringBuffer);
        return 0;
    }
}
