package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bytedance.sdk.openadsdk.core.dislike.xj.hf;
import com.bytedance.sdk.openadsdk.zg.w.hf.y;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TTDislikeScrollListView extends ListView {
    private AdapterView.OnItemClickListener hf;
    private AdapterView.OnItemClickListener w;
    private hf xj;

    public TTDislikeScrollListView(Context context) {
        super(context);
        this.w = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.widget.TTDislikeScrollListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (TTDislikeScrollListView.this.getAdapter() == null || TTDislikeScrollListView.this.getAdapter().getItem(i) == null || !(TTDislikeScrollListView.this.getAdapter().getItem(i) instanceof y)) {
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
                y yVar = (y) TTDislikeScrollListView.this.getAdapter().getItem(i);
                if (yVar.y()) {
                    return;
                }
                if (TTDislikeScrollListView.this.hf != null) {
                    TTDislikeScrollListView.this.hf.onItemClick(adapterView, view, i, j);
                }
                if (TTDislikeScrollListView.this.xj != null) {
                    TTDislikeScrollListView.this.xj.xj(yVar);
                }
            }
        };
        xj();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public void setDislikeController(hf hfVar) {
        this.xj = hfVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.hf = onItemClickListener;
    }

    private void xj() {
        super.setOnItemClickListener(this.w);
    }
}
