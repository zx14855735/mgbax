package com.bytedance.sdk.component.widget.recycler;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class f {
    final Rect hf;
    private int w;
    protected final RecyclerView.d xj;

    public abstract int c();

    public abstract int f();

    public int hf() {
        if (Integer.MIN_VALUE == this.w) {
            return 0;
        }
        return y() - this.w;
    }

    public abstract int hf(View view);

    public abstract int kd();

    public abstract int kd(View view);

    public abstract int u();

    public abstract int u(View view);

    public abstract int w();

    public abstract int w(View view);

    public abstract int xj(View view);

    public void xj() {
        this.w = y();
    }

    public abstract void xj(int i);

    public abstract int y();

    public abstract int y(View view);

    private f(RecyclerView.d dVar) {
        this.w = Integer.MIN_VALUE;
        this.hf = new Rect();
        this.xj = dVar;
    }

    public static f hf(RecyclerView.d dVar) {
        return new f(dVar) { // from class: com.bytedance.sdk.component.widget.recycler.f.2
            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int c() {
                return this.xj.x();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int f() {
                return this.xj.pz();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int hf(View view) {
                return this.xj.tf(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.tf) view.getLayoutParams())).bottomMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int kd() {
                return this.xj.ra();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int u() {
                return this.xj.ra() - this.xj.x();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int w() {
                return this.xj.et();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public void xj(int i) {
                this.xj.tf(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int y(View view) {
                RecyclerView.tf tfVar = (RecyclerView.tf) view.getLayoutParams();
                return this.xj.kd(view) + ((ViewGroup.MarginLayoutParams) tfVar).leftMargin + ((ViewGroup.MarginLayoutParams) tfVar).rightMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int kd(View view) {
                RecyclerView.tf tfVar = (RecyclerView.tf) view.getLayoutParams();
                return this.xj.y(view) + ((ViewGroup.MarginLayoutParams) tfVar).topMargin + ((ViewGroup.MarginLayoutParams) tfVar).bottomMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int u(View view) {
                this.xj.xj(view, true, this.hf);
                return this.hf.top;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int w(View view) {
                this.xj.xj(view, true, this.hf);
                return this.hf.bottom;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int xj(View view) {
                return this.xj.f(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.tf) view.getLayoutParams())).topMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int y() {
                return (this.xj.ra() - this.xj.et()) - this.xj.x();
            }
        };
    }

    public static f xj(RecyclerView.d dVar, int i) {
        if (i == 0) {
            return xj(dVar);
        }
        if (i == 1) {
            return hf(dVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static f xj(RecyclerView.d dVar) {
        return new f(dVar) { // from class: com.bytedance.sdk.component.widget.recycler.f.1
            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int c() {
                return this.xj.io();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int f() {
                return this.xj.jk();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int hf(View view) {
                return this.xj.d(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.tf) view.getLayoutParams())).rightMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int kd() {
                return this.xj.ht();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int u() {
                return this.xj.ht() - this.xj.io();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int w() {
                return this.xj.dk();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public void xj(int i) {
                this.xj.d(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int y(View view) {
                RecyclerView.tf tfVar = (RecyclerView.tf) view.getLayoutParams();
                return this.xj.y(view) + ((ViewGroup.MarginLayoutParams) tfVar).topMargin + ((ViewGroup.MarginLayoutParams) tfVar).bottomMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int kd(View view) {
                RecyclerView.tf tfVar = (RecyclerView.tf) view.getLayoutParams();
                return this.xj.kd(view) + ((ViewGroup.MarginLayoutParams) tfVar).leftMargin + ((ViewGroup.MarginLayoutParams) tfVar).rightMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int u(View view) {
                this.xj.xj(view, true, this.hf);
                return this.hf.left;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int w(View view) {
                this.xj.xj(view, true, this.hf);
                return this.hf.right;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int xj(View view) {
                return this.xj.c(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.tf) view.getLayoutParams())).leftMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.f
            public int y() {
                return (this.xj.ht() - this.xj.dk()) - this.xj.io();
            }
        };
    }
}
