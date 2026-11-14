package com.sigmob.sdk.mraid;

import android.content.Context;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.am;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class o extends n {
    protected am.a c;
    protected com.sigmob.sdk.mraid2.k d;

    public o(String str) {
        super(str);
    }

    public am.a a(Context context) {
        return new am.a(context, new am.b() { // from class: com.sigmob.sdk.mraid.o.1
            @Override // com.sigmob.sdk.base.common.am.b
            public void a() {
                o oVar = o.this;
                com.sigmob.sdk.mraid2.k kVar = oVar.d;
                if (kVar == null) {
                    return;
                }
                kVar.a(oVar.f13481a, "twist", "began", new HashMap<>());
            }

            @Override // com.sigmob.sdk.base.common.am.b
            public void a(float f) {
            }

            @Override // com.sigmob.sdk.base.common.am.b
            public void a(Map<String, Number> map) {
                if (map == null || o.this.d == null) {
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                Number number = map.get("turn_x");
                Number number2 = map.get("turn_y");
                Number number3 = map.get("turn_z");
                Number number4 = map.get("turn_time");
                hashMap.put("x", String.valueOf(number));
                hashMap.put("y", String.valueOf(number2));
                hashMap.put("z", String.valueOf(number3));
                hashMap.put("time", number4);
                o oVar = o.this;
                oVar.d.a(oVar.f13481a, "twist", PointCategory.END, hashMap);
            }
        }, am.c.WRING);
    }

    public abstract void a(float f);

    public am.a b(Context context) {
        am.a aVar = new am.a(context, new am.b() { // from class: com.sigmob.sdk.mraid.o.2
            @Override // com.sigmob.sdk.base.common.am.b
            public void a() {
                o oVar = o.this;
                com.sigmob.sdk.mraid2.k kVar = oVar.d;
                if (kVar == null) {
                    return;
                }
                kVar.a(oVar.f13481a, "shake", "began", new HashMap<>());
            }

            @Override // com.sigmob.sdk.base.common.am.b
            public void a(float f) {
            }

            @Override // com.sigmob.sdk.base.common.am.b
            public void a(Map<String, Number> map) {
                if (map == null || o.this.d == null) {
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                Number number = map.get("x_max_acc");
                Number number2 = map.get("y_max_acc");
                Number number3 = map.get("z_max_acc");
                hashMap.put("x", String.valueOf(number));
                hashMap.put("y", String.valueOf(number2));
                hashMap.put("z", String.valueOf(number3));
                o oVar = o.this;
                oVar.d.a(oVar.f13481a, "shake", PointCategory.END, hashMap);
            }
        }, am.c.SHAKE);
        aVar.a(1);
        return aVar;
    }

    public abstract void b(float f);

    public am.a c(Context context) {
        am.a aVar = new am.a(context, new am.b() { // from class: com.sigmob.sdk.mraid.o.3
            @Override // com.sigmob.sdk.base.common.am.b
            public void a() {
                o oVar = o.this;
                com.sigmob.sdk.mraid2.k kVar = oVar.d;
                if (kVar == null) {
                    return;
                }
                kVar.a(oVar.f13481a, "swing", "began", new HashMap<>());
            }

            @Override // com.sigmob.sdk.base.common.am.b
            public void a(float f) {
                o.this.a(f);
                if (o.this.d == null) {
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put(PointCategory.PROGRESS, Integer.valueOf((int) (f * 100.0f)));
                o oVar = o.this;
                oVar.d.a(oVar.f13481a, "swing", PointCategory.PROGRESS, hashMap);
            }

            @Override // com.sigmob.sdk.base.common.am.b
            public void a(Map<String, Number> map) {
                if (map == null || o.this.d == null) {
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                Number number = map.get("x_max_acc");
                Number number2 = map.get("y_max_acc");
                Number number3 = map.get("z_max_acc");
                hashMap.put("x", String.valueOf(number));
                hashMap.put("y", String.valueOf(number2));
                hashMap.put("z", String.valueOf(number3));
                o oVar = o.this;
                oVar.d.a(oVar.f13481a, "swing", PointCategory.END, hashMap);
            }
        }, am.c.SWING);
        aVar.a(1);
        return aVar;
    }

    public am.a d(Context context) {
        am.a aVar = new am.a(context, new am.b() { // from class: com.sigmob.sdk.mraid.o.4
            @Override // com.sigmob.sdk.base.common.am.b
            public void a() {
                o oVar = o.this;
                com.sigmob.sdk.mraid2.k kVar = oVar.d;
                if (kVar == null) {
                    return;
                }
                kVar.a(oVar.f13481a, "slope", "began", new HashMap<>());
            }

            @Override // com.sigmob.sdk.base.common.am.b
            public void a(float f) {
                o.this.b(f);
                if (o.this.d == null) {
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put(PointCategory.PROGRESS, Integer.valueOf((int) (f * 100.0f)));
                o oVar = o.this;
                oVar.d.a(oVar.f13481a, "slope", PointCategory.PROGRESS, hashMap);
            }

            @Override // com.sigmob.sdk.base.common.am.b
            public void a(Map<String, Number> map) {
                if (map == null || o.this.d == null) {
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                Number number = map.get("turn_x");
                Number number2 = map.get("turn_y");
                Number number3 = map.get("turn_z");
                Number number4 = map.get("turn_time");
                hashMap.put("x", String.valueOf(number));
                hashMap.put("y", String.valueOf(number2));
                hashMap.put("z", String.valueOf(number3));
                hashMap.put("time", number4);
                o oVar = o.this;
                oVar.d.a(oVar.f13481a, "slope", PointCategory.END, hashMap);
            }
        }, am.c.SLOPE);
        aVar.a(1);
        return aVar;
    }

    public void e(int i) {
        am.a aVar = this.c;
        if (aVar == null) {
            return;
        }
        aVar.f(i);
    }

    public void a(int i) {
        am.a aVar = this.c;
        if (aVar == null) {
            return;
        }
        aVar.c(i);
    }

    public void b(int i) {
        am.a aVar = this.c;
        if (aVar == null) {
            return;
        }
        aVar.b(i);
    }

    public void c(int i) {
        am.a aVar = this.c;
        if (aVar == null) {
            return;
        }
        aVar.d(i);
    }

    public void d() {
        am.a aVar = this.c;
        if (aVar == null) {
            return;
        }
        aVar.a();
    }

    public void a(Context context, int i) {
        if (i == 0) {
            this.c = b(context);
            return;
        }
        if (i == 1) {
            this.c = a(context);
            return;
        }
        if (i == 2) {
            this.c = d(context);
        } else if (i != 3) {
            SigmobLog.e("Motion type is not support.");
        } else {
            this.c = c(context);
        }
    }

    public void d(int i) {
        am.a aVar = this.c;
        if (aVar == null) {
            return;
        }
        aVar.e(i);
    }

    public void a(Context context, String str) {
        str.getClass();
        switch (str) {
            case "shake":
                this.c = b(context);
                break;
            case "slope":
                this.c = d(context);
                break;
            case "swing":
                this.c = c(context);
                break;
            case "twist":
                this.c = a(context);
                break;
            default:
                SigmobLog.e("Motion type is not support.");
                break;
        }
    }

    public void a(com.sigmob.sdk.mraid2.k kVar) {
        this.d = kVar;
    }
}
