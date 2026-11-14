package com.octopus.ad.b.j;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f12379a;

    public a(Context context) {
        this.f12379a = context;
    }

    public boolean a(int i, String str, ContentValues[] contentValuesArr) {
        Uri parse;
        if (i == 6) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        } else if (i != 7) {
            parse = null;
        } else {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/STATISTICS_" + str);
        }
        if (parse == null) {
            return false;
        }
        return this.f12379a.getContentResolver().bulkInsert(parse, contentValuesArr) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(int r8, java.lang.String r9) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L5c
            r1 = 1
            if (r8 == r1) goto L49
            r1 = 2
            if (r8 == r1) goto L36
            r1 = 3
            if (r8 == r1) goto L2f
            r1 = 4
            if (r8 == r1) goto L1c
            r9 = 5
            if (r8 == r9) goto L14
            r2 = r0
            goto L63
        L14:
            java.lang.String r8 = "content://com.vivo.abe.exidentifier/guid"
            android.net.Uri r8 = android.net.Uri.parse(r8)
        L1a:
            r2 = r8
            goto L63
        L1c:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS_"
            r8.<init>(r1)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L1a
        L2f:
            java.lang.String r8 = "content://com.vivo.vms.IdProvider/IdentifierId/UDID"
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L1a
        L36:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            r8.<init>(r1)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L1a
        L49:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
            r8.<init>(r1)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L1a
        L5c:
            java.lang.String r8 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L1a
        L63:
            if (r2 != 0) goto L66
            return r0
        L66:
            android.content.Context r8 = r7.f12379a     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L91
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L91
            r5 = 0
            r6 = 0
            r3 = 0
            r4 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L91
            if (r8 == 0) goto L8a
            boolean r9 = r8.moveToNext()     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L91
            if (r9 == 0) goto L8a
            java.lang.String r9 = "value"
            int r9 = r8.getColumnIndex(r9)     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L91
            java.lang.String r0 = r8.getString(r9)     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L91
            goto L8a
        L87:
            r0 = move-exception
            r8 = r0
            goto L90
        L8a:
            if (r8 == 0) goto L8f
            r8.close()     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L91
        L8f:
            return r0
        L90:
            throw r8
        L91:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.octopus.ad.b.j.a.a(int, java.lang.String):java.lang.String");
    }
}
