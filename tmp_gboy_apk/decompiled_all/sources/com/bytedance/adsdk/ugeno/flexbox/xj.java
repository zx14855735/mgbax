package com.bytedance.adsdk.ugeno.flexbox;

import android.view.View;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
interface xj {
    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<w> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    int hf(int i, int i2, int i3);

    View hf(int i);

    void setFlexLines(List<w> list);

    int xj(int i, int i2, int i3);

    int xj(View view);

    int xj(View view, int i, int i2);

    View xj(int i);

    void xj(View view, int i, int i2, w wVar);

    void xj(w wVar);

    boolean xj();
}
