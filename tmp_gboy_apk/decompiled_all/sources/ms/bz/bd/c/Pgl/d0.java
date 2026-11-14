package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.bytedance.sdk.component.utils.pl;
import com.sigmob.sdk.base.views.r;
import java.lang.reflect.Method;
import java.util.Iterator;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class d0 extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object A4TApA(String str, Object obj) {
        Bundle bundle;
        boolean z = false;
        Context context = pblv.f14062A4TApA.f14063A2egSU;
        String str2 = pblr.f14052A2egSU;
        PackageManager packageManager = context.getPackageManager();
        IBinder iBinder = null;
        if (packageManager != null) {
            Iterator<ResolveInfo> it = packageManager.queryIntentActivities(new Intent((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e3a78d", new byte[]{117, 63, 22, 81, 8, 122, 98, 92, 57, 105, 96, com.sigmob.sdk.archives.tar.e.L, 28, 87, 73, 114, 101, 6, 57, 104, 122, Byte.MAX_VALUE, 63, 98, 46, 93}), (Uri) null), r.b.d).iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo != null && (bundle = activityInfo.applicationInfo.metaData) != null && bundle.get((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2368a1", new byte[]{59, 33, 74, 95, 91, 34, 60, 27, 105, 126, 38, 35, 86, 69, 81, 40})) != null) {
                    break;
                }
            }
        }
        String packageName = context.getPackageName();
        String str3 = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2309fd", new byte[]{34, com.sigmob.sdk.archives.tar.e.J, 87, 68, 79, 122, 37, 11});
        try {
            Method declaredMethod = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f9ecf9", new byte[]{118, com.sigmob.sdk.archives.tar.e.M, 18, 5, 86, 39, 97, 86, 59, 32, 57, 8, 19, 5, 79, 39, 102, 29, 25, com.sigmob.sdk.archives.tar.e.J, 121, 58, 17, 18, 75})).getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bca15f", new byte[]{116, 100, 6, 118, 15, 99, 119, 75, com.sigmob.sdk.archives.tar.e.K, 100}), String.class);
            declaredMethod.setAccessible(true);
            iBinder = (IBinder) declaredMethod.invoke(null, str3);
        } catch (Exception e) {
            pl.xj(e);
        }
        if (iBinder != null) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(pblr.f14052A2egSU);
                obtain.writeInt(2);
                obtain.writeString(packageName);
                obtain.writeStrongBinder(new Binder());
                if (iBinder.transact(1598837584, obtain, obtain2, 0)) {
                    obtain2.readException();
                    obtain.recycle();
                    obtain2.recycle();
                    z = true;
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return Boolean.valueOf(z);
    }
}
