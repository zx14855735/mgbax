package com.bytedance.embedapplog;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class s extends n {
    private final Context kd;

    public s(Context context) {
        super(true, true);
        this.kd = context;
    }

    @Override // com.bytedance.embedapplog.n
    public boolean xj(JSONObject jSONObject) {
        aq.xj(jSONObject, MediaFormat.KEY_LANGUAGE, this.kd.getResources().getConfiguration().locale.getLanguage());
        int rawOffset = TimeZone.getDefault().getRawOffset() / BaseConstants.Time.HOUR;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            rawOffset = 12;
        }
        jSONObject.put("timezone", rawOffset);
        aq.xj(jSONObject, "region", Locale.getDefault().getCountry());
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        aq.xj(jSONObject, "tz_name", timeZone.getID());
        jSONObject.put("tz_offset", timeZone.getOffset(System.currentTimeMillis() / 1000));
        return true;
    }
}
