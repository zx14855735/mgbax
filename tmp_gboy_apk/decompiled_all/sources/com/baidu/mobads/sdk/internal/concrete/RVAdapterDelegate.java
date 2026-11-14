package com.baidu.mobads.sdk.internal.concrete;

import android.view.ViewGroup;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.b;
import com.baidu.mobads.sdk.internal.a.c;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class RVAdapterDelegate extends RecyclerView.A2egSU implements a {

    /* renamed from: a, reason: collision with root package name */
    private final c f9795a;
    private final b b;

    public RVAdapterDelegate(IAdInterListener iAdInterListener) {
        this.f9795a = c.a(iAdInterListener, this);
        registerAdapterDataObserver(new ViewPager2.DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.A4TApA
            public void onChanged() {
                RVAdapterDelegate.this.f9795a.a("onChanged");
            }
        });
        this.b = new b();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f9795a.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f9795a.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public IAdInterListener getDelegator() {
        return this.f9795a.getDelegator();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public int getItemCount() {
        Object a2 = this.f9795a.a("getItemCount", new Object[0]);
        if (a2 instanceof Integer) {
            return ((Integer) a2).intValue();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public long getItemId(int i) {
        return this.f9795a.a("getItemId", Integer.valueOf(i)) instanceof Integer ? ((Integer) r0).intValue() : super.getItemId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public int getItemViewType(int i) {
        Object a2 = this.f9795a.a("getItemType", Integer.valueOf(i));
        return a2 instanceof Integer ? ((Integer) a2).intValue() : super.getItemViewType(i);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f9795a.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f9795a.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f9795a.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        if ("notifyItemChanged".equals(str2)) {
            notifyItemChanged(this.b.a(objArr, 0, 0), this.b.a(objArr, 1, (Object) null));
        } else if ("notifyRangeInserted".equals(str2)) {
            notifyItemRangeInserted(this.b.a(objArr, 0, 0), this.b.a(objArr, 1, 0));
        } else if ("notifyRangeRemoved".equals(str2)) {
            notifyItemRangeRemoved(this.b.a(objArr, 0, 0), this.b.a(objArr, 1, 0));
        } else if ("notifyItemRangeChanged".equals(str2)) {
            notifyItemRangeChanged(this.b.a(objArr, 0, 0), this.b.a(objArr, 1, 0));
        } else if ("notifyDataSetChanged".equals(str2)) {
            notifyDataSetChanged();
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f9795a.a("onAttachedToRecyclerView", recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.f9795a.a("onDetachedFromRecyclerView", recyclerView);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f9795a.setTarget(obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public void onBindViewHolder(RVViewHolderDelegate rVViewHolderDelegate, int i) {
        this.f9795a.a("onBindViewHolder", rVViewHolderDelegate.getDelegator(), Integer.valueOf(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public RVViewHolderDelegate onCreateViewHolder(ViewGroup viewGroup, int i) {
        Object a2 = this.f9795a.a("onCreateViewHolder", viewGroup, Integer.valueOf(i));
        return a2 instanceof RVViewHolderDelegate ? (RVViewHolderDelegate) a2 : new RVViewHolderDelegate(this.f9795a.getDelegator(), viewGroup) { // from class: com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate.2
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public boolean onFailedToRecycleView(RVViewHolderDelegate rVViewHolderDelegate) {
        Object a2 = this.f9795a.a("onFailedToRecycleView", rVViewHolderDelegate.getDelegator());
        return a2 instanceof Boolean ? ((Boolean) a2).booleanValue() : super.onFailedToRecycleView((Dphsd2) rVViewHolderDelegate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public void onViewAttachedToWindow(RVViewHolderDelegate rVViewHolderDelegate) {
        super.onViewAttachedToWindow((Dphsd2) rVViewHolderDelegate);
        this.f9795a.a("onViewAttachedToWindow", rVViewHolderDelegate.getDelegator());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public void onViewDetachedFromWindow(RVViewHolderDelegate rVViewHolderDelegate) {
        super.onViewDetachedFromWindow((Dphsd2) rVViewHolderDelegate);
        this.f9795a.a("onViewDetachedFromWindow", rVViewHolderDelegate.getDelegator());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public void onViewRecycled(RVViewHolderDelegate rVViewHolderDelegate) {
        this.f9795a.a("onViewRecycled", rVViewHolderDelegate.getDelegator());
    }
}
