package LLcl8r;

import android.content.SharedPreferences;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.game.boy.activity.EmulatorActivity;
import com.game.boy.activity.LayoutsActivity;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z implements SurfaceHolder.Callback {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final SurfaceView f4659AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Map f4660AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public LqstKO.ASJ6gh f4661AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public SurfaceHolder f4662AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f4663B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f4664B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final EmulatorActivity f4665B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public I3HV03.A4TApA f4666B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f4667B7CMnp;

    public ARc23Z(EmulatorActivity emulatorActivity, SurfaceView surfaceView) {
        this.f4665B3GDIM = emulatorActivity;
        this.f4659AcNBzu = surfaceView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0035, code lost:
    
        if (r0 != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A2egSU() {
        /*
            r7 = this;
            int r0 = r7.f4663B25kr6
            if (r0 == 0) goto L6f
            int r1 = r7.f4664B2KMhB
            if (r1 == 0) goto L6f
            r2 = 1
            r3 = 0
            if (r0 <= r1) goto Le
            r4 = 1
            goto Lf
        Le:
            r4 = 0
        Lf:
            com.game.boy.activity.EmulatorActivity r5 = r7.f4665B3GDIM
            r5.f11010C4FrIb = r4
            I3HV03.A4TApA r6 = r7.f4666B4ZgIw
            java.util.Map r0 = r6.AZkASS(r0, r1, r4)
            r7.f4660AlLFFp = r0
            int r0 = r7.f4663B25kr6
            int r1 = r7.f4664B2KMhB
            if (r0 < r1) goto L2b
            android.content.SharedPreferences r0 = r5.f11024CtFAbx
            java.lang.String r1 = "stretchToFit"
            boolean r0 = r0.getBoolean(r1, r3)
            if (r0 != 0) goto L37
        L2b:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 < r1) goto L41
            boolean r0 = ADYaiT.BpkvW3.BJ7GGh(r5)
            if (r0 == 0) goto L41
        L37:
            android.graphics.Rect r0 = new android.graphics.Rect
            int r1 = r7.f4663B25kr6
            int r4 = r7.f4664B2KMhB
            r0.<init>(r3, r3, r1, r4)
            goto L4b
        L41:
            java.util.Map r0 = r7.f4660AlLFFp
            java.lang.String r1 = "video"
            java.lang.Object r0 = r0.get(r1)
            android.graphics.Rect r0 = (android.graphics.Rect) r0
        L4b:
            int r1 = r0.width()
            int r4 = r7.f4663B25kr6
            if (r1 < r4) goto L5d
            int r1 = r0.height()
            int r4 = r7.f4664B2KMhB
            if (r1 >= r4) goto L5c
            goto L5d
        L5c:
            r2 = 0
        L5d:
            r7.f4667B7CMnp = r2
            KpHwm4.AaHO0E r1 = r5.f11011CASmeH
            C4FrIb.A2egSU r2 = new C4FrIb.A2egSU
            r3 = 22
            r4 = 0
            r2.<init>(r7, r0, r3, r4)
            r1.A2egSU(r2)
            r0 = 0
            r7.f4660AlLFFp = r0
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: LLcl8r.ARc23Z.A2egSU():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x054f  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x05f2 A[EDGE_INSN: B:147:0x05f2->B:148:0x05f2 BREAK  A[LOOP:1: B:128:0x0589->B:144:0x05e4], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x037c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A4TApA() {
        /*
            Method dump skipped, instructions count: 1593
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: LLcl8r.ARc23Z.A4TApA():void");
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.f4661AmA8tU != null) {
            this.f4663B25kr6 = i2;
            this.f4664B2KMhB = i3;
            A2egSU();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        LqstKO.ASJ6gh aSJ6gh;
        EmulatorActivity emulatorActivity = this.f4665B3GDIM;
        EmulatorActivity.B4ZgIw(this.f4659AcNBzu, emulatorActivity.getWindowManager().getDefaultDisplay().getRefreshRate());
        SharedPreferences sharedPreferences = emulatorActivity.f11024CtFAbx;
        int i = LayoutsActivity.f11061B4ZgIw;
        this.f4666B4ZgIw = new I3HV03.A4TApA(sharedPreferences.getString("layoutProfile", "Default"), 6, new Hdahpu.ASJ6gh(emulatorActivity));
        this.f4662AzWtSf = surfaceHolder;
        emulatorActivity.f11011CASmeH.A2egSU(new AMqCpz(this, 0));
        this.f4662AzWtSf = null;
        if (EmulatorActivity.f10989DRlcZ9 || (aSJ6gh = this.f4661AmA8tU) == null) {
            return;
        }
        EmulatorActivity.f10989DRlcZ9 = true;
        if (aSJ6gh.f4947AYUAbz) {
            emulatorActivity.BTvldC(2131886662);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (this.f4661AmA8tU != null) {
            this.f4665B3GDIM.f11011CASmeH.A2egSU(new AMqCpz(this, 1));
            this.f4661AmA8tU = null;
            this.f4666B4ZgIw = null;
            this.f4663B25kr6 = 0;
            this.f4664B2KMhB = 0;
        }
    }
}
