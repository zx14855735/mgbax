package LLiCI0;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.io.File;
import java.util.HashSet;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BChYOn {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f4725A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Object f4726A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Object f4727A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final Object f4728ADYaiT;
    public final Object AMqCpz;

    public BChYOn(MkAsKS.A2egSU a2egSU, Bitmap bitmap, MkAsKS.ADYaiT aDYaiT) {
        this.f4727A5SV6n = a2egSU;
        this.f4728ADYaiT = bitmap;
        this.f4726A4TApA = aDYaiT;
        this.AMqCpz = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        A2egSU();
    }

    public void A2egSU() {
        Rect rect = ((MkAsKS.ADYaiT) this.f4726A4TApA).f5434A5SV6n;
        this.f4725A2egSU = 0;
        int centerX = rect.centerX();
        MkAsKS.A2egSU a2egSU = (MkAsKS.A2egSU) this.f4727A5SV6n;
        if (centerX <= a2egSU.getWidth() / 2) {
            this.f4725A2egSU |= 1;
        }
        if (rect.centerY() <= a2egSU.getHeight() / 2) {
            this.f4725A2egSU |= 2;
        }
        A4TApA();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x003b, code lost:
    
        if (r2 < 0) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A4TApA() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f4726A4TApA
            MkAsKS.ADYaiT r0 = (MkAsKS.ADYaiT) r0
            android.graphics.Rect r0 = r0.f5434A5SV6n
            java.lang.Object r1 = r7.AMqCpz
            android.graphics.Rect r1 = (android.graphics.Rect) r1
            int r2 = r1.width()
            int r3 = r1.height()
            int r4 = r7.f4725A2egSU
            r4 = r4 & 1
            java.lang.Object r5 = r7.f4727A5SV6n
            MkAsKS.A2egSU r5 = (MkAsKS.A2egSU) r5
            if (r4 != 0) goto L25
            int r4 = r0.left
            int r2 = r4 - r2
            if (r2 >= 0) goto L23
            goto L31
        L23:
            r4 = r2
            goto L31
        L25:
            int r4 = r0.right
            int r6 = r5.getWidth()
            int r6 = r6 - r2
            if (r4 <= r6) goto L31
            int r4 = r0.right
            int r4 = r4 - r2
        L31:
            int r2 = r7.f4725A2egSU
            r2 = r2 & 2
            if (r2 != 0) goto L40
            int r0 = r0.top
            int r2 = r0 - r3
            if (r2 >= 0) goto L3e
            goto L4c
        L3e:
            r0 = r2
            goto L4c
        L40:
            int r2 = r0.bottom
            int r5 = r5.getHeight()
            int r5 = r5 - r3
            if (r2 <= r5) goto L3e
            int r0 = r0.bottom
            int r0 = r0 - r3
        L4c:
            r1.offsetTo(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: LLiCI0.BChYOn.A4TApA():void");
    }

    public BChYOn(BIYEnU bIYEnU, File file, int i, String str, File file2) {
        this.AMqCpz = bIYEnU;
        this.f4726A4TApA = file;
        this.f4725A2egSU = i;
        this.f4728ADYaiT = str;
        this.f4727A5SV6n = file2;
    }

    public BChYOn(List list, HashSet hashSet, int i) {
        byte[] bArr = new byte[64];
        this.f4727A5SV6n = bArr;
        this.f4725A2egSU = i;
        bArr[0] = 64;
        this.AMqCpz = new OLy1FW.AMqCpz[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((OLy1FW.AMqCpz[]) this.AMqCpz)[i2] = new OLy1FW.AMqCpz(i2, ((OLy1FW.A2egSU) list.get(i2)).AMqCpz);
        }
        this.f4728ADYaiT = new int[i];
        int i3 = 0;
        for (short s = 0; s < i; s = (short) (s + 1)) {
            if (hashSet.contains(Short.valueOf(s))) {
                ((int[]) this.f4728ADYaiT)[s] = i3;
                i3 += 16;
            } else {
                ((int[]) this.f4728ADYaiT)[s] = -1;
            }
        }
        this.f4726A4TApA = new OLy1FW.ADYaiT((short) 513, (short) 84, (((OLy1FW.AMqCpz[]) this.AMqCpz).length * 16) + (((int[]) this.f4728ADYaiT).length * 4) + 84);
    }
}
