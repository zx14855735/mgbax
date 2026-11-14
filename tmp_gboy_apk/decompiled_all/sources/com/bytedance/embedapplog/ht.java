package com.bytedance.embedapplog;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ht implements Callable<q> {
    private Long hf;
    private final jk xj;

    public ht(jk jkVar, Long l) {
        this.xj = jkVar;
        this.hf = l;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public q call() {
        Future xj = j.xj(new Callable<q>() { // from class: com.bytedance.embedapplog.ht.1
            @Override // java.util.concurrent.Callable
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public q call() {
                try {
                    return ht.this.xj.xj();
                } catch (Exception e) {
                    v.hf("__kiteFingerTask#future call error " + e.getMessage());
                    return new q();
                }
            }
        });
        try {
            return this.hf.longValue() > 0 ? (q) xj.get(this.hf.longValue(), TimeUnit.SECONDS) : (q) xj.get();
        } catch (TimeoutException e) {
            v.hf("__kiteFingerTask# collection timed out" + e.getMessage());
            return new q();
        }
    }
}
