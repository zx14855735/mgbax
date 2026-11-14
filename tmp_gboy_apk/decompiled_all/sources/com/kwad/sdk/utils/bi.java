package com.kwad.sdk.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class bi {
    private static volatile bi bfs;
    private final Map<String, a> bft = new ConcurrentHashMap();
    private final Map<String, CopyOnWriteArraySet<SensorEventListener>> bfu = new ConcurrentHashMap();
    private boolean bfv = false;

    public static class a implements SensorEventListener {
        private final WeakReference<bi> aig;
        private final String key;

        public a(String str, bi biVar) {
            this.key = str;
            this.aig = new WeakReference<>(biVar);
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            bi biVar = this.aig.get();
            if (biVar != null) {
                biVar.a(this.key, sensorEvent);
            }
        }
    }

    public interface b {
        void onFailed();
    }

    private bi() {
        com.kwad.sdk.core.c.b.Ji();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.utils.bi.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                com.kwad.sdk.core.d.c.d("SensorDataManager", "onBackToBackground");
                SensorManager checkAndObtainSensorManager = bk.Tt().checkAndObtainSensorManager(ServiceProvider.getContext());
                for (String str : bi.this.bft.keySet()) {
                    try {
                        checkAndObtainSensorManager.unregisterListener((a) bi.this.bft.get(str));
                        com.kwad.sdk.core.d.c.d("SensorDataManager", "unregister successfully: " + str);
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                com.kwad.sdk.core.d.c.d("SensorDataManager", "onBackToForeground ");
                SensorManager checkAndObtainSensorManager = bk.Tt().checkAndObtainSensorManager(ServiceProvider.getContext());
                for (String str : bi.this.bft.keySet()) {
                    a aVar = (a) bi.this.bft.get(str);
                    if (aVar != null) {
                        checkAndObtainSensorManager.registerListener(aVar, bi.a(bi.this, Integer.parseInt(str.split("_")[0])), bi.b(bi.this, Integer.parseInt(str.split("_")[1])));
                        com.kwad.sdk.core.d.c.d("SensorDataManager", "register successfully: ".concat(str));
                    }
                }
            }
        });
    }

    private static String D(int i, int i2) {
        return i + "_" + i2;
    }

    public static bi To() {
        if (bfs == null) {
            synchronized (bi.class) {
                try {
                    if (bfs == null) {
                        bfs = new bi();
                    }
                } finally {
                }
            }
        }
        return bfs;
    }

    public static /* synthetic */ Sensor a(bi biVar, int i) {
        return fn(i);
    }

    public static /* synthetic */ int b(bi biVar, int i) {
        return fo(i);
    }

    private static Sensor fn(int i) {
        bk Tt = bk.Tt();
        Context context = ServiceProvider.getContext();
        if (i == 1) {
            return Tt.getDefaultSensor(context, 10);
        }
        if (i == 2) {
            return Tt.getDefaultSensor(context, 4);
        }
        if (i == 3) {
            return Tt.getDefaultSensor(context, 1);
        }
        if (i != 4) {
            return null;
        }
        return Tt.getDefaultSensor(context, 9);
    }

    private static int fo(int i) {
        if (i == -3) {
            return 2;
        }
        if (i != -2) {
            return i != -1 ? 3 : 0;
        }
        return 1;
    }

    private void hD(String str) {
        a aVar = this.bft.get(str);
        if (aVar != null) {
            this.bft.remove(str);
            try {
                bk.Tt().unregisterListener(aVar);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
    }

    private a hE(String str) {
        a aVar = this.bft.get(str);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(str, this);
        this.bft.put(str, aVar2);
        return aVar2;
    }

    public final synchronized void a(int i, int i2, SensorEventListener sensorEventListener, b bVar) {
        Sensor fn = fn(i);
        if (fn == null) {
            if (bVar != null) {
                bVar.onFailed();
            }
            return;
        }
        String D = D(i, i2);
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.bfu.get(D);
        if (copyOnWriteArraySet == null) {
            copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        }
        copyOnWriteArraySet.add(sensorEventListener);
        if (copyOnWriteArraySet.size() == 1) {
            this.bfu.put(D, copyOnWriteArraySet);
            a(D, i2, fn);
        }
    }

    public final synchronized void a(SensorEventListener sensorEventListener) {
        try {
            for (Map.Entry<String, CopyOnWriteArraySet<SensorEventListener>> entry : this.bfu.entrySet()) {
                CopyOnWriteArraySet<SensorEventListener> value = entry.getValue();
                Iterator<SensorEventListener> it = value.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SensorEventListener next = it.next();
                    if (next.equals(sensorEventListener)) {
                        value.remove(next);
                        break;
                    }
                }
                if (value.size() == 0) {
                    hD(entry.getKey());
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void a(String str, int i, Sensor sensor) {
        boolean useSensorManagerDisable = bc.useSensorManagerDisable();
        this.bfv = useSensorManagerDisable;
        if (useSensorManagerDisable) {
            return;
        }
        bk.Tt().registerListener(ServiceProvider.getContext(), hE(str), sensor, fo(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, SensorEvent sensorEvent) {
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.bfu.get(str);
        if (copyOnWriteArraySet != null) {
            Iterator<SensorEventListener> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                it.next().onSensorChanged(sensorEvent);
            }
        }
    }
}
