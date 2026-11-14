package com.bytedance.sdk.openadsdk;

import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface FilterWord {
    void addOption(FilterWord filterWord);

    String getId();

    boolean getIsSelected();

    String getName();

    List<FilterWord> getOptions();

    boolean hasSecondOptions();

    boolean isValid();

    void setIsSelected(boolean z);
}
