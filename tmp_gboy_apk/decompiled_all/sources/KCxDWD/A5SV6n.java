package KCxDWD;

import ADYaiT.CQhlFr;
import ADYaiT.DAk1zC;
import ADYaiT.DUi7mC;
import AZkASS.ARc23Z;
import AZkASS.AcNBzu;
import AZkASS.AmA8tU;
import AaHO0E.HHoABE;
import COJEAR.AMqCpz;
import COJEAR.AYUAbz;
import COJEAR.BpkvW3;
import COJEAR.CASmeH;
import CQhlFr.B7CMnp;
import Cd8JRx.ASJ6gh;
import EsrwYR.ADYaiT;
import Fyurov.AZkASS;
import GJee0v.AZOQYO;
import GnQT2j.AaHO0E;
import HXc4pW.AzWtSf;
import HXc4pW.B4ZgIw;
import Hjvs0g.BI9f7h;
import Hjvs0g.BIYEnU;
import Hjvs0g.BmvVmW;
import Hjvs0g.CSDoyG;
import Hjvs0g.CTkVKb;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.view.ContentInfo;
import android.view.View;
import android.view.WindowInsetsController;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.CmUvjW;
import androidx.profileinstaller.ProfileInstallReceiver;
import androidx.viewpager2.widget.ViewPager2;
import com.alliance.ssp.ad.activity.NMRewardVideoActivity;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n implements AcNBzu, AMqCpz, B7CMnp, DUi7mC.AMqCpz, GnQT2j.AMqCpz, AaHO0E, ADYaiT, AZkASS, Ixu71n.A2egSU, BIYEnU, Hjvs0g.A2egSU, HSHyT0.A4TApA, CSDoyG {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public static volatile A5SV6n f4239AmA8tU;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4240AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Object f4241AlLFFp;

    public /* synthetic */ A5SV6n(int i, Object obj) {
        this.f4240AcNBzu = i;
        this.f4241AlLFFp = obj;
    }

    private final void B2KMhB(AmA8tU amA8tU) {
    }

    @Override // GnQT2j.AMqCpz
    public void A2egSU() {
        EY4UKY.ADYaiT aDYaiT = new EY4UKY.ADYaiT();
        SAAllianceAdData sAAllianceAdData = ((DjONCG.A4TApA) this.f4241AlLFFp).f2423A4TApA;
        aDYaiT.B3GDIM(5, 1, sAAllianceAdData, sAAllianceAdData.getCrequestid(), "");
    }

    @Override // DUi7mC.AMqCpz
    public void A5SV6n(int i, Serializable serializable) {
        if (i == 6 || i == 7 || i == 8) {
        }
        ((ProfileInstallReceiver) this.f4241AlLFFp).setResultCode(i);
    }

    @Override // CQhlFr.B7CMnp
    public boolean ADYaiT(View view) {
        switch (this.f4240AcNBzu) {
            case 11:
                DrawerLayout drawerLayout = (DrawerLayout) this.f4241AlLFFp;
                if (DrawerLayout.AcNBzu(view) && drawerLayout.AYUAbz(view) != 2) {
                    drawerLayout.A5SV6n(view, true);
                    break;
                }
                break;
            default:
                int currentItem = ((ViewPager2) view).getCurrentItem() + 1;
                ViewPager2 viewPager2 = ((De4eam.AZkASS) this.f4241AlLFFp).f2413ADYaiT;
                if (viewPager2.f9602BV3sI0) {
                    viewPager2.A5SV6n(currentItem, true);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // COJEAR.AMqCpz
    public void AMqCpz(Uri uri) {
        ((ContentInfo.Builder) this.f4241AlLFFp).setLinkUri(uri);
    }

    @Override // Ixu71n.A2egSU
    public Object ARc23Z() {
        HHoABE hHoABE = (HHoABE) this.f4241AlLFFp;
        return new B4ZgIw((HieBYM.A5SV6n) hHoABE.f926A2egSU, (HieBYM.A5SV6n) hHoABE.f927A4TApA, (HieBYM.A5SV6n) hHoABE.f928A5SV6n, (HieBYM.A5SV6n) hHoABE.f929ADYaiT, (AzWtSf) hHoABE.AMqCpz, (AzWtSf) hHoABE.f930ARc23Z, (DUi7mC) hHoABE.f931ASJ6gh);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    @Override // HSHyT0.A4TApA
    public boolean ASJ6gh(Object obj, File file, HSHyT0.AmA8tU amA8tU) {
        InputStream inputStream = (InputStream) obj;
        HZUvgL.AaHO0E aaHO0E = (HZUvgL.AaHO0E) this.f4241AlLFFp;
        byte[] bArr = (byte[]) aaHO0E.ADYaiT(65536, byte[].class);
        boolean z = false;
        ?? r2 = 0;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        r2 = -1;
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    } catch (IOException unused) {
                        fileOutputStream = fileOutputStream2;
                        Log.isLoggable("StreamEncoder", 3);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        aaHO0E.AYUAbz(bArr);
                        r2 = fileOutputStream;
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        r2 = fileOutputStream2;
                        if (r2 != 0) {
                            try {
                                r2.close();
                            } catch (IOException unused3) {
                            }
                        }
                        aaHO0E.AYUAbz(bArr);
                        throw th;
                    }
                }
                fileOutputStream2.close();
                try {
                    fileOutputStream2.close();
                } catch (IOException unused4) {
                }
                aaHO0E.AYUAbz(bArr);
                z = true;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused5) {
        }
        return z;
    }

    @Override // Hjvs0g.BIYEnU
    public BI9f7h AYUAbz(BmvVmW bmvVmW) {
        switch (this.f4240AcNBzu) {
            case 27:
                return new Hjvs0g.A4TApA((AssetManager) this.f4241AlLFFp, 0, this);
            default:
                return new CTkVKb(this);
        }
    }

    @Override // COJEAR.AMqCpz
    public void AZOQYO(int i) {
        ((ContentInfo.Builder) this.f4241AlLFFp).setFlags(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x024e, code lost:
    
        r10 = r10.getIntent();
     */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01ad A[Catch: Exception -> 0x01f4, TryCatch #1 {Exception -> 0x01f4, blocks: (B:52:0x0167, B:57:0x0196, B:60:0x01ad, B:62:0x01b7, B:65:0x01c2, B:66:0x01df, B:68:0x01e7, B:72:0x01f0, B:74:0x0186, B:75:0x018b, B:77:0x018f, B:79:0x0193), top: B:51:0x0167 }] */
    @Override // AZkASS.AcNBzu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean AZkASS(AZkASS.AmA8tU r13, android.view.MenuItem r14) {
        /*
            Method dump skipped, instructions count: 962
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: KCxDWD.A5SV6n.AZkASS(AZkASS.AmA8tU, android.view.MenuItem):boolean");
    }

    @Override // Hjvs0g.CSDoyG
    public com.bumptech.glide.load.data.AMqCpz AaHO0E(Uri uri) {
        return new com.bumptech.glide.load.data.A2egSU((ContentResolver) this.f4241AlLFFp, uri, 1);
    }

    @Override // AZkASS.AcNBzu
    public void AcNBzu(AmA8tU amA8tU) {
        switch (this.f4240AcNBzu) {
            case 1:
                DAk1zC dAk1zC = (DAk1zC) this.f4241AlLFFp;
                boolean B25kr62 = dAk1zC.f224A2egSU.f898A2egSU.B25kr6();
                CQhlFr cQhlFr = dAk1zC.f225A4TApA;
                if (!B25kr62) {
                    if (cQhlFr.onPreparePanel(0, null, amA8tU)) {
                        cQhlFr.onMenuOpened(108, amA8tU);
                        break;
                    }
                } else {
                    cQhlFr.onPanelClosed(108, amA8tU);
                    break;
                }
                break;
            case 2:
            case 3:
            default:
                Toolbar toolbar = (Toolbar) this.f4241AlLFFp;
                AaHO0E.AzWtSf azWtSf = toolbar.f8219AcNBzu.f8140BniPrB;
                if (azWtSf == null || !azWtSf.AlLFFp()) {
                    Iterator it = toolbar.f8250CkXcdM.f1642A4TApA.iterator();
                    while (it.hasNext()) {
                        ((CmUvjW) ((COJEAR.B7CMnp) it.next())).f8826A2egSU.B4ZgIw(amA8tU);
                    }
                }
                A5SV6n a5SV6n = toolbar.f8258D6yqiO;
                if (a5SV6n != null) {
                    a5SV6n.AcNBzu(amA8tU);
                    break;
                }
                break;
            case 4:
                AcNBzu acNBzu = ((ActionMenuView) this.f4241AlLFFp).f8141C2rE4F;
                if (acNBzu != null) {
                    acNBzu.AcNBzu(amA8tU);
                    break;
                }
                break;
            case 5:
                break;
        }
    }

    public void AlLFFp(String str) {
        FZu94u.A4TApA a4TApA = (FZu94u.A4TApA) this.f4241AlLFFp;
        a4TApA.getClass();
        new EY4UKY.ADYaiT().B3GDIM(3, 3, a4TApA.f3187AYUAbz, a4TApA.f3200B9tovu, "");
        a4TApA.De4eam(5, FZu94u.A4TApA.Ddcejp(a4TApA, str), null);
    }

    @Override // Hjvs0g.A2egSU
    public com.bumptech.glide.load.data.AMqCpz AmA8tU(AssetManager assetManager, String str) {
        return new com.bumptech.glide.load.data.AaHO0E(assetManager, str, 0);
    }

    public Hdahpu.A5SV6n AzWtSf() {
        Hdahpu.A5SV6n a5SV6n;
        synchronized (((ArrayDeque) this.f4241AlLFFp)) {
            a5SV6n = (Hdahpu.A5SV6n) ((ArrayDeque) this.f4241AlLFFp).poll();
        }
        return a5SV6n == null ? new Hdahpu.A5SV6n() : a5SV6n;
    }

    public void B25kr6(Hdahpu.A5SV6n a5SV6n) {
        synchronized (((ArrayDeque) this.f4241AlLFFp)) {
            if (((ArrayDeque) this.f4241AlLFFp).size() < 10) {
                ((ArrayDeque) this.f4241AlLFFp).offer(a5SV6n);
            }
        }
    }

    @Override // EsrwYR.ADYaiT
    public String a(IBinder iBinder) {
        EdhSi6.A5SV6n a5SV6n;
        Object obj = this.f4241AlLFFp;
        switch (this.f4240AcNBzu) {
            case 18:
                int i = EdhSi6.A4TApA.f2542A2egSU;
                if (iBinder == null) {
                    a5SV6n = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (queryLocalInterface == null || !(queryLocalInterface instanceof EdhSi6.A5SV6n)) {
                        EdhSi6.A2egSU a2egSU = new EdhSi6.A2egSU();
                        a2egSU.f2541A2egSU = iBinder;
                        a5SV6n = a2egSU;
                    } else {
                        a5SV6n = (EdhSi6.A5SV6n) queryLocalInterface;
                    }
                }
                if (a5SV6n == null) {
                    throw new GL2Jh7.A2egSU("IDeviceIdManager is null");
                }
                String packageName = ((NOd7IU.AmA8tU) obj).f5913AlLFFp.getPackageName();
                EdhSi6.A2egSU a2egSU2 = (EdhSi6.A2egSU) a5SV6n;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(packageName);
                    a2egSU2.f2541A2egSU.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            default:
                try {
                    return ((EsrwYR.A5SV6n) obj).A2egSU(iBinder);
                } catch (GL2Jh7.A2egSU e) {
                    throw e;
                } catch (RemoteException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new GL2Jh7.A2egSU(e3);
                }
        }
    }

    @Override // GnQT2j.AMqCpz
    public void b() {
        EY4UKY.ADYaiT aDYaiT = new EY4UKY.ADYaiT();
        SAAllianceAdData sAAllianceAdData = ((DjONCG.A4TApA) this.f4241AlLFFp).f2423A4TApA;
        aDYaiT.B3GDIM(5, 0, sAAllianceAdData, sAAllianceAdData.getCrequestid(), "");
    }

    @Override // COJEAR.AMqCpz
    public AYUAbz build() {
        ContentInfo build;
        build = ((ContentInfo.Builder) this.f4241AlLFFp).build();
        return new AYUAbz(new ARc23Z(build));
    }

    @Override // GnQT2j.AMqCpz
    public void c() {
        EY4UKY.ADYaiT aDYaiT = new EY4UKY.ADYaiT();
        SAAllianceAdData sAAllianceAdData = ((DjONCG.A4TApA) this.f4241AlLFFp).f2423A4TApA;
        aDYaiT.B3GDIM(5, 0, sAAllianceAdData, sAAllianceAdData.getCrequestid(), "");
    }

    @Override // COJEAR.AMqCpz
    public void setExtras(Bundle bundle) {
        ((ContentInfo.Builder) this.f4241AlLFFp).setExtras(bundle);
    }

    public A5SV6n(Context context, int i) {
        this.f4240AcNBzu = i;
        switch (i) {
            case 26:
                this.f4241AlLFFp = new NOd7IU.AmA8tU(context, 7, false);
                break;
            default:
                this.f4241AlLFFp = new A4TApA(context);
                break;
        }
    }

    @Override // Fyurov.AZkASS
    public void b(View view) {
        ((TextView) view).setHighlightColor(0);
        FSFw2u.AZkASS aZkASS = (FSFw2u.AZkASS) this.f4241AlLFFp;
        FSFw2u.AZkASS.ECyGFg(aZkASS, aZkASS.f2718GJee0v.getPrivacyUrl());
        int i = AZOQYO.f3039AcNBzu;
    }

    @Override // Fyurov.AZkASS
    public void c(View view) {
        ((TextView) view).setHighlightColor(0);
        FSFw2u.AZkASS aZkASS = (FSFw2u.AZkASS) this.f4241AlLFFp;
        FSFw2u.AZkASS.ECyGFg(aZkASS, aZkASS.f2718GJee0v.getAppIntro());
        int i = AZOQYO.f3039AcNBzu;
    }

    public A5SV6n(View view) {
        this.f4240AcNBzu = 9;
        if (Build.VERSION.SDK_INT >= 30) {
            CASmeH cASmeH = new CASmeH(view);
            cASmeH.f1658A4TApA = view;
            this.f4241AlLFFp = cASmeH;
            return;
        }
        this.f4241AlLFFp = new BpkvW3(view);
    }

    public A5SV6n(WindowInsetsController windowInsetsController) {
        this.f4240AcNBzu = 9;
        CASmeH cASmeH = new CASmeH(null);
        cASmeH.f1659A5SV6n = windowInsetsController;
        this.f4241AlLFFp = cASmeH;
    }

    public A5SV6n() {
        this.f4240AcNBzu = 25;
        this.f4241AlLFFp = new ArrayDeque();
    }

    public A5SV6n(EditText editText) {
        this.f4240AcNBzu = 12;
        this.f4241AlLFFp = new K1Z3yj.A2egSU(editText);
    }

    public A5SV6n(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f4240AcNBzu = 10;
        if (Build.VERSION.SDK_INT >= 25) {
            this.f4241AlLFFp = new ASJ6gh(uri, clipDescription, uri2);
        } else {
            this.f4241AlLFFp = new DUi7mC(3, uri, clipDescription, uri2);
        }
    }

    public A5SV6n(ClipData clipData, int i) {
        this.f4240AcNBzu = 7;
        this.f4241AlLFFp = COJEAR.ADYaiT.AMqCpz(clipData, i);
    }

    @Override // Fyurov.AZkASS
    public void a(View view) {
        ((TextView) view).setHighlightColor(0);
        FSFw2u.AZkASS aZkASS = (FSFw2u.AZkASS) this.f4241AlLFFp;
        FSFw2u.AZkASS.ECyGFg(aZkASS, aZkASS.f2718GJee0v.getPermissionUrl());
        int i = AZOQYO.f3039AcNBzu;
    }

    @Override // GnQT2j.AaHO0E
    public void a(Bitmap bitmap) {
        NMRewardVideoActivity nMRewardVideoActivity = (NMRewardVideoActivity) this.f4241AlLFFp;
        ImageView imageView = nMRewardVideoActivity.f9671DyaChj;
        if (imageView != null) {
            imageView.setImageBitmap(NMRewardVideoActivity.A2egSU(bitmap));
            nMRewardVideoActivity.f9673EGM26s.setImageBitmap(NMRewardVideoActivity.A2egSU(bitmap));
            nMRewardVideoActivity.f9672ECyGFg.setImageBitmap(NMRewardVideoActivity.A2egSU(bitmap));
        }
    }

    @Override // GnQT2j.AMqCpz
    public void a() {
        switch (this.f4240AcNBzu) {
            case 15:
                EY4UKY.ADYaiT aDYaiT = new EY4UKY.ADYaiT();
                SAAllianceAdData sAAllianceAdData = ((DjONCG.A4TApA) this.f4241AlLFFp).f2423A4TApA;
                aDYaiT.B3GDIM(5, 2, sAAllianceAdData, sAAllianceAdData.getCrequestid(), "");
                break;
            default:
                FZu94u.A4TApA a4TApA = (FZu94u.A4TApA) this.f4241AlLFFp;
                a4TApA.getClass();
                new EY4UKY.ADYaiT().B3GDIM(3, 4, a4TApA.f3187AYUAbz, a4TApA.f3200B9tovu, "");
                a4TApA.De4eam(5, FZu94u.A4TApA.Ddcejp(a4TApA, null), null);
                break;
        }
    }

    @Override // GnQT2j.AMqCpz, GnQT2j.AaHO0E
    public void a(Exception exc) {
        switch (this.f4240AcNBzu) {
            case 15:
                exc.getMessage();
                int i = AZOQYO.f3039AcNBzu;
                break;
            default:
                int i2 = AZOQYO.f3039AcNBzu;
                break;
        }
    }
}
