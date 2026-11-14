package DG07BK;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n {

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final Object f2064ARc23Z = new Object();

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static A5SV6n f2065ASJ6gh;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Context f2066A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final HashMap f2067A4TApA = new HashMap();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final HashMap f2068A5SV6n = new HashMap();

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final ArrayList f2069ADYaiT = new ArrayList();
    public final A2egSU AMqCpz;

    static {
        rXTIY();
    }

    public A5SV6n(Context context) {
        this.f2066A2egSU = context;
        this.AMqCpz = new A2egSU(this, context.getMainLooper(), 0);
    }

    public static A5SV6n A2egSU(Context context) {
        A5SV6n a5SV6n;
        synchronized (f2064ARc23Z) {
            try {
                if (f2065ASJ6gh == null) {
                    f2065ASJ6gh = new A5SV6n(context.getApplicationContext());
                }
                a5SV6n = f2065ASJ6gh;
            } catch (Throwable th) {
                throw th;
            }
        }
        return a5SV6n;
    }

    private static /* synthetic */ void rXTIY() {
        char[] charArray = "\u001c\u0010\u0012Q\u0018\u001e\u0012\u001aQ\u001d\u0010\u0006Q\f\u0017\u001a\u0013\u0013Q5\u0011\u0016=\r\u0016\u001b\u0018\u001a".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 127);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001c\u0013\u0016\u0011\u0016\u000b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 127);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f2067A4TApA) {
            try {
                A4TApA a4TApA = new A4TApA(intentFilter, broadcastReceiver);
                ArrayList arrayList = (ArrayList) this.f2067A4TApA.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.f2067A4TApA.put(broadcastReceiver, arrayList);
                }
                arrayList.add(a4TApA);
                for (int i = 0; i < intentFilter.countActions(); i++) {
                    String action = intentFilter.getAction(i);
                    ArrayList arrayList2 = (ArrayList) this.f2068A5SV6n.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                        this.f2068A5SV6n.put(action, arrayList2);
                    }
                    arrayList2.add(a4TApA);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f2067A4TApA) {
            try {
                ArrayList arrayList = (ArrayList) this.f2067A4TApA.remove(broadcastReceiver);
                if (arrayList == null) {
                    return;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    A4TApA a4TApA = (A4TApA) arrayList.get(size);
                    a4TApA.f2063ADYaiT = true;
                    for (int i = 0; i < a4TApA.f2060A2egSU.countActions(); i++) {
                        String action = a4TApA.f2060A2egSU.getAction(i);
                        ArrayList arrayList2 = (ArrayList) this.f2068A5SV6n.get(action);
                        if (arrayList2 != null) {
                            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                                A4TApA a4TApA2 = (A4TApA) arrayList2.get(size2);
                                if (a4TApA2.f2061A4TApA == broadcastReceiver) {
                                    a4TApA2.f2063ADYaiT = true;
                                    arrayList2.remove(size2);
                                }
                            }
                            if (arrayList2.size() <= 0) {
                                this.f2068A5SV6n.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
