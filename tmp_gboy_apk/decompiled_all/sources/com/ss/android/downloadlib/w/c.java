package com.ss.android.downloadlib.w;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.download.api.model.hf;
import com.ss.android.downloadlib.c.p;
import com.ss.android.socialbase.appdownloader.w.g;
import com.ss.android.socialbase.appdownloader.w.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c extends com.ss.android.socialbase.appdownloader.w.xj {
    private static String xj = "c";

    public static class xj implements pl {
        private Dialog xj;

        public xj(Dialog dialog) {
            if (dialog != null) {
                this.xj = dialog;
                xj();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.w.pl
        public boolean hf() {
            Dialog dialog = this.xj;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }

        @Override // com.ss.android.socialbase.appdownloader.w.pl
        public void xj() {
            Dialog dialog = this.xj;
            if (dialog != null) {
                dialog.show();
            }
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.w.xj, com.ss.android.socialbase.appdownloader.w.u
    public g xj(Context context) {
        return new g(context) { // from class: com.ss.android.downloadlib.w.c.1
            private DialogInterface.OnClickListener kd;
            private DialogInterface.OnClickListener u;
            private hf.xj w;
            final /* synthetic */ Context xj;
            private DialogInterface.OnCancelListener y;

            {
                this.xj = context;
                this.w = new hf.xj(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.w.g
            public g hf(int i, DialogInterface.OnClickListener onClickListener) {
                this.w.u(this.xj.getResources().getString(i));
                this.kd = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.w.g
            public g xj(int i) {
                this.w.xj(this.xj.getResources().getString(i));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.w.g
            public g xj(String str) {
                this.w.hf(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.w.g
            public g xj(int i, DialogInterface.OnClickListener onClickListener) {
                this.w.w(this.xj.getResources().getString(i));
                this.u = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.w.g
            public g xj(DialogInterface.OnCancelListener onCancelListener) {
                this.y = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.w.g
            public g xj(boolean z) {
                this.w.xj(z);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.w.g
            public pl xj() {
                this.w.xj(new hf.InterfaceC0464hf() { // from class: com.ss.android.downloadlib.w.c.1.1
                    @Override // com.ss.android.download.api.model.hf.InterfaceC0464hf
                    public void hf(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.kd != null) {
                            AnonymousClass1.this.kd.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.download.api.model.hf.InterfaceC0464hf
                    public void w(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.y == null || dialogInterface == null) {
                            return;
                        }
                        AnonymousClass1.this.y.onCancel(dialogInterface);
                    }

                    @Override // com.ss.android.download.api.model.hf.InterfaceC0464hf
                    public void xj(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.u != null) {
                            AnonymousClass1.this.u.onClick(dialogInterface, -1);
                        }
                    }
                });
                p.xj(c.xj, "getThemedAlertDlgBuilder", null);
                this.w.xj(3);
                return new xj(com.ss.android.downloadlib.addownload.pl.w().hf(this.w.xj()));
            }
        };
    }
}
