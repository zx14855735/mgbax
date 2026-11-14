package com.kwad.sdk.api.push;

import A5SV6n.A2egSU;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.app.BNL6CD;
import androidx.core.app.BTvldC;
import androidx.core.app.BV3sI0;
import androidx.core.app.C2rE4F;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.sigmob.sdk.base.views.r;

@KsAdSdkApi
@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class KsNotificationCompat {

    @KsAdSdkApi
    @A2egSU
    public static final class Builder {
        private BV3sI0 mBuilder;

        public Builder(Context context, String str) {
            try {
                this.mBuilder = new BV3sI0(context, str);
            } catch (Throwable unused) {
                this.mBuilder = new BV3sI0(context, null);
            }
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.mBuilder.f8512A4TApA.add(new BNL6CD(i, charSequence, pendingIntent));
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder addExtras(Bundle bundle) {
            BV3sI0 bV3sI0 = this.mBuilder;
            if (bundle == null) {
                bV3sI0.getClass();
                return this;
            }
            Bundle bundle2 = bV3sI0.f8538BV3sI0;
            if (bundle2 == null) {
                bV3sI0.f8538BV3sI0 = new Bundle(bundle);
                return this;
            }
            bundle2.putAll(bundle);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder addPerson(String str) {
            BV3sI0 bV3sI0 = this.mBuilder;
            bV3sI0.getClass();
            if (str != null && !str.isEmpty()) {
                bV3sI0.f8552CkXcdM.add(str);
            }
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Notification build() {
            return this.mBuilder.A2egSU();
        }

        @KsAdSdkApi
        @A2egSU
        public final Bundle getExtras() {
            BV3sI0 bV3sI0 = this.mBuilder;
            if (bV3sI0.f8538BV3sI0 == null) {
                bV3sI0.f8538BV3sI0 = new Bundle();
            }
            return bV3sI0.f8538BV3sI0;
        }

        @KsAdSdkApi
        @A2egSU
        public final Notification getNotification() {
            return build();
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setAutoCancel(boolean z) {
            this.mBuilder.A5SV6n(z);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setBadgeIconType(int i) {
            this.mBuilder.f8545COJEAR = i;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setCategory(String str) {
            this.mBuilder.f8537BTvldC = str;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setChannelId(String str) {
            this.mBuilder.f8544CNPG0E = str;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setColor(int i) {
            this.mBuilder.f8539BmvVmW = i;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setColorized(boolean z) {
            BV3sI0 bV3sI0 = this.mBuilder;
            bV3sI0.f8535BNL6CD = z;
            bV3sI0.f8536BPw6Q8 = true;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setContent(RemoteViews remoteViews) {
            this.mBuilder.f8551CikNvS.contentView = remoteViews;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setContentInfo(CharSequence charSequence) {
            BV3sI0 bV3sI0 = this.mBuilder;
            bV3sI0.getClass();
            bV3sI0.f8520AaHO0E = BV3sI0.A4TApA(charSequence);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setContentIntent(PendingIntent pendingIntent) {
            this.mBuilder.f8516ASJ6gh = pendingIntent;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setContentText(CharSequence charSequence) {
            BV3sI0 bV3sI0 = this.mBuilder;
            bV3sI0.getClass();
            bV3sI0.f8515ARc23Z = BV3sI0.A4TApA(charSequence);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setContentTitle(CharSequence charSequence) {
            BV3sI0 bV3sI0 = this.mBuilder;
            bV3sI0.getClass();
            bV3sI0.AMqCpz = BV3sI0.A4TApA(charSequence);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setCustomBigContentView(RemoteViews remoteViews) {
            this.mBuilder.f8542C4FrIb = remoteViews;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setCustomContentView(RemoteViews remoteViews) {
            this.mBuilder.f8541C2rE4F = remoteViews;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setCustomHeadsUpContentView(RemoteViews remoteViews) {
            this.mBuilder.f8543CASmeH = remoteViews;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setDecoratedCustomStyle() {
            this.mBuilder.ASJ6gh(new C2rE4F());
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setDefaults(int i) {
            this.mBuilder.ADYaiT(i);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setDeleteIntent(PendingIntent pendingIntent) {
            this.mBuilder.f8551CikNvS.deleteIntent = pendingIntent;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setExtras(Bundle bundle) {
            this.mBuilder.f8538BV3sI0 = bundle;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setFullScreenIntent(PendingIntent pendingIntent, boolean z) {
            BV3sI0 bV3sI0 = this.mBuilder;
            bV3sI0.f8517AYUAbz = pendingIntent;
            bV3sI0.AMqCpz(r.b.d, z);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setGroup(String str) {
            this.mBuilder.f8531BChYOn = str;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setGroupAlertBehavior(int i) {
            this.mBuilder.f8548CTkVKb = i;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setGroupSummary(boolean z) {
            this.mBuilder.f8532BI9f7h = z;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setLargeIcon(Bitmap bitmap) {
            this.mBuilder.ARc23Z(bitmap);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setLights(int i, int i2, int i3) {
            Notification notification = this.mBuilder.f8551CikNvS;
            notification.ledARGB = i;
            notification.ledOnMS = i2;
            notification.ledOffMS = i3;
            notification.flags = ((i2 == 0 || i3 == 0) ? 0 : 1) | (notification.flags & (-2));
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setLocalOnly(boolean z) {
            this.mBuilder.f8534BJ7GGh = z;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setNumber(int i) {
            this.mBuilder.f8521AcNBzu = i;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setOngoing(boolean z) {
            this.mBuilder.AMqCpz(2, z);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setOnlyAlertOnce(boolean z) {
            this.mBuilder.AMqCpz(8, z);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setPriority(int i) {
            this.mBuilder.f8522AlLFFp = i;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setProgress(int i, int i2, boolean z) {
            BV3sI0 bV3sI0 = this.mBuilder;
            bV3sI0.f8528B4ZgIw = i;
            bV3sI0.f8529B7CMnp = i2;
            bV3sI0.f8530B9tovu = z;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setPublicVersion(Notification notification) {
            this.mBuilder.BpkvW3 = notification;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setRemoteInputHistory(CharSequence[] charSequenceArr) {
            this.mBuilder.f8527B3GDIM = charSequenceArr;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setShortcutId(String str) {
            this.mBuilder.f8546CQhlFr = str;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setShowWhen(boolean z) {
            this.mBuilder.f8523AmA8tU = z;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setSmallIcon(int i) {
            this.mBuilder.f8551CikNvS.icon = i;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setSortKey(String str) {
            this.mBuilder.f8533BIYEnU = str;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setSound(Uri uri) {
            Notification notification = this.mBuilder.f8551CikNvS;
            notification.sound = uri;
            notification.audioStreamType = -1;
            notification.audioAttributes = BTvldC.A2egSU(BTvldC.AMqCpz(BTvldC.A5SV6n(BTvldC.A4TApA(), 4), 5));
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setSubText(CharSequence charSequence) {
            BV3sI0 bV3sI0 = this.mBuilder;
            bV3sI0.getClass();
            bV3sI0.f8526B2KMhB = BV3sI0.A4TApA(charSequence);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setTicker(CharSequence charSequence) {
            this.mBuilder.f8551CikNvS.tickerText = BV3sI0.A4TApA(charSequence);
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setTimeoutAfter(long j) {
            this.mBuilder.f8547CSDoyG = j;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setUsesChronometer(boolean z) {
            this.mBuilder.f8524AzWtSf = z;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setVibrate(long[] jArr) {
            this.mBuilder.f8551CikNvS.vibrate = jArr;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setVisibility(int i) {
            this.mBuilder.f8540BniPrB = i;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setWhen(long j) {
            this.mBuilder.f8551CikNvS.when = j;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setSmallIcon(int i, int i2) {
            Notification notification = this.mBuilder.f8551CikNvS;
            notification.icon = i;
            notification.iconLevel = i2;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
            BV3sI0 bV3sI0 = this.mBuilder;
            bV3sI0.f8551CikNvS.tickerText = BV3sI0.A4TApA(charSequence);
            bV3sI0.f8518AZOQYO = remoteViews;
            return this;
        }

        @KsAdSdkApi
        @A2egSU
        public Builder(Context context) {
            this(context, null);
        }

        @KsAdSdkApi
        @A2egSU
        public final Builder setSound(Uri uri, int i) {
            Notification notification = this.mBuilder.f8551CikNvS;
            notification.sound = uri;
            notification.audioStreamType = i;
            notification.audioAttributes = BTvldC.A2egSU(BTvldC.ADYaiT(BTvldC.A5SV6n(BTvldC.A4TApA(), 4), i));
            return this;
        }
    }
}
