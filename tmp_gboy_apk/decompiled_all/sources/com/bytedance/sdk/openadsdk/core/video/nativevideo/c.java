package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.widget.qt;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c {
    private y xj;

    public c(y yVar) {
        this.xj = yVar;
    }

    public boolean hf() {
        View view;
        RoundImageView roundImageView;
        TextView textView;
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.xj.et)) {
            return true;
        }
        View view2 = this.xj.f;
        return (view2 != null && view2.getVisibility() == 0) || ((view = this.xj.tf) != null && view.getVisibility() == 0) || (((roundImageView = this.xj.p) != null && roundImageView.getVisibility() == 0) || ((textView = this.xj.f10451pl) != null && textView.getVisibility() == 0));
    }

    public boolean xj() {
        qt qtVar = this.xj.x;
        boolean xj = qtVar != null ? qtVar.xj() : false;
        StringBuilder sb = new StringBuilder("isVisible=");
        sb.append(xj);
        sb.append(",mPlayBtn.getVisibility() == VISIBLE->");
        sb.append(this.xj.w.getVisibility() == 0);
        pl.xj("ClickCreativeListener", sb.toString());
        return xj || this.xj.w.getVisibility() == 0;
    }
}
