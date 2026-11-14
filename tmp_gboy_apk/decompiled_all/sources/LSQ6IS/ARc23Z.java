package LSQ6IS;

import COJEAR.BpkvW3;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.graphics.RectF;
import android.preference.PreferenceManager;
import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.game.boy.viewUi.GameSurfaceView;
import com.sigmob.sdk.downloader.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z extends LQ734U.A2egSU implements View.OnTouchListener {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Mm8v1u.ARc23Z f4849AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Context f4850AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final SharedPreferences f4851B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final GameSurfaceView f4852B2KMhB;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public BpkvW3 f4855B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f4856B9tovu;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final ArrayList f4853B3GDIM = new ArrayList(10);

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final SparseArray f4854B4ZgIw = new SparseArray(4);

    /* renamed from: BChYOn, reason: collision with root package name */
    public final HashMap f4857BChYOn = new HashMap();

    public ARc23Z(GameSurfaceView gameSurfaceView) {
        this.f4852B2KMhB = gameSurfaceView;
        gameSurfaceView.setOnTouchListener(this);
        Context context = gameSurfaceView.getContext();
        this.f4850AzWtSf = context;
        this.f4851B25kr6 = PreferenceManager.getDefaultSharedPreferences(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [LSQ6IS.A4TApA] */
    /* JADX WARN: Type inference failed for: r7v10, types: [LSQ6IS.A2egSU, LSQ6IS.A4TApA] */
    /* JADX WARN: Type inference failed for: r7v11, types: [LSQ6IS.A2egSU, LSQ6IS.A4TApA] */
    /* JADX WARN: Type inference failed for: r7v12, types: [LSQ6IS.A2egSU, LSQ6IS.A4TApA] */
    /* JADX WARN: Type inference failed for: r7v13, types: [LSQ6IS.A2egSU, LSQ6IS.A4TApA] */
    /* JADX WARN: Type inference failed for: r7v14, types: [LSQ6IS.A4TApA, LSQ6IS.A5SV6n] */
    /* JADX WARN: Type inference failed for: r7v15, types: [LSQ6IS.A2egSU, LSQ6IS.A4TApA] */
    /* JADX WARN: Type inference failed for: r7v16, types: [LSQ6IS.A2egSU, LSQ6IS.A4TApA] */
    /* JADX WARN: Type inference failed for: r7v17, types: [LSQ6IS.A2egSU, LSQ6IS.A4TApA] */
    /* JADX WARN: Type inference failed for: r7v18, types: [LSQ6IS.A2egSU, LSQ6IS.A4TApA] */
    /* JADX WARN: Type inference failed for: r7v19, types: [LSQ6IS.A2egSU, LSQ6IS.A4TApA] */
    /* JADX WARN: Type inference failed for: r7v2, types: [LSQ6IS.A2egSU, LSQ6IS.A4TApA] */
    /* JADX WARN: Type inference failed for: r7v20, types: [LSQ6IS.A2egSU, LSQ6IS.A4TApA] */
    /* JADX WARN: Type inference failed for: r7v21, types: [LSQ6IS.A2egSU, LSQ6IS.A4TApA] */
    /* JADX WARN: Type inference failed for: r7v22, types: [LSQ6IS.A2egSU, LSQ6IS.A4TApA] */
    /* JADX WARN: Type inference failed for: r7v23, types: [LSQ6IS.A2egSU, LSQ6IS.A4TApA] */
    /* JADX WARN: Type inference failed for: r7v24, types: [LSQ6IS.A4TApA, LSQ6IS.ADYaiT] */
    /* JADX WARN: Type inference failed for: r7v3, types: [LSQ6IS.A2egSU, LSQ6IS.A4TApA] */
    /* JADX WARN: Type inference failed for: r7v4, types: [LSQ6IS.A2egSU, LSQ6IS.A4TApA] */
    /* JADX WARN: Type inference failed for: r7v5, types: [LSQ6IS.A2egSU, LSQ6IS.A4TApA] */
    /* JADX WARN: Type inference failed for: r7v6, types: [LSQ6IS.A2egSU, LSQ6IS.A4TApA] */
    /* JADX WARN: Type inference failed for: r7v7, types: [LSQ6IS.A2egSU, LSQ6IS.A4TApA] */
    /* JADX WARN: Type inference failed for: r7v8, types: [LSQ6IS.A4TApA, LSQ6IS.ADYaiT] */
    /* JADX WARN: Type inference failed for: r7v9, types: [LSQ6IS.A2egSU, LSQ6IS.A4TApA] */
    public static A4TApA ARc23Z(ARc23Z aRc23Z, String str, Rect rect, SharedPreferences sharedPreferences, Mm8v1u.ARc23Z aRc23Z2) {
        boolean equals = "video".equals(str);
        GameSurfaceView gameSurfaceView = aRc23Z.f4852B2KMhB;
        ?? r7 = 0;
        if (equals) {
            gameSurfaceView.setSkipRect(new RectF(rect));
            return null;
        }
        RectF rectF = new RectF(rect);
        gameSurfaceView.getClass();
        if (str != null) {
            gameSurfaceView.f11159B4ZgIw.put(str, new Mm8v1u.ADYaiT(gameSurfaceView.getContext(), str, rectF, aRc23Z2));
            gameSurfaceView.f11175CNPG0E = true;
        }
        str.getClass();
        switch (str) {
            case "turbo_a":
                r7 = new A2egSU(f.a.c);
                Rect rect2 = LXWm8h.A2egSU.f4858ARc23Z;
                r7.A4TApA(rect);
                break;
            case "turbo_b":
                r7 = new A2egSU(ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
                Rect rect3 = LXWm8h.A2egSU.f4858ARc23Z;
                r7.A4TApA(rect);
                break;
            case "rewind":
                r7 = new A2egSU(772);
                Rect rect4 = LXWm8h.A2egSU.f4858ARc23Z;
                r7.A4TApA(rect);
                break;
            case "select":
                r7 = new A2egSU(4);
                Rect rect5 = LXWm8h.A2egSU.f4858ARc23Z;
                r7.A4TApA(rect);
                break;
            case "a":
                r7 = new A2egSU(1);
                Rect rect6 = LXWm8h.A2egSU.f4858ARc23Z;
                r7.A4TApA(rect);
                break;
            case "b":
                r7 = new A2egSU(2);
                Rect rect7 = LXWm8h.A2egSU.f4858ARc23Z;
                r7.A4TApA(rect);
                break;
            case "ab":
                r7 = new ADYaiT(2, 1);
                r7.f4846ASJ6gh = sharedPreferences.getBoolean("abButtonPress", false);
                Rect rect8 = LXWm8h.A2egSU.f4858ARc23Z;
                r7.A4TApA(rect);
                break;
            case "ff":
                r7 = new A2egSU(262144);
                Rect rect9 = LXWm8h.A2egSU.f4858ARc23Z;
                r7.A4TApA(rect);
                break;
            case "ss":
                r7 = new A2egSU(524288);
                Rect rect10 = LXWm8h.A2egSU.f4858ARc23Z;
                r7.A4TApA(rect);
                break;
            case "tl":
                r7 = new A2egSU(512);
                Rect rect11 = LXWm8h.A2egSU.f4858ARc23Z;
                r7.A4TApA(rect);
                break;
            case "tr":
                r7 = new A2egSU(256);
                Rect rect12 = LXWm8h.A2egSU.f4858ARc23Z;
                r7.A4TApA(rect);
                break;
            case "a+b":
                r7 = new A2egSU(3);
                Rect rect13 = LXWm8h.A2egSU.f4858ARc23Z;
                r7.A4TApA(rect);
                break;
            case "dpad":
                r7 = new A5SV6n();
                r7.AMqCpz = sharedPreferences.getBoolean("dpad4Way", false);
                Rect rect14 = LXWm8h.A2egSU.f4858ARc23Z;
                r7.A4TApA(rect);
                break;
            case "load":
                r7 = new A2egSU(65536);
                Rect rect15 = LXWm8h.A2egSU.f4858ARc23Z;
                r7.A4TApA(rect);
                break;
            case "menu":
                r7 = new A2egSU(1048576);
                Rect rect16 = LXWm8h.A2egSU.f4858ARc23Z;
                r7.A4TApA(rect);
                break;
            case "save":
                r7 = new A2egSU(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                Rect rect17 = LXWm8h.A2egSU.f4858ARc23Z;
                r7.A4TApA(rect);
                break;
            case "tl+a":
                r7 = new A2egSU(MediaPlayer.MEDIA_PLAYER_OPTION_MODULE_ID);
                Rect rect18 = LXWm8h.A2egSU.f4858ARc23Z;
                r7.A4TApA(rect);
                break;
            case "tl+b":
                r7 = new A2egSU(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE);
                Rect rect19 = LXWm8h.A2egSU.f4858ARc23Z;
                r7.A4TApA(rect);
                break;
            case "tr+a":
                r7 = new A2egSU(257);
                Rect rect20 = LXWm8h.A2egSU.f4858ARc23Z;
                r7.A4TApA(rect);
                break;
            case "tr+b":
                r7 = new A2egSU(MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE);
                Rect rect21 = LXWm8h.A2egSU.f4858ARc23Z;
                r7.A4TApA(rect);
                break;
            case "start":
                r7 = new A2egSU(8);
                Rect rect22 = LXWm8h.A2egSU.f4858ARc23Z;
                r7.A4TApA(rect);
                break;
            case "tl+tr":
                r7 = new A2egSU(768);
                Rect rect23 = LXWm8h.A2egSU.f4858ARc23Z;
                r7.A4TApA(rect);
                break;
            case "turbo_ab":
                r7 = new ADYaiT(ProxyCacheUtils.DEFAULT_BUFFER_SIZE, f.a.c);
                r7.f4846ASJ6gh = sharedPreferences.getBoolean("abButtonPress", false);
                Rect rect24 = LXWm8h.A2egSU.f4858ARc23Z;
                r7.A4TApA(rect);
                break;
        }
        r7.f4842A4TApA = gameSurfaceView;
        r7.f4844ADYaiT = str;
        return r7;
    }

    @Override // LQ734U.A2egSU
    public final void A2egSU(int i) {
        BpkvW3 bpkvW3 = this.f4855B7CMnp;
        if (bpkvW3 != null && ((this.f4823AcNBzu ^ i) & i) != 0) {
            bpkvW3.f1656A2egSU.performHapticFeedback(1, 3);
        }
        super.A2egSU(i);
    }

    @Override // LQ734U.A2egSU
    public final void A4TApA(SharedPreferences sharedPreferences) {
        if (!sharedPreferences.getBoolean("enableVibrator", false)) {
            this.f4855B7CMnp = null;
        } else if (this.f4855B7CMnp == null) {
            this.f4855B7CMnp = new BpkvW3(this.f4852B2KMhB);
        }
        int i = sharedPreferences.getInt("controlsSensitivity", 7);
        if (i > 0 && i < 10) {
            int i2 = (this.f4850AzWtSf.getResources().getDisplayMetrics().densityDpi * 10) / (10 - i);
        }
    }

    @Override // LQ734U.A2egSU
    public final void A5SV6n() {
        this.f4824AlLFFp = null;
        this.f4852B2KMhB.setOnTouchListener(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r2 != 6) goto L92;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01c5 A[LOOP:0: B:24:0x01bf->B:26:0x01c5, LOOP_END] */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r20, android.view.MotionEvent r21) {
        /*
            Method dump skipped, instructions count: 469
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: LSQ6IS.ARc23Z.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
