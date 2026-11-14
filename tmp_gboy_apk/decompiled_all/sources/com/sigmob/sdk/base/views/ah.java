package com.sigmob.sdk.base.views;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.logger.SigmobLog;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ah extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    int f13254a;
    boolean b;
    private final w c;
    private final w d;
    private int e;

    public ah(Context context) {
        super(context);
        this.f13254a = 0;
        this.b = false;
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.c = new w(context);
        w wVar = new w(context);
        this.d = wVar;
        setLayoutParams(layoutParams);
        int i = this.f13254a;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
        layoutParams2.addRule(9);
        layoutParams2.addRule(20);
        wVar.setId(ClientMetadata.generateViewId());
        addView(wVar, layoutParams2);
    }

    public void a(int i) {
        this.e = i;
        if (!this.b) {
            if (i > 0) {
                this.d.setText(String.valueOf(i));
            }
        } else if (i > 0) {
            this.c.setText(com.sigmob.sdk.base.k.d(Integer.valueOf(i)));
            if (this.c.getVisibility() != 0) {
                this.c.setVisibility(0);
            }
        }
    }

    public void b() {
        if (this.b) {
            return;
        }
        this.b = true;
        SigmobLog.d("show skip widget");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.f13254a);
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        w wVar = this.c;
        int i = this.f13254a;
        wVar.setPadding((int) (i / 3.0f), 0, (int) (i / 3.0f), 0);
        int i2 = this.e;
        if (i2 > 0) {
            this.c.setText(com.sigmob.sdk.base.k.d(Integer.valueOf(i2)));
        } else {
            this.c.setText(com.sigmob.sdk.base.k.i());
        }
        addView(this.c, layoutParams);
    }

    public int getTime() {
        return this.e;
    }

    public boolean a() {
        return this.b;
    }
}
