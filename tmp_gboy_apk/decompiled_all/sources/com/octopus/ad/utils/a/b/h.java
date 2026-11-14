package com.octopus.ad.utils.a.b;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class h implements com.octopus.ad.utils.a.d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f12686a;

    public h(Context context) {
        this.f12686a = context;
    }

    @Override // com.octopus.ad.utils.a.d
    public boolean a() {
        Context context = this.f12686a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception e) {
            com.octopus.ad.utils.a.f.a(e);
            return false;
        }
    }

    @Override // com.octopus.ad.utils.a.d
    public void a(com.octopus.ad.utils.a.c cVar) {
        if (this.f12686a == null || cVar == null) {
            return;
        }
        try {
            Cursor query = this.f12686a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
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
