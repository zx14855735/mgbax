package androidx.constraintlayout.widget;

import BChYOn.ARc23Z;
import BChYOn.ASJ6gh;
import BJ7GGh.ADYaiT;
import BJ7GGh.AMqCpz;
import BJ7GGh.AYUAbz;
import BJ7GGh.AZOQYO;
import BJ7GGh.AZkASS;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: BV3sI0, reason: collision with root package name */
    public static AZkASS f8398BV3sI0;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final SparseArray f8399AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ArrayList f8400AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final ASJ6gh f8401AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f8402AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f8403B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f8404B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f8405B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f8406B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public int f8407B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public A5SV6n f8408B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public K1Z3yj.A2egSU f8409BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public int f8410BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public HashMap f8411BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final SparseArray f8412BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public final AMqCpz f8413BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public int f8414BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public int f8415BTvldC;

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8399AcNBzu = new SparseArray();
        this.f8400AlLFFp = new ArrayList(4);
        this.f8401AmA8tU = new ASJ6gh();
        this.f8402AzWtSf = 0;
        this.f8403B25kr6 = 0;
        this.f8404B2KMhB = Integer.MAX_VALUE;
        this.f8405B3GDIM = Integer.MAX_VALUE;
        this.f8406B4ZgIw = true;
        this.f8407B7CMnp = 257;
        this.f8408B9tovu = null;
        this.f8409BChYOn = null;
        this.f8410BI9f7h = -1;
        this.f8411BIYEnU = new HashMap();
        this.f8412BJ7GGh = new SparseArray();
        this.f8413BNL6CD = new AMqCpz(this, this);
        this.f8414BPw6Q8 = 0;
        this.f8415BTvldC = 0;
        A5SV6n(attributeSet, 0);
    }

    public static ADYaiT A2egSU() {
        ADYaiT aDYaiT = new ADYaiT(-2, -2);
        aDYaiT.f1343A2egSU = -1;
        aDYaiT.f1344A4TApA = -1;
        aDYaiT.f1345A5SV6n = -1.0f;
        aDYaiT.f1346ADYaiT = true;
        aDYaiT.AMqCpz = -1;
        aDYaiT.f1347ARc23Z = -1;
        aDYaiT.f1348ASJ6gh = -1;
        aDYaiT.f1349AYUAbz = -1;
        aDYaiT.f1350AZOQYO = -1;
        aDYaiT.f1351AZkASS = -1;
        aDYaiT.f1352AaHO0E = -1;
        aDYaiT.f1353AcNBzu = -1;
        aDYaiT.f1354AlLFFp = -1;
        aDYaiT.f1355AmA8tU = -1;
        aDYaiT.f1356AzWtSf = -1;
        aDYaiT.f1357B25kr6 = -1;
        aDYaiT.f1358B2KMhB = 0;
        aDYaiT.f1359B3GDIM = 0.0f;
        aDYaiT.f1360B4ZgIw = -1;
        aDYaiT.f1361B7CMnp = -1;
        aDYaiT.f1362B9tovu = -1;
        aDYaiT.f1363BChYOn = -1;
        aDYaiT.f1364BI9f7h = Integer.MIN_VALUE;
        aDYaiT.f1365BIYEnU = Integer.MIN_VALUE;
        aDYaiT.f1366BJ7GGh = Integer.MIN_VALUE;
        aDYaiT.f1367BNL6CD = Integer.MIN_VALUE;
        aDYaiT.f1368BPw6Q8 = Integer.MIN_VALUE;
        aDYaiT.f1369BTvldC = Integer.MIN_VALUE;
        aDYaiT.f1370BV3sI0 = Integer.MIN_VALUE;
        aDYaiT.f1371BmvVmW = 0;
        aDYaiT.f1372BniPrB = 0.5f;
        aDYaiT.BpkvW3 = 0.5f;
        aDYaiT.f1373C2rE4F = null;
        aDYaiT.f1374C4FrIb = -1.0f;
        aDYaiT.f1375CASmeH = -1.0f;
        aDYaiT.f1376CNPG0E = 0;
        aDYaiT.f1377COJEAR = 0;
        aDYaiT.f1378CQhlFr = 0;
        aDYaiT.f1379CSDoyG = 0;
        aDYaiT.f1380CTkVKb = 0;
        aDYaiT.f1381CcAIMM = 0;
        aDYaiT.f1382Cd8JRx = 0;
        aDYaiT.f1383CikNvS = 0;
        aDYaiT.f1384CkXcdM = 1.0f;
        aDYaiT.f1385CmUvjW = 1.0f;
        aDYaiT.f1386CqNSpT = -1;
        aDYaiT.f1387CrfGsy = -1;
        aDYaiT.f1388CtFAbx = -1;
        aDYaiT.f1389CtxOCS = false;
        aDYaiT.f1390D07BeM = false;
        aDYaiT.f1391D6DOie = null;
        aDYaiT.f1392D6yqiO = 0;
        aDYaiT.f1393D8MqeW = true;
        aDYaiT.f1394D8cQ8b = true;
        aDYaiT.f1395D9tr6l = false;
        aDYaiT.f1396DAk1zC = false;
        aDYaiT.f1397DG07BK = false;
        aDYaiT.f1398DRlcZ9 = -1;
        aDYaiT.f1399DUi7mC = -1;
        aDYaiT.f1400DV2E8K = -1;
        aDYaiT.f1401DXnQ0V = -1;
        aDYaiT.DXuj49 = Integer.MIN_VALUE;
        aDYaiT.f1402DaOi9o = Integer.MIN_VALUE;
        aDYaiT.f1403DcUJf1 = 0.5f;
        aDYaiT.f1406DjONCG = new ARc23Z();
        return aDYaiT;
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int max2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return max2 > 0 ? max2 : max;
    }

    public static AZkASS getSharedValues() {
        if (f8398BV3sI0 == null) {
            f8398BV3sI0 = new AZkASS();
        }
        return f8398BV3sI0;
    }

    public final ARc23Z A4TApA(View view) {
        if (view == this) {
            return this.f8401AmA8tU;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof ADYaiT) {
            return ((ADYaiT) view.getLayoutParams()).f1406DjONCG;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof ADYaiT) {
            return ((ADYaiT) view.getLayoutParams()).f1406DjONCG;
        }
        return null;
    }

    public final void A5SV6n(AttributeSet attributeSet, int i) {
        ASJ6gh aSJ6gh = this.f8401AmA8tU;
        aSJ6gh.f1187DUi7mC = this;
        AMqCpz aMqCpz = this.f8413BNL6CD;
        aSJ6gh.f1199EGM26s = aMqCpz;
        aSJ6gh.f1197DyaChj.f1291ARc23Z = aMqCpz;
        this.f8399AcNBzu.put(getId(), this);
        this.f8408B9tovu = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f8417A4TApA, i, 0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == 16) {
                    this.f8402AzWtSf = obtainStyledAttributes.getDimensionPixelOffset(index, this.f8402AzWtSf);
                } else if (index == 17) {
                    this.f8403B25kr6 = obtainStyledAttributes.getDimensionPixelOffset(index, this.f8403B25kr6);
                } else if (index == 14) {
                    this.f8404B2KMhB = obtainStyledAttributes.getDimensionPixelOffset(index, this.f8404B2KMhB);
                } else if (index == 15) {
                    this.f8405B3GDIM = obtainStyledAttributes.getDimensionPixelOffset(index, this.f8405B3GDIM);
                } else if (index == 113) {
                    this.f8407B7CMnp = obtainStyledAttributes.getInt(index, this.f8407B7CMnp);
                } else if (index == 56) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            ADYaiT(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f8409BChYOn = null;
                        }
                    }
                } else if (index == 34) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        A5SV6n a5SV6n = new A5SV6n();
                        this.f8408B9tovu = a5SV6n;
                        a5SV6n.AMqCpz(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f8408B9tovu = null;
                    }
                    this.f8410BI9f7h = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        aSJ6gh.f1207EicXu4 = this.f8407B7CMnp;
        B4ZgIw.ADYaiT.f1055B25kr6 = aSJ6gh.CtxOCS(512);
    }

    public final void ADYaiT(int i) {
        int eventType;
        BJ7GGh.ARc23Z aRc23Z;
        Context context = getContext();
        K1Z3yj.A2egSU a2egSU = new K1Z3yj.A2egSU(5, false);
        a2egSU.f4174AlLFFp = new SparseArray();
        a2egSU.f4175AmA8tU = new SparseArray();
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            eventType = xml.getEventType();
            aRc23Z = null;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
        while (true) {
            char c = 1;
            if (eventType == 1) {
                this.f8409BChYOn = a2egSU;
                return;
            }
            if (eventType == 0) {
                xml.getName();
            } else if (eventType == 2) {
                String name = xml.getName();
                switch (name.hashCode()) {
                    case -1349929691:
                        if (name.equals("ConstraintSet")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 80204913:
                        if (name.equals("State")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1382829617:
                        if (name.equals("StateSet")) {
                            break;
                        }
                        c = 65535;
                        break;
                    case 1657696882:
                        if (name.equals("layoutDescription")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1901439077:
                        if (name.equals("Variant")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                if (c == 2) {
                    aRc23Z = new BJ7GGh.ARc23Z(context, xml);
                    ((SparseArray) a2egSU.f4174AlLFFp).put(aRc23Z.f1414A2egSU, aRc23Z);
                } else if (c == 3) {
                    BJ7GGh.ASJ6gh aSJ6gh = new BJ7GGh.ASJ6gh(context, xml);
                    if (aRc23Z != null) {
                        ((ArrayList) aRc23Z.f1416A5SV6n).add(aSJ6gh);
                    }
                } else if (c == 4) {
                    a2egSU.B25kr6(context, xml);
                }
            }
            eventType = xml.next();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x050a  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01d3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AMqCpz(BChYOn.ASJ6gh r26, int r27, int r28, int r29) {
        /*
            Method dump skipped, instructions count: 1733
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.AMqCpz(BChYOn.ASJ6gh, int, int, int):void");
    }

    public final void ARc23Z(ARc23Z aRc23Z, ADYaiT aDYaiT, SparseArray sparseArray, int i, BChYOn.ADYaiT aDYaiT2) {
        View view = (View) this.f8399AcNBzu.get(i);
        ARc23Z aRc23Z2 = (ARc23Z) sparseArray.get(i);
        if (aRc23Z2 == null || view == null || !(view.getLayoutParams() instanceof ADYaiT)) {
            return;
        }
        aDYaiT.f1395D9tr6l = true;
        BChYOn.ADYaiT aDYaiT3 = BChYOn.ADYaiT.f1118B25kr6;
        if (aDYaiT2 == aDYaiT3) {
            ADYaiT aDYaiT4 = (ADYaiT) view.getLayoutParams();
            aDYaiT4.f1395D9tr6l = true;
            aDYaiT4.f1406DjONCG.BpkvW3 = true;
        }
        aRc23Z.AZOQYO(aDYaiT3).A4TApA(aRc23Z2.AZOQYO(aDYaiT2), aDYaiT.f1371BmvVmW, aDYaiT.f1370BV3sI0, true);
        aRc23Z.BpkvW3 = true;
        aRc23Z.AZOQYO(BChYOn.ADYaiT.f1115AlLFFp).AZkASS();
        aRc23Z.AZOQYO(BChYOn.ADYaiT.f1117AzWtSf).AZkASS();
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ADYaiT;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.f8400AlLFFp;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                ((A2egSU) arrayList.get(i)).getClass();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i3 = (int) ((parseInt / 1080.0f) * width);
                        int i4 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = i3;
                        float f2 = i4;
                        float f3 = i3 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float parseInt4 = i4 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f3, f2, f3, parseInt4, paint);
                        canvas.drawLine(f3, parseInt4, f, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f3, f2, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.f8406B4ZgIw = true;
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return A2egSU();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        ADYaiT aDYaiT = new ADYaiT(context, attributeSet);
        aDYaiT.f1343A2egSU = -1;
        aDYaiT.f1344A4TApA = -1;
        aDYaiT.f1345A5SV6n = -1.0f;
        aDYaiT.f1346ADYaiT = true;
        aDYaiT.AMqCpz = -1;
        aDYaiT.f1347ARc23Z = -1;
        aDYaiT.f1348ASJ6gh = -1;
        aDYaiT.f1349AYUAbz = -1;
        aDYaiT.f1350AZOQYO = -1;
        aDYaiT.f1351AZkASS = -1;
        aDYaiT.f1352AaHO0E = -1;
        aDYaiT.f1353AcNBzu = -1;
        aDYaiT.f1354AlLFFp = -1;
        aDYaiT.f1355AmA8tU = -1;
        aDYaiT.f1356AzWtSf = -1;
        aDYaiT.f1357B25kr6 = -1;
        aDYaiT.f1358B2KMhB = 0;
        aDYaiT.f1359B3GDIM = 0.0f;
        aDYaiT.f1360B4ZgIw = -1;
        aDYaiT.f1361B7CMnp = -1;
        aDYaiT.f1362B9tovu = -1;
        aDYaiT.f1363BChYOn = -1;
        aDYaiT.f1364BI9f7h = Integer.MIN_VALUE;
        aDYaiT.f1365BIYEnU = Integer.MIN_VALUE;
        aDYaiT.f1366BJ7GGh = Integer.MIN_VALUE;
        aDYaiT.f1367BNL6CD = Integer.MIN_VALUE;
        aDYaiT.f1368BPw6Q8 = Integer.MIN_VALUE;
        aDYaiT.f1369BTvldC = Integer.MIN_VALUE;
        aDYaiT.f1370BV3sI0 = Integer.MIN_VALUE;
        aDYaiT.f1371BmvVmW = 0;
        aDYaiT.f1372BniPrB = 0.5f;
        aDYaiT.BpkvW3 = 0.5f;
        aDYaiT.f1373C2rE4F = null;
        aDYaiT.f1374C4FrIb = -1.0f;
        aDYaiT.f1375CASmeH = -1.0f;
        aDYaiT.f1376CNPG0E = 0;
        aDYaiT.f1377COJEAR = 0;
        aDYaiT.f1378CQhlFr = 0;
        aDYaiT.f1379CSDoyG = 0;
        aDYaiT.f1380CTkVKb = 0;
        aDYaiT.f1381CcAIMM = 0;
        aDYaiT.f1382Cd8JRx = 0;
        aDYaiT.f1383CikNvS = 0;
        aDYaiT.f1384CkXcdM = 1.0f;
        aDYaiT.f1385CmUvjW = 1.0f;
        aDYaiT.f1386CqNSpT = -1;
        aDYaiT.f1387CrfGsy = -1;
        aDYaiT.f1388CtFAbx = -1;
        aDYaiT.f1389CtxOCS = false;
        aDYaiT.f1390D07BeM = false;
        aDYaiT.f1391D6DOie = null;
        aDYaiT.f1392D6yqiO = 0;
        aDYaiT.f1393D8MqeW = true;
        aDYaiT.f1394D8cQ8b = true;
        aDYaiT.f1395D9tr6l = false;
        aDYaiT.f1396DAk1zC = false;
        aDYaiT.f1397DG07BK = false;
        aDYaiT.f1398DRlcZ9 = -1;
        aDYaiT.f1399DUi7mC = -1;
        aDYaiT.f1400DV2E8K = -1;
        aDYaiT.f1401DXnQ0V = -1;
        aDYaiT.DXuj49 = Integer.MIN_VALUE;
        aDYaiT.f1402DaOi9o = Integer.MIN_VALUE;
        aDYaiT.f1403DcUJf1 = 0.5f;
        aDYaiT.f1406DjONCG = new ARc23Z();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f8417A4TApA);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            int i2 = BJ7GGh.A5SV6n.f1342A2egSU.get(index);
            switch (i2) {
                case 1:
                    aDYaiT.f1388CtFAbx = obtainStyledAttributes.getInt(index, aDYaiT.f1388CtFAbx);
                    break;
                case 2:
                    int resourceId = obtainStyledAttributes.getResourceId(index, aDYaiT.f1357B25kr6);
                    aDYaiT.f1357B25kr6 = resourceId;
                    if (resourceId == -1) {
                        aDYaiT.f1357B25kr6 = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    aDYaiT.f1358B2KMhB = obtainStyledAttributes.getDimensionPixelSize(index, aDYaiT.f1358B2KMhB);
                    break;
                case 4:
                    float f = obtainStyledAttributes.getFloat(index, aDYaiT.f1359B3GDIM) % 360.0f;
                    aDYaiT.f1359B3GDIM = f;
                    if (f < 0.0f) {
                        aDYaiT.f1359B3GDIM = (360.0f - f) % 360.0f;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    aDYaiT.f1343A2egSU = obtainStyledAttributes.getDimensionPixelOffset(index, aDYaiT.f1343A2egSU);
                    break;
                case 6:
                    aDYaiT.f1344A4TApA = obtainStyledAttributes.getDimensionPixelOffset(index, aDYaiT.f1344A4TApA);
                    break;
                case 7:
                    aDYaiT.f1345A5SV6n = obtainStyledAttributes.getFloat(index, aDYaiT.f1345A5SV6n);
                    break;
                case 8:
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, aDYaiT.AMqCpz);
                    aDYaiT.AMqCpz = resourceId2;
                    if (resourceId2 == -1) {
                        aDYaiT.AMqCpz = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    int resourceId3 = obtainStyledAttributes.getResourceId(index, aDYaiT.f1347ARc23Z);
                    aDYaiT.f1347ARc23Z = resourceId3;
                    if (resourceId3 == -1) {
                        aDYaiT.f1347ARc23Z = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    int resourceId4 = obtainStyledAttributes.getResourceId(index, aDYaiT.f1348ASJ6gh);
                    aDYaiT.f1348ASJ6gh = resourceId4;
                    if (resourceId4 == -1) {
                        aDYaiT.f1348ASJ6gh = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    int resourceId5 = obtainStyledAttributes.getResourceId(index, aDYaiT.f1349AYUAbz);
                    aDYaiT.f1349AYUAbz = resourceId5;
                    if (resourceId5 == -1) {
                        aDYaiT.f1349AYUAbz = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    int resourceId6 = obtainStyledAttributes.getResourceId(index, aDYaiT.f1350AZOQYO);
                    aDYaiT.f1350AZOQYO = resourceId6;
                    if (resourceId6 == -1) {
                        aDYaiT.f1350AZOQYO = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    int resourceId7 = obtainStyledAttributes.getResourceId(index, aDYaiT.f1351AZkASS);
                    aDYaiT.f1351AZkASS = resourceId7;
                    if (resourceId7 == -1) {
                        aDYaiT.f1351AZkASS = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    int resourceId8 = obtainStyledAttributes.getResourceId(index, aDYaiT.f1352AaHO0E);
                    aDYaiT.f1352AaHO0E = resourceId8;
                    if (resourceId8 == -1) {
                        aDYaiT.f1352AaHO0E = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    int resourceId9 = obtainStyledAttributes.getResourceId(index, aDYaiT.f1353AcNBzu);
                    aDYaiT.f1353AcNBzu = resourceId9;
                    if (resourceId9 == -1) {
                        aDYaiT.f1353AcNBzu = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    int resourceId10 = obtainStyledAttributes.getResourceId(index, aDYaiT.f1354AlLFFp);
                    aDYaiT.f1354AlLFFp = resourceId10;
                    if (resourceId10 == -1) {
                        aDYaiT.f1354AlLFFp = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    int resourceId11 = obtainStyledAttributes.getResourceId(index, aDYaiT.f1360B4ZgIw);
                    aDYaiT.f1360B4ZgIw = resourceId11;
                    if (resourceId11 == -1) {
                        aDYaiT.f1360B4ZgIw = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 18:
                    int resourceId12 = obtainStyledAttributes.getResourceId(index, aDYaiT.f1361B7CMnp);
                    aDYaiT.f1361B7CMnp = resourceId12;
                    if (resourceId12 == -1) {
                        aDYaiT.f1361B7CMnp = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 19:
                    int resourceId13 = obtainStyledAttributes.getResourceId(index, aDYaiT.f1362B9tovu);
                    aDYaiT.f1362B9tovu = resourceId13;
                    if (resourceId13 == -1) {
                        aDYaiT.f1362B9tovu = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 20:
                    int resourceId14 = obtainStyledAttributes.getResourceId(index, aDYaiT.f1363BChYOn);
                    aDYaiT.f1363BChYOn = resourceId14;
                    if (resourceId14 == -1) {
                        aDYaiT.f1363BChYOn = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 21:
                    aDYaiT.f1364BI9f7h = obtainStyledAttributes.getDimensionPixelSize(index, aDYaiT.f1364BI9f7h);
                    break;
                case 22:
                    aDYaiT.f1365BIYEnU = obtainStyledAttributes.getDimensionPixelSize(index, aDYaiT.f1365BIYEnU);
                    break;
                case 23:
                    aDYaiT.f1366BJ7GGh = obtainStyledAttributes.getDimensionPixelSize(index, aDYaiT.f1366BJ7GGh);
                    break;
                case 24:
                    aDYaiT.f1367BNL6CD = obtainStyledAttributes.getDimensionPixelSize(index, aDYaiT.f1367BNL6CD);
                    break;
                case 25:
                    aDYaiT.f1368BPw6Q8 = obtainStyledAttributes.getDimensionPixelSize(index, aDYaiT.f1368BPw6Q8);
                    break;
                case 26:
                    aDYaiT.f1369BTvldC = obtainStyledAttributes.getDimensionPixelSize(index, aDYaiT.f1369BTvldC);
                    break;
                case 27:
                    aDYaiT.f1389CtxOCS = obtainStyledAttributes.getBoolean(index, aDYaiT.f1389CtxOCS);
                    break;
                case 28:
                    aDYaiT.f1390D07BeM = obtainStyledAttributes.getBoolean(index, aDYaiT.f1390D07BeM);
                    break;
                case 29:
                    aDYaiT.f1372BniPrB = obtainStyledAttributes.getFloat(index, aDYaiT.f1372BniPrB);
                    break;
                case 30:
                    aDYaiT.BpkvW3 = obtainStyledAttributes.getFloat(index, aDYaiT.BpkvW3);
                    break;
                case 31:
                    aDYaiT.f1378CQhlFr = obtainStyledAttributes.getInt(index, 0);
                    break;
                case 32:
                    aDYaiT.f1379CSDoyG = obtainStyledAttributes.getInt(index, 0);
                    break;
                case 33:
                    try {
                        aDYaiT.f1380CTkVKb = obtainStyledAttributes.getDimensionPixelSize(index, aDYaiT.f1380CTkVKb);
                        break;
                    } catch (Exception unused) {
                        if (obtainStyledAttributes.getInt(index, aDYaiT.f1380CTkVKb) == -2) {
                            aDYaiT.f1380CTkVKb = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 34:
                    try {
                        aDYaiT.f1382Cd8JRx = obtainStyledAttributes.getDimensionPixelSize(index, aDYaiT.f1382Cd8JRx);
                        break;
                    } catch (Exception unused2) {
                        if (obtainStyledAttributes.getInt(index, aDYaiT.f1382Cd8JRx) == -2) {
                            aDYaiT.f1382Cd8JRx = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 35:
                    aDYaiT.f1384CkXcdM = Math.max(0.0f, obtainStyledAttributes.getFloat(index, aDYaiT.f1384CkXcdM));
                    aDYaiT.f1378CQhlFr = 2;
                    break;
                case 36:
                    try {
                        aDYaiT.f1381CcAIMM = obtainStyledAttributes.getDimensionPixelSize(index, aDYaiT.f1381CcAIMM);
                        break;
                    } catch (Exception unused3) {
                        if (obtainStyledAttributes.getInt(index, aDYaiT.f1381CcAIMM) == -2) {
                            aDYaiT.f1381CcAIMM = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 37:
                    try {
                        aDYaiT.f1383CikNvS = obtainStyledAttributes.getDimensionPixelSize(index, aDYaiT.f1383CikNvS);
                        break;
                    } catch (Exception unused4) {
                        if (obtainStyledAttributes.getInt(index, aDYaiT.f1383CikNvS) == -2) {
                            aDYaiT.f1383CikNvS = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 38:
                    aDYaiT.f1385CmUvjW = Math.max(0.0f, obtainStyledAttributes.getFloat(index, aDYaiT.f1385CmUvjW));
                    aDYaiT.f1379CSDoyG = 2;
                    break;
                default:
                    switch (i2) {
                        case 44:
                            A5SV6n.AYUAbz(aDYaiT, obtainStyledAttributes.getString(index));
                            break;
                        case 45:
                            aDYaiT.f1374C4FrIb = obtainStyledAttributes.getFloat(index, aDYaiT.f1374C4FrIb);
                            break;
                        case 46:
                            aDYaiT.f1375CASmeH = obtainStyledAttributes.getFloat(index, aDYaiT.f1375CASmeH);
                            break;
                        case 47:
                            aDYaiT.f1376CNPG0E = obtainStyledAttributes.getInt(index, 0);
                            break;
                        case 48:
                            aDYaiT.f1377COJEAR = obtainStyledAttributes.getInt(index, 0);
                            break;
                        case 49:
                            aDYaiT.f1386CqNSpT = obtainStyledAttributes.getDimensionPixelOffset(index, aDYaiT.f1386CqNSpT);
                            break;
                        case 50:
                            aDYaiT.f1387CrfGsy = obtainStyledAttributes.getDimensionPixelOffset(index, aDYaiT.f1387CrfGsy);
                            break;
                        case ILivePlayer.LIVE_DATALOADER_RW_TIMEOUT /* 51 */:
                            aDYaiT.f1391D6DOie = obtainStyledAttributes.getString(index);
                            break;
                        case 52:
                            int resourceId15 = obtainStyledAttributes.getResourceId(index, aDYaiT.f1355AmA8tU);
                            aDYaiT.f1355AmA8tU = resourceId15;
                            if (resourceId15 == -1) {
                                aDYaiT.f1355AmA8tU = obtainStyledAttributes.getInt(index, -1);
                                break;
                            } else {
                                break;
                            }
                        case 53:
                            int resourceId16 = obtainStyledAttributes.getResourceId(index, aDYaiT.f1356AzWtSf);
                            aDYaiT.f1356AzWtSf = resourceId16;
                            if (resourceId16 == -1) {
                                aDYaiT.f1356AzWtSf = obtainStyledAttributes.getInt(index, -1);
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            aDYaiT.f1371BmvVmW = obtainStyledAttributes.getDimensionPixelSize(index, aDYaiT.f1371BmvVmW);
                            break;
                        case 55:
                            aDYaiT.f1370BV3sI0 = obtainStyledAttributes.getDimensionPixelSize(index, aDYaiT.f1370BV3sI0);
                            break;
                        default:
                            switch (i2) {
                                case 64:
                                    A5SV6n.ASJ6gh(aDYaiT, obtainStyledAttributes, index, 0);
                                    break;
                                case ILivePlayer.LIVE_PLAYER_OPTION_ABR_STRATEGY /* 65 */:
                                    A5SV6n.ASJ6gh(aDYaiT, obtainStyledAttributes, index, 1);
                                    break;
                                case 66:
                                    aDYaiT.f1392D6yqiO = obtainStyledAttributes.getInt(index, aDYaiT.f1392D6yqiO);
                                    break;
                                case 67:
                                    aDYaiT.f1346ADYaiT = obtainStyledAttributes.getBoolean(index, aDYaiT.f1346ADYaiT);
                                    break;
                            }
                    }
            }
        }
        obtainStyledAttributes.recycle();
        aDYaiT.A2egSU();
        return aDYaiT;
    }

    public int getMaxHeight() {
        return this.f8405B3GDIM;
    }

    public int getMaxWidth() {
        return this.f8404B2KMhB;
    }

    public int getMinHeight() {
        return this.f8403B25kr6;
    }

    public int getMinWidth() {
        return this.f8402AzWtSf;
    }

    public int getOptimizationLevel() {
        return this.f8401AmA8tU.f1207EicXu4;
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        ASJ6gh aSJ6gh = this.f8401AmA8tU;
        if (aSJ6gh.f1140AaHO0E == null) {
            int id2 = getId();
            if (id2 != -1) {
                aSJ6gh.f1140AaHO0E = getContext().getResources().getResourceEntryName(id2);
            } else {
                aSJ6gh.f1140AaHO0E = "parent";
            }
        }
        if (aSJ6gh.f1189DXnQ0V == null) {
            aSJ6gh.f1189DXnQ0V = aSJ6gh.f1140AaHO0E;
        }
        Iterator it = aSJ6gh.f1275DuwtYk.iterator();
        while (it.hasNext()) {
            ARc23Z aRc23Z = (ARc23Z) it.next();
            View view = aRc23Z.f1187DUi7mC;
            if (view != null) {
                if (aRc23Z.f1140AaHO0E == null && (id = view.getId()) != -1) {
                    aRc23Z.f1140AaHO0E = getContext().getResources().getResourceEntryName(id);
                }
                if (aRc23Z.f1189DXnQ0V == null) {
                    aRc23Z.f1189DXnQ0V = aRc23Z.f1140AaHO0E;
                }
            }
        }
        aSJ6gh.AmA8tU(sb);
        return sb.toString();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            ADYaiT aDYaiT = (ADYaiT) childAt.getLayoutParams();
            ARc23Z aRc23Z = aDYaiT.f1406DjONCG;
            if (childAt.getVisibility() != 8 || aDYaiT.f1396DAk1zC || aDYaiT.f1397DG07BK || isInEditMode) {
                int B3GDIM2 = aRc23Z.B3GDIM();
                int B4ZgIw2 = aRc23Z.B4ZgIw();
                childAt.layout(B3GDIM2, B4ZgIw2, aRc23Z.B2KMhB() + B3GDIM2, aRc23Z.AaHO0E() + B4ZgIw2);
            }
        }
        ArrayList arrayList = this.f8400AlLFFp;
        int size = arrayList.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                ((A2egSU) arrayList.get(i6)).getClass();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:281:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0344  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r35, int r36) {
        /*
            Method dump skipped, instructions count: 1543
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        ARc23Z A4TApA2 = A4TApA(view);
        if ((view instanceof AZOQYO) && !(A4TApA2 instanceof BChYOn.AZkASS)) {
            ADYaiT aDYaiT = (ADYaiT) view.getLayoutParams();
            BChYOn.AZkASS aZkASS = new BChYOn.AZkASS();
            aDYaiT.f1406DjONCG = aZkASS;
            aDYaiT.f1396DAk1zC = true;
            aZkASS.CmUvjW(aDYaiT.f1388CtFAbx);
        }
        if (view instanceof A2egSU) {
            A2egSU a2egSU = (A2egSU) view;
            a2egSU.AZOQYO();
            ((ADYaiT) view.getLayoutParams()).f1397DG07BK = true;
            ArrayList arrayList = this.f8400AlLFFp;
            if (!arrayList.contains(a2egSU)) {
                arrayList.add(a2egSU);
            }
        }
        this.f8399AcNBzu.put(view.getId(), view);
        this.f8406B4ZgIw = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f8399AcNBzu.remove(view.getId());
        ARc23Z A4TApA2 = A4TApA(view);
        this.f8401AmA8tU.f1275DuwtYk.remove(A4TApA2);
        A4TApA2.BV3sI0();
        this.f8400AlLFFp.remove(view);
        this.f8406B4ZgIw = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.f8406B4ZgIw = true;
        super.requestLayout();
    }

    public void setConstraintSet(A5SV6n a5SV6n) {
        this.f8408B9tovu = a5SV6n;
    }

    @Override // android.view.View
    public void setId(int i) {
        int id = getId();
        SparseArray sparseArray = this.f8399AcNBzu;
        sparseArray.remove(id);
        super.setId(i);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.f8405B3GDIM) {
            return;
        }
        this.f8405B3GDIM = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.f8404B2KMhB) {
            return;
        }
        this.f8404B2KMhB = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.f8403B25kr6) {
            return;
        }
        this.f8403B25kr6 = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.f8402AzWtSf) {
            return;
        }
        this.f8402AzWtSf = i;
        requestLayout();
    }

    public void setOnConstraintsChanged(AYUAbz aYUAbz) {
        K1Z3yj.A2egSU a2egSU = this.f8409BChYOn;
        if (a2egSU != null) {
            a2egSU.getClass();
        }
    }

    public void setOptimizationLevel(int i) {
        this.f8407B7CMnp = i;
        ASJ6gh aSJ6gh = this.f8401AmA8tU;
        aSJ6gh.f1207EicXu4 = i;
        B4ZgIw.ADYaiT.f1055B25kr6 = aSJ6gh.CtxOCS(512);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8399AcNBzu = new SparseArray();
        this.f8400AlLFFp = new ArrayList(4);
        this.f8401AmA8tU = new ASJ6gh();
        this.f8402AzWtSf = 0;
        this.f8403B25kr6 = 0;
        this.f8404B2KMhB = Integer.MAX_VALUE;
        this.f8405B3GDIM = Integer.MAX_VALUE;
        this.f8406B4ZgIw = true;
        this.f8407B7CMnp = 257;
        this.f8408B9tovu = null;
        this.f8409BChYOn = null;
        this.f8410BI9f7h = -1;
        this.f8411BIYEnU = new HashMap();
        this.f8412BJ7GGh = new SparseArray();
        this.f8413BNL6CD = new AMqCpz(this, this);
        this.f8414BPw6Q8 = 0;
        this.f8415BTvldC = 0;
        A5SV6n(attributeSet, i);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        ADYaiT aDYaiT = new ADYaiT(layoutParams);
        aDYaiT.f1343A2egSU = -1;
        aDYaiT.f1344A4TApA = -1;
        aDYaiT.f1345A5SV6n = -1.0f;
        aDYaiT.f1346ADYaiT = true;
        aDYaiT.AMqCpz = -1;
        aDYaiT.f1347ARc23Z = -1;
        aDYaiT.f1348ASJ6gh = -1;
        aDYaiT.f1349AYUAbz = -1;
        aDYaiT.f1350AZOQYO = -1;
        aDYaiT.f1351AZkASS = -1;
        aDYaiT.f1352AaHO0E = -1;
        aDYaiT.f1353AcNBzu = -1;
        aDYaiT.f1354AlLFFp = -1;
        aDYaiT.f1355AmA8tU = -1;
        aDYaiT.f1356AzWtSf = -1;
        aDYaiT.f1357B25kr6 = -1;
        aDYaiT.f1358B2KMhB = 0;
        aDYaiT.f1359B3GDIM = 0.0f;
        aDYaiT.f1360B4ZgIw = -1;
        aDYaiT.f1361B7CMnp = -1;
        aDYaiT.f1362B9tovu = -1;
        aDYaiT.f1363BChYOn = -1;
        aDYaiT.f1364BI9f7h = Integer.MIN_VALUE;
        aDYaiT.f1365BIYEnU = Integer.MIN_VALUE;
        aDYaiT.f1366BJ7GGh = Integer.MIN_VALUE;
        aDYaiT.f1367BNL6CD = Integer.MIN_VALUE;
        aDYaiT.f1368BPw6Q8 = Integer.MIN_VALUE;
        aDYaiT.f1369BTvldC = Integer.MIN_VALUE;
        aDYaiT.f1370BV3sI0 = Integer.MIN_VALUE;
        aDYaiT.f1371BmvVmW = 0;
        aDYaiT.f1372BniPrB = 0.5f;
        aDYaiT.BpkvW3 = 0.5f;
        aDYaiT.f1373C2rE4F = null;
        aDYaiT.f1374C4FrIb = -1.0f;
        aDYaiT.f1375CASmeH = -1.0f;
        aDYaiT.f1376CNPG0E = 0;
        aDYaiT.f1377COJEAR = 0;
        aDYaiT.f1378CQhlFr = 0;
        aDYaiT.f1379CSDoyG = 0;
        aDYaiT.f1380CTkVKb = 0;
        aDYaiT.f1381CcAIMM = 0;
        aDYaiT.f1382Cd8JRx = 0;
        aDYaiT.f1383CikNvS = 0;
        aDYaiT.f1384CkXcdM = 1.0f;
        aDYaiT.f1385CmUvjW = 1.0f;
        aDYaiT.f1386CqNSpT = -1;
        aDYaiT.f1387CrfGsy = -1;
        aDYaiT.f1388CtFAbx = -1;
        aDYaiT.f1389CtxOCS = false;
        aDYaiT.f1390D07BeM = false;
        aDYaiT.f1391D6DOie = null;
        aDYaiT.f1392D6yqiO = 0;
        aDYaiT.f1393D8MqeW = true;
        aDYaiT.f1394D8cQ8b = true;
        aDYaiT.f1395D9tr6l = false;
        aDYaiT.f1396DAk1zC = false;
        aDYaiT.f1397DG07BK = false;
        aDYaiT.f1398DRlcZ9 = -1;
        aDYaiT.f1399DUi7mC = -1;
        aDYaiT.f1400DV2E8K = -1;
        aDYaiT.f1401DXnQ0V = -1;
        aDYaiT.DXuj49 = Integer.MIN_VALUE;
        aDYaiT.f1402DaOi9o = Integer.MIN_VALUE;
        aDYaiT.f1403DcUJf1 = 0.5f;
        aDYaiT.f1406DjONCG = new ARc23Z();
        return aDYaiT;
    }
}
