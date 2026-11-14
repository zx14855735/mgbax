package com.sigmob.sdk.base.models;

import android.graphics.Rect;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ExposureChange {
    float exposedPercentage;
    List occlusionRectangles;
    Rect visibleRectangle;

    public ExposureChange(float f, Rect rect, List list) {
        this.exposedPercentage = f;
        this.visibleRectangle = rect;
        this.occlusionRectangles = list;
    }

    public String toString() {
        return "\"exposureChange\"={\"exposedPercentage\"=" + this.exposedPercentage + ", \"visibleRectangle\"={\"x\"=" + this.visibleRectangle.left + ",\"y\"=" + this.visibleRectangle.top + ",\"width\"=" + this.visibleRectangle.width() + ",\"height\"=" + this.visibleRectangle.height() + "}, \"occlusionRectangles\"=[]}";
    }
}
