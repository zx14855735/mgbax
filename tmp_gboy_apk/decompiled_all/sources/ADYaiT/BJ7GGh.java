package ADYaiT;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.sigmob.sdk.base.views.r;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class BJ7GGh {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final BI9f7h f97AcNBzu = new BI9f7h(new BIYEnU(0));

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static int f98AlLFFp = -100;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static C2rE4F.AYUAbz f99AmA8tU = null;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static C2rE4F.AYUAbz f100AzWtSf = null;

    /* renamed from: B25kr6, reason: collision with root package name */
    public static Boolean f101B25kr6 = null;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static boolean f102B2KMhB = false;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static final B25kr6.AMqCpz f103B3GDIM = new B25kr6.AMqCpz();

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static final Object f104B4ZgIw = new Object();

    /* renamed from: B7CMnp, reason: collision with root package name */
    public static final Object f105B7CMnp = new Object();

    static {
        XJpLRlR();
    }

    public static boolean A4TApA(Context context) {
        if (f101B25kr6 == null) {
            try {
                int i = D6yqiO.f218AcNBzu;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) D6yqiO.class), Build.VERSION.SDK_INT >= 24 ? D6DOie.A2egSU() | r.b.d : MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK).metaData;
                if (bundle != null) {
                    f101B25kr6 = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                f101B25kr6 = Boolean.FALSE;
            }
        }
        return f101B25kr6.booleanValue();
    }

    public static void AMqCpz(CkXcdM ckXcdM) {
        synchronized (f104B4ZgIw) {
            try {
                B25kr6.AMqCpz aMqCpz = f103B3GDIM;
                aMqCpz.getClass();
                B25kr6.A2egSU a2egSU = new B25kr6.A2egSU(aMqCpz);
                while (a2egSU.hasNext()) {
                    BJ7GGh bJ7GGh = (BJ7GGh) ((WeakReference) a2egSU.next()).get();
                    if (bJ7GGh == ckXcdM || bJ7GGh == null) {
                        a2egSU.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void AaHO0E(int i) {
        if ((i == -1 || i == 0 || i == 1 || i == 2 || i == 3) && f98AlLFFp != i) {
            f98AlLFFp = i;
            synchronized (f104B4ZgIw) {
                try {
                    B25kr6.AMqCpz aMqCpz = f103B3GDIM;
                    aMqCpz.getClass();
                    B25kr6.A2egSU a2egSU = new B25kr6.A2egSU(aMqCpz);
                    while (a2egSU.hasNext()) {
                        BJ7GGh bJ7GGh = (BJ7GGh) ((WeakReference) a2egSU.next()).get();
                        if (bJ7GGh != null) {
                            ((CkXcdM) bJ7GGh).AzWtSf(true, true);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static /* synthetic */ void XJpLRlR() {
        char[] charArray = "p|~=tr~v=q|j=`{v\u007f\u007f=Y}zQazwtv".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 19);
        }
        String str = new String(charArray);
        char[] charArray2 = "p\u007fz}zg".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 19);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public abstract void A2egSU();

    public abstract void A5SV6n();

    public abstract void ADYaiT();

    public abstract boolean ARc23Z(int i);

    public abstract void ASJ6gh(int i);

    public abstract void AYUAbz(View view);

    public abstract void AZOQYO(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void AlLFFp(CharSequence charSequence);

    public abstract AZOQYO.A4TApA AmA8tU(AZOQYO.A2egSU a2egSU);
}
