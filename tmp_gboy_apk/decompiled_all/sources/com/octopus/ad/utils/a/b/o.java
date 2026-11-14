package com.octopus.ad.utils.a.b;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.czhj.sdk.common.Constants;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class o implements com.octopus.ad.utils.a.d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f12696a;

    public o(Context context) {
        this.f12696a = context;
    }

    @Override // com.octopus.ad.utils.a.d
    public boolean a() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return com.octopus.ad.utils.a.g.a("persist.sys.identifierid.supported", Constants.FAIL).equals("1");
    }

    @Override // com.octopus.ad.utils.a.d
    public void a(com.octopus.ad.utils.a.c cVar) {
        if (this.f12696a == null || cVar == null) {
            return;
        }
        try {
            Cursor query = this.f12696a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            try {
                Objects.requireNonNull(query);
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex("value"));
                if (string != null && string.length() != 0) {
                    com.octopus.ad.utils.a.f.a("OAID query success: ".concat(string));
                    cVar.a(string);
                    query.close();
                    return;
                }
                throw new com.octopus.ad.utils.a.e("OAID query failed");
            } finally {
            }
        } catch (Exception e) {
            com.octopus.ad.utils.a.f.a(e);
            cVar.a(e);
        }
    }
}
