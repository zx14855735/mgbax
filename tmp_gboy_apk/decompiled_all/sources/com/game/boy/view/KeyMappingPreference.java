package com.game.boy.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import androidx.preference.DialogPreference;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.czhj.sdk.common.Constants;
import com.qq.e.comm.adevent.AdEventType;
import com.qq.e.comm.managers.setting.GlobalSetting;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class KeyMappingPreference extends DialogPreference {

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public final Resources f11127DRlcZ9;

    /* renamed from: DUi7mC, reason: collision with root package name */
    public int f11128DUi7mC;

    public KeyMappingPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11127DRlcZ9 = context.getResources();
        this.f9063D9tr6l = getContext().getString(2131886183);
        this.BpkvW3 = 0;
    }

    @Override // androidx.preference.Preference
    public final void B7CMnp(Object obj, boolean z) {
        BmvVmW(z ? AMqCpz(0) : ((Integer) obj).intValue());
    }

    public final void BmvVmW(int i) {
        String string;
        this.f11128DUi7mC = i;
        BChYOn(i);
        Resources resources = this.f11127DRlcZ9;
        if (i == 0) {
            string = resources.getString(2131886410);
        } else if (i == 27) {
            string = "CAMERA";
        } else if (i == 74) {
            string = ";";
        } else if (i == 80) {
            string = "FOCUS";
        } else if (i == 82) {
            string = "MENU";
        } else if (i == 84) {
            string = "SEARCH";
        } else if (i == 4) {
            string = "BACK";
        } else if (i == 5) {
            string = "CALL";
        } else if (i == 66) {
            string = "ENTER";
        } else if (i == 67) {
            string = "DEL";
        } else if (i == 76) {
            string = "/";
        } else if (i != 77) {
            switch (i) {
                case 7:
                    string = Constants.FAIL;
                    break;
                case 8:
                    string = "1";
                    break;
                case 9:
                    string = "2";
                    break;
                case 10:
                    string = "3";
                    break;
                case 11:
                    string = "4";
                    break;
                case 12:
                    string = "5";
                    break;
                case 13:
                    string = "6";
                    break;
                case 14:
                    string = "7";
                    break;
                case 15:
                    string = GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD;
                    break;
                case 16:
                    string = "9";
                    break;
                default:
                    switch (i) {
                        case 19:
                            string = "DPAD Up";
                            break;
                        case 20:
                            string = "DPAD Down";
                            break;
                        case 21:
                            string = "DPAD Left";
                            break;
                        case 22:
                            string = "DPAD Right";
                            break;
                        case 23:
                            string = "DPAD Center";
                            break;
                        case 24:
                            string = "Volume UP";
                            break;
                        case 25:
                            string = "Volume DOWN";
                            break;
                        default:
                            switch (i) {
                                case 29:
                                    string = "A";
                                    break;
                                case 30:
                                    string = "B";
                                    break;
                                case 31:
                                    string = "C";
                                    break;
                                case 32:
                                    string = "D";
                                    break;
                                case 33:
                                    string = "E";
                                    break;
                                case 34:
                                    string = "F";
                                    break;
                                case 35:
                                    string = "G";
                                    break;
                                case 36:
                                    string = "H";
                                    break;
                                case 37:
                                    string = "I";
                                    break;
                                case 38:
                                    string = "J";
                                    break;
                                case 39:
                                    string = "K";
                                    break;
                                case 40:
                                    string = "L";
                                    break;
                                case 41:
                                    string = "M";
                                    break;
                                case 42:
                                    string = "N";
                                    break;
                                case 43:
                                    string = "O";
                                    break;
                                case 44:
                                    string = "P";
                                    break;
                                case 45:
                                    string = "Q";
                                    break;
                                case 46:
                                    string = "R";
                                    break;
                                case 47:
                                    string = "S";
                                    break;
                                case 48:
                                    string = "T";
                                    break;
                                case 49:
                                    string = "U";
                                    break;
                                case 50:
                                    string = "V";
                                    break;
                                case ILivePlayer.LIVE_DATALOADER_RW_TIMEOUT /* 51 */:
                                    string = "W";
                                    break;
                                case 52:
                                    string = "X";
                                    break;
                                case 53:
                                    string = "Y";
                                    break;
                                case 54:
                                    string = "Z";
                                    break;
                                case 55:
                                    string = ",";
                                    break;
                                case 56:
                                    string = ".";
                                    break;
                                case ILivePlayer.LIVE_PLAYER_OPTION_PLAY_URL /* 57 */:
                                    string = "ALT (left)";
                                    break;
                                case 58:
                                    string = "ALT (right)";
                                    break;
                                case 59:
                                    string = "SHIFT (left)";
                                    break;
                                case 60:
                                    string = "SHIFT (right)";
                                    break;
                                case 61:
                                    string = "TAB";
                                    break;
                                case 62:
                                    string = "SPACE";
                                    break;
                                default:
                                    switch (i) {
                                        case 96:
                                            string = "Button A";
                                            break;
                                        case MediaPlayer.MEDIA_PLAYER_OPTION_USE_MEDIA_CODEC_AUDIO /* 97 */:
                                            string = "Button B";
                                            break;
                                        case MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_RESET_SYSTEM_VOLUME /* 98 */:
                                            string = "Button C";
                                            break;
                                        case 99:
                                            string = "Button X";
                                            break;
                                        case 100:
                                            string = "Button Y";
                                            break;
                                        case 101:
                                            string = "Button Z";
                                            break;
                                        case 102:
                                            string = "Button L1";
                                            break;
                                        case 103:
                                            string = "Button R1";
                                            break;
                                        case 104:
                                            string = "Button L2";
                                            break;
                                        case 105:
                                            string = "Button R2";
                                            break;
                                        case 106:
                                            string = "Thumb Left";
                                            break;
                                        case 107:
                                            string = "Thumb Right";
                                            break;
                                        case 108:
                                            string = "Button Start";
                                            break;
                                        case AdEventType.AD_RENDER_SUCCESS /* 109 */:
                                            string = "Button Select";
                                            break;
                                        default:
                                            if (i >= 188 && i <= 203) {
                                                StringBuilder sb = new StringBuilder("Button ");
                                                sb.append(i - 187);
                                                string = sb.toString();
                                                break;
                                            } else {
                                                string = resources.getString(2131886418, Integer.valueOf(i));
                                                break;
                                            }
                                            break;
                                    }
                            }
                    }
            }
        } else {
            string = "@";
        }
        BNL6CD(string);
    }
}
