package io.dcloud.openapi.core.util;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import io.dcloud.base.R;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a.aaaaaaaa;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AOLErrorUtil {
    public static String getErrorMsg(int i) {
        if (aaaaaaaa.aaaaaaac() == null || aaaaaaaa.aaaaaaac().aaaaaaao() == null) {
            return "zh".equalsIgnoreCase(Locale.getDefault().getCountry()) ? "广告未初始化或者初始化信息为空" : "Please init first";
        }
        Context aaaaaaao = aaaaaaaa.aaaaaaac().aaaaaaao();
        if (i == -5100) {
            return aaaaaaao.getString(R.string.dcloud_ad_error_code_5100);
        }
        switch (i) {
            case -5022:
                break;
            case -5021:
                break;
            case -5020:
                break;
            case -5019:
                break;
            case -5018:
                break;
            case -5017:
                break;
            case -5016:
                break;
            case -5015:
                break;
            case -5014:
                break;
            case -5013:
                break;
            case -5012:
                break;
            case -5011:
                break;
            default:
                switch (i) {
                    case -5008:
                        break;
                    case -5007:
                        break;
                    case -5006:
                        break;
                    case -5005:
                        break;
                    case -5004:
                        break;
                    case -5003:
                        break;
                    case -5002:
                        break;
                    case -5001:
                        break;
                    case AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite /* -5000 */:
                        break;
                    default:
                        if (i != -4002) {
                            if (i != -4001) {
                                if (i == -603) {
                                    break;
                                } else {
                                    switch (i) {
                                        case 200000:
                                            break;
                                        case 200001:
                                            break;
                                        case 200002:
                                            break;
                                        default:
                                            switch (i) {
                                            }
                                    }
                                }
                            }
                        }
                        break;
                }
        }
        return "";
    }
}
