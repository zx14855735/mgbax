package com.sigmob.sdk.downloader.core.breakpoint;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class m implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    static final int f13358a = 0;
    static final int b = -1;
    static final int c = -2;
    static final int d = -3;
    private static final String e = "RemitSyncExecutor";
    private final Handler f;
    private final Set<Integer> g;
    private final a h;

    public interface a {
        void a(List<Integer> list);

        void h(int i);

        void i(int i);
    }

    public m(a aVar) {
        this.h = aVar;
        this.g = new HashSet();
        HandlerThread handlerThread = new HandlerThread("FileDownload RemitHandoverToDB");
        handlerThread.start();
        this.f = new Handler(handlerThread.getLooper(), this);
    }

    public void a() {
        this.f.getLooper().quit();
    }

    public void b(int i) {
        this.f.sendEmptyMessage(i);
    }

    public void c(int i) {
        Message obtainMessage = this.f.obtainMessage(-3);
        obtainMessage.arg1 = i;
        this.f.sendMessage(obtainMessage);
    }

    public void d(int i) {
        Message obtainMessage = this.f.obtainMessage(-2);
        obtainMessage.arg1 = i;
        this.f.sendMessage(obtainMessage);
    }

    public void e(int i) {
        this.f.removeMessages(i);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i;
        StringBuilder sb;
        String str;
        int i2 = message.what;
        if (i2 == -3) {
            i = message.arg1;
            this.g.remove(Integer.valueOf(i));
            this.h.i(i);
            sb = new StringBuilder("remove info ");
        } else {
            if (i2 != -2) {
                if (i2 == -1) {
                    List list = (List) message.obj;
                    this.g.removeAll(list);
                    sb = new StringBuilder("remove free bunch ids ");
                    sb.append(list);
                    com.sigmob.sdk.downloader.core.c.b(e, sb.toString());
                    return true;
                }
                if (i2 != 0) {
                    try {
                        this.h.h(i2);
                        this.g.add(Integer.valueOf(i2));
                        com.sigmob.sdk.downloader.core.c.b(e, "sync info with id: " + i2);
                        return true;
                    } catch (IOException unused) {
                        str = "sync cache to db failed for id: " + i2;
                    }
                } else {
                    List<Integer> list2 = (List) message.obj;
                    try {
                        this.h.a(list2);
                        this.g.addAll(list2);
                        com.sigmob.sdk.downloader.core.c.b(e, "sync bunch info with ids: " + list2);
                        return true;
                    } catch (IOException unused2) {
                        str = "sync info to db failed for ids: " + list2;
                    }
                }
                com.sigmob.sdk.downloader.core.c.a(e, str);
                return true;
            }
            i = message.arg1;
            this.g.remove(Integer.valueOf(i));
            sb = new StringBuilder("remove free bunch id ");
        }
        sb.append(i);
        com.sigmob.sdk.downloader.core.c.b(e, sb.toString());
        return true;
    }

    public m(a aVar, Handler handler, Set<Integer> set) {
        this.h = aVar;
        this.f = handler;
        this.g = set;
    }

    public void a(int i, long j) {
        this.f.sendEmptyMessageDelayed(i, j);
    }

    public void b(List<Integer> list) {
        Message obtainMessage = this.f.obtainMessage(-1);
        obtainMessage.obj = list;
        this.f.sendMessage(obtainMessage);
    }

    public void a(List<Integer> list) {
        Message obtainMessage = this.f.obtainMessage(0);
        obtainMessage.obj = list;
        this.f.sendMessage(obtainMessage);
    }

    public void a(int[] iArr) {
        for (int i : iArr) {
            this.f.removeMessages(i);
        }
    }

    public boolean a(int i) {
        return this.g.contains(Integer.valueOf(i));
    }
}
