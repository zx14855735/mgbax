package com.czhj.sdk.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.utils.PlayServicesUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import java.util.Calendar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class IdentifierManager {
    private static final String b = "com.Sigmob.settings.identifier";
    private static final String c = "privacy.identifier.ifa";
    private static final String d = "privacy.identifier.ifa_aes_gcm";
    private static final String e = "privacy.identifier.Sigmob";
    private static final String f = "privacy.identifier.time";
    private static final String g = "privacy.limit.ad.tracking";
    private static final int h = -1;

    /* renamed from: a, reason: collision with root package name */
    private long f10593a;
    private AdvertisingId i;
    private Context j;
    private AdvertisingIdChangeListener k;
    private boolean l;
    private boolean m;
    private SdkInitializationListener n;

    public interface AdvertisingIdChangeListener {
        void onIdChanged(AdvertisingId advertisingId, AdvertisingId advertisingId2);
    }

    public class RefreshAdvertisingInfoAsyncTask extends AsyncTask<Void, Void, Void> {
        private RefreshAdvertisingInfoAsyncTask() {
        }

        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) {
            IdentifierManager.this.b();
            IdentifierManager.this.l = false;
            return null;
        }
    }

    public interface SdkInitializationListener {
        void onInitializationFinished();
    }

    public IdentifierManager(Context context, AdvertisingIdChangeListener advertisingIdChangeListener) {
    }

    private static synchronized AdvertisingId a(Context context) {
        synchronized (IdentifierManager.class) {
            Preconditions.NoThrow.checkNotNull(context);
            Calendar calendar = Calendar.getInstance();
            try {
                SharedPreferences sharedPreferences = SharedPreferencesUtil.getSharedPreferences(context, b);
                String string = sharedPreferences.getString(d, "");
                String DecryptString = !TextUtils.isEmpty(string) ? AESUtil.DecryptString(string, Constants.AESKEY) : sharedPreferences.getString(c, "");
                String string2 = sharedPreferences.getString(e, "");
                long j = sharedPreferences.getLong(f, calendar.getTimeInMillis());
                boolean z = sharedPreferences.getBoolean(g, false);
                if (!TextUtils.isEmpty(DecryptString) && !TextUtils.isEmpty(string2)) {
                    return new AdvertisingId(DecryptString, string2, z, j);
                }
            } catch (Throwable unused) {
                SigmobLog.e("Cannot read identifier from shared preferences");
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        PlayServicesUtil.AdvertisingInfo advertisingInfo;
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (d()) {
            try {
                advertisingInfo = PlayServicesUtil.getAdvertisingIdInfo(this.j);
            } catch (Throwable unused) {
                advertisingInfo = null;
            }
            if (advertisingInfo != null) {
                AdvertisingId advertisingId = this.i;
                if (advertisingInfo.limitAdTracking && advertisingId.b()) {
                    a(advertisingInfo.advertisingId, AdvertisingId.a(), advertisingInfo.limitAdTracking, timeInMillis);
                } else {
                    a(advertisingInfo.advertisingId, advertisingId.b, advertisingInfo.limitAdTracking, advertisingId.f10589a.getTimeInMillis());
                }
            }
        }
    }

    private void c() {
        SdkInitializationListener sdkInitializationListener = this.n;
        if (sdkInitializationListener != null) {
            sdkInitializationListener.onInitializationFinished();
            this.n = null;
        }
        this.m = true;
    }

    private boolean d() {
        return true;
    }

    public AdvertisingId getAdvertisingInfo() {
        AdvertisingId advertisingId = this.i;
        this.f10593a = System.currentTimeMillis();
        return advertisingId;
    }

    private void a() {
        if (this.l) {
            return;
        }
        this.l = true;
        new RefreshAdvertisingInfoAsyncTask().execute(new Void[0]);
    }

    private static synchronized void a(Context context, AdvertisingId advertisingId) {
        synchronized (IdentifierManager.class) {
            Preconditions.NoThrow.checkNotNull(context);
            Preconditions.NoThrow.checkNotNull(advertisingId);
            SharedPreferences.Editor edit = SharedPreferencesUtil.getSharedPreferences(context, b).edit();
            edit.putBoolean(g, advertisingId.mDoNotTrack);
            edit.remove(c);
            edit.putString(d, AESUtil.EncryptString(advertisingId.mAdvertisingId, Constants.AESKEY));
            edit.putString(e, advertisingId.b);
            edit.putLong(f, advertisingId.f10589a.getTimeInMillis());
            edit.apply();
        }
    }

    private void a(AdvertisingId advertisingId) {
        AdvertisingId advertisingId2 = this.i;
        this.i = advertisingId;
        a(this.j, advertisingId);
        if (!this.i.equals(advertisingId2) || !this.m) {
            a(advertisingId2, this.i);
        }
        if (this.m) {
            return;
        }
        c();
    }

    private void a(AdvertisingId advertisingId, AdvertisingId advertisingId2) {
        Preconditions.NoThrow.checkNotNull(advertisingId2);
        AdvertisingIdChangeListener advertisingIdChangeListener = this.k;
        if (advertisingIdChangeListener != null) {
            advertisingIdChangeListener.onIdChanged(advertisingId, advertisingId2);
        }
    }

    private void a(String str, String str2, boolean z, long j) {
        Preconditions.NoThrow.checkNotNull(str);
        Preconditions.NoThrow.checkNotNull(str2);
        a(new AdvertisingId(str, str2, z, j));
    }
}
