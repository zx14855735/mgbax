package com.bytedance.sdk.component.hf.xj;

import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class kd extends qt {
    List<String> hf;
    List<String> xj;

    public kd(List<String> list, List<String> list2) {
        this.xj = list;
        this.hf = list2;
    }

    public static final class xj {
        private final List<String> xj = new ArrayList();
        private final List<String> hf = new ArrayList();

        public xj xj(String str, String str2) {
            this.xj.add(str);
            this.hf.add(str2);
            return this;
        }

        public kd xj() {
            return new kd(this.xj, this.hf);
        }
    }
}
