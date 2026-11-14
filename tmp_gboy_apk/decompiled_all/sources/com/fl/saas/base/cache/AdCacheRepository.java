package com.fl.saas.base.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.fl.saas.base.rest.ConfigHelper;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.common.util.RandomUtils;
import com.fl.saas.config.http.HttpCallbackStringListener;
import com.fl.saas.config.http.NetDataUtils;
import com.fl.saas.config.utils.DeviceUtil;
import com.sigmob.sdk.base.db.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AdCacheRepository {
    private static final String TAG = "YdSDK-AdCacheRepository";
    private static AdCacheRepository mInstance;
    private final DatabaseHelper dbHelper = DatabaseHelper.getInstance(DeviceUtil.getContext());

    private AdCacheRepository() {
    }

    private void deleteExpireAdCache() {
        SQLiteDatabase sQLiteDatabase;
        if (this.dbHelper == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            sQLiteDatabase = this.dbHelper.getReadableDatabase();
        } catch (Exception unused) {
            sQLiteDatabase = null;
        } catch (Throwable th) {
            th = th;
            sQLiteDatabase = null;
        }
        try {
            cursor = sQLiteDatabase.query(DatabaseHelper.TABLE_AD_CACHE, new String[]{DatabaseHelper.COLUMN_ID, DatabaseHelper.COLUMN_PRICE, DatabaseHelper.COLUMN_VALUE}, "_time < ?", new String[]{String.valueOf(System.currentTimeMillis() - ((ConfigHelper.getInstance().getCacheAdTime() * 60) * 1000))}, null, null, "_id DESC");
            while (cursor.moveToNext()) {
                AdCacheBean adCacheBean = new AdCacheBean();
                adCacheBean.setId(cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID)));
                adCacheBean.setPrice(cursor.getDouble(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PRICE)));
                adCacheBean.setValue(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_VALUE)));
                arrayList.add(adCacheBean);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                AdCacheBean adCacheBean2 = (AdCacheBean) it.next();
                deleteAdCache(adCacheBean2.getId());
                uploadBidFail(adCacheBean2);
            }
            cursor.close();
            sQLiteDatabase.close();
        } catch (Exception unused2) {
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
    }

    public static AdCacheRepository getInstance() {
        if (mInstance == null) {
            synchronized (AdCacheRepository.class) {
                mInstance = new AdCacheRepository();
            }
        }
        return mInstance;
    }

    private List<AdCacheBean> searchAdCaches(String str) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor = null;
        if (this.dbHelper == null) {
            return null;
        }
        deleteExpireAdCache();
        ArrayList arrayList = new ArrayList();
        try {
            sQLiteDatabase = this.dbHelper.getReadableDatabase();
        } catch (Exception unused) {
            sQLiteDatabase = null;
        } catch (Throwable th) {
            th = th;
            sQLiteDatabase = null;
        }
        try {
            cursor = sQLiteDatabase.query(DatabaseHelper.TABLE_AD_CACHE, new String[]{DatabaseHelper.COLUMN_ID, DatabaseHelper.COLUMN_KEY, DatabaseHelper.COLUMN_TIME, DatabaseHelper.COLUMN_PRICE, DatabaseHelper.COLUMN_VALUE}, "_key = ?", new String[]{str}, null, null, "_price DESC");
            while (cursor.moveToNext()) {
                AdCacheBean adCacheBean = new AdCacheBean();
                adCacheBean.setId(cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID)));
                adCacheBean.setKey(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_KEY)));
                adCacheBean.setTime(cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_TIME)));
                adCacheBean.setPrice(cursor.getDouble(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PRICE)));
                adCacheBean.setValue(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_VALUE)));
                arrayList.add(adCacheBean);
            }
            if (arrayList.size() > ConfigHelper.getInstance().getQueueNum()) {
                for (int queueNum = ConfigHelper.getInstance().getQueueNum(); queueNum < arrayList.size(); queueNum++) {
                    deleteAdCache(((AdCacheBean) arrayList.get(queueNum)).getId());
                    uploadBidFail((AdCacheBean) arrayList.get(queueNum));
                }
            }
            cursor.close();
            sQLiteDatabase.close();
            return arrayList;
        } catch (Exception unused2) {
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
    }

    private void uploadBidFail(AdCacheBean adCacheBean) {
        JSONArray optJSONArray;
        try {
            JSONObject parseResponseNew = NetDataUtils.parseResponseNew(adCacheBean.getValue());
            if (parseResponseNew.optInt(PluginConstants.KEY_ERROR_CODE, -1) == -1 || (optJSONArray = parseResponseNew.optJSONArray(a.f13169a)) == null || optJSONArray.length() <= 0) {
                return;
            }
            JSONArray optJSONArray2 = optJSONArray.optJSONObject(0).optJSONArray("notice_failed_urls");
            if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray2.length(); i++) {
                arrayList.add(optJSONArray2.optString(i));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                AdHttpUtils.getInstance().doGet(((String) arrayList.get(i2)).replaceAll("__PRICE__", (adCacheBean.getPrice() + RandomUtils.getRandomInt(100)) + ""), new HttpCallbackStringListener() { // from class: com.fl.saas.base.cache.AdCacheRepository.1
                    @Override // com.fl.saas.config.http.HttpCallbackStringListener
                    public void onError(Exception exc) {
                    }

                    @Override // com.fl.saas.config.http.HttpCallbackStringListener
                    public void onJump(String str) {
                    }

                    @Override // com.fl.saas.config.http.HttpCallbackStringListener
                    public void onSuccess(String str) {
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long addAdCache(AdCacheBean adCacheBean) {
        SQLiteDatabase writableDatabase;
        if (this.dbHelper == null) {
            return 0L;
        }
        deleteExpireAdCache();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            writableDatabase = this.dbHelper.getWritableDatabase();
        } catch (SQLException unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseHelper.COLUMN_KEY, adCacheBean.getKey());
            contentValues.put(DatabaseHelper.COLUMN_TIME, Long.valueOf(adCacheBean.getTime()));
            contentValues.put(DatabaseHelper.COLUMN_PRICE, Double.valueOf(adCacheBean.getPrice()));
            contentValues.put(DatabaseHelper.COLUMN_VALUE, adCacheBean.getValue());
            writableDatabase.beginTransaction();
            try {
                long insertOrThrow = writableDatabase.insertOrThrow(DatabaseHelper.TABLE_AD_CACHE, null, contentValues);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.close();
                return insertOrThrow;
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException unused2) {
            sQLiteDatabase = writableDatabase;
            if (sQLiteDatabase == null) {
                return -1L;
            }
            sQLiteDatabase.close();
            return -1L;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = writableDatabase;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
    }

    public void deleteAdCache(long j) {
        DatabaseHelper databaseHelper = this.dbHelper;
        if (databaseHelper == null) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = databaseHelper.getWritableDatabase();
            sQLiteDatabase.delete(DatabaseHelper.TABLE_AD_CACHE, "_id = ?", new String[]{String.valueOf(j)});
            sQLiteDatabase.close();
        } catch (SQLException unused) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
    }

    public AdCacheBean getCacheAdContent(String str) {
        List<AdCacheBean> searchAdCaches = searchAdCaches(str);
        if (searchAdCaches == null || searchAdCaches.isEmpty()) {
            return null;
        }
        return searchAdCaches.get(0);
    }
}
