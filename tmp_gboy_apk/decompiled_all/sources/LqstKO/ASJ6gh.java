package LqstKO;

import Hdahpu.AZOQYO;
import android.graphics.Rect;
import android.opengl.GLES10;
import android.opengl.GLES11;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.game.boy.activity.BIYEnU;
import java.util.ArrayList;
import java.util.Objects;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ASJ6gh {

    /* renamed from: A4TApA, reason: collision with root package name */
    public EGLSurface f4942A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public EGLContext f4943A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public AMqCpz f4944ADYaiT;
    public final ADYaiT AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public float f4945ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public float f4946ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final boolean f4947AYUAbz;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public EGL10 f4950AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public EGLDisplay f4951AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public BIYEnU f4952AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f4953AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public ARc23Z f4954AzWtSf;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Rect f4941A2egSU = new Rect(0, 0, MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA, 160);

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final ArrayList f4948AZOQYO = new ArrayList(10);

    /* renamed from: AZkASS, reason: collision with root package name */
    public final int[] f4949AZkASS = new int[1];

    public ASJ6gh(SurfaceHolder surfaceHolder) {
        boolean z = false;
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.f4950AaHO0E = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f4951AcNBzu = eglGetDisplay;
        this.f4950AaHO0E.eglInitialize(eglGetDisplay, new int[2]);
        EGLConfig A4TApA2 = A4TApA(this.f4950AaHO0E, this.f4951AcNBzu, 2);
        EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
        if (A4TApA2 != null) {
            this.f4943A5SV6n = this.f4950AaHO0E.eglCreateContext(this.f4951AcNBzu, A4TApA2, eGLContext, new int[]{12440, 2, 12344});
        }
        if (this.f4943A5SV6n != null) {
            this.AMqCpz = new A4TApA();
        } else {
            this.AMqCpz = new AZOQYO(24);
            A4TApA2 = A4TApA(this.f4950AaHO0E, this.f4951AcNBzu, 1);
            this.f4943A5SV6n = this.f4950AaHO0E.eglCreateContext(this.f4951AcNBzu, A4TApA2, eGLContext, null);
        }
        EGLSurface eglCreateWindowSurface = this.f4950AaHO0E.eglCreateWindowSurface(this.f4951AcNBzu, A4TApA2, surfaceHolder, null);
        this.f4942A4TApA = eglCreateWindowSurface;
        this.f4950AaHO0E.eglMakeCurrent(this.f4951AcNBzu, eglCreateWindowSurface, eglCreateWindowSurface, this.f4943A5SV6n);
        try {
            Objects.toString(this.f4950AaHO0E.getClass().getMethod("eglSwapInterval", EGLDisplay.class, Integer.TYPE).invoke(this.f4950AaHO0E, this.f4951AcNBzu, 1));
        } catch (Throwable th) {
            th.toString();
        }
        GLES10.glBlendFunc(770, 771);
        this.AMqCpz.a();
        String glGetString = GLES10.glGetString(7937);
        if (glGetString != null && glGetString.indexOf("Android PixelFlinger") >= 0) {
            z = true;
        }
        this.f4947AYUAbz = z;
        GLES10.glBlendFunc(770, 771);
        this.AMqCpz.a();
    }

    public static int A2egSU(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i) {
        int[] iArr = new int[1];
        if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr)) {
            return iArr[0];
        }
        return 0;
    }

    public static EGLConfig A4TApA(EGL10 egl10, EGLDisplay eGLDisplay, int i) {
        int abs;
        int i2 = 0;
        int i3 = 12324;
        int[] iArr = {12324, 5, 12323, 6, 12322, 5, 12321, 0, 12325, 0, 12326, 0, 12352, 4, 12344};
        if (i < 2) {
            iArr[12] = 12344;
        }
        int[] iArr2 = new int[1];
        egl10.eglChooseConfig(eGLDisplay, iArr, null, 0, iArr2);
        int i4 = iArr2[0];
        EGLConfig eGLConfig = null;
        if (i4 <= 0) {
            return null;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[i4];
        egl10.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i4, iArr2);
        int i5 = 1000;
        while (i2 < i4) {
            EGLConfig eGLConfig2 = eGLConfigArr[i2];
            int A2egSU2 = A2egSU(egl10, eGLDisplay, eGLConfig2, 12325);
            int A2egSU3 = A2egSU(egl10, eGLDisplay, eGLConfig2, 12326);
            if (A2egSU2 >= 0 && A2egSU3 >= 0 && (abs = Math.abs(A2egSU(egl10, eGLDisplay, eGLConfig2, 12321)) + Math.abs(A2egSU(egl10, eGLDisplay, eGLConfig2, 12322) - 5) + Math.abs(A2egSU(egl10, eGLDisplay, eGLConfig2, 12323) - 6) + Math.abs(A2egSU(egl10, eGLDisplay, eGLConfig2, i3) - 5)) < i5) {
                eGLConfig = eGLConfig2;
                i5 = abs;
            }
            i2++;
            i3 = 12324;
        }
        return eGLConfig;
    }

    public final void A5SV6n(AMqCpz aMqCpz) {
        this.f4944ADYaiT = aMqCpz;
        this.AMqCpz.AYUAbz(aMqCpz);
        GLES10.glBindTexture(3553, this.f4944ADYaiT.f4933AcNBzu);
        this.f4944ADYaiT.getClass();
        GLES10.glDisable(3042);
    }

    public final void ADYaiT(ARc23Z aRc23Z) {
        this.f4954AzWtSf = aRc23Z;
        GLES11.glBindBuffer(34962, aRc23Z.f4938A2egSU);
        this.AMqCpz.A2egSU(aRc23Z);
        GLES10.glDrawArrays(5, 0, 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0156 A[Catch: all -> 0x00af, Exception -> 0x00b3, TryCatch #4 {Exception -> 0x00b3, blocks: (B:12:0x009c, B:15:0x00a2, B:18:0x0156, B:20:0x0161, B:30:0x00b6, B:32:0x00bc, B:36:0x0100, B:38:0x0105, B:39:0x010c, B:41:0x013f, B:55:0x00fc, B:54:0x00f9, B:56:0x0148), top: B:11:0x009c, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0168 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0100 A[Catch: all -> 0x00af, Exception -> 0x00b3, TryCatch #4 {Exception -> 0x00b3, blocks: (B:12:0x009c, B:15:0x00a2, B:18:0x0156, B:20:0x0161, B:30:0x00b6, B:32:0x00bc, B:36:0x0100, B:38:0x0105, B:39:0x010c, B:41:0x013f, B:55:0x00fc, B:54:0x00f9, B:56:0x0148), top: B:11:0x009c, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0105 A[Catch: all -> 0x00af, Exception -> 0x00b3, TryCatch #4 {Exception -> 0x00b3, blocks: (B:12:0x009c, B:15:0x00a2, B:18:0x0156, B:20:0x0161, B:30:0x00b6, B:32:0x00bc, B:36:0x0100, B:38:0x0105, B:39:0x010c, B:41:0x013f, B:55:0x00fc, B:54:0x00f9, B:56:0x0148), top: B:11:0x009c, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013f A[Catch: all -> 0x00af, Exception -> 0x00b3, TryCatch #4 {Exception -> 0x00b3, blocks: (B:12:0x009c, B:15:0x00a2, B:18:0x0156, B:20:0x0161, B:30:0x00b6, B:32:0x00bc, B:36:0x0100, B:38:0x0105, B:39:0x010c, B:41:0x013f, B:55:0x00fc, B:54:0x00f9, B:56:0x0148), top: B:11:0x009c, outer: #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AMqCpz() {
        /*
            Method dump skipped, instructions count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: LqstKO.ASJ6gh.AMqCpz():void");
    }
}
