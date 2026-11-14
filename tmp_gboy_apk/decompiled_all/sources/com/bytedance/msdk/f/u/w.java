package com.bytedance.msdk.f.u;

import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.d;
import com.bytedance.sdk.component.hf.xj.zg;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.w.hf.io;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.mta.PointCategory;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    public static Map<String, Object> xj;

    public static class xj implements d {
        private am hf(d.xj xjVar) {
            try {
                Field field = xjVar.getClass().getDeclaredFields()[0];
                field.setAccessible(true);
                Object obj = field.get(xjVar);
                Field declaredField = obj.getClass().getDeclaredField(PointCategory.REQUEST);
                declaredField.setAccessible(true);
                io ioVar = (io) declaredField.get(obj);
                declaredField.set(obj, ioVar.y().xj(String.valueOf(xjVar.xj().hf().c().hf("b4oil169.fn.bytedance.net").xj(Constants.HTTP).hf())).hf("case-id", (String) w.xj.get("case_id")).xj());
                return xjVar.xj();
            } catch (Throwable th) {
                pl.xj(th);
                return xjVar.xj();
            }
        }

        @Override // com.bytedance.sdk.component.hf.xj.d
        public zg xj(d.xj xjVar) {
            am xj = xjVar.xj();
            String cVar = xj.hf().toString();
            if (cVar.contains("/api/ad/union/mediation/config") || cVar.contains("/api/ad/union/mediation/exchange")) {
                xj = hf(xjVar);
            }
            return xjVar.xj(xj);
        }
    }

    public static void xj(Map map) {
        xj = map;
    }

    public static boolean xj() {
        return com.bytedance.msdk.core.xj.p().jk();
    }
}
