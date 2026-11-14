package QgOIY0;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.sigmob.sdk.base.views.r;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class BNL6CD extends BChYOn implements QmCR4D.A4TApA {

    /* renamed from: BI9f7h, reason: collision with root package name */
    public static final /* synthetic */ int f7609BI9f7h = 0;

    /* renamed from: A4TApA, reason: collision with root package name */
    public ArrayList f7611A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f7612A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public ArrayList f7613ADYaiT;
    public ArrayList AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public ArrayList f7614ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public ArrayList f7615ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public ArrayList f7616AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public ArrayList f7617AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public ArrayList f7618AZkASS;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public B3GDIM f7620AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public B9tovu f7621AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public B2KMhB f7622AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f7623AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f7624B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public String f7625B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f7626B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public ArrayList f7627B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public ArrayList f7628B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public ArrayList f7629B9tovu;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public int f7619AaHO0E = 0;

    /* renamed from: BChYOn, reason: collision with root package name */
    public Bundle f7630BChYOn = null;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final LLYwnm.AMqCpz f7610A2egSU = new LLYwnm.AMqCpz(22, this);

    static {
        new DecelerateInterpolator(2.5f);
        new DecelerateInterpolator(1.5f);
        new AccelerateInterpolator(2.5f);
        new AccelerateInterpolator(1.5f);
        zodyUch();
    }

    public static void AMqCpz(BNL6CD bnl6cd, AaHO0E aaHO0E, boolean z, boolean z2, boolean z3) {
        BNL6CD bnl6cd2;
        bnl6cd.getClass();
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aaHO0E);
        arrayList2.add(Boolean.valueOf(z));
        BIYEnU(arrayList, arrayList2, 0, 1);
        if (z2) {
            bnl6cd2 = bnl6cd;
            AMqCpz.AMqCpz(bnl6cd2, arrayList, arrayList2, 0, 1, true);
        } else {
            bnl6cd2 = bnl6cd;
        }
        if (z3) {
            bnl6cd2.A2egSU(bnl6cd2.f7619AaHO0E, true);
        }
        ArrayList arrayList3 = bnl6cd2.f7613ADYaiT;
        if (arrayList3 != null) {
            int size = arrayList3.size();
            for (int i = 0; i < size; i++) {
            }
        }
    }

    public static void BIYEnU(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        int i3 = -1;
        int i4 = i;
        while (i4 < i2) {
            AaHO0E aaHO0E = (AaHO0E) arrayList.get(i4);
            if (((Boolean) arrayList2.get(i4)).booleanValue()) {
                aaHO0E.A5SV6n(i3);
                boolean z = i4 == i2 + (-1);
                ArrayList arrayList3 = aaHO0E.f7505A4TApA;
                int size = arrayList3.size() - 1;
                while (true) {
                    BNL6CD bnl6cd = aaHO0E.f7504A2egSU;
                    if (size >= 0) {
                        AZkASS aZkASS = (AZkASS) arrayList3.get(size);
                        B2KMhB b2KMhB = aZkASS.f7500A4TApA;
                        int i5 = aaHO0E.f7509ASJ6gh;
                        int i6 = i5 != 4097 ? i5 != 4099 ? i5 != 8194 ? 0 : 4097 : 4099 : 8194;
                        int i7 = aaHO0E.f7510AYUAbz;
                        if (b2KMhB.f7570BmvVmW != null || i6 != 0 || i7 != 0) {
                            b2KMhB.AYUAbz();
                            B25kr6 b25kr6 = b2KMhB.f7570BmvVmW;
                            b25kr6.f7546A4TApA = i6;
                            b25kr6.f7547A5SV6n = i7;
                        }
                        int i8 = aZkASS.f7499A2egSU;
                        if (i8 == 1) {
                            b2KMhB.AZkASS(aZkASS.f7503ARc23Z);
                            bnl6cd.getClass();
                            boolean z2 = b2KMhB.f7585CqNSpT > 0;
                            if (!b2KMhB.f7560B7CMnp || !z2) {
                                ArrayList arrayList4 = bnl6cd.AMqCpz;
                                if (arrayList4 != null) {
                                    arrayList4.remove(b2KMhB);
                                }
                                b2KMhB.f7580CcAIMM = false;
                                b2KMhB.f7581Cd8JRx = true;
                            }
                        } else if (i8 == 3) {
                            b2KMhB.AZkASS(aZkASS.AMqCpz);
                            bnl6cd.A5SV6n(b2KMhB, false);
                        } else if (i8 == 4) {
                            b2KMhB.AZkASS(aZkASS.AMqCpz);
                            bnl6cd.getClass();
                            if (b2KMhB.f7559B4ZgIw) {
                                b2KMhB.f7559B4ZgIw = false;
                                b2KMhB.f7571BniPrB = !b2KMhB.f7571BniPrB;
                            }
                        } else if (i8 == 5) {
                            b2KMhB.AZkASS(aZkASS.f7503ARc23Z);
                            bnl6cd.getClass();
                            if (!b2KMhB.f7559B4ZgIw) {
                                b2KMhB.f7559B4ZgIw = true;
                                b2KMhB.f7571BniPrB = !b2KMhB.f7571BniPrB;
                            }
                        } else if (i8 == 6) {
                            b2KMhB.AZkASS(aZkASS.AMqCpz);
                            bnl6cd.CmUvjW(b2KMhB);
                        } else {
                            if (i8 != 7) {
                                throw new IllegalArgumentException("Unknown cmd: " + aZkASS.f7499A2egSU);
                            }
                            b2KMhB.AZkASS(aZkASS.f7503ARc23Z);
                            bnl6cd.getClass();
                            if (!b2KMhB.f7560B7CMnp) {
                                b2KMhB.f7560B7CMnp = true;
                                if (b2KMhB.f7580CcAIMM) {
                                    ArrayList arrayList5 = bnl6cd.AMqCpz;
                                    if (arrayList5 != null) {
                                        arrayList5.remove(b2KMhB);
                                    }
                                    b2KMhB.f7580CcAIMM = false;
                                }
                            }
                        }
                        if (!aaHO0E.f7521B4ZgIw && aZkASS.f7499A2egSU != 3) {
                            bnl6cd.CASmeH(b2KMhB);
                        }
                        size--;
                    } else if (!aaHO0E.f7521B4ZgIw && z) {
                        bnl6cd.A2egSU(bnl6cd.f7619AaHO0E, true);
                    }
                }
            } else {
                aaHO0E.A5SV6n(1);
                ArrayList arrayList6 = aaHO0E.f7505A4TApA;
                int size2 = arrayList6.size();
                int i9 = 0;
                while (true) {
                    BNL6CD bnl6cd2 = aaHO0E.f7504A2egSU;
                    if (i9 < size2) {
                        AZkASS aZkASS2 = (AZkASS) arrayList6.get(i9);
                        B2KMhB b2KMhB2 = aZkASS2.f7500A4TApA;
                        int i10 = aaHO0E.f7509ASJ6gh;
                        int i11 = aaHO0E.f7510AYUAbz;
                        if (b2KMhB2.f7570BmvVmW != null || i10 != 0 || i11 != 0) {
                            b2KMhB2.AYUAbz();
                            B25kr6 b25kr62 = b2KMhB2.f7570BmvVmW;
                            b25kr62.f7546A4TApA = i10;
                            b25kr62.f7547A5SV6n = i11;
                        }
                        int i12 = aZkASS2.f7499A2egSU;
                        if (i12 == 1) {
                            b2KMhB2.AZkASS(aZkASS2.f7501A5SV6n);
                            bnl6cd2.A5SV6n(b2KMhB2, false);
                        } else if (i12 == 3) {
                            b2KMhB2.AZkASS(aZkASS2.f7502ADYaiT);
                            bnl6cd2.getClass();
                            boolean z3 = b2KMhB2.f7585CqNSpT > 0;
                            if (!b2KMhB2.f7560B7CMnp || !z3) {
                                ArrayList arrayList7 = bnl6cd2.AMqCpz;
                                if (arrayList7 != null) {
                                    arrayList7.remove(b2KMhB2);
                                }
                                b2KMhB2.f7580CcAIMM = false;
                                b2KMhB2.f7581Cd8JRx = true;
                            }
                        } else if (i12 == 4) {
                            b2KMhB2.AZkASS(aZkASS2.f7502ADYaiT);
                            bnl6cd2.getClass();
                            if (!b2KMhB2.f7559B4ZgIw) {
                                b2KMhB2.f7559B4ZgIw = true;
                                b2KMhB2.f7571BniPrB = !b2KMhB2.f7571BniPrB;
                            }
                        } else if (i12 == 5) {
                            b2KMhB2.AZkASS(aZkASS2.f7501A5SV6n);
                            bnl6cd2.getClass();
                            if (b2KMhB2.f7559B4ZgIw) {
                                b2KMhB2.f7559B4ZgIw = false;
                                b2KMhB2.f7571BniPrB = !b2KMhB2.f7571BniPrB;
                            }
                        } else if (i12 == 6) {
                            b2KMhB2.AZkASS(aZkASS2.f7502ADYaiT);
                            bnl6cd2.getClass();
                            if (!b2KMhB2.f7560B7CMnp) {
                                b2KMhB2.f7560B7CMnp = true;
                                if (b2KMhB2.f7580CcAIMM) {
                                    ArrayList arrayList8 = bnl6cd2.AMqCpz;
                                    if (arrayList8 != null) {
                                        arrayList8.remove(b2KMhB2);
                                    }
                                    b2KMhB2.f7580CcAIMM = false;
                                }
                            }
                        } else {
                            if (i12 != 7) {
                                throw new IllegalArgumentException("Unknown cmd: " + aZkASS2.f7499A2egSU);
                            }
                            b2KMhB2.AZkASS(aZkASS2.f7501A5SV6n);
                            bnl6cd2.CmUvjW(b2KMhB2);
                        }
                        if (!aaHO0E.f7521B4ZgIw && aZkASS2.f7499A2egSU != 1) {
                            bnl6cd2.CASmeH(b2KMhB2);
                        }
                        i9++;
                    } else if (!aaHO0E.f7521B4ZgIw) {
                        bnl6cd2.A2egSU(bnl6cd2.f7619AaHO0E, true);
                    }
                }
            }
            i4++;
            i3 = -1;
        }
    }

    private static /* synthetic */ void zodyUch() {
        char[] charArray = "ÊÆÄ\u0087ÎÈÄÌ\u0087ËÆÐ\u0087ÚÁÌÅÅ\u0087ãÇÀëÛÀÍÎÌ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 169);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÊÅÀÇÀÝ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 169);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU(int i, boolean z) {
        boolean z2;
        if (this.f7620AcNBzu == null && i != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.f7619AaHO0E) {
            this.f7619AaHO0E = i;
            if (this.f7613ADYaiT != null) {
                ArrayList arrayList = this.AMqCpz;
                if (arrayList != null) {
                    int size = arrayList.size();
                    z2 = false;
                    for (int i2 = 0; i2 < size; i2++) {
                        B2KMhB b2KMhB = (B2KMhB) this.AMqCpz.get(i2);
                        CASmeH(b2KMhB);
                        CcAIMM ccAIMM = b2KMhB.f7567BPw6Q8;
                        if (ccAIMM != null) {
                            z2 |= ccAIMM.A4TApA();
                        }
                    }
                } else {
                    z2 = false;
                }
                int size2 = this.f7613ADYaiT.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    B2KMhB b2KMhB2 = (B2KMhB) this.f7613ADYaiT.get(i3);
                    if (b2KMhB2 != null && (b2KMhB2.f7581Cd8JRx || b2KMhB2.f7560B7CMnp)) {
                        CASmeH(b2KMhB2);
                        CcAIMM ccAIMM2 = b2KMhB2.f7567BPw6Q8;
                        if (ccAIMM2 != null) {
                            z2 |= ccAIMM2.A4TApA();
                        }
                    }
                }
                if (z2) {
                    return;
                }
                BniPrB();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x003f, code lost:
    
        if (r12 != 4) goto L238;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x020c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A4TApA(QgOIY0.B2KMhB r10, int r11, int r12, int r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 1158
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: QgOIY0.BNL6CD.A4TApA(QgOIY0.B2KMhB, int, int, int, boolean):void");
    }

    public final void A5SV6n(B2KMhB b2KMhB, boolean z) {
        if (this.AMqCpz == null) {
            this.AMqCpz = new ArrayList();
        }
        CQhlFr(b2KMhB);
        if (b2KMhB.f7560B7CMnp) {
            return;
        }
        if (this.AMqCpz.contains(b2KMhB)) {
            throw new IllegalStateException("Fragment already added: " + b2KMhB);
        }
        this.AMqCpz.add(b2KMhB);
        b2KMhB.f7580CcAIMM = true;
        b2KMhB.f7581Cd8JRx = false;
        b2KMhB.f7571BniPrB = false;
        if (z) {
            A4TApA(b2KMhB, this.f7619AaHO0E, 0, 0, false);
        }
    }

    public final void ADYaiT(BI9f7h bI9f7h, boolean z) {
        if (!z) {
            CtFAbx();
        }
        synchronized (this) {
            try {
                if (this.f7624B25kr6 || this.f7620AcNBzu == null) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
                if (this.f7611A4TApA == null) {
                    this.f7611A4TApA = new ArrayList();
                }
                this.f7611A4TApA.add(bI9f7h);
                CtxOCS();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void ARc23Z(Parcelable parcelable, BPw6Q8 bPw6Q8) {
        ArrayList arrayList;
        if (parcelable == null) {
            return;
        }
        BTvldC bTvldC = (BTvldC) parcelable;
        if (bTvldC.f7633AcNBzu == null) {
            return;
        }
        if (bPw6Q8 != null) {
            ArrayList arrayList2 = bPw6Q8.f7631A2egSU;
            arrayList = bPw6Q8.f7632A4TApA;
            int size = arrayList2 != null ? arrayList2.size() : 0;
            for (int i = 0; i < size; i++) {
                B2KMhB b2KMhB = (B2KMhB) arrayList2.get(i);
                BV3sI0 bV3sI0 = bTvldC.f7633AcNBzu[b2KMhB.f7574CASmeH];
                bV3sI0.f7647BI9f7h = b2KMhB;
                b2KMhB.f7573C4FrIb = null;
                b2KMhB.f7585CqNSpT = 0;
                b2KMhB.f7583CkXcdM = false;
                b2KMhB.f7580CcAIMM = false;
                b2KMhB.f7577CQhlFr = null;
                Bundle bundle = bV3sI0.f7646BChYOn;
                if (bundle != null) {
                    bundle.setClassLoader(this.f7620AcNBzu.f7588A4TApA.getClassLoader());
                    b2KMhB.f7573C4FrIb = bV3sI0.f7646BChYOn.getSparseParcelableArray("android:view_state");
                    b2KMhB.f7572C2rE4F = bV3sI0.f7646BChYOn;
                }
            }
        } else {
            arrayList = null;
        }
        this.f7613ADYaiT = new ArrayList(bTvldC.f7633AcNBzu.length);
        ArrayList arrayList3 = this.f7614ARc23Z;
        if (arrayList3 != null) {
            arrayList3.clear();
        }
        int i2 = 0;
        while (true) {
            BV3sI0[] bV3sI0Arr = bTvldC.f7633AcNBzu;
            if (i2 >= bV3sI0Arr.length) {
                break;
            }
            BV3sI0 bV3sI02 = bV3sI0Arr[i2];
            if (bV3sI02 != null) {
                BPw6Q8 bPw6Q82 = (arrayList == null || i2 >= arrayList.size()) ? null : (BPw6Q8) arrayList.get(i2);
                B3GDIM b3gdim = this.f7620AcNBzu;
                B2KMhB b2KMhB2 = this.f7622AmA8tU;
                if (bV3sI02.f7647BI9f7h == null) {
                    B7CMnp b7CMnp = b3gdim.f7588A4TApA;
                    Bundle bundle2 = bV3sI02.f7644B7CMnp;
                    if (bundle2 != null) {
                        bundle2.setClassLoader(b7CMnp.getClassLoader());
                    }
                    bV3sI02.f7647BI9f7h = B2KMhB.A5SV6n(b7CMnp, bV3sI02.f7636AcNBzu, bundle2);
                    Bundle bundle3 = bV3sI02.f7646BChYOn;
                    if (bundle3 != null) {
                        bundle3.setClassLoader(b7CMnp.getClassLoader());
                        bV3sI02.f7647BI9f7h.f7572C2rE4F = bV3sI02.f7646BChYOn;
                    }
                    bV3sI02.f7647BI9f7h.ADYaiT(bV3sI02.f7637AlLFFp, b2KMhB2);
                    B2KMhB b2KMhB3 = bV3sI02.f7647BI9f7h;
                    b2KMhB3.f7582CikNvS = bV3sI02.f7638AmA8tU;
                    b2KMhB3.f7584CmUvjW = true;
                    b2KMhB3.f7556B25kr6 = bV3sI02.f7639AzWtSf;
                    b2KMhB3.f7557B2KMhB = bV3sI02.f7640B25kr6;
                    b2KMhB3.f7558B3GDIM = bV3sI02.f7641B2KMhB;
                    b2KMhB3.f7561B9tovu = bV3sI02.f7642B3GDIM;
                    b2KMhB3.f7560B7CMnp = bV3sI02.f7643B4ZgIw;
                    b2KMhB3.f7559B4ZgIw = bV3sI02.f7645B9tovu;
                    b2KMhB3.f7586CrfGsy = b3gdim.f7589A5SV6n;
                }
                B2KMhB b2KMhB4 = bV3sI02.f7647BI9f7h;
                b2KMhB4.f7554AmA8tU = bPw6Q82;
                this.f7613ADYaiT.add(b2KMhB4);
                bV3sI02.f7647BI9f7h = null;
            } else {
                this.f7613ADYaiT.add(null);
                if (this.f7614ARc23Z == null) {
                    this.f7614ARc23Z = new ArrayList();
                }
                this.f7614ARc23Z.add(Integer.valueOf(i2));
            }
            i2++;
        }
        if (bPw6Q8 != null) {
            ArrayList arrayList4 = bPw6Q8.f7631A2egSU;
            int size2 = arrayList4 != null ? arrayList4.size() : 0;
            for (int i3 = 0; i3 < size2; i3++) {
                B2KMhB b2KMhB5 = (B2KMhB) arrayList4.get(i3);
                int i4 = b2KMhB5.f7578CSDoyG;
                if (i4 >= 0) {
                    if (i4 < this.f7613ADYaiT.size()) {
                        b2KMhB5.f7577CQhlFr = (B2KMhB) this.f7613ADYaiT.get(b2KMhB5.f7578CSDoyG);
                    } else {
                        b2KMhB5.toString();
                        b2KMhB5.f7577CQhlFr = null;
                    }
                }
            }
        }
        if (bTvldC.f7634AlLFFp != null) {
            this.AMqCpz = new ArrayList(bTvldC.f7634AlLFFp.length);
            int i5 = 0;
            while (true) {
                int[] iArr = bTvldC.f7634AlLFFp;
                if (i5 >= iArr.length) {
                    break;
                }
                B2KMhB b2KMhB6 = (B2KMhB) this.f7613ADYaiT.get(iArr[i5]);
                if (b2KMhB6 == null) {
                    AYUAbz(new IllegalStateException("No instantiated fragment for index #" + bTvldC.f7634AlLFFp[i5]));
                    throw null;
                }
                b2KMhB6.f7580CcAIMM = true;
                if (this.AMqCpz.contains(b2KMhB6)) {
                    throw new IllegalStateException("Already added!");
                }
                this.AMqCpz.add(b2KMhB6);
                i5++;
            }
        } else {
            this.AMqCpz = null;
        }
        if (bTvldC.f7635AmA8tU == null) {
            this.f7615ASJ6gh = null;
            return;
        }
        this.f7615ASJ6gh = new ArrayList(bTvldC.f7635AmA8tU.length);
        int i6 = 0;
        while (true) {
            AcNBzu[] acNBzuArr = bTvldC.f7635AmA8tU;
            if (i6 >= acNBzuArr.length) {
                return;
            }
            AcNBzu acNBzu = acNBzuArr[i6];
            acNBzu.getClass();
            AaHO0E aaHO0E = new AaHO0E(this);
            int i7 = 0;
            while (true) {
                int[] iArr2 = acNBzu.f7522AcNBzu;
                if (i7 >= iArr2.length) {
                    break;
                }
                AZkASS aZkASS = new AZkASS();
                aZkASS.f7499A2egSU = iArr2[i7];
                int i8 = i7 + 2;
                int i9 = iArr2[i7 + 1];
                if (i9 >= 0) {
                    aZkASS.f7500A4TApA = (B2KMhB) this.f7613ADYaiT.get(i9);
                } else {
                    aZkASS.f7500A4TApA = null;
                }
                int i10 = iArr2[i8];
                aZkASS.f7501A5SV6n = i10;
                int i11 = iArr2[i7 + 3];
                aZkASS.f7502ADYaiT = i11;
                int i12 = iArr2[i7 + 4];
                aZkASS.AMqCpz = i12;
                int i13 = iArr2[i7 + 5];
                aZkASS.f7503ARc23Z = i13;
                aaHO0E.f7506A5SV6n = i10;
                aaHO0E.f7507ADYaiT = i11;
                aaHO0E.AMqCpz = i12;
                aaHO0E.f7508ARc23Z = i13;
                aaHO0E.ADYaiT(aZkASS);
                i7 += 6;
            }
            aaHO0E.f7509ASJ6gh = acNBzu.f7523AlLFFp;
            aaHO0E.f7510AYUAbz = acNBzu.f7524AmA8tU;
            aaHO0E.f7512AZkASS = acNBzu.f7525AzWtSf;
            aaHO0E.f7514AcNBzu = acNBzu.f7526B25kr6;
            aaHO0E.f7511AZOQYO = true;
            aaHO0E.f7515AlLFFp = acNBzu.f7527B2KMhB;
            aaHO0E.f7516AmA8tU = acNBzu.f7528B3GDIM;
            aaHO0E.f7517AzWtSf = acNBzu.f7529B4ZgIw;
            aaHO0E.f7518B25kr6 = acNBzu.f7530B7CMnp;
            aaHO0E.f7519B2KMhB = acNBzu.f7531B9tovu;
            aaHO0E.f7520B3GDIM = acNBzu.f7532BChYOn;
            aaHO0E.f7521B4ZgIw = acNBzu.f7533BI9f7h;
            aaHO0E.A5SV6n(1);
            this.f7615ASJ6gh.add(aaHO0E);
            int i14 = aaHO0E.f7514AcNBzu;
            if (i14 >= 0) {
                synchronized (this) {
                    try {
                        if (this.f7617AZOQYO == null) {
                            this.f7617AZOQYO = new ArrayList();
                        }
                        int size3 = this.f7617AZOQYO.size();
                        if (i14 < size3) {
                            this.f7617AZOQYO.set(i14, aaHO0E);
                        } else {
                            while (size3 < i14) {
                                this.f7617AZOQYO.add(null);
                                if (this.f7618AZkASS == null) {
                                    this.f7618AZkASS = new ArrayList();
                                }
                                this.f7618AZkASS.add(Integer.valueOf(size3));
                                size3++;
                            }
                            this.f7617AZOQYO.add(aaHO0E);
                        }
                    } finally {
                    }
                }
            }
            i6++;
        }
    }

    public final void ASJ6gh(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        B2KMhB b2KMhB;
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AMqCpz.f7495A2egSU);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(0);
            }
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            B7CMnp b7CMnp = this.f7620AcNBzu.f7588A4TApA;
            try {
                QkAq4X.AYUAbz aYUAbz = B2KMhB.f7550CtFAbx;
                Class<?> cls = (Class) aYUAbz.get(attributeValue);
                if (cls == null) {
                    cls = b7CMnp.getClassLoader().loadClass(attributeValue);
                    aYUAbz.put(attributeValue, cls);
                }
                z = B2KMhB.class.isAssignableFrom(cls);
            } catch (ClassNotFoundException unused) {
                z = false;
            }
            if (z) {
                int id = view != null ? view.getId() : 0;
                if (id == -1 && resourceId == -1 && string == null) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                }
                B2KMhB B7CMnp2 = resourceId != -1 ? B7CMnp(resourceId) : null;
                if (B7CMnp2 == null && string != null) {
                    ArrayList arrayList = this.AMqCpz;
                    if (arrayList != null) {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            b2KMhB = (B2KMhB) this.AMqCpz.get(size);
                            if (b2KMhB != null && string.equals(b2KMhB.f7558B3GDIM)) {
                                break;
                            }
                        }
                    }
                    ArrayList arrayList2 = this.f7613ADYaiT;
                    if (arrayList2 != null) {
                        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                            b2KMhB = (B2KMhB) this.f7613ADYaiT.get(size2);
                            if (b2KMhB != null && string.equals(b2KMhB.f7558B3GDIM)) {
                                B7CMnp2 = b2KMhB;
                            }
                        }
                    }
                    B7CMnp2 = null;
                }
                if (B7CMnp2 == null && id != -1) {
                    B7CMnp2 = B7CMnp(id);
                }
                if (B7CMnp2 == null) {
                    B7CMnp2 = B2KMhB.A5SV6n(context, attributeValue, null);
                    B7CMnp2.f7582CikNvS = true;
                    if (resourceId == 0) {
                        resourceId = id;
                    }
                    B7CMnp2.f7556B25kr6 = resourceId;
                    B7CMnp2.f7557B2KMhB = id;
                    B7CMnp2.f7558B3GDIM = string;
                    B7CMnp2.f7583CkXcdM = true;
                    B7CMnp2.f7586CrfGsy = this;
                    B3GDIM b3gdim = this.f7620AcNBzu;
                    B7CMnp2.f7552AcNBzu = b3gdim;
                    B7CMnp b7CMnp2 = b3gdim.f7588A4TApA;
                    B7CMnp2.f7563BI9f7h = true;
                    if ((b3gdim != null ? b3gdim.f7587A2egSU : null) != null) {
                        B7CMnp2.f7563BI9f7h = true;
                    }
                    A5SV6n(B7CMnp2, true);
                } else {
                    if (B7CMnp2.f7583CkXcdM) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
                    }
                    B7CMnp2.f7583CkXcdM = true;
                    B3GDIM b3gdim2 = this.f7620AcNBzu;
                    B7CMnp2.f7552AcNBzu = b3gdim2;
                    if (!B7CMnp2.f7562BChYOn) {
                        B7CMnp b7CMnp3 = b3gdim2.f7588A4TApA;
                        B7CMnp2.f7563BI9f7h = true;
                        if ((b3gdim2 != null ? b3gdim2.f7587A2egSU : null) != null) {
                            B7CMnp2.f7563BI9f7h = true;
                        }
                    }
                }
                B2KMhB b2KMhB2 = B7CMnp2;
                int i = this.f7619AaHO0E;
                if (i >= 1 || !b2KMhB2.f7582CikNvS) {
                    A4TApA(b2KMhB2, i, 0, 0, false);
                } else {
                    A4TApA(b2KMhB2, 1, 0, 0, false);
                }
                throw new IllegalStateException(CtFAbx.BI9f7h("Fragment ", attributeValue, " did not create a view."));
            }
        }
    }

    public final void AYUAbz(RuntimeException runtimeException) {
        runtimeException.getMessage();
        PrintWriter printWriter = new PrintWriter(new QkAq4X.AMqCpz(0));
        B3GDIM b3gdim = this.f7620AcNBzu;
        try {
            if (b3gdim != null) {
                b3gdim.f7595AZkASS.dump("  ", null, printWriter, new String[0]);
            } else {
                AZOQYO("  ", null, printWriter, new String[0]);
            }
            throw runtimeException;
        } catch (Exception unused) {
            throw runtimeException;
        }
    }

    public final void AZOQYO(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        String str2;
        int size4;
        int size5;
        int size6;
        String AcNBzu2 = CtFAbx.AcNBzu(str, "    ");
        ArrayList arrayList = this.f7613ADYaiT;
        if (arrayList != null && (size6 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i = 0; i < size6; i++) {
                B2KMhB b2KMhB = (B2KMhB) this.f7613ADYaiT.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(b2KMhB);
                if (b2KMhB != null) {
                    b2KMhB.getClass();
                    printWriter.print(AcNBzu2);
                    printWriter.print("mFragmentId=#");
                    printWriter.print(Integer.toHexString(b2KMhB.f7556B25kr6));
                    printWriter.print(" mContainerId=#");
                    printWriter.print(Integer.toHexString(b2KMhB.f7557B2KMhB));
                    printWriter.print(" mTag=");
                    printWriter.println(b2KMhB.f7558B3GDIM);
                    printWriter.print(AcNBzu2);
                    printWriter.print("mState=");
                    printWriter.print(b2KMhB.BpkvW3);
                    printWriter.print(" mIndex=");
                    printWriter.print(b2KMhB.f7574CASmeH);
                    printWriter.print(" mWho=");
                    printWriter.print(b2KMhB.f7575CNPG0E);
                    printWriter.print(" mBackStackNesting=");
                    printWriter.println(b2KMhB.f7585CqNSpT);
                    printWriter.print(AcNBzu2);
                    printWriter.print("mAdded=");
                    printWriter.print(b2KMhB.f7580CcAIMM);
                    printWriter.print(" mRemoving=");
                    printWriter.print(b2KMhB.f7581Cd8JRx);
                    printWriter.print(" mFromLayout=");
                    printWriter.print(b2KMhB.f7582CikNvS);
                    printWriter.print(" mInLayout=");
                    printWriter.println(b2KMhB.f7583CkXcdM);
                    printWriter.print(AcNBzu2);
                    printWriter.print("mHidden=");
                    printWriter.print(b2KMhB.f7559B4ZgIw);
                    printWriter.print(" mDetached=");
                    printWriter.print(b2KMhB.f7560B7CMnp);
                    printWriter.print(" mMenuVisible=");
                    printWriter.print(true);
                    printWriter.print(" mHasMenu=");
                    printWriter.println(false);
                    printWriter.print(AcNBzu2);
                    printWriter.print("mRetainInstance=");
                    printWriter.print(b2KMhB.f7561B9tovu);
                    printWriter.print(" mRetaining=");
                    printWriter.print(b2KMhB.f7562BChYOn);
                    printWriter.print(" mUserVisibleHint=");
                    printWriter.println(b2KMhB.f7566BNL6CD);
                    if (b2KMhB.f7586CrfGsy != null) {
                        printWriter.print(AcNBzu2);
                        printWriter.print("mFragmentManager=");
                        printWriter.println(b2KMhB.f7586CrfGsy);
                    }
                    if (b2KMhB.f7552AcNBzu != null) {
                        printWriter.print(AcNBzu2);
                        printWriter.print("mHost=");
                        printWriter.println(b2KMhB.f7552AcNBzu);
                    }
                    if (b2KMhB.f7555AzWtSf != null) {
                        printWriter.print(AcNBzu2);
                        printWriter.print("mParentFragment=");
                        printWriter.println(b2KMhB.f7555AzWtSf);
                    }
                    if (b2KMhB.f7576COJEAR != null) {
                        printWriter.print(AcNBzu2);
                        printWriter.print("mArguments=");
                        printWriter.println(b2KMhB.f7576COJEAR);
                    }
                    if (b2KMhB.f7572C2rE4F != null) {
                        printWriter.print(AcNBzu2);
                        printWriter.print("mSavedFragmentState=");
                        printWriter.println(b2KMhB.f7572C2rE4F);
                    }
                    if (b2KMhB.f7573C4FrIb != null) {
                        printWriter.print(AcNBzu2);
                        printWriter.print("mSavedViewState=");
                        printWriter.println(b2KMhB.f7573C4FrIb);
                    }
                    if (b2KMhB.f7577CQhlFr != null) {
                        printWriter.print(AcNBzu2);
                        printWriter.print("mTarget=");
                        printWriter.print(b2KMhB.f7577CQhlFr);
                        printWriter.print(" mTargetRequestCode=");
                        printWriter.println(b2KMhB.f7579CTkVKb);
                    }
                    if (b2KMhB.A4TApA() != 0) {
                        printWriter.print(AcNBzu2);
                        printWriter.print("mNextAnim=");
                        printWriter.println(b2KMhB.A4TApA());
                    }
                    if (b2KMhB.f7564BIYEnU != null) {
                        printWriter.print(AcNBzu2);
                        printWriter.print("mContainer=");
                        printWriter.println(b2KMhB.f7564BIYEnU);
                    }
                    if (b2KMhB.f7567BPw6Q8 != null) {
                        printWriter.print(AcNBzu2);
                        printWriter.println("Loader Manager:");
                        b2KMhB.f7567BPw6Q8.A2egSU(AcNBzu2 + "  ", printWriter);
                    }
                    if (b2KMhB.f7553AlLFFp != null) {
                        printWriter.print(AcNBzu2);
                        printWriter.println("Child " + b2KMhB.f7553AlLFFp + ":");
                        b2KMhB.f7553AlLFFp.AZOQYO(CtFAbx.AcNBzu(AcNBzu2, "  "), fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        ArrayList arrayList2 = this.AMqCpz;
        if (arrayList2 != null && (size5 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size5; i2++) {
                B2KMhB b2KMhB2 = (B2KMhB) this.AMqCpz.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(b2KMhB2.toString());
            }
        }
        ArrayList arrayList3 = this.f7616AYUAbz;
        if (arrayList3 != null && (size4 = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                B2KMhB b2KMhB3 = (B2KMhB) this.f7616AYUAbz.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(b2KMhB3.toString());
            }
        }
        ArrayList arrayList4 = this.f7615ASJ6gh;
        if (arrayList4 != null && (size3 = arrayList4.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                AaHO0E aaHO0E = (AaHO0E) this.f7615ASJ6gh.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(aaHO0E.toString());
                printWriter.print(AcNBzu2);
                printWriter.print("mName=");
                printWriter.print(aaHO0E.f7512AZkASS);
                printWriter.print(" mIndex=");
                printWriter.print(aaHO0E.f7514AcNBzu);
                printWriter.print(" mCommitted=");
                printWriter.println(aaHO0E.f7513AaHO0E);
                if (aaHO0E.f7509ASJ6gh != 0) {
                    printWriter.print(AcNBzu2);
                    printWriter.print("mTransition=#");
                    printWriter.print(Integer.toHexString(aaHO0E.f7509ASJ6gh));
                    printWriter.print(" mTransitionStyle=#");
                    printWriter.println(Integer.toHexString(aaHO0E.f7510AYUAbz));
                }
                if (aaHO0E.f7506A5SV6n != 0 || aaHO0E.f7507ADYaiT != 0) {
                    printWriter.print(AcNBzu2);
                    printWriter.print("mEnterAnim=#");
                    printWriter.print(Integer.toHexString(aaHO0E.f7506A5SV6n));
                    printWriter.print(" mExitAnim=#");
                    printWriter.println(Integer.toHexString(aaHO0E.f7507ADYaiT));
                }
                if (aaHO0E.AMqCpz != 0 || aaHO0E.f7508ARc23Z != 0) {
                    printWriter.print(AcNBzu2);
                    printWriter.print("mPopEnterAnim=#");
                    printWriter.print(Integer.toHexString(aaHO0E.AMqCpz));
                    printWriter.print(" mPopExitAnim=#");
                    printWriter.println(Integer.toHexString(aaHO0E.f7508ARc23Z));
                }
                if (aaHO0E.f7515AlLFFp != 0 || aaHO0E.f7516AmA8tU != null) {
                    printWriter.print(AcNBzu2);
                    printWriter.print("mBreadCrumbTitleRes=#");
                    printWriter.print(Integer.toHexString(aaHO0E.f7515AlLFFp));
                    printWriter.print(" mBreadCrumbTitleText=");
                    printWriter.println(aaHO0E.f7516AmA8tU);
                }
                if (aaHO0E.f7517AzWtSf != 0 || aaHO0E.f7518B25kr6 != null) {
                    printWriter.print(AcNBzu2);
                    printWriter.print("mBreadCrumbShortTitleRes=#");
                    printWriter.print(Integer.toHexString(aaHO0E.f7517AzWtSf));
                    printWriter.print(" mBreadCrumbShortTitleText=");
                    printWriter.println(aaHO0E.f7518B25kr6);
                }
                ArrayList arrayList5 = aaHO0E.f7505A4TApA;
                if (!arrayList5.isEmpty()) {
                    printWriter.print(AcNBzu2);
                    printWriter.println("Operations:");
                    int size7 = arrayList5.size();
                    for (int i5 = 0; i5 < size7; i5++) {
                        AZkASS aZkASS = (AZkASS) arrayList5.get(i5);
                        switch (aZkASS.f7499A2egSU) {
                            case 0:
                                str2 = "NULL";
                                break;
                            case 1:
                                str2 = "ADD";
                                break;
                            case 2:
                                str2 = "REPLACE";
                                break;
                            case 3:
                                str2 = "REMOVE";
                                break;
                            case 4:
                                str2 = "HIDE";
                                break;
                            case 5:
                                str2 = "SHOW";
                                break;
                            case 6:
                                str2 = "DETACH";
                                break;
                            case 7:
                                str2 = "ATTACH";
                                break;
                            default:
                                str2 = "cmd=" + aZkASS.f7499A2egSU;
                                break;
                        }
                        printWriter.print(AcNBzu2);
                        printWriter.print("  Op #");
                        printWriter.print(i5);
                        printWriter.print(": ");
                        printWriter.print(str2);
                        printWriter.print(" ");
                        printWriter.println(aZkASS.f7500A4TApA);
                        if (aZkASS.f7501A5SV6n != 0 || aZkASS.f7502ADYaiT != 0) {
                            printWriter.print(AcNBzu2);
                            printWriter.print("enterAnim=#");
                            printWriter.print(Integer.toHexString(aZkASS.f7501A5SV6n));
                            printWriter.print(" exitAnim=#");
                            printWriter.println(Integer.toHexString(aZkASS.f7502ADYaiT));
                        }
                        if (aZkASS.AMqCpz != 0 || aZkASS.f7503ARc23Z != 0) {
                            printWriter.print(AcNBzu2);
                            printWriter.print("popEnterAnim=#");
                            printWriter.print(Integer.toHexString(aZkASS.AMqCpz));
                            printWriter.print(" popExitAnim=#");
                            printWriter.println(Integer.toHexString(aZkASS.f7503ARc23Z));
                        }
                    }
                }
            }
        }
        synchronized (this) {
            try {
                ArrayList arrayList6 = this.f7617AZOQYO;
                if (arrayList6 != null && (size2 = arrayList6.size()) > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (int i6 = 0; i6 < size2; i6++) {
                        Object obj = (AaHO0E) this.f7617AZOQYO.get(i6);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i6);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
                ArrayList arrayList7 = this.f7618AZkASS;
                if (arrayList7 != null && arrayList7.size() > 0) {
                    printWriter.print(str);
                    printWriter.print("mAvailBackStackIndices: ");
                    printWriter.println(Arrays.toString(this.f7618AZkASS.toArray()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ArrayList arrayList8 = this.f7611A4TApA;
        if (arrayList8 != null && (size = arrayList8.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i7 = 0; i7 < size; i7++) {
                Object obj2 = (BI9f7h) this.f7611A4TApA.get(i7);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i7);
                printWriter.print(": ");
                printWriter.println(obj2);
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f7620AcNBzu);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f7621AlLFFp);
        if (this.f7622AmA8tU != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f7622AmA8tU);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f7619AaHO0E);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f7623AzWtSf);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f7624B25kr6);
        if (this.f7625B2KMhB != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f7625B2KMhB);
        }
        ArrayList arrayList9 = this.f7614ARc23Z;
        if (arrayList9 == null || arrayList9.size() <= 0) {
            return;
        }
        printWriter.print(str);
        printWriter.print("  mAvailIndices: ");
        printWriter.println(Arrays.toString(this.f7614ARc23Z.toArray()));
    }

    public final void AZkASS(ArrayList arrayList, ArrayList arrayList2) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0062, code lost:
    
        if (r13 != 7) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AaHO0E(java.util.ArrayList r21, java.util.ArrayList r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 551
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: QgOIY0.BNL6CD.AaHO0E(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    public final boolean AcNBzu(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        int i3;
        ArrayList arrayList3 = this.f7615ASJ6gh;
        if (arrayList3 == null) {
            return false;
        }
        if (i < 0 && (i2 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f7615ASJ6gh.remove(size));
            arrayList2.add(Boolean.TRUE);
            return true;
        }
        if (i >= 0) {
            i3 = arrayList3.size() - 1;
            while (i3 >= 0) {
                AaHO0E aaHO0E = (AaHO0E) this.f7615ASJ6gh.get(i3);
                if (i >= 0 && i == aaHO0E.f7514AcNBzu) {
                    break;
                }
                i3--;
            }
            if (i3 < 0) {
                return false;
            }
            if ((i2 & 1) != 0) {
                i3--;
                while (i3 >= 0) {
                    AaHO0E aaHO0E2 = (AaHO0E) this.f7615ASJ6gh.get(i3);
                    if (i < 0 || i != aaHO0E2.f7514AcNBzu) {
                        break;
                    }
                    i3--;
                }
            }
        } else {
            i3 = -1;
        }
        if (i3 == this.f7615ASJ6gh.size() - 1) {
            return false;
        }
        for (int size2 = this.f7615ASJ6gh.size() - 1; size2 > i3; size2--) {
            arrayList.add(this.f7615ASJ6gh.remove(size2));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final boolean AlLFFp() {
        BNL6CD bnl6cd;
        boolean z = false;
        if (this.AMqCpz != null) {
            for (int i = 0; i < this.AMqCpz.size(); i++) {
                B2KMhB b2KMhB = (B2KMhB) this.AMqCpz.get(i);
                if (b2KMhB != null) {
                    if ((b2KMhB.f7559B4ZgIw || (bnl6cd = b2KMhB.f7553AlLFFp) == null) ? false : bnl6cd.AlLFFp()) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public final void AmA8tU() {
        if (this.AMqCpz != null) {
            for (int i = 0; i < this.AMqCpz.size(); i++) {
                B2KMhB b2KMhB = (B2KMhB) this.AMqCpz.get(i);
                if (b2KMhB != null) {
                    b2KMhB.f7563BI9f7h = true;
                    BNL6CD bnl6cd = b2KMhB.f7553AlLFFp;
                    if (bnl6cd != null) {
                        bnl6cd.AmA8tU();
                    }
                }
            }
        }
    }

    public final boolean AzWtSf() {
        boolean z;
        BNL6CD bnl6cd;
        ArrayList arrayList = null;
        if (this.AMqCpz != null) {
            z = false;
            for (int i = 0; i < this.AMqCpz.size(); i++) {
                B2KMhB b2KMhB = (B2KMhB) this.AMqCpz.get(i);
                if (b2KMhB != null) {
                    if ((b2KMhB.f7559B4ZgIw || (bnl6cd = b2KMhB.f7553AlLFFp) == null) ? false : bnl6cd.AzWtSf()) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(b2KMhB);
                        z = true;
                    }
                }
            }
        } else {
            z = false;
        }
        if (this.f7616AYUAbz != null) {
            for (int i2 = 0; i2 < this.f7616AYUAbz.size(); i2++) {
                B2KMhB b2KMhB2 = (B2KMhB) this.f7616AYUAbz.get(i2);
                if (arrayList == null || !arrayList.contains(b2KMhB2)) {
                    b2KMhB2.getClass();
                }
            }
        }
        this.f7616AYUAbz = arrayList;
        return z;
    }

    public final boolean B25kr6() {
        BNL6CD bnl6cd;
        if (this.AMqCpz != null) {
            for (int i = 0; i < this.AMqCpz.size(); i++) {
                B2KMhB b2KMhB = (B2KMhB) this.AMqCpz.get(i);
                if (b2KMhB != null) {
                    if ((b2KMhB.f7559B4ZgIw || (bnl6cd = b2KMhB.f7553AlLFFp) == null || !bnl6cd.B25kr6()) ? false : true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void B2KMhB() {
        BNL6CD bnl6cd;
        B2KMhB b2KMhB = this.f7622AmA8tU;
        if (b2KMhB == null || (bnl6cd = b2KMhB.f7586CrfGsy) == null) {
            return;
        }
        bnl6cd.B2KMhB();
    }

    public final void B3GDIM() {
        BNL6CD bnl6cd;
        B2KMhB b2KMhB = this.f7622AmA8tU;
        if (b2KMhB == null || (bnl6cd = b2KMhB.f7586CrfGsy) == null) {
            return;
        }
        bnl6cd.B3GDIM();
    }

    public final void B4ZgIw() {
        BNL6CD bnl6cd;
        ArrayList arrayList = this.AMqCpz;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            B2KMhB b2KMhB = (B2KMhB) this.AMqCpz.get(size);
            if (b2KMhB != null && (bnl6cd = b2KMhB.f7553AlLFFp) != null) {
                bnl6cd.B4ZgIw();
            }
        }
    }

    public final B2KMhB B7CMnp(int i) {
        ArrayList arrayList = this.AMqCpz;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                B2KMhB b2KMhB = (B2KMhB) this.AMqCpz.get(size);
                if (b2KMhB != null && b2KMhB.f7556B25kr6 == i) {
                    return b2KMhB;
                }
            }
        }
        ArrayList arrayList2 = this.f7613ADYaiT;
        if (arrayList2 == null) {
            return null;
        }
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            B2KMhB b2KMhB2 = (B2KMhB) this.f7613ADYaiT.get(size2);
            if (b2KMhB2 != null && b2KMhB2.f7556B25kr6 == i) {
                return b2KMhB2;
            }
        }
        return null;
    }

    public final B2KMhB B9tovu(String str) {
        ArrayList arrayList = this.f7613ADYaiT;
        if (arrayList == null) {
            return null;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            B2KMhB b2KMhB = (B2KMhB) this.f7613ADYaiT.get(size);
            if (b2KMhB != null) {
                if (!str.equals(b2KMhB.f7575CNPG0E)) {
                    BNL6CD bnl6cd = b2KMhB.f7553AlLFFp;
                    b2KMhB = bnl6cd != null ? bnl6cd.B9tovu(str) : null;
                }
                if (b2KMhB != null) {
                    return b2KMhB;
                }
            }
        }
        return null;
    }

    public final void BChYOn() {
        BNL6CD bnl6cd;
        if (this.AMqCpz != null) {
            for (int i = 0; i < this.AMqCpz.size(); i++) {
                B2KMhB b2KMhB = (B2KMhB) this.AMqCpz.get(i);
                if (b2KMhB != null && !b2KMhB.f7559B4ZgIw && (bnl6cd = b2KMhB.f7553AlLFFp) != null) {
                    bnl6cd.BChYOn();
                }
            }
        }
    }

    public final void BI9f7h(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        AZkASS(arrayList, arrayList2);
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!((AaHO0E) arrayList.get(i)).f7521B4ZgIw) {
                if (i2 != i) {
                    AaHO0E(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (((Boolean) arrayList2.get(i)).booleanValue()) {
                    while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((AaHO0E) arrayList.get(i2)).f7521B4ZgIw) {
                        i2++;
                    }
                }
                AaHO0E(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            AaHO0E(arrayList, arrayList2, i2, size);
        }
    }

    public final boolean BJ7GGh() {
        BNL6CD bnl6cd;
        if (this.AMqCpz != null) {
            for (int i = 0; i < this.AMqCpz.size(); i++) {
                B2KMhB b2KMhB = (B2KMhB) this.AMqCpz.get(i);
                if (b2KMhB != null) {
                    if ((b2KMhB.f7559B4ZgIw || (bnl6cd = b2KMhB.f7553AlLFFp) == null || !bnl6cd.BJ7GGh()) ? false : true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void BNL6CD() {
        BNL6CD bnl6cd;
        B2KMhB b2KMhB = this.f7622AmA8tU;
        if (b2KMhB == null || (bnl6cd = b2KMhB.f7586CrfGsy) == null) {
            return;
        }
        bnl6cd.BNL6CD();
    }

    public final void BPw6Q8() {
        BNL6CD bnl6cd;
        B2KMhB b2KMhB = this.f7622AmA8tU;
        if (b2KMhB == null || (bnl6cd = b2KMhB.f7586CrfGsy) == null) {
            return;
        }
        bnl6cd.BPw6Q8();
    }

    public final void BTvldC() {
        BNL6CD bnl6cd;
        B2KMhB b2KMhB = this.f7622AmA8tU;
        if (b2KMhB == null || (bnl6cd = b2KMhB.f7586CrfGsy) == null) {
            return;
        }
        bnl6cd.BTvldC();
    }

    public final void BV3sI0() {
        BNL6CD bnl6cd;
        ArrayList arrayList = this.AMqCpz;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            B2KMhB b2KMhB = (B2KMhB) this.AMqCpz.get(size);
            if (b2KMhB != null && (bnl6cd = b2KMhB.f7553AlLFFp) != null) {
                bnl6cd.BV3sI0();
            }
        }
    }

    public final void BmvVmW() {
        if (this.f7612A5SV6n) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (Looper.myLooper() != this.f7620AcNBzu.f7590ADYaiT.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (this.f7627B4ZgIw == null) {
            this.f7627B4ZgIw = new ArrayList();
            this.f7628B7CMnp = new ArrayList();
        }
        this.f7612A5SV6n = true;
        try {
            AZkASS(null, null);
        } finally {
            this.f7612A5SV6n = false;
        }
    }

    public final void BniPrB() {
        if (this.f7613ADYaiT == null) {
            return;
        }
        for (int i = 0; i < this.f7613ADYaiT.size(); i++) {
            B2KMhB b2KMhB = (B2KMhB) this.f7613ADYaiT.get(i);
            if (b2KMhB != null && b2KMhB.f7565BJ7GGh) {
                if (this.f7612A5SV6n) {
                    this.f7626B3GDIM = true;
                } else {
                    b2KMhB.f7565BJ7GGh = false;
                    A4TApA(b2KMhB, this.f7619AaHO0E, 0, 0, false);
                }
            }
        }
    }

    public final void BpkvW3() {
        BNL6CD bnl6cd;
        B2KMhB b2KMhB = this.f7622AmA8tU;
        if (b2KMhB == null || (bnl6cd = b2KMhB.f7586CrfGsy) == null) {
            return;
        }
        bnl6cd.BpkvW3();
    }

    public final void C2rE4F() {
        BNL6CD bnl6cd;
        B2KMhB b2KMhB = this.f7622AmA8tU;
        if (b2KMhB == null || (bnl6cd = b2KMhB.f7586CrfGsy) == null) {
            return;
        }
        bnl6cd.C2rE4F();
    }

    public final void C4FrIb() {
        BNL6CD bnl6cd;
        B2KMhB b2KMhB = this.f7622AmA8tU;
        if (b2KMhB == null || (bnl6cd = b2KMhB.f7586CrfGsy) == null) {
            return;
        }
        bnl6cd.C4FrIb();
    }

    public final void CASmeH(B2KMhB b2KMhB) {
        if (b2KMhB == null) {
            return;
        }
        int i = this.f7619AaHO0E;
        if (b2KMhB.f7581Cd8JRx) {
            i = b2KMhB.f7585CqNSpT > 0 ? Math.min(i, 1) : Math.min(i, 0);
        }
        int i2 = i;
        B25kr6 b25kr6 = b2KMhB.f7570BmvVmW;
        A4TApA(b2KMhB, i2, b25kr6 == null ? 0 : b25kr6.f7546A4TApA, b25kr6 == null ? 0 : b25kr6.f7547A5SV6n, false);
        if (b2KMhB.f7571BniPrB) {
            b2KMhB.f7571BniPrB = false;
        }
    }

    public final boolean CNPG0E() {
        BmvVmW();
        boolean z = false;
        while (true) {
            ArrayList arrayList = this.f7627B4ZgIw;
            ArrayList arrayList2 = this.f7628B7CMnp;
            synchronized (this) {
                try {
                    ArrayList arrayList3 = this.f7611A4TApA;
                    if (arrayList3 == null || arrayList3.size() == 0) {
                        break;
                    }
                    int size = this.f7611A4TApA.size();
                    for (int i = 0; i < size; i++) {
                        ((BI9f7h) this.f7611A4TApA.get(i)).A2egSU(arrayList, arrayList2);
                    }
                    this.f7611A4TApA.clear();
                    this.f7620AcNBzu.f7590ADYaiT.removeCallbacks(this.f7610A2egSU);
                    if (size <= 0) {
                        break;
                    }
                    z = true;
                    this.f7612A5SV6n = true;
                    try {
                        BI9f7h(this.f7627B4ZgIw, this.f7628B7CMnp);
                    } finally {
                        D07BeM();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        COJEAR();
        return z;
    }

    public final void COJEAR() {
        CcAIMM ccAIMM;
        if (this.f7626B3GDIM) {
            boolean z = false;
            for (int i = 0; i < this.f7613ADYaiT.size(); i++) {
                B2KMhB b2KMhB = (B2KMhB) this.f7613ADYaiT.get(i);
                if (b2KMhB != null && (ccAIMM = b2KMhB.f7567BPw6Q8) != null) {
                    z |= ccAIMM.A4TApA();
                }
            }
            if (z) {
                return;
            }
            this.f7626B3GDIM = false;
            BniPrB();
        }
    }

    public final void CQhlFr(B2KMhB b2KMhB) {
        if (b2KMhB.f7574CASmeH >= 0) {
            return;
        }
        ArrayList arrayList = this.f7614ARc23Z;
        if (arrayList != null && arrayList.size() > 0) {
            b2KMhB.ADYaiT(((Integer) this.f7614ARc23Z.remove(r0.size() - 1)).intValue(), this.f7622AmA8tU);
            this.f7613ADYaiT.set(b2KMhB.f7574CASmeH, b2KMhB);
        } else {
            if (this.f7613ADYaiT == null) {
                this.f7613ADYaiT = new ArrayList();
            }
            b2KMhB.ADYaiT(this.f7613ADYaiT.size(), this.f7622AmA8tU);
            this.f7613ADYaiT.add(b2KMhB);
        }
    }

    public final void CSDoyG() {
        BNL6CD bnl6cd;
        B2KMhB b2KMhB = this.f7622AmA8tU;
        if (b2KMhB == null || (bnl6cd = b2KMhB.f7586CrfGsy) == null) {
            return;
        }
        bnl6cd.CSDoyG();
    }

    public final void CTkVKb() {
        BNL6CD bnl6cd;
        B2KMhB b2KMhB = this.f7622AmA8tU;
        if (b2KMhB == null || (bnl6cd = b2KMhB.f7586CrfGsy) == null) {
            return;
        }
        bnl6cd.CTkVKb();
    }

    public final BPw6Q8 CcAIMM() {
        ArrayList arrayList;
        ArrayList arrayList2;
        BPw6Q8 CcAIMM2;
        if (this.f7613ADYaiT != null) {
            arrayList = null;
            arrayList2 = null;
            for (int i = 0; i < this.f7613ADYaiT.size(); i++) {
                B2KMhB b2KMhB = (B2KMhB) this.f7613ADYaiT.get(i);
                if (b2KMhB != null) {
                    boolean z = true;
                    if (b2KMhB.f7561B9tovu) {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(b2KMhB);
                        b2KMhB.f7562BChYOn = true;
                        B2KMhB b2KMhB2 = b2KMhB.f7577CQhlFr;
                        b2KMhB.f7578CSDoyG = b2KMhB2 != null ? b2KMhB2.f7574CASmeH : -1;
                    }
                    BNL6CD bnl6cd = b2KMhB.f7553AlLFFp;
                    if (bnl6cd == null || (CcAIMM2 = bnl6cd.CcAIMM()) == null) {
                        z = false;
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            for (int i2 = 0; i2 < i; i2++) {
                                arrayList.add(null);
                            }
                        }
                        arrayList.add(CcAIMM2);
                    }
                    if (arrayList != null && !z) {
                        arrayList.add(null);
                    }
                }
            }
        } else {
            arrayList = null;
            arrayList2 = null;
        }
        if (arrayList2 == null && arrayList == null) {
            return null;
        }
        return new BPw6Q8(arrayList2, arrayList);
    }

    public final void Cd8JRx() {
        BNL6CD bnl6cd;
        B2KMhB b2KMhB = this.f7622AmA8tU;
        if (b2KMhB == null || (bnl6cd = b2KMhB.f7586CrfGsy) == null) {
            return;
        }
        bnl6cd.Cd8JRx();
    }

    public final BTvldC CikNvS() {
        int[] iArr;
        int size;
        int size2;
        Bundle bundle;
        BTvldC CikNvS2;
        ArrayList arrayList = this.f7613ADYaiT;
        int size3 = arrayList == null ? 0 : arrayList.size();
        for (int i = 0; i < size3; i++) {
        }
        CNPG0E();
        this.f7623AzWtSf = true;
        ArrayList arrayList2 = this.f7613ADYaiT;
        AcNBzu[] acNBzuArr = null;
        if (arrayList2 != null && arrayList2.size() > 0) {
            int size4 = this.f7613ADYaiT.size();
            BV3sI0[] bV3sI0Arr = new BV3sI0[size4];
            boolean z = false;
            for (int i2 = 0; i2 < size4; i2++) {
                B2KMhB b2KMhB = (B2KMhB) this.f7613ADYaiT.get(i2);
                if (b2KMhB != null) {
                    if (b2KMhB.f7574CASmeH < 0) {
                        AYUAbz(new IllegalStateException("Failure saving state: active " + b2KMhB + " has cleared index: " + b2KMhB.f7574CASmeH));
                        throw null;
                    }
                    BV3sI0 bV3sI0 = new BV3sI0(b2KMhB);
                    bV3sI0Arr[i2] = bV3sI0;
                    if (b2KMhB.BpkvW3 <= 0 || bV3sI0.f7646BChYOn != null) {
                        bV3sI0.f7646BChYOn = b2KMhB.f7572C2rE4F;
                    } else {
                        if (this.f7630BChYOn == null) {
                            this.f7630BChYOn = new Bundle();
                        }
                        Bundle bundle2 = this.f7630BChYOn;
                        b2KMhB.AlLFFp(bundle2);
                        BNL6CD bnl6cd = b2KMhB.f7553AlLFFp;
                        if (bnl6cd != null && (CikNvS2 = bnl6cd.CikNvS()) != null) {
                            bundle2.putParcelable("android:support:fragments", CikNvS2);
                        }
                        BpkvW3();
                        if (this.f7630BChYOn.isEmpty()) {
                            bundle = null;
                        } else {
                            bundle = this.f7630BChYOn;
                            this.f7630BChYOn = null;
                        }
                        if (b2KMhB.f7573C4FrIb != null) {
                            if (bundle == null) {
                                bundle = new Bundle();
                            }
                            bundle.putSparseParcelableArray("android:view_state", b2KMhB.f7573C4FrIb);
                        }
                        if (!b2KMhB.f7566BNL6CD) {
                            if (bundle == null) {
                                bundle = new Bundle();
                            }
                            bundle.putBoolean("android:user_visible_hint", b2KMhB.f7566BNL6CD);
                        }
                        bV3sI0.f7646BChYOn = bundle;
                        B2KMhB b2KMhB2 = b2KMhB.f7577CQhlFr;
                        if (b2KMhB2 != null) {
                            if (b2KMhB2.f7574CASmeH < 0) {
                                AYUAbz(new IllegalStateException("Failure saving state: " + b2KMhB + " has target not in fragment manager: " + b2KMhB.f7577CQhlFr));
                                throw null;
                            }
                            if (bundle == null) {
                                bV3sI0.f7646BChYOn = new Bundle();
                            }
                            Bundle bundle3 = bV3sI0.f7646BChYOn;
                            B2KMhB b2KMhB3 = b2KMhB.f7577CQhlFr;
                            int i3 = b2KMhB3.f7574CASmeH;
                            if (i3 < 0) {
                                AYUAbz(new IllegalStateException("Fragment " + b2KMhB3 + " is not currently in the FragmentManager"));
                                throw null;
                            }
                            bundle3.putInt("android:target_state", i3);
                            int i4 = b2KMhB.f7579CTkVKb;
                            if (i4 != 0) {
                                bV3sI0.f7646BChYOn.putInt("android:target_req_state", i4);
                            }
                        }
                    }
                    z = true;
                }
            }
            if (z) {
                ArrayList arrayList3 = this.AMqCpz;
                if (arrayList3 == null || (size2 = arrayList3.size()) <= 0) {
                    iArr = null;
                } else {
                    iArr = new int[size2];
                    for (int i5 = 0; i5 < size2; i5++) {
                        int i6 = ((B2KMhB) this.AMqCpz.get(i5)).f7574CASmeH;
                        iArr[i5] = i6;
                        if (i6 < 0) {
                            AYUAbz(new IllegalStateException("Failure saving state: active " + this.AMqCpz.get(i5) + " has cleared index: " + iArr[i5]));
                            throw null;
                        }
                    }
                }
                ArrayList arrayList4 = this.f7615ASJ6gh;
                if (arrayList4 != null && (size = arrayList4.size()) > 0) {
                    acNBzuArr = new AcNBzu[size];
                    for (int i7 = 0; i7 < size; i7++) {
                        acNBzuArr[i7] = new AcNBzu((AaHO0E) this.f7615ASJ6gh.get(i7));
                    }
                }
                BTvldC bTvldC = new BTvldC();
                bTvldC.f7633AcNBzu = bV3sI0Arr;
                bTvldC.f7634AlLFFp = iArr;
                bTvldC.f7635AmA8tU = acNBzuArr;
                return bTvldC;
            }
        }
        return null;
    }

    public final void CkXcdM() {
        BNL6CD bnl6cd;
        B2KMhB b2KMhB = this.f7622AmA8tU;
        if (b2KMhB == null || (bnl6cd = b2KMhB.f7586CrfGsy) == null) {
            return;
        }
        bnl6cd.CkXcdM();
    }

    public final void CmUvjW(B2KMhB b2KMhB) {
        if (b2KMhB.f7560B7CMnp) {
            b2KMhB.f7560B7CMnp = false;
            if (b2KMhB.f7580CcAIMM) {
                return;
            }
            if (this.AMqCpz == null) {
                this.AMqCpz = new ArrayList();
            }
            if (this.AMqCpz.contains(b2KMhB)) {
                throw new IllegalStateException("Fragment already added: " + b2KMhB);
            }
            this.AMqCpz.add(b2KMhB);
            b2KMhB.f7580CcAIMM = true;
        }
    }

    public final void CqNSpT() {
        this.f7624B25kr6 = true;
        CNPG0E();
        this.f7612A5SV6n = true;
        A2egSU(0, false);
        this.f7612A5SV6n = false;
        this.f7620AcNBzu = null;
        this.f7621AlLFFp = null;
        this.f7622AmA8tU = null;
    }

    public final void CrfGsy() {
        if (this.AMqCpz != null) {
            for (int i = 0; i < this.AMqCpz.size(); i++) {
                B2KMhB b2KMhB = (B2KMhB) this.AMqCpz.get(i);
                if (b2KMhB != null) {
                    b2KMhB.f7563BI9f7h = true;
                    BNL6CD bnl6cd = b2KMhB.f7553AlLFFp;
                    if (bnl6cd != null) {
                        bnl6cd.CrfGsy();
                    }
                }
            }
        }
    }

    public final void CtFAbx() {
        if (this.f7623AzWtSf) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.f7625B2KMhB == null) {
            return;
        }
        throw new IllegalStateException("Can not perform this action inside of " + this.f7625B2KMhB);
    }

    public final void CtxOCS() {
        synchronized (this) {
            boolean z = false;
            try {
                ArrayList arrayList = this.f7611A4TApA;
                if (arrayList != null && arrayList.size() == 1) {
                    z = true;
                }
                if (z) {
                    this.f7620AcNBzu.f7590ADYaiT.removeCallbacks(this.f7610A2egSU);
                    this.f7620AcNBzu.f7590ADYaiT.post(this.f7610A2egSU);
                }
            } finally {
            }
        }
    }

    public final void D07BeM() {
        this.f7612A5SV6n = false;
        this.f7628B7CMnp.clear();
        this.f7627B4ZgIw.clear();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(r.b.d);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        B2KMhB b2KMhB = this.f7622AmA8tU;
        if (b2KMhB != null) {
            QkAq4X.ADYaiT.A4TApA(b2KMhB, sb);
        } else {
            QkAq4X.ADYaiT.A4TApA(this.f7620AcNBzu, sb);
        }
        sb.append("}}");
        return sb.toString();
    }
}
