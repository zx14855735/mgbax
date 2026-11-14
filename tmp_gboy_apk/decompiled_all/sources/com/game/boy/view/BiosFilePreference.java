package com.game.boy.view;

import IQ76hF.AmA8tU;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.net.Uri;
import android.util.AttributeSet;
import androidx.preference.Preference;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BiosFilePreference extends Preference {

    /* renamed from: D6yqiO, reason: collision with root package name */
    public String f11125D6yqiO;

    /* renamed from: D8MqeW, reason: collision with root package name */
    public String[] f11126D8MqeW;

    public BiosFilePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11126D8MqeW = new String[]{".bin", ".bios"};
        this.f9082B2KMhB = new AmA8tU(14, this);
    }

    @Override // androidx.preference.Preference
    public final Object B25kr6(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    @Override // androidx.preference.Preference
    public final void B4ZgIw(Object obj) {
        this.f11125D6yqiO = ARc23Z(null);
        BpkvW3();
    }

    public final String BmvVmW(Uri uri) {
        Uri uri2;
        int columnIndex;
        Cursor cursor = null;
        r1 = null;
        r1 = null;
        r1 = null;
        String string = null;
        if (IAdInterListener.AdProdType.PRODUCT_CONTENT.equals(uri.getScheme())) {
            try {
                uri2 = uri;
                Cursor query = getContext().getContentResolver().query(uri2, null, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst() && (columnIndex = query.getColumnIndex("_display_name")) >= 0) {
                            string = query.getString(columnIndex);
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            uri2 = uri;
        }
        if (string != null) {
            return string;
        }
        String path = uri2.getPath();
        int lastIndexOf = path.lastIndexOf(47);
        return lastIndexOf != -1 ? path.substring(lastIndexOf + 1) : path;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00b4 A[Catch: Exception -> 0x00b0, TRY_LEAVE, TryCatch #0 {Exception -> 0x00b0, blocks: (B:8:0x00ac, B:10:0x00b4, B:38:0x00e5, B:40:0x00ea), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f8 A[Catch: Exception -> 0x00f4, TRY_LEAVE, TryCatch #7 {Exception -> 0x00f4, blocks: (B:55:0x00f0, B:48:0x00f8), top: B:54:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00ac A[Catch: Exception -> 0x00b0, TRY_ENTER, TryCatch #0 {Exception -> 0x00b0, blocks: (B:8:0x00ac, B:10:0x00b4, B:38:0x00e5, B:40:0x00ea), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void BniPrB(android.net.Uri r10) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.game.boy.view.BiosFilePreference.BniPrB(android.net.Uri):void");
    }

    public final void BpkvW3() {
        String name = this.f11125D6yqiO != null ? new File(this.f11125D6yqiO).getName() : null;
        if (name != null) {
            BNL6CD(name);
        }
    }

    public BiosFilePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11126D8MqeW = new String[]{".bin", ".bios"};
        this.f9082B2KMhB = new AmA8tU(14, this);
    }
}
