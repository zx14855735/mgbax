package com.bytedance.pangle.w;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.cb;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.tf;
import com.bytedance.pangle.util.y;
import com.sigmob.sdk.base.n;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private String c;
    private String hf;
    private File kd;
    private List<File> u;
    private JSONObject w;
    private String xj;
    private JSONObject y;

    private boolean d() {
        JSONObject jSONObject;
        List<File> list = this.u;
        boolean z = false;
        if (list == null || list.size() == 0 || (jSONObject = this.w) == null || jSONObject.length() == 0) {
            StringBuilder sb = new StringBuilder("DexPluginConfig check md5 fail, packageName=");
            sb.append(this.hf);
            sb.append(" dexlist is ");
            sb.append(this.u);
            sb.append(" dexlist size is ");
            List<File> list2 = this.u;
            sb.append(list2 == null ? -1 : list2.size());
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, sb.toString());
            return false;
        }
        int size = this.u.size();
        int length = this.w.length();
        for (File file : this.u) {
            String xj = y.xj(file);
            if (xj != null) {
                xj = xj.toLowerCase();
            }
            String xj2 = xj(file.getName());
            if (TextUtils.equals(xj2, xj)) {
                size--;
                length--;
            } else {
                StringBuilder sb2 = new StringBuilder("DexPluginConfig check md5 fail, packageName=");
                A2egSU.BIYEnU(sb2, this.hf, "downloadFileMd5=", xj, " configMd5=");
                sb2.append(xj2);
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, sb2.toString());
            }
        }
        if (size == 0 && length == 0) {
            z = true;
        }
        StringBuilder sb3 = new StringBuilder("DexPluginConfig check md5 ");
        sb3.append(z ? cb.o : "fail");
        sb3.append(", packageName=");
        sb3.append(this.hf);
        sb3.append(" fileSize=");
        sb3.append(size);
        sb3.append(" configFileSize=");
        sb3.append(length);
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, sb3.toString());
        return z;
    }

    private boolean f() {
        JSONObject jSONObject;
        Map<String, JSONObject> kd = tf.xj().kd();
        if (kd != null && kd.size() > 0 && (jSONObject = kd.get(this.hf)) != null && jSONObject.has("packageName") && TextUtils.equals(jSONObject.optString("packageName"), this.hf)) {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginConfig check packageName success , packageName=" + this.hf);
            return true;
        }
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginConfig check packageName fail, packageName=" + this.hf + ", packageManager=" + kd);
        return false;
    }

    public static xj xj(JSONObject jSONObject, File file, List<File> list) {
        xj xjVar = new xj();
        xjVar.xj = jSONObject.optString("version");
        xjVar.hf = jSONObject.optString(n.p);
        xjVar.w = jSONObject.optJSONObject("adn_adapter_md5");
        xjVar.c = jSONObject.optString("alias_package_name");
        xjVar.u = list;
        xjVar.kd = file;
        xjVar.y = jSONObject;
        return xjVar;
    }

    public String c() {
        return this.c;
    }

    public String hf() {
        return this.hf;
    }

    public File kd() {
        return this.kd;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DexPluginConfig{mVersion='");
        sb.append(this.xj);
        sb.append("', mPackageName='");
        return CtFAbx.B25kr6(sb, this.hf, "'}");
    }

    public List<File> u() {
        return this.u;
    }

    public int w() {
        if (TextUtils.isEmpty(this.xj)) {
            return -1;
        }
        String replace = this.xj.replace(".", "");
        if (TextUtils.isEmpty(replace)) {
            return -1;
        }
        try {
            return Integer.valueOf(replace).intValue();
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public JSONObject y() {
        return this.y;
    }

    public boolean xj() {
        return f() && d();
    }

    public String xj(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str) && (jSONObject = this.w) != null && jSONObject.has(str)) {
            return this.w.optString(str);
        }
        return "";
    }
}
