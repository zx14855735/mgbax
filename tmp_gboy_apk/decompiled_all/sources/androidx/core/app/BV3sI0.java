package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BV3sI0 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Context f8511A2egSU;
    public CharSequence AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public CharSequence f8515ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public PendingIntent f8516ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public PendingIntent f8517AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public RemoteViews f8518AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public IconCompat f8519AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public CharSequence f8520AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f8521AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f8522AlLFFp;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f8524AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public C4FrIb f8525B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public CharSequence f8526B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public CharSequence[] f8527B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int f8528B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public int f8529B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f8530B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public String f8531BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public boolean f8532BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public String f8533BIYEnU;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public boolean f8535BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public boolean f8536BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public String f8537BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public Bundle f8538BV3sI0;
    public Notification BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public RemoteViews f8541C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public RemoteViews f8542C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public RemoteViews f8543CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public String f8544CNPG0E;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public String f8546CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public long f8547CSDoyG;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public final boolean f8550Cd8JRx;

    /* renamed from: CikNvS, reason: collision with root package name */
    public final Notification f8551CikNvS;

    /* renamed from: CkXcdM, reason: collision with root package name */
    public final ArrayList f8552CkXcdM;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ArrayList f8512A4TApA = new ArrayList();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ArrayList f8513A5SV6n = new ArrayList();

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final ArrayList f8514ADYaiT = new ArrayList();

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f8523AmA8tU = true;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public boolean f8534BJ7GGh = false;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public int f8539BmvVmW = 0;

    /* renamed from: BniPrB, reason: collision with root package name */
    public int f8540BniPrB = 0;

    /* renamed from: COJEAR, reason: collision with root package name */
    public int f8545COJEAR = 0;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public int f8548CTkVKb = 0;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public int f8549CcAIMM = 0;

    public BV3sI0(Context context, String str) {
        Notification notification = new Notification();
        this.f8551CikNvS = notification;
        this.f8511A2egSU = context;
        this.f8544CNPG0E = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.f8522AlLFFp = 0;
        this.f8552CkXcdM = new ArrayList();
        this.f8550Cd8JRx = true;
    }

    public static CharSequence A4TApA(CharSequence charSequence) {
        return charSequence == null ? charSequence : charSequence.length() > 5120 ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public final Notification A2egSU() {
        Notification notification;
        Bundle bundle;
        RemoteViews AYUAbz2;
        RemoteViews ARc23Z2;
        CikNvS cikNvS = new CikNvS(this);
        BV3sI0 bV3sI0 = cikNvS.f8557A5SV6n;
        C4FrIb c4FrIb = bV3sI0.f8525B25kr6;
        if (c4FrIb != null) {
            c4FrIb.A4TApA(cikNvS);
        }
        RemoteViews ASJ6gh2 = c4FrIb != null ? c4FrIb.ASJ6gh() : null;
        int i = Build.VERSION.SDK_INT;
        Notification.Builder builder = cikNvS.f8556A4TApA;
        if (i >= 26) {
            notification = builder.build();
        } else {
            int i2 = cikNvS.f8560ASJ6gh;
            if (i >= 24) {
                notification = builder.build();
                if (i2 != 0) {
                    if (CASmeH.ARc23Z(notification) != null && (notification.flags & 512) != 0 && i2 == 2) {
                        CikNvS.A4TApA(notification);
                    }
                    if (CASmeH.ARc23Z(notification) != null && (notification.flags & 512) == 0 && i2 == 1) {
                        CikNvS.A4TApA(notification);
                    }
                }
            } else {
                builder.setExtras(cikNvS.f8559ARc23Z);
                Notification build = builder.build();
                RemoteViews remoteViews = cikNvS.f8558ADYaiT;
                if (remoteViews != null) {
                    build.contentView = remoteViews;
                }
                RemoteViews remoteViews2 = cikNvS.AMqCpz;
                if (remoteViews2 != null) {
                    build.bigContentView = remoteViews2;
                }
                RemoteViews remoteViews3 = cikNvS.f8561AYUAbz;
                if (remoteViews3 != null) {
                    build.headsUpContentView = remoteViews3;
                }
                if (i2 != 0) {
                    if (CASmeH.ARc23Z(build) != null && (build.flags & 512) != 0 && i2 == 2) {
                        CikNvS.A4TApA(build);
                    }
                    if (CASmeH.ARc23Z(build) != null && (build.flags & 512) == 0 && i2 == 1) {
                        CikNvS.A4TApA(build);
                    }
                }
                notification = build;
            }
        }
        if (ASJ6gh2 != null) {
            notification.contentView = ASJ6gh2;
        } else {
            RemoteViews remoteViews4 = bV3sI0.f8541C2rE4F;
            if (remoteViews4 != null) {
                notification.contentView = remoteViews4;
            }
        }
        if (c4FrIb != null && (ARc23Z2 = c4FrIb.ARc23Z()) != null) {
            notification.bigContentView = ARc23Z2;
        }
        if (c4FrIb != null && (AYUAbz2 = bV3sI0.f8525B25kr6.AYUAbz()) != null) {
            notification.headsUpContentView = AYUAbz2;
        }
        if (c4FrIb != null && (bundle = notification.extras) != null) {
            c4FrIb.A2egSU(bundle);
        }
        return notification;
    }

    public final void A5SV6n(boolean z) {
        AMqCpz(16, z);
    }

    public final void ADYaiT(int i) {
        Notification notification = this.f8551CikNvS;
        notification.defaults = i;
        if ((i & 4) != 0) {
            notification.flags |= 1;
        }
    }

    public final void AMqCpz(int i, boolean z) {
        Notification notification = this.f8551CikNvS;
        if (z) {
            notification.flags = i | notification.flags;
        } else {
            notification.flags = (~i) & notification.flags;
        }
    }

    public final void ARc23Z(Bitmap bitmap) {
        IconCompat iconCompat;
        if (bitmap == null) {
            iconCompat = null;
        } else {
            if (Build.VERSION.SDK_INT < 27) {
                Resources resources = this.f8511A2egSU.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(2131165281);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(2131165280);
                if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                    double min = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
                    bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * min), (int) Math.ceil(bitmap.getHeight() * min), true);
                }
            }
            PorterDuff.Mode mode = IconCompat.f8573AaHO0E;
            bitmap.getClass();
            IconCompat iconCompat2 = new IconCompat(1);
            iconCompat2.f8575A4TApA = bitmap;
            iconCompat = iconCompat2;
        }
        this.f8519AZkASS = iconCompat;
    }

    public final void ASJ6gh(C4FrIb c4FrIb) {
        if (this.f8525B25kr6 != c4FrIb) {
            this.f8525B25kr6 = c4FrIb;
            if (c4FrIb == null || c4FrIb.f8553A2egSU == this) {
                return;
            }
            c4FrIb.f8553A2egSU = this;
            ASJ6gh(c4FrIb);
        }
    }
}
