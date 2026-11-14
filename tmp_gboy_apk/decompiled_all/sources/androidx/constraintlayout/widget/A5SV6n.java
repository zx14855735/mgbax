package androidx.constraintlayout.widget;

import ADYaiT.CtFAbx;
import BJ7GGh.AZOQYO;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.adevent.AdEventType;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A5SV6n {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final int[] f8295ADYaiT = {0, 4, 8};
    public static final SparseIntArray AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final SparseIntArray f8296ARc23Z;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final HashMap f8297A2egSU = new HashMap();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final boolean f8298A4TApA = true;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final HashMap f8299A5SV6n = new HashMap();

    public static class A2egSU {

        /* renamed from: A2egSU, reason: collision with root package name */
        public int f8300A2egSU;

        /* renamed from: A4TApA, reason: collision with root package name */
        public final ADYaiT f8301A4TApA = new ADYaiT();

        /* renamed from: A5SV6n, reason: collision with root package name */
        public final C0006A5SV6n f8302A5SV6n = new C0006A5SV6n();

        /* renamed from: ADYaiT, reason: collision with root package name */
        public final A4TApA f8303ADYaiT = new A4TApA();
        public final AMqCpz AMqCpz = new AMqCpz();

        /* renamed from: ARc23Z, reason: collision with root package name */
        public HashMap f8304ARc23Z = new HashMap();

        public final void A2egSU(BJ7GGh.ADYaiT aDYaiT) {
            A4TApA a4TApA = this.f8303ADYaiT;
            aDYaiT.AMqCpz = a4TApA.f8312AYUAbz;
            aDYaiT.f1347ARc23Z = a4TApA.f8313AZOQYO;
            aDYaiT.f1348ASJ6gh = a4TApA.f8314AZkASS;
            aDYaiT.f1349AYUAbz = a4TApA.f8315AaHO0E;
            aDYaiT.f1350AZOQYO = a4TApA.f8316AcNBzu;
            aDYaiT.f1351AZkASS = a4TApA.f8317AlLFFp;
            aDYaiT.f1352AaHO0E = a4TApA.f8318AmA8tU;
            aDYaiT.f1353AcNBzu = a4TApA.f8319AzWtSf;
            aDYaiT.f1354AlLFFp = a4TApA.f8320B25kr6;
            aDYaiT.f1355AmA8tU = a4TApA.f8321B2KMhB;
            aDYaiT.f1356AzWtSf = a4TApA.f8322B3GDIM;
            aDYaiT.f1360B4ZgIw = a4TApA.f8323B4ZgIw;
            aDYaiT.f1361B7CMnp = a4TApA.f8324B7CMnp;
            aDYaiT.f1362B9tovu = a4TApA.f8325B9tovu;
            aDYaiT.f1363BChYOn = a4TApA.f8326BChYOn;
            ((ViewGroup.MarginLayoutParams) aDYaiT).leftMargin = a4TApA.BpkvW3;
            ((ViewGroup.MarginLayoutParams) aDYaiT).rightMargin = a4TApA.f8336C2rE4F;
            ((ViewGroup.MarginLayoutParams) aDYaiT).topMargin = a4TApA.f8337C4FrIb;
            ((ViewGroup.MarginLayoutParams) aDYaiT).bottomMargin = a4TApA.f8338CASmeH;
            aDYaiT.f1368BPw6Q8 = a4TApA.f8347CkXcdM;
            aDYaiT.f1369BTvldC = a4TApA.f8346CikNvS;
            aDYaiT.f1365BIYEnU = a4TApA.f8343CTkVKb;
            aDYaiT.f1367BNL6CD = a4TApA.f8345Cd8JRx;
            aDYaiT.f1372BniPrB = a4TApA.f8327BI9f7h;
            aDYaiT.BpkvW3 = a4TApA.f8328BIYEnU;
            aDYaiT.f1357B25kr6 = a4TApA.f8330BNL6CD;
            aDYaiT.f1358B2KMhB = a4TApA.f8331BPw6Q8;
            aDYaiT.f1359B3GDIM = a4TApA.f8332BTvldC;
            aDYaiT.f1373C2rE4F = a4TApA.f8329BJ7GGh;
            aDYaiT.f1386CqNSpT = a4TApA.f8333BV3sI0;
            aDYaiT.f1387CrfGsy = a4TApA.f8334BmvVmW;
            aDYaiT.f1375CASmeH = a4TApA.f8349CqNSpT;
            aDYaiT.f1374C4FrIb = a4TApA.f8350CrfGsy;
            aDYaiT.f1377COJEAR = a4TApA.f8352CtxOCS;
            aDYaiT.f1376CNPG0E = a4TApA.f8351CtFAbx;
            aDYaiT.f1389CtxOCS = a4TApA.f8366DcUJf1;
            aDYaiT.f1390D07BeM = a4TApA.f8367DdagTj;
            aDYaiT.f1378CQhlFr = a4TApA.f8353D07BeM;
            aDYaiT.f1379CSDoyG = a4TApA.f8354D6DOie;
            aDYaiT.f1382Cd8JRx = a4TApA.f8355D6yqiO;
            aDYaiT.f1383CikNvS = a4TApA.f8356D8MqeW;
            aDYaiT.f1380CTkVKb = a4TApA.f8357D8cQ8b;
            aDYaiT.f1381CcAIMM = a4TApA.f8358D9tr6l;
            aDYaiT.f1384CkXcdM = a4TApA.f8359DAk1zC;
            aDYaiT.f1385CmUvjW = a4TApA.f8360DG07BK;
            aDYaiT.f1388CtFAbx = a4TApA.f8335BniPrB;
            aDYaiT.f1345A5SV6n = a4TApA.f8310ARc23Z;
            aDYaiT.f1343A2egSU = a4TApA.f8309ADYaiT;
            aDYaiT.f1344A4TApA = a4TApA.AMqCpz;
            ((ViewGroup.MarginLayoutParams) aDYaiT).width = a4TApA.f8307A4TApA;
            ((ViewGroup.MarginLayoutParams) aDYaiT).height = a4TApA.f8308A5SV6n;
            String str = a4TApA.f8365DaOi9o;
            if (str != null) {
                aDYaiT.f1391D6DOie = str;
            }
            aDYaiT.f1392D6yqiO = a4TApA.f8368De4eam;
            aDYaiT.setMarginStart(a4TApA.f8340COJEAR);
            aDYaiT.setMarginEnd(a4TApA.f8339CNPG0E);
            aDYaiT.A2egSU();
        }

        public final Object clone() {
            A2egSU a2egSU = new A2egSU();
            A4TApA a4TApA = a2egSU.f8303ADYaiT;
            a4TApA.getClass();
            A4TApA a4TApA2 = this.f8303ADYaiT;
            a4TApA.f8306A2egSU = a4TApA2.f8306A2egSU;
            a4TApA.f8307A4TApA = a4TApA2.f8307A4TApA;
            a4TApA.f8308A5SV6n = a4TApA2.f8308A5SV6n;
            a4TApA.f8309ADYaiT = a4TApA2.f8309ADYaiT;
            a4TApA.AMqCpz = a4TApA2.AMqCpz;
            a4TApA.f8310ARc23Z = a4TApA2.f8310ARc23Z;
            a4TApA.f8311ASJ6gh = a4TApA2.f8311ASJ6gh;
            a4TApA.f8312AYUAbz = a4TApA2.f8312AYUAbz;
            a4TApA.f8313AZOQYO = a4TApA2.f8313AZOQYO;
            a4TApA.f8314AZkASS = a4TApA2.f8314AZkASS;
            a4TApA.f8315AaHO0E = a4TApA2.f8315AaHO0E;
            a4TApA.f8316AcNBzu = a4TApA2.f8316AcNBzu;
            a4TApA.f8317AlLFFp = a4TApA2.f8317AlLFFp;
            a4TApA.f8318AmA8tU = a4TApA2.f8318AmA8tU;
            a4TApA.f8319AzWtSf = a4TApA2.f8319AzWtSf;
            a4TApA.f8320B25kr6 = a4TApA2.f8320B25kr6;
            a4TApA.f8321B2KMhB = a4TApA2.f8321B2KMhB;
            a4TApA.f8322B3GDIM = a4TApA2.f8322B3GDIM;
            a4TApA.f8323B4ZgIw = a4TApA2.f8323B4ZgIw;
            a4TApA.f8324B7CMnp = a4TApA2.f8324B7CMnp;
            a4TApA.f8325B9tovu = a4TApA2.f8325B9tovu;
            a4TApA.f8326BChYOn = a4TApA2.f8326BChYOn;
            a4TApA.f8327BI9f7h = a4TApA2.f8327BI9f7h;
            a4TApA.f8328BIYEnU = a4TApA2.f8328BIYEnU;
            a4TApA.f8329BJ7GGh = a4TApA2.f8329BJ7GGh;
            a4TApA.f8330BNL6CD = a4TApA2.f8330BNL6CD;
            a4TApA.f8331BPw6Q8 = a4TApA2.f8331BPw6Q8;
            a4TApA.f8332BTvldC = a4TApA2.f8332BTvldC;
            a4TApA.f8333BV3sI0 = a4TApA2.f8333BV3sI0;
            a4TApA.f8334BmvVmW = a4TApA2.f8334BmvVmW;
            a4TApA.f8335BniPrB = a4TApA2.f8335BniPrB;
            a4TApA.BpkvW3 = a4TApA2.BpkvW3;
            a4TApA.f8336C2rE4F = a4TApA2.f8336C2rE4F;
            a4TApA.f8337C4FrIb = a4TApA2.f8337C4FrIb;
            a4TApA.f8338CASmeH = a4TApA2.f8338CASmeH;
            a4TApA.f8339CNPG0E = a4TApA2.f8339CNPG0E;
            a4TApA.f8340COJEAR = a4TApA2.f8340COJEAR;
            a4TApA.f8341CQhlFr = a4TApA2.f8341CQhlFr;
            a4TApA.f8342CSDoyG = a4TApA2.f8342CSDoyG;
            a4TApA.f8343CTkVKb = a4TApA2.f8343CTkVKb;
            a4TApA.f8344CcAIMM = a4TApA2.f8344CcAIMM;
            a4TApA.f8345Cd8JRx = a4TApA2.f8345Cd8JRx;
            a4TApA.f8346CikNvS = a4TApA2.f8346CikNvS;
            a4TApA.f8347CkXcdM = a4TApA2.f8347CkXcdM;
            a4TApA.f8348CmUvjW = a4TApA2.f8348CmUvjW;
            a4TApA.f8349CqNSpT = a4TApA2.f8349CqNSpT;
            a4TApA.f8350CrfGsy = a4TApA2.f8350CrfGsy;
            a4TApA.f8351CtFAbx = a4TApA2.f8351CtFAbx;
            a4TApA.f8352CtxOCS = a4TApA2.f8352CtxOCS;
            a4TApA.f8353D07BeM = a4TApA2.f8353D07BeM;
            a4TApA.f8354D6DOie = a4TApA2.f8354D6DOie;
            a4TApA.f8355D6yqiO = a4TApA2.f8355D6yqiO;
            a4TApA.f8356D8MqeW = a4TApA2.f8356D8MqeW;
            a4TApA.f8357D8cQ8b = a4TApA2.f8357D8cQ8b;
            a4TApA.f8358D9tr6l = a4TApA2.f8358D9tr6l;
            a4TApA.f8359DAk1zC = a4TApA2.f8359DAk1zC;
            a4TApA.f8360DG07BK = a4TApA2.f8360DG07BK;
            a4TApA.f8361DRlcZ9 = a4TApA2.f8361DRlcZ9;
            a4TApA.f8362DUi7mC = a4TApA2.f8362DUi7mC;
            a4TApA.f8363DV2E8K = a4TApA2.f8363DV2E8K;
            a4TApA.f8365DaOi9o = a4TApA2.f8365DaOi9o;
            int[] iArr = a4TApA2.f8364DXnQ0V;
            if (iArr == null || a4TApA2.DXuj49 != null) {
                a4TApA.f8364DXnQ0V = null;
            } else {
                a4TApA.f8364DXnQ0V = Arrays.copyOf(iArr, iArr.length);
            }
            a4TApA.DXuj49 = a4TApA2.DXuj49;
            a4TApA.f8366DcUJf1 = a4TApA2.f8366DcUJf1;
            a4TApA.f8367DdagTj = a4TApA2.f8367DdagTj;
            a4TApA.Ddcejp = a4TApA2.Ddcejp;
            a4TApA.f8368De4eam = a4TApA2.f8368De4eam;
            C0006A5SV6n c0006A5SV6n = a2egSU.f8302A5SV6n;
            c0006A5SV6n.getClass();
            C0006A5SV6n c0006A5SV6n2 = this.f8302A5SV6n;
            c0006A5SV6n2.getClass();
            c0006A5SV6n.f8370A2egSU = c0006A5SV6n2.f8370A2egSU;
            c0006A5SV6n.f8372A5SV6n = c0006A5SV6n2.f8372A5SV6n;
            c0006A5SV6n.AMqCpz = c0006A5SV6n2.AMqCpz;
            c0006A5SV6n.f8373ADYaiT = c0006A5SV6n2.f8373ADYaiT;
            ADYaiT aDYaiT = a2egSU.f8301A4TApA;
            aDYaiT.getClass();
            ADYaiT aDYaiT2 = this.f8301A4TApA;
            aDYaiT2.getClass();
            aDYaiT.f8378A2egSU = aDYaiT2.f8378A2egSU;
            aDYaiT.f8380A5SV6n = aDYaiT2.f8380A5SV6n;
            aDYaiT.f8381ADYaiT = aDYaiT2.f8381ADYaiT;
            aDYaiT.f8379A4TApA = aDYaiT2.f8379A4TApA;
            AMqCpz aMqCpz = a2egSU.AMqCpz;
            aMqCpz.getClass();
            AMqCpz aMqCpz2 = this.AMqCpz;
            aMqCpz2.getClass();
            aMqCpz.f8383A2egSU = aMqCpz2.f8383A2egSU;
            aMqCpz.f8384A4TApA = aMqCpz2.f8384A4TApA;
            aMqCpz.f8385A5SV6n = aMqCpz2.f8385A5SV6n;
            aMqCpz.f8386ADYaiT = aMqCpz2.f8386ADYaiT;
            aMqCpz.AMqCpz = aMqCpz2.AMqCpz;
            aMqCpz.f8387ARc23Z = aMqCpz2.f8387ARc23Z;
            aMqCpz.f8388ASJ6gh = aMqCpz2.f8388ASJ6gh;
            aMqCpz.f8389AYUAbz = aMqCpz2.f8389AYUAbz;
            aMqCpz.f8390AZOQYO = aMqCpz2.f8390AZOQYO;
            aMqCpz.f8391AZkASS = aMqCpz2.f8391AZkASS;
            aMqCpz.f8392AaHO0E = aMqCpz2.f8392AaHO0E;
            aMqCpz.f8393AcNBzu = aMqCpz2.f8393AcNBzu;
            aMqCpz.f8394AlLFFp = aMqCpz2.f8394AlLFFp;
            a2egSU.f8300A2egSU = this.f8300A2egSU;
            return a2egSU;
        }
    }

    public static class A4TApA {

        /* renamed from: DjONCG, reason: collision with root package name */
        public static final SparseIntArray f8305DjONCG;

        /* renamed from: A4TApA, reason: collision with root package name */
        public int f8307A4TApA;

        /* renamed from: A5SV6n, reason: collision with root package name */
        public int f8308A5SV6n;

        /* renamed from: DXnQ0V, reason: collision with root package name */
        public int[] f8364DXnQ0V;
        public String DXuj49;

        /* renamed from: DaOi9o, reason: collision with root package name */
        public String f8365DaOi9o;

        /* renamed from: A2egSU, reason: collision with root package name */
        public boolean f8306A2egSU = false;

        /* renamed from: ADYaiT, reason: collision with root package name */
        public int f8309ADYaiT = -1;
        public int AMqCpz = -1;

        /* renamed from: ARc23Z, reason: collision with root package name */
        public float f8310ARc23Z = -1.0f;

        /* renamed from: ASJ6gh, reason: collision with root package name */
        public boolean f8311ASJ6gh = true;

        /* renamed from: AYUAbz, reason: collision with root package name */
        public int f8312AYUAbz = -1;

        /* renamed from: AZOQYO, reason: collision with root package name */
        public int f8313AZOQYO = -1;

        /* renamed from: AZkASS, reason: collision with root package name */
        public int f8314AZkASS = -1;

        /* renamed from: AaHO0E, reason: collision with root package name */
        public int f8315AaHO0E = -1;

        /* renamed from: AcNBzu, reason: collision with root package name */
        public int f8316AcNBzu = -1;

        /* renamed from: AlLFFp, reason: collision with root package name */
        public int f8317AlLFFp = -1;

        /* renamed from: AmA8tU, reason: collision with root package name */
        public int f8318AmA8tU = -1;

        /* renamed from: AzWtSf, reason: collision with root package name */
        public int f8319AzWtSf = -1;

        /* renamed from: B25kr6, reason: collision with root package name */
        public int f8320B25kr6 = -1;

        /* renamed from: B2KMhB, reason: collision with root package name */
        public int f8321B2KMhB = -1;

        /* renamed from: B3GDIM, reason: collision with root package name */
        public int f8322B3GDIM = -1;

        /* renamed from: B4ZgIw, reason: collision with root package name */
        public int f8323B4ZgIw = -1;

        /* renamed from: B7CMnp, reason: collision with root package name */
        public int f8324B7CMnp = -1;

        /* renamed from: B9tovu, reason: collision with root package name */
        public int f8325B9tovu = -1;

        /* renamed from: BChYOn, reason: collision with root package name */
        public int f8326BChYOn = -1;

        /* renamed from: BI9f7h, reason: collision with root package name */
        public float f8327BI9f7h = 0.5f;

        /* renamed from: BIYEnU, reason: collision with root package name */
        public float f8328BIYEnU = 0.5f;

        /* renamed from: BJ7GGh, reason: collision with root package name */
        public String f8329BJ7GGh = null;

        /* renamed from: BNL6CD, reason: collision with root package name */
        public int f8330BNL6CD = -1;

        /* renamed from: BPw6Q8, reason: collision with root package name */
        public int f8331BPw6Q8 = 0;

        /* renamed from: BTvldC, reason: collision with root package name */
        public float f8332BTvldC = 0.0f;

        /* renamed from: BV3sI0, reason: collision with root package name */
        public int f8333BV3sI0 = -1;

        /* renamed from: BmvVmW, reason: collision with root package name */
        public int f8334BmvVmW = -1;

        /* renamed from: BniPrB, reason: collision with root package name */
        public int f8335BniPrB = -1;
        public int BpkvW3 = 0;

        /* renamed from: C2rE4F, reason: collision with root package name */
        public int f8336C2rE4F = 0;

        /* renamed from: C4FrIb, reason: collision with root package name */
        public int f8337C4FrIb = 0;

        /* renamed from: CASmeH, reason: collision with root package name */
        public int f8338CASmeH = 0;

        /* renamed from: CNPG0E, reason: collision with root package name */
        public int f8339CNPG0E = 0;

        /* renamed from: COJEAR, reason: collision with root package name */
        public int f8340COJEAR = 0;

        /* renamed from: CQhlFr, reason: collision with root package name */
        public int f8341CQhlFr = 0;

        /* renamed from: CSDoyG, reason: collision with root package name */
        public int f8342CSDoyG = Integer.MIN_VALUE;

        /* renamed from: CTkVKb, reason: collision with root package name */
        public int f8343CTkVKb = Integer.MIN_VALUE;

        /* renamed from: CcAIMM, reason: collision with root package name */
        public int f8344CcAIMM = Integer.MIN_VALUE;

        /* renamed from: Cd8JRx, reason: collision with root package name */
        public int f8345Cd8JRx = Integer.MIN_VALUE;

        /* renamed from: CikNvS, reason: collision with root package name */
        public int f8346CikNvS = Integer.MIN_VALUE;

        /* renamed from: CkXcdM, reason: collision with root package name */
        public int f8347CkXcdM = Integer.MIN_VALUE;

        /* renamed from: CmUvjW, reason: collision with root package name */
        public int f8348CmUvjW = Integer.MIN_VALUE;

        /* renamed from: CqNSpT, reason: collision with root package name */
        public float f8349CqNSpT = -1.0f;

        /* renamed from: CrfGsy, reason: collision with root package name */
        public float f8350CrfGsy = -1.0f;

        /* renamed from: CtFAbx, reason: collision with root package name */
        public int f8351CtFAbx = 0;

        /* renamed from: CtxOCS, reason: collision with root package name */
        public int f8352CtxOCS = 0;

        /* renamed from: D07BeM, reason: collision with root package name */
        public int f8353D07BeM = 0;

        /* renamed from: D6DOie, reason: collision with root package name */
        public int f8354D6DOie = 0;

        /* renamed from: D6yqiO, reason: collision with root package name */
        public int f8355D6yqiO = 0;

        /* renamed from: D8MqeW, reason: collision with root package name */
        public int f8356D8MqeW = 0;

        /* renamed from: D8cQ8b, reason: collision with root package name */
        public int f8357D8cQ8b = 0;

        /* renamed from: D9tr6l, reason: collision with root package name */
        public int f8358D9tr6l = 0;

        /* renamed from: DAk1zC, reason: collision with root package name */
        public float f8359DAk1zC = 1.0f;

        /* renamed from: DG07BK, reason: collision with root package name */
        public float f8360DG07BK = 1.0f;

        /* renamed from: DRlcZ9, reason: collision with root package name */
        public int f8361DRlcZ9 = -1;

        /* renamed from: DUi7mC, reason: collision with root package name */
        public int f8362DUi7mC = 0;

        /* renamed from: DV2E8K, reason: collision with root package name */
        public int f8363DV2E8K = -1;

        /* renamed from: DcUJf1, reason: collision with root package name */
        public boolean f8366DcUJf1 = false;

        /* renamed from: DdagTj, reason: collision with root package name */
        public boolean f8367DdagTj = false;
        public boolean Ddcejp = true;

        /* renamed from: De4eam, reason: collision with root package name */
        public int f8368De4eam = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f8305DjONCG = sparseIntArray;
            sparseIntArray.append(43, 24);
            sparseIntArray.append(44, 25);
            sparseIntArray.append(46, 28);
            sparseIntArray.append(47, 29);
            sparseIntArray.append(52, 35);
            sparseIntArray.append(51, 34);
            sparseIntArray.append(24, 4);
            sparseIntArray.append(23, 3);
            sparseIntArray.append(19, 1);
            sparseIntArray.append(61, 6);
            sparseIntArray.append(62, 7);
            sparseIntArray.append(31, 17);
            sparseIntArray.append(32, 18);
            sparseIntArray.append(33, 19);
            sparseIntArray.append(15, 90);
            sparseIntArray.append(0, 26);
            sparseIntArray.append(48, 31);
            sparseIntArray.append(49, 32);
            sparseIntArray.append(30, 10);
            sparseIntArray.append(29, 9);
            sparseIntArray.append(66, 13);
            sparseIntArray.append(69, 16);
            sparseIntArray.append(67, 14);
            sparseIntArray.append(64, 11);
            sparseIntArray.append(68, 15);
            sparseIntArray.append(65, 12);
            sparseIntArray.append(55, 38);
            sparseIntArray.append(41, 37);
            sparseIntArray.append(40, 39);
            sparseIntArray.append(54, 40);
            sparseIntArray.append(39, 20);
            sparseIntArray.append(53, 36);
            sparseIntArray.append(28, 5);
            sparseIntArray.append(42, 91);
            sparseIntArray.append(50, 91);
            sparseIntArray.append(45, 91);
            sparseIntArray.append(22, 91);
            sparseIntArray.append(18, 91);
            sparseIntArray.append(3, 23);
            sparseIntArray.append(5, 27);
            sparseIntArray.append(7, 30);
            sparseIntArray.append(8, 8);
            sparseIntArray.append(4, 33);
            sparseIntArray.append(6, 2);
            sparseIntArray.append(1, 22);
            sparseIntArray.append(2, 21);
            sparseIntArray.append(56, 41);
            sparseIntArray.append(34, 42);
            sparseIntArray.append(17, 41);
            sparseIntArray.append(16, 42);
            sparseIntArray.append(71, 76);
            sparseIntArray.append(25, 61);
            sparseIntArray.append(27, 62);
            sparseIntArray.append(26, 63);
            sparseIntArray.append(60, 69);
            sparseIntArray.append(38, 70);
            sparseIntArray.append(12, 71);
            sparseIntArray.append(10, 72);
            sparseIntArray.append(11, 73);
            sparseIntArray.append(13, 74);
            sparseIntArray.append(9, 75);
            aJobpo();
        }

        private static /* synthetic */ void aJobpo() {
            char[] charArray = "0<>}42>6}1<*} ;6??}\u0019=:\u0011!:746".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'S');
            }
            String str = new String(charArray);
            char[] charArray2 = "0?:=:'".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'S');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public final void A2egSU(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AMqCpz);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                SparseIntArray sparseIntArray = f8305DjONCG;
                int i2 = sparseIntArray.get(index);
                switch (i2) {
                    case 1:
                        this.f8320B25kr6 = A5SV6n.ARc23Z(obtainStyledAttributes, index, this.f8320B25kr6);
                        break;
                    case 2:
                        this.f8338CASmeH = obtainStyledAttributes.getDimensionPixelSize(index, this.f8338CASmeH);
                        break;
                    case 3:
                        this.f8319AzWtSf = A5SV6n.ARc23Z(obtainStyledAttributes, index, this.f8319AzWtSf);
                        break;
                    case 4:
                        this.f8318AmA8tU = A5SV6n.ARc23Z(obtainStyledAttributes, index, this.f8318AmA8tU);
                        break;
                    case 5:
                        this.f8329BJ7GGh = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.f8333BV3sI0 = obtainStyledAttributes.getDimensionPixelOffset(index, this.f8333BV3sI0);
                        break;
                    case 7:
                        this.f8334BmvVmW = obtainStyledAttributes.getDimensionPixelOffset(index, this.f8334BmvVmW);
                        break;
                    case 8:
                        this.f8339CNPG0E = obtainStyledAttributes.getDimensionPixelSize(index, this.f8339CNPG0E);
                        break;
                    case 9:
                        this.f8326BChYOn = A5SV6n.ARc23Z(obtainStyledAttributes, index, this.f8326BChYOn);
                        break;
                    case 10:
                        this.f8325B9tovu = A5SV6n.ARc23Z(obtainStyledAttributes, index, this.f8325B9tovu);
                        break;
                    case 11:
                        this.f8345Cd8JRx = obtainStyledAttributes.getDimensionPixelSize(index, this.f8345Cd8JRx);
                        break;
                    case 12:
                        this.f8346CikNvS = obtainStyledAttributes.getDimensionPixelSize(index, this.f8346CikNvS);
                        break;
                    case 13:
                        this.f8342CSDoyG = obtainStyledAttributes.getDimensionPixelSize(index, this.f8342CSDoyG);
                        break;
                    case 14:
                        this.f8344CcAIMM = obtainStyledAttributes.getDimensionPixelSize(index, this.f8344CcAIMM);
                        break;
                    case 15:
                        this.f8347CkXcdM = obtainStyledAttributes.getDimensionPixelSize(index, this.f8347CkXcdM);
                        break;
                    case 16:
                        this.f8343CTkVKb = obtainStyledAttributes.getDimensionPixelSize(index, this.f8343CTkVKb);
                        break;
                    case 17:
                        this.f8309ADYaiT = obtainStyledAttributes.getDimensionPixelOffset(index, this.f8309ADYaiT);
                        break;
                    case 18:
                        this.AMqCpz = obtainStyledAttributes.getDimensionPixelOffset(index, this.AMqCpz);
                        break;
                    case 19:
                        this.f8310ARc23Z = obtainStyledAttributes.getFloat(index, this.f8310ARc23Z);
                        break;
                    case 20:
                        this.f8327BI9f7h = obtainStyledAttributes.getFloat(index, this.f8327BI9f7h);
                        break;
                    case 21:
                        this.f8308A5SV6n = obtainStyledAttributes.getLayoutDimension(index, this.f8308A5SV6n);
                        break;
                    case 22:
                        this.f8307A4TApA = obtainStyledAttributes.getLayoutDimension(index, this.f8307A4TApA);
                        break;
                    case 23:
                        this.BpkvW3 = obtainStyledAttributes.getDimensionPixelSize(index, this.BpkvW3);
                        break;
                    case 24:
                        this.f8312AYUAbz = A5SV6n.ARc23Z(obtainStyledAttributes, index, this.f8312AYUAbz);
                        break;
                    case 25:
                        this.f8313AZOQYO = A5SV6n.ARc23Z(obtainStyledAttributes, index, this.f8313AZOQYO);
                        break;
                    case 26:
                        this.f8335BniPrB = obtainStyledAttributes.getInt(index, this.f8335BniPrB);
                        break;
                    case 27:
                        this.f8336C2rE4F = obtainStyledAttributes.getDimensionPixelSize(index, this.f8336C2rE4F);
                        break;
                    case 28:
                        this.f8314AZkASS = A5SV6n.ARc23Z(obtainStyledAttributes, index, this.f8314AZkASS);
                        break;
                    case 29:
                        this.f8315AaHO0E = A5SV6n.ARc23Z(obtainStyledAttributes, index, this.f8315AaHO0E);
                        break;
                    case 30:
                        this.f8340COJEAR = obtainStyledAttributes.getDimensionPixelSize(index, this.f8340COJEAR);
                        break;
                    case 31:
                        this.f8323B4ZgIw = A5SV6n.ARc23Z(obtainStyledAttributes, index, this.f8323B4ZgIw);
                        break;
                    case 32:
                        this.f8324B7CMnp = A5SV6n.ARc23Z(obtainStyledAttributes, index, this.f8324B7CMnp);
                        break;
                    case 33:
                        this.f8337C4FrIb = obtainStyledAttributes.getDimensionPixelSize(index, this.f8337C4FrIb);
                        break;
                    case 34:
                        this.f8317AlLFFp = A5SV6n.ARc23Z(obtainStyledAttributes, index, this.f8317AlLFFp);
                        break;
                    case 35:
                        this.f8316AcNBzu = A5SV6n.ARc23Z(obtainStyledAttributes, index, this.f8316AcNBzu);
                        break;
                    case 36:
                        this.f8328BIYEnU = obtainStyledAttributes.getFloat(index, this.f8328BIYEnU);
                        break;
                    case 37:
                        this.f8350CrfGsy = obtainStyledAttributes.getFloat(index, this.f8350CrfGsy);
                        break;
                    case 38:
                        this.f8349CqNSpT = obtainStyledAttributes.getFloat(index, this.f8349CqNSpT);
                        break;
                    case 39:
                        this.f8351CtFAbx = obtainStyledAttributes.getInt(index, this.f8351CtFAbx);
                        break;
                    case 40:
                        this.f8352CtxOCS = obtainStyledAttributes.getInt(index, this.f8352CtxOCS);
                        break;
                    case 41:
                        A5SV6n.ASJ6gh(this, obtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        A5SV6n.ASJ6gh(this, obtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i2) {
                            case 61:
                                this.f8330BNL6CD = A5SV6n.ARc23Z(obtainStyledAttributes, index, this.f8330BNL6CD);
                                break;
                            case 62:
                                this.f8331BPw6Q8 = obtainStyledAttributes.getDimensionPixelSize(index, this.f8331BPw6Q8);
                                break;
                            case 63:
                                this.f8332BTvldC = obtainStyledAttributes.getFloat(index, this.f8332BTvldC);
                                break;
                            default:
                                switch (i2) {
                                    case 69:
                                        this.f8359DAk1zC = obtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.f8360DG07BK = obtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        break;
                                    case 72:
                                        this.f8361DRlcZ9 = obtainStyledAttributes.getInt(index, this.f8361DRlcZ9);
                                        break;
                                    case 73:
                                        this.f8362DUi7mC = obtainStyledAttributes.getDimensionPixelSize(index, this.f8362DUi7mC);
                                        break;
                                    case 74:
                                        this.DXuj49 = obtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.Ddcejp = obtainStyledAttributes.getBoolean(index, this.Ddcejp);
                                        break;
                                    case 76:
                                        this.f8368De4eam = obtainStyledAttributes.getInt(index, this.f8368De4eam);
                                        break;
                                    case 77:
                                        this.f8321B2KMhB = A5SV6n.ARc23Z(obtainStyledAttributes, index, this.f8321B2KMhB);
                                        break;
                                    case 78:
                                        this.f8322B3GDIM = A5SV6n.ARc23Z(obtainStyledAttributes, index, this.f8322B3GDIM);
                                        break;
                                    case 79:
                                        this.f8348CmUvjW = obtainStyledAttributes.getDimensionPixelSize(index, this.f8348CmUvjW);
                                        break;
                                    case 80:
                                        this.f8341CQhlFr = obtainStyledAttributes.getDimensionPixelSize(index, this.f8341CQhlFr);
                                        break;
                                    case 81:
                                        this.f8353D07BeM = obtainStyledAttributes.getInt(index, this.f8353D07BeM);
                                        break;
                                    case 82:
                                        this.f8354D6DOie = obtainStyledAttributes.getInt(index, this.f8354D6DOie);
                                        break;
                                    case 83:
                                        this.f8356D8MqeW = obtainStyledAttributes.getDimensionPixelSize(index, this.f8356D8MqeW);
                                        break;
                                    case 84:
                                        this.f8355D6yqiO = obtainStyledAttributes.getDimensionPixelSize(index, this.f8355D6yqiO);
                                        break;
                                    case 85:
                                        this.f8358D9tr6l = obtainStyledAttributes.getDimensionPixelSize(index, this.f8358D9tr6l);
                                        break;
                                    case 86:
                                        this.f8357D8cQ8b = obtainStyledAttributes.getDimensionPixelSize(index, this.f8357D8cQ8b);
                                        break;
                                    case 87:
                                        this.f8366DcUJf1 = obtainStyledAttributes.getBoolean(index, this.f8366DcUJf1);
                                        break;
                                    case 88:
                                        this.f8367DdagTj = obtainStyledAttributes.getBoolean(index, this.f8367DdagTj);
                                        break;
                                    case 89:
                                        this.f8365DaOi9o = obtainStyledAttributes.getString(index);
                                        break;
                                    case MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SYNC_MODE /* 90 */:
                                        this.f8311ASJ6gh = obtainStyledAttributes.getBoolean(index, this.f8311ASJ6gh);
                                        break;
                                    case MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY /* 91 */:
                                        Integer.toHexString(index);
                                        sparseIntArray.get(index);
                                        break;
                                    default:
                                        Integer.toHexString(index);
                                        sparseIntArray.get(index);
                                        break;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: androidx.constraintlayout.widget.A5SV6n$A5SV6n, reason: collision with other inner class name */
    public static class C0006A5SV6n {

        /* renamed from: AZkASS, reason: collision with root package name */
        public static final SparseIntArray f8369AZkASS;

        /* renamed from: A2egSU, reason: collision with root package name */
        public int f8370A2egSU = -1;

        /* renamed from: A4TApA, reason: collision with root package name */
        public int f8371A4TApA = 0;

        /* renamed from: A5SV6n, reason: collision with root package name */
        public int f8372A5SV6n = -1;

        /* renamed from: ADYaiT, reason: collision with root package name */
        public float f8373ADYaiT = Float.NaN;
        public float AMqCpz = Float.NaN;

        /* renamed from: ARc23Z, reason: collision with root package name */
        public float f8374ARc23Z = Float.NaN;

        /* renamed from: ASJ6gh, reason: collision with root package name */
        public int f8375ASJ6gh = -1;

        /* renamed from: AYUAbz, reason: collision with root package name */
        public String f8376AYUAbz = null;

        /* renamed from: AZOQYO, reason: collision with root package name */
        public int f8377AZOQYO = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f8369AZkASS = sparseIntArray;
            sparseIntArray.append(3, 1);
            sparseIntArray.append(5, 2);
            sparseIntArray.append(9, 3);
            sparseIntArray.append(2, 4);
            sparseIntArray.append(1, 5);
            sparseIntArray.append(0, 6);
            sparseIntArray.append(4, 7);
            sparseIntArray.append(8, 8);
            sparseIntArray.append(7, 9);
            sparseIntArray.append(6, 10);
            Zzfus();
        }

        private static /* synthetic */ void Zzfus() {
            char[] charArray = "ÃÏÍ\u008eÇÁÍÅ\u008eÂÏÙ\u008eÓÈÅÌÌ\u008eêÎÉâÒÉÄÇÅ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 160);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÃÌÉÎÉÔ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 160);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public final void A2egSU(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f8420ARc23Z);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (f8369AZkASS.get(index)) {
                    case 1:
                        this.AMqCpz = obtainStyledAttributes.getFloat(index, this.AMqCpz);
                        break;
                    case 2:
                        this.f8372A5SV6n = obtainStyledAttributes.getInt(index, this.f8372A5SV6n);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            String str = B7CMnp.A2egSU.f1091A2egSU[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f8370A2egSU = A5SV6n.ARc23Z(obtainStyledAttributes, index, this.f8370A2egSU);
                        break;
                    case 6:
                        this.f8371A4TApA = obtainStyledAttributes.getInteger(index, this.f8371A4TApA);
                        break;
                    case 7:
                        this.f8373ADYaiT = obtainStyledAttributes.getFloat(index, this.f8373ADYaiT);
                        break;
                    case 8:
                        this.f8375ASJ6gh = obtainStyledAttributes.getInteger(index, this.f8375ASJ6gh);
                        break;
                    case 9:
                        this.f8374ARc23Z = obtainStyledAttributes.getFloat(index, this.f8374ARc23Z);
                        break;
                    case 10:
                        int i2 = obtainStyledAttributes.peekValue(index).type;
                        if (i2 == 1) {
                            this.f8377AZOQYO = obtainStyledAttributes.getResourceId(index, -1);
                            break;
                        } else if (i2 == 3) {
                            String string = obtainStyledAttributes.getString(index);
                            this.f8376AYUAbz = string;
                            if (string.indexOf("/") > 0) {
                                this.f8377AZOQYO = obtainStyledAttributes.getResourceId(index, -1);
                                break;
                            } else {
                                break;
                            }
                        } else {
                            obtainStyledAttributes.getInteger(index, this.f8377AZOQYO);
                            break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class ADYaiT {

        /* renamed from: A2egSU, reason: collision with root package name */
        public int f8378A2egSU = 0;

        /* renamed from: A4TApA, reason: collision with root package name */
        public int f8379A4TApA = 0;

        /* renamed from: A5SV6n, reason: collision with root package name */
        public float f8380A5SV6n = 1.0f;

        /* renamed from: ADYaiT, reason: collision with root package name */
        public float f8381ADYaiT = Float.NaN;

        public final void A2egSU(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f8421ASJ6gh);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 1) {
                    this.f8380A5SV6n = obtainStyledAttributes.getFloat(index, this.f8380A5SV6n);
                } else if (index == 0) {
                    int i2 = obtainStyledAttributes.getInt(index, this.f8378A2egSU);
                    this.f8378A2egSU = i2;
                    this.f8378A2egSU = A5SV6n.f8295ADYaiT[i2];
                } else if (index == 4) {
                    this.f8379A4TApA = obtainStyledAttributes.getInt(index, this.f8379A4TApA);
                } else if (index == 3) {
                    this.f8381ADYaiT = obtainStyledAttributes.getFloat(index, this.f8381ADYaiT);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class AMqCpz {

        /* renamed from: AmA8tU, reason: collision with root package name */
        public static final SparseIntArray f8382AmA8tU;

        /* renamed from: A2egSU, reason: collision with root package name */
        public float f8383A2egSU = 0.0f;

        /* renamed from: A4TApA, reason: collision with root package name */
        public float f8384A4TApA = 0.0f;

        /* renamed from: A5SV6n, reason: collision with root package name */
        public float f8385A5SV6n = 0.0f;

        /* renamed from: ADYaiT, reason: collision with root package name */
        public float f8386ADYaiT = 1.0f;
        public float AMqCpz = 1.0f;

        /* renamed from: ARc23Z, reason: collision with root package name */
        public float f8387ARc23Z = Float.NaN;

        /* renamed from: ASJ6gh, reason: collision with root package name */
        public float f8388ASJ6gh = Float.NaN;

        /* renamed from: AYUAbz, reason: collision with root package name */
        public int f8389AYUAbz = -1;

        /* renamed from: AZOQYO, reason: collision with root package name */
        public float f8390AZOQYO = 0.0f;

        /* renamed from: AZkASS, reason: collision with root package name */
        public float f8391AZkASS = 0.0f;

        /* renamed from: AaHO0E, reason: collision with root package name */
        public float f8392AaHO0E = 0.0f;

        /* renamed from: AcNBzu, reason: collision with root package name */
        public boolean f8393AcNBzu = false;

        /* renamed from: AlLFFp, reason: collision with root package name */
        public float f8394AlLFFp = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f8382AmA8tU = sparseIntArray;
            sparseIntArray.append(6, 1);
            sparseIntArray.append(7, 2);
            sparseIntArray.append(8, 3);
            sparseIntArray.append(4, 4);
            sparseIntArray.append(5, 5);
            sparseIntArray.append(0, 6);
            sparseIntArray.append(1, 7);
            sparseIntArray.append(2, 8);
            sparseIntArray.append(3, 9);
            sparseIntArray.append(9, 10);
            sparseIntArray.append(10, 11);
            sparseIntArray.append(11, 12);
            VsKoLP();
        }

        private static /* synthetic */ void VsKoLP() {
            char[] charArray = "\u001f\u0013\u0011R\u001b\u001d\u0011\u0019R\u001e\u0013\u0005R\u000f\u0014\u0019\u0010\u0010R6\u0012\u0015>\u000e\u0015\u0018\u001b\u0019".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '|');
            }
            String str = new String(charArray);
            char[] charArray2 = "\u001f\u0010\u0015\u0012\u0015\b".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '|');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public final void A2egSU(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f8423AZOQYO);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (f8382AmA8tU.get(index)) {
                    case 1:
                        this.f8383A2egSU = obtainStyledAttributes.getFloat(index, this.f8383A2egSU);
                        break;
                    case 2:
                        this.f8384A4TApA = obtainStyledAttributes.getFloat(index, this.f8384A4TApA);
                        break;
                    case 3:
                        this.f8385A5SV6n = obtainStyledAttributes.getFloat(index, this.f8385A5SV6n);
                        break;
                    case 4:
                        this.f8386ADYaiT = obtainStyledAttributes.getFloat(index, this.f8386ADYaiT);
                        break;
                    case 5:
                        this.AMqCpz = obtainStyledAttributes.getFloat(index, this.AMqCpz);
                        break;
                    case 6:
                        this.f8387ARc23Z = obtainStyledAttributes.getDimension(index, this.f8387ARc23Z);
                        break;
                    case 7:
                        this.f8388ASJ6gh = obtainStyledAttributes.getDimension(index, this.f8388ASJ6gh);
                        break;
                    case 8:
                        this.f8390AZOQYO = obtainStyledAttributes.getDimension(index, this.f8390AZOQYO);
                        break;
                    case 9:
                        this.f8391AZkASS = obtainStyledAttributes.getDimension(index, this.f8391AZkASS);
                        break;
                    case 10:
                        this.f8392AaHO0E = obtainStyledAttributes.getDimension(index, this.f8392AaHO0E);
                        break;
                    case 11:
                        this.f8393AcNBzu = true;
                        this.f8394AlLFFp = obtainStyledAttributes.getDimension(index, this.f8394AlLFFp);
                        break;
                    case 12:
                        this.f8389AYUAbz = A5SV6n.ARc23Z(obtainStyledAttributes, index, this.f8389AYUAbz);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        AMqCpz = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f8296ARc23Z = sparseIntArray2;
        sparseIntArray.append(82, 25);
        sparseIntArray.append(83, 26);
        sparseIntArray.append(85, 29);
        sparseIntArray.append(86, 30);
        sparseIntArray.append(92, 36);
        sparseIntArray.append(91, 35);
        sparseIntArray.append(63, 4);
        sparseIntArray.append(62, 3);
        sparseIntArray.append(58, 1);
        sparseIntArray.append(60, 91);
        sparseIntArray.append(59, 92);
        sparseIntArray.append(101, 6);
        sparseIntArray.append(102, 7);
        sparseIntArray.append(70, 17);
        sparseIntArray.append(71, 18);
        sparseIntArray.append(72, 19);
        sparseIntArray.append(54, 99);
        sparseIntArray.append(0, 27);
        sparseIntArray.append(87, 32);
        sparseIntArray.append(88, 33);
        sparseIntArray.append(69, 10);
        sparseIntArray.append(68, 9);
        sparseIntArray.append(106, 13);
        sparseIntArray.append(AdEventType.AD_RENDER_SUCCESS, 16);
        sparseIntArray.append(107, 14);
        sparseIntArray.append(104, 11);
        sparseIntArray.append(108, 15);
        sparseIntArray.append(105, 12);
        sparseIntArray.append(95, 40);
        sparseIntArray.append(80, 39);
        sparseIntArray.append(79, 41);
        sparseIntArray.append(94, 42);
        sparseIntArray.append(78, 20);
        sparseIntArray.append(93, 37);
        sparseIntArray.append(67, 5);
        sparseIntArray.append(81, 87);
        sparseIntArray.append(90, 87);
        sparseIntArray.append(84, 87);
        sparseIntArray.append(61, 87);
        sparseIntArray.append(57, 87);
        sparseIntArray.append(5, 24);
        sparseIntArray.append(7, 28);
        sparseIntArray.append(23, 31);
        sparseIntArray.append(24, 8);
        sparseIntArray.append(6, 34);
        sparseIntArray.append(8, 2);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(4, 21);
        sparseIntArray.append(96, 95);
        sparseIntArray.append(73, 96);
        sparseIntArray.append(2, 22);
        sparseIntArray.append(13, 43);
        sparseIntArray.append(26, 44);
        sparseIntArray.append(21, 45);
        sparseIntArray.append(22, 46);
        sparseIntArray.append(20, 60);
        sparseIntArray.append(18, 47);
        sparseIntArray.append(19, 48);
        sparseIntArray.append(14, 49);
        sparseIntArray.append(15, 50);
        sparseIntArray.append(16, 51);
        sparseIntArray.append(17, 52);
        sparseIntArray.append(25, 53);
        sparseIntArray.append(97, 54);
        sparseIntArray.append(74, 55);
        sparseIntArray.append(98, 56);
        sparseIntArray.append(75, 57);
        sparseIntArray.append(99, 58);
        sparseIntArray.append(76, 59);
        sparseIntArray.append(64, 61);
        sparseIntArray.append(66, 62);
        sparseIntArray.append(65, 63);
        sparseIntArray.append(28, 64);
        sparseIntArray.append(121, 65);
        sparseIntArray.append(35, 66);
        sparseIntArray.append(122, 67);
        sparseIntArray.append(AdEventType.AD_ZOOM_OUT, 79);
        sparseIntArray.append(1, 38);
        sparseIntArray.append(AdEventType.AD_TICK, 68);
        sparseIntArray.append(100, 69);
        sparseIntArray.append(77, 70);
        sparseIntArray.append(111, 97);
        sparseIntArray.append(32, 71);
        sparseIntArray.append(30, 72);
        sparseIntArray.append(31, 73);
        sparseIntArray.append(33, 74);
        sparseIntArray.append(29, 75);
        sparseIntArray.append(AdEventType.AD_ZOOM_OUT_PLAY_FINISH, 76);
        sparseIntArray.append(89, 77);
        sparseIntArray.append(123, 78);
        sparseIntArray.append(56, 80);
        sparseIntArray.append(55, 81);
        sparseIntArray.append(116, 82);
        sparseIntArray.append(AVMDLDataLoaderConfigure.DEFAULT_SOCKET_IDLE_TIMEOUT, 83);
        sparseIntArray.append(119, 84);
        sparseIntArray.append(TTVideoEngine.PLAYER_BUFFERING_DATA_OF_MILLISECONDS, 85);
        sparseIntArray.append(117, 86);
        sparseIntArray2.append(85, 6);
        sparseIntArray2.append(85, 7);
        sparseIntArray2.append(0, 27);
        sparseIntArray2.append(89, 13);
        sparseIntArray2.append(92, 16);
        sparseIntArray2.append(90, 14);
        sparseIntArray2.append(87, 11);
        sparseIntArray2.append(91, 15);
        sparseIntArray2.append(88, 12);
        sparseIntArray2.append(78, 40);
        sparseIntArray2.append(71, 39);
        sparseIntArray2.append(70, 41);
        sparseIntArray2.append(77, 42);
        sparseIntArray2.append(69, 20);
        sparseIntArray2.append(76, 37);
        sparseIntArray2.append(60, 5);
        sparseIntArray2.append(72, 87);
        sparseIntArray2.append(75, 87);
        sparseIntArray2.append(73, 87);
        sparseIntArray2.append(57, 87);
        sparseIntArray2.append(56, 87);
        sparseIntArray2.append(5, 24);
        sparseIntArray2.append(7, 28);
        sparseIntArray2.append(23, 31);
        sparseIntArray2.append(24, 8);
        sparseIntArray2.append(6, 34);
        sparseIntArray2.append(8, 2);
        sparseIntArray2.append(3, 23);
        sparseIntArray2.append(4, 21);
        sparseIntArray2.append(79, 95);
        sparseIntArray2.append(64, 96);
        sparseIntArray2.append(2, 22);
        sparseIntArray2.append(13, 43);
        sparseIntArray2.append(26, 44);
        sparseIntArray2.append(21, 45);
        sparseIntArray2.append(22, 46);
        sparseIntArray2.append(20, 60);
        sparseIntArray2.append(18, 47);
        sparseIntArray2.append(19, 48);
        sparseIntArray2.append(14, 49);
        sparseIntArray2.append(15, 50);
        sparseIntArray2.append(16, 51);
        sparseIntArray2.append(17, 52);
        sparseIntArray2.append(25, 53);
        sparseIntArray2.append(80, 54);
        sparseIntArray2.append(65, 55);
        sparseIntArray2.append(81, 56);
        sparseIntArray2.append(66, 57);
        sparseIntArray2.append(82, 58);
        sparseIntArray2.append(67, 59);
        sparseIntArray2.append(59, 62);
        sparseIntArray2.append(58, 63);
        sparseIntArray2.append(28, 64);
        sparseIntArray2.append(105, 65);
        sparseIntArray2.append(34, 66);
        sparseIntArray2.append(106, 67);
        sparseIntArray2.append(96, 79);
        sparseIntArray2.append(1, 38);
        sparseIntArray2.append(97, 98);
        sparseIntArray2.append(95, 68);
        sparseIntArray2.append(83, 69);
        sparseIntArray2.append(68, 70);
        sparseIntArray2.append(32, 71);
        sparseIntArray2.append(30, 72);
        sparseIntArray2.append(31, 73);
        sparseIntArray2.append(33, 74);
        sparseIntArray2.append(29, 75);
        sparseIntArray2.append(98, 76);
        sparseIntArray2.append(74, 77);
        sparseIntArray2.append(107, 78);
        sparseIntArray2.append(55, 80);
        sparseIntArray2.append(54, 81);
        sparseIntArray2.append(100, 82);
        sparseIntArray2.append(104, 83);
        sparseIntArray2.append(103, 84);
        sparseIntArray2.append(102, 85);
        sparseIntArray2.append(101, 86);
        sparseIntArray2.append(94, 97);
        pIast();
    }

    public static int[] A5SV6n(Barrier barrier, String str) {
        int i;
        String[] split = str.split(",");
        Context context = barrier.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < split.length) {
            String trim = split[i2].trim();
            Object obj = null;
            try {
                i = R$id.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, f.f13353a, context.getPackageName());
            }
            if (i == 0 && barrier.isInEditMode() && (barrier.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) barrier.getParent();
                if (CtFAbx.B9tovu(trim)) {
                    HashMap hashMap = constraintLayout.f8411BIYEnU;
                    if (hashMap != null && hashMap.containsKey(trim)) {
                        obj = constraintLayout.f8411BIYEnU.get(trim);
                    }
                } else {
                    constraintLayout.getClass();
                }
                if (obj != null && (obj instanceof Integer)) {
                    i = ((Integer) obj).intValue();
                }
            }
            iArr[i3] = i;
            i2++;
            i3++;
        }
        return i3 != split.length ? Arrays.copyOf(iArr, i3) : iArr;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static A2egSU ADYaiT(Context context, AttributeSet attributeSet, boolean z) {
        int i = 1;
        A2egSU a2egSU = new A2egSU();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z ? R$styleable.f8418A5SV6n : R$styleable.f8416A2egSU);
        int[] iArr = f8295ADYaiT;
        SparseIntArray sparseIntArray = AMqCpz;
        ADYaiT aDYaiT = a2egSU.f8301A4TApA;
        AMqCpz aMqCpz = a2egSU.AMqCpz;
        C0006A5SV6n c0006A5SV6n = a2egSU.f8302A5SV6n;
        A4TApA a4TApA = a2egSU.f8303ADYaiT;
        int i2 = 3;
        if (z) {
            int indexCount = obtainStyledAttributes.getIndexCount();
            androidx.constraintlayout.widget.A4TApA a4TApA2 = new androidx.constraintlayout.widget.A4TApA();
            a4TApA2.f8284A2egSU = new int[10];
            a4TApA2.f8285A4TApA = new int[10];
            a4TApA2.f8286A5SV6n = 0;
            a4TApA2.f8287ADYaiT = new int[10];
            a4TApA2.AMqCpz = new float[10];
            a4TApA2.f8288ARc23Z = 0;
            a4TApA2.f8289ASJ6gh = new int[5];
            a4TApA2.f8290AYUAbz = new String[5];
            a4TApA2.f8291AZOQYO = 0;
            a4TApA2.f8292AZkASS = new int[4];
            a4TApA2.f8293AaHO0E = new boolean[4];
            a4TApA2.f8294AcNBzu = 0;
            c0006A5SV6n.getClass();
            a4TApA.getClass();
            aDYaiT.getClass();
            aMqCpz.getClass();
            int i3 = 0;
            while (i3 < indexCount) {
                int index = obtainStyledAttributes.getIndex(i3);
                switch (f8296ARc23Z.get(index)) {
                    case 2:
                        a4TApA2.A4TApA(2, obtainStyledAttributes.getDimensionPixelSize(index, a4TApA.f8338CASmeH));
                        i = 1;
                        break;
                    case 3:
                    case 4:
                    case 9:
                    case 10:
                    case 25:
                    case 26:
                    case 29:
                    case 30:
                    case 32:
                    case 33:
                    case 35:
                    case 36:
                    case 61:
                    case 88:
                    case 89:
                    case MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SYNC_MODE /* 90 */:
                    case MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY /* 91 */:
                    case MediaPlayer.MEDIA_PLAYER_OPTION_OUTLET_DROP_FRAME_TYPE /* 92 */:
                    default:
                        Integer.toHexString(index);
                        sparseIntArray.get(index);
                        break;
                    case 5:
                        a4TApA2.A5SV6n(5, obtainStyledAttributes.getString(index));
                        i = 1;
                        break;
                    case 6:
                        a4TApA2.A4TApA(6, obtainStyledAttributes.getDimensionPixelOffset(index, a4TApA.f8333BV3sI0));
                        i = 1;
                        break;
                    case 7:
                        a4TApA2.A4TApA(7, obtainStyledAttributes.getDimensionPixelOffset(index, a4TApA.f8334BmvVmW));
                        i = 1;
                        break;
                    case 8:
                        a4TApA2.A4TApA(8, obtainStyledAttributes.getDimensionPixelSize(index, a4TApA.f8339CNPG0E));
                        i = 1;
                        break;
                    case 11:
                        a4TApA2.A4TApA(11, obtainStyledAttributes.getDimensionPixelSize(index, a4TApA.f8345Cd8JRx));
                        i = 1;
                        break;
                    case 12:
                        a4TApA2.A4TApA(12, obtainStyledAttributes.getDimensionPixelSize(index, a4TApA.f8346CikNvS));
                        i = 1;
                        break;
                    case 13:
                        a4TApA2.A4TApA(13, obtainStyledAttributes.getDimensionPixelSize(index, a4TApA.f8342CSDoyG));
                        i = 1;
                        break;
                    case 14:
                        a4TApA2.A4TApA(14, obtainStyledAttributes.getDimensionPixelSize(index, a4TApA.f8344CcAIMM));
                        i = 1;
                        break;
                    case 15:
                        a4TApA2.A4TApA(15, obtainStyledAttributes.getDimensionPixelSize(index, a4TApA.f8347CkXcdM));
                        i = 1;
                        break;
                    case 16:
                        a4TApA2.A4TApA(16, obtainStyledAttributes.getDimensionPixelSize(index, a4TApA.f8343CTkVKb));
                        i = 1;
                        break;
                    case 17:
                        a4TApA2.A4TApA(17, obtainStyledAttributes.getDimensionPixelOffset(index, a4TApA.f8309ADYaiT));
                        i = 1;
                        break;
                    case 18:
                        a4TApA2.A4TApA(18, obtainStyledAttributes.getDimensionPixelOffset(index, a4TApA.AMqCpz));
                        i = 1;
                        break;
                    case 19:
                        a4TApA2.A2egSU(obtainStyledAttributes.getFloat(index, a4TApA.f8310ARc23Z), 19);
                        i = 1;
                        break;
                    case 20:
                        a4TApA2.A2egSU(obtainStyledAttributes.getFloat(index, a4TApA.f8327BI9f7h), 20);
                        i = 1;
                        break;
                    case 21:
                        a4TApA2.A4TApA(21, obtainStyledAttributes.getLayoutDimension(index, a4TApA.f8308A5SV6n));
                        i = 1;
                        break;
                    case 22:
                        a4TApA2.A4TApA(22, iArr[obtainStyledAttributes.getInt(index, aDYaiT.f8378A2egSU)]);
                        i = 1;
                        break;
                    case 23:
                        a4TApA2.A4TApA(23, obtainStyledAttributes.getLayoutDimension(index, a4TApA.f8307A4TApA));
                        i = 1;
                        break;
                    case 24:
                        a4TApA2.A4TApA(24, obtainStyledAttributes.getDimensionPixelSize(index, a4TApA.BpkvW3));
                        i = 1;
                        break;
                    case 27:
                        a4TApA2.A4TApA(27, obtainStyledAttributes.getInt(index, a4TApA.f8335BniPrB));
                        i = 1;
                        break;
                    case 28:
                        a4TApA2.A4TApA(28, obtainStyledAttributes.getDimensionPixelSize(index, a4TApA.f8336C2rE4F));
                        i = 1;
                        break;
                    case 31:
                        a4TApA2.A4TApA(31, obtainStyledAttributes.getDimensionPixelSize(index, a4TApA.f8340COJEAR));
                        i = 1;
                        break;
                    case 34:
                        a4TApA2.A4TApA(34, obtainStyledAttributes.getDimensionPixelSize(index, a4TApA.f8337C4FrIb));
                        i = 1;
                        break;
                    case 37:
                        a4TApA2.A2egSU(obtainStyledAttributes.getFloat(index, a4TApA.f8328BIYEnU), 37);
                        i = 1;
                        break;
                    case 38:
                        int resourceId = obtainStyledAttributes.getResourceId(index, a2egSU.f8300A2egSU);
                        a2egSU.f8300A2egSU = resourceId;
                        a4TApA2.A4TApA(38, resourceId);
                        i = 1;
                        break;
                    case 39:
                        a4TApA2.A2egSU(obtainStyledAttributes.getFloat(index, a4TApA.f8350CrfGsy), 39);
                        i = 1;
                        break;
                    case 40:
                        a4TApA2.A2egSU(obtainStyledAttributes.getFloat(index, a4TApA.f8349CqNSpT), 40);
                        i = 1;
                        break;
                    case 41:
                        a4TApA2.A4TApA(41, obtainStyledAttributes.getInt(index, a4TApA.f8351CtFAbx));
                        i = 1;
                        break;
                    case 42:
                        a4TApA2.A4TApA(42, obtainStyledAttributes.getInt(index, a4TApA.f8352CtxOCS));
                        i = 1;
                        break;
                    case 43:
                        a4TApA2.A2egSU(obtainStyledAttributes.getFloat(index, aDYaiT.f8380A5SV6n), 43);
                        i = 1;
                        break;
                    case 44:
                        a4TApA2.ADYaiT(44, true);
                        a4TApA2.A2egSU(obtainStyledAttributes.getDimension(index, aMqCpz.f8394AlLFFp), 44);
                        i = 1;
                        break;
                    case 45:
                        a4TApA2.A2egSU(obtainStyledAttributes.getFloat(index, aMqCpz.f8384A4TApA), 45);
                        i = 1;
                        break;
                    case 46:
                        a4TApA2.A2egSU(obtainStyledAttributes.getFloat(index, aMqCpz.f8385A5SV6n), 46);
                        i = 1;
                        break;
                    case 47:
                        a4TApA2.A2egSU(obtainStyledAttributes.getFloat(index, aMqCpz.f8386ADYaiT), 47);
                        i = 1;
                        break;
                    case 48:
                        a4TApA2.A2egSU(obtainStyledAttributes.getFloat(index, aMqCpz.AMqCpz), 48);
                        i = 1;
                        break;
                    case 49:
                        a4TApA2.A2egSU(obtainStyledAttributes.getDimension(index, aMqCpz.f8387ARc23Z), 49);
                        i = 1;
                        break;
                    case 50:
                        a4TApA2.A2egSU(obtainStyledAttributes.getDimension(index, aMqCpz.f8388ASJ6gh), 50);
                        i = 1;
                        break;
                    case ILivePlayer.LIVE_DATALOADER_RW_TIMEOUT /* 51 */:
                        a4TApA2.A2egSU(obtainStyledAttributes.getDimension(index, aMqCpz.f8390AZOQYO), 51);
                        i = 1;
                        break;
                    case 52:
                        a4TApA2.A2egSU(obtainStyledAttributes.getDimension(index, aMqCpz.f8391AZkASS), 52);
                        i = 1;
                        break;
                    case 53:
                        a4TApA2.A2egSU(obtainStyledAttributes.getDimension(index, aMqCpz.f8392AaHO0E), 53);
                        i = 1;
                        break;
                    case 54:
                        a4TApA2.A4TApA(54, obtainStyledAttributes.getInt(index, a4TApA.f8353D07BeM));
                        i = 1;
                        break;
                    case 55:
                        a4TApA2.A4TApA(55, obtainStyledAttributes.getInt(index, a4TApA.f8354D6DOie));
                        i = 1;
                        break;
                    case 56:
                        a4TApA2.A4TApA(56, obtainStyledAttributes.getDimensionPixelSize(index, a4TApA.f8355D6yqiO));
                        i = 1;
                        break;
                    case ILivePlayer.LIVE_PLAYER_OPTION_PLAY_URL /* 57 */:
                        a4TApA2.A4TApA(57, obtainStyledAttributes.getDimensionPixelSize(index, a4TApA.f8356D8MqeW));
                        i = 1;
                        break;
                    case 58:
                        a4TApA2.A4TApA(58, obtainStyledAttributes.getDimensionPixelSize(index, a4TApA.f8357D8cQ8b));
                        i = 1;
                        break;
                    case 59:
                        a4TApA2.A4TApA(59, obtainStyledAttributes.getDimensionPixelSize(index, a4TApA.f8358D9tr6l));
                        i = 1;
                        break;
                    case 60:
                        a4TApA2.A2egSU(obtainStyledAttributes.getFloat(index, aMqCpz.f8383A2egSU), 60);
                        i = 1;
                        break;
                    case 62:
                        a4TApA2.A4TApA(62, obtainStyledAttributes.getDimensionPixelSize(index, a4TApA.f8331BPw6Q8));
                        i = 1;
                        break;
                    case 63:
                        a4TApA2.A2egSU(obtainStyledAttributes.getFloat(index, a4TApA.f8332BTvldC), 63);
                        i = 1;
                        break;
                    case 64:
                        a4TApA2.A4TApA(64, ARc23Z(obtainStyledAttributes, index, c0006A5SV6n.f8370A2egSU));
                        i = 1;
                        break;
                    case ILivePlayer.LIVE_PLAYER_OPTION_ABR_STRATEGY /* 65 */:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            a4TApA2.A5SV6n(65, obtainStyledAttributes.getString(index));
                        } else {
                            a4TApA2.A5SV6n(65, B7CMnp.A2egSU.f1091A2egSU[obtainStyledAttributes.getInteger(index, 0)]);
                        }
                        i = 1;
                        break;
                    case 66:
                        a4TApA2.A4TApA(66, obtainStyledAttributes.getInt(index, 0));
                        i = 1;
                        break;
                    case 67:
                        a4TApA2.A2egSU(obtainStyledAttributes.getFloat(index, c0006A5SV6n.AMqCpz), 67);
                        i = 1;
                        break;
                    case 68:
                        a4TApA2.A2egSU(obtainStyledAttributes.getFloat(index, aDYaiT.f8381ADYaiT), 68);
                        i = 1;
                        break;
                    case 69:
                        a4TApA2.A2egSU(obtainStyledAttributes.getFloat(index, 1.0f), 69);
                        i = 1;
                        break;
                    case 70:
                        a4TApA2.A2egSU(obtainStyledAttributes.getFloat(index, 1.0f), 70);
                        i = 1;
                        break;
                    case 71:
                        break;
                    case 72:
                        a4TApA2.A4TApA(72, obtainStyledAttributes.getInt(index, a4TApA.f8361DRlcZ9));
                        i = 1;
                        break;
                    case 73:
                        a4TApA2.A4TApA(73, obtainStyledAttributes.getDimensionPixelSize(index, a4TApA.f8362DUi7mC));
                        i = 1;
                        break;
                    case 74:
                        a4TApA2.A5SV6n(74, obtainStyledAttributes.getString(index));
                        i = 1;
                        break;
                    case 75:
                        a4TApA2.ADYaiT(75, obtainStyledAttributes.getBoolean(index, a4TApA.Ddcejp));
                        i = 1;
                        break;
                    case 76:
                        a4TApA2.A4TApA(76, obtainStyledAttributes.getInt(index, c0006A5SV6n.f8372A5SV6n));
                        i = 1;
                        break;
                    case 77:
                        a4TApA2.A5SV6n(77, obtainStyledAttributes.getString(index));
                        i = 1;
                        break;
                    case 78:
                        a4TApA2.A4TApA(78, obtainStyledAttributes.getInt(index, aDYaiT.f8379A4TApA));
                        i = 1;
                        break;
                    case 79:
                        a4TApA2.A2egSU(obtainStyledAttributes.getFloat(index, c0006A5SV6n.f8373ADYaiT), 79);
                        i = 1;
                        break;
                    case 80:
                        a4TApA2.ADYaiT(80, obtainStyledAttributes.getBoolean(index, a4TApA.f8366DcUJf1));
                        i = 1;
                        break;
                    case 81:
                        a4TApA2.ADYaiT(81, obtainStyledAttributes.getBoolean(index, a4TApA.f8367DdagTj));
                        i = 1;
                        break;
                    case 82:
                        a4TApA2.A4TApA(82, obtainStyledAttributes.getInteger(index, c0006A5SV6n.f8371A4TApA));
                        i = 1;
                        break;
                    case 83:
                        a4TApA2.A4TApA(83, ARc23Z(obtainStyledAttributes, index, aMqCpz.f8389AYUAbz));
                        i = 1;
                        break;
                    case 84:
                        a4TApA2.A4TApA(84, obtainStyledAttributes.getInteger(index, c0006A5SV6n.f8375ASJ6gh));
                        i = 1;
                        break;
                    case 85:
                        a4TApA2.A2egSU(obtainStyledAttributes.getFloat(index, c0006A5SV6n.f8374ARc23Z), 85);
                        i = 1;
                        break;
                    case 86:
                        int i4 = obtainStyledAttributes.peekValue(index).type;
                        if (i4 == i) {
                            int resourceId2 = obtainStyledAttributes.getResourceId(index, -1);
                            c0006A5SV6n.f8377AZOQYO = resourceId2;
                            a4TApA2.A4TApA(89, resourceId2);
                            if (c0006A5SV6n.f8377AZOQYO != -1) {
                                a4TApA2.A4TApA(88, -2);
                            }
                        } else if (i4 == 3) {
                            String string = obtainStyledAttributes.getString(index);
                            c0006A5SV6n.f8376AYUAbz = string;
                            a4TApA2.A5SV6n(90, string);
                            if (c0006A5SV6n.f8376AYUAbz.indexOf("/") > 0) {
                                int resourceId3 = obtainStyledAttributes.getResourceId(index, -1);
                                c0006A5SV6n.f8377AZOQYO = resourceId3;
                                a4TApA2.A4TApA(89, resourceId3);
                                a4TApA2.A4TApA(88, -2);
                            } else {
                                a4TApA2.A4TApA(88, -1);
                            }
                        } else {
                            a4TApA2.A4TApA(88, obtainStyledAttributes.getInteger(index, c0006A5SV6n.f8377AZOQYO));
                        }
                        i = 1;
                        break;
                    case 87:
                        Integer.toHexString(index);
                        sparseIntArray.get(index);
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_DROP_FRAME /* 93 */:
                        a4TApA2.A4TApA(93, obtainStyledAttributes.getDimensionPixelSize(index, a4TApA.f8341CQhlFr));
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_SET_TRACK_VOLUME /* 94 */:
                        a4TApA2.A4TApA(94, obtainStyledAttributes.getDimensionPixelSize(index, a4TApA.f8348CmUvjW));
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_PREFER_NEAREST_SAMPLE /* 95 */:
                        ASJ6gh(a4TApA2, obtainStyledAttributes, index, 0);
                        break;
                    case 96:
                        ASJ6gh(a4TApA2, obtainStyledAttributes, index, i);
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_USE_MEDIA_CODEC_AUDIO /* 97 */:
                        a4TApA2.A4TApA(97, obtainStyledAttributes.getInt(index, a4TApA.f8368De4eam));
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_RESET_SYSTEM_VOLUME /* 98 */:
                        int i5 = BIYEnU.A2egSU.f1326BmvVmW;
                        if (obtainStyledAttributes.peekValue(index).type == i2) {
                            obtainStyledAttributes.getString(index);
                        } else {
                            a2egSU.f8300A2egSU = obtainStyledAttributes.getResourceId(index, a2egSU.f8300A2egSU);
                        }
                        break;
                    case 99:
                        a4TApA2.ADYaiT(99, obtainStyledAttributes.getBoolean(index, a4TApA.f8311ASJ6gh));
                        break;
                }
                i3 += i;
                i2 = 3;
            }
        } else {
            int indexCount2 = obtainStyledAttributes.getIndexCount();
            int i6 = 0;
            while (i6 < indexCount2) {
                int index2 = obtainStyledAttributes.getIndex(i6);
                if (index2 != i && 23 != index2 && 24 != index2) {
                    c0006A5SV6n.getClass();
                    a4TApA.getClass();
                    aDYaiT.getClass();
                    aMqCpz.getClass();
                }
                switch (sparseIntArray.get(index2)) {
                    case 1:
                        a4TApA.f8320B25kr6 = ARc23Z(obtainStyledAttributes, index2, a4TApA.f8320B25kr6);
                        break;
                    case 2:
                        a4TApA.f8338CASmeH = obtainStyledAttributes.getDimensionPixelSize(index2, a4TApA.f8338CASmeH);
                        break;
                    case 3:
                        a4TApA.f8319AzWtSf = ARc23Z(obtainStyledAttributes, index2, a4TApA.f8319AzWtSf);
                        break;
                    case 4:
                        a4TApA.f8318AmA8tU = ARc23Z(obtainStyledAttributes, index2, a4TApA.f8318AmA8tU);
                        break;
                    case 5:
                        a4TApA.f8329BJ7GGh = obtainStyledAttributes.getString(index2);
                        break;
                    case 6:
                        a4TApA.f8333BV3sI0 = obtainStyledAttributes.getDimensionPixelOffset(index2, a4TApA.f8333BV3sI0);
                        break;
                    case 7:
                        a4TApA.f8334BmvVmW = obtainStyledAttributes.getDimensionPixelOffset(index2, a4TApA.f8334BmvVmW);
                        break;
                    case 8:
                        a4TApA.f8339CNPG0E = obtainStyledAttributes.getDimensionPixelSize(index2, a4TApA.f8339CNPG0E);
                        break;
                    case 9:
                        a4TApA.f8326BChYOn = ARc23Z(obtainStyledAttributes, index2, a4TApA.f8326BChYOn);
                        break;
                    case 10:
                        a4TApA.f8325B9tovu = ARc23Z(obtainStyledAttributes, index2, a4TApA.f8325B9tovu);
                        break;
                    case 11:
                        a4TApA.f8345Cd8JRx = obtainStyledAttributes.getDimensionPixelSize(index2, a4TApA.f8345Cd8JRx);
                        break;
                    case 12:
                        a4TApA.f8346CikNvS = obtainStyledAttributes.getDimensionPixelSize(index2, a4TApA.f8346CikNvS);
                        break;
                    case 13:
                        a4TApA.f8342CSDoyG = obtainStyledAttributes.getDimensionPixelSize(index2, a4TApA.f8342CSDoyG);
                        break;
                    case 14:
                        a4TApA.f8344CcAIMM = obtainStyledAttributes.getDimensionPixelSize(index2, a4TApA.f8344CcAIMM);
                        break;
                    case 15:
                        a4TApA.f8347CkXcdM = obtainStyledAttributes.getDimensionPixelSize(index2, a4TApA.f8347CkXcdM);
                        break;
                    case 16:
                        a4TApA.f8343CTkVKb = obtainStyledAttributes.getDimensionPixelSize(index2, a4TApA.f8343CTkVKb);
                        break;
                    case 17:
                        a4TApA.f8309ADYaiT = obtainStyledAttributes.getDimensionPixelOffset(index2, a4TApA.f8309ADYaiT);
                        break;
                    case 18:
                        a4TApA.AMqCpz = obtainStyledAttributes.getDimensionPixelOffset(index2, a4TApA.AMqCpz);
                        break;
                    case 19:
                        a4TApA.f8310ARc23Z = obtainStyledAttributes.getFloat(index2, a4TApA.f8310ARc23Z);
                        break;
                    case 20:
                        a4TApA.f8327BI9f7h = obtainStyledAttributes.getFloat(index2, a4TApA.f8327BI9f7h);
                        break;
                    case 21:
                        a4TApA.f8308A5SV6n = obtainStyledAttributes.getLayoutDimension(index2, a4TApA.f8308A5SV6n);
                        break;
                    case 22:
                        int i7 = obtainStyledAttributes.getInt(index2, aDYaiT.f8378A2egSU);
                        aDYaiT.f8378A2egSU = i7;
                        aDYaiT.f8378A2egSU = iArr[i7];
                        break;
                    case 23:
                        a4TApA.f8307A4TApA = obtainStyledAttributes.getLayoutDimension(index2, a4TApA.f8307A4TApA);
                        break;
                    case 24:
                        a4TApA.BpkvW3 = obtainStyledAttributes.getDimensionPixelSize(index2, a4TApA.BpkvW3);
                        break;
                    case 25:
                        a4TApA.f8312AYUAbz = ARc23Z(obtainStyledAttributes, index2, a4TApA.f8312AYUAbz);
                        break;
                    case 26:
                        a4TApA.f8313AZOQYO = ARc23Z(obtainStyledAttributes, index2, a4TApA.f8313AZOQYO);
                        break;
                    case 27:
                        a4TApA.f8335BniPrB = obtainStyledAttributes.getInt(index2, a4TApA.f8335BniPrB);
                        break;
                    case 28:
                        a4TApA.f8336C2rE4F = obtainStyledAttributes.getDimensionPixelSize(index2, a4TApA.f8336C2rE4F);
                        break;
                    case 29:
                        a4TApA.f8314AZkASS = ARc23Z(obtainStyledAttributes, index2, a4TApA.f8314AZkASS);
                        break;
                    case 30:
                        a4TApA.f8315AaHO0E = ARc23Z(obtainStyledAttributes, index2, a4TApA.f8315AaHO0E);
                        break;
                    case 31:
                        a4TApA.f8340COJEAR = obtainStyledAttributes.getDimensionPixelSize(index2, a4TApA.f8340COJEAR);
                        break;
                    case 32:
                        a4TApA.f8323B4ZgIw = ARc23Z(obtainStyledAttributes, index2, a4TApA.f8323B4ZgIw);
                        break;
                    case 33:
                        a4TApA.f8324B7CMnp = ARc23Z(obtainStyledAttributes, index2, a4TApA.f8324B7CMnp);
                        break;
                    case 34:
                        a4TApA.f8337C4FrIb = obtainStyledAttributes.getDimensionPixelSize(index2, a4TApA.f8337C4FrIb);
                        break;
                    case 35:
                        a4TApA.f8317AlLFFp = ARc23Z(obtainStyledAttributes, index2, a4TApA.f8317AlLFFp);
                        break;
                    case 36:
                        a4TApA.f8316AcNBzu = ARc23Z(obtainStyledAttributes, index2, a4TApA.f8316AcNBzu);
                        break;
                    case 37:
                        a4TApA.f8328BIYEnU = obtainStyledAttributes.getFloat(index2, a4TApA.f8328BIYEnU);
                        break;
                    case 38:
                        a2egSU.f8300A2egSU = obtainStyledAttributes.getResourceId(index2, a2egSU.f8300A2egSU);
                        break;
                    case 39:
                        a4TApA.f8350CrfGsy = obtainStyledAttributes.getFloat(index2, a4TApA.f8350CrfGsy);
                        break;
                    case 40:
                        a4TApA.f8349CqNSpT = obtainStyledAttributes.getFloat(index2, a4TApA.f8349CqNSpT);
                        break;
                    case 41:
                        a4TApA.f8351CtFAbx = obtainStyledAttributes.getInt(index2, a4TApA.f8351CtFAbx);
                        break;
                    case 42:
                        a4TApA.f8352CtxOCS = obtainStyledAttributes.getInt(index2, a4TApA.f8352CtxOCS);
                        break;
                    case 43:
                        aDYaiT.f8380A5SV6n = obtainStyledAttributes.getFloat(index2, aDYaiT.f8380A5SV6n);
                        break;
                    case 44:
                        aMqCpz.f8393AcNBzu = true;
                        aMqCpz.f8394AlLFFp = obtainStyledAttributes.getDimension(index2, aMqCpz.f8394AlLFFp);
                        break;
                    case 45:
                        aMqCpz.f8384A4TApA = obtainStyledAttributes.getFloat(index2, aMqCpz.f8384A4TApA);
                        break;
                    case 46:
                        aMqCpz.f8385A5SV6n = obtainStyledAttributes.getFloat(index2, aMqCpz.f8385A5SV6n);
                        break;
                    case 47:
                        aMqCpz.f8386ADYaiT = obtainStyledAttributes.getFloat(index2, aMqCpz.f8386ADYaiT);
                        break;
                    case 48:
                        aMqCpz.AMqCpz = obtainStyledAttributes.getFloat(index2, aMqCpz.AMqCpz);
                        break;
                    case 49:
                        aMqCpz.f8387ARc23Z = obtainStyledAttributes.getDimension(index2, aMqCpz.f8387ARc23Z);
                        break;
                    case 50:
                        aMqCpz.f8388ASJ6gh = obtainStyledAttributes.getDimension(index2, aMqCpz.f8388ASJ6gh);
                        break;
                    case ILivePlayer.LIVE_DATALOADER_RW_TIMEOUT /* 51 */:
                        aMqCpz.f8390AZOQYO = obtainStyledAttributes.getDimension(index2, aMqCpz.f8390AZOQYO);
                        break;
                    case 52:
                        aMqCpz.f8391AZkASS = obtainStyledAttributes.getDimension(index2, aMqCpz.f8391AZkASS);
                        break;
                    case 53:
                        aMqCpz.f8392AaHO0E = obtainStyledAttributes.getDimension(index2, aMqCpz.f8392AaHO0E);
                        break;
                    case 54:
                        a4TApA.f8353D07BeM = obtainStyledAttributes.getInt(index2, a4TApA.f8353D07BeM);
                        break;
                    case 55:
                        a4TApA.f8354D6DOie = obtainStyledAttributes.getInt(index2, a4TApA.f8354D6DOie);
                        break;
                    case 56:
                        a4TApA.f8355D6yqiO = obtainStyledAttributes.getDimensionPixelSize(index2, a4TApA.f8355D6yqiO);
                        break;
                    case ILivePlayer.LIVE_PLAYER_OPTION_PLAY_URL /* 57 */:
                        a4TApA.f8356D8MqeW = obtainStyledAttributes.getDimensionPixelSize(index2, a4TApA.f8356D8MqeW);
                        break;
                    case 58:
                        a4TApA.f8357D8cQ8b = obtainStyledAttributes.getDimensionPixelSize(index2, a4TApA.f8357D8cQ8b);
                        break;
                    case 59:
                        a4TApA.f8358D9tr6l = obtainStyledAttributes.getDimensionPixelSize(index2, a4TApA.f8358D9tr6l);
                        break;
                    case 60:
                        aMqCpz.f8383A2egSU = obtainStyledAttributes.getFloat(index2, aMqCpz.f8383A2egSU);
                        break;
                    case 61:
                        a4TApA.f8330BNL6CD = ARc23Z(obtainStyledAttributes, index2, a4TApA.f8330BNL6CD);
                        break;
                    case 62:
                        a4TApA.f8331BPw6Q8 = obtainStyledAttributes.getDimensionPixelSize(index2, a4TApA.f8331BPw6Q8);
                        break;
                    case 63:
                        a4TApA.f8332BTvldC = obtainStyledAttributes.getFloat(index2, a4TApA.f8332BTvldC);
                        break;
                    case 64:
                        c0006A5SV6n.f8370A2egSU = ARc23Z(obtainStyledAttributes, index2, c0006A5SV6n.f8370A2egSU);
                        break;
                    case ILivePlayer.LIVE_PLAYER_OPTION_ABR_STRATEGY /* 65 */:
                        if (obtainStyledAttributes.peekValue(index2).type != 3) {
                            String str = B7CMnp.A2egSU.f1091A2egSU[obtainStyledAttributes.getInteger(index2, 0)];
                            c0006A5SV6n.getClass();
                            break;
                        } else {
                            obtainStyledAttributes.getString(index2);
                            c0006A5SV6n.getClass();
                            break;
                        }
                    case 66:
                        obtainStyledAttributes.getInt(index2, 0);
                        c0006A5SV6n.getClass();
                        break;
                    case 67:
                        c0006A5SV6n.AMqCpz = obtainStyledAttributes.getFloat(index2, c0006A5SV6n.AMqCpz);
                        break;
                    case 68:
                        aDYaiT.f8381ADYaiT = obtainStyledAttributes.getFloat(index2, aDYaiT.f8381ADYaiT);
                        break;
                    case 69:
                        a4TApA.f8359DAk1zC = obtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 70:
                        a4TApA.f8360DG07BK = obtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 71:
                        break;
                    case 72:
                        a4TApA.f8361DRlcZ9 = obtainStyledAttributes.getInt(index2, a4TApA.f8361DRlcZ9);
                        break;
                    case 73:
                        a4TApA.f8362DUi7mC = obtainStyledAttributes.getDimensionPixelSize(index2, a4TApA.f8362DUi7mC);
                        break;
                    case 74:
                        a4TApA.DXuj49 = obtainStyledAttributes.getString(index2);
                        break;
                    case 75:
                        a4TApA.Ddcejp = obtainStyledAttributes.getBoolean(index2, a4TApA.Ddcejp);
                        break;
                    case 76:
                        c0006A5SV6n.f8372A5SV6n = obtainStyledAttributes.getInt(index2, c0006A5SV6n.f8372A5SV6n);
                        break;
                    case 77:
                        a4TApA.f8365DaOi9o = obtainStyledAttributes.getString(index2);
                        break;
                    case 78:
                        aDYaiT.f8379A4TApA = obtainStyledAttributes.getInt(index2, aDYaiT.f8379A4TApA);
                        break;
                    case 79:
                        c0006A5SV6n.f8373ADYaiT = obtainStyledAttributes.getFloat(index2, c0006A5SV6n.f8373ADYaiT);
                        break;
                    case 80:
                        a4TApA.f8366DcUJf1 = obtainStyledAttributes.getBoolean(index2, a4TApA.f8366DcUJf1);
                        break;
                    case 81:
                        a4TApA.f8367DdagTj = obtainStyledAttributes.getBoolean(index2, a4TApA.f8367DdagTj);
                        break;
                    case 82:
                        c0006A5SV6n.f8371A4TApA = obtainStyledAttributes.getInteger(index2, c0006A5SV6n.f8371A4TApA);
                        break;
                    case 83:
                        aMqCpz.f8389AYUAbz = ARc23Z(obtainStyledAttributes, index2, aMqCpz.f8389AYUAbz);
                        break;
                    case 84:
                        c0006A5SV6n.f8375ASJ6gh = obtainStyledAttributes.getInteger(index2, c0006A5SV6n.f8375ASJ6gh);
                        break;
                    case 85:
                        c0006A5SV6n.f8374ARc23Z = obtainStyledAttributes.getFloat(index2, c0006A5SV6n.f8374ARc23Z);
                        break;
                    case 86:
                        int i8 = obtainStyledAttributes.peekValue(index2).type;
                        if (i8 == 1) {
                            c0006A5SV6n.f8377AZOQYO = obtainStyledAttributes.getResourceId(index2, -1);
                        } else if (i8 == 3) {
                            String string2 = obtainStyledAttributes.getString(index2);
                            c0006A5SV6n.f8376AYUAbz = string2;
                            if (string2.indexOf("/") > 0) {
                                c0006A5SV6n.f8377AZOQYO = obtainStyledAttributes.getResourceId(index2, -1);
                            }
                        } else {
                            obtainStyledAttributes.getInteger(index2, c0006A5SV6n.f8377AZOQYO);
                        }
                        break;
                    case 87:
                        Integer.toHexString(index2);
                        sparseIntArray.get(index2);
                        break;
                    case 88:
                    case 89:
                    case MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SYNC_MODE /* 90 */:
                    default:
                        Integer.toHexString(index2);
                        sparseIntArray.get(index2);
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY /* 91 */:
                        a4TApA.f8321B2KMhB = ARc23Z(obtainStyledAttributes, index2, a4TApA.f8321B2KMhB);
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_OUTLET_DROP_FRAME_TYPE /* 92 */:
                        a4TApA.f8322B3GDIM = ARc23Z(obtainStyledAttributes, index2, a4TApA.f8322B3GDIM);
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_DROP_FRAME /* 93 */:
                        a4TApA.f8341CQhlFr = obtainStyledAttributes.getDimensionPixelSize(index2, a4TApA.f8341CQhlFr);
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_SET_TRACK_VOLUME /* 94 */:
                        a4TApA.f8348CmUvjW = obtainStyledAttributes.getDimensionPixelSize(index2, a4TApA.f8348CmUvjW);
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_PREFER_NEAREST_SAMPLE /* 95 */:
                        ASJ6gh(a4TApA, obtainStyledAttributes, index2, 0);
                        break;
                    case 96:
                        ASJ6gh(a4TApA, obtainStyledAttributes, index2, 1);
                        break;
                    case MediaPlayer.MEDIA_PLAYER_OPTION_USE_MEDIA_CODEC_AUDIO /* 97 */:
                        a4TApA.f8368De4eam = obtainStyledAttributes.getInt(index2, a4TApA.f8368De4eam);
                        break;
                }
                i6++;
                i = 1;
            }
            if (a4TApA.DXuj49 != null) {
                a4TApA.f8364DXnQ0V = null;
            }
        }
        obtainStyledAttributes.recycle();
        return a2egSU;
    }

    public static int ARc23Z(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
    
        if (r8 == (-1)) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void ASJ6gh(java.lang.Object r7, android.content.res.TypedArray r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.A5SV6n.ASJ6gh(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void AYUAbz(BJ7GGh.ADYaiT aDYaiT, String str) {
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i = -1;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                i = substring.equalsIgnoreCase("W") ? 0 : substring.equalsIgnoreCase("H") ? 1 : -1;
                r2 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            try {
                if (indexOf2 < 0 || indexOf2 >= length - 1) {
                    String substring2 = str.substring(r2);
                    if (substring2.length() > 0) {
                        Float.parseFloat(substring2);
                    }
                } else {
                    String substring3 = str.substring(r2, indexOf2);
                    String substring4 = str.substring(indexOf2 + 1);
                    if (substring3.length() > 0 && substring4.length() > 0) {
                        float parseFloat = Float.parseFloat(substring3);
                        float parseFloat2 = Float.parseFloat(substring4);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            if (i == 1) {
                                Math.abs(parseFloat2 / parseFloat);
                            } else {
                                Math.abs(parseFloat / parseFloat2);
                            }
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        aDYaiT.f1373C2rE4F = str;
    }

    private static /* synthetic */ void pIast() {
        char[] charArray = "Û×Õ\u0096ßÙÕÝ\u0096Ú×Á\u0096ËÐÝÔÔ\u0096òÖÑúÊÑÜßÝ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 184);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÛÔÑÖÑÌ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 184);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashMap hashMap = this.f8299A5SV6n;
        HashSet hashSet = new HashSet(hashMap.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!hashMap.containsKey(Integer.valueOf(id))) {
                try {
                    childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                }
            } else {
                if (this.f8298A4TApA && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1 && hashMap.containsKey(Integer.valueOf(id))) {
                    hashSet.remove(Integer.valueOf(id));
                    A2egSU a2egSU = (A2egSU) hashMap.get(Integer.valueOf(id));
                    if (a2egSU != null) {
                        if (childAt instanceof Barrier) {
                            A4TApA a4TApA = a2egSU.f8303ADYaiT;
                            a4TApA.f8363DV2E8K = 1;
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            barrier.setType(a4TApA.f8361DRlcZ9);
                            barrier.setMargin(a4TApA.f8362DUi7mC);
                            barrier.setAllowsGoneWidget(a4TApA.Ddcejp);
                            int[] iArr = a4TApA.f8364DXnQ0V;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = a4TApA.DXuj49;
                                if (str != null) {
                                    int[] A5SV6n2 = A5SV6n(barrier, str);
                                    a4TApA.f8364DXnQ0V = A5SV6n2;
                                    barrier.setReferencedIds(A5SV6n2);
                                }
                            }
                        }
                        BJ7GGh.ADYaiT aDYaiT = (BJ7GGh.ADYaiT) childAt.getLayoutParams();
                        aDYaiT.A2egSU();
                        a2egSU.A2egSU(aDYaiT);
                        HashMap hashMap2 = a2egSU.f8304ARc23Z;
                        Class<?> cls = childAt.getClass();
                        for (String str2 : hashMap2.keySet()) {
                            BJ7GGh.A4TApA a4TApA2 = (BJ7GGh.A4TApA) hashMap2.get(str2);
                            if (!a4TApA2.f1336A2egSU) {
                                str2 = CtFAbx.BChYOn("set", str2);
                            }
                            try {
                                int ordinal = a4TApA2.f1337A4TApA.ordinal();
                                Class<?> cls2 = Float.TYPE;
                                Class<?> cls3 = Integer.TYPE;
                                switch (ordinal) {
                                    case 0:
                                        cls.getMethod(str2, cls3).invoke(childAt, Integer.valueOf(a4TApA2.f1338A5SV6n));
                                        break;
                                    case 1:
                                        cls.getMethod(str2, cls2).invoke(childAt, Float.valueOf(a4TApA2.f1339ADYaiT));
                                        break;
                                    case 2:
                                        cls.getMethod(str2, cls3).invoke(childAt, Integer.valueOf(a4TApA2.f1341ASJ6gh));
                                        break;
                                    case 3:
                                        Method method = cls.getMethod(str2, Drawable.class);
                                        ColorDrawable colorDrawable = new ColorDrawable();
                                        colorDrawable.setColor(a4TApA2.f1341ASJ6gh);
                                        method.invoke(childAt, colorDrawable);
                                        break;
                                    case 4:
                                        cls.getMethod(str2, CharSequence.class).invoke(childAt, a4TApA2.AMqCpz);
                                        break;
                                    case 5:
                                        cls.getMethod(str2, Boolean.TYPE).invoke(childAt, Boolean.valueOf(a4TApA2.f1340ARc23Z));
                                        break;
                                    case 6:
                                        cls.getMethod(str2, cls2).invoke(childAt, Float.valueOf(a4TApA2.f1339ADYaiT));
                                        break;
                                    case 7:
                                        cls.getMethod(str2, cls3).invoke(childAt, Integer.valueOf(a4TApA2.f1338A5SV6n));
                                        break;
                                }
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (NoSuchMethodException e2) {
                                e2.getMessage();
                            } catch (InvocationTargetException e3) {
                                e3.printStackTrace();
                            }
                        }
                        childAt.setLayoutParams(aDYaiT);
                        ADYaiT aDYaiT2 = a2egSU.f8301A4TApA;
                        if (aDYaiT2.f8379A4TApA == 0) {
                            childAt.setVisibility(aDYaiT2.f8378A2egSU);
                        }
                        childAt.setAlpha(aDYaiT2.f8380A5SV6n);
                        AMqCpz aMqCpz = a2egSU.AMqCpz;
                        childAt.setRotation(aMqCpz.f8383A2egSU);
                        childAt.setRotationX(aMqCpz.f8384A4TApA);
                        childAt.setRotationY(aMqCpz.f8385A5SV6n);
                        childAt.setScaleX(aMqCpz.f8386ADYaiT);
                        childAt.setScaleY(aMqCpz.AMqCpz);
                        if (aMqCpz.f8389AYUAbz != -1) {
                            if (((View) childAt.getParent()).findViewById(aMqCpz.f8389AYUAbz) != null) {
                                float bottom = (r7.getBottom() + r7.getTop()) / 2.0f;
                                float right = (r7.getRight() + r7.getLeft()) / 2.0f;
                                if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                    childAt.setPivotX(right - childAt.getLeft());
                                    childAt.setPivotY(bottom - childAt.getTop());
                                }
                            }
                        } else {
                            if (!Float.isNaN(aMqCpz.f8387ARc23Z)) {
                                childAt.setPivotX(aMqCpz.f8387ARc23Z);
                            }
                            if (!Float.isNaN(aMqCpz.f8388ASJ6gh)) {
                                childAt.setPivotY(aMqCpz.f8388ASJ6gh);
                            }
                        }
                        childAt.setTranslationX(aMqCpz.f8390AZOQYO);
                        childAt.setTranslationY(aMqCpz.f8391AZkASS);
                        childAt.setTranslationZ(aMqCpz.f8392AaHO0E);
                        if (aMqCpz.f8393AcNBzu) {
                            childAt.setElevation(aMqCpz.f8394AlLFFp);
                        }
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            A2egSU a2egSU2 = (A2egSU) hashMap.get(num);
            if (a2egSU2 != null) {
                A4TApA a4TApA3 = a2egSU2.f8303ADYaiT;
                if (a4TApA3.f8363DV2E8K == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    int[] iArr2 = a4TApA3.f8364DXnQ0V;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str3 = a4TApA3.DXuj49;
                        if (str3 != null) {
                            int[] A5SV6n3 = A5SV6n(barrier2, str3);
                            a4TApA3.f8364DXnQ0V = A5SV6n3;
                            barrier2.setReferencedIds(A5SV6n3);
                        }
                    }
                    barrier2.setType(a4TApA3.f8361DRlcZ9);
                    barrier2.setMargin(a4TApA3.f8362DUi7mC);
                    BJ7GGh.ADYaiT A2egSU2 = ConstraintLayout.A2egSU();
                    barrier2.AZOQYO();
                    a2egSU2.A2egSU(A2egSU2);
                    constraintLayout.addView(barrier2, A2egSU2);
                }
                if (a4TApA3.f8306A2egSU) {
                    View azoqyo = new AZOQYO(constraintLayout.getContext());
                    azoqyo.setId(num.intValue());
                    BJ7GGh.ADYaiT A2egSU3 = ConstraintLayout.A2egSU();
                    a2egSU2.A2egSU(A2egSU3);
                    constraintLayout.addView(azoqyo, A2egSU3);
                }
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt2 = constraintLayout.getChildAt(i2);
            if (childAt2 instanceof androidx.constraintlayout.widget.A2egSU) {
                ((androidx.constraintlayout.widget.A2egSU) childAt2).AMqCpz(constraintLayout);
            }
        }
    }

    public final void A4TApA(ConstraintLayout constraintLayout) {
        int i;
        int i2;
        A5SV6n a5SV6n = this;
        int childCount = constraintLayout.getChildCount();
        HashMap hashMap = a5SV6n.f8299A5SV6n;
        hashMap.clear();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = constraintLayout.getChildAt(i3);
            BJ7GGh.ADYaiT aDYaiT = (BJ7GGh.ADYaiT) childAt.getLayoutParams();
            int id = childAt.getId();
            if (a5SV6n.f8298A4TApA && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!hashMap.containsKey(Integer.valueOf(id))) {
                hashMap.put(Integer.valueOf(id), new A2egSU());
            }
            A2egSU a2egSU = (A2egSU) hashMap.get(Integer.valueOf(id));
            if (a2egSU == null) {
                i = childCount;
            } else {
                HashMap hashMap2 = a5SV6n.f8297A2egSU;
                HashMap hashMap3 = new HashMap();
                Class<?> cls = childAt.getClass();
                for (String str : hashMap2.keySet()) {
                    BJ7GGh.A4TApA a4TApA = (BJ7GGh.A4TApA) hashMap2.get(str);
                    try {
                        if (str.equals("BackgroundColor")) {
                            hashMap3.put(str, new BJ7GGh.A4TApA(a4TApA, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                            i2 = childCount;
                        } else {
                            i2 = childCount;
                            try {
                                hashMap3.put(str, new BJ7GGh.A4TApA(a4TApA, cls.getMethod("getMap" + str, new Class[0]).invoke(childAt, new Object[0])));
                            } catch (IllegalAccessException e) {
                                e = e;
                                e.printStackTrace();
                                childCount = i2;
                            } catch (NoSuchMethodException e2) {
                                e = e2;
                                e.printStackTrace();
                                childCount = i2;
                            } catch (InvocationTargetException e3) {
                                e = e3;
                                e.printStackTrace();
                                childCount = i2;
                            }
                        }
                    } catch (IllegalAccessException e4) {
                        e = e4;
                        i2 = childCount;
                    } catch (NoSuchMethodException e5) {
                        e = e5;
                        i2 = childCount;
                    } catch (InvocationTargetException e6) {
                        e = e6;
                        i2 = childCount;
                    }
                    childCount = i2;
                }
                i = childCount;
                a2egSU.f8304ARc23Z = hashMap3;
                a2egSU.f8300A2egSU = id;
                int i4 = aDYaiT.AMqCpz;
                A4TApA a4TApA2 = a2egSU.f8303ADYaiT;
                a4TApA2.f8312AYUAbz = i4;
                a4TApA2.f8313AZOQYO = aDYaiT.f1347ARc23Z;
                a4TApA2.f8314AZkASS = aDYaiT.f1348ASJ6gh;
                a4TApA2.f8315AaHO0E = aDYaiT.f1349AYUAbz;
                a4TApA2.f8316AcNBzu = aDYaiT.f1350AZOQYO;
                a4TApA2.f8317AlLFFp = aDYaiT.f1351AZkASS;
                a4TApA2.f8318AmA8tU = aDYaiT.f1352AaHO0E;
                a4TApA2.f8319AzWtSf = aDYaiT.f1353AcNBzu;
                a4TApA2.f8320B25kr6 = aDYaiT.f1354AlLFFp;
                a4TApA2.f8321B2KMhB = aDYaiT.f1355AmA8tU;
                a4TApA2.f8322B3GDIM = aDYaiT.f1356AzWtSf;
                a4TApA2.f8323B4ZgIw = aDYaiT.f1360B4ZgIw;
                a4TApA2.f8324B7CMnp = aDYaiT.f1361B7CMnp;
                a4TApA2.f8325B9tovu = aDYaiT.f1362B9tovu;
                a4TApA2.f8326BChYOn = aDYaiT.f1363BChYOn;
                a4TApA2.f8327BI9f7h = aDYaiT.f1372BniPrB;
                a4TApA2.f8328BIYEnU = aDYaiT.BpkvW3;
                a4TApA2.f8329BJ7GGh = aDYaiT.f1373C2rE4F;
                a4TApA2.f8330BNL6CD = aDYaiT.f1357B25kr6;
                a4TApA2.f8331BPw6Q8 = aDYaiT.f1358B2KMhB;
                a4TApA2.f8332BTvldC = aDYaiT.f1359B3GDIM;
                a4TApA2.f8333BV3sI0 = aDYaiT.f1386CqNSpT;
                a4TApA2.f8334BmvVmW = aDYaiT.f1387CrfGsy;
                a4TApA2.f8335BniPrB = aDYaiT.f1388CtFAbx;
                a4TApA2.f8310ARc23Z = aDYaiT.f1345A5SV6n;
                a4TApA2.f8309ADYaiT = aDYaiT.f1343A2egSU;
                a4TApA2.AMqCpz = aDYaiT.f1344A4TApA;
                a4TApA2.f8307A4TApA = ((ViewGroup.MarginLayoutParams) aDYaiT).width;
                a4TApA2.f8308A5SV6n = ((ViewGroup.MarginLayoutParams) aDYaiT).height;
                a4TApA2.BpkvW3 = ((ViewGroup.MarginLayoutParams) aDYaiT).leftMargin;
                a4TApA2.f8336C2rE4F = ((ViewGroup.MarginLayoutParams) aDYaiT).rightMargin;
                a4TApA2.f8337C4FrIb = ((ViewGroup.MarginLayoutParams) aDYaiT).topMargin;
                a4TApA2.f8338CASmeH = ((ViewGroup.MarginLayoutParams) aDYaiT).bottomMargin;
                a4TApA2.f8341CQhlFr = aDYaiT.f1371BmvVmW;
                a4TApA2.f8349CqNSpT = aDYaiT.f1375CASmeH;
                a4TApA2.f8350CrfGsy = aDYaiT.f1374C4FrIb;
                a4TApA2.f8352CtxOCS = aDYaiT.f1377COJEAR;
                a4TApA2.f8351CtFAbx = aDYaiT.f1376CNPG0E;
                a4TApA2.f8366DcUJf1 = aDYaiT.f1389CtxOCS;
                a4TApA2.f8367DdagTj = aDYaiT.f1390D07BeM;
                a4TApA2.f8353D07BeM = aDYaiT.f1378CQhlFr;
                a4TApA2.f8354D6DOie = aDYaiT.f1379CSDoyG;
                a4TApA2.f8355D6yqiO = aDYaiT.f1382Cd8JRx;
                a4TApA2.f8356D8MqeW = aDYaiT.f1383CikNvS;
                a4TApA2.f8357D8cQ8b = aDYaiT.f1380CTkVKb;
                a4TApA2.f8358D9tr6l = aDYaiT.f1381CcAIMM;
                a4TApA2.f8359DAk1zC = aDYaiT.f1384CkXcdM;
                a4TApA2.f8360DG07BK = aDYaiT.f1385CmUvjW;
                a4TApA2.f8365DaOi9o = aDYaiT.f1391D6DOie;
                a4TApA2.f8343CTkVKb = aDYaiT.f1365BIYEnU;
                a4TApA2.f8345Cd8JRx = aDYaiT.f1367BNL6CD;
                a4TApA2.f8342CSDoyG = aDYaiT.f1364BI9f7h;
                a4TApA2.f8344CcAIMM = aDYaiT.f1366BJ7GGh;
                a4TApA2.f8347CkXcdM = aDYaiT.f1368BPw6Q8;
                a4TApA2.f8346CikNvS = aDYaiT.f1369BTvldC;
                a4TApA2.f8348CmUvjW = aDYaiT.f1370BV3sI0;
                a4TApA2.f8368De4eam = aDYaiT.f1392D6yqiO;
                a4TApA2.f8339CNPG0E = aDYaiT.getMarginEnd();
                a4TApA2.f8340COJEAR = aDYaiT.getMarginStart();
                int visibility = childAt.getVisibility();
                ADYaiT aDYaiT2 = a2egSU.f8301A4TApA;
                aDYaiT2.f8378A2egSU = visibility;
                aDYaiT2.f8380A5SV6n = childAt.getAlpha();
                float rotation = childAt.getRotation();
                AMqCpz aMqCpz = a2egSU.AMqCpz;
                aMqCpz.f8383A2egSU = rotation;
                aMqCpz.f8384A4TApA = childAt.getRotationX();
                aMqCpz.f8385A5SV6n = childAt.getRotationY();
                aMqCpz.f8386ADYaiT = childAt.getScaleX();
                aMqCpz.AMqCpz = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    aMqCpz.f8387ARc23Z = pivotX;
                    aMqCpz.f8388ASJ6gh = pivotY;
                }
                aMqCpz.f8390AZOQYO = childAt.getTranslationX();
                aMqCpz.f8391AZkASS = childAt.getTranslationY();
                aMqCpz.f8392AaHO0E = childAt.getTranslationZ();
                if (aMqCpz.f8393AcNBzu) {
                    aMqCpz.f8394AlLFFp = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    a4TApA2.Ddcejp = barrier.getAllowsGoneWidget();
                    a4TApA2.f8364DXnQ0V = barrier.getReferencedIds();
                    a4TApA2.f8361DRlcZ9 = barrier.getType();
                    a4TApA2.f8362DUi7mC = barrier.getMargin();
                }
            }
            i3++;
            a5SV6n = this;
            childCount = i;
        }
    }

    public final void AMqCpz(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    A2egSU ADYaiT2 = ADYaiT(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        ADYaiT2.f8303ADYaiT.f8306A2egSU = true;
                    }
                    this.f8299A5SV6n.put(Integer.valueOf(ADYaiT2.f8300A2egSU), ADYaiT2);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }
}
