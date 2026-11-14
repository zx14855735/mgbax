package com.kwad.sdk.liteapi.encrypt;

import A5SV6n.A2egSU;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.liteapi.KsSecSDKWrapper;
import com.kwad.sdk.liteapi.LiteApiLogger;
import java.util.Arrays;
import java.util.Map;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class LiteKsSig1Util {
    private static final boolean DEBUG = false;
    private static final String JOIN_STRING = "&";
    public static final String PARAM_SIGNATURE = "Ks-Sig1";
    private static final String TAG = "KsSig1Util";

    public static String atlasSign(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                String doSign = KsSecSDKWrapper.doSign(context, str);
                return doSign == null ? "" : doSign;
            } catch (Throwable th) {
                LiteApiLogger.printStackTraceOnly(th);
            }
        }
        return "";
    }

    private static String emptyIfNull(String str) {
        return str == null ? "" : str;
    }

    private static String generateInputString(String str, String str2) {
        Uri parse = Uri.parse(str);
        StringBuilder sb = new StringBuilder();
        sb.append(parse.getPath());
        sb.append(JOIN_STRING);
        return J3FDQU.A2egSU.B3GDIM(sb, getSortedQuery(parse.getQuery()), JOIN_STRING, str2);
    }

    private static String getSortedQuery(String str) {
        if (TextUtils.isEmpty(str)) {
            return emptyIfNull(str);
        }
        String[] split = str.split(JOIN_STRING);
        Arrays.sort(split);
        return TextUtils.join(JOIN_STRING, split);
    }

    public static void sigRequest(Context context, String str, Map<String, String> map, String str2) {
        map.put(PARAM_SIGNATURE, atlasSign(context, generateInputString(str, str2)));
    }
}
