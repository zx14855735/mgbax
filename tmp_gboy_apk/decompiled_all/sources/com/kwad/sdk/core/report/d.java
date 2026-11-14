package com.kwad.sdk.core.report;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.commons.codec.language.Soundex;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class d implements l<e> {
    private static final String[] aLe = {"count(*)"};
    private static boolean aLf = false;
    protected c aLg;

    static {
        qNfdoV();
    }

    public d(c cVar) {
        a(cVar);
    }

    private void a(c cVar) {
        this.aLg = cVar;
    }

    private synchronized void c(e eVar) {
        if (aLf) {
            getTag();
            Objects.toString(eVar);
        }
        try {
            this.aLg.getReadableDatabase().delete(Kh(), "actionId=?", new String[]{eVar.actionId});
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    private static /* synthetic */ void qNfdoV() {
        char[] charArray = "NB@\u0003JL@H\u0003OBT\u0003^EHAA\u0003gCDo_DIJH".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ Soundex.SILENT_MARKER);
        }
        String str = new String(charArray);
        char[] charArray2 = "NADCDY".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ Soundex.SILENT_MARKER);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized void B(List<e> list) {
        if (aLf) {
            getTag();
            list.size();
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.aLg.getReadableDatabase();
                sQLiteDatabase.beginTransaction();
                Iterator<e> it = list.iterator();
                while (it.hasNext()) {
                    c(it.next());
                }
                sQLiteDatabase.setTransactionSuccessful();
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.printStackTrace(e);
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.c.printStackTrace(e2);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e3) {
                        com.kwad.sdk.core.d.c.printStackTrace(e3);
                    }
                }
            }
        } finally {
        }
    }

    public abstract String Kh();

    public abstract String[] Ki();

    public final synchronized List<e> Kj() {
        Cursor cursor = null;
        try {
            try {
                String[] Ki = Ki();
                cursor = this.aLg.getReadableDatabase().query(Kh(), Ki.length == 0 ? null : Ki, null, null, null, null, null);
                if (cursor != null) {
                    ArrayList arrayList = new ArrayList();
                    while (cursor.moveToNext()) {
                        try {
                            arrayList.add(f(cursor));
                        } catch (Exception e) {
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                        }
                    }
                    if (aLf) {
                        getTag();
                        arrayList.size();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            e eVar = (e) it.next();
                            getTag();
                            Objects.toString(eVar);
                        }
                    }
                    return arrayList;
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.c.printStackTrace(e2);
            }
            return new ArrayList();
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        }
    }

    @Override // com.kwad.sdk.core.report.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final synchronized void m(e eVar) {
        ContentValues contentValues;
        if (aLf) {
            getTag();
            Objects.toString(eVar);
        }
        try {
            contentValues = new ContentValues();
            contentValues.put("actionId", eVar.actionId);
            contentValues.put("aLog", eVar.toJson().toString());
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        try {
            this.aLg.getReadableDatabase().insert(Kh(), null, contentValues);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.c.printStackTrace(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized List<e> dW(int i) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = this.aLg.getReadableDatabase().query(Kh(), Ki(), null, null, null, null, null, "0,200");
                while (cursor.moveToNext()) {
                    try {
                        arrayList.add(f(cursor));
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                    }
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.c.printStackTrace(e2);
            }
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        }
        return arrayList;
    }

    public abstract e f(Cursor cursor);

    public abstract String getTag();

    @Override // com.kwad.sdk.core.report.l
    public final synchronized long size() {
        long j;
        Cursor cursor = null;
        try {
            try {
                cursor = this.aLg.getReadableDatabase().query(Kh(), aLe, null, null, null, null, null);
                cursor.moveToFirst();
                j = cursor.getLong(0);
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                j = 0;
            }
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        }
        return j;
    }
}
