package NOd7IU;

import NUY5pn.B7CMnp;
import NUY5pn.B9tovu;
import OLy1FW.AzWtSf;
import android.R;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.TypedValue;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.kuaishou.weapon.p0.t;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT extends AYUAbz {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final ADYaiT f5861A4TApA = new ADYaiT();

    static {
        FRECY();
    }

    private static /* synthetic */ void FRECY() {
        char[] charArray = "dhj)`fjb)eh~)tobkk)MinEunc`b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 7);
        }
        String str = new String(charArray);
        char[] charArray2 = "dknins".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 7);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // NOd7IU.AYUAbz
    public final Intent A5SV6n(int i) {
        return super.ADYaiT(null, i, null);
    }

    public final void AMqCpz(Context context, int i, PendingIntent pendingIntent) {
        Notification B25kr62;
        int i2;
        if (i == 18) {
            new A5SV6n(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            return;
        }
        String A5SV6n2 = i == 6 ? B7CMnp.A5SV6n(context, "common_google_play_services_resolution_required_title") : B7CMnp.A4TApA(context, i);
        if (A5SV6n2 == null) {
            A5SV6n2 = context.getResources().getString(2131034118);
        }
        String ADYaiT2 = i == 6 ? B7CMnp.ADYaiT(context, "common_google_play_services_resolution_required_text", B7CMnp.A2egSU(context)) : B7CMnp.AMqCpz(context, i);
        Resources resources = context.getResources();
        if (AlLFFp.B2KMhB(context)) {
            B25kr62 = new Notification.Builder(context).setSmallIcon(context.getApplicationInfo().icon).setPriority(2).setAutoCancel(true).setContentTitle(A5SV6n2).setStyle(new Notification.BigTextStyle().bigText(ADYaiT2)).addAction(2130837505, resources.getString(2131034126), pendingIntent).build();
        } else {
            QgOIY0.A4TApA a4TApA = new QgOIY0.A4TApA();
            a4TApA.f7493AYUAbz = new ArrayList();
            a4TApA.f7494AZOQYO = false;
            Notification notification = new Notification();
            a4TApA.f7487A2egSU = notification;
            a4TApA.f7489A5SV6n = context;
            notification.when = System.currentTimeMillis();
            notification.audioStreamType = -1;
            a4TApA.f7488A4TApA = new ArrayList();
            notification.icon = R.drawable.stat_sys_warning;
            notification.tickerText = QgOIY0.A4TApA.A4TApA(resources.getString(2131034118));
            notification.when = System.currentTimeMillis();
            notification.flags |= 16;
            a4TApA.f7491ARc23Z = pendingIntent;
            a4TApA.f7490ADYaiT = QgOIY0.A4TApA.A4TApA(A5SV6n2);
            a4TApA.AMqCpz = QgOIY0.A4TApA.A4TApA(ADYaiT2);
            a4TApA.f7494AZOQYO = true;
            QgOIY0.A2egSU a2egSU = new QgOIY0.A2egSU();
            a2egSU.f7486A4TApA = QgOIY0.A4TApA.A4TApA(ADYaiT2);
            a4TApA.A2egSU(a2egSU);
            B25kr62 = QgOIY0.ASJ6gh.f7498A2egSU.B25kr6(a4TApA, new AzWtSf(7, (byte) 0));
        }
        if (i == 1 || i == 2 || i == 3) {
            AMqCpz.f5864A5SV6n.set(false);
            i2 = 10436;
        } else {
            i2 = 39789;
        }
        ((NotificationManager) context.getSystemService("notification")).notify(i2, B25kr62);
    }

    public final void ARc23Z(GoogleApiActivity googleApiActivity, int i, GoogleApiActivity googleApiActivity2) {
        AlertDialog create;
        B9tovu b9tovu = new B9tovu(super.ADYaiT(googleApiActivity, i, t.t), googleApiActivity);
        if (i == 0) {
            create = null;
        } else {
            TypedValue typedValue = new TypedValue();
            googleApiActivity.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
            AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(googleApiActivity.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(googleApiActivity, 5) : null;
            if (builder == null) {
                builder = new AlertDialog.Builder(googleApiActivity);
            }
            builder.setMessage(B7CMnp.AMqCpz(googleApiActivity, i));
            builder.setOnCancelListener(googleApiActivity2);
            String string = googleApiActivity.getResources().getString(i != 1 ? i != 2 ? i != 3 ? R.string.ok : 2131034112 : 2131034121 : 2131034115);
            if (string != null) {
                builder.setPositiveButton(string, b9tovu);
            }
            String A4TApA2 = B7CMnp.A4TApA(googleApiActivity, i);
            if (A4TApA2 != null) {
                builder.setTitle(A4TApA2);
            }
            create = builder.create();
        }
        if (create == null) {
            return;
        }
        FragmentManager fragmentManager = googleApiActivity.getFragmentManager();
        A4TApA a4TApA = new A4TApA();
        create.setOnCancelListener(null);
        create.setOnDismissListener(null);
        a4TApA.f5857AcNBzu = create;
        a4TApA.f5858AlLFFp = googleApiActivity2;
        a4TApA.show(fragmentManager, "GooglePlayServicesErrorDialog");
    }
}
