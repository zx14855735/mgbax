package QgOIY0;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.sigmob.sdk.base.views.r;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ADYaiT extends A5SV6n {
    @Override // QgOIY0.A5SV6n
    public final Notification B25kr6(A4TApA a4TApA, OLy1FW.AzWtSf azWtSf) {
        Notification.Builder remoteInputHistory;
        Context context = a4TApA.f7489A5SV6n;
        Notification notification = a4TApA.f7487A2egSU;
        CharSequence charSequence = a4TApA.f7490ADYaiT;
        CharSequence charSequence2 = a4TApA.AMqCpz;
        PendingIntent pendingIntent = a4TApA.f7491ARc23Z;
        boolean z = a4TApA.f7494AZOQYO;
        ArrayList arrayList = a4TApA.f7488A4TApA;
        remoteInputHistory = new Notification.Builder(context).setWhen(notification.when).setShowWhen(true).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(null).setContentInfo(null).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & r.b.d) != 0).setLargeIcon((Bitmap) null).setNumber(0).setUsesChronometer(false).setPriority(0).setProgress(0, 0, false).setLocalOnly(z).setExtras(null).setGroup(null).setGroupSummary(false).setSortKey(null).setCategory(null).setColor(0).setVisibility(0).setPublicVersion(null).setRemoteInputHistory(null);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            remoteInputHistory.addPerson((String) it.next());
        }
        Iterator it2 = a4TApA.f7493AYUAbz.iterator();
        if (it2.hasNext()) {
            if (it2.next() == null) {
                throw null;
            }
            throw new ClassCastException();
        }
        A2egSU a2egSU = a4TApA.f7492ASJ6gh;
        if (a2egSU != null) {
            new Notification.BigTextStyle(remoteInputHistory).setBigContentTitle(null).bigText(a2egSU.f7486A4TApA);
        }
        Notification build = remoteInputHistory.build();
        if (a4TApA.f7492ASJ6gh != null) {
            Bundle bundle = build.extras;
        }
        return build;
    }
}
