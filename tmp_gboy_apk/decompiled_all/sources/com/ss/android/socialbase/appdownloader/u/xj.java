package com.ss.android.socialbase.appdownloader.u;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.w.g;
import com.ss.android.socialbase.appdownloader.w.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj extends com.ss.android.socialbase.appdownloader.w.hf {
    private AlertDialog.Builder xj;

    /* renamed from: com.ss.android.socialbase.appdownloader.u.xj$xj, reason: collision with other inner class name */
    public static class C0480xj implements pl {
        private AlertDialog xj;

        public C0480xj(AlertDialog.Builder builder) {
            if (builder != null) {
                this.xj = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.w.pl
        public boolean hf() {
            AlertDialog alertDialog = this.xj;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        @Override // com.ss.android.socialbase.appdownloader.w.pl
        public void xj() {
            AlertDialog alertDialog = this.xj;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }
    }

    public xj(Context context) {
        this.xj = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.w.g
    public g hf(int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.xj;
        if (builder != null) {
            builder.setNegativeButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.w.g
    public g xj(int i) {
        AlertDialog.Builder builder = this.xj;
        if (builder != null) {
            builder.setTitle(i);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.w.g
    public g xj(String str) {
        AlertDialog.Builder builder = this.xj;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.w.g
    public g xj(int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.xj;
        if (builder != null) {
            builder.setPositiveButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.w.g
    public g xj(DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = this.xj;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.w.g
    public pl xj() {
        return new C0480xj(this.xj);
    }
}
