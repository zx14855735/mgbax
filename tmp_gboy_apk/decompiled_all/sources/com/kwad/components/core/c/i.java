package com.kwad.components.core.c;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class i implements j, Comparable<i> {
    private final String Oc;
    private final String Om;
    private final String On;
    private final String Oo;
    private final long Op;
    private final long createTime;
    private final int ecpm;

    private i(String str, String str2, String str3, int i, String str4, long j, long j2) {
        this.Om = str;
        this.Oc = str2;
        this.On = str3;
        this.ecpm = i;
        this.Oo = str4;
        this.createTime = j;
        this.Op = j2;
    }

    public static List<i> a(e eVar, AdResultData adResultData) {
        List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
        int size = proceedTemplateList.size();
        long currentTimeMillis = System.currentTimeMillis();
        long ow = eVar.ow() + (currentTimeMillis / 1000);
        ArrayList arrayList = new ArrayList();
        SceneImpl defaultAdScene = adResultData.getDefaultAdScene();
        for (AdTemplate adTemplate : proceedTemplateList) {
            long j = currentTimeMillis;
            arrayList.add(new i(String.valueOf(com.kwad.sdk.core.response.b.e.eB(adTemplate)), String.valueOf(adResultData.getPosId()), new AdResultData(adResultData, defaultAdScene, Collections.singletonList(adTemplate)).getResponseJson(), com.kwad.sdk.core.response.b.e.eF(adTemplate), adResultData.getDefaultAdScene().toJson().toString(), j + size, ow));
            size--;
            currentTimeMillis = j;
        }
        return arrayList;
    }

    @SuppressLint({com.sigmob.sdk.downloader.core.c.b})
    private static synchronized i c(Cursor cursor) {
        i iVar;
        synchronized (i.class) {
            iVar = new i(cursor.getString(cursor.getColumnIndex("creativeId")), cursor.getString(cursor.getColumnIndex("posId")), cursor.getString(cursor.getColumnIndex("adJson")), cursor.getInt(cursor.getColumnIndex("ecpm")), cursor.getString(cursor.getColumnIndex("adSenseJson")), cursor.getLong(cursor.getColumnIndex("createTime")), cursor.getLong(cursor.getColumnIndex("expireTime")));
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(i iVar) {
        return iVar.oD() == oD() ? (int) (iVar.oE() - oE()) : iVar.oD() - oD();
    }

    public static AdResultData k(List<i> list) {
        ArrayList arrayList = new ArrayList();
        AdResultData adResultData = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        Iterator<i> it = list.iterator();
        SceneImpl sceneImpl = null;
        while (it.hasNext()) {
            adResultData = c(it.next());
            if (adResultData != null) {
                if (sceneImpl == null) {
                    sceneImpl = adResultData.getDefaultAdScene();
                }
                arrayList.addAll(adResultData.getProceedTemplateList());
            }
        }
        AdResultData adResultData2 = new AdResultData(adResultData, sceneImpl, arrayList);
        adResultData2.setAdSource("cache");
        return adResultData2;
    }

    private String oC() {
        return this.On;
    }

    private int oD() {
        return this.ecpm;
    }

    private long oE() {
        return this.createTime;
    }

    private String oG() {
        return this.Oo;
    }

    public final long oF() {
        return this.Op;
    }

    public final String oH() {
        return this.Om;
    }

    public final String ot() {
        return this.Oc;
    }

    @Override // com.kwad.components.core.c.j
    public final ContentValues ox() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("creativeId", this.Om);
        contentValues.put("posId", this.Oc);
        contentValues.put("adJson", this.On);
        contentValues.put("ecpm", Integer.valueOf(this.ecpm));
        contentValues.put("adSenseJson", this.Oo);
        contentValues.put("createTime", Long.valueOf(this.createTime));
        contentValues.put("expireTime", Long.valueOf(this.Op));
        contentValues.put("playAgainJson", (String) null);
        return contentValues;
    }

    private static AdResultData c(i iVar) {
        if (iVar == null) {
            return null;
        }
        if (iVar.oC() != null && iVar.oG() != null) {
            try {
                String oG = iVar.oG();
                SceneImpl sceneImpl = new SceneImpl();
                sceneImpl.parseJson(new JSONObject(oG));
                AdResultData createFromResponseJson = AdResultData.createFromResponseJson(iVar.oC(), sceneImpl);
                Iterator<AdTemplate> it = createFromResponseJson.getProceedTemplateList().iterator();
                while (it.hasNext()) {
                    it.next().fromCache = true;
                }
                return createFromResponseJson;
            } catch (JSONException e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                return null;
            }
        }
        com.kwad.sdk.core.d.c.w("CachedAd", "createAdResultData cachedAd data illegal");
        return null;
    }

    public static List<i> a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                arrayList.add(c(cursor));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        return arrayList;
    }
}
