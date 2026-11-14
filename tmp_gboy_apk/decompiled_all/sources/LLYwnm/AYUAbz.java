package LLYwnm;

import C4FrIb.B4ZgIw;
import android.os.Handler;
import android.os.Looper;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.czhj.sdk.common.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AYUAbz {

    /* renamed from: AaHO0E, reason: collision with root package name */
    public static final Gson f4624AaHO0E = new Gson();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final Type f4625AcNBzu = TypeToken.getParameterized(Map.class, String.class, Object.class).getType();

    /* renamed from: A4TApA, reason: collision with root package name */
    public volatile String f4627A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public volatile String f4628A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final CopyOnWriteArrayList f4629ADYaiT = new CopyOnWriteArrayList();
    public final CopyOnWriteArrayList AMqCpz = new CopyOnWriteArrayList();

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final CopyOnWriteArrayList f4630ARc23Z = new CopyOnWriteArrayList();

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final CopyOnWriteArrayList f4631ASJ6gh = new CopyOnWriteArrayList();

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final ConcurrentHashMap f4632AYUAbz = new ConcurrentHashMap();

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final ScheduledExecutorService f4633AZOQYO = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: AZkASS, reason: collision with root package name */
    public final Handler f4634AZkASS = new Handler(Looper.getMainLooper());

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AcNBzu f4626A2egSU = new AcNBzu(this);

    static {
        Egqcr();
    }

    public static boolean A2egSU(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : "true".equalsIgnoreCase(String.valueOf(obj));
    }

    public static String A4TApA(Object obj) {
        if (obj == null) {
            return null;
        }
        return String.valueOf(obj);
    }

    private static /* synthetic */ void Egqcr() {
        char[] charArray = "¡\u00ad¯ì¥£¯§ì \u00ad»ì±ª§®®ì\u0088¬«\u0080°«¦¥§".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 194);
        }
        String str = new String(charArray);
        char[] charArray2 = "¡®«¬«¶".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 194);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A5SV6n(Runnable runnable) {
        this.f4634AZkASS.post(runnable);
    }

    public final void ADYaiT(String str, String str2, LHpdLt.A4TApA a4TApA) {
        if (str == null) {
            if (a4TApA != null) {
                A5SV6n(new AMqCpz(0, a4TApA));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("action", "send_message");
        hashMap.put("message", str);
        if (str2 != null && !str2.isEmpty()) {
            hashMap.put("roomID", str2);
        }
        if (this.f4628A5SV6n != null && !this.f4628A5SV6n.isEmpty()) {
            hashMap.put("uuid", this.f4628A5SV6n);
        }
        ARc23Z(hashMap, "send_message", a4TApA);
    }

    public final void AMqCpz(String str) {
        HashMap BI9f7h2 = J3FDQU.A2egSU.BI9f7h("action", "join_room");
        if (str != null && !str.isEmpty()) {
            BI9f7h2.put("room_id", str);
        }
        ARc23Z(BI9f7h2, null, null);
    }

    public final void ARc23Z(HashMap hashMap, String str, B25kr6 b25kr6) {
        ASJ6gh aSJ6gh;
        if (this.f4627A4TApA == null || this.f4627A4TApA.isEmpty()) {
            if (b25kr6 != null) {
                A5SV6n(new AMqCpz(1, b25kr6));
                return;
            }
            return;
        }
        hashMap.put(Constants.TOKEN, this.f4627A4TApA);
        AZOQYO.ARc23Z aRc23Z = null;
        if (b25kr6 == null || str == null) {
            aSJ6gh = null;
        } else {
            aSJ6gh = new ASJ6gh(b25kr6);
            Queue queue = (Queue) this.f4632AYUAbz.get(str);
            if (queue == null) {
                queue = new ConcurrentLinkedQueue();
                Queue queue2 = (Queue) this.f4632AYUAbz.putIfAbsent(str, queue);
                if (queue2 != null) {
                    queue = queue2;
                }
            }
            queue.offer(aSJ6gh);
            aSJ6gh.f4623A4TApA = this.f4633AZOQYO.schedule(new B4ZgIw(7, this, str, aSJ6gh), ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS);
        }
        if (b25kr6 != null) {
            aRc23Z = new AZOQYO.ARc23Z();
            aRc23Z.f366AzWtSf = this;
            aRc23Z.f363AcNBzu = b25kr6;
            aRc23Z.f364AlLFFp = aSJ6gh;
            aRc23Z.f365AmA8tU = str;
        }
        this.f4626A2egSU.ARc23Z(hashMap, aRc23Z);
    }
}
