package MOpbMP;

import com.game.boy.activity.MainActivity;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BmvVmW {

    /* renamed from: A2egSU, reason: collision with root package name */
    public boolean f5056A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final CopyOnWriteArrayList f5057A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public androidx.activity.B7CMnp f5058A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ int f5059ADYaiT;
    public final /* synthetic */ Object AMqCpz;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BmvVmW(int i, Object obj) {
        this(false);
        this.f5059ADYaiT = i;
        this.AMqCpz = obj;
    }

    public BmvVmW(boolean z) {
        this.f5056A2egSU = z;
        this.f5057A4TApA = new CopyOnWriteArrayList();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BmvVmW(MainActivity mainActivity) {
        this(true);
        this.f5059ADYaiT = 2;
        this.AMqCpz = mainActivity;
    }
}
