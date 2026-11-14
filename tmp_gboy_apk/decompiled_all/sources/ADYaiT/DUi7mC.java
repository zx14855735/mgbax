package ADYaiT;

import android.content.ClipDescription;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.game.boy.emu.gba.Console;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.xml.parsers.DocumentBuilderFactory;
import okhttp3.Call;
import okhttp3.Callback;
import org.apache.http.conn.ConnectTimeoutException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DUi7mC implements Cd8JRx.AYUAbz, Callback, EmJGcg.A2egSU, GYpKKt.A2egSU, GnQT2j.AlLFFp, IOxIEW.A5SV6n, com.google.gson.internal.AlLFFp {

    /* renamed from: B25kr6, reason: collision with root package name */
    public static DUi7mC f237B25kr6;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f238AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Object f239AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Object f240AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public Object f241AzWtSf;

    public /* synthetic */ DUi7mC(int i) {
        this.f238AcNBzu = i;
    }

    public static void B2KMhB(String str, Object... objArr) {
        String.format(Locale.US, str, objArr);
    }

    private final void BI9f7h() {
    }

    @Override // Cd8JRx.AYUAbz
    public Uri A2egSU() {
        return (Uri) this.f239AlLFFp;
    }

    @Override // EmJGcg.A2egSU
    public void A4TApA(GEYgCP.A2egSU a2egSU) {
        Object obj;
        Context context = (Context) this.f239AlLFFp;
        if (context != null) {
            Class cls = (Class) this.f240AmA8tU;
            if (cls == null || (obj = this.f241AzWtSf) == null) {
                new GL2Jh7.A2egSU("Xiaomi IdProvider not exists");
                return;
            }
            try {
                String str = (String) cls.getMethod("getOAID", Context.class).invoke(obj, context);
                if (str == null || str.length() == 0) {
                    throw new GL2Jh7.A2egSU("OAID query failed");
                }
                NOd7IU.AlLFFp.f5886AlLFFp = str;
            } catch (Exception unused) {
            }
        }
    }

    @Override // Cd8JRx.AYUAbz
    public void A5SV6n() {
    }

    @Override // Cd8JRx.AYUAbz
    public Uri ADYaiT() {
        return (Uri) this.f241AzWtSf;
    }

    @Override // GYpKKt.A2egSU
    public void AMqCpz(Object obj) {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        EY4UKY.ADYaiT aDYaiT = new EY4UKY.ADYaiT();
        H0qugq.AZOQYO azoqyo = (H0qugq.AZOQYO) this.f241AzWtSf;
        aDYaiT.AzWtSf((String) this.f239AlLFFp, (String) this.f240AmA8tU, true, azoqyo.f3187AYUAbz, azoqyo.f3200B9tovu);
    }

    @Override // IOxIEW.A5SV6n
    public HXc4pW.BTvldC ARc23Z(HXc4pW.BTvldC bTvldC, HSHyT0.AmA8tU amA8tU) {
        Drawable drawable = (Drawable) bTvldC.get();
        if (drawable instanceof BitmapDrawable) {
            return ((IOxIEW.A2egSU) this.f240AmA8tU).ARc23Z(I3HV03.ARc23Z.A5SV6n((HZUvgL.ADYaiT) this.f239AlLFFp, ((BitmapDrawable) drawable).getBitmap()), amA8tU);
        }
        if (drawable instanceof IJPJ4E.A4TApA) {
            return ((IOxIEW.A4TApA) this.f241AzWtSf).ARc23Z(bTvldC, amA8tU);
        }
        return null;
    }

    @Override // Cd8JRx.AYUAbz
    public Object ASJ6gh() {
        return null;
    }

    public Object AYUAbz() {
        Object A2egSU2 = ((CNPG0E.A5SV6n) this.f241AzWtSf).A2egSU();
        if (A2egSU2 == null) {
            A2egSU2 = ((Ixu71n.A2egSU) this.f239AlLFFp).ARc23Z();
            if (Log.isLoggable("FactoryPools", 2)) {
                A2egSU2.getClass().toString();
            }
        }
        if (A2egSU2 instanceof Ixu71n.A4TApA) {
            ((Ixu71n.A4TApA) A2egSU2).ADYaiT().f4096A2egSU = false;
        }
        return A2egSU2;
    }

    public List AZOQYO() {
        String[] strArr;
        if (((ArrayList) this.f240AmA8tU) == null) {
            File file = (File) this.f241AzWtSf;
            ArrayList arrayList = new ArrayList();
            try {
                NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file).getDocumentElement().getElementsByTagName("cheat");
                for (int i = 0; i < elementsByTagName.getLength(); i++) {
                    Element element = (Element) elementsByTagName.item(i);
                    KpHwm4.ASJ6gh aSJ6gh = new KpHwm4.ASJ6gh();
                    aSJ6gh.f4289A2egSU = !"false".equals(element.getAttribute("enabled"));
                    aSJ6gh.f4291A5SV6n = element.getAttribute(PointParamKey.TYPE);
                    aSJ6gh.f4290A4TApA = element.getAttribute("name");
                    NodeList elementsByTagName2 = element.getElementsByTagName(PluginConstants.KEY_ERROR_CODE);
                    aSJ6gh.f4292ADYaiT = new String[elementsByTagName2.getLength()];
                    int i2 = 0;
                    while (true) {
                        strArr = aSJ6gh.f4292ADYaiT;
                        if (i2 >= strArr.length) {
                            break;
                        }
                        strArr[i2] = ((Text) elementsByTagName2.item(i2).getFirstChild()).getData();
                        i2++;
                    }
                    if (strArr.length > 0) {
                        arrayList.add(aSJ6gh);
                    }
                }
            } catch (FileNotFoundException unused) {
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f240AmA8tU = arrayList;
        }
        return (ArrayList) this.f240AmA8tU;
    }

    @Override // com.google.gson.internal.AlLFFp
    public Object AZkASS() {
        try {
            return ((com.google.gson.internal.B9tovu) this.f239AlLFFp).A4TApA((Class) this.f240AmA8tU);
        } catch (Exception e) {
            throw new RuntimeException("Unable to invoke no-args constructor for " + ((Type) this.f241AzWtSf) + ". Register an InstanceCreator with Gson for this type may fix this problem.", e);
        }
    }

    public void AaHO0E(Console console) {
        console.clearCheats();
        Iterator it = ((ArrayList) AZOQYO()).iterator();
        while (it.hasNext()) {
            KpHwm4.ASJ6gh aSJ6gh = (KpHwm4.ASJ6gh) it.next();
            int i = 0;
            while (true) {
                String[] strArr = aSJ6gh.f4292ADYaiT;
                if (i < strArr.length) {
                    console.addCheat(strArr[i], aSJ6gh.f4291A5SV6n, aSJ6gh.f4289A2egSU);
                    i++;
                }
            }
        }
    }

    public Bitmap AcNBzu(BitmapFactory.Options options) {
        switch (this.f238AcNBzu) {
            case 12:
                I3HV03.BPw6Q8 bPw6Q8 = (I3HV03.BPw6Q8) ((NGepWW.A2egSU) this.f239AlLFFp).f5658AlLFFp;
                bPw6Q8.reset();
                return BitmapFactory.decodeStream(bPw6Q8, null, options);
            default:
                return BitmapFactory.decodeFileDescriptor(((com.bumptech.glide.load.data.AzWtSf) this.f241AzWtSf).A2egSU().getFileDescriptor(), null, options);
        }
    }

    public androidx.lifecycle.CikNvS AlLFFp(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return AmA8tU("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName), cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public androidx.lifecycle.CikNvS AmA8tU(String str, Class cls) {
        androidx.lifecycle.CikNvS A4TApA2;
        RXb0Sz.ARc23Z.AMqCpz(str, "key");
        androidx.lifecycle.CtxOCS ctxOCS = (androidx.lifecycle.CtxOCS) this.f239AlLFFp;
        ctxOCS.getClass();
        LinkedHashMap linkedHashMap = ctxOCS.f9039A2egSU;
        androidx.lifecycle.CikNvS cikNvS = (androidx.lifecycle.CikNvS) linkedHashMap.get(str);
        boolean isInstance = cls.isInstance(cikNvS);
        androidx.lifecycle.CqNSpT cqNSpT = (androidx.lifecycle.CqNSpT) this.f240AmA8tU;
        if (isInstance) {
            androidx.lifecycle.CtFAbx ctFAbx = cqNSpT instanceof androidx.lifecycle.CtFAbx ? (androidx.lifecycle.CtFAbx) cqNSpT : null;
            if (ctFAbx != null) {
                RXb0Sz.ARc23Z.A4TApA(cikNvS);
                ctFAbx.A2egSU(cikNvS);
            }
            RXb0Sz.ARc23Z.A5SV6n(cikNvS, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return cikNvS;
        }
        D9tr6l.ADYaiT aDYaiT = new D9tr6l.ADYaiT((D9tr6l.A4TApA) this.f241AzWtSf);
        aDYaiT.f2052A2egSU.put(androidx.lifecycle.CkXcdM.f9034A4TApA, str);
        try {
            A4TApA2 = cqNSpT.AzWtSf(cls, aDYaiT);
        } catch (AbstractMethodError unused) {
            A4TApA2 = cqNSpT.A4TApA(cls);
        }
        RXb0Sz.ARc23Z.AMqCpz(A4TApA2, "viewModel");
        androidx.lifecycle.CikNvS cikNvS2 = (androidx.lifecycle.CikNvS) linkedHashMap.put(str, A4TApA2);
        if (cikNvS2 != null) {
            cikNvS2.A4TApA();
        }
        return A4TApA2;
    }

    public ImageHeaderParser$ImageType AzWtSf() {
        switch (this.f238AcNBzu) {
            case 12:
                I3HV03.BPw6Q8 bPw6Q8 = (I3HV03.BPw6Q8) ((NGepWW.A2egSU) this.f239AlLFFp).f5658AlLFFp;
                bPw6Q8.reset();
                return HSHyT0.AZOQYO.getType((ArrayList) this.f241AzWtSf, bPw6Q8, (HZUvgL.AaHO0E) this.f240AmA8tU);
            default:
                return HSHyT0.AZOQYO.getType((ArrayList) this.f240AmA8tU, (com.bumptech.glide.load.data.AzWtSf) this.f241AzWtSf, (HZUvgL.AaHO0E) this.f239AlLFFp);
        }
    }

    public File B25kr6(Context context) {
        ((Hdahpu.AZOQYO) this.f240AmA8tU).getClass();
        return new File(context.getDir("lib", 0), System.mapLibraryName("pl_droidsonroids_gif"));
    }

    public boolean B3GDIM(int i, BChYOn.ARc23Z aRc23Z, BJ7GGh.AMqCpz aMqCpz) {
        int[] iArr = aRc23Z.f1195Dphsd2;
        int i2 = iArr[0];
        BI9f7h.A4TApA a4TApA = (BI9f7h.A4TApA) this.f240AmA8tU;
        a4TApA.f1276A2egSU = i2;
        a4TApA.f1277A4TApA = iArr[1];
        a4TApA.f1278A5SV6n = aRc23Z.B2KMhB();
        a4TApA.f1279ADYaiT = aRc23Z.AaHO0E();
        a4TApA.f1283AZOQYO = false;
        a4TApA.f1284AZkASS = i;
        boolean z = a4TApA.f1276A2egSU == 3;
        boolean z2 = a4TApA.f1277A4TApA == 3;
        boolean z3 = z && aRc23Z.f1178D07BeM > 0.0f;
        boolean z4 = z2 && aRc23Z.f1178D07BeM > 0.0f;
        int[] iArr2 = aRc23Z.f1150B9tovu;
        if (z3 && iArr2[0] == 4) {
            a4TApA.f1276A2egSU = 1;
        }
        if (z4 && iArr2[1] == 4) {
            a4TApA.f1277A4TApA = 1;
        }
        aMqCpz.A4TApA(aRc23Z, a4TApA);
        aRc23Z.CcAIMM(a4TApA.AMqCpz);
        aRc23Z.CQhlFr(a4TApA.f1280ARc23Z);
        aRc23Z.BpkvW3 = a4TApA.f1282AYUAbz;
        aRc23Z.CASmeH(a4TApA.f1281ASJ6gh);
        a4TApA.f1284AZkASS = 0;
        return a4TApA.f1283AZOQYO;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.AbstractQueue, java.util.concurrent.BlockingQueue] */
    public void B4ZgIw(byte[] bArr) {
        MhxuEA.A5SV6n a5SV6n = (MhxuEA.A5SV6n) ((MOpbMP.A2egSU) this.f241AzWtSf).f4987AmA8tU;
        if (bArr.length == 4) {
            byte b = bArr[0];
            byte[] bArr2 = MhxuEA.A5SV6n.f5353B9tovu;
            if (b == bArr2[0] && bArr[1] == bArr2[1] && bArr[2] == bArr2[2] && bArr[3] == bArr2[3]) {
                a5SV6n.f5367AmA8tU.set(System.currentTimeMillis());
                ((MhxuEA.A5SV6n) ((MOpbMP.A2egSU) this.f241AzWtSf).f4987AmA8tU).f5368AzWtSf.set(0);
                ((MhxuEA.A5SV6n) ((MOpbMP.A2egSU) this.f241AzWtSf).f4987AmA8tU).AMqCpz = 0L;
                ((MhxuEA.A5SV6n) ((MOpbMP.A2egSU) this.f241AzWtSf).f4987AmA8tU).f5369B25kr6.set(false);
                return;
            }
        }
        if (!((AtomicBoolean) this.f239AlLFFp).get()) {
            if (bArr.length >= 2) {
                byte b2 = bArr[0];
                byte[] bArr3 = MhxuEA.A5SV6n.f5351B4ZgIw;
                if (b2 == bArr3[0] && bArr[1] == bArr3[1]) {
                    ((AtomicBoolean) this.f239AlLFFp).set(true);
                    ((CountDownLatch) this.f240AmA8tU).countDown();
                    ((MhxuEA.A5SV6n) ((MOpbMP.A2egSU) this.f241AzWtSf).f4987AmA8tU).f5367AmA8tU.set(System.currentTimeMillis());
                    ((MhxuEA.A5SV6n) ((MOpbMP.A2egSU) this.f241AzWtSf).f4987AmA8tU).AMqCpz = 0L;
                    ((MhxuEA.A5SV6n) ((MOpbMP.A2egSU) this.f241AzWtSf).f4987AmA8tU).f5369B25kr6.set(false);
                    IQ76hF.AmA8tU amA8tU = ((MhxuEA.A5SV6n) ((MOpbMP.A2egSU) this.f241AzWtSf).f4987AmA8tU).f5370B2KMhB;
                    ((KpHwm4.AzWtSf) amA8tU.f3956AlLFFp).f4343B3GDIM = true;
                    ((KpHwm4.AzWtSf) amA8tU.f3956AlLFFp).f4344B4ZgIw = new McNXgv.A5SV6n(new AZkASS.ARc23Z(21, amA8tU));
                    KpHwm4.AzWtSf azWtSf = (KpHwm4.AzWtSf) amA8tU.f3956AlLFFp;
                    azWtSf.f4348BI9f7h.f4352A5SV6n.add(azWtSf.f4344B4ZgIw);
                    int i = Mi9UWv.ASJ6gh.f5402BniPrB;
                    ((KpHwm4.AzWtSf) amA8tU.f3956AlLFFp).f4348BI9f7h.getClass();
                    ByteBuffer putInt = KpHwm4.B25kr6.ARc23Z((short) 1, 10).putInt(i);
                    if (i == 1) {
                        putInt.putShort((short) 0);
                        putInt.putInt(((KpHwm4.AzWtSf) amA8tU.f3956AlLFFp).f4341B25kr6.size());
                    }
                    MhxuEA.A5SV6n a5SV6n2 = ((KpHwm4.AzWtSf) amA8tU.f3956AlLFFp).f4342B2KMhB;
                    byte[] array = putInt.array();
                    Iterator it = a5SV6n2.f5356A4TApA.values().iterator();
                    while (it.hasNext()) {
                        ((MdiDtx.A5SV6n) it.next()).ADYaiT(array);
                    }
                    return;
                }
                return;
            }
            return;
        }
        MhxuEA.A5SV6n a5SV6n3 = (MhxuEA.A5SV6n) ((MOpbMP.A2egSU) this.f241AzWtSf).f4987AmA8tU;
        if (bArr.length == 4) {
            byte b3 = bArr[0];
            byte[] bArr4 = MhxuEA.A5SV6n.f5354BChYOn;
            if (b3 == bArr4[0] && bArr[1] == bArr4[1] && bArr[2] == bArr4[2] && bArr[3] == bArr4[3]) {
                IQ76hF.AmA8tU amA8tU2 = a5SV6n3.f5370B2KMhB;
                ((KpHwm4.AzWtSf) amA8tU2.f3956AlLFFp).f4343B3GDIM = false;
                ((KpHwm4.AzWtSf) amA8tU2.f3956AlLFFp).f4346B9tovu.countDown();
                return;
            }
        }
        a5SV6n3.f5367AmA8tU.set(System.currentTimeMillis());
        ((MhxuEA.A5SV6n) ((MOpbMP.A2egSU) this.f241AzWtSf).f4987AmA8tU).f5368AzWtSf.set(0);
        ((MhxuEA.A5SV6n) ((MOpbMP.A2egSU) this.f241AzWtSf).f4987AmA8tU).AMqCpz = 0L;
        ((MhxuEA.A5SV6n) ((MOpbMP.A2egSU) this.f241AzWtSf).f4987AmA8tU).f5369B25kr6.set(false);
        IQ76hF.AmA8tU amA8tU3 = ((MhxuEA.A5SV6n) ((MOpbMP.A2egSU) this.f241AzWtSf).f4987AmA8tU).f5370B2KMhB;
        amA8tU3.getClass();
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        while (wrap.remaining() >= 4) {
            int i2 = wrap.getInt(wrap.position());
            if (wrap.remaining() < i2 + 4) {
                return;
            }
            wrap.getInt();
            byte[] bArr5 = new byte[i2];
            wrap.get(bArr5);
            ByteBuffer wrap2 = ByteBuffer.wrap(bArr5);
            try {
                McNXgv.A5SV6n a5SV6n4 = ((KpHwm4.AzWtSf) amA8tU3.f3956AlLFFp).f4344B4ZgIw;
                if (a5SV6n4 != null) {
                    a5SV6n4.f5296BIYEnU.put(wrap2);
                }
            } catch (InterruptedException unused) {
            }
        }
    }

    public boolean B7CMnp(Object obj) {
        if (obj instanceof Ixu71n.A4TApA) {
            ((Ixu71n.A4TApA) obj).ADYaiT().f4096A2egSU = true;
        }
        switch (((Hdahpu.AZOQYO) this.f240AmA8tU).f3699AcNBzu) {
            case 20:
                break;
            default:
                ((List) obj).clear();
                break;
        }
        return ((CNPG0E.A5SV6n) this.f241AzWtSf).A5SV6n(obj);
    }

    public void B9tovu(BChYOn.ASJ6gh aSJ6gh, int i, int i2, int i3) {
        int i4 = aSJ6gh.f1183D9tr6l;
        int i5 = aSJ6gh.f1184DAk1zC;
        aSJ6gh.f1183D9tr6l = 0;
        aSJ6gh.f1184DAk1zC = 0;
        aSJ6gh.CcAIMM(i2);
        aSJ6gh.CQhlFr(i3);
        if (i4 < 0) {
            aSJ6gh.f1183D9tr6l = 0;
        } else {
            aSJ6gh.f1183D9tr6l = i4;
        }
        if (i5 < 0) {
            aSJ6gh.f1184DAk1zC = 0;
        } else {
            aSJ6gh.f1184DAk1zC = i5;
        }
        BChYOn.ASJ6gh aSJ6gh2 = (BChYOn.ASJ6gh) this.f241AzWtSf;
        aSJ6gh2.f1198ECyGFg = i;
        aSJ6gh2.CkXcdM();
    }

    public void BChYOn(boolean z) {
        Ogw3zR.A5SV6n a5SV6n = (Ogw3zR.A5SV6n) this.f239AlLFFp;
        if (a5SV6n != null) {
            a5SV6n.A4TApA((Ogw3zR.A4TApA) this.f240AmA8tU, (View) this.f241AzWtSf, z);
        }
    }

    public void BIYEnU() {
        Ogw3zR.A5SV6n a5SV6n = (Ogw3zR.A5SV6n) this.f239AlLFFp;
        if (a5SV6n != null) {
            a5SV6n.A5SV6n((View) this.f241AzWtSf);
        }
    }

    public void BJ7GGh(BChYOn.ASJ6gh aSJ6gh) {
        ArrayList arrayList = (ArrayList) this.f239AlLFFp;
        arrayList.clear();
        int size = aSJ6gh.f1275DuwtYk.size();
        for (int i = 0; i < size; i++) {
            BChYOn.ARc23Z aRc23Z = (BChYOn.ARc23Z) aSJ6gh.f1275DuwtYk.get(i);
            int[] iArr = aRc23Z.f1195Dphsd2;
            if (iArr[0] == 3 || iArr[1] == 3) {
                arrayList.add(aRc23Z);
            }
        }
        aSJ6gh.f1197DyaChj.f1288A4TApA = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Map BNL6CD() {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f239AlLFFp
            android.content.Context r0 = (android.content.Context) r0
            java.lang.Object r1 = r9.f240AmA8tU
            JrXYwF.AMqCpz r1 = (JrXYwF.AMqCpz) r1
            java.util.Map r1 = r1.xj()
            if (r1 != 0) goto L14
            java.util.HashMap r1 = new java.util.HashMap
            r2 = 4
            r1.<init>(r2)
        L14:
            boolean r2 = r1.isEmpty()
            java.lang.String r3 = "version_name"
            java.lang.String r4 = "update_version_code"
            java.lang.String r5 = "version_code"
            if (r2 != 0) goto L3c
            java.lang.String r2 = "app_version"
            boolean r2 = r1.containsKey(r2)
            if (r2 != 0) goto L2e
            boolean r2 = r1.containsKey(r3)
            if (r2 == 0) goto L3c
        L2e:
            boolean r2 = r1.containsKey(r5)
            if (r2 == 0) goto L3c
            boolean r2 = r1.containsKey(r4)
            if (r2 != 0) goto L3b
            goto L3c
        L3b:
            return r1
        L3c:
            r2 = 0
            android.content.pm.PackageManager r6 = r0.getPackageManager()     // Catch: java.lang.Throwable -> L6c
            java.lang.String r7 = r0.getPackageName()     // Catch: java.lang.Throwable -> L6c
            r8 = 128(0x80, float:1.794E-43)
            android.content.pm.PackageInfo r6 = r6.getPackageInfo(r7, r8)     // Catch: java.lang.Throwable -> L6c
            java.lang.String r7 = r6.versionName     // Catch: java.lang.Throwable -> L6c
            r1.put(r3, r7)     // Catch: java.lang.Throwable -> L6c
            int r7 = r6.versionCode     // Catch: java.lang.Throwable -> L6c
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L6c
            r1.put(r5, r7)     // Catch: java.lang.Throwable -> L6c
            java.lang.Object r7 = r1.get(r4)     // Catch: java.lang.Throwable -> L6c
            if (r7 != 0) goto Ld5
            android.content.pm.ApplicationInfo r6 = r6.applicationInfo     // Catch: java.lang.Throwable -> L6c
            android.os.Bundle r6 = r6.metaData     // Catch: java.lang.Throwable -> L6c
            if (r6 == 0) goto L6e
            java.lang.String r7 = "UPDATE_VERSION_CODE"
            java.lang.Object r6 = r6.get(r7)     // Catch: java.lang.Throwable -> L6c
            goto L6f
        L6c:
            goto L79
        L6e:
            r6 = r2
        L6f:
            if (r6 != 0) goto L75
            java.lang.Object r6 = r1.get(r5)     // Catch: java.lang.Throwable -> L6c
        L75:
            r1.put(r4, r6)     // Catch: java.lang.Throwable -> L6c
            return r1
        L79:
            java.lang.Class r6 = com.bumptech.glide.A5SV6n.AlLFFp(r0)
            java.lang.reflect.Field r7 = com.bumptech.glide.A5SV6n.f9897B25kr6
            if (r7 != 0) goto L8d
            if (r6 == 0) goto L8d
            java.lang.String r7 = "VERSION_NAME"
            java.lang.reflect.Field r6 = r6.getDeclaredField(r7)     // Catch: java.lang.NoSuchFieldException -> L8c
            com.bumptech.glide.A5SV6n.f9897B25kr6 = r6     // Catch: java.lang.NoSuchFieldException -> L8c
            goto L8d
        L8c:
        L8d:
            java.lang.reflect.Field r6 = com.bumptech.glide.A5SV6n.f9897B25kr6
            if (r6 == 0) goto L98
            java.lang.Object r6 = r6.get(r2)     // Catch: java.lang.Throwable -> L98
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L98
            goto L9a
        L98:
            java.lang.String r6 = ""
        L9a:
            r1.put(r3, r6)
            java.lang.Class r0 = com.bumptech.glide.A5SV6n.AlLFFp(r0)
            java.lang.reflect.Field r3 = com.bumptech.glide.A5SV6n.f9898B2KMhB
            if (r3 != 0) goto Lb1
            if (r0 == 0) goto Lb1
            java.lang.String r3 = "VERSION_CODE"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r3)     // Catch: java.lang.NoSuchFieldException -> Lb0
            com.bumptech.glide.A5SV6n.f9898B2KMhB = r0     // Catch: java.lang.NoSuchFieldException -> Lb0
            goto Lb1
        Lb0:
        Lb1:
            java.lang.reflect.Field r0 = com.bumptech.glide.A5SV6n.f9898B2KMhB
            if (r0 == 0) goto Lc0
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> Lc0
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> Lc0
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> Lc0
            goto Lc1
        Lc0:
            r0 = -1
        Lc1:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.put(r5, r0)
            java.lang.Object r0 = r1.get(r4)
            if (r0 != 0) goto Ld5
            java.lang.Object r0 = r1.get(r5)
            r1.put(r4, r0)
        Ld5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ADYaiT.DUi7mC.BNL6CD():java.util.Map");
    }

    @Override // GnQT2j.AlLFFp
    public void a(int i, int i2) {
        Handler handler = (Handler) this.f239AlLFFp;
        if (handler != null) {
            int i3 = (int) ((i2 * 100.0f) / i);
            if (i2 == i) {
                i3 = 100;
            }
            Message message = new Message();
            message.what = i3;
            handler.sendMessage(message);
        }
    }

    @Override // Cd8JRx.AYUAbz
    public ClipDescription getDescription() {
        return (ClipDescription) this.f240AmA8tU;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        switch (this.f238AcNBzu) {
            case 4:
                int[] iArr = (int[]) this.f239AlLFFp;
                int i = iArr[0];
                if (i >= 1) {
                    ((KCxDWD.A5SV6n) this.f240AmA8tU).getClass();
                    if ((iOException instanceof SocketTimeoutException) || (iOException instanceof ConnectTimeoutException)) {
                        new EY4UKY.ADYaiT().AZOQYO(1, 3, null, null, 0);
                    } else {
                        new EY4UKY.ADYaiT().AZOQYO(1, 2, null, null, 200);
                    }
                    iOException.getMessage();
                    int i2 = GJee0v.AZOQYO.f3039AcNBzu;
                    break;
                } else {
                    iArr[0] = i + 1;
                    call.clone().enqueue(this);
                    break;
                }
                break;
            default:
                ((GJee0v.ASJ6gh) this.f240AmA8tU).a(iOException);
                break;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:3|4|5|(12:9|(1:11)|12|(1:14)|15|(1:17)|18|19|20|22|23|(3:24|25|(1:27)(7:28|29|30|31|32|33|34)))|87|(0)|12|(0)|15|(0)|18|19|20|22|23|(4:24|25|(0)(0)|27)) */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00bb, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00c2, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00b7, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00b8, code lost:
    
        r8 = null;
        r3 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00b1, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00d9, code lost:
    
        r0.toString();
        r0 = GJee0v.AZOQYO.f3039AcNBzu;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00c0, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00c1, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00bd, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00be, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0092 A[Catch: all -> 0x0099, Exception -> 0x009b, LOOP:0: B:24:0x008b->B:27:0x0092, LOOP_END, TryCatch #13 {Exception -> 0x009b, all -> 0x0099, blocks: (B:25:0x008b, B:27:0x0092, B:29:0x009d), top: B:24:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d5 A[Catch: IOException -> 0x00b1, TRY_ENTER, TRY_LEAVE, TryCatch #2 {IOException -> 0x00b1, blocks: (B:32:0x00ad, B:48:0x00d5), top: B:19:0x0077 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x00d9 -> B:32:0x00de). Please report as a decompilation issue!!! */
    @Override // okhttp3.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onResponse(okhttp3.Call r17, okhttp3.Response r18) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ADYaiT.DUi7mC.onResponse(okhttp3.Call, okhttp3.Response):void");
    }

    public /* synthetic */ DUi7mC(int i, Object obj, Object obj2, Object obj3) {
        this.f238AcNBzu = i;
        this.f239AlLFFp = obj;
        this.f240AmA8tU = obj2;
        this.f241AzWtSf = obj3;
    }

    public /* synthetic */ DUi7mC(Object obj, Object obj2, Object obj3, int i, boolean z) {
        this.f238AcNBzu = i;
        this.f241AzWtSf = obj;
        this.f239AlLFFp = obj2;
        this.f240AmA8tU = obj3;
    }

    public DUi7mC(GJee0v.ASJ6gh aSJ6gh, Context context, String str) {
        this.f238AcNBzu = 6;
        this.f240AmA8tU = aSJ6gh;
        this.f239AlLFFp = context;
        this.f241AzWtSf = str;
    }

    public DUi7mC(Context context) {
        this.f238AcNBzu = 5;
        this.f239AlLFFp = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f240AmA8tU = cls;
            this.f241AzWtSf = cls.newInstance();
        } catch (Exception unused) {
        }
    }

    @Override // EmJGcg.A2egSU
    /* renamed from: a, reason: collision with other method in class */
    public boolean mo0a() {
        return this.f241AzWtSf != null;
    }

    @Override // GYpKKt.A2egSU
    public void a(int i, String str) {
        int i2 = GJee0v.AZOQYO.f3039AcNBzu;
        EY4UKY.ADYaiT aDYaiT = new EY4UKY.ADYaiT();
        H0qugq.AZOQYO azoqyo = (H0qugq.AZOQYO) this.f241AzWtSf;
        aDYaiT.AzWtSf((String) this.f239AlLFFp, (String) this.f240AmA8tU, false, azoqyo.f3187AYUAbz, azoqyo.f3200B9tovu);
    }

    public DUi7mC(String str) {
        this.f238AcNBzu = 17;
        this.f239AlLFFp = new ArrayList();
        this.f241AzWtSf = new File(KpHwm4.AYUAbz.A2egSU("cheat"), CtFAbx.AcNBzu(str, ".cht"));
    }

    @Override // GnQT2j.AlLFFp
    public void a() {
        switch (this.f238AcNBzu) {
            case 8:
                Message message = new Message();
                message.what = -100;
                ((Handler) this.f239AlLFFp).sendMessage(message);
                if (H0qugq.AZOQYO.f3180EY4UKY) {
                    H0qugq.AZOQYO.f3180EY4UKY = false;
                    break;
                } else {
                    int i = GJee0v.AZOQYO.f3039AcNBzu;
                    ((H0qugq.AZOQYO) this.f241AzWtSf).BpkvW3((SAAllianceAdData) this.f240AmA8tU);
                    break;
                }
            default:
                ArrayList arrayList = (ArrayList) this.f239AlLFFp;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Console) it.next()).clearCheats();
                }
                arrayList.clear();
                break;
        }
    }

    public DUi7mC(HZUvgL.AaHO0E aaHO0E, InputStream inputStream, ArrayList arrayList) {
        this.f238AcNBzu = 12;
        ItGa5w.ARc23Z.A5SV6n(aaHO0E, "Argument must not be null");
        this.f240AmA8tU = aaHO0E;
        ItGa5w.ARc23Z.A5SV6n(arrayList, "Argument must not be null");
        this.f241AzWtSf = arrayList;
        this.f239AlLFFp = new NGepWW.A2egSU(inputStream, aaHO0E);
    }

    public DUi7mC(androidx.lifecycle.CtxOCS ctxOCS, androidx.lifecycle.CqNSpT cqNSpT, D9tr6l.A4TApA a4TApA) {
        this.f238AcNBzu = 24;
        RXb0Sz.ARc23Z.AMqCpz(ctxOCS, "store");
        RXb0Sz.ARc23Z.AMqCpz(cqNSpT, "factory");
        RXb0Sz.ARc23Z.AMqCpz(a4TApA, "defaultCreationExtras");
        this.f239AlLFFp = ctxOCS;
        this.f240AmA8tU = cqNSpT;
        this.f241AzWtSf = a4TApA;
    }

    public DUi7mC() {
        this.f238AcNBzu = 21;
        Hdahpu.AZOQYO azoqyo = new Hdahpu.AZOQYO(28);
        Mxl9NN.A2egSU a2egSU = new Mxl9NN.A2egSU();
        this.f239AlLFFp = new HashSet();
        this.f240AmA8tU = azoqyo;
        this.f241AzWtSf = a2egSU;
    }

    public DUi7mC(Ogw3zR.A4TApA a4TApA, View view) {
        Object a5SV6n;
        this.f238AcNBzu = 22;
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            a5SV6n = new Ogw3zR.AMqCpz();
        } else {
            a5SV6n = i >= 33 ? new Ogw3zR.A5SV6n() : null;
        }
        this.f239AlLFFp = a5SV6n;
        this.f240AmA8tU = a4TApA;
        this.f241AzWtSf = view;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DUi7mC(androidx.lifecycle.CtxOCS ctxOCS, androidx.lifecycle.CqNSpT cqNSpT) {
        this(ctxOCS, cqNSpT, D9tr6l.A2egSU.f2051A4TApA);
        this.f238AcNBzu = 24;
        RXb0Sz.ARc23Z.AMqCpz(ctxOCS, "store");
    }

    public DUi7mC(Context context, LocationManager locationManager) {
        this.f238AcNBzu = 0;
        this.f241AzWtSf = new DRlcZ9();
        this.f239AlLFFp = context;
        this.f240AmA8tU = locationManager;
    }

    public DUi7mC(BChYOn.ASJ6gh aSJ6gh) {
        this.f238AcNBzu = 2;
        this.f239AlLFFp = new ArrayList();
        this.f240AmA8tU = new BI9f7h.A4TApA();
        this.f241AzWtSf = aSJ6gh;
    }

    public DUi7mC(ParcelFileDescriptor parcelFileDescriptor, ArrayList arrayList, HZUvgL.AaHO0E aaHO0E) {
        this.f238AcNBzu = 13;
        ItGa5w.ARc23Z.A5SV6n(aaHO0E, "Argument must not be null");
        this.f239AlLFFp = aaHO0E;
        ItGa5w.ARc23Z.A5SV6n(arrayList, "Argument must not be null");
        this.f240AmA8tU = arrayList;
        this.f241AzWtSf = new com.bumptech.glide.load.data.AzWtSf(parcelFileDescriptor);
    }

    public DUi7mC(FragmentActivity fragmentActivity, View view) {
        this.f238AcNBzu = 1;
        AZkASS.AmA8tU amA8tU = new AZkASS.AmA8tU(fragmentActivity);
        this.f239AlLFFp = amA8tU;
        amA8tU.f497B25kr6 = new KCxDWD.A5SV6n(5, this);
        AZkASS.BIYEnU bIYEnU = new AZkASS.BIYEnU(2130969745, amA8tU, fragmentActivity, view, false);
        this.f240AmA8tU = bIYEnU;
        bIYEnU.f565ARc23Z = 0;
        bIYEnU.f569AZkASS = new AZkASS.BI9f7h(1, this);
    }

    public DUi7mC(MOpbMP.A2egSU a2egSU, int i, AtomicBoolean atomicBoolean, CountDownLatch countDownLatch) {
        this.f238AcNBzu = 19;
        this.f241AzWtSf = a2egSU;
        this.f239AlLFFp = atomicBoolean;
        this.f240AmA8tU = countDownLatch;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DUi7mC(FragmentActivity fragmentActivity) {
        this(fragmentActivity.getViewModelStore(), fragmentActivity.getDefaultViewModelProviderFactory(), fragmentActivity.getDefaultViewModelCreationExtras());
        this.f238AcNBzu = 24;
        RXb0Sz.ARc23Z.AMqCpz(fragmentActivity, "owner");
    }

    public DUi7mC(Class cls, Type type) {
        Object b7CMnp;
        this.f238AcNBzu = 25;
        this.f240AmA8tU = cls;
        this.f241AzWtSf = type;
        try {
            try {
                try {
                    Class<?> cls2 = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls2.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    b7CMnp = new com.google.gson.internal.B2KMhB(declaredField.get(null), cls2.getMethod("allocateInstance", Class.class));
                } catch (Exception unused) {
                    b7CMnp = new com.google.gson.internal.B7CMnp();
                }
            } catch (Exception unused2) {
                Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod.setAccessible(true);
                b7CMnp = new com.google.gson.internal.B4ZgIw(declaredMethod);
            }
        } catch (Exception unused3) {
            Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
            declaredMethod2.setAccessible(true);
            int intValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
            Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
            declaredMethod3.setAccessible(true);
            b7CMnp = new com.google.gson.internal.B3GDIM(intValue, declaredMethod3);
        }
        this.f239AlLFFp = b7CMnp;
    }

    public DUi7mC(HXc4pW.AzWtSf azWtSf, IhMMDv.ASJ6gh aSJ6gh, HXc4pW.B4ZgIw b4ZgIw) {
        this.f238AcNBzu = 11;
        this.f241AzWtSf = azWtSf;
        this.f240AmA8tU = aSJ6gh;
        this.f239AlLFFp = b4ZgIw;
    }
}
