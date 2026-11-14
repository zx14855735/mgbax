package com.bytedance.sdk.openadsdk.am;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y {
    private WeakReference<f> hf;
    private Context xj;
    private Map<String, xj> w = new HashMap();
    private SensorEventListener u = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.am.y.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            f u;
            if (sensorEvent.sensor.getType() != 1 || (u = y.this.u()) == null) {
                return;
            }
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", f);
                jSONObject.put("y", f2);
                jSONObject.put("z", f3);
                u.xj("accelerometer_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    private SensorEventListener kd = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.am.y.12
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            f u;
            if (sensorEvent.sensor.getType() != 4 || (u = y.this.u()) == null) {
                return;
            }
            float degrees = (float) Math.toDegrees(sensorEvent.values[0]);
            float degrees2 = (float) Math.toDegrees(sensorEvent.values[1]);
            float degrees3 = (float) Math.toDegrees(sensorEvent.values[2]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", degrees);
                jSONObject.put("y", degrees2);
                jSONObject.put("z", degrees3);
                u.xj("gyro_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    private SensorEventListener y = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.am.y.23
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            f u;
            if (sensorEvent.sensor.getType() != 10 || (u = y.this.u()) == null) {
                return;
            }
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", f);
                jSONObject.put("y", f2);
                jSONObject.put("z", f3);
                u.xj("accelerometer_grativityless_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    private SensorEventListener c = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.am.y.34
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                float[] fArr = sensorEvent.values;
                float[] fArr2 = tf.hf;
                System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            } else if (sensorEvent.sensor.getType() == 2) {
                float[] fArr3 = sensorEvent.values;
                float[] fArr4 = tf.w;
                System.arraycopy(fArr3, 0, fArr4, 0, fArr4.length);
            }
            float[] fArr5 = tf.u;
            SensorManager.getRotationMatrix(fArr5, null, tf.hf, tf.w);
            float[] fArr6 = tf.kd;
            SensorManager.getOrientation(fArr5, fArr6);
            f u = y.this.u();
            if (u == null) {
                return;
            }
            float f = fArr6[0];
            float f2 = fArr6[1];
            float f3 = fArr6[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("alpha", f);
                jSONObject.put("beta", f2);
                jSONObject.put("gamma", f3);
                u.xj("rotation_vector_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };

    public interface xj {
        JSONObject xj(JSONObject jSONObject);
    }

    public y(f fVar) {
        this.xj = fVar.getContext();
        this.hf = new WeakReference<>(fVar);
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.am.xj kd() {
        f u = u();
        if (u == null) {
            return null;
        }
        return u.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f u() {
        WeakReference<f> weakReference = this.hf;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private void w() {
        this.w.put("adInfo", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.45
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                if (u == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject v = u.v();
                if (v != null) {
                    v.put(PluginConstants.KEY_ERROR_CODE, 1);
                    return v;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(PluginConstants.KEY_ERROR_CODE, -1);
                return jSONObject3;
            }
        });
        this.w.put("appInfo", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.56
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.5.1");
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = y.this.xj().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject2.put("supportList", jSONArray);
                f u = y.this.u();
                if (u != null) {
                    jSONObject2.put("deviceId", u.y());
                    jSONObject2.put("netType", u.zg());
                    jSONObject2.put("innerAppName", u.w());
                    jSONObject2.put("appName", u.u());
                    jSONObject2.put("appVersion", u.kd());
                    Map<String, String> xj2 = u.xj();
                    for (String str : xj2.keySet()) {
                        jSONObject2.put(str, xj2.get(str));
                    }
                }
                return jSONObject2;
            }
        });
        this.w.put("playableSDKInfo", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.61
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.5.1");
                jSONObject2.put("os", "android");
                return jSONObject2;
            }
        });
        this.w.put("subscribe_app_ad", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.62
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                com.bytedance.sdk.openadsdk.am.xj kd = y.this.kd();
                JSONObject jSONObject2 = new JSONObject();
                if (kd == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("download_app_ad", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.63
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                com.bytedance.sdk.openadsdk.am.xj kd = y.this.kd();
                JSONObject jSONObject2 = new JSONObject();
                if (kd == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("isViewable", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.2
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                if (u == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(PluginConstants.KEY_ERROR_CODE, 1);
                jSONObject3.put("viewStatus", u.f());
                return jSONObject3;
            }
        });
        this.w.put("getVolume", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.3
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                if (u == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(PluginConstants.KEY_ERROR_CODE, 1);
                jSONObject3.put("endcard_mute", u.c());
                return jSONObject3;
            }
        });
        this.w.put("getScreenSize", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.4
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                if (u == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject yo = u.yo();
                yo.put(PluginConstants.KEY_ERROR_CODE, 1);
                return yo;
            }
        });
        this.w.put("start_accelerometer_observer", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.5
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                int i = 2;
                if (jSONObject != null) {
                    try {
                        i = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        c.xj("PlayableJsBridge", "invoke start_accelerometer_observer error", th);
                        jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                tf.xj(y.this.xj, y.this.u, i);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("close_accelerometer_observer", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.6
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    tf.xj(y.this.xj, y.this.u);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    c.xj("PlayableJsBridge", "invoke close_accelerometer_observer error", th);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.w.put("start_gyro_observer", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.7
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                int i = 2;
                if (jSONObject != null) {
                    try {
                        i = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        c.xj("PlayableJsBridge", "invoke start_gyro_observer error", th);
                        jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                tf.hf(y.this.xj, y.this.kd, i);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("close_gyro_observer", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.8
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    tf.xj(y.this.xj, y.this.kd);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    c.xj("PlayableJsBridge", "invoke close_gyro_observer error", th);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.w.put("start_accelerometer_grativityless_observer", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.9
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                int i = 2;
                if (jSONObject != null) {
                    try {
                        i = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        c.xj("PlayableJsBridge", "invoke start_accelerometer_grativityless_observer error", th);
                        jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                tf.w(y.this.xj, y.this.y, i);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("close_accelerometer_grativityless_observer", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.10
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    tf.xj(y.this.xj, y.this.y);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    c.xj("PlayableJsBridge", "invoke close_accelerometer_grativityless_observer error", th);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.w.put("start_rotation_vector_observer", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.11
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                int i = 2;
                if (jSONObject != null) {
                    try {
                        i = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        c.xj("PlayableJsBridge", "invoke start_rotation_vector_observer error", th);
                        jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                tf.u(y.this.xj, y.this.c, i);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("close_rotation_vector_observer", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.13
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    tf.xj(y.this.xj, y.this.c);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    c.xj("PlayableJsBridge", "invoke close_rotation_vector_observer error", th);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.w.put("device_shake", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.14
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    tf.xj(y.this.xj, 300L);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    c.xj("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.w.put("device_shake_short", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.15
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    tf.xj(y.this.xj, 150L);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    c.xj("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.w.put("playable_style", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.16
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject hf = u.hf();
                hf.put(PluginConstants.KEY_ERROR_CODE, 1);
                return hf;
            }
        });
        this.w.put("sendReward", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.17
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                u.pz();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("webview_time_track", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.18
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                return new JSONObject();
            }
        });
        this.w.put("playable_event", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.19
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null || jSONObject == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                u.hf(jSONObject.optString("event", null), jSONObject.optJSONObject("params"));
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("reportAd", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.20
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("close", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.21
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("openAdLandPageLinks", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.22
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("get_viewport", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.24
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject jk = u.jk();
                jk.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jk;
            }
        });
        this.w.put("jssdk_load_finish", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.25
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                u.q();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_material_render_result", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.26
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                u.p(jSONObject);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("detect_change_playable_click", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.27
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject d = u.d();
                d.put(PluginConstants.KEY_ERROR_CODE, 1);
                return d;
            }
        });
        this.w.put("check_camera_permission", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.28
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject pl2 = u.pl();
                pl2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return pl2;
            }
        });
        this.w.put("check_external_storage", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.29
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject g = u.g();
                if (g.isNull("result")) {
                    g.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return g;
                }
                g.put(PluginConstants.KEY_ERROR_CODE, 1);
                return g;
            }
        });
        this.w.put("playable_open_camera", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.30
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                u.xj(jSONObject);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_pick_photo", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.31
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                u.hf(jSONObject);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_download_media_in_photos", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.32
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                u.w(jSONObject);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_preventTouchEvent", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.33
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                u.u(jSONObject);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_settings_info", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.35
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject am = u.am();
                am.put(PluginConstants.KEY_ERROR_CODE, 1);
                return am;
            }
        });
        this.w.put("playable_load_main_scene", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.36
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                u.ht();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_enter_section", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.37
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                u.y(jSONObject);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_end", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.38
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                u.ra();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_finish_play_playable", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.39
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                u.dk();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_transfrom_module_show", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.40
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                u.et();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_transfrom_module_change_color", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.41
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                u.io();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_set_scroll_rect", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.42
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_click_area", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.43
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                u.c(jSONObject);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_real_play_start", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.44
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_material_first_frame_show", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.46
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                u.x();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_stuck_check_pong", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.47
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                u.ai();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_material_adnormal_mask", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.48
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                u.f(jSONObject);
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_long_press_panel", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.49
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_alpha_player_play", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.50
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_transfrom_module_highlight", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.51
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_send_click_event", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.52
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_query_media_permission_declare", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.53
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject d = u.d(jSONObject);
                d.put(PluginConstants.KEY_ERROR_CODE, 1);
                return d;
            }
        });
        this.w.put("playable_query_media_permission_enable", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.54
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                f u = y.this.u();
                JSONObject jSONObject2 = new JSONObject();
                if (u == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                JSONObject tf = u.tf(jSONObject);
                tf.put(PluginConstants.KEY_ERROR_CODE, 1);
                return tf;
            }
        });
        this.w.put("playable_apply_media_permission", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.55
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                com.bytedance.sdk.openadsdk.am.xj kd = y.this.kd();
                JSONObject jSONObject2 = new JSONObject();
                if (kd == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_start_kws", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.57
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                com.bytedance.sdk.openadsdk.am.xj kd = y.this.kd();
                JSONObject jSONObject2 = new JSONObject();
                if (kd == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_close_kws", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.58
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                com.bytedance.sdk.openadsdk.am.xj kd = y.this.kd();
                JSONObject jSONObject2 = new JSONObject();
                if (kd == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_video_preload_task_add", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.59
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                com.bytedance.sdk.openadsdk.am.xj kd = y.this.kd();
                JSONObject jSONObject2 = new JSONObject();
                if (kd == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
        this.w.put("playable_video_preload_task_cancel", new xj() { // from class: com.bytedance.sdk.openadsdk.am.y.60
            @Override // com.bytedance.sdk.openadsdk.am.y.xj
            public JSONObject xj(JSONObject jSONObject) {
                com.bytedance.sdk.openadsdk.am.xj kd = y.this.kd();
                JSONObject jSONObject2 = new JSONObject();
                if (kd == null) {
                    jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                    return jSONObject2;
                }
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, 1);
                return jSONObject2;
            }
        });
    }

    public void hf() {
        tf.xj(this.xj, this.u);
        tf.xj(this.xj, this.kd);
        tf.xj(this.xj, this.y);
        tf.xj(this.xj, this.c);
    }

    public Set<String> xj() {
        return this.w.keySet();
    }

    public JSONObject xj(String str, JSONObject jSONObject) {
        try {
            xj xjVar = this.w.get(str);
            if (xjVar == null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(PluginConstants.KEY_ERROR_CODE, -1);
                return jSONObject2;
            }
            return xjVar.xj(jSONObject);
        } catch (Throwable th) {
            c.xj("PlayableJsBridge", "invoke error", th);
            return null;
        }
    }
}
