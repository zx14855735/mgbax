package com.bytedance.sdk.component.xj;

import android.net.Uri;
import com.bytedance.component.sdk.annotation.MainThread;
import com.bytedance.sdk.component.xj.ht;
import com.bytedance.sdk.component.xj.p;
import com.bytedance.sdk.component.xj.pz;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class jk {
    private final Set<String> hf;
    private p.hf kd;
    private final pz u;
    private final ht w = e.xj;
    private final Set<String> xj;

    public jk(pz pzVar, Set<String> set, Set<String> set2) {
        this.u = pzVar;
        if (set == null || set.isEmpty()) {
            this.xj = new LinkedHashSet();
        } else {
            this.xj = new LinkedHashSet(set);
        }
        if (set2 == null || set2.isEmpty()) {
            this.hf = new LinkedHashSet();
        } else {
            this.hf = new LinkedHashSet(set2);
        }
    }

    public final synchronized ra hf(String str, hf hfVar) {
        return xj(str, hfVar, false);
    }

    @MainThread
    public final synchronized ra xj(boolean z, String str, hf hfVar) {
        p.hf hfVar2;
        try {
            Uri parse = Uri.parse(str);
            String host = parse.getHost();
            if (host == null) {
                return null;
            }
            ra raVar = this.hf.contains(hfVar.xj()) ? ra.PUBLIC : null;
            for (String str2 : this.xj) {
                if (parse.getHost().equals(str2) || host.endsWith(".".concat(String.valueOf(str2)))) {
                    raVar = ra.PRIVATE;
                    break;
                }
            }
            if (raVar == null && (hfVar2 = this.kd) != null && hfVar2.xj(str)) {
                if (this.kd.xj(str, hfVar.xj())) {
                    return null;
                }
                raVar = ra.PRIVATE;
            }
            ra xj = z ? xj(str, hfVar) : hf(str, hfVar);
            return xj != null ? xj : raVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void hf(ht.xj xjVar) {
        ht htVar = this.w;
        if (htVar != null) {
            htVar.hf(xjVar);
        }
    }

    @MainThread
    public final synchronized ra xj(String str, hf hfVar) {
        return xj(str, hfVar, true);
    }

    public void xj(p.hf hfVar) {
        this.kd = hfVar;
    }

    public void xj(ht.xj xjVar) {
        ht htVar = this.w;
        if (htVar != null) {
            htVar.xj(xjVar);
        }
    }

    private ra xj(String str, hf hfVar, boolean z) {
        pz pzVar;
        if (!z || (pzVar = this.u) == null) {
            return null;
        }
        pz.w xj = pzVar.xj(str, this.xj);
        if (xj.w.contains(hfVar.xj())) {
            return null;
        }
        if (xj.hf.contains(hfVar.xj())) {
            return ra.PRIVATE;
        }
        if (xj.xj.compareTo(hfVar.hf()) < 0) {
            return null;
        }
        return xj.xj;
    }
}
