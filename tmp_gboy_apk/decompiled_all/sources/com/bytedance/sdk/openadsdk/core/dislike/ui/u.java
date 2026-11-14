package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.widget.FlowLayout;
import com.bytedance.sdk.openadsdk.zg.w.hf.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends BaseAdapter {
    private final Context hf;
    private xj w;
    private final List<y> xj;

    public class hf {
        FlowLayout hf;
        TextView xj;

        private hf() {
        }
    }

    public interface xj {
        void xj(int i, y yVar);
    }

    public u(Context context, List<y> list) {
        this.xj = list == null ? new ArrayList(0) : new ArrayList(list);
        this.hf = context != null ? context.getApplicationContext() : context;
    }

    private TextView hf() {
        TextView textView = new TextView(this.hf);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        com.bytedance.sdk.openadsdk.core.dislike.xj.u hf2 = com.bytedance.sdk.openadsdk.core.dislike.xj.xj.hf();
        marginLayoutParams.setMargins(0, 0, hf2.xj(this.hf, 8.0f), hf2.xj(this.hf, 8.0f));
        textView.setLayoutParams(marginLayoutParams);
        int xj2 = hf2.xj(this.hf, 21.0f);
        int xj3 = hf2.xj(this.hf, 6.0f);
        textView.setPadding(xj2, xj3, xj2, xj3);
        Drawable xj4 = xj(Color.parseColor("#0A161823"));
        ((GradientDrawable) xj4).setCornerRadius(hf2.xj(this.hf, 4.0f));
        textView.setBackground(xj4);
        textView.setTextColor(Color.parseColor("#BF161823"));
        textView.setTextSize(14.0f);
        textView.setAlpha(0.75f);
        return textView;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<y> list = this.xj;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.xj.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View view2;
        hf hfVar;
        if (view == null) {
            hfVar = new hf();
            view2 = com.bytedance.sdk.openadsdk.res.u.hf(this.hf);
            hfVar.xj = (TextView) view2.findViewById(2047279094);
            hfVar.hf = (FlowLayout) view2.findViewById(2047279093);
            view2.setTag(hfVar);
        } else {
            view2 = view;
            hfVar = (hf) view.getTag();
        }
        y yVar = this.xj.get(i);
        hfVar.xj.setText(yVar.hf());
        if (!yVar.y()) {
            hfVar.xj.setBackground(xj());
            hfVar.hf.setVisibility(8);
            return view2;
        }
        hfVar.hf.removeAllViews();
        List<y> u = yVar.u();
        for (int i2 = 0; i2 < u.size(); i2++) {
            final y yVar2 = u.get(i2);
            TextView hf2 = hf();
            hf2.setText(yVar2.hf());
            hf2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.u.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (u.this.w != null) {
                        u.this.w.xj(i, yVar2);
                    }
                }
            });
            hfVar.hf.addView(hf2);
        }
        hfVar.hf.setVisibility(0);
        return view2;
    }

    private StateListDrawable xj() {
        Drawable xj2 = xj(Color.parseColor("#FDE6E6E6"));
        Drawable xj3 = xj(Color.parseColor("#FDFFFFFF"));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, xj2);
        stateListDrawable.addState(new int[0], xj3);
        return stateListDrawable;
    }

    private Drawable xj(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    public void xj(xj xjVar) {
        this.w = xjVar;
    }

    public void xj(List<y> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.xj.clear();
        this.xj.addAll(list);
        notifyDataSetChanged();
    }
}
