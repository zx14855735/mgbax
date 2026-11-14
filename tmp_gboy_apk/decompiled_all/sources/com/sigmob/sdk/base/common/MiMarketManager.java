package com.sigmob.sdk.base.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class MiMarketManager {

    /* renamed from: a, reason: collision with root package name */
    private static final int f13094a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;

    public static class DirectMailStatusReceiver extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private static final String f13095a = "com.xiaomi.market.DIRECT_MAIL_CHECK_RESULT";
        private static final String b = "com.xiaomi.market.DIRECT_MAIL_STATUS";
        private static final String c = "com.xiaomi.market.DIRECT_MAIL_DOWNLOAD_PROGRESS";
        private BaseAdUnit d;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).getOptions().put("packageName", str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).getOptions().put("packageName", str);
            }
        }

        public void a(Context context, BaseAdUnit baseAdUnit) {
            if (context == null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(f13095a);
            intentFilter.addAction(b);
            intentFilter.addAction(c);
            this.d = baseAdUnit;
            v.a(context, this, intentFilter);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Bundle extras = intent.getExtras();
            if (TextUtils.isEmpty(action) || extras == null) {
                return;
            }
            action.getClass();
            switch (action) {
                case "com.xiaomi.market.DIRECT_MAIL_STATUS":
                    int i = extras.getInt("statusCode");
                    String string = extras.getString("packageName");
                    SigmobLog.d("MiMarketManager: statusCode:" + i + " packageName:" + string);
                    ae.a("mimarket_status", String.valueOf(i), this.d, new AaHO0E(string, 11));
                    break;
                case "com.xiaomi.market.DIRECT_MAIL_DOWNLOAD_PROGRESS":
                    int i2 = extras.getInt("downloadProgress");
                    String string2 = extras.getString("packageName");
                    ae.a("mimarket_download_progress", String.valueOf(i2), this.d, new AaHO0E(string2, 12));
                    SigmobLog.d("MiMarketManager: downloadProgress:" + i2 + " packageName:" + string2);
                    break;
                case "com.xiaomi.market.DIRECT_MAIL_CHECK_RESULT":
                    int i3 = extras.getInt("styleCheckResult");
                    String string3 = extras.getString("packageName");
                    ae.a("mimarket_check_result", i3 == 0 ? "1" : Constants.FAIL, this.d, new AaHO0E(string3, 10));
                    SigmobLog.d("MiMarketManager: styleResult:" + i3 + " packageName:" + string3);
                    break;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).getOptions().put("packageName", str);
            }
        }
    }

    public static void a(Context context, ArrayList<String> arrayList) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider/referrer"), null, null, null, null);
        while (query != null) {
            try {
                if (!query.moveToFirst()) {
                    break;
                }
                query.getString(0);
                query.getString(1);
                query.getString(2);
                query.getString(3);
            } finally {
            }
        }
        if (query != null) {
            query.close();
        }
    }

    public static void b(Context context, ArrayList<String> arrayList) {
        ArrayList parcelableArrayList;
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("packageNames", arrayList);
        Bundle call = context.getContentResolver().call(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider/status"), "queryDownloadStatus", (String) null, bundle);
        if (call == null || (parcelableArrayList = call.getParcelableArrayList("packageNames")) == null || parcelableArrayList.isEmpty()) {
            return;
        }
        for (Object obj : parcelableArrayList) {
            if (obj != null && (obj instanceof Bundle)) {
                Bundle bundle2 = (Bundle) obj;
                SigmobLog.d("packageName = " + bundle2.getString("packageName") + ", status = " + bundle2.getInt("status") + ", progress = " + bundle2.getInt(PointCategory.PROGRESS));
            }
        }
    }
}
