package MkAsKS;

import LLiCI0.BChYOn;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.game.boy.activity.LayoutEditor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AYUAbz implements A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final A2egSU f5442A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final BChYOn f5443A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ADYaiT f5444A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final int f5445ADYaiT;
    public Rect AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f5446ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public int f5447ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final Rect f5448AYUAbz = new Rect();

    public AYUAbz(A2egSU a2egSU, BChYOn bChYOn) {
        this.f5442A2egSU = a2egSU;
        this.f5443A4TApA = bChYOn;
        this.f5445ADYaiT = bChYOn.f4725A2egSU;
        this.f5444A5SV6n = (ADYaiT) bChYOn.f4726A4TApA;
    }

    @Override // MkAsKS.A5SV6n
    public final void a(int i, int i2) {
        this.AMqCpz = new Rect(this.f5444A5SV6n.f5434A5SV6n);
        this.f5446ARc23Z = i;
        this.f5447ASJ6gh = i2;
    }

    @Override // MkAsKS.A5SV6n
    public final void b(int i, int i2) {
        int i3 = i - this.f5446ARc23Z;
        int i4 = i2 - this.f5447ASJ6gh;
        Rect rect = this.AMqCpz;
        Rect rect2 = this.f5448AYUAbz;
        rect2.set(rect);
        int i5 = this.f5445ADYaiT;
        int i6 = i5 & 1;
        A2egSU a2egSU = this.f5442A2egSU;
        if (i6 == 0) {
            rect2.left = A2egSU.A2egSU(a2egSU, i3 + rect2.left, a2egSU.getWidth());
        } else {
            rect2.right = A2egSU.A2egSU(a2egSU, i3 + rect2.right, a2egSU.getWidth());
        }
        int i7 = i5 & 2;
        if (i7 == 0) {
            rect2.top = A2egSU.A2egSU(a2egSU, i4 + rect2.top, a2egSU.getHeight());
        } else {
            rect2.bottom = A2egSU.A2egSU(a2egSU, i4 + rect2.bottom, a2egSU.getHeight());
        }
        ADYaiT aDYaiT = this.f5444A5SV6n;
        if (rect2.equals(aDYaiT.f5434A5SV6n)) {
            return;
        }
        a2egSU.A4TApA(aDYaiT);
        int height = rect2.height();
        int width = rect2.width();
        int i8 = aDYaiT.f5436ARc23Z;
        if (width < i8) {
            width = i8;
        }
        if (aDYaiT.AMqCpz) {
            Bitmap bitmap = aDYaiT.f5433A4TApA;
            int height2 = (bitmap.getHeight() * width) / bitmap.getWidth();
            A2egSU a2egSU2 = aDYaiT.f5432A2egSU;
            if (height2 > a2egSU2.getHeight()) {
                int height3 = a2egSU2.getHeight();
                width = (bitmap.getWidth() * height3) / bitmap.getHeight();
                height = height3;
            } else {
                height = height2;
            }
        }
        int i9 = aDYaiT.f5437ASJ6gh;
        if (height < i9) {
            height = i9;
        }
        if (i6 == 0) {
            rect2.left = rect2.right - width;
        } else {
            rect2.right = width + rect2.left;
        }
        if (i7 == 0) {
            rect2.top = rect2.bottom - height;
        } else {
            rect2.bottom = rect2.top + height;
        }
        aDYaiT.f5434A5SV6n.set(rect2);
        this.f5443A4TApA.A4TApA();
        a2egSU.A4TApA(aDYaiT);
        ARc23Z aRc23Z = a2egSU.f5426B7CMnp;
        if (aRc23Z != null) {
            ((LayoutEditor) aRc23Z).f11055B25kr6 = true;
        }
    }

    @Override // MkAsKS.A5SV6n
    public final void a() {
        A2egSU a2egSU = this.f5442A2egSU;
        ADYaiT aDYaiT = this.f5444A5SV6n;
        a2egSU.A4TApA(aDYaiT);
        this.f5443A4TApA.A2egSU();
        a2egSU.A4TApA(aDYaiT);
    }
}
