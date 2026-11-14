package AZOQYO;

import ADYaiT.CTkVKb;
import ADYaiT.CtFAbx;
import ADYaiT.D8MqeW;
import AZkASS.BV3sI0;
import C4FrIb.B3GDIM;
import HXc4pW.B7CMnp;
import HXc4pW.B9tovu;
import HXc4pW.BTvldC;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.emoji2.text.BI9f7h;
import androidx.emoji2.text.BNL6CD;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z implements A2egSU, GnQT2j.AaHO0E {

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final ARc23Z f359B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static final ARc23Z f360B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static ARc23Z f361B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static volatile ARc23Z f362B4ZgIw;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public Object f363AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Object f364AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Object f365AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public Object f366AzWtSf;

    static {
        ARc23Z aRc23Z = new ARc23Z("#FFFFFFFF", "#FFF1F5F9", "#FF000000", "#FFC7C7C7");
        f359B25kr6 = aRc23Z;
        f360B2KMhB = new ARc23Z("#FF5F5F5F", "#FF5F5F5F", "#FFFFFFFF", "#FFFFFFFF");
        f361B3GDIM = aRc23Z;
        RmQSJl();
    }

    public ARc23Z(String str, String str2, String str3, String str4) {
        this.f363AcNBzu = str;
        this.f364AlLFFp = str2;
        this.f365AmA8tU = str3;
        this.f366AzWtSf = str4;
    }

    public static void AmA8tU(Context context) {
        if (f362B4ZgIw == null) {
            ARc23Z aRc23Z = new ARc23Z();
            aRc23Z.f363AcNBzu = new HashMap();
            aRc23Z.f364AlLFFp = context;
            aRc23Z.f365AmA8tU = new KBDfKG.A4TApA(context);
            IySJvm.A2egSU a2egSU = new IySJvm.A2egSU();
            try {
                context.registerReceiver(new CTkVKb(3, a2egSU), new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            } catch (Throwable unused) {
            }
            aRc23Z.f366AzWtSf = a2egSU;
            f362B4ZgIw = aRc23Z;
        }
    }

    private static /* synthetic */ void RmQSJl() {
        char[] charArray = "UY[\u0018QW[S\u0018TYO\u0018E^SZZ\u0018|X_tD_RQS".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '6');
        }
        String str = new String(charArray);
        char[] charArray2 = "UZ_X_B".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '6');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public synchronized void A2egSU(B7CMnp b7CMnp, B9tovu b9tovu) {
        HXc4pW.A4TApA a4TApA = (HXc4pW.A4TApA) ((HashMap) this.f364AlLFFp).put(b7CMnp, new HXc4pW.A4TApA(b7CMnp, b9tovu, (ReferenceQueue) this.f365AmA8tU));
        if (a4TApA != null) {
            a4TApA.f3490A5SV6n = null;
            a4TApA.clear();
        }
    }

    public void A4TApA(HXc4pW.A4TApA a4TApA) {
        BTvldC bTvldC;
        synchronized (this) {
            ((HashMap) this.f364AlLFFp).remove(a4TApA.f3488A2egSU);
            if (a4TApA.f3489A4TApA && (bTvldC = a4TApA.f3490A5SV6n) != null) {
                ((HXc4pW.AzWtSf) this.f366AzWtSf).AMqCpz(a4TApA.f3488A2egSU, new B9tovu(bTvldC, true, false, a4TApA.f3488A2egSU, (HXc4pW.AzWtSf) this.f366AzWtSf));
            }
        }
    }

    public ASJ6gh A5SV6n(A4TApA a4TApA) {
        ArrayList arrayList = (ArrayList) this.f365AmA8tU;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ASJ6gh aSJ6gh = (ASJ6gh) arrayList.get(i);
            if (aSJ6gh != null && aSJ6gh.f368A4TApA == a4TApA) {
                return aSJ6gh;
            }
        }
        ASJ6gh aSJ6gh2 = new ASJ6gh((Context) this.f364AlLFFp, a4TApA);
        arrayList.add(aSJ6gh2);
        return aSJ6gh2;
    }

    @Override // AZOQYO.A2egSU
    public boolean ADYaiT(A4TApA a4TApA, AZkASS.AmA8tU amA8tU) {
        ASJ6gh A5SV6n2 = A5SV6n(a4TApA);
        B25kr6.AzWtSf azWtSf = (B25kr6.AzWtSf) this.f366AzWtSf;
        Menu menu = (Menu) azWtSf.get(amA8tU);
        if (menu == null) {
            menu = new BV3sI0((Context) this.f364AlLFFp, amA8tU);
            azWtSf.put(amA8tU, menu);
        }
        return ((ActionMode.Callback) this.f363AcNBzu).onPrepareActionMode(A5SV6n2, menu);
    }

    public List AMqCpz() {
        List list = (List) this.f364AlLFFp;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (double d = 0.0d; d <= 360.0d; d += 1.0d) {
            OO3awZ.ADYaiT aDYaiT = (OO3awZ.ADYaiT) this.f363AcNBzu;
            arrayList.add(OO3awZ.ADYaiT.A2egSU(d, aDYaiT.f6400A4TApA, aDYaiT.f6401A5SV6n));
        }
        List unmodifiableList = Collections.unmodifiableList(arrayList);
        this.f364AlLFFp = unmodifiableList;
        return unmodifiableList;
    }

    @Override // AZOQYO.A2egSU
    public boolean ARc23Z(A4TApA a4TApA, MenuItem menuItem) {
        return ((ActionMode.Callback) this.f363AcNBzu).onActionItemClicked(A5SV6n(a4TApA), new AZkASS.B9tovu((Context) this.f364AlLFFp, (BniPrB.A2egSU) menuItem));
    }

    public List ASJ6gh() {
        Comparator comparing;
        ArrayList arrayList = (ArrayList) this.f365AmA8tU;
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(AMqCpz());
        arrayList2.add((OO3awZ.ADYaiT) this.f363AcNBzu);
        comparing = Comparator.comparing(new OO3awZ.ARc23Z(23, this), new C4FrIb.A5SV6n(1));
        Collections.sort(arrayList2, comparing);
        this.f365AmA8tU = arrayList2;
        return arrayList2;
    }

    @Override // AZOQYO.A2egSU
    public void AYUAbz(A4TApA a4TApA) {
        ((ActionMode.Callback) this.f363AcNBzu).onDestroyActionMode(A5SV6n(a4TApA));
    }

    @Override // AZOQYO.A2egSU
    public boolean AZOQYO(A4TApA a4TApA, AZkASS.AmA8tU amA8tU) {
        ASJ6gh A5SV6n2 = A5SV6n(a4TApA);
        B25kr6.AzWtSf azWtSf = (B25kr6.AzWtSf) this.f366AzWtSf;
        Menu menu = (Menu) azWtSf.get(amA8tU);
        if (menu == null) {
            menu = new BV3sI0((Context) this.f364AlLFFp, amA8tU);
            azWtSf.put(amA8tU, menu);
        }
        return ((ActionMode.Callback) this.f363AcNBzu).onCreateActionMode(A5SV6n2, menu);
    }

    public double AZkASS(OO3awZ.ADYaiT aDYaiT) {
        double doubleValue = ((Double) ((HashMap) AaHO0E()).get((OO3awZ.ADYaiT) ((ArrayList) ASJ6gh()).get(((ArrayList) ASJ6gh()).size() - 1))).doubleValue() - ((Double) ((HashMap) AaHO0E()).get((OO3awZ.ADYaiT) ((ArrayList) ASJ6gh()).get(0))).doubleValue();
        double doubleValue2 = ((Double) ((HashMap) AaHO0E()).get(aDYaiT)).doubleValue() - ((Double) ((HashMap) AaHO0E()).get((OO3awZ.ADYaiT) ((ArrayList) ASJ6gh()).get(0))).doubleValue();
        if (doubleValue == 0.0d) {
            return 0.5d;
        }
        return doubleValue2 / doubleValue;
    }

    public Map AaHO0E() {
        HashMap hashMap = (HashMap) this.f366AzWtSf;
        if (hashMap != null) {
            return hashMap;
        }
        ArrayList arrayList = new ArrayList(AMqCpz());
        arrayList.add((OO3awZ.ADYaiT) this.f363AcNBzu);
        HashMap hashMap2 = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            OO3awZ.ADYaiT aDYaiT = (OO3awZ.ADYaiT) it.next();
            double[] AZOQYO2 = OO3awZ.A2egSU.AZOQYO(aDYaiT.f6402ADYaiT);
            double degrees = Math.toDegrees(Math.atan2(AZOQYO2[2], AZOQYO2[1])) % 360.0d;
            if (degrees < 0.0d) {
                degrees += 360.0d;
            }
            double pow = Math.pow(Math.hypot(AZOQYO2[1], AZOQYO2[2]), 1.07d) * 0.02d;
            double d = (degrees - 50.0d) % 360.0d;
            if (d < 0.0d) {
                d += 360.0d;
            }
            hashMap2.put(aDYaiT, Double.valueOf((Math.cos(Math.toRadians(d)) * pow) - 0.5d));
        }
        this.f366AzWtSf = hashMap2;
        return hashMap2;
    }

    public void AcNBzu(String str, String str2) {
        String str3;
        LLYwnm.AYUAbz aYUAbz = (LLYwnm.AYUAbz) this.f366AzWtSf;
        LLYwnm.ASJ6gh aSJ6gh = (LLYwnm.ASJ6gh) this.f364AlLFFp;
        if (aSJ6gh != null && (str3 = (String) this.f365AmA8tU) != null) {
            Queue queue = (Queue) aYUAbz.f4632AYUAbz.get(str3);
            if (queue != null) {
                queue.remove(aSJ6gh);
            }
            ScheduledFuture scheduledFuture = aSJ6gh.f4623A4TApA;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
        }
        aYUAbz.A5SV6n(new C4FrIb.A2egSU(this, str, str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public KCVcbs.A5SV6n AlLFFp(JrXYwF.ARc23Z r11, KCVcbs.A5SV6n r12) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: AZOQYO.ARc23Z.AlLFFp(JrXYwF.ARc23Z, KCVcbs.A5SV6n):KCVcbs.A5SV6n");
    }

    @Override // GnQT2j.AaHO0E
    public void a(Bitmap bitmap) {
        ImageView imageView = (ImageView) this.f363AcNBzu;
        try {
            imageView.setImageBitmap(FOAO9d.AcNBzu.Dphsd2((FOAO9d.AcNBzu) this.f366AzWtSf, bitmap, 80, 80, 40));
            ((LinearLayout) this.f365AmA8tU).addView(imageView);
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 017: "), new EY4UKY.ADYaiT(), "004", e);
        }
    }

    public ARc23Z(int i) {
        switch (i) {
            case 4:
                ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new B3GDIM(1));
                this.f364AlLFFp = new HashMap();
                this.f365AmA8tU = new ReferenceQueue();
                this.f363AcNBzu = newSingleThreadExecutor;
                newSingleThreadExecutor.execute(new D8MqeW(18, this));
                break;
            default:
                this.f363AcNBzu = new B25kr6.ADYaiT();
                this.f364AlLFFp = new SparseArray();
                this.f365AmA8tU = new B25kr6.AYUAbz();
                this.f366AzWtSf = new B25kr6.ADYaiT();
                break;
        }
    }

    @Override // GnQT2j.AaHO0E
    public void a(Exception exc) {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        Bitmap decodeResource = BitmapFactory.decodeResource(((Context) this.f364AlLFFp).getResources(), 2131231421);
        if (decodeResource != null) {
            ImageView imageView = (ImageView) this.f363AcNBzu;
            imageView.setImageBitmap(decodeResource);
            ((LinearLayout) this.f365AmA8tU).addView(imageView);
        }
    }

    public ARc23Z(Typeface typeface, CtxOCS.A4TApA a4TApA) {
        int i;
        int i2;
        int i3;
        int i4;
        this.f366AzWtSf = typeface;
        this.f363AcNBzu = a4TApA;
        this.f365AmA8tU = new BI9f7h(1024);
        int A2egSU2 = a4TApA.A2egSU(6);
        if (A2egSU2 != 0) {
            int i5 = A2egSU2 + a4TApA.f1917A2egSU;
            i = a4TApA.f1918A4TApA.getInt(a4TApA.f1918A4TApA.getInt(i5) + i5);
        } else {
            i = 0;
        }
        this.f364AlLFFp = new char[i * 2];
        int A2egSU3 = a4TApA.A2egSU(6);
        if (A2egSU3 != 0) {
            int i6 = A2egSU3 + a4TApA.f1917A2egSU;
            i2 = a4TApA.f1918A4TApA.getInt(a4TApA.f1918A4TApA.getInt(i6) + i6);
        } else {
            i2 = 0;
        }
        for (int i7 = 0; i7 < i2; i7++) {
            BNL6CD bnl6cd = new BNL6CD(this, i7);
            CtxOCS.A2egSU A4TApA2 = bnl6cd.A4TApA();
            int A2egSU4 = A4TApA2.A2egSU(4);
            Character.toChars(A2egSU4 != 0 ? A4TApA2.f1918A4TApA.getInt(A2egSU4 + A4TApA2.f1917A2egSU) : 0, (char[]) this.f364AlLFFp, i7 * 2);
            CtxOCS.A2egSU A4TApA3 = bnl6cd.A4TApA();
            int A2egSU5 = A4TApA3.A2egSU(16);
            if (A2egSU5 != 0) {
                int i8 = A2egSU5 + A4TApA3.f1917A2egSU;
                i3 = A4TApA3.f1918A4TApA.getInt(A4TApA3.f1918A4TApA.getInt(i8) + i8);
            } else {
                i3 = 0;
            }
            JrXYwF.A4TApA.B2KMhB(i3 > 0, "invalid metadata codepoint length");
            CtxOCS.A2egSU A4TApA4 = bnl6cd.A4TApA();
            int A2egSU6 = A4TApA4.A2egSU(16);
            if (A2egSU6 != 0) {
                int i9 = A2egSU6 + A4TApA4.f1917A2egSU;
                i4 = A4TApA4.f1918A4TApA.getInt(A4TApA4.f1918A4TApA.getInt(i9) + i9);
            } else {
                i4 = 0;
            }
            ((BI9f7h) this.f365AmA8tU).A2egSU(bnl6cd, 0, i4 - 1);
        }
    }

    public ARc23Z(Context context, ActionMode.Callback callback) {
        this.f364AlLFFp = context;
        this.f363AcNBzu = callback;
        this.f365AmA8tU = new ArrayList();
        this.f366AzWtSf = new B25kr6.AzWtSf();
    }
}
