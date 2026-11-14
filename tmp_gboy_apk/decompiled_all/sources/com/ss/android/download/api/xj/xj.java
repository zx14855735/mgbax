package com.ss.android.download.api.xj;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import com.ss.android.download.api.config.g;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.hf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj implements g {
    @Override // com.ss.android.download.api.config.g
    public Dialog hf(com.ss.android.download.api.model.hf hfVar) {
        return xj(hfVar);
    }

    @Override // com.ss.android.download.api.config.g
    public void xj(int i, Context context, DownloadModel downloadModel, String str, Drawable drawable, int i2) {
        Toast.makeText(context, str, 0).show();
    }

    private static Dialog xj(final com.ss.android.download.api.model.hf hfVar) {
        if (hfVar == null) {
            return null;
        }
        AlertDialog show = new AlertDialog.Builder(hfVar.xj).setTitle(hfVar.hf).setMessage(hfVar.w).setPositiveButton(hfVar.u, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.xj.xj.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                hf.InterfaceC0464hf interfaceC0464hf = com.ss.android.download.api.model.hf.this.f;
                if (interfaceC0464hf != null) {
                    interfaceC0464hf.xj(dialogInterface);
                }
            }
        }).setNegativeButton(hfVar.kd, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.xj.xj.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                hf.InterfaceC0464hf interfaceC0464hf = com.ss.android.download.api.model.hf.this.f;
                if (interfaceC0464hf != null) {
                    interfaceC0464hf.hf(dialogInterface);
                }
            }
        }).show();
        show.setCanceledOnTouchOutside(hfVar.y);
        show.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.download.api.xj.xj.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                hf.InterfaceC0464hf interfaceC0464hf = com.ss.android.download.api.model.hf.this.f;
                if (interfaceC0464hf != null) {
                    interfaceC0464hf.w(dialogInterface);
                }
            }
        });
        Drawable drawable = hfVar.c;
        if (drawable != null) {
            show.setIcon(drawable);
        }
        return show;
    }
}
