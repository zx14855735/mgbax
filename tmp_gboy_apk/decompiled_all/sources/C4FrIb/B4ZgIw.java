package C4FrIb;

import ADYaiT.D8MqeW;
import COJEAR.EGM26s;
import COJEAR.EUIRHA;
import L2suez.B9tovu;
import LLiCI0.CcAIMM;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.alliance.ssp.ad.activity.NMRewardVideoActivity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.game.boy.MyApp;
import com.game.boy.activity.EmulatorActivity;
import com.game.boy.activity.LayoutEditor;
import com.game.boy.activity.MainActivity;
import com.game.boy.emu.gba.Console;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B4ZgIw implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f1582AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Object f1583AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Object f1584AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public Object f1585AzWtSf;

    public /* synthetic */ B4ZgIw() {
        this.f1582AcNBzu = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        K1Z3yj.A2egSU a2egSU;
        AtomicBoolean atomicBoolean;
        String AYUAbz2;
        Nm94Z2.A5SV6n a5SV6n;
        OverScroller overScroller;
        int i = 2;
        int i2 = 3;
        int i3 = 4;
        int i4 = 1;
        Bitmap bitmap = null;
        Object obj = null;
        r6 = null;
        r6 = null;
        HashMap hashMap = null;
        File file = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        switch (this.f1582AcNBzu) {
            case 0:
                try {
                    obj = ((AaHO0E) this.f1583AlLFFp).call();
                } catch (Exception unused) {
                }
                ((Handler) this.f1585AzWtSf).post(new A2egSU((AZkASS) this.f1584AmA8tU, i4, obj));
                return;
            case 1:
                EGM26s.AYUAbz((View) this.f1583AlLFFp, (K1Z3yj.A2egSU) this.f1584AmA8tU);
                ((ValueAnimator) this.f1585AzWtSf).start();
                return;
            case 2:
                ((NMRewardVideoActivity) this.f1585AzWtSf).runOnUiThread(new A2egSU(this, NMRewardVideoActivity.A4TApA((String) this.f1583AlLFFp), i, objArr == true ? 1 : 0));
                return;
            case 3:
                Thread.currentThread().setUncaughtExceptionHandler(GJee0v.AlLFFp.f3048ADYaiT);
                GnQT2j.AaHO0E aaHO0E = (GnQT2j.AaHO0E) ((B4ZgIw) this.f1585AzWtSf).f1584AmA8tU;
                Bitmap bitmap2 = (Bitmap) this.f1583AlLFFp;
                if (bitmap2 != null) {
                    if (aaHO0E != null) {
                        aaHO0E.a(bitmap2);
                        return;
                    }
                    return;
                } else {
                    if (aaHO0E != null) {
                        Exception exc = (Exception) this.f1584AmA8tU;
                        if (exc != null) {
                            aaHO0E.a(exc);
                            return;
                        } else {
                            aaHO0E.a(new Exception("download image exception"));
                            return;
                        }
                    }
                    return;
                }
            case 4:
                Thread.currentThread().setUncaughtExceptionHandler(GJee0v.AlLFFp.f3048ADYaiT);
                try {
                    bitmap = GnQT2j.ARc23Z.A5SV6n((String) this.f1583AlLFFp);
                    e = null;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                }
                synchronized (com.bumptech.glide.A5SV6n.f9893AcNBzu) {
                    try {
                        if (com.bumptech.glide.A5SV6n.f9892AaHO0E == null) {
                            com.bumptech.glide.A5SV6n.f9892AaHO0E = new Handler(Looper.getMainLooper());
                        }
                    } finally {
                    }
                }
                com.bumptech.glide.A5SV6n.f9892AaHO0E.post(new B4ZgIw(i2, this, bitmap, e));
                if (bitmap == null || (a2egSU = ((GnQT2j.AcNBzu) this.f1585AzWtSf).f3129A2egSU) == null) {
                    return;
                }
                String str = (String) this.f1583AlLFFp;
                try {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    H0R8Px.ASJ6gh aSJ6gh = (H0R8Px.ASJ6gh) a2egSU.f4174AlLFFp;
                    if (aSJ6gh != null && !TextUtils.isEmpty(str)) {
                        aSJ6gh.f3152A2egSU.put(str, bitmap);
                    }
                    AZkASS.ARc23Z aRc23Z = (AZkASS.ARc23Z) a2egSU.f4175AmA8tU;
                    if (aRc23Z != null) {
                        aRc23Z.BI9f7h(str, bitmap);
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case 5:
                Uri uri = (Uri) this.f1584AmA8tU;
                MainActivity mainActivity = (MainActivity) this.f1583AlLFFp;
                try {
                    String AYUAbz3 = LCJm5h.ARc23Z.AYUAbz(mainActivity, uri);
                    if (AYUAbz3 == null) {
                        throw new IOException("无法获取文件名");
                    }
                    int AZOQYO2 = LCJm5h.ARc23Z.AZOQYO(AYUAbz3);
                    if (AZOQYO2 == -1) {
                        throw new IOException("不支持的文件类型: " + LCJm5h.ARc23Z.ARc23Z(AYUAbz3));
                    }
                    if (AZOQYO2 == 0 || AZOQYO2 == 4) {
                        StringBuilder sb = new StringBuilder("temp_verify_");
                        sb.append(System.currentTimeMillis());
                        sb.append(AZOQYO2 == 0 ? ".gba" : ".zip");
                        File file2 = new File(mainActivity.getCacheDir(), sb.toString());
                        if (!LCJm5h.ARc23Z.A4TApA(mainActivity, uri, file2)) {
                            throw new IOException("无法创建临时文件进行验证");
                        }
                        int AmA8tU2 = LCJm5h.ARc23Z.AmA8tU(file2);
                        file2.delete();
                        if (AmA8tU2 == 2) {
                            throw new IOException(AZOQYO2 == 0 ? "GBA文件可能已损坏，建议重新获取" : "ZIP压缩包中未找到GBA文件");
                        }
                        if (AmA8tU2 == 3) {
                            throw new IOException(AZOQYO2 == 0 ? "文件无法读取或格式不支持" : "ZIP压缩包损坏或无法读取");
                        }
                    }
                    LCJm5h.ARc23Z.f4430A4TApA.post(new D8MqeW(this, AZOQYO2, AYUAbz3));
                    return;
                } catch (Exception e3) {
                    LCJm5h.ARc23Z.f4430A4TApA.post(new A2egSU(this, e3, 15, objArr2 == true ? 1 : 0));
                    return;
                }
            case 6:
                Uri uri2 = (Uri) this.f1584AmA8tU;
                Context context = (Context) this.f1583AlLFFp;
                try {
                    try {
                        AYUAbz2 = LCJm5h.ARc23Z.AYUAbz(context, uri2);
                    } catch (Throwable th) {
                        AtomicBoolean atomicBoolean2 = LCJm5h.ARc23Z.f4431A5SV6n;
                        if (atomicBoolean2.get()) {
                            atomicBoolean2.set(false);
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                }
                if (AYUAbz2 == null) {
                    throw new IOException("无法获取文件名");
                }
                int AZOQYO3 = LCJm5h.ARc23Z.AZOQYO(AYUAbz2);
                if (AZOQYO3 == -1) {
                    throw new IOException("不支持的文件类型: " + LCJm5h.ARc23Z.ARc23Z(AYUAbz2));
                }
                File file3 = new File(context.getCacheDir(), "import_" + System.currentTimeMillis() + "_" + AYUAbz2);
                try {
                } catch (Exception e5) {
                    e = e5;
                    file = file3;
                    if (file != null && file.exists()) {
                        file.delete();
                    }
                    LCJm5h.ARc23Z.f4430A4TApA.post(new A2egSU(this, e, 16, objArr3 == true ? 1 : 0));
                    atomicBoolean = LCJm5h.ARc23Z.f4431A5SV6n;
                    if (!atomicBoolean.get()) {
                        return;
                    }
                    atomicBoolean.set(false);
                    return;
                }
                if (!LCJm5h.ARc23Z.A4TApA(context, uri2, file3)) {
                    throw new IOException("文件复制到临时目录失败");
                }
                if (AZOQYO3 == 0 || AZOQYO3 == 4) {
                    int AmA8tU3 = LCJm5h.ARc23Z.AmA8tU(file3);
                    if (AmA8tU3 == 2) {
                        throw new IOException(AZOQYO3 == 0 ? "GBA文件可能已损坏，建议重新获取" : "ZIP压缩包中未找到有效的GBA文件");
                    }
                    if (AmA8tU3 == 3) {
                        throw new IOException(AZOQYO3 == 0 ? "文件无法读取或格式不支持" : "ZIP压缩包损坏或无法读取");
                    }
                }
                String str2 = AZOQYO3 != 2 ? AZOQYO3 != 3 ? "GBoy/rom" : "GBoy/image" : "GBoy/save";
                File A2egSU2 = B9tovu.A2egSU(str2);
                if (!A2egSU2.exists()) {
                    throw new IOException("无法创建目标目录: ".concat(str2));
                }
                String A5SV6n2 = LCJm5h.ARc23Z.A5SV6n(A2egSU2, AYUAbz2);
                File file4 = new File(A2egSU2, A5SV6n2);
                boolean renameTo = file3.renameTo(file4);
                if (!renameTo) {
                    renameTo = LCJm5h.ARc23Z.ADYaiT(file3, file4);
                }
                if (!renameTo) {
                    throw new IOException("无法将文件移动到目标目录");
                }
                LCJm5h.ARc23Z.f4430A4TApA.post(new LCJm5h.ADYaiT(this, AZOQYO3, file4.length(), A5SV6n2));
                atomicBoolean = LCJm5h.ARc23Z.f4431A5SV6n;
                if (!atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(false);
                return;
            case 7:
                Queue queue = (Queue) ((LLYwnm.AYUAbz) this.f1585AzWtSf).f4632AYUAbz.get((String) this.f1583AlLFFp);
                if (queue == null) {
                    return;
                }
                Iterator it = queue.iterator();
                while (it.hasNext()) {
                    if (((LLYwnm.ASJ6gh) it.next()) == ((LLYwnm.ASJ6gh) this.f1584AmA8tU)) {
                        it.remove();
                        return;
                    }
                }
                return;
            case 8:
                AZOQYO.ARc23Z aRc23Z2 = (AZOQYO.ARc23Z) this.f1584AmA8tU;
                try {
                    LLYwnm.AcNBzu.A2egSU((LLYwnm.AcNBzu) this.f1585AzWtSf, L2suez.AYUAbz.f4368A2egSU.toJson((HashMap) this.f1583AlLFFp).getBytes(StandardCharsets.UTF_8), aRc23Z2);
                    return;
                } catch (Exception e6) {
                    if (aRc23Z2 != null) {
                        aRc23Z2.AcNBzu(null, "Map转换失败: " + e6.getMessage());
                        return;
                    }
                    return;
                }
            case 9:
                String str3 = (String) this.f1583AlLFFp;
                CcAIMM ccAIMM = (CcAIMM) this.f1585AzWtSf;
                try {
                    try {
                        File file5 = (File) com.bumptech.glide.A4TApA.ARc23Z(ccAIMM.f4786AcNBzu).AaHO0E(str3).BJ7GGh().get();
                        if (file5 != null && file5.exists()) {
                            CcAIMM.A2egSU(ccAIMM, file5, (String) this.f1584AmA8tU);
                        }
                    } finally {
                        ccAIMM.f4790B25kr6.remove(str3);
                    }
                } catch (Exception e7) {
                    e7.printStackTrace();
                    e7.getMessage();
                }
                return;
            case 10:
                View view = (View) this.f1584AmA8tU;
                if (view == null || (overScroller = (a5SV6n = (Nm94Z2.A5SV6n) this.f1585AzWtSf).f6055AzWtSf) == null) {
                    return;
                }
                boolean computeScrollOffset = overScroller.computeScrollOffset();
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f1583AlLFFp;
                if (!computeScrollOffset) {
                    a5SV6n.AaHO0E(coordinatorLayout, view);
                    return;
                } else {
                    a5SV6n.AlLFFp(coordinatorLayout, view, a5SV6n.f6055AzWtSf.getCurrY());
                    view.postOnAnimation(this);
                    return;
                }
            case 11:
                String absolutePath = ((File) this.f1584AmA8tU).getAbsolutePath();
                Console console = (Console) this.f1583AlLFFp;
                int loadState = console.loadState(absolutePath);
                if (loadState != 0) {
                    WeakReference weakReference = EmulatorActivity.f10988DG07BK;
                    MyApp.f10879AmA8tU.post(new KpHwm4.ARc23Z(loadState != -5 ? loadState != -4 ? loadState != -3 ? 2131886728 : 2131886731 : 2131886729 : 2131886730));
                    return;
                }
                EmulatorActivity emulatorActivity = (EmulatorActivity) this.f1585AzWtSf;
                if (emulatorActivity.f11015CSDoyG != null) {
                    try {
                        console.saveStateToMemory();
                    } catch (Exception unused2) {
                    }
                }
                AudioTrack audioTrack = emulatorActivity.f11022CqNSpT;
                if (audioTrack != null) {
                    audioTrack.flush();
                    return;
                }
                return;
            default:
                LayoutEditor layoutEditor = (LayoutEditor) this.f1585AzWtSf;
                HashMap hashMap2 = new HashMap();
                boolean z = layoutEditor.f11060B9tovu.getBoolean("enable_custom_icons", false);
                String string = layoutEditor.f11060B9tovu.getString("icon_pack_path", null);
                if (z && string != null) {
                    try {
                        hashMap = LayoutEditor.AmA8tU(string);
                    } catch (Exception unused3) {
                    }
                }
                Resources resources = (Resources) this.f1583AlLFFp;
                hashMap2.put("dpad", LayoutEditor.AlLFFp(resources, 2131230904, hashMap));
                hashMap2.put("a+b", LayoutEditor.AlLFFp(resources, 2131230875, hashMap));
                hashMap2.put(t.f, LayoutEditor.AlLFFp(resources, 2131230760, hashMap));
                hashMap2.put(t.l, LayoutEditor.AlLFFp(resources, 2131230846, hashMap));
                hashMap2.put("tl", LayoutEditor.AlLFFp(resources, 2131231323, hashMap));
                hashMap2.put("tr", LayoutEditor.AlLFFp(resources, 2131231502, hashMap));
                hashMap2.put("tl+tr", LayoutEditor.AlLFFp(resources, 2131231332, hashMap));
                hashMap2.put("tl+a", LayoutEditor.AlLFFp(resources, 2131231325, hashMap));
                hashMap2.put("tl+b", LayoutEditor.AlLFFp(resources, 2131231327, hashMap));
                hashMap2.put("tr+a", LayoutEditor.AlLFFp(resources, 2131231504, hashMap));
                hashMap2.put("tr+b", LayoutEditor.AlLFFp(resources, 2131231506, hashMap));
                hashMap2.put("select", LayoutEditor.AlLFFp(resources, 2131231517, hashMap));
                hashMap2.put("start", LayoutEditor.AlLFFp(resources, 2131231545, hashMap));
                hashMap2.put("menu", LayoutEditor.AlLFFp(resources, 2131231356, hashMap));
                hashMap2.put("turbo_a", LayoutEditor.AlLFFp(resources, 2131230762, hashMap));
                hashMap2.put("turbo_b", LayoutEditor.AlLFFp(resources, 2131230848, hashMap));
                hashMap2.put("load", LayoutEditor.AlLFFp(resources, 2131231331, hashMap));
                hashMap2.put("save", LayoutEditor.AlLFFp(resources, 2131231515, hashMap));
                hashMap2.put("ff", LayoutEditor.AlLFFp(resources, 2131231544, hashMap));
                hashMap2.put("rewind", LayoutEditor.AlLFFp(resources, 2131231509, hashMap));
                hashMap2.put("ss", LayoutEditor.AlLFFp(resources, 2131231516, hashMap));
                int i5 = L2suez.AMqCpz.f4363A2egSU;
                Bitmap createBitmap = Bitmap.createBitmap(MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA, 160, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawColor(0);
                Paint paint = new Paint();
                paint.setColor(L2suez.AMqCpz.f4363A2egSU);
                paint.setStrokeWidth(1.0f);
                Path path = new Path();
                int i6 = 0;
                while (true) {
                    float f = 0.0f;
                    if (i6 > 160) {
                        int i7 = 0;
                        while (i7 <= 240) {
                            float f2 = i7;
                            path.moveTo(f2, f);
                            path.lineTo(f2, 160.0f);
                            i7++;
                            f = 0.0f;
                        }
                        canvas.drawPath(path, paint);
                        Paint paint2 = new Paint();
                        paint2.setColor(L2suez.AMqCpz.f4364A4TApA);
                        paint2.setStrokeWidth(1.0f);
                        for (int i8 = 0; i8 <= 160; i8 += 8) {
                            float f3 = i8;
                            canvas.drawLine(0.0f, f3, 240.0f, f3, paint2);
                        }
                        for (int i9 = 0; i9 <= 240; i9 += 8) {
                            float f4 = i9;
                            canvas.drawLine(f4, 0.0f, f4, 160.0f, paint2);
                        }
                        hashMap2.put("video", createBitmap);
                        LayoutEditor.f11052BChYOn = Collections.unmodifiableMap(hashMap2);
                        layoutEditor.runOnUiThread(new com.game.boy.activity.ASJ6gh(i3, this));
                        return;
                    }
                    float f5 = i6;
                    path.moveTo(0.0f, f5);
                    path.lineTo(240.0f, f5);
                    i6++;
                }
        }
    }

    public /* synthetic */ B4ZgIw(int i, Object obj, Object obj2, Object obj3) {
        this.f1582AcNBzu = i;
        this.f1585AzWtSf = obj;
        this.f1583AlLFFp = obj2;
        this.f1584AmA8tU = obj3;
    }

    public /* synthetic */ B4ZgIw(Context context, Uri uri, Object obj, int i) {
        this.f1582AcNBzu = i;
        this.f1583AlLFFp = context;
        this.f1584AmA8tU = uri;
        this.f1585AzWtSf = obj;
    }

    public B4ZgIw(View view, EUIRHA euirha, K1Z3yj.A2egSU a2egSU, ValueAnimator valueAnimator) {
        this.f1582AcNBzu = 1;
        this.f1583AlLFFp = view;
        this.f1584AmA8tU = a2egSU;
        this.f1585AzWtSf = valueAnimator;
    }
}
