package com.bumptech.glide;

import ADYaiT.CtFAbx;
import ADYaiT.DUi7mC;
import Hjvs0g.AYUAbz;
import Hjvs0g.BniPrB;
import Hjvs0g.BpkvW3;
import Hjvs0g.C2rE4F;
import Hjvs0g.C4FrIb;
import Hjvs0g.CASmeH;
import Hjvs0g.COJEAR;
import Hjvs0g.CQhlFr;
import Hjvs0g.CcAIMM;
import HtmBAy.A2egSU;
import I3HV03.B4ZgIw;
import I3HV03.BI9f7h;
import I3HV03.BNL6CD;
import I3HV03.COJEAR;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.sigmob.sdk.base.n;
import com.sigmob.sdk.base.views.r;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA implements ComponentCallbacks2 {

    /* renamed from: B7CMnp, reason: collision with root package name */
    public static volatile A4TApA f9873B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public static volatile boolean f9874B9tovu;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final HZUvgL.ADYaiT f9875AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Hdahpu.AMqCpz f9876AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final ARc23Z f9877AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final AaHO0E f9878AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final HZUvgL.AaHO0E f9879B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final IQ76hF.AaHO0E f9880B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final IQ76hF.ADYaiT f9881B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final ArrayList f9882B4ZgIw = new ArrayList();

    public A4TApA(Context context, HXc4pW.AzWtSf azWtSf, Hdahpu.AMqCpz aMqCpz, HZUvgL.ADYaiT aDYaiT, HZUvgL.AaHO0E aaHO0E, IQ76hF.AaHO0E aaHO0E2, IQ76hF.ADYaiT aDYaiT2, int i, OLy1FW.AzWtSf azWtSf2, B25kr6.ADYaiT aDYaiT3, List list, NGepWW.A2egSU a2egSU) {
        HSHyT0.B25kr6 aYUAbz;
        HSHyT0.B25kr6 a2egSU2;
        this.f9875AcNBzu = aDYaiT;
        this.f9879B25kr6 = aaHO0E;
        this.f9876AlLFFp = aMqCpz;
        this.f9880B2KMhB = aaHO0E2;
        this.f9881B3GDIM = aDYaiT2;
        Resources resources = context.getResources();
        AaHO0E aaHO0E3 = new AaHO0E();
        this.f9878AzWtSf = aaHO0E3;
        I3HV03.AzWtSf azWtSf3 = new I3HV03.AzWtSf();
        Ifhupb.A5SV6n a5SV6n = aaHO0E3.f9939ASJ6gh;
        synchronized (a5SV6n) {
            a5SV6n.f3967A2egSU.add(azWtSf3);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 27) {
            aaHO0E3.AYUAbz(new BI9f7h());
        }
        ArrayList ARc23Z2 = aaHO0E3.ARc23Z();
        IJPJ4E.A2egSU a2egSU3 = new IJPJ4E.A2egSU(context, ARc23Z2, aDYaiT, aaHO0E);
        COJEAR cojear = new COJEAR(aDYaiT, new Hdahpu.AZOQYO(11));
        B4ZgIw b4ZgIw = new B4ZgIw(aaHO0E3.ARc23Z(), resources.getDisplayMetrics(), aDYaiT, aaHO0E);
        if (!((Map) a2egSU.f5658AlLFFp).containsKey(A5SV6n.class) || i2 < 28) {
            aYUAbz = new I3HV03.AYUAbz(b4ZgIw, 0);
            a2egSU2 = new I3HV03.A2egSU(b4ZgIw, 2, aaHO0E);
        } else {
            a2egSU2 = new BNL6CD();
            aYUAbz = new I3HV03.AZOQYO();
        }
        I9dkCd.A5SV6n a5SV6n2 = new I9dkCd.A5SV6n(context);
        BniPrB bniPrB = new BniPrB(resources, 1);
        BpkvW3 bpkvW3 = new BpkvW3(resources, 1);
        BpkvW3 bpkvW32 = new BpkvW3(resources, 0);
        BniPrB bniPrB2 = new BniPrB(resources, 0);
        I3HV03.A5SV6n a5SV6n3 = new I3HV03.A5SV6n(aaHO0E);
        IOxIEW.A2egSU a2egSU4 = new IOxIEW.A2egSU();
        IOxIEW.A4TApA a4TApA = new IOxIEW.A4TApA();
        ContentResolver contentResolver = context.getContentResolver();
        aaHO0E3.A2egSU(ByteBuffer.class, new Hjvs0g.ARc23Z());
        aaHO0E3.A2egSU(InputStream.class, new KCxDWD.A5SV6n(28, aaHO0E));
        aaHO0E3.ADYaiT("Bitmap", ByteBuffer.class, Bitmap.class, aYUAbz);
        aaHO0E3.ADYaiT("Bitmap", InputStream.class, Bitmap.class, a2egSU2);
        aaHO0E3.ADYaiT("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new I3HV03.AYUAbz(b4ZgIw, 1));
        aaHO0E3.ADYaiT("Bitmap", ParcelFileDescriptor.class, Bitmap.class, cojear);
        aaHO0E3.ADYaiT("Bitmap", AssetFileDescriptor.class, Bitmap.class, new COJEAR(aDYaiT, new Hdahpu.AZOQYO(8)));
        COJEAR.A2egSU a2egSU5 = COJEAR.A2egSU.f3770AcNBzu;
        aaHO0E3.A5SV6n(Bitmap.class, Bitmap.class, a2egSU5);
        aaHO0E3.ADYaiT("Bitmap", Bitmap.class, Bitmap.class, new I3HV03.BpkvW3());
        aaHO0E3.A4TApA(Bitmap.class, a5SV6n3);
        aaHO0E3.ADYaiT("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new I3HV03.A2egSU(resources, aYUAbz));
        aaHO0E3.ADYaiT("BitmapDrawable", InputStream.class, BitmapDrawable.class, new I3HV03.A2egSU(resources, a2egSU2));
        aaHO0E3.ADYaiT("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new I3HV03.A2egSU(resources, cojear));
        aaHO0E3.A4TApA(BitmapDrawable.class, new I3HV03.A4TApA(aDYaiT, 0, a5SV6n3));
        aaHO0E3.ADYaiT("Gif", InputStream.class, IJPJ4E.A4TApA.class, new IJPJ4E.AZkASS(ARc23Z2, a2egSU3, aaHO0E));
        aaHO0E3.ADYaiT("Gif", ByteBuffer.class, IJPJ4E.A4TApA.class, a2egSU3);
        aaHO0E3.A4TApA(IJPJ4E.A4TApA.class, new IJPJ4E.A5SV6n());
        aaHO0E3.A5SV6n(HPJABZ.ADYaiT.class, HPJABZ.ADYaiT.class, a2egSU5);
        aaHO0E3.ADYaiT("Bitmap", HPJABZ.ADYaiT.class, Bitmap.class, new I9dkCd.A5SV6n(aDYaiT));
        aaHO0E3.ADYaiT("legacy_append", Uri.class, Drawable.class, a5SV6n2);
        aaHO0E3.ADYaiT("legacy_append", Uri.class, Bitmap.class, new I3HV03.A2egSU(a5SV6n2, 1, aDYaiT));
        aaHO0E3.AZOQYO(new I3bnmY.A2egSU());
        aaHO0E3.A5SV6n(File.class, ByteBuffer.class, new AYUAbz.A2egSU());
        aaHO0E3.A5SV6n(File.class, InputStream.class, new Hjvs0g.AaHO0E());
        aaHO0E3.ADYaiT("legacy_append", File.class, File.class, new IDXjOL.A2egSU());
        aaHO0E3.A5SV6n(File.class, ParcelFileDescriptor.class, new Hjvs0g.AZkASS());
        aaHO0E3.A5SV6n(File.class, File.class, a2egSU5);
        aaHO0E3.AZOQYO(new com.bumptech.glide.load.data.AlLFFp(aaHO0E));
        aaHO0E3.AZOQYO(new com.bumptech.glide.load.data.AmA8tU());
        Class cls = Integer.TYPE;
        aaHO0E3.A5SV6n(cls, InputStream.class, bniPrB);
        aaHO0E3.A5SV6n(cls, ParcelFileDescriptor.class, bpkvW32);
        aaHO0E3.A5SV6n(Integer.class, InputStream.class, bniPrB);
        aaHO0E3.A5SV6n(Integer.class, ParcelFileDescriptor.class, bpkvW32);
        aaHO0E3.A5SV6n(Integer.class, Uri.class, bpkvW3);
        aaHO0E3.A5SV6n(cls, AssetFileDescriptor.class, bniPrB2);
        aaHO0E3.A5SV6n(Integer.class, AssetFileDescriptor.class, bniPrB2);
        aaHO0E3.A5SV6n(cls, Uri.class, bpkvW3);
        aaHO0E3.A5SV6n(String.class, InputStream.class, new Hjvs0g.AZOQYO());
        aaHO0E3.A5SV6n(Uri.class, InputStream.class, new Hjvs0g.AZOQYO());
        aaHO0E3.A5SV6n(String.class, InputStream.class, new CASmeH());
        aaHO0E3.A5SV6n(String.class, ParcelFileDescriptor.class, new C4FrIb());
        aaHO0E3.A5SV6n(String.class, AssetFileDescriptor.class, new C2rE4F());
        aaHO0E3.A5SV6n(Uri.class, InputStream.class, new AZkASS.ARc23Z(16, context.getAssets()));
        aaHO0E3.A5SV6n(Uri.class, ParcelFileDescriptor.class, new KCxDWD.A5SV6n(27, context.getAssets()));
        aaHO0E3.A5SV6n(Uri.class, InputStream.class, new EsrwYR.A4TApA(context, 5));
        aaHO0E3.A5SV6n(Uri.class, InputStream.class, new NOd7IU.AmA8tU(context, 8, false));
        if (i2 >= 29) {
            aaHO0E3.A5SV6n(Uri.class, InputStream.class, new HtmBAy.A4TApA(context, InputStream.class));
            aaHO0E3.A5SV6n(Uri.class, ParcelFileDescriptor.class, new HtmBAy.A4TApA(context, ParcelFileDescriptor.class));
        }
        aaHO0E3.A5SV6n(Uri.class, InputStream.class, new CQhlFr(contentResolver, 1));
        aaHO0E3.A5SV6n(Uri.class, ParcelFileDescriptor.class, new KCxDWD.A5SV6n(29, contentResolver));
        aaHO0E3.A5SV6n(Uri.class, AssetFileDescriptor.class, new CQhlFr(contentResolver, 0));
        aaHO0E3.A5SV6n(Uri.class, InputStream.class, new CcAIMM());
        aaHO0E3.A5SV6n(URL.class, InputStream.class, new HtmBAy.AMqCpz());
        aaHO0E3.A5SV6n(Uri.class, File.class, new EsrwYR.A4TApA(context, 4));
        aaHO0E3.A5SV6n(Hjvs0g.AcNBzu.class, InputStream.class, new A2egSU.C0001A2egSU());
        aaHO0E3.A5SV6n(byte[].class, ByteBuffer.class, new Hjvs0g.A5SV6n());
        aaHO0E3.A5SV6n(byte[].class, InputStream.class, new Hjvs0g.ADYaiT());
        aaHO0E3.A5SV6n(Uri.class, Uri.class, a2egSU5);
        aaHO0E3.A5SV6n(Drawable.class, Drawable.class, a2egSU5);
        aaHO0E3.ADYaiT("legacy_append", Drawable.class, Drawable.class, new I9dkCd.ADYaiT());
        aaHO0E3.AZkASS(Bitmap.class, BitmapDrawable.class, new BniPrB(resources, 2));
        aaHO0E3.AZkASS(Bitmap.class, byte[].class, a2egSU4);
        aaHO0E3.AZkASS(Drawable.class, byte[].class, new DUi7mC(14, aDYaiT, a2egSU4, a4TApA));
        aaHO0E3.AZkASS(IJPJ4E.A4TApA.class, byte[].class, a4TApA);
        if (i2 >= 23) {
            I3HV03.COJEAR cojear2 = new I3HV03.COJEAR(aDYaiT, new Hdahpu.AZOQYO(9));
            aaHO0E3.ADYaiT("legacy_append", ByteBuffer.class, Bitmap.class, cojear2);
            aaHO0E3.ADYaiT("legacy_append", ByteBuffer.class, BitmapDrawable.class, new I3HV03.A2egSU(resources, cojear2));
        }
        this.f9877AmA8tU = new ARc23Z(context, aaHO0E, aaHO0E3, new IlwJBd.ARc23Z(), azWtSf2, aDYaiT3, list, azWtSf, a2egSU, i);
    }

    public static void A2egSU(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (f9874B9tovu) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        f9874B9tovu = true;
        ADYaiT aDYaiT = new ADYaiT();
        Context applicationContext = context.getApplicationContext();
        List list = Collections.EMPTY_LIST;
        Log.isLoggable("ManifestParser", 3);
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), r.b.d);
            if (applicationInfo.metaData == null) {
                Log.isLoggable("ManifestParser", 3);
            } else {
                if (Log.isLoggable("ManifestParser", 2)) {
                    Objects.toString(applicationInfo.metaData);
                }
                for (String str : applicationInfo.metaData.keySet()) {
                    if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                        A5SV6n.CrfGsy(str);
                        throw null;
                    }
                }
                Log.isLoggable("ManifestParser", 3);
            }
            if (generatedAppGlideModule != null && !generatedAppGlideModule.A2egSU().isEmpty()) {
                generatedAppGlideModule.A2egSU();
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    throw CtFAbx.A5SV6n(it);
                }
            }
            if (Log.isLoggable("Glide", 3)) {
                Iterator it2 = arrayList.iterator();
                if (it2.hasNext()) {
                    throw CtFAbx.A5SV6n(it2);
                }
            }
            Iterator it3 = arrayList.iterator();
            if (it3.hasNext()) {
                throw CtFAbx.A5SV6n(it3);
            }
            if (aDYaiT.f9905ASJ6gh == null) {
                if (HieBYM.A5SV6n.f3709AmA8tU == 0) {
                    HieBYM.A5SV6n.f3709AmA8tU = Math.min(4, Runtime.getRuntime().availableProcessors());
                }
                int i = HieBYM.A5SV6n.f3709AmA8tU;
                if (TextUtils.isEmpty(n.l)) {
                    throw new IllegalArgumentException("Name must be non-null and non-empty, but given: source");
                }
                aDYaiT.f9905ASJ6gh = new HieBYM.A5SV6n(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new HieBYM.A4TApA(n.l, false)));
            }
            if (aDYaiT.f9906AYUAbz == null) {
                int i2 = HieBYM.A5SV6n.f3709AmA8tU;
                if (TextUtils.isEmpty("disk-cache")) {
                    throw new IllegalArgumentException("Name must be non-null and non-empty, but given: disk-cache");
                }
                aDYaiT.f9906AYUAbz = new HieBYM.A5SV6n(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new HieBYM.A4TApA("disk-cache", true)));
            }
            if (aDYaiT.f9912AmA8tU == null) {
                if (HieBYM.A5SV6n.f3709AmA8tU == 0) {
                    HieBYM.A5SV6n.f3709AmA8tU = Math.min(4, Runtime.getRuntime().availableProcessors());
                }
                int i3 = HieBYM.A5SV6n.f3709AmA8tU >= 4 ? 2 : 1;
                if (TextUtils.isEmpty("animation")) {
                    throw new IllegalArgumentException("Name must be non-null and non-empty, but given: animation");
                }
                aDYaiT.f9912AmA8tU = new HieBYM.A5SV6n(new ThreadPoolExecutor(i3, i3, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new HieBYM.A4TApA("animation", true)));
            }
            if (aDYaiT.f9908AZkASS == null) {
                aDYaiT.f9908AZkASS = new Hdahpu.AYUAbz(new Hdahpu.ARc23Z(applicationContext));
            }
            if (aDYaiT.f9909AaHO0E == null) {
                aDYaiT.f9909AaHO0E = new IQ76hF.ADYaiT();
            }
            if (aDYaiT.f9903ADYaiT == null) {
                int i4 = aDYaiT.f9908AZkASS.f3696A2egSU;
                if (i4 > 0) {
                    aDYaiT.f9903ADYaiT = new HZUvgL.AcNBzu(i4);
                } else {
                    aDYaiT.f9903ADYaiT = new HZUvgL.AMqCpz();
                }
            }
            if (aDYaiT.AMqCpz == null) {
                aDYaiT.AMqCpz = new HZUvgL.AaHO0E(aDYaiT.f9908AZkASS.f3698A5SV6n);
            }
            if (aDYaiT.f9904ARc23Z == null) {
                aDYaiT.f9904ARc23Z = new Hdahpu.AMqCpz(aDYaiT.f9908AZkASS.f3697A4TApA);
            }
            if (aDYaiT.f9907AZOQYO == null) {
                aDYaiT.f9907AZOQYO = new KCxDWD.A5SV6n(applicationContext, 26);
            }
            if (aDYaiT.f9902A5SV6n == null) {
                aDYaiT.f9902A5SV6n = new HXc4pW.AzWtSf(aDYaiT.f9904ARc23Z, aDYaiT.f9907AZOQYO, aDYaiT.f9906AYUAbz, aDYaiT.f9905ASJ6gh, new HieBYM.A5SV6n(new ThreadPoolExecutor(0, Integer.MAX_VALUE, HieBYM.A5SV6n.f3708AlLFFp, TimeUnit.MILLISECONDS, new SynchronousQueue(), new HieBYM.A4TApA("source-unlimited", false))), aDYaiT.f9912AmA8tU);
            }
            List list2 = aDYaiT.f9913AzWtSf;
            if (list2 == null) {
                aDYaiT.f9913AzWtSf = Collections.EMPTY_LIST;
            } else {
                aDYaiT.f9913AzWtSf = Collections.unmodifiableList(list2);
            }
            ASJ6gh aSJ6gh = aDYaiT.f9901A4TApA;
            aSJ6gh.getClass();
            NGepWW.A2egSU a2egSU = new NGepWW.A2egSU(aSJ6gh);
            A4TApA a4TApA = new A4TApA(applicationContext, aDYaiT.f9902A5SV6n, aDYaiT.f9904ARc23Z, aDYaiT.f9903ADYaiT, aDYaiT.AMqCpz, new IQ76hF.AaHO0E(a2egSU), aDYaiT.f9909AaHO0E, aDYaiT.f9910AcNBzu, aDYaiT.f9911AlLFFp, aDYaiT.f9900A2egSU, aDYaiT.f9913AzWtSf, a2egSU);
            Iterator it4 = arrayList.iterator();
            if (it4.hasNext()) {
                throw CtFAbx.A5SV6n(it4);
            }
            applicationContext.registerComponentCallbacks(a4TApA);
            f9873B7CMnp = a4TApA;
            f9874B9tovu = false;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
        }
    }

    public static A4TApA A4TApA(Context context) {
        GeneratedAppGlideModule generatedAppGlideModule;
        if (f9873B7CMnp == null) {
            try {
                generatedAppGlideModule = (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext().getApplicationContext());
            } catch (ClassNotFoundException unused) {
                Log.isLoggable("Glide", 5);
                generatedAppGlideModule = null;
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e);
            } catch (InstantiationException e2) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e2);
            } catch (NoSuchMethodException e3) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e3);
            } catch (InvocationTargetException e4) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e4);
            }
            synchronized (A4TApA.class) {
                try {
                    if (f9873B7CMnp == null) {
                        A2egSU(context, generatedAppGlideModule);
                    }
                } finally {
                }
            }
        }
        return f9873B7CMnp;
    }

    public static IQ76hF.AaHO0E A5SV6n(Context context) {
        ItGa5w.ARc23Z.A5SV6n(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return A4TApA(context).f9880B2KMhB;
    }

    public static AzWtSf ARc23Z(Context context) {
        return A5SV6n(context).A5SV6n(context);
    }

    public final void ADYaiT(AzWtSf azWtSf) {
        synchronized (this.f9882B4ZgIw) {
            try {
                if (this.f9882B4ZgIw.contains(azWtSf)) {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
                this.f9882B4ZgIw.add(azWtSf);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void AMqCpz(AzWtSf azWtSf) {
        synchronized (this.f9882B4ZgIw) {
            try {
                if (!this.f9882B4ZgIw.contains(azWtSf)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
                this.f9882B4ZgIw.remove(azWtSf);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Context getContext() {
        return this.f9877AmA8tU.getBaseContext();
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        char[] cArr = ItGa5w.AlLFFp.f4092A2egSU;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
        this.f9876AlLFFp.AMqCpz(0L);
        this.f9875AcNBzu.AMqCpz();
        this.f9879B25kr6.A2egSU();
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        char[] cArr = ItGa5w.AlLFFp.f4092A2egSU;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
        synchronized (this.f9882B4ZgIw) {
            try {
                Iterator it = this.f9882B4ZgIw.iterator();
                while (it.hasNext()) {
                    ((AzWtSf) it.next()).getClass();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f9876AlLFFp.ARc23Z(i);
        this.f9875AcNBzu.ADYaiT(i);
        this.f9879B25kr6.AZOQYO(i);
    }
}
