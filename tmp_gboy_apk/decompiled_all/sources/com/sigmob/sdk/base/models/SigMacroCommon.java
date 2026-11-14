package com.sigmob.sdk.base.models;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.track.BaseMacroCommon;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.TouchLocation;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.b;
import com.sigmob.sdk.base.utils.o;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Random;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class SigMacroCommon extends BaseMacroCommon {
    public static final String DEFAULT_XY = "-999";
    public static final String _ADSCENEID_ = "_ADSCENEID_";
    public static final String _ADSCENE_ = "_ADSCENE_";
    public static final String _BEGINTIME_ = "_BEGINTIME_";
    public static final String _BEHAVIOR_ = "_BEHAVIOR_";
    public static final String _CLICKAREA_ = "_CLICKAREA_";
    public static final String _CLICKID_ = "_CLICKID_";
    public static final String _CLICKSCENE_ = "_CLICKSCENE_";
    public static final String _COMPLETED_ = "_COMPLETED_";
    public static final String _CURRENCY_ = "_CURRENCY_";
    public static final String _DOWNTS_ = "_DOWNTS_";
    public static final String _DOWNX_ = "_DOWNX_";
    public static final String _DOWNY_ = "_DOWNY_";
    public static final String _ENDTIME_ = "_ENDTIME_";
    public static final String _FINALCLICK_ = "_FINALCLICK_";
    public static final String _HEIGHT_ = "_HEIGHT_";
    public static final String _HIGHESTLOSSPRICE_ = "_HIGHESTLOSSPRICE_";
    public static final String _ISNC_ = "_ISNC_";
    public static final String _IS_TRUNCATION_ = "_ISTRUNCATION_";
    public static final String _PLAYFIRSTFRAME_ = "_PLAYFIRSTFRAME_";
    public static final String _PLAYLASTFRAME_ = "_PLAYLASTFRAME_";
    public static final String _PROGRESS_ = "_PROGRESS_";
    public static final String _PUBLISHERPRICE_ = "_PUBLISHERPRICE_";
    public static final String _SCENE_ = "_SCENE_";
    public static final String _SETCLOSETIME_ = "_SETCLOSETIME_";
    public static final String _SHOWSKIPTIME_ = "_SHOWSKIPTIME_";
    public static final String _SLD_ = "_SLD_";
    public static final String _SLOTHEIGHT_ = "_SLOTHEIGHT_";
    public static final String _SLOTWIDTH_ = "_SLOTWIDTH_";
    public static final String _STATUS_ = "_STATUS_";
    public static final String _TEMPLATE_ = "_TEMPLATE_";
    public static final String _TYPE_ = "_TYPE_";
    public static final String _UPTS_ = "_UPTS_";
    public static final String _UPX_ = "_UPX_";
    public static final String _UPY_ = "_UPY_";
    public static final String _VIDEOTIME_ = "_VIDEOTIME_";
    public static final String _VMD5_ = "_VMD5_";
    public static final String _VURL_ = "_VURL_";
    public static final String _WIDTH_ = "_WIDTH_";
    private static final long serialVersionUID = 1;
    private static final long initialUptimeMillis = SystemClock.uptimeMillis();
    private static final long initialCurrentTimeMillis = System.currentTimeMillis();

    static {
        AQloFH();
    }

    private static /* synthetic */ void AQloFH() {
        char[] charArray = "^RP\u0013Z\\PX\u0013_RD\u0013NUXQQ\u0013wST\u007fOTYZX".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '=');
        }
        String str = new String(charArray);
        char[] charArray2 = "^QTSTI".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '=');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static long convertUptimeMillisToCurrentTimeMillis(long j) {
        return initialCurrentTimeMillis + (j - initialUptimeMillis);
    }

    private static String getMacroValue(String str) {
        char c;
        try {
            switch (str.hashCode()) {
                case -1590308376:
                    if (str.equals(_BEGINTIME_)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -1494891674:
                    if (str.equals(_TYPE_)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -662306149:
                    if (str.equals(_SLOTHEIGHT_)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -415971623:
                    if (str.equals(_HEIGHT_)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 853731986:
                    if (str.equals(_SCENE_)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 891331278:
                    if (str.equals(_BEHAVIOR_)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 973765784:
                    if (str.equals(_WIDTH_)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 1179083118:
                    if (str.equals(_STATUS_)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 2074198166:
                    if (str.equals(_SLOTWIDTH_)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    return "1";
                case 1:
                case 2:
                    return Constants.FAIL;
                case 3:
                    return "2";
                case 4:
                    return Constants.FAIL;
                case 5:
                case 6:
                    return String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealWidthDip());
                case 7:
                case '\b':
                    return String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealHeightDip());
                default:
                    return "unFind";
            }
        } catch (Throwable unused) {
            return "unFind";
        }
    }

    public String getCoordinate() {
        String marcoKey = getMarcoKey(_DOWNX_);
        String marcoKey2 = getMarcoKey(_DOWNY_);
        String marcoKey3 = getMarcoKey(_UPX_);
        String marcoKey4 = getMarcoKey(_UPY_);
        StringBuilder sb = new StringBuilder();
        sb.append(marcoKey);
        sb.append(",");
        sb.append(marcoKey2);
        sb.append(",");
        sb.append(marcoKey3);
        return CtFAbx.B25kr6(sb, ",", marcoKey4);
    }

    @Override // com.czhj.sdk.common.track.BaseMacroCommon
    public String replaceWithDefault(String str) {
        String replaceWithDefault = super.replaceWithDefault(str);
        SigmobLog.d("macroProcess() called with:[" + str + "][" + replaceWithDefault + "]");
        if (o.b(replaceWithDefault) && !replaceWithDefault.equals("unFind")) {
            return replaceWithDefault;
        }
        try {
            String macroValue = getMacroValue(str);
            SigmobLog.d("macroProcess() called with: [" + str + "][" + macroValue + "]");
            if (!o.b(macroValue)) {
                return null;
            }
            if (macroValue.equals("unFind")) {
                return null;
            }
            return macroValue;
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return null;
        }
    }

    public void updateClickMarco(MotionEvent motionEvent, MotionEvent motionEvent2, boolean z) {
        if (motionEvent == null) {
            motionEvent = motionEvent2;
        }
        Context e = b.e();
        float rawX = z ? motionEvent.getRawX() : motionEvent.getX();
        float rawY = z ? motionEvent.getRawY() : motionEvent.getY();
        float rawX2 = z ? motionEvent2.getRawX() : motionEvent2.getX();
        float rawY2 = z ? motionEvent2.getRawY() : motionEvent2.getY();
        long eventTime = motionEvent.getEventTime();
        long eventTime2 = motionEvent2.getEventTime();
        addMarcoKey(_DOWNX_, String.valueOf(Dips.pixelsToIntDips(rawX, e)));
        addMarcoKey(_DOWNY_, String.valueOf(Dips.pixelsToIntDips(rawY, e)));
        addMarcoKey(_UPX_, String.valueOf(Dips.pixelsToIntDips(rawX2, e)));
        addMarcoKey(_UPY_, String.valueOf(Dips.pixelsToIntDips(rawY2, e)));
        addMarcoKey(_DOWNTS_, String.valueOf(convertUptimeMillisToCurrentTimeMillis(eventTime)));
        addMarcoKey(_UPTS_, String.valueOf(convertUptimeMillisToCurrentTimeMillis(eventTime2)));
        addMarcoKey(_SLD_, Constants.FAIL);
    }

    public void updateClickMarco(TouchLocation touchLocation, TouchLocation touchLocation2) {
        if (touchLocation == null && touchLocation2 == null) {
            return;
        }
        Context e = b.e();
        TouchLocation touchLocation3 = touchLocation == null ? touchLocation2 : touchLocation;
        if (touchLocation2 != null) {
            touchLocation = touchLocation2;
        }
        updateClickMarco(String.valueOf(Dips.pixelsToIntDips(touchLocation3.getX(), e)), String.valueOf(Dips.pixelsToIntDips(touchLocation3.getY(), e)), String.valueOf(Dips.pixelsToIntDips(touchLocation.getX(), e)), String.valueOf(Dips.pixelsToIntDips(touchLocation.getY(), e)));
        addMarcoKey(_SLD_, Constants.FAIL);
    }

    public void updateClickMarco(String str, String str2, String str3, String str4) {
        addMarcoKey(_DOWNX_, str);
        addMarcoKey(_DOWNY_, str2);
        addMarcoKey(_UPX_, str3);
        addMarcoKey(_UPY_, str4);
        if (str.equals(DEFAULT_XY)) {
            return;
        }
        String marcoKey = getMarcoKey(_DOWNTS_);
        String marcoKey2 = getMarcoKey(_UPTS_);
        if (o.b(marcoKey) && o.b(marcoKey2)) {
            return;
        }
        Random random = new Random();
        addMarcoKey(_DOWNTS_, String.valueOf(System.currentTimeMillis()));
        addMarcoKey(_UPTS_, String.valueOf(System.currentTimeMillis() + random.nextInt(50)));
    }

    public static String getCoordinate(MotionEvent motionEvent, MotionEvent motionEvent2, boolean z) {
        Context e = b.e();
        return String.format(Locale.getDefault(), "%d,%d,%d,%d", Integer.valueOf(Dips.pixelsToIntDips(z ? motionEvent.getRawX() : motionEvent.getX(), e)), Integer.valueOf(Dips.pixelsToIntDips(z ? motionEvent.getRawY() : motionEvent.getY(), e)), Integer.valueOf(Dips.pixelsToIntDips(z ? motionEvent2.getRawX() : motionEvent2.getX(), e)), Integer.valueOf(Dips.pixelsToIntDips(z ? motionEvent2.getRawY() : motionEvent2.getY(), e)));
    }
}
