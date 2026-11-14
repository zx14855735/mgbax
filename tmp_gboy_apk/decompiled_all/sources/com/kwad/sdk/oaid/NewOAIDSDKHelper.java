package com.kwad.sdk.oaid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.e;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class NewOAIDSDKHelper {
    private static boolean mIsRequestIng;
    private static boolean sGetOaidFail;

    public static class IIdentifierListenerImpl implements IIdentifierListener {
        private final a mOaidListener;
        private final long mStartTime;

        public IIdentifierListenerImpl(long j, a aVar) {
            this.mStartTime = j;
            this.mOaidListener = aVar;
        }

        public void onSupport(IdSupplier idSupplier) {
            System.currentTimeMillis();
            if (idSupplier != null) {
                String oaid = idSupplier.getOAID();
                if (TextUtils.isEmpty(oaid)) {
                    NewOAIDSDKHelper.access$002(true);
                } else {
                    this.mOaidListener.OnOAIDValid(oaid);
                }
            }
            NewOAIDSDKHelper.access$102(false);
        }
    }

    public interface a {
        void OnOAIDValid(String str);
    }

    public static void a(Context context, a aVar) {
        if (context == null || sGetOaidFail) {
            return;
        }
        if (!isSupport()) {
            sGetOaidFail = true;
            return;
        }
        if (mIsRequestIng) {
            return;
        }
        mIsRequestIng = true;
        try {
            MdidSdkHelper.InitSdk(context.getApplicationContext(), true, new IIdentifierListenerImpl(System.currentTimeMillis(), aVar));
            System.currentTimeMillis();
        } catch (Throwable unused) {
            mIsRequestIng = false;
            sGetOaidFail = true;
        }
    }

    public static /* synthetic */ boolean access$002(boolean z) {
        sGetOaidFail = true;
        return true;
    }

    public static /* synthetic */ boolean access$102(boolean z) {
        mIsRequestIng = false;
        return false;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static boolean isSupport() {
        try {
            new IIdentifierListener() { // from class: com.kwad.sdk.oaid.NewOAIDSDKHelper.1
                public void onSupport(IdSupplier idSupplier) {
                }
            }.onSupport((IdSupplier) null);
            e.a();
            Class.forName("com.bun.miitmdid.core.MdidSdkHelper", false, NewOAIDSDKHelper.class.getClassLoader());
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
