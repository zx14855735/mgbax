package LLcl8r;

import KpHwm4.AaHO0E;
import android.opengl.GLES20;
import com.game.boy.activity.EmulatorActivity;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4657AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ ARc23Z f4658AlLFFp;

    public /* synthetic */ AMqCpz(ARc23Z aRc23Z, int i) {
        this.f4657AcNBzu = i;
        this.f4658AlLFFp = aRc23Z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4657AcNBzu) {
            case 0:
                ARc23Z aRc23Z = this.f4658AlLFFp;
                try {
                    LqstKO.ASJ6gh aSJ6gh = new LqstKO.ASJ6gh(aRc23Z.f4662AzWtSf);
                    aRc23Z.f4661AmA8tU = aSJ6gh;
                    EmulatorActivity emulatorActivity = aRc23Z.f4665B3GDIM;
                    AaHO0E aaHO0E = emulatorActivity.f11011CASmeH;
                    aaHO0E.f4305AlLFFp = emulatorActivity.AZkASS(aSJ6gh);
                    aaHO0E.f4294A2egSU = aRc23Z;
                    break;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            default:
                ARc23Z aRc23Z2 = this.f4658AlLFFp;
                EmulatorActivity emulatorActivity2 = aRc23Z2.f4665B3GDIM;
                AaHO0E aaHO0E2 = emulatorActivity2.f11011CASmeH;
                LqstKO.ASJ6gh aSJ6gh2 = aRc23Z2.f4661AmA8tU;
                aaHO0E2.f4305AlLFFp = null;
                aaHO0E2.f4306AmA8tU = null;
                aaHO0E2.f4294A2egSU = null;
                LSQ6IS.ARc23Z aRc23Z3 = emulatorActivity2.f11009C2rE4F;
                if (aRc23Z3 != null) {
                    aRc23Z3.f4852B2KMhB.A5SV6n();
                    aRc23Z3.f4853B3GDIM.clear();
                }
                LqstKO.ASJ6gh aSJ6gh3 = aRc23Z2.f4661AmA8tU;
                LqstKO.ADYaiT aDYaiT = aSJ6gh3.AMqCpz;
                if (aDYaiT instanceof LqstKO.A4TApA) {
                    LqstKO.A4TApA a4TApA = (LqstKO.A4TApA) aDYaiT;
                    int[] iArr = a4TApA.f4905B4ZgIw;
                    if (iArr != null) {
                        for (int i : iArr) {
                            if (i != 0) {
                                GLES20.glDeleteTextures(1, new int[]{i}, 0);
                            }
                        }
                        a4TApA.f4905B4ZgIw = null;
                    }
                    a4TApA.f4906B7CMnp = 0;
                    a4TApA.f4907B9tovu = 0;
                    a4TApA.f4903B2KMhB = null;
                    a4TApA.f4904B3GDIM = null;
                    int[] iArr2 = a4TApA.f4919C4FrIb;
                    if (iArr2 != null) {
                        for (int i2 : iArr2) {
                            if (i2 != 0) {
                                GLES20.glDeleteTextures(1, new int[]{i2}, 0);
                            }
                        }
                        a4TApA.f4919C4FrIb = null;
                    }
                    int[] iArr3 = a4TApA.f4918C2rE4F;
                    if (iArr3 != null) {
                        for (int i3 : iArr3) {
                            if (i3 != 0) {
                                GLES20.glDeleteFramebuffers(1, new int[]{i3}, 0);
                            }
                        }
                        a4TApA.f4918C2rE4F = null;
                    }
                    int i4 = a4TApA.f4914BTvldC;
                    if (i4 != 0) {
                        GLES20.glDeleteTextures(1, new int[]{i4}, 0);
                        a4TApA.f4914BTvldC = 0;
                    }
                    int i5 = a4TApA.f4915BV3sI0;
                    if (i5 != 0) {
                        GLES20.glDeleteFramebuffers(1, new int[]{i5}, 0);
                        a4TApA.f4915BV3sI0 = 0;
                    }
                    int i6 = a4TApA.f4908BChYOn;
                    if (i6 != 0) {
                        GLES20.glDeleteProgram(i6);
                        a4TApA.f4908BChYOn = 0;
                    }
                    int i7 = a4TApA.f4913BPw6Q8;
                    if (i7 != 0) {
                        GLES20.glDeleteBuffers(1, new int[]{i7}, 0);
                        a4TApA.f4913BPw6Q8 = 0;
                    }
                    a4TApA.f4920CASmeH = 0;
                    a4TApA.f4921CNPG0E = 0;
                    a4TApA.f4916BmvVmW = 0;
                    a4TApA.f4917BniPrB = 0;
                    a4TApA.BpkvW3 = false;
                }
                EGL10 egl10 = aSJ6gh3.f4950AaHO0E;
                EGLDisplay eGLDisplay = aSJ6gh3.f4951AcNBzu;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                aSJ6gh3.f4950AaHO0E.eglDestroySurface(aSJ6gh3.f4951AcNBzu, aSJ6gh3.f4942A4TApA);
                aSJ6gh3.f4950AaHO0E.eglDestroyContext(aSJ6gh3.f4951AcNBzu, aSJ6gh3.f4943A5SV6n);
                aSJ6gh3.f4950AaHO0E.eglTerminate(aSJ6gh3.f4951AcNBzu);
                aSJ6gh3.f4942A4TApA = null;
                aSJ6gh3.f4943A5SV6n = null;
                aSJ6gh3.f4951AcNBzu = null;
                aSJ6gh3.f4950AaHO0E = null;
                break;
        }
    }
}
