package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class RequestBuilder extends IhMMDv.A2egSU implements Cloneable {

    /* renamed from: CqNSpT, reason: collision with root package name */
    public static final RequestOptions f9959CqNSpT = (RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().ADYaiT(HXc4pW.AlLFFp.f3557A5SV6n)).AaHO0E()).B25kr6(true);
    public final Context BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public final AzWtSf f9960C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public final Class f9961C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public final A4TApA f9962CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public final ARc23Z f9963CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public B25kr6 f9964COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public Object f9965CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public ArrayList f9966CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public RequestBuilder f9967CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public RequestBuilder f9968CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public Float f9969Cd8JRx;

    /* renamed from: CikNvS, reason: collision with root package name */
    public boolean f9970CikNvS = true;

    /* renamed from: CkXcdM, reason: collision with root package name */
    public boolean f9971CkXcdM;

    /* renamed from: CmUvjW, reason: collision with root package name */
    public boolean f9972CmUvjW;

    static {
        IrrkkA();
    }

    public RequestBuilder(A4TApA a4TApA, AzWtSf azWtSf, Class cls, Context context) {
        RequestOptions requestOptions;
        this.f9962CASmeH = a4TApA;
        this.f9960C2rE4F = azWtSf;
        this.f9961C4FrIb = cls;
        this.BpkvW3 = context;
        B25kr6.ADYaiT aDYaiT = azWtSf.f9948AcNBzu.f9877AmA8tU.f9923ARc23Z;
        B25kr6 b25kr6 = (B25kr6) aDYaiT.get(cls);
        if (b25kr6 == null) {
            for (Map.Entry entry : aDYaiT.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    b25kr6 = (B25kr6) entry.getValue();
                }
            }
        }
        this.f9964COJEAR = b25kr6 == null ? ARc23Z.f9918AaHO0E : b25kr6;
        this.f9963CNPG0E = a4TApA.f9877AmA8tU;
        Iterator it = azWtSf.f9956B7CMnp.iterator();
        while (it.hasNext()) {
            B9tovu((IhMMDv.ARc23Z) it.next());
        }
        synchronized (azWtSf) {
            requestOptions = azWtSf.f9957B9tovu;
        }
        A2egSU(requestOptions);
    }

    private static /* synthetic */ void IrrkkA() {
        char[] charArray = "¾²°óº¼°¸ó¿²¤ó®µ¸±±ó\u0097³´\u009f¯´¹º¸".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 221);
        }
        String str = new String(charArray);
        char[] charArray2 = "¾±´³´©".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 221);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final RequestBuilder B9tovu(IhMMDv.ARc23Z aRc23Z) {
        if (this.f3998BV3sI0) {
            return clone().B9tovu(aRc23Z);
        }
        if (aRc23Z != null) {
            if (this.f9966CSDoyG == null) {
                this.f9966CSDoyG = new ArrayList();
            }
            this.f9966CSDoyG.add(aRc23Z);
        }
        AcNBzu();
        return this;
    }

    @Override // IhMMDv.A2egSU
    /* renamed from: BChYOn, reason: merged with bridge method [inline-methods] */
    public final RequestBuilder A2egSU(IhMMDv.A2egSU a2egSU) {
        ItGa5w.ARc23Z.A4TApA(a2egSU);
        return (RequestBuilder) super.A2egSU(a2egSU);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00fa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final IhMMDv.A5SV6n BI9f7h(int r17, int r18, IhMMDv.A2egSU r19, IhMMDv.ADYaiT r20, IhMMDv.AMqCpz r21, IlwJBd.AYUAbz r22, com.bumptech.glide.AZOQYO r23, com.bumptech.glide.B25kr6 r24, java.lang.Object r25, java.util.concurrent.Executor r26) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.RequestBuilder.BI9f7h(int, int, IhMMDv.A2egSU, IhMMDv.ADYaiT, IhMMDv.AMqCpz, IlwJBd.AYUAbz, com.bumptech.glide.AZOQYO, com.bumptech.glide.B25kr6, java.lang.Object, java.util.concurrent.Executor):IhMMDv.A5SV6n");
    }

    @Override // IhMMDv.A2egSU
    /* renamed from: BIYEnU, reason: merged with bridge method [inline-methods] */
    public final RequestBuilder clone() {
        RequestBuilder requestBuilder = (RequestBuilder) super.clone();
        requestBuilder.f9964COJEAR = requestBuilder.f9964COJEAR.clone();
        if (requestBuilder.f9966CSDoyG != null) {
            requestBuilder.f9966CSDoyG = new ArrayList(requestBuilder.f9966CSDoyG);
        }
        RequestBuilder requestBuilder2 = requestBuilder.f9967CTkVKb;
        if (requestBuilder2 != null) {
            requestBuilder.f9967CTkVKb = requestBuilder2.clone();
        }
        RequestBuilder requestBuilder3 = requestBuilder.f9968CcAIMM;
        if (requestBuilder3 != null) {
            requestBuilder.f9968CcAIMM = requestBuilder3.clone();
        }
        return requestBuilder;
    }

    public final IhMMDv.AMqCpz BJ7GGh() {
        RequestBuilder requestBuilder = new RequestBuilder(this.f9962CASmeH, this.f9960C2rE4F, File.class, this.BpkvW3);
        requestBuilder.f9965CQhlFr = this.f9965CQhlFr;
        requestBuilder.f9971CkXcdM = this.f9971CkXcdM;
        RequestBuilder A2egSU2 = requestBuilder.A2egSU(f9959CqNSpT);
        A2egSU2.getClass();
        IhMMDv.AMqCpz aMqCpz = new IhMMDv.AMqCpz();
        A2egSU2.BPw6Q8(aMqCpz, aMqCpz, A2egSU2, ItGa5w.ARc23Z.f4080A4TApA);
        return aMqCpz;
    }

    public final AZOQYO BNL6CD(AZOQYO azoqyo) {
        int ordinal = azoqyo.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            return AZOQYO.f9929AcNBzu;
        }
        if (ordinal == 2) {
            return AZOQYO.f9930AlLFFp;
        }
        if (ordinal == 3) {
            return AZOQYO.f9931AmA8tU;
        }
        throw new IllegalArgumentException("unknown priority: " + this.f3984AzWtSf);
    }

    public final void BPw6Q8(IlwJBd.AYUAbz aYUAbz, IhMMDv.AMqCpz aMqCpz, IhMMDv.A2egSU a2egSU, Executor executor) {
        ItGa5w.ARc23Z.A4TApA(aYUAbz);
        if (!this.f9971CkXcdM) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        Object obj = new Object();
        B25kr6 b25kr6 = this.f9964COJEAR;
        IhMMDv.A5SV6n BI9f7h2 = BI9f7h(a2egSU.f3989B7CMnp, a2egSU.f3988B4ZgIw, a2egSU, null, aMqCpz, aYUAbz, a2egSU.f3984AzWtSf, b25kr6, obj, executor);
        IhMMDv.A5SV6n AYUAbz2 = aYUAbz.AYUAbz();
        if (BI9f7h2.A4TApA(AYUAbz2) && (a2egSU.f3987B3GDIM || !AYUAbz2.AaHO0E())) {
            ItGa5w.ARc23Z.A5SV6n(AYUAbz2, "Argument must not be null");
            if (AYUAbz2.isRunning()) {
                return;
            }
            AYUAbz2.AZOQYO();
            return;
        }
        this.f9960C2rE4F.A5SV6n(aYUAbz);
        aYUAbz.ARc23Z(BI9f7h2);
        AzWtSf azWtSf = this.f9960C2rE4F;
        synchronized (azWtSf) {
            azWtSf.f9953B2KMhB.f3963AcNBzu.add(aYUAbz);
            IQ76hF.AlLFFp alLFFp = azWtSf.f9951AzWtSf;
            alLFFp.f3952A2egSU.add(BI9f7h2);
            if (alLFFp.f3954A5SV6n) {
                BI9f7h2.clear();
                Log.isLoggable("RequestTracker", 2);
                alLFFp.f3953A4TApA.add(BI9f7h2);
            } else {
                BI9f7h2.AZOQYO();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void BTvldC(android.widget.ImageView r5) {
        /*
            r4 = this;
            r0 = 1
            char[] r1 = ItGa5w.AlLFFp.f4092A2egSU
            android.os.Looper r1 = android.os.Looper.myLooper()
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            if (r1 != r2) goto Lc1
            ItGa5w.ARc23Z.A4TApA(r5)
            int r1 = r4.f3981AcNBzu
            r2 = 2048(0x800, float:2.87E-42)
            boolean r1 = IhMMDv.A2egSU.ASJ6gh(r1, r2)
            if (r1 != 0) goto L7a
            boolean r1 = r4.f3992BI9f7h
            if (r1 == 0) goto L7a
            android.widget.ImageView$ScaleType r1 = r5.getScaleType()
            if (r1 == 0) goto L7a
            int[] r1 = com.bumptech.glide.AlLFFp.f9943A2egSU
            android.widget.ImageView$ScaleType r2 = r5.getScaleType()
            int r2 = r2.ordinal()
            r1 = r1[r2]
            switch(r1) {
                case 1: goto L6a;
                case 2: goto L58;
                case 3: goto L46;
                case 4: goto L46;
                case 5: goto L46;
                case 6: goto L34;
                default: goto L33;
            }
        L33:
            goto L7a
        L34:
            com.bumptech.glide.RequestBuilder r1 = r4.clone()
            I3HV03.B25kr6 r2 = I3HV03.B2KMhB.f3827A4TApA
            I3HV03.AaHO0E r3 = new I3HV03.AaHO0E
            r3.<init>()
            IhMMDv.A2egSU r1 = r1.AYUAbz(r2, r3)
            r1.f3999BmvVmW = r0
            goto L7b
        L46:
            com.bumptech.glide.RequestBuilder r1 = r4.clone()
            I3HV03.B25kr6 r2 = I3HV03.B2KMhB.f3826A2egSU
            I3HV03.BIYEnU r3 = new I3HV03.BIYEnU
            r3.<init>()
            IhMMDv.A2egSU r1 = r1.AYUAbz(r2, r3)
            r1.f3999BmvVmW = r0
            goto L7b
        L58:
            com.bumptech.glide.RequestBuilder r1 = r4.clone()
            I3HV03.B25kr6 r2 = I3HV03.B2KMhB.f3827A4TApA
            I3HV03.AaHO0E r3 = new I3HV03.AaHO0E
            r3.<init>()
            IhMMDv.A2egSU r1 = r1.AYUAbz(r2, r3)
            r1.f3999BmvVmW = r0
            goto L7b
        L6a:
            com.bumptech.glide.RequestBuilder r1 = r4.clone()
            I3HV03.B25kr6 r2 = I3HV03.B2KMhB.f3828A5SV6n
            I3HV03.AZkASS r3 = new I3HV03.AZkASS
            r3.<init>()
            IhMMDv.A2egSU r1 = r1.AYUAbz(r2, r3)
            goto L7b
        L7a:
            r1 = r4
        L7b:
            com.bumptech.glide.ARc23Z r2 = r4.f9963CNPG0E
            IlwJBd.ARc23Z r2 = r2.f9921A5SV6n
            r2.getClass()
            java.lang.Class<android.graphics.Bitmap> r2 = android.graphics.Bitmap.class
            java.lang.Class r3 = r4.f9961C4FrIb
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L93
            IlwJBd.A4TApA r0 = new IlwJBd.A4TApA
            r2 = 0
            r0.<init>(r5, r2)
            goto La1
        L93:
            java.lang.Class<android.graphics.drawable.Drawable> r2 = android.graphics.drawable.Drawable.class
            boolean r2 = r2.isAssignableFrom(r3)
            if (r2 == 0) goto La8
            IlwJBd.A4TApA r2 = new IlwJBd.A4TApA
            r2.<init>(r5, r0)
            r0 = r2
        La1:
            ADYaiT.BIYEnU r5 = ItGa5w.ARc23Z.f4079A2egSU
            r2 = 0
            r4.BPw6Q8(r0, r2, r1, r5)
            return
        La8:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unhandled class: "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r1 = ", try .as*(Class).transcode(ResourceTranscoder)"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        Lc1:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "You must call this method on the main thread"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.RequestBuilder.BTvldC(android.widget.ImageView):void");
    }

    public final RequestBuilder BV3sI0(IhMMDv.ARc23Z aRc23Z) {
        if (this.f3998BV3sI0) {
            return clone().BV3sI0(aRc23Z);
        }
        this.f9966CSDoyG = null;
        return B9tovu(aRc23Z);
    }

    public final RequestBuilder BmvVmW(Object obj) {
        if (this.f3998BV3sI0) {
            return clone().BmvVmW(obj);
        }
        this.f9965CQhlFr = obj;
        this.f9971CkXcdM = true;
        AcNBzu();
        return this;
    }

    public final IhMMDv.ASJ6gh BniPrB(int i, int i2, IhMMDv.A2egSU a2egSU, IhMMDv.ADYaiT aDYaiT, IhMMDv.AMqCpz aMqCpz, IlwJBd.AYUAbz aYUAbz, AZOQYO azoqyo, B25kr6 b25kr6, Object obj, Executor executor) {
        Object obj2 = this.f9965CQhlFr;
        ArrayList arrayList = this.f9966CSDoyG;
        ARc23Z aRc23Z = this.f9963CNPG0E;
        return new IhMMDv.ASJ6gh(this.BpkvW3, aRc23Z, obj, obj2, this.f9961C4FrIb, a2egSU, i, i2, azoqyo, aYUAbz, aMqCpz, arrayList, aDYaiT, aRc23Z.f9924ASJ6gh, b25kr6.f9958AcNBzu, executor);
    }

    public final RequestBuilder BpkvW3(float f) {
        if (this.f3998BV3sI0) {
            return clone().BpkvW3(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f9969Cd8JRx = Float.valueOf(f);
        AcNBzu();
        return this;
    }

    public final RequestBuilder C2rE4F(I9dkCd.A2egSU a2egSU) {
        if (this.f3998BV3sI0) {
            return clone().C2rE4F(a2egSU);
        }
        this.f9964COJEAR = a2egSU;
        this.f9970CikNvS = false;
        AcNBzu();
        return this;
    }
}
