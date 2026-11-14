package com.bytedance.sdk.openadsdk.core.pl.xj;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.y;
import com.bytedance.sdk.openadsdk.core.widget.tf;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f {

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

    private static AlertDialog createAlertDialog(Activity activity, int i, final DialogBuilder dialogBuilder) {
        AlertDialog.Builder onCancelListener = new AlertDialog.Builder(activity, i).setTitle(dialogBuilder.title).setMessage(dialogBuilder.message).setPositiveButton(dialogBuilder.positiveBtnText, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.pl.xj.f.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onPositiveBtnClick(dialogInterface);
                }
            }
        }).setNegativeButton(dialogBuilder.negativeBtnText, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.pl.xj.f.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onNegativeBtnClick(dialogInterface);
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.pl.xj.f.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onCancel(dialogInterface);
                }
            }
        });
        if (dialogBuilder.icon != null) {
            onCancelListener.setIcon(dialogBuilder.icon);
        }
        AlertDialog create = onCancelListener.create();
        if (activity != null && !activity.isFinishing()) {
            create.show();
        }
        return create;
    }

    private static AlertDialog getBackInstallDialog(Activity activity, final DialogBuilder dialogBuilder) {
        return new com.bytedance.sdk.openadsdk.core.widget.tf(activity).xj(dialogBuilder.title).hf(dialogBuilder.message).w(dialogBuilder.positiveBtnText).u(dialogBuilder.negativeBtnText).xj(dialogBuilder.icon).xj(new tf.xj() { // from class: com.bytedance.sdk.openadsdk.core.pl.xj.f.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.tf.xj
            public void onClickNo(Dialog dialog) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onNegativeBtnClick(dialog);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.tf.xj
            public void onClickYes(Dialog dialog) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onPositiveBtnClick(dialog);
                }
            }
        }).xj(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.pl.xj.f.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onCancel(dialogInterface);
                }
            }
        });
    }

    public static void showDialogByDelegate(WeakReference<Context> weakReference, boolean z, final DialogBuilder dialogBuilder) {
        y.xj xjVar = new y.xj() { // from class: com.bytedance.sdk.openadsdk.core.pl.xj.f.3
            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnNo() {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onNegativeBtnClick(new xj());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnYes() {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onPositiveBtnClick(new xj());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogCancel() {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onCancel(new xj());
                }
            }
        };
        if (z) {
            com.bytedance.sdk.openadsdk.core.a.y.xj(weakReference.get(), String.valueOf(dialogBuilder.hashCode()), dialogBuilder.title, dialogBuilder.message, dialogBuilder.positiveBtnText, dialogBuilder.negativeBtnText, xjVar);
        } else {
            com.bytedance.sdk.openadsdk.core.a.y.xj(weakReference.get(), String.valueOf(dialogBuilder.hashCode()), dialogBuilder.title, dialogBuilder.message, xjVar);
        }
    }

    public static AlertDialog showDialogBySelf(Activity activity, boolean z, DialogBuilder dialogBuilder) {
        if (!z) {
            return createAlertDialog(activity, jk.f(activity, "Theme.Dialog.TTDownload"), dialogBuilder);
        }
        AlertDialog backInstallDialog = getBackInstallDialog(activity, dialogBuilder);
        if (activity != null && !activity.isFinishing()) {
            backInstallDialog.show();
        }
        return backInstallDialog;
    }
}
