package com.sigmob.sdk.videoAd;

import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.utils.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d extends AdTracker implements Serializable, Comparable<d> {
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    private final float f13698a;

    public d(String str, float f) {
        super(AdTracker.MessageType.QUARTILE_EVENT, null, str, null);
        Preconditions.NoThrow.checkArgument(f >= 0.0f);
        this.f13698a = f;
    }

    private float a() {
        return this.f13698a;
    }

    public String toString() {
        return String.format(Locale.US, "%2f: %s", Float.valueOf(this.f13698a), getUrl());
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(d dVar) {
        return Double.compare(a(), dVar.a());
    }

    public static List<d> a(List<d> list, String str, long j, long j2) {
        if (j2 <= 0 || j < 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        d dVar = new d(str, j / j2);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            d dVar2 = list.get(i);
            if (dVar2.compareTo(dVar) > 0) {
                break;
            }
            if (!dVar2.isTracked()) {
                arrayList.add(dVar2);
            }
        }
        return arrayList;
    }
}
