package com.bytedance.sdk.component.tf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class d implements Comparable<d>, Runnable {
    private int mPriority;
    private String name;

    public d(String str, int i) {
        this.mPriority = 0;
        this.mPriority = i == 0 ? 5 : i;
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public void setPriority(int i) {
        this.mPriority = i;
    }

    @Override // java.lang.Comparable
    public int compareTo(d dVar) {
        if (getPriority() < dVar.getPriority()) {
            return 1;
        }
        return getPriority() >= dVar.getPriority() ? -1 : 0;
    }

    public d(String str) {
        this.mPriority = 5;
        this.name = str;
    }
}
