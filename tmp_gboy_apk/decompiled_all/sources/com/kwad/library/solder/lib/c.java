package com.kwad.library.solder.lib;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class c implements com.kwad.library.solder.lib.a.b {
    private final File auB;
    private final File auC;
    private final com.kwad.library.solder.lib.ext.c auD;
    private final Context mContext;

    public c(Context context, com.kwad.library.solder.lib.ext.c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.auD = cVar;
        this.auB = applicationContext.getDir(cVar.BS(), 0);
        this.auC = applicationContext.getCacheDir();
    }

    private String Bp() {
        return this.auB.getAbsolutePath();
    }

    private String F(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(Bp());
        String str3 = File.separator;
        return A2egSU.AzWtSf(sb, str3, str, str3, str2);
    }

    private String a(com.kwad.library.solder.lib.a.a aVar) {
        return G(aVar.getId(), aVar.getVersion());
    }

    private static void delete(String str) {
        w.delete(str);
    }

    private boolean i(String str, String str2, boolean z) {
        if (!w.hh(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.equals(str2, al.getFileMD5Digest(str))) {
            return true;
        }
        delete(str);
        return false;
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void Bo() {
        if (this.auB.getFreeSpace() < 10000000) {
            throw new IOException("No enough capacity.");
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void E(String str, String str2) {
        File file = new File(F(str, str2));
        if (file.exists()) {
            w.T(file);
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String G(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(Bp());
        String str3 = File.separator;
        A2egSU.BIYEnU(sb, str3, str, str3, str2);
        sb.append(str3);
        sb.append(this.auD.BX());
        return sb.toString();
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String b(com.kwad.library.solder.lib.a.a aVar) {
        String a2 = a(aVar);
        if (TextUtils.isEmpty(a2)) {
            throw new PluginError.InstallError("Can not get install path.", PluginError.ERROR_INS_INSTALL_PATH);
        }
        aVar.getId();
        File file = new File(a2);
        if (file.exists() && !this.auD.BY() && i(file.getAbsolutePath(), aVar.BC(), true)) {
            return a2;
        }
        String BB = aVar.BB();
        aVar.getId();
        File file2 = new File(BB);
        if (!file2.exists()) {
            throw new PluginError.InstallError("Plugin file not exist.", 3001);
        }
        aVar.getId();
        if (!i(BB, aVar.BC(), true)) {
            aVar.BC();
            throw new PluginError.InstallError("check plugin md5 fail:" + aVar.BC() + " " + BB, 3003);
        }
        if (file2.renameTo(file)) {
            aVar.getId();
            return a2;
        }
        try {
            Bo();
            try {
                w.f(file2, file);
                w.T(file2);
                return a2;
            } catch (Throwable th) {
                a.e("PluginInstallerImpl", th);
                throw new PluginError.InstallError(th, 3004);
            }
        } catch (Throwable th2) {
            a.e("PluginInstallerImpl", th2);
            throw new PluginError.InstallError(th2, 3005);
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void bZ(String str) {
        File file = new File(ca(str));
        if (file.exists()) {
            w.T(file);
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String ca(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(Bp());
        return CtFAbx.B25kr6(sb, File.separator, str);
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final File e(String str, boolean z) {
        String md5;
        if (str == null || (md5 = com.kwad.library.solder.lib.d.b.getMD5(str)) == null) {
            return null;
        }
        if (!z) {
            StringBuilder A4TApA2 = AYUAbz.A4TApA(md5);
            A4TApA2.append(System.currentTimeMillis());
            return File.createTempFile(A4TApA2.toString(), this.auD.BW(), this.auC);
        }
        StringBuilder A4TApA3 = AYUAbz.A4TApA(md5);
        if (this.auD.BW() != null) {
            A4TApA3.append(this.auD.BW());
        }
        File file = new File(this.auC, A4TApA3.toString());
        if (file.exists() || file.createNewFile()) {
            return file;
        }
        return null;
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final boolean a(String str, String str2, String str3) {
        if (this.auD.BY()) {
            return false;
        }
        return i(G(str, str2), str3, true);
    }
}
