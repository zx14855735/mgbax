package com.sigmob.sdk.base.views;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import com.czhj.sdk.logger.SigmobLog;
import java.lang.reflect.Method;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class at {
    private static at c = null;
    private static final AtomicReference<at> d = new AtomicReference<>();
    private static final int e = 2;
    private final Object b = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final Queue<g> f13274a = new LinkedBlockingQueue(2);

    static {
        tOuvo();
    }

    private at() {
    }

    public static at a() {
        while (true) {
            at atVar = c;
            if (atVar != null) {
                return atVar;
            }
            AtomicReference<at> atomicReference = d;
            at atVar2 = new at();
            while (!atomicReference.compareAndSet(null, atVar2)) {
                if (atomicReference.get() != null) {
                    break;
                }
            }
            at atVar3 = d.get();
            c = atVar3;
            return atVar3;
        }
    }

    private g b(Context context) {
        g gVar;
        Queue<g> queue = this.f13274a;
        g poll = queue != null ? queue.poll() : null;
        SigmobLog.i("acquireWebViewInternal  webview:" + poll);
        if (poll != null) {
            ((MutableContextWrapper) poll.getContext()).setBaseContext(context);
            return poll;
        }
        synchronized (this.b) {
            gVar = new g(new MutableContextWrapper(context));
        }
        return gVar;
    }

    private static /* synthetic */ void tOuvo() {
        char[] charArray = "û÷õ¶ÿùõý¶ú÷á¶ëðýôô¶ÒöñÚêñüÿý".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 152);
        }
        String str = new String(charArray);
        char[] charArray2 = "ûôñöñì".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 152);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void b(g gVar) {
        try {
            if (gVar.getContext() instanceof MutableContextWrapper) {
                MutableContextWrapper mutableContextWrapper = (MutableContextWrapper) gVar.getContext();
                mutableContextWrapper.setBaseContext(mutableContextWrapper.getApplicationContext());
                SigmobLog.i("enqueue  webview:" + gVar);
                if (this.f13274a != null) {
                    gVar.b();
                    this.f13274a.offer(gVar);
                } else {
                    gVar.destroy();
                }
            }
            if (gVar.getContext() instanceof Activity) {
                SigmobLog.i("Abandon this webview  ， It will cause leak if enqueue !");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public g a(Context context) {
        return b(context);
    }

    public void a(g gVar) {
        b(gVar);
    }
}
