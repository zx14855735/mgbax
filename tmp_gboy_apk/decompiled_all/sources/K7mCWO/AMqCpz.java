package K7mCWO;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz implements Handler.Callback {

    /* renamed from: B7CMnp, reason: collision with root package name */
    public static Printer f4182B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public static AMqCpz f4183B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public static final ADYaiT f4184BChYOn = new ADYaiT();

    /* renamed from: AmA8tU, reason: collision with root package name */
    public long f4187AmA8tU;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final boolean f4191B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f4192B4ZgIw;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f4186AlLFFp = 0;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final SparseArray f4188AzWtSf = new SparseArray();

    /* renamed from: B25kr6, reason: collision with root package name */
    public final LinkedList f4189B25kr6 = new LinkedList();

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final LinkedList f4190B2KMhB = new LinkedList();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Handler f4185AcNBzu = new Handler(A2egSU.A4TApA().getLooper(), this);

    static {
        AFvxG();
    }

    public AMqCpz() {
        Printer printer;
        this.f4191B3GDIM = false;
        if (this.f4191B3GDIM) {
            return;
        }
        this.f4191B3GDIM = true;
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            printer = (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception unused) {
            com.bumptech.glide.AMqCpz.C2rE4F();
            printer = null;
        }
        f4182B7CMnp = printer;
        ADYaiT aDYaiT = f4184BChYOn;
        if (printer == aDYaiT) {
            f4182B7CMnp = null;
        }
        Looper.getMainLooper().setMessageLogging(aDYaiT);
    }

    public static AMqCpz A2egSU() {
        if (f4183B9tovu == null) {
            synchronized (AMqCpz.class) {
                try {
                    if (f4183B9tovu == null) {
                        f4183B9tovu = new AMqCpz();
                    }
                } finally {
                }
            }
        }
        return f4183B9tovu;
    }

    public static void ADYaiT(List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        } catch (Exception unused) {
            JrXYwF.A5SV6n.f4152ADYaiT.getClass();
        }
    }

    private static /* synthetic */ void AFvxG() {
        char[] charArray = "¥©«è¡§«£è¤©¿èµ®£ªªè\u008c¨¯\u0084´¯¢¡£".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 198);
        }
        String str = new String(charArray);
        char[] charArray2 = "¥ª¯¨¯²".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 198);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A4TApA(long j, Runnable runnable, int i, long j2) {
        if (j < 0) {
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = (int) j;
            List list = (List) this.f4188AzWtSf.get(i3);
            if (list == null) {
                synchronized (this.f4188AzWtSf) {
                    try {
                        list = (List) this.f4188AzWtSf.get(i3);
                        if (list == null) {
                            list = new LinkedList();
                            this.f4188AzWtSf.put(i3, list);
                        }
                    } finally {
                    }
                }
            }
            list.add(runnable);
            j += j2;
        }
    }

    public final synchronized void A5SV6n(String str, LinkedList linkedList) {
        if (linkedList != null) {
            if (!linkedList.isEmpty()) {
                try {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        ((Printer) it.next()).println(str);
                    }
                } catch (Exception unused) {
                    JrXYwF.A5SV6n.f4152ADYaiT.getClass();
                }
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Handler handler = this.f4185AcNBzu;
        if (handler.hasMessages(0)) {
            return true;
        }
        int i = message.what;
        SparseArray sparseArray = this.f4188AzWtSf;
        if (i == 0) {
            this.f4186AlLFFp = 0;
            if (sparseArray.size() != 0 && sparseArray.keyAt(0) == 0) {
                ADYaiT((List) sparseArray.valueAt(0));
                this.f4186AlLFFp++;
            }
        } else {
            if (i == 1) {
                handler.removeMessages(2);
                if (sparseArray.size() != 0 && sparseArray.keyAt(sparseArray.size() - 1) == 0) {
                    ADYaiT((List) sparseArray.get(Integer.MAX_VALUE));
                }
                return true;
            }
            if (i == 2) {
                ADYaiT((List) sparseArray.valueAt(this.f4186AlLFFp));
                this.f4186AlLFFp++;
            }
        }
        if (this.f4186AlLFFp >= sparseArray.size()) {
            return true;
        }
        long keyAt = sparseArray.keyAt(this.f4186AlLFFp);
        if (keyAt != 2147483647L) {
            handler.sendEmptyMessageAtTime(2, this.f4187AmA8tU + keyAt);
        }
        return true;
    }
}
