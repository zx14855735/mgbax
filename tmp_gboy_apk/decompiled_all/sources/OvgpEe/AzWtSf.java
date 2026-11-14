package OvgpEe;

import ADYaiT.CcAIMM;
import AaHO0E.GEYgCP;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AzWtSf extends CcAIMM {

    /* renamed from: BChYOn, reason: collision with root package name */
    public static final int[] f6897BChYOn = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_CHECK_ENHANCE, MediaPlayer.MEDIA_PLAYER_OPTION_LATENCYTIME, MediaPlayer.MEDIA_PLAYER_OPTION_SUB_FIRST_LOAD_TIME, 750};

    /* renamed from: BI9f7h, reason: collision with root package name */
    public static final int[] f6898BI9f7h = {1267, 1000, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_FRAME_META_CALLBACK, 0};

    /* renamed from: BIYEnU, reason: collision with root package name */
    public static final GEYgCP f6899BIYEnU = new GEYgCP(Float.class, "animationFraction", 11);

    /* renamed from: AmA8tU, reason: collision with root package name */
    public ObjectAnimator f6900AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public ObjectAnimator f6901AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final Interpolator[] f6902B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final B25kr6 f6903B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f6904B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f6905B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public float f6906B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public A5SV6n f6907B9tovu;

    static {
        JWXo();
    }

    public AzWtSf(Context context, B25kr6 b25kr6) {
        super(2);
        this.f6904B3GDIM = 0;
        this.f6907B9tovu = null;
        this.f6903B2KMhB = b25kr6;
        this.f6902B25kr6 = new Interpolator[]{AnimationUtils.loadInterpolator(context, 2130772033), AnimationUtils.loadInterpolator(context, 2130772034), AnimationUtils.loadInterpolator(context, 2130772035), AnimationUtils.loadInterpolator(context, 2130772036)};
    }

    private static /* synthetic */ void JWXo() {
        char[] charArray = "l`b!hnbj!m`v!|gjcc!EafM}fkhj".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 15);
        }
        String str = new String(charArray);
        char[] charArray2 = "lcfaf{".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 15);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // ADYaiT.CcAIMM
    public final void A5SV6n() {
        ObjectAnimator objectAnimator = this.f6900AmA8tU;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // ADYaiT.CcAIMM
    public final void AZOQYO() {
        B25kr6();
        ObjectAnimator objectAnimator = this.f6900AmA8tU;
        B25kr6 b25kr6 = this.f6903B2KMhB;
        objectAnimator.setDuration((long) (b25kr6.f6920AmA8tU * 1800.0f));
        this.f6901AzWtSf.setDuration((long) (b25kr6.f6920AmA8tU * 1800.0f));
        B2KMhB();
    }

    @Override // ADYaiT.CcAIMM
    public final void AaHO0E(A5SV6n a5SV6n) {
        this.f6907B9tovu = a5SV6n;
    }

    @Override // ADYaiT.CcAIMM
    public final void AcNBzu() {
        ObjectAnimator objectAnimator = this.f6901AzWtSf;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        A5SV6n();
        if (((AaHO0E) this.f135AcNBzu).isVisible()) {
            this.f6901AzWtSf.setFloatValues(this.f6906B7CMnp, 1.0f);
            this.f6901AzWtSf.setDuration((long) ((1.0f - this.f6906B7CMnp) * 1800.0f));
            this.f6901AzWtSf.start();
        }
    }

    @Override // ADYaiT.CcAIMM
    public final void AmA8tU() {
        B25kr6();
        B2KMhB();
        this.f6900AmA8tU.start();
    }

    @Override // ADYaiT.CcAIMM
    public final void AzWtSf() {
        this.f6907B9tovu = null;
    }

    public final void B25kr6() {
        ObjectAnimator objectAnimator = this.f6900AmA8tU;
        B25kr6 b25kr6 = this.f6903B2KMhB;
        GEYgCP gEYgCP = f6899BIYEnU;
        if (objectAnimator == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, gEYgCP, 0.0f, 1.0f);
            this.f6900AmA8tU = ofFloat;
            ofFloat.setDuration((long) (b25kr6.f6920AmA8tU * 1800.0f));
            this.f6900AmA8tU.setInterpolator(null);
            this.f6900AmA8tU.setRepeatCount(-1);
            this.f6900AmA8tU.addListener(new AmA8tU(this, 0));
        }
        if (this.f6901AzWtSf == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, gEYgCP, 1.0f);
            this.f6901AzWtSf = ofFloat2;
            ofFloat2.setDuration((long) (b25kr6.f6920AmA8tU * 1800.0f));
            this.f6901AzWtSf.setInterpolator(null);
            this.f6901AzWtSf.addListener(new AmA8tU(this, 1));
        }
    }

    public final void B2KMhB() {
        this.f6904B3GDIM = 0;
        Iterator it = ((ArrayList) this.f136AlLFFp).iterator();
        while (it.hasNext()) {
            ((AYUAbz) it.next()).f6865A5SV6n = this.f6903B2KMhB.AMqCpz[0];
        }
    }
}
