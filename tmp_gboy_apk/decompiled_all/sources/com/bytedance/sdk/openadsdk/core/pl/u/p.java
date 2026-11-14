package com.bytedance.sdk.openadsdk.core.pl.u;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.y;
import com.bytedance.sdk.openadsdk.core.widget.tf;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class p {

    public static class xj implements DialogInterface {
        private xj() {
        }

        @Override // android.content.DialogInterface
        public void cancel() {
        }

        @Override // android.content.DialogInterface
        public void dismiss() {
        }
    }

    private static AlertDialog xj(Activity activity, final com.bytedance.sdk.openadsdk.core.pl.u.xj xjVar) {
        return new com.bytedance.sdk.openadsdk.core.widget.tf(activity).xj(xjVar.xj).hf(xjVar.hf).w(xjVar.w).u(xjVar.u).xj(xjVar.kd).xj(new tf.xj() { // from class: com.bytedance.sdk.openadsdk.core.pl.u.p.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.tf.xj
            public void onClickNo(Dialog dialog) {
                hf hfVar = com.bytedance.sdk.openadsdk.core.pl.u.xj.this.y;
                if (hfVar != null) {
                    hfVar.hf(dialog);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.tf.xj
            public void onClickYes(Dialog dialog) {
                hf hfVar = com.bytedance.sdk.openadsdk.core.pl.u.xj.this.y;
                if (hfVar != null) {
                    hfVar.xj(dialog);
                }
            }
        }).xj(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.pl.u.p.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                hf hfVar = com.bytedance.sdk.openadsdk.core.pl.u.xj.this.y;
                if (hfVar != null) {
                    hfVar.w(dialogInterface);
                }
            }
        });
    }

    public static void xj(WeakReference<Context> weakReference, boolean z, final com.bytedance.sdk.openadsdk.core.pl.u.xj xjVar) {
        y.xj xjVar2 = new y.xj() { // from class: com.bytedance.sdk.openadsdk.core.pl.u.p.3
            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnNo() {
                hf hfVar = com.bytedance.sdk.openadsdk.core.pl.u.xj.this.y;
                if (hfVar != null) {
                    hfVar.hf(new xj());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnYes() {
                hf hfVar = com.bytedance.sdk.openadsdk.core.pl.u.xj.this.y;
                if (hfVar != null) {
                    hfVar.xj(new xj());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogCancel() {
                hf hfVar = com.bytedance.sdk.openadsdk.core.pl.u.xj.this.y;
                if (hfVar != null) {
                    hfVar.w(new xj());
                }
            }
        };
        if (z) {
            com.bytedance.sdk.openadsdk.core.a.y.xj(weakReference.get(), String.valueOf(xjVar.hashCode()), xjVar.xj, xjVar.hf, xjVar.w, xjVar.u, xjVar2);
        } else {
            com.bytedance.sdk.openadsdk.core.a.y.xj(weakReference.get(), String.valueOf(xjVar.hashCode()), xjVar.xj, xjVar.hf, xjVar2);
        }
    }

    public static AlertDialog xj(Activity activity, boolean z, com.bytedance.sdk.openadsdk.core.pl.u.xj xjVar) {
        if (z) {
            AlertDialog xj2 = xj(activity, xjVar);
            if (activity != null && !activity.isFinishing()) {
                xj2.show();
            }
            return xj2;
        }
        return xj(activity, jk.f(activity, "Theme.Dialog.TTDownload"), xjVar);
    }

    private static AlertDialog xj(Activity activity, int i, final com.bytedance.sdk.openadsdk.core.pl.u.xj xjVar) {
        AlertDialog.Builder onCancelListener = new AlertDialog.Builder(activity, i).setTitle(xjVar.xj).setMessage(xjVar.hf).setPositiveButton(xjVar.w, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.pl.u.p.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                hf hfVar = com.bytedance.sdk.openadsdk.core.pl.u.xj.this.y;
                if (hfVar != null) {
                    hfVar.xj(dialogInterface);
                }
            }
        }).setNegativeButton(xjVar.u, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.pl.u.p.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                hf hfVar = com.bytedance.sdk.openadsdk.core.pl.u.xj.this.y;
                if (hfVar != null) {
                    hfVar.hf(dialogInterface);
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.pl.u.p.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                hf hfVar = com.bytedance.sdk.openadsdk.core.pl.u.xj.this.y;
                if (hfVar != null) {
                    hfVar.w(dialogInterface);
                }
            }
        });
        Drawable drawable = xjVar.kd;
        if (drawable != null) {
            onCancelListener.setIcon(drawable);
        }
        AlertDialog create = onCancelListener.create();
        if (activity != null && !activity.isFinishing()) {
            create.show();
        }
        return create;
    }
}
