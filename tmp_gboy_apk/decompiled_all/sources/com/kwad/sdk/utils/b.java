package com.kwad.sdk.utils;

import android.view.MotionEvent;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aj;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {
    public static boolean a(aj.a aVar, List<Integer> list) {
        int abs = Math.abs(aVar.SE() - aVar.SG());
        int abs2 = Math.abs(aVar.SF() - aVar.SH());
        if (list == null || list.isEmpty() || list.size() < 2) {
            return abs > 20 || abs2 > 20;
        }
        int atan2 = (int) ((Math.atan2(abs2, abs) * 180.0d) / 3.141592653589793d);
        return atan2 > list.get(0).intValue() && atan2 < list.get(1).intValue();
    }

    public static boolean g(aj.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (Math.abs(aVar.SG() - aVar.SE()) > 20) || (Math.abs(aVar.SH() - aVar.SF()) > 20);
    }

    public static boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, AdTemplate adTemplate) {
        boolean z = false;
        if (adTemplate == null) {
            return false;
        }
        AdInfo er = com.kwad.sdk.core.response.b.e.er(adTemplate);
        float abs = Math.abs(motionEvent2.getRawX() - motionEvent.getRawX());
        float abs2 = Math.abs(motionEvent2.getRawY() - motionEvent.getRawY());
        List<Integer> V = com.kwad.sdk.core.response.b.a.V(er);
        if (V == null || V.isEmpty() || V.size() < 2) {
            return abs > 20.0f || abs2 > 20.0f;
        }
        int atan2 = (int) ((Math.atan2(abs2, abs) * 180.0d) / 3.141592653589793d);
        if (atan2 > V.get(0).intValue() && atan2 < V.get(1).intValue()) {
            z = true;
        }
        if (z) {
            adTemplate.swipeAngle = atan2;
        }
        return z;
    }

    public static boolean a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent != null && motionEvent2 != null) {
            boolean z = Math.abs(motionEvent2.getY() - motionEvent.getY()) > 20.0f;
            if (Math.abs(motionEvent2.getX() - motionEvent.getX()) > 20.0f || z) {
                return true;
            }
        }
        return false;
    }
}
