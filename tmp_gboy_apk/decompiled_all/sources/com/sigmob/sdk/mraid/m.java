package com.sigmob.sdk.mraid;

import ADYaiT.CtFAbx;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.C;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.mta.PointCategory;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13479a = "vnd.android.cursor.item/event";
    private static final int b = 31;
    private static final String[] c = {"yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ"};

    public interface a {
        void onFailure(f fVar);
    }

    public static class b implements MediaScannerConnection.MediaScannerConnectionClient {

        /* renamed from: a, reason: collision with root package name */
        private final String f13480a;
        private final String b;
        private MediaScannerConnection c;

        private b(String str, String str2) {
            this.f13480a = str;
            this.b = str2;
        }

        private void a(MediaScannerConnection mediaScannerConnection) {
            this.c = mediaScannerConnection;
        }

        @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
        public void onMediaScannerConnected() {
            MediaScannerConnection mediaScannerConnection = this.c;
            if (mediaScannerConnection != null) {
                mediaScannerConnection.scanFile(this.f13480a, this.b);
            }
        }

        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public void onScanCompleted(String str, Uri uri) {
            MediaScannerConnection mediaScannerConnection = this.c;
            if (mediaScannerConnection != null) {
                mediaScannerConnection.disconnect();
            }
        }
    }

    static {
        gwgs();
    }

    private String a(int i) {
        switch (i) {
            case 0:
                return "SU";
            case 1:
                return "MO";
            case 2:
                return "TU";
            case 3:
                return "WE";
            case 4:
                return "TH";
            case 5:
                return "FR";
            case 6:
                return "SA";
            default:
                throw new IllegalArgumentException(CtFAbx.ARc23Z(i, "invalid day of week "));
        }
    }

    private String b(int i) {
        if (i == 0 || i < -31 || i > 31) {
            throw new IllegalArgumentException(CtFAbx.ARc23Z(i, "invalid day of month "));
        }
        return CtFAbx.ARc23Z(i, "");
    }

    private String c(String str) {
        StringBuilder sb = new StringBuilder();
        boolean[] zArr = new boolean[63];
        String[] split = str.split(",");
        for (String str2 : split) {
            int parseInt = Integer.parseInt(str2);
            int i = parseInt + 31;
            if (!zArr[i]) {
                sb.append(b(parseInt) + ",");
                zArr[i] = true;
            }
        }
        if (split.length == 0) {
            throw new IllegalArgumentException("must have at least 1 day of the month if specifying repeating weekly");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static boolean d(Context context) {
        return false;
    }

    private static /* synthetic */ void gwgs() {
        char[] charArray = "[WU\u0016_YU]\u0016ZWA\u0016KP]TT\u0016rVQzJQ\\_]".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '8');
        }
        String str = new String(charArray);
        char[] charArray2 = "[TQVQL".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '8');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean c(Context context) {
        return false;
    }

    private Date a(String str) {
        Date date = null;
        for (String str2 : c) {
            try {
                date = new SimpleDateFormat(str2, Locale.US).parse(str);
            } catch (ParseException unused) {
            }
            if (date != null) {
                break;
            }
        }
        return date;
    }

    private Map<String, Object> a(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (!map.containsKey("description") || !map.containsKey("start")) {
            throw new IllegalArgumentException("Missing start and description fields");
        }
        hashMap.put("title", map.get("description"));
        if (!map.containsKey("start") || map.get("start") == null) {
            throw new IllegalArgumentException("Invalid calendar event: start is null.");
        }
        Date a2 = a(map.get("start"));
        if (a2 == null) {
            throw new IllegalArgumentException("Invalid calendar event: start time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
        }
        hashMap.put("beginTime", Long.valueOf(a2.getTime()));
        if (map.containsKey(PointCategory.END) && map.get(PointCategory.END) != null) {
            Date a3 = a(map.get(PointCategory.END));
            if (a3 == null) {
                throw new IllegalArgumentException("Invalid calendar event: end time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
            }
            hashMap.put("endTime", Long.valueOf(a3.getTime()));
        }
        if (map.containsKey("location")) {
            hashMap.put("eventLocation", map.get("location"));
        }
        if (map.containsKey("summary")) {
            hashMap.put("description", map.get("summary"));
        }
        if (map.containsKey("transparency")) {
            hashMap.put("availability", Integer.valueOf(map.get("transparency").equals("transparent") ? 1 : 0));
        }
        hashMap.put("rrule", b(map));
        return hashMap;
    }

    private String b(String str) {
        StringBuilder sb = new StringBuilder();
        boolean[] zArr = new boolean[7];
        String[] split = str.split(",");
        for (String str2 : split) {
            int parseInt = Integer.parseInt(str2);
            if (parseInt == 7) {
                parseInt = 0;
            }
            if (!zArr[parseInt]) {
                sb.append(a(parseInt) + ",");
                zArr[parseInt] = true;
            }
        }
        if (split.length == 0) {
            throw new IllegalArgumentException("must have at least 1 day of the week if specifying repeating weekly");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public void a(Context context, String str, a aVar) {
        if (c(context)) {
            return;
        }
        SigmobLog.e("Error downloading file - the device does not have an SD card mounted, or the SigmobAndroid permission is not granted.");
        throw new f("Error downloading file  - the device does not have an SD card mounted, or the SigmobAndroid permission is not granted.");
    }

    private String b(Map<String, String> map) {
        String c2;
        StringBuilder sb;
        String sb2;
        StringBuilder sb3 = new StringBuilder();
        if (map.containsKey("frequency")) {
            String str = map.get("frequency");
            int parseInt = map.containsKey("interval") ? Integer.parseInt(map.get("interval")) : -1;
            if ("daily".equals(str)) {
                sb3.append("FREQ=DAILY;");
                if (parseInt != -1) {
                    sb2 = "INTERVAL=" + parseInt + ";";
                    sb3.append(sb2);
                }
            } else {
                if ("weekly".equals(str)) {
                    sb3.append("FREQ=WEEKLY;");
                    if (parseInt != -1) {
                        sb3.append("INTERVAL=" + parseInt + ";");
                    }
                    if (map.containsKey("daysInWeek")) {
                        c2 = b(map.get("daysInWeek"));
                        if (c2 == null) {
                            throw new IllegalArgumentException("invalid ");
                        }
                        sb = new StringBuilder("BYDAY=");
                        sb.append(c2);
                        sb.append(";");
                        sb2 = sb.toString();
                    }
                } else {
                    if (!"monthly".equals(str)) {
                        throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
                    }
                    sb3.append("FREQ=MONTHLY;");
                    if (parseInt != -1) {
                        sb3.append("INTERVAL=" + parseInt + ";");
                    }
                    if (map.containsKey("daysInMonth")) {
                        c2 = c(map.get("daysInMonth"));
                        if (c2 == null) {
                            throw new IllegalArgumentException();
                        }
                        sb = new StringBuilder("BYMONTHDAY=");
                        sb.append(c2);
                        sb.append(";");
                        sb2 = sb.toString();
                    }
                }
                sb3.append(sb2);
            }
        }
        return sb3.toString();
    }

    public void a(Context context, Map<String, String> map) {
        if (!d(context)) {
            SigmobLog.e("unsupported action createCalendarEvent for devices pre-ICS");
            throw new f("Action is unsupported on this device (need SigmobAndroid version Ice Cream Sandwich or above)");
        }
        try {
            Map<String, Object> a2 = a(map);
            Intent type = new Intent("android.intent.action.INSERT").setType(f13479a);
            for (String str : a2.keySet()) {
                Object obj = a2.get(str);
                if (obj instanceof Long) {
                    type.putExtra(str, ((Long) obj).longValue());
                } else if (obj instanceof Integer) {
                    type.putExtra(str, ((Integer) obj).intValue());
                } else {
                    type.putExtra(str, (String) obj);
                }
            }
            type.setFlags(C.ENCODING_PCM_MU_LAW);
            context.startActivity(type);
        } catch (ActivityNotFoundException unused) {
            SigmobLog.e("no calendar app installed");
            throw new f("Action is unsupported on this device - no calendar app installed");
        } catch (IllegalArgumentException e) {
            SigmobLog.e("create calendar: invalid parameters " + e.getMessage());
            throw new f(e);
        } catch (Exception e2) {
            SigmobLog.e("could not create calendar event");
            throw new f(e2);
        }
    }

    public boolean a(Activity activity, View view) {
        return false;
    }

    public boolean b(Context context) {
        return false;
    }

    public boolean a(Context context) {
        return false;
    }
}
