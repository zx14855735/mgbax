package com.sigmob.sdk.base;

import GnQT2j.A4TApA;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.Database.SQLiteBuider;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.z;
import com.sigmob.sdk.base.db.a;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.WindAdMetaData;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmobRequest;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.utils.q;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.WindAds;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class m {
    private static final HashMap<String, h> b = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private h f13179a;
    private boolean d;
    private String e;
    private int g;
    protected WindAdRequest l;
    protected AdStatus h = AdStatus.AdStatusNone;
    protected int i = 0;
    protected int j = 0;
    protected int k = 0;
    private int c = 0;
    private int f = 0;
    private String m = WindAds.CNY;

    static {
        PUUzb();
    }

    public m(WindAdRequest windAdRequest, boolean z) {
        this.l = windAdRequest;
        windAdRequest.setHalfInterstitial(z);
    }

    private static /* synthetic */ void PUUzb() {
        char[] charArray = "}qs0y\u007fs{0|qg0mv{rr0Tpw\\lwzy{".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 30);
        }
        String str = new String(charArray);
        char[] charArray2 = "}rwpwj".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 30);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private h a(String str) {
        boolean isClosed;
        h hVar = new h();
        Cursor cursor = null;
        try {
            cursor = com.sigmob.sdk.base.db.a.a().getReadableDatabase().rawQuery("select error_code, count(*) as num from adload_event where adslot_id = '" + str + "' group by adslot_id", null);
            a(hVar, cursor);
            if (cursor != null) {
                if (!isClosed) {
                    return hVar;
                }
            }
        } catch (Throwable th) {
            try {
                SigmobLog.e(th.getMessage());
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            } finally {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            }
        }
        return hVar;
    }

    private void b(String str) {
        if (com.sigmob.sdk.base.utils.o.a((CharSequence) str)) {
            return;
        }
        try {
            com.sigmob.sdk.base.db.a.a().getWritableDatabase().delete(com.sigmob.sdk.base.db.a.f, "adslot_id=?", new String[]{str});
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    public abstract void a(WindAdError windAdError);

    public abstract void a(String str, String str2);

    public abstract Map<String, BiddingResponse> b();

    public abstract com.sigmob.sdk.manager.b c();

    public String d() {
        WindAdRequest windAdRequest = this.l;
        if (windAdRequest == null) {
            return null;
        }
        return windAdRequest.getPlacementId();
    }

    public Integer e() {
        WindAdRequest windAdRequest = this.l;
        if (windAdRequest == null) {
            return null;
        }
        return Integer.valueOf(windAdRequest.getAdType());
    }

    public boolean f() {
        String d = d();
        com.sigmob.sdk.manager.b c = c();
        return !com.sigmob.sdk.base.utils.o.a((CharSequence) d) && c != null && this.h == AdStatus.AdStatusReady && c.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean g() {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.m.g():boolean");
    }

    public int getBidFloor() {
        return this.g;
    }

    public String getBid_token() {
        return this.e;
    }

    public String getCurrency() {
        return this.m;
    }

    public abstract String getEcpm();

    public WindAdMetaData getWindAdMetaData() {
        com.sigmob.sdk.manager.b c = c();
        if (c == null) {
            return null;
        }
        BaseAdUnit i = c.i();
        if (i == null) {
            i = c.e();
        }
        return WindAdMetaData.create(i);
    }

    public boolean loadAd() {
        this.d = false;
        this.e = null;
        return false;
    }

    public void sendLossNotificationWithInfo(Map<String, Object> map) {
        String str;
        try {
            Map<String, BiddingResponse> b2 = b();
            if (b2 == null) {
                return;
            }
            Set<String> keySet = b2.keySet();
            if (com.sigmob.sdk.base.utils.e.a(keySet)) {
                return;
            }
            for (String str2 : keySet) {
                BiddingResponse biddingResponse = b2.get(str2);
                if (biddingResponse != null) {
                    String str3 = biddingResponse.lose_url;
                    if (!com.sigmob.sdk.base.utils.o.a((CharSequence) str3)) {
                        if (com.sigmob.sdk.base.utils.e.b(map)) {
                            if (map.get(WindAds.AUCTION_PRICE) != null) {
                                a(SigMacroCommon._PUBLISHERPRICE_, String.valueOf(map.get(WindAds.AUCTION_PRICE)));
                                str3 = str3.replace("__AUCTION_PRICE__", String.valueOf(map.get(WindAds.AUCTION_PRICE)));
                            }
                            if (map.get(WindAds.CURRENCY) != null) {
                                a(SigMacroCommon._CURRENCY_, String.valueOf(map.get(WindAds.CURRENCY)));
                                str = String.valueOf(map.get(WindAds.CURRENCY));
                            } else {
                                a(SigMacroCommon._CURRENCY_, this.m);
                                str = this.m;
                            }
                            str3 = str3.replace("__CURRENCY__", str);
                            if (map.get(WindAds.LOSS_REASON) != null) {
                                str3 = str3.replace("_BIDLOSSCODE_", String.valueOf(map.get(WindAds.LOSS_REASON)));
                            }
                            if (map.get(WindAds.ADN_ID) != null) {
                                str3 = str3.replace("_WINADNID_", String.valueOf(map.get(WindAds.ADN_ID)));
                            }
                        }
                        com.sigmob.sdk.base.network.b.a(str3, PointCategory.LOSE, this.l, str2);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendWinNotificationWithInfo(Map<String, Object> map) {
        String str;
        try {
            Map<String, BiddingResponse> b2 = b();
            if (b2 == null) {
                return;
            }
            Set<String> keySet = b2.keySet();
            if (com.sigmob.sdk.base.utils.e.a(keySet)) {
                return;
            }
            for (String str2 : keySet) {
                BiddingResponse biddingResponse = b2.get(str2);
                if (biddingResponse != null) {
                    String str3 = biddingResponse.win_url;
                    if (!com.sigmob.sdk.base.utils.o.a((CharSequence) str3)) {
                        if (com.sigmob.sdk.base.utils.e.b(map)) {
                            if (map.get(WindAds.AUCTION_PRICE) != null) {
                                a(SigMacroCommon._PUBLISHERPRICE_, String.valueOf(map.get(WindAds.AUCTION_PRICE)));
                                str3 = str3.replace("__AUCTION_PRICE__", String.valueOf(map.get(WindAds.AUCTION_PRICE)));
                            }
                            if (map.get(WindAds.HIGHEST_LOSS_PRICE) != null) {
                                a(SigMacroCommon._HIGHESTLOSSPRICE_, String.valueOf(map.get(WindAds.HIGHEST_LOSS_PRICE)));
                                str3 = str3.replace("__HIGHEST_LOSS_PRICE__", String.valueOf(map.get(WindAds.HIGHEST_LOSS_PRICE)));
                            }
                            if (map.get(WindAds.CURRENCY) != null) {
                                a(SigMacroCommon._CURRENCY_, String.valueOf(map.get(WindAds.CURRENCY)));
                                str = String.valueOf(map.get(WindAds.CURRENCY));
                            } else {
                                a(SigMacroCommon._CURRENCY_, this.m);
                                str = this.m;
                            }
                            str3 = str3.replace("__CURRENCY__", str);
                        }
                        com.sigmob.sdk.base.network.b.a(str3, PointCategory.WIN, this.l, str2);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBidEcpm(int i) {
        a(SigMacroCommon._PUBLISHERPRICE_, String.valueOf(i));
    }

    public void setBidFloor(int i) {
        this.g = i;
    }

    public void setCurrency(String str) {
        this.m = str;
    }

    private void a() {
        this.i = 0;
        b(d());
        this.f13179a.a();
    }

    public boolean loadAd(String str) {
        this.d = true;
        this.e = str;
        SigmobLog.d("loadAd: bidToken = " + str);
        return false;
    }

    public void a(z zVar, String str) {
        ae.a(PointCategory.REQUEST, "init", this.l, (LoadAdRequest) null, new A4TApA(this, str, zVar));
    }

    private void a(h hVar, Cursor cursor) {
        if (cursor == null || !cursor.moveToFirst()) {
            return;
        }
        int i = cursor.getInt(cursor.getColumnIndexOrThrow("error_code"));
        int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("num"));
        do {
            if (i != 0) {
                hVar.f13174a = i2;
            }
            hVar.b += i2;
            switch (i) {
                case 600200:
                case 600201:
                case 600203:
                case 600204:
                    hVar.g = i2;
                    break;
                case 600900:
                    hVar.e = i2;
                    break;
                case 600905:
                    hVar.c = i2;
                    break;
                case 610012:
                    hVar.h = i2;
                    break;
                case 610013:
                    hVar.d = i2;
                    break;
            }
        } while (cursor.moveToNext());
    }

    private void a(final String str, final int i) {
        if (com.sigmob.sdk.base.utils.o.a((CharSequence) str)) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = com.sigmob.sdk.base.db.a.a().getWritableDatabase();
            SQLiteBuider.Insert.Builder builder = new SQLiteBuider.Insert.Builder();
            builder.setTableName(com.sigmob.sdk.base.db.a.f);
            HashMap hashMap = new HashMap();
            hashMap.put("adslot_id", str);
            hashMap.put("error_code", Integer.valueOf(i));
            hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            builder.setColumnValues(hashMap);
            com.sigmob.sdk.base.db.a.a().a(writableDatabase, builder.build(), new a.InterfaceC0448a() { // from class: com.sigmob.sdk.base.m.1
                @Override // com.sigmob.sdk.base.db.a.InterfaceC0448a
                public void a() {
                    SigmobLog.d(str + " insert load error event " + i + " onSuccess: ");
                }

                @Override // com.sigmob.sdk.base.db.a.InterfaceC0448a
                public void a(Throwable th) {
                    SigmobLog.e(str + " insert load error event " + i + " onFailed: ", th);
                }
            });
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, z zVar, Object obj) {
        if (obj instanceof PointEntitySigmobRequest) {
            PointEntitySigmobRequest pointEntitySigmobRequest = (PointEntitySigmobRequest) obj;
            pointEntitySigmobRequest.setLoad_count(String.valueOf(this.f13179a.b));
            pointEntitySigmobRequest.setInvalid_load_count(String.valueOf(this.f13179a.f13174a));
            pointEntitySigmobRequest.setGdpr_filters(String.valueOf(this.f13179a.c));
            pointEntitySigmobRequest.setInterval_filters(String.valueOf(this.f13179a.d));
            pointEntitySigmobRequest.setPldempty_filters(String.valueOf(this.i));
            pointEntitySigmobRequest.setInit_filters(String.valueOf(this.f13179a.e));
            pointEntitySigmobRequest.setLoading_filters(String.valueOf(this.f13179a.h));
            pointEntitySigmobRequest.setProguard_filters(String.valueOf(this.f13179a.g));
            pointEntitySigmobRequest.setAdx_id(null);
            if (com.sigmob.sdk.base.utils.o.b(this.e)) {
                pointEntitySigmobRequest.setBid_token(this.e);
            }
            if (com.sigmob.sdk.base.utils.o.b(str)) {
                pointEntitySigmobRequest.setTrace_id(str);
            }
            Map<String, String> options = pointEntitySigmobRequest.getOptions();
            if (q.b(zVar)) {
                options.put(PointParamKey.FEED_PRE_REQUEST_COUNT, String.valueOf(zVar.f13166a));
                options.put(PointParamKey.FEED_PRE_READY_COUNT, String.valueOf(zVar.b));
            }
            options.put(PointParamKey.IS_MINOR, i.a().d() ? Constants.FAIL : "1");
            options.put(PointParamKey.IS_UNPERSONALIZED, i.a().e() ? Constants.FAIL : "1");
            options.put(PointParamKey.PERSONALIZED_FILTERS, String.valueOf(this.f13179a.f));
            options.put(PointParamKey.REQUEST_SCENE_TYPE, String.valueOf(j.NormalRequest.a()));
            pointEntitySigmobRequest.setOptions(options);
        }
        a();
    }

    public void a(boolean z) {
        this.d = z;
    }
}
