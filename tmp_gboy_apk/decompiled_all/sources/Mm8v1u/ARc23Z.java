package Mm8v1u;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final HashMap f5483A2egSU = new HashMap();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Context f5484A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public String f5485A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public long f5486ADYaiT;
    public boolean AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final I3HV03.A4TApA f5487ARc23Z;

    public ARc23Z(Context context) {
        this.f5484A4TApA = context;
        I3HV03.A4TApA a4TApA = new I3HV03.A4TApA(context, (String) null);
        this.f5487ARc23Z = a4TApA;
        boolean z = ((SharedPreferences) a4TApA.f3808AlLFFp).getBoolean("enable_custom_icons", false);
        String string = ((SharedPreferences) a4TApA.f3808AlLFFp).getString("icon_pack_path", null);
        this.f5485A5SV6n = string;
        this.AMqCpz = z;
        if (!z || string == null) {
            return;
        }
        File file = new File(string);
        if (file.exists()) {
            this.f5486ADYaiT = file.lastModified();
            A4TApA();
        }
    }

    public final Bitmap A2egSU(String str, boolean z) {
        I3HV03.A4TApA a4TApA = this.f5487ARc23Z;
        if (a4TApA.AzWtSf("enable_custom_icons") && a4TApA.B25kr6("icon_pack_path") != null && new File(a4TApA.B25kr6("icon_pack_path")).exists()) {
            HashMap hashMap = this.f5483A2egSU;
            Bitmap bitmap = (Bitmap) hashMap.get(str);
            if (bitmap != null && !bitmap.isRecycled()) {
                return bitmap;
            }
            if (bitmap != null) {
                hashMap.remove(str);
            }
            if (z) {
                return null;
            }
        }
        HashMap hashMap2 = new HashMap();
        J3FDQU.A2egSU.BNL6CD(2131230904, hashMap2, "cross", 2131230875, "c");
        J3FDQU.A2egSU.BNL6CD(2131230760, hashMap2, t.f, 2131230846, t.l);
        J3FDQU.A2egSU.BNL6CD(2131231323, hashMap2, "l", 2131231502, t.k);
        hashMap2.put("start", 2131231545);
        hashMap2.put("menu", 2131231356);
        J3FDQU.A2egSU.BNL6CD(2131230762, hashMap2, "a_turbo", 2131230848, "b_turbo");
        hashMap2.put("select", 2131231517);
        hashMap2.put("load", 2131231331);
        hashMap2.put("save", 2131231515);
        hashMap2.put("skip", 2131231544);
        hashMap2.put("rewind", 2131231509);
        hashMap2.put("screenshot", 2131231516);
        J3FDQU.A2egSU.BNL6CD(2131231332, hashMap2, "lr", 2131231325, "la");
        J3FDQU.A2egSU.BNL6CD(2131231327, hashMap2, "lb", 2131231504, "ra");
        J3FDQU.A2egSU.BNL6CD(2131231506, hashMap2, "rb", 2131230910, "cross_u");
        J3FDQU.A2egSU.BNL6CD(2131230912, hashMap2, "cross_ur", 2131230909, "cross_r");
        J3FDQU.A2egSU.BNL6CD(2131230907, hashMap2, "cross_dr", 2131230905, "cross_d");
        J3FDQU.A2egSU.BNL6CD(2131230906, hashMap2, "cross_dl", 2131230908, "cross_l");
        J3FDQU.A2egSU.BNL6CD(2131230911, hashMap2, "cross_ul", 2131230876, "c_pressed");
        J3FDQU.A2egSU.BNL6CD(2131230761, hashMap2, "a_pressed", 2131230847, "b_pressed");
        J3FDQU.A2egSU.BNL6CD(2131231324, hashMap2, "l_pressed", 2131231503, "r_pressed");
        hashMap2.put("start_pressed", 2131231546);
        hashMap2.put("save_pressed", 2131231515);
        J3FDQU.A2egSU.BNL6CD(2131230763, hashMap2, "a_turbo_pressed", 2131230849, "b_turbo_pressed");
        hashMap2.put("select_pressed", 2131231518);
        hashMap2.put("load_pressed", 2131231331);
        hashMap2.put("menu_pressed", 2131231356);
        hashMap2.put("skip_pressed", 2131231544);
        hashMap2.put("screenshot", 2131231516);
        hashMap2.put("lr_pressed", 2131231333);
        J3FDQU.A2egSU.BNL6CD(2131231326, hashMap2, "la_pressed", 2131231328, "lb_pressed");
        J3FDQU.A2egSU.BNL6CD(2131231505, hashMap2, "ra_pressed", 2131231507, "rb_pressed");
        Integer num = (Integer) hashMap2.get(str);
        if (num == null) {
            return null;
        }
        try {
            return BitmapFactory.decodeResource(this.f5484A4TApA.getResources(), num.intValue());
        } catch (Exception unused) {
            return null;
        }
    }

    public final void A4TApA() {
        HashMap hashMap = this.f5483A2egSU;
        hashMap.clear();
        String string = ((SharedPreferences) this.f5487ARc23Z.f3808AlLFFp).getString("icon_pack_path", null);
        if (string == null) {
            A5SV6n();
            return;
        }
        File file = new File(string);
        if (!file.exists()) {
            A5SV6n();
            return;
        }
        try {
            ZipFile zipFile = new ZipFile(string);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            long lastModified = file.lastModified();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                String name = nextElement.getName();
                if (name.matches(".*\\.(png|jpg|jpeg)$")) {
                    InputStream inputStream = zipFile.getInputStream(nextElement);
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                        if (decodeStream != null) {
                            hashMap.put(name.substring(0, name.lastIndexOf(46)), decodeStream);
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } finally {
                    }
                }
            }
            this.f5485A5SV6n = string;
            this.f5486ADYaiT = lastModified;
            this.AMqCpz = true;
        } catch (IOException unused) {
            A5SV6n();
        }
    }

    public final void A5SV6n() {
        this.AMqCpz = false;
        this.f5485A5SV6n = null;
        this.f5486ADYaiT = 0L;
    }
}
