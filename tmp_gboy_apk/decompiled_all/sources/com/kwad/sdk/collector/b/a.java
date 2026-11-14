package com.kwad.sdk.collector.b;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.webkit.WebView;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.reward.A2egSU;
import com.kwad.sdk.api.proxy.app.ServiceProxyRemote;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.d;
import com.kwad.sdk.collector.model.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a extends com.kwad.sdk.m.a {
    private static AtomicBoolean azy = new AtomicBoolean(false);
    public static volatile Message azz;
    private HandlerC0349a azw = new HandlerC0349a(0);
    private Messenger azx = new Messenger(this.azw);

    /* renamed from: com.kwad.sdk.collector.b.a$a, reason: collision with other inner class name */
    public static class HandlerC0349a extends Handler {
        private WeakReference<Service> azB;

        private HandlerC0349a() {
        }

        public final void a(Service service) {
            if (service != null) {
                this.azB = new WeakReference<>(service);
            } else {
                this.azB = null;
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            c.d("RemoteService", "handleMessage");
            WeakReference<Service> weakReference = this.azB;
            Service service = weakReference != null ? weakReference.get() : null;
            if (service == null) {
                return;
            }
            if (!a.FB().get()) {
                c.d("RemoteService", "save buffered message");
                a.azz = Message.obtain(message);
                return;
            }
            final Messenger messenger = message.replyTo;
            int i = message.what;
            A2egSU.A4TApA(i, "handleMessage what: ", "RemoteService");
            if (i != 100) {
                return;
            }
            final Bundle bundle = new Bundle();
            g.a(service, new g.b() { // from class: com.kwad.sdk.collector.b.a.a.1
                @Override // com.kwad.sdk.utils.g.b
                public final void x(List<b> list) {
                    c.d("RemoteService", "RemoteService: onAppStatusResult list: " + list);
                    if (list != null && !list.isEmpty()) {
                        c.d("RemoteService", "RemoteService: onAppStatusResult: " + list.size());
                        JSONArray P = g.a.P(list);
                        String jSONArray = P != null ? P.toString() : null;
                        com.bykv.vk.component.ttvideo.player.A2egSU.B7CMnp("resultJson :", jSONArray, "RemoteService");
                        if (jSONArray != null) {
                            AppStatusRules Rg = g.Rg();
                            ArrayList<AppStatusRules.Strategy> allStrategy = Rg != null ? Rg.getAllStrategy() : null;
                            String jSONArray2 = allStrategy != null ? aa.S(allStrategy).toString() : null;
                            bundle.putString("resultJson", jSONArray);
                            bundle.putString("allStrategyJson", jSONArray2);
                        }
                    }
                    try {
                        Message obtain = Message.obtain();
                        obtain.what = 101;
                        obtain.setData(bundle);
                        messenger.send(obtain);
                    } catch (RemoteException unused) {
                    }
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    Iterator<b> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().destroy();
                    }
                }
            });
        }

        public /* synthetic */ HandlerC0349a(byte b) {
            this();
        }
    }

    static {
        wOEf();
    }

    public static AtomicBoolean FB() {
        return azy;
    }

    public static void b(Context context, ServiceConnection serviceConnection) {
        c.d("RemoteService", "unbindASService");
        try {
            context.unbindService(serviceConnection);
        } catch (Exception e) {
            c.printStackTrace(e);
        }
    }

    private static boolean bx(Context context) {
        String processName = ay.getProcessName(context);
        return (processName == null || context.getPackageName().equals(processName)) ? false : true;
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.c.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        try {
            int i = ServiceProxyRemote.f12321AcNBzu;
            com.kwad.sdk.service.c.putComponentProxy(ServiceProxyRemote.class, a.class);
        } catch (Throwable unused) {
        }
    }

    private static /* synthetic */ void wOEf() {
        char[] charArray = "%)+h!'+#h$)?h5.#**h\f(/\u00044/\"!#".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'F');
        }
        String str = new String(charArray);
        char[] charArray2 = "%*/(/2".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'F');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(Service service, Intent intent) {
        return this.azx.getBinder();
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        super.onCreate(service);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WebView.setDataDirectorySuffix(ay.getProcessName(service.getApplicationContext()));
            } catch (Exception e) {
                c.d("RemoteService", "WebView has already been initialized " + e.getMessage());
            }
        }
        c.d("RemoteService", "onCreate processName:" + ay.getProcessName(service));
        if (SystemUtil.isInMainProcess(service)) {
            azy.set(true);
        } else {
            d.a(service, new d.a() { // from class: com.kwad.sdk.collector.b.a.1
                @Override // com.kwad.sdk.collector.d.a
                public final void cN(String str) {
                    c.e("RemoteService", "onLoadError: " + str);
                    a.azy.set(false);
                }

                @Override // com.kwad.sdk.collector.d.a
                public final void onLoaded() {
                    c.d("RemoteService", "onLoaded");
                    a.azy.set(true);
                    if (a.azz != null) {
                        a.this.azw.handleMessage(a.azz);
                        a.azz = null;
                    }
                }
            });
        }
        this.azw.a(service);
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(Service service) {
        super.onDestroy(service);
        c.d("RemoteService", "onDestroy");
        this.azw.a(null);
        if (bx(service)) {
            c.d("RemoteService", "goto kill myself");
            Process.killProcess(Process.myPid());
        }
    }

    public static void a(Context context, ServiceConnection serviceConnection) {
        c.d("RemoteService", "bindASService");
        context.bindService(new Intent(context, (Class<?>) ServiceProxyRemote.class), serviceConnection, 1);
    }
}
