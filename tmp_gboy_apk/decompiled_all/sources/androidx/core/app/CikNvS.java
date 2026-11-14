package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import com.sigmob.sdk.base.views.r;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CikNvS {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Context f8555A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Notification.Builder f8556A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final BV3sI0 f8557A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final RemoteViews f8558ADYaiT;
    public final RemoteViews AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final Bundle f8559ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final int f8560ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final RemoteViews f8561AYUAbz;

    public CikNvS(BV3sI0 bV3sI0) {
        CharSequence charSequence;
        int i;
        Bundle[] bundleArr;
        ArrayList arrayList;
        Bitmap A2egSU2;
        new ArrayList();
        this.f8559ARc23Z = new Bundle();
        this.f8557A5SV6n = bV3sI0;
        Context context = bV3sI0.f8511A2egSU;
        this.f8555A2egSU = context;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            this.f8556A4TApA = CSDoyG.A2egSU(context, bV3sI0.f8544CNPG0E);
        } else {
            this.f8556A4TApA = new Notification.Builder(bV3sI0.f8511A2egSU);
        }
        Notification notification = bV3sI0.f8551CikNvS;
        int i3 = 2;
        this.f8556A4TApA.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, bV3sI0.f8518AZOQYO).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(bV3sI0.AMqCpz).setContentText(bV3sI0.f8515ARc23Z).setContentInfo(bV3sI0.f8520AaHO0E).setContentIntent(bV3sI0.f8516ASJ6gh).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(bV3sI0.f8517AYUAbz, (notification.flags & r.b.d) != 0).setNumber(bV3sI0.f8521AcNBzu).setProgress(bV3sI0.f8528B4ZgIw, bV3sI0.f8529B7CMnp, bV3sI0.f8530B9tovu);
        if (i2 < 23) {
            Notification.Builder builder = this.f8556A4TApA;
            IconCompat iconCompat = bV3sI0.f8519AZkASS;
            if (iconCompat != null) {
                int i4 = iconCompat.f8574A2egSU;
                if (i4 == -1 && i2 >= 23) {
                    Object obj = iconCompat.f8575A4TApA;
                    if (obj instanceof Bitmap) {
                        A2egSU2 = (Bitmap) obj;
                    }
                } else if (i4 == 1) {
                    A2egSU2 = (Bitmap) iconCompat.f8575A4TApA;
                } else {
                    if (i4 != 5) {
                        throw new IllegalStateException("called getBitmap() on " + iconCompat);
                    }
                    A2egSU2 = IconCompat.A2egSU((Bitmap) iconCompat.f8575A4TApA, true);
                }
                builder.setLargeIcon(A2egSU2);
            }
            A2egSU2 = null;
            builder.setLargeIcon(A2egSU2);
        } else {
            Notification.Builder builder2 = this.f8556A4TApA;
            IconCompat iconCompat2 = bV3sI0.f8519AZkASS;
            COJEAR.A4TApA(builder2, iconCompat2 == null ? null : iconCompat2.ASJ6gh(context));
        }
        this.f8556A4TApA.setSubText(bV3sI0.f8526B2KMhB).setUsesChronometer(bV3sI0.f8524AzWtSf).setPriority(bV3sI0.f8522AlLFFp);
        C4FrIb c4FrIb = bV3sI0.f8525B25kr6;
        if (c4FrIb instanceof BniPrB) {
            BniPrB bniPrB = (BniPrB) c4FrIb;
            int A4TApA2 = BPw6Q8.ASJ6gh.A4TApA(bniPrB.f8553A2egSU.f8511A2egSU, 2131099691);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) bniPrB.f8553A2egSU.f8511A2egSU.getResources().getString(2131886157));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(A4TApA2), 0, spannableStringBuilder.length(), 18);
            Context context2 = bniPrB.f8553A2egSU.f8511A2egSU;
            PorterDuff.Mode mode = IconCompat.f8573AaHO0E;
            context2.getClass();
            IconCompat A4TApA3 = IconCompat.A4TApA(context2.getResources(), context2.getPackageName(), 2131230974);
            Bundle bundle = new Bundle();
            CharSequence A4TApA4 = BV3sI0.A4TApA(spannableStringBuilder);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            BNL6CD bnl6cd = new BNL6CD(A4TApA3, A4TApA4, null, bundle, arrayList3.isEmpty() ? null : (CtxOCS[]) arrayList3.toArray(new CtxOCS[arrayList3.size()]), arrayList2.isEmpty() ? null : (CtxOCS[]) arrayList2.toArray(new CtxOCS[arrayList2.size()]));
            bnl6cd.f8503A2egSU.putBoolean("key_action_priority", true);
            ArrayList arrayList4 = new ArrayList(3);
            arrayList4.add(bnl6cd);
            ArrayList arrayList5 = bniPrB.f8553A2egSU.f8512A4TApA;
            if (arrayList5 != null) {
                Iterator it = arrayList5.iterator();
                while (it.hasNext()) {
                    BNL6CD bnl6cd2 = (BNL6CD) it.next();
                    bnl6cd2.getClass();
                    if (!bnl6cd2.f8503A2egSU.getBoolean("key_action_priority") && i3 > 1) {
                        arrayList4.add(bnl6cd2);
                        i3--;
                    }
                }
            }
            Iterator it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                A2egSU((BNL6CD) it2.next());
            }
        } else {
            Iterator it3 = bV3sI0.f8512A4TApA.iterator();
            while (it3.hasNext()) {
                A2egSU((BNL6CD) it3.next());
            }
        }
        Bundle bundle2 = bV3sI0.f8538BV3sI0;
        if (bundle2 != null) {
            this.f8559ARc23Z.putAll(bundle2);
        }
        int i5 = Build.VERSION.SDK_INT;
        this.f8558ADYaiT = bV3sI0.f8541C2rE4F;
        this.AMqCpz = bV3sI0.f8542C4FrIb;
        this.f8556A4TApA.setShowWhen(bV3sI0.f8523AmA8tU);
        CASmeH.AZOQYO(this.f8556A4TApA, bV3sI0.f8534BJ7GGh);
        CASmeH.ASJ6gh(this.f8556A4TApA, bV3sI0.f8531BChYOn);
        CASmeH.AZkASS(this.f8556A4TApA, bV3sI0.f8533BIYEnU);
        CASmeH.AYUAbz(this.f8556A4TApA, bV3sI0.f8532BI9f7h);
        this.f8560ASJ6gh = bV3sI0.f8548CTkVKb;
        CNPG0E.A4TApA(this.f8556A4TApA, bV3sI0.f8537BTvldC);
        CNPG0E.A5SV6n(this.f8556A4TApA, bV3sI0.f8539BmvVmW);
        CNPG0E.ARc23Z(this.f8556A4TApA, bV3sI0.f8540BniPrB);
        CNPG0E.ADYaiT(this.f8556A4TApA, bV3sI0.BpkvW3);
        CNPG0E.AMqCpz(this.f8556A4TApA, notification.sound, notification.audioAttributes);
        ArrayList arrayList6 = bV3sI0.f8552CkXcdM;
        ArrayList arrayList7 = bV3sI0.f8513A5SV6n;
        if (i5 < 28) {
            if (arrayList7 == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(arrayList7.size());
                Iterator it4 = arrayList7.iterator();
                if (it4.hasNext()) {
                    throw ADYaiT.CtFAbx.A5SV6n(it4);
                }
            }
            if (arrayList != null) {
                if (arrayList6 == null) {
                    arrayList6 = arrayList;
                } else {
                    B25kr6.AMqCpz aMqCpz = new B25kr6.AMqCpz(arrayList6.size() + arrayList.size());
                    aMqCpz.addAll(arrayList);
                    aMqCpz.addAll(arrayList6);
                    arrayList6 = new ArrayList(aMqCpz);
                }
            }
        }
        if (arrayList6 != null && !arrayList6.isEmpty()) {
            Iterator it5 = arrayList6.iterator();
            while (it5.hasNext()) {
                CNPG0E.A2egSU(this.f8556A4TApA, (String) it5.next());
            }
        }
        this.f8561AYUAbz = bV3sI0.f8543CASmeH;
        ArrayList arrayList8 = bV3sI0.f8514ADYaiT;
        if (arrayList8.size() > 0) {
            if (bV3sI0.f8538BV3sI0 == null) {
                bV3sI0.f8538BV3sI0 = new Bundle();
            }
            Bundle bundle3 = bV3sI0.f8538BV3sI0.getBundle("android.car.EXTENSIONS");
            bundle3 = bundle3 == null ? new Bundle() : bundle3;
            Bundle bundle4 = new Bundle(bundle3);
            Bundle bundle5 = new Bundle();
            for (int i6 = 0; i6 < arrayList8.size(); i6++) {
                String num = Integer.toString(i6);
                BNL6CD bnl6cd3 = (BNL6CD) arrayList8.get(i6);
                Bundle bundle6 = new Bundle();
                IconCompat A2egSU3 = bnl6cd3.A2egSU();
                bundle6.putInt("icon", A2egSU3 != null ? A2egSU3.A5SV6n() : 0);
                bundle6.putCharSequence("title", bnl6cd3.f8508ASJ6gh);
                bundle6.putParcelable("actionIntent", bnl6cd3.f8509AYUAbz);
                Bundle bundle7 = bnl6cd3.f8503A2egSU;
                Bundle bundle8 = bundle7 != null ? new Bundle(bundle7) : new Bundle();
                bundle8.putBoolean("android.support.allowGeneratedReplies", bnl6cd3.f8506ADYaiT);
                bundle6.putBundle("extras", bundle8);
                CtxOCS[] ctxOCSArr = bnl6cd3.f8505A5SV6n;
                if (ctxOCSArr == null) {
                    bundleArr = null;
                } else {
                    bundleArr = new Bundle[ctxOCSArr.length];
                    if (ctxOCSArr.length > 0) {
                        CtxOCS ctxOCS = ctxOCSArr[0];
                        new Bundle();
                        throw null;
                    }
                }
                bundle6.putParcelableArray("remoteInputs", bundleArr);
                bundle6.putBoolean("showsUserInterface", bnl6cd3.AMqCpz);
                bundle6.putInt("semanticAction", 0);
                bundle5.putBundle(num, bundle6);
            }
            charSequence = null;
            bundle3.putBundle("invisible_actions", bundle5);
            bundle4.putBundle("invisible_actions", bundle5);
            if (bV3sI0.f8538BV3sI0 == null) {
                bV3sI0.f8538BV3sI0 = new Bundle();
            }
            bV3sI0.f8538BV3sI0.putBundle("android.car.EXTENSIONS", bundle3);
            this.f8559ARc23Z.putBundle("android.car.EXTENSIONS", bundle4);
        } else {
            charSequence = null;
        }
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 24) {
            this.f8556A4TApA.setExtras(bV3sI0.f8538BV3sI0);
            CQhlFr.AMqCpz(this.f8556A4TApA, bV3sI0.f8527B3GDIM);
            RemoteViews remoteViews = bV3sI0.f8541C2rE4F;
            if (remoteViews != null) {
                CQhlFr.A5SV6n(this.f8556A4TApA, remoteViews);
            }
            RemoteViews remoteViews2 = bV3sI0.f8542C4FrIb;
            if (remoteViews2 != null) {
                CQhlFr.A4TApA(this.f8556A4TApA, remoteViews2);
            }
            RemoteViews remoteViews3 = bV3sI0.f8543CASmeH;
            if (remoteViews3 != null) {
                CQhlFr.ADYaiT(this.f8556A4TApA, remoteViews3);
            }
        }
        if (i7 >= 26) {
            CSDoyG.A4TApA(this.f8556A4TApA, bV3sI0.f8545COJEAR);
            CSDoyG.AMqCpz(this.f8556A4TApA, charSequence);
            CSDoyG.ARc23Z(this.f8556A4TApA, bV3sI0.f8546CQhlFr);
            CSDoyG.ASJ6gh(this.f8556A4TApA, bV3sI0.f8547CSDoyG);
            CSDoyG.ADYaiT(this.f8556A4TApA, bV3sI0.f8548CTkVKb);
            if (bV3sI0.f8536BPw6Q8) {
                CSDoyG.A5SV6n(this.f8556A4TApA, bV3sI0.f8535BNL6CD);
            }
            if (!TextUtils.isEmpty(bV3sI0.f8544CNPG0E)) {
                this.f8556A4TApA.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i7 >= 28) {
            Iterator it6 = arrayList7.iterator();
            if (it6.hasNext()) {
                throw ADYaiT.CtFAbx.A5SV6n(it6);
            }
        }
        if (i7 >= 29) {
            CcAIMM.A2egSU(this.f8556A4TApA, bV3sI0.f8550Cd8JRx);
            CcAIMM.A4TApA(this.f8556A4TApA, null);
        }
        if (i7 < 31 || (i = bV3sI0.f8549CcAIMM) == 0) {
            return;
        }
        Cd8JRx.A4TApA(this.f8556A4TApA, i);
    }

    public static void A4TApA(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -4;
    }

    public final void A2egSU(BNL6CD bnl6cd) {
        int i = Build.VERSION.SDK_INT;
        IconCompat A2egSU2 = bnl6cd.A2egSU();
        PendingIntent pendingIntent = bnl6cd.f8509AYUAbz;
        CharSequence charSequence = bnl6cd.f8508ASJ6gh;
        Notification.Action.Builder A2egSU3 = i >= 23 ? COJEAR.A2egSU(A2egSU2 != null ? A2egSU2.ASJ6gh(null) : null, charSequence, pendingIntent) : CASmeH.AMqCpz(A2egSU2 != null ? A2egSU2.A5SV6n() : 0, charSequence, pendingIntent);
        CtxOCS[] ctxOCSArr = bnl6cd.f8505A5SV6n;
        if (ctxOCSArr != null) {
            RemoteInput[] remoteInputArr = new RemoteInput[ctxOCSArr.length];
            if (ctxOCSArr.length > 0) {
                CtxOCS ctxOCS = ctxOCSArr[0];
                throw null;
            }
            for (RemoteInput remoteInput : remoteInputArr) {
                CASmeH.A5SV6n(A2egSU3, remoteInput);
            }
        }
        Bundle bundle = bnl6cd.f8503A2egSU;
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        boolean z = bnl6cd.f8506ADYaiT;
        bundle2.putBoolean("android.support.allowGeneratedReplies", z);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            CQhlFr.A2egSU(A2egSU3, z);
        }
        bundle2.putInt("android.support.action.semanticAction", 0);
        if (i2 >= 28) {
            CTkVKb.A4TApA(A2egSU3, 0);
        }
        if (i2 >= 29) {
            CcAIMM.A5SV6n(A2egSU3, false);
        }
        if (i2 >= 31) {
            Cd8JRx.A2egSU(A2egSU3, false);
        }
        bundle2.putBoolean("android.support.action.showsUserInterface", bnl6cd.AMqCpz);
        CASmeH.A4TApA(A2egSU3, bundle2);
        CASmeH.A2egSU(this.f8556A4TApA, CASmeH.ADYaiT(A2egSU3));
    }

    public Context getContext() {
        return this.f8555A2egSU;
    }
}
