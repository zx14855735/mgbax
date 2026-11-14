package com.czhj.sdk.common.track;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a;
import com.czhj.sdk.common.Database.DBOperator;
import com.czhj.sdk.common.Database.SQLiteBuider;
import com.czhj.sdk.common.Database.SQLiteLisenter;
import com.czhj.sdk.common.Database.SQLiteTrackHelper;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AdTracker implements Serializable {
    private static final long serialVersionUID = 1;
    private String extInfo;
    private boolean mCalled;
    private final String mEvent;
    private Long mId;
    private final MessageType mMessageType;
    private final String mRequest_id;
    private String mSource = "native";
    private String mUrl;
    private Integer retryCount;
    private Integer retryNum;
    private Long timestamp;

    /* renamed from: com.czhj.sdk.common.track.AdTracker$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$czhj$sdk$common$track$AdTracker$MessageType;

        static {
            int[] iArr = new int[MessageType.values().length];
            $SwitchMap$com$czhj$sdk$common$track$AdTracker$MessageType = iArr;
            try {
                iArr[MessageType.QUARTILE_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$czhj$sdk$common$track$AdTracker$MessageType[MessageType.TOBID_TRACKING_URL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$czhj$sdk$common$track$AdTracker$MessageType[MessageType.TRACKING_URL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum MessageType {
        TRACKING_URL,
        QUARTILE_EVENT,
        TOBID_TRACKING_URL;

        static {
            HzRqeF();
        }

        private static /* synthetic */ void HzRqeF() {
            char[] charArray = "#/-n'!-%n\"/9n3(%,,n\n.)\u00022)$'%".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '@');
            }
            String str = new String(charArray);
            char[] charArray2 = "#,).)4".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '@');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public AdTracker(MessageType messageType, String str, String str2, String str3) {
        this.mRequest_id = str3;
        this.mMessageType = messageType;
        this.mUrl = str;
        this.mEvent = str2;
    }

    public static void cleanExpiredAdTracker(long j) {
        try {
            DBOperator.getInstance().delete(SQLiteTrackHelper.getInstance().getWritableDatabase(), "tracks", "timestamp < " + (System.currentTimeMillis() - j), new SQLiteLisenter() { // from class: com.czhj.sdk.common.track.AdTracker.1
                @Override // com.czhj.sdk.common.Database.SQLiteLisenter
                public void onFailed(Error error) {
                    SigmobLog.e(error.getMessage());
                }

                @Override // com.czhj.sdk.common.Database.SQLiteLisenter
                public void onSuccess(List list) {
                }
            });
        } catch (Throwable th) {
            SigmobLog.e("cleanExpiredAdTracker error", th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.Long] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void cleanLimitAdTracker(long r8) {
        /*
            java.lang.String r0 = "id <'"
            java.lang.String r1 = "select * from tracks order by id desc limit "
            r2 = 0
            com.czhj.sdk.common.Database.SQLiteTrackHelper r3 = com.czhj.sdk.common.Database.SQLiteTrackHelper.getInstance()     // Catch: java.lang.Throwable -> L86
            android.database.sqlite.SQLiteDatabase r3 = r3.getReadableDatabase()     // Catch: java.lang.Throwable -> L86
            java.lang.String r4 = "select * from tracks"
            android.database.Cursor r4 = r3.rawQuery(r4, r2)     // Catch: java.lang.Throwable -> L86
            if (r4 == 0) goto L22
            int r5 = r4.getCount()     // Catch: java.lang.Throwable -> L1f
            long r5 = (long) r5     // Catch: java.lang.Throwable -> L1f
            r4.close()     // Catch: java.lang.Throwable -> L1f
            r4 = r2
            goto L24
        L1f:
            r8 = move-exception
            r2 = r4
            goto L87
        L22:
            r5 = 0
        L24:
            int r7 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r7 <= 0) goto L56
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1f
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L1f
            r5.append(r8)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r8 = r5.toString()     // Catch: java.lang.Throwable -> L1f
            android.database.Cursor r8 = r3.rawQuery(r8, r2)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r9 = "id"
            int r9 = r8.getColumnIndex(r9)     // Catch: java.lang.Throwable -> L52
            boolean r1 = r8.moveToLast()     // Catch: java.lang.Throwable -> L52
            if (r1 == 0) goto L57
            long r3 = r8.getLong(r9)     // Catch: java.lang.Throwable -> L52
            java.lang.Long r9 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> L52
            r8.close()     // Catch: java.lang.Throwable -> L52
            r8 = r2
            r2 = r9
            goto L57
        L52:
            r9 = move-exception
            r2 = r8
            r8 = r9
            goto L87
        L56:
            r8 = r4
        L57:
            if (r2 == 0) goto L80
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52
            r9.<init>(r0)     // Catch: java.lang.Throwable -> L52
            r9.append(r2)     // Catch: java.lang.Throwable -> L52
            java.lang.String r0 = "'"
            r9.append(r0)     // Catch: java.lang.Throwable -> L52
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L52
            com.czhj.sdk.common.Database.DBOperator r0 = com.czhj.sdk.common.Database.DBOperator.getInstance()     // Catch: java.lang.Throwable -> L52
            com.czhj.sdk.common.Database.SQLiteTrackHelper r1 = com.czhj.sdk.common.Database.SQLiteTrackHelper.getInstance()     // Catch: java.lang.Throwable -> L52
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L52
            java.lang.String r2 = "tracks"
            com.czhj.sdk.common.track.AdTracker$2 r3 = new com.czhj.sdk.common.track.AdTracker$2     // Catch: java.lang.Throwable -> L52
            r3.<init>()     // Catch: java.lang.Throwable -> L52
            r0.delete(r1, r2, r9, r3)     // Catch: java.lang.Throwable -> L52
        L80:
            if (r8 == 0) goto L91
            r8.close()
            return
        L86:
            r8 = move-exception
        L87:
            java.lang.String r9 = "cleanLimitAdTracker "
            com.czhj.sdk.logger.SigmobLog.e(r9, r8)     // Catch: java.lang.Throwable -> L92
            if (r2 == 0) goto L91
            r2.close()
        L91:
            return
        L92:
            r8 = move-exception
            if (r2 == 0) goto L98
            r2.close()
        L98:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.sdk.common.track.AdTracker.cleanLimitAdTracker(long):void");
    }

    public static SQLiteBuider.CreateTable createTable() {
        SQLiteBuider.CreateTable.Builder builder = new SQLiteBuider.CreateTable.Builder();
        builder.setTableName("tracks");
        builder.setPrimaryKey(f.f13353a, "long");
        builder.autoincrement(true);
        HashMap hashMap = new HashMap();
        hashMap.put("url", a.b);
        hashMap.put("event", a.b);
        hashMap.put(PointParamKey.REQUEST_ID, a.b);
        hashMap.put("timestamp", "long");
        hashMap.put(n.l, a.b);
        hashMap.put("retryNum", IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
        hashMap.put("extInfo", a.b);
        hashMap.put("messageType", IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
        builder.setColumns(hashMap);
        return builder.build();
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x0140, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x013d, code lost:
    
        if (r3 == null) goto L74;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0132 A[EDGE_INSN: B:56:0x0132->B:89:0x0132 BREAK  A[LOOP:0: B:9:0x0070->B:42:0x00f3], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<com.czhj.sdk.common.track.AdTracker> getAdTrackerFromDB(int r24, long r25) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.sdk.common.track.AdTracker.getAdTrackerFromDB(int, long):java.util.List");
    }

    private void setId(Long l) {
        this.mId = l;
    }

    private void setRetryCount(int i) {
        this.retryCount = Integer.valueOf(i);
    }

    public void deleteDB() {
        if (this.mId == null) {
            return;
        }
        try {
            DBOperator.getInstance().delete(SQLiteTrackHelper.getInstance().getWritableDatabase(), "tracks", "id ='" + this.mId + "'", new SQLiteLisenter() { // from class: com.czhj.sdk.common.track.AdTracker.4
                @Override // com.czhj.sdk.common.Database.SQLiteLisenter
                public void onFailed(Error error) {
                    SigmobLog.e(error.getMessage());
                }

                @Override // com.czhj.sdk.common.Database.SQLiteLisenter
                public void onSuccess(List list) {
                    SigmobLog.d("delete id " + AdTracker.this.mId);
                }
            });
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    public String getEvent() {
        return this.mEvent;
    }

    public String getExtInfo() {
        return this.extInfo;
    }

    public Long getId() {
        return this.mId;
    }

    public MessageType getMessageType() {
        return this.mMessageType;
    }

    public String getRequest_id() {
        return this.mRequest_id;
    }

    public int getRetryCount() {
        return this.retryCount.intValue();
    }

    public Integer getRetryNum() {
        Integer num = this.retryNum;
        if (num == null) {
            return 0;
        }
        return num;
    }

    public String getSource() {
        return this.mSource;
    }

    public long getTimestamp() {
        Long l = this.timestamp;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void insertToDB(final SQLiteTrackHelper.ExecCallBack execCallBack) {
        try {
            SQLiteBuider.Insert.Builder builder = new SQLiteBuider.Insert.Builder();
            builder.setTableName("tracks");
            HashMap hashMap = new HashMap();
            int i = AnonymousClass5.$SwitchMap$com$czhj$sdk$common$track$AdTracker$MessageType[this.mMessageType.ordinal()];
            int i2 = 1;
            if (i != 1) {
                i2 = 2;
                if (i != 2) {
                    i2 = 0;
                }
            }
            hashMap.put("url", this.mUrl);
            hashMap.put(PointParamKey.REQUEST_ID, this.mRequest_id);
            hashMap.put("event", this.mEvent);
            hashMap.put(n.l, this.mSource);
            hashMap.put("retryNum", this.retryCount);
            hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("extInfo", this.extInfo);
            hashMap.put("messageType", Integer.valueOf(i2));
            builder.setColumnValues(hashMap);
            SQLiteTrackHelper.getInstance();
            SQLiteTrackHelper.insert(SQLiteTrackHelper.getInstance().getWritableDatabase(), builder.build(), new SQLiteTrackHelper.ExecCallBack() { // from class: com.czhj.sdk.common.track.AdTracker.3
                @Override // com.czhj.sdk.common.Database.SQLiteTrackHelper.ExecCallBack
                public void onFailed(Throwable th) {
                    SQLiteTrackHelper.ExecCallBack execCallBack2 = execCallBack;
                    if (execCallBack2 != null) {
                        execCallBack2.onFailed(th);
                    }
                    SigmobLog.e(th.getMessage());
                }

                @Override // com.czhj.sdk.common.Database.SQLiteTrackHelper.ExecCallBack
                public void onSuccess() {
                    SigmobLog.d("event: " + AdTracker.this.mEvent + " url " + AdTracker.this.mUrl + " mRequest_id: " + AdTracker.this.mRequest_id + " insert success! ");
                    SQLiteTrackHelper.ExecCallBack execCallBack2 = execCallBack;
                    if (execCallBack2 != null) {
                        execCallBack2.onSuccess();
                    }
                }
            });
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    public boolean isTracked() {
        return this.mCalled;
    }

    public void setExtInfo(String str) {
        this.extInfo = str;
    }

    public void setRetryCountInc() {
        this.retryCount = Integer.valueOf(this.retryCount.intValue() + 1);
    }

    public void setRetryNum(Integer num) {
        this.retryNum = num;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void setTimestamp(Long l) {
        this.timestamp = l;
    }

    public void setTracked() {
        this.mCalled = true;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public void updateToDB() {
        try {
            SQLiteBuider.Update.Builder builder = new SQLiteBuider.Update.Builder();
            builder.setTableName("tracks");
            builder.setWhere(" where id=" + this.mId.toString());
            HashMap hashMap = new HashMap();
            hashMap.put("retryNum", this.retryCount);
            builder.setColumnValues(hashMap);
            SQLiteTrackHelper.getInstance().transactionWriteExecSQL(SQLiteTrackHelper.getInstance().getWritableDatabase(), builder.build().getSql(), null);
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }
}
