package com.kwad.components.core.proxy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class g extends AlertDialog {
    protected ViewGroup Da;
    public Activity mActivity;
    protected final Context mContext;

    public g(Activity activity) {
        super(activity);
        setOwnerActivity(activity);
        this.mActivity = activity;
        this.mContext = com.kwad.sdk.o.m.wrapContextIfNeed(activity);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        try {
            com.kwad.sdk.o.m.r(activity);
        } catch (Throwable unused) {
        }
        try {
            super.dismiss();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    public float dw() {
        return -1.0f;
    }

    public ViewGroup dx() {
        return null;
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        T t = (T) this.Da.findViewById(i);
        return t != null ? t : (T) super.findViewById(i);
    }

    public abstract int getLayoutId();

    public abstract void h(View view);

    @Override // android.app.AlertDialog, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (getLayoutId() != 0) {
                this.Da = (ViewGroup) com.kwad.sdk.o.m.inflate(this.mContext, getLayoutId(), null);
            } else {
                this.Da = dx();
            }
            setContentView(this.Da);
            setCanceledOnTouchOutside(pm());
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().clearFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            if (dw() != -1.0f) {
                attributes.dimAmount = dw();
            }
            getWindow().setAttributes(attributes);
            setCancelable(qU());
            h(this.Da);
        } catch (Throwable th) {
            if (!com.kwad.sdk.l.DP().CT()) {
                throw th;
            }
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
            dismiss();
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        setTitle((CharSequence) null);
    }

    public boolean pm() {
        return false;
    }

    public boolean qU() {
        return true;
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        super.setContentView(i);
        this.Da = (ViewGroup) com.kwad.sdk.o.m.inflate(this.mContext, i, null);
    }
}
