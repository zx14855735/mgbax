package com.bytedance.adsdk.ugeno.viewpager;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class hf {
    private DataSetObserver hf;
    private final DataSetObservable xj = new DataSetObservable();

    public Parcelable hf() {
        return null;
    }

    public void w() {
        synchronized (this) {
            try {
                DataSetObserver dataSetObserver = this.hf;
                if (dataSetObserver != null) {
                    dataSetObserver.onChanged();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.xj.notifyChanged();
    }

    public float xj(int i) {
        return 1.0f;
    }

    public abstract int xj();

    public abstract boolean xj(View view, Object obj);

    public int xj(Object obj) {
        return -1;
    }

    public Object xj(ViewGroup viewGroup, int i) {
        return xj((View) viewGroup, i);
    }

    public void xj(ViewGroup viewGroup, int i, Object obj) {
        xj((View) viewGroup, i, obj);
    }

    @Deprecated
    public Object xj(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void xj(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void xj(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.hf = dataSetObserver;
        }
    }
}
