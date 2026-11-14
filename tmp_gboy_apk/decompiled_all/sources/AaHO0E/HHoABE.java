package AaHO0E;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class HHoABE {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Object f926A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Object f927A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Object f928A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final Object f929ADYaiT;
    public final Object AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final Object f930ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public Object f931ASJ6gh;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.Map] */
    public HHoABE(HashSet hashSet, QkAq4X.A4TApA a4TApA, String str, String str2, NGepWW.BI9f7h bI9f7h) {
        Set unmodifiableSet = hashSet == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(hashSet);
        this.f926A2egSU = unmodifiableSet;
        QkAq4X.A4TApA a4TApA2 = a4TApA == null ? Collections.EMPTY_MAP : a4TApA;
        this.f928A5SV6n = a4TApA2;
        this.f929ADYaiT = str;
        this.AMqCpz = str2;
        this.f930ARc23Z = bI9f7h;
        HashSet hashSet2 = new HashSet(unmodifiableSet);
        Iterator it = a4TApA2.values().iterator();
        if (it.hasNext()) {
            throw ADYaiT.CtFAbx.A5SV6n(it);
        }
        this.f927A4TApA = Collections.unmodifiableSet(hashSet2);
    }

    public HHoABE(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f929ADYaiT = layoutParams;
        this.AMqCpz = new Rect();
        this.f930ARc23Z = new int[2];
        this.f931ASJ6gh = new int[2];
        this.f926A2egSU = context;
        View inflate = LayoutInflater.from(context).inflate(2131492893, (ViewGroup) null);
        this.f927A4TApA = inflate;
        this.f928A5SV6n = (TextView) inflate.findViewById(2131297642);
        layoutParams.setTitle(HHoABE.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = 2131951621;
        layoutParams.flags = 24;
    }

    public HHoABE(HieBYM.A5SV6n a5SV6n, HieBYM.A5SV6n a5SV6n2, HieBYM.A5SV6n a5SV6n3, HieBYM.A5SV6n a5SV6n4, HXc4pW.AzWtSf azWtSf, HXc4pW.AzWtSf azWtSf2) {
        this.f931ASJ6gh = Ixu71n.A5SV6n.A2egSU(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS, new KCxDWD.A5SV6n(24, this));
        this.f926A2egSU = a5SV6n;
        this.f927A4TApA = a5SV6n2;
        this.f928A5SV6n = a5SV6n3;
        this.f929ADYaiT = a5SV6n4;
        this.AMqCpz = azWtSf;
        this.f930ARc23Z = azWtSf2;
    }
}
