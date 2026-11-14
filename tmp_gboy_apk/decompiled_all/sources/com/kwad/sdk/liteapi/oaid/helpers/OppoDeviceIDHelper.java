package com.kwad.sdk.liteapi.oaid.helpers;

import A5SV6n.A2egSU;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.PackageManagerUtils;
import com.kwad.sdk.liteapi.oaid.interfaces.OppoIDInterface;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class OppoDeviceIDHelper {
    private static final String TAG = "OppoDeviceIDHelper";
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> mLinkedBlockingQueue = new LinkedBlockingQueue<>(1);
    private ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.liteapi.oaid.helpers.OppoDeviceIDHelper.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LiteApiLogger.i(OppoDeviceIDHelper.TAG, "onServiceConnected");
            try {
                OppoDeviceIDHelper.this.mLinkedBlockingQueue.put(iBinder);
            } catch (InterruptedException e) {
                LiteApiLogger.printStackTrace(e);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public OppoDeviceIDHelper(Context context) {
        this.mContext = context;
    }

    private String getSign() {
        Signature[] signatureArr;
        try {
            Context context = this.mContext;
            PackageInfo packageInfo = PackageManagerUtils.getPackageInfo(context, context.getPackageName(), 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0) {
                byte[] digest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                }
                return sb.toString();
            }
        } catch (Exception e) {
            LiteApiLogger.printStackTrace(e);
        }
        return null;
    }

    private boolean isSupportOppo() {
        try {
            PackageInfo packageInfo = PackageManagerUtils.getPackageInfo(this.mContext, "com.heytap.openid", 0);
            if (packageInfo != null) {
                if ((Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode) >= 1) {
                    return true;
                }
            }
        } catch (Exception e) {
            LiteApiLogger.printStackTrace(e);
        }
        return false;
    }

    public String getOAID() {
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            boolean bindService = this.mContext.bindService(intent, this.serviceConnection, 1);
            LiteApiLogger.i(TAG, "getOAID isBin=" + bindService);
            if (!bindService) {
                return "";
            }
            try {
                try {
                    str = new OppoIDInterface.a(this.mLinkedBlockingQueue.take()).getSerID(this.mContext.getPackageName(), getSign(), "OUID");
                    LiteApiLogger.i(TAG, "getOAID oaid" + str);
                    return str;
                } catch (Exception e) {
                    LiteApiLogger.printStackTrace(e);
                    this.mContext.unbindService(this.serviceConnection);
                    return str;
                }
            } finally {
                this.mContext.unbindService(this.serviceConnection);
            }
        } catch (Exception e2) {
            LiteApiLogger.i(TAG, "getOAID service not found");
            LiteApiLogger.printStackTraceOnly(e2);
            return str;
        }
    }
}
