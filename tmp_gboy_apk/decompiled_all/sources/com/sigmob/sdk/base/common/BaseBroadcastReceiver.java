package com.sigmob.sdk.base.common;

import ADYaiT.CtFAbx;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLogger;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class BaseBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13092a = "BaseBroadcastReceiver";
    private final String b;

    public BaseBroadcastReceiver(String str) {
        this.b = str;
    }

    public abstract IntentFilter a();

    public void a(BroadcastReceiver broadcastReceiver) {
        aj a2 = aj.a(com.sigmob.sdk.b.e());
        if (a2 == null) {
            return;
        }
        try {
            a2.a(broadcastReceiver, a());
        } catch (Exception e) {
            SigmobLogger.e(f13092a, CtFAbx.AZOQYO(e, new StringBuilder("register: error = ")), new Object[0]);
        }
    }

    public void b(BroadcastReceiver broadcastReceiver) {
        aj a2;
        if (broadcastReceiver == null || (a2 = aj.a(com.sigmob.sdk.b.e())) == null) {
            return;
        }
        try {
            a2.a(broadcastReceiver);
        } catch (Exception e) {
            SigmobLogger.e(f13092a, CtFAbx.AZOQYO(e, new StringBuilder("unregister: error = ")), new Object[0]);
        }
    }

    public static void a(Context context, String str, String str2) {
        a(context, str, null, str2, 0);
    }

    public static void a(Context context, String str, String str2, int i) {
        a(context, str, null, str2, i);
    }

    public static void a(Context context, String str, Map<String, Object> map, String str2) {
        a(context, str, map, str2, 0);
    }

    public static void a(Context context, String str, Map<String, Object> map, String str2, int i) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(str2);
        Intent intent = new Intent(str2);
        intent.putExtra(Constants.BROADCAST_IDENTIFIER_KEY, str);
        if (map != null) {
            for (String str3 : map.keySet()) {
                try {
                    Object obj = map.get(str3);
                    if (obj instanceof Number) {
                        intent.putExtra(str3, (Number) obj);
                    } else {
                        intent.putExtra(str3, (String) obj);
                    }
                } catch (Throwable th) {
                    SigmobLogger.e(f13092a, J3FDQU.A2egSU.B4ZgIw(th, new StringBuilder("broadcastAction: error = ")), new Object[0]);
                }
            }
        }
        aj a2 = aj.a(context);
        if (a2 == null) {
            return;
        }
        try {
            a2.a(intent, i);
        } catch (Exception e) {
            SigmobLogger.e(f13092a, CtFAbx.AZOQYO(e, new StringBuilder("broadcastAction: error = ")), new Object[0]);
        }
    }

    public boolean a(Intent intent) {
        Preconditions.NoThrow.checkNotNull(intent);
        String stringExtra = intent.getStringExtra(Constants.BROADCAST_IDENTIFIER_KEY);
        return !TextUtils.isEmpty(stringExtra) && stringExtra.equalsIgnoreCase(this.b);
    }
}
