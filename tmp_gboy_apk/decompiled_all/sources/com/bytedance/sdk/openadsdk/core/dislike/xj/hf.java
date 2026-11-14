package com.bytedance.sdk.openadsdk.core.dislike.xj;

import ADYaiT.BpkvW3;
import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.zg.w.hf.y;
import java.lang.reflect.Field;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private final com.bytedance.sdk.openadsdk.core.dislike.w.hf xj;

    public static final class xj implements AdapterView.OnItemClickListener {
        private final AdapterView.OnItemClickListener hf;
        private final hf xj;

        private com.bytedance.sdk.openadsdk.core.dislike.w.w xj(Object obj) {
            Object obj2;
            if (obj == null) {
                return null;
            }
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                try {
                    declaredFields[i].setAccessible(true);
                    obj2 = declaredFields[i].get(obj);
                } catch (Exception e) {
                    pl.xj(e);
                }
                if (obj2 instanceof y) {
                    return new com.bytedance.sdk.openadsdk.core.dislike.w.w(((y) obj2).xj(), ((y) obj2).hf());
                }
                continue;
            }
            return null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.Adapter] */
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ?? adapter = adapterView.getAdapter();
            if (adapter != 0) {
                Object item = adapter.getItem(i);
                if (BpkvW3.BmvVmW(item)) {
                    this.xj.xj(xj(item));
                }
            }
            AdapterView.OnItemClickListener onItemClickListener = this.hf;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i, j);
            }
        }

        private xj(AdapterView.OnItemClickListener onItemClickListener, hf hfVar) {
            this.xj = hfVar;
            this.hf = onItemClickListener;
        }
    }

    public hf(com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar) {
        this.xj = hfVar;
    }

    public void xj(y yVar) {
        if (this.xj == null || yVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.xj.xj.xj().xj(this.xj, yVar);
    }

    public static final void xj(com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar, Dialog dialog, Integer[] numArr) {
        if (numArr == null || numArr.length <= 0) {
            return;
        }
        hf hfVar2 = new hf(hfVar);
        for (Integer num : numArr) {
            View findViewById = dialog.findViewById(num.intValue());
            if (findViewById instanceof ListView) {
                ListView listView = (ListView) findViewById;
                listView.setOnItemClickListener(new xj(listView.getOnItemClickListener(), hfVar2));
            }
        }
    }
}
