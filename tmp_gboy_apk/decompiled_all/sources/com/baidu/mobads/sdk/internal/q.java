package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.aa;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static volatile q f9846a;
    private List<aa.a> b = new CopyOnWriteArrayList();

    private q() {
    }

    public static q a() {
        if (f9846a == null) {
            synchronized (q.class) {
                try {
                    if (f9846a == null) {
                        f9846a = new q();
                    }
                } finally {
                }
            }
        }
        return f9846a;
    }

    private void b(aa.a aVar) {
        if (this.b.contains(aVar)) {
            this.b.remove(aVar);
        }
    }

    public void a(aa.a aVar) {
        if (aVar == null || this.b.contains(aVar)) {
            return;
        }
        this.b.add(aVar);
    }

    public void a(int i) {
        for (aa.a aVar : this.b) {
            if (i == 1) {
                aVar.onSuccess();
            } else if (i == 2) {
                aVar.onFailure();
            }
            b(aVar);
        }
    }
}
