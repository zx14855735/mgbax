package NGepWW;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.bykv.vk.component.ttvideo.player.C;
import com.google.android.gms.common.api.GoogleApiActivity;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class EicXu4 implements Handler.Callback {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static final NSK3xo.A4TApA f5834B4ZgIw = new NSK3xo.A4TApA(4, "Sign-out occurred while this API call was in progress.");

    /* renamed from: B7CMnp, reason: collision with root package name */
    public static final NSK3xo.A4TApA f5835B7CMnp = new NSK3xo.A4TApA(4, "The user must be signed in to make this API call.");

    /* renamed from: B9tovu, reason: collision with root package name */
    public static final Object f5836B9tovu = new Object();

    /* renamed from: BChYOn, reason: collision with root package name */
    public static EicXu4 f5837BChYOn;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Context f5838AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final NOd7IU.ADYaiT f5839AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f5840AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final AtomicInteger f5841AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final ConcurrentHashMap f5842B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final NasM11.A2egSU f5843B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final Handler f5844B3GDIM;

    static {
        RIPfMuf();
    }

    public EicXu4(Context context, Looper looper) {
        NOd7IU.ADYaiT aDYaiT = NOd7IU.ADYaiT.f5861A4TApA;
        this.f5840AmA8tU = -1;
        new AtomicInteger(1);
        this.f5841AzWtSf = new AtomicInteger(0);
        this.f5842B25kr6 = new ConcurrentHashMap(5, 0.75f, 1);
        new NasM11.A2egSU();
        this.f5843B2KMhB = new NasM11.A2egSU();
        this.f5838AcNBzu = context;
        this.f5844B3GDIM = new Handler(looper, this);
        this.f5839AlLFFp = aDYaiT;
    }

    public static EicXu4 A2egSU(Context context) {
        EicXu4 eicXu4;
        synchronized (f5836B9tovu) {
            try {
                if (f5837BChYOn == null) {
                    HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                    handlerThread.start();
                    Looper looper = handlerThread.getLooper();
                    Context applicationContext = context.getApplicationContext();
                    NOd7IU.ADYaiT aDYaiT = NOd7IU.ADYaiT.f5861A4TApA;
                    f5837BChYOn = new EicXu4(applicationContext, looper);
                }
                eicXu4 = f5837BChYOn;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eicXu4;
    }

    private static /* synthetic */ void RIPfMuf() {
        char[] charArray = "($&e,*&.e)$2e8#.''e\u0001%\"\t9\"/,.".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'K');
        }
        String str = new String(charArray);
        char[] charArray2 = "('\"%\"?".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'K');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final boolean A4TApA(NOd7IU.A2egSU a2egSU, int i) {
        PendingIntent pendingIntent;
        boolean A4TApA2 = a2egSU.A4TApA();
        NOd7IU.ADYaiT aDYaiT = this.f5839AlLFFp;
        int i2 = a2egSU.f5854AlLFFp;
        if (!A4TApA2 && !aDYaiT.A4TApA(i2)) {
            return false;
        }
        aDYaiT.getClass();
        boolean A4TApA3 = a2egSU.A4TApA();
        Context context = this.f5838AcNBzu;
        if (A4TApA3) {
            pendingIntent = a2egSU.f5855AmA8tU;
        } else {
            pendingIntent = null;
            Intent ADYaiT2 = aDYaiT.ADYaiT(context, i2, null);
            if (ADYaiT2 != null) {
                pendingIntent = PendingIntent.getActivity(context, 0, ADYaiT2, C.ENCODING_PCM_MU_LAW);
            }
        }
        if (pendingIntent != null) {
            int i3 = GoogleApiActivity.f11210AlLFFp;
            Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
            intent.putExtra("pending_intent", pendingIntent);
            intent.putExtra("failing_client_id", i);
            intent.putExtra("notify_manager", true);
            aDYaiT.AMqCpz(context, i2, PendingIntent.getActivity(context, 0, intent, 134217728));
        }
        return true;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        NasM11.A2egSU a2egSU = this.f5843B2KMhB;
        int i = message.what;
        ConcurrentHashMap concurrentHashMap = this.f5842B25kr6;
        EdhSi6 edhSi6 = null;
        switch (i) {
            case 1:
                ((D9tr6l) message.obj).getClass();
                throw null;
            case 2:
                for (EdhSi6 edhSi62 : concurrentHashMap.values()) {
                    NUY5pn.AYUAbz.A2egSU(edhSi62.f5821A2egSU.f5844B3GDIM);
                    edhSi62.f5829AZkASS = null;
                    edhSi62.ARc23Z();
                }
                return true;
            case 3:
            case 6:
            case 11:
                ((F1loUV) message.obj).getClass();
                throw null;
            case 4:
                int i2 = message.arg1;
                NOd7IU.A2egSU a2egSU2 = (NOd7IU.A2egSU) message.obj;
                Iterator it = concurrentHashMap.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        EdhSi6 edhSi63 = (EdhSi6) it.next();
                        if (edhSi63.f5826ASJ6gh == i2) {
                            edhSi6 = edhSi63;
                        }
                    }
                }
                if (edhSi6 != null) {
                    int i3 = a2egSU2.f5854AlLFFp;
                    this.f5839AlLFFp.getClass();
                    int i4 = NOd7IU.AMqCpz.AMqCpz;
                    String valueOf = String.valueOf(NOd7IU.A2egSU.A2egSU(i3));
                    String valueOf2 = String.valueOf(a2egSU2.f5856AzWtSf);
                    edhSi6.A5SV6n(new NSK3xo.A4TApA(17, com.bykv.vk.component.ttvideo.player.A2egSU.AzWtSf(new StringBuilder(valueOf2.length() + valueOf.length() + 69), "Error resolution was canceled by the user, original error message: ", valueOf, ": ", valueOf2)));
                } else {
                    StringBuilder sb = new StringBuilder(76);
                    sb.append("Could not find API instance ");
                    sb.append(i2);
                    sb.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb.toString(), new Exception());
                }
                return true;
            case 5:
                B7CMnp b7CMnp = (B7CMnp) message.obj;
                b7CMnp.getClass();
                if (!concurrentHashMap.containsKey(null)) {
                    concurrentHashMap.put(null, new EdhSi6(this, b7CMnp));
                }
                EdhSi6 edhSi64 = (EdhSi6) concurrentHashMap.get(null);
                if (edhSi64.f5823A5SV6n.i()) {
                    a2egSU.add(null);
                }
                edhSi64.ARc23Z();
                return true;
            case 7:
                if (concurrentHashMap.containsKey(message.obj)) {
                    EdhSi6 edhSi65 = (EdhSi6) concurrentHashMap.get(message.obj);
                    NUY5pn.AYUAbz.A2egSU(edhSi65.f5821A2egSU.f5844B3GDIM);
                    if (edhSi65.f5828AZOQYO) {
                        edhSi65.ARc23Z();
                    }
                }
                return true;
            case 8:
                Iterator it2 = a2egSU.iterator();
                while (it2.hasNext()) {
                    EdhSi6 edhSi66 = (EdhSi6) concurrentHashMap.remove((D8cQ8b) it2.next());
                    NUY5pn.AYUAbz.A2egSU(edhSi66.f5821A2egSU.f5844B3GDIM);
                    NSK3xo.A4TApA a4TApA = f5834B4ZgIw;
                    edhSi66.A5SV6n(a4TApA);
                    DXuj49 dXuj49 = edhSi66.f5824ADYaiT;
                    dXuj49.getClass();
                    dXuj49.A2egSU(false, a4TApA);
                    Iterator it3 = edhSi66.f5825ARc23Z.keySet().iterator();
                    while (it3.hasNext()) {
                        if (it3.next() != null) {
                            throw new ClassCastException();
                        }
                        D6yqiO d6yqiO = new D6yqiO(new NIA37H.A4TApA());
                        NUY5pn.AYUAbz.A2egSU(edhSi66.f5821A2egSU.f5844B3GDIM);
                        NSK3xo.ARc23Z aRc23Z = edhSi66.f5823A5SV6n;
                        if (((NUY5pn.BJ7GGh) aRc23Z).AZOQYO()) {
                            aRc23Z.i();
                            DXuj49 dXuj492 = edhSi66.f5824ADYaiT;
                            try {
                                d6yqiO.A5SV6n(edhSi66);
                            } catch (DeadObjectException unused) {
                                edhSi66.a(1);
                                ((NUY5pn.BJ7GGh) aRc23Z).AYUAbz();
                            }
                            edhSi66.AZOQYO();
                        } else {
                            edhSi66.f5822A4TApA.add(d6yqiO);
                            NOd7IU.A2egSU a2egSU3 = edhSi66.f5829AZkASS;
                            if (a2egSU3 == null || !a2egSU3.A4TApA()) {
                                edhSi66.ARc23Z();
                            } else {
                                edhSi66.A4TApA(edhSi66.f5829AZkASS);
                            }
                        }
                    }
                    ((NUY5pn.BJ7GGh) edhSi66.f5823A5SV6n).AYUAbz();
                }
                a2egSU.clear();
                return true;
            case 9:
                if (concurrentHashMap.containsKey(message.obj)) {
                    EdhSi6 edhSi67 = (EdhSi6) concurrentHashMap.get(message.obj);
                    EicXu4 eicXu4 = edhSi67.f5821A2egSU;
                    NUY5pn.AYUAbz.A2egSU(eicXu4.f5844B3GDIM);
                    boolean z = edhSi67.f5828AZOQYO;
                    if (z) {
                        if (z) {
                            EicXu4 eicXu42 = edhSi67.f5821A2egSU;
                            eicXu42.f5844B3GDIM.removeMessages(9, null);
                            eicXu42.f5844B3GDIM.removeMessages(7, null);
                            edhSi67.f5828AZOQYO = false;
                        }
                        edhSi67.A5SV6n(eicXu4.f5839AlLFFp.A2egSU(eicXu4.f5838AcNBzu) == 18 ? new NSK3xo.A4TApA(8, "Connection timed out while waiting for Google Play services update to complete.") : new NSK3xo.A4TApA(8, "API failed to connect while resuming due to an unknown error."));
                        ((NUY5pn.BJ7GGh) edhSi67.f5823A5SV6n).AYUAbz();
                    }
                }
                return true;
            case 10:
                if (concurrentHashMap.containsKey(message.obj)) {
                    EdhSi6 edhSi68 = (EdhSi6) concurrentHashMap.get(message.obj);
                    NUY5pn.AYUAbz.A2egSU(edhSi68.f5821A2egSU.f5844B3GDIM);
                    NUY5pn.BJ7GGh bJ7GGh = (NUY5pn.BJ7GGh) edhSi68.f5823A5SV6n;
                    if (bJ7GGh.AZOQYO() && edhSi68.f5825ARc23Z.size() == 0) {
                        DXuj49 dXuj493 = edhSi68.f5824ADYaiT;
                        if (dXuj493.f5736A2egSU.isEmpty() && dXuj493.f5737A4TApA.isEmpty()) {
                            bJ7GGh.AYUAbz();
                        } else {
                            edhSi68.AZOQYO();
                        }
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
