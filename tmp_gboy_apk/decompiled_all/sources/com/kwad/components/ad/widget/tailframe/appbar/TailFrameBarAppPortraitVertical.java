package com.kwad.components.ad.widget.tailframe.appbar;

import BPw6Q8.ASJ6gh;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TailFrameBarAppPortraitVertical extends a {
    public TailFrameBarAppPortraitVertical(Context context) {
        this(context, null);
    }

    @Override // com.kwad.components.ad.widget.tailframe.appbar.a
    public int getLayoutId() {
        return R.layout.ksad_video_tf_bar_app_portrait_vertical;
    }

    @Override // com.kwad.components.ad.widget.tailframe.appbar.a
    public final void j(AdTemplate adTemplate) {
        if (e.O(adTemplate)) {
            this.Ha.setBackgroundColor(ASJ6gh.A4TApA(getContext(), R.color.ksad_translucent));
            this.nq.setTextColor(Color.parseColor("#FFFFFF"));
            this.Np.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            this.Ha.setBackgroundColor(Color.parseColor("#E6FFFFFF"));
        }
        super.j(adTemplate);
    }

    public TailFrameBarAppPortraitVertical(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarAppPortraitVertical(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
