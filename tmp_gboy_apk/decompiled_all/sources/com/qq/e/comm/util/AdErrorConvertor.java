package com.qq.e.comm.util;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.constants.ErrorCode;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AdErrorConvertor {
    public static AdError formatErrorCode(int i) {
        if (i == 4014) {
            return new AdError(ErrorCode.AD_DATA_NOT_READY, "广告未成功返回或广告无效时，启动了广告展示，请在广告返回后再进行展示广告的操作。具体方法为，请在show之前，使用isValid判断广告是否有效，当结果为true时再去调用show方法。");
        }
        if (i == 4015) {
            return new AdError(ErrorCode.AD_REPLAY, "同一条广告不允许多次展示，请再次拉取后展示。");
        }
        if (i == 5018) {
            return new AdError(ErrorCode.AD_POS_ID_BLOCKED, "当前请求所使用的广告位已被下线，请至开发者平台流量合作板块，检查广告位是否被关闭、冻结或者已被删除。");
        }
        if (i == 5019) {
            return new AdError(ErrorCode.AD_APP_ID_BLOCKED, "appid被封，请至平台流量合作板块，检查appid的状态。");
        }
        if (i == 5021) {
            return new AdError(ErrorCode.AD_TYPE_DEPRECATED, "该类型广告已废弃，请使用其他类型的广告。");
        }
        if (i == 5022) {
            return new AdError(ErrorCode.EXPRESS_RENDER_FAIL, "广告模板渲染失败。");
        }
        switch (i) {
            case 2001:
                return new AdError(2001, "可能由于SDK版本较低，或系统应用不支持插件导致，可以将SDK升级至最新版本。如在进行通路测试或者仍未解决，请至反馈中心提交工单联系技术支持处理。");
            case 2002:
                return new AdError(2002, "内部错误。");
            case 2003:
                return new AdError(2003, "SDK未初始化。");
            default:
                switch (i) {
                    case 3001:
                    case 3004:
                    case 3005:
                        return new AdError(3001, "网络问题导致，请开发者检查下是否有连接代理或者网络环境不佳，建议使用稳定的4G、5G网络或者WiFi，确认网络状态后重试。");
                    case 3002:
                        return new AdError(3002, "网络超时。");
                    case 3003:
                        return new AdError(3003, "网络不可用。");
                    default:
                        switch (i) {
                            case 4001:
                                return new AdError(4001, "传入的参数有错误。");
                            case 4002:
                                return new AdError(4002, "Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予。");
                            case 4003:
                                return new AdError(4003, "广告位错误。");
                            case 4004:
                                return new AdError(4004, "开屏场景的广告容器不可见，请将广告容器设置为可见，并及时移除上次拉取广告的view避免容器被遮挡；如是开屏全屏广告，请确保调用了fetchFullScreenAdOnly和showFullScreenAd接口。如果仍未解决，请至反馈中心提交工单联系技术支持处理。");
                            case 4005:
                                return new AdError(4005, "广告容器尺寸错误。");
                            case 4006:
                                return new AdError(4006, "原生广告接口调用顺序错误，调用点击接口前未调用曝光接口。");
                            case 4007:
                                return new AdError(4007, "当前广告形态不支持模拟器，或开屏不支持Pad，建议使用真机、手机进行测试，如在进行通路测试或者仍未解决，请至反馈中心提交工单联系技术支持处理。");
                            case 4008:
                                return new AdError(4008, "设备方向不适合展示广告。");
                            case ErrorCode.SKIP_VIEW_SIZE_ERROR /* 4009 */:
                                return new AdError(ErrorCode.SKIP_VIEW_SIZE_ERROR, "开屏广告的自定义跳过按钮尺寸小于3x3dp。");
                            default:
                                switch (i) {
                                    case 4011:
                                        return new AdError(4011, "由于网络环境不佳或连有连接代理，导致开屏广告拉取超过设置时间。请保障网络畅通，并根据错误信息提示修改嵌入代码；在开屏广告下，可以通过fetchDelay设置超时时间为5s或者其他时间。");
                                    case ErrorCode.AD_INSTANCE_NOT_READY /* 4017 */:
                                        return new AdError(ErrorCode.AD_INSTANCE_NOT_READY, "广告实例尚未准备好。请确保在注册实例成功后再调用实例的相关方法。");
                                    case 5001:
                                        return new AdError(5001, "后台数据异常，可能由于sdk版本过低导致。请升级优量汇SDK版本至最新，如仍有错误，请联系运营人员或至反馈中心提交工单联系技术支持处理。");
                                    case 5002:
                                        return new AdError(5002, "视频素材下载错误，如网络环境不佳导致视频类广告无法下载。建议检查网络环境后重试，如仍有错误，请联系优量汇运营人员或至反馈中心提单咨询。");
                                    case 5003:
                                        return new AdError(5003, "视频素材播放错误。");
                                    case ErrorCode.NO_AD_FILL /* 5004 */:
                                        return new AdError(ErrorCode.NO_AD_FILL, "没有匹配到合适的广告资源，属于调试中或者线上广告的正常现象。如果您在调试环境中遇到此问题，可以通过帮助中的广告助手解决此类问题。");
                                    case ErrorCode.TRAFFIC_CONTROL_DAY /* 5005 */:
                                        return new AdError(ErrorCode.TRAFFIC_CONTROL_DAY, "广告请求量或消耗等指标超过日限额，请明日00:30后再发送请求。");
                                    case ErrorCode.PACKAGE_NAME_ERROR /* 5006 */:
                                        return new AdError(ErrorCode.PACKAGE_NAME_ERROR, "包名校验错误，当前App的包名和优量汇移动联盟官网注册的媒体包名不一致，因此无广告返回");
                                    case ErrorCode.RESOURCE_LOAD_ERROR /* 5007 */:
                                        return new AdError(ErrorCode.RESOURCE_LOAD_ERROR, "资源加载错误。");
                                    case ErrorCode.IMAGE_LOAD_ERROR /* 5008 */:
                                        return new AdError(ErrorCode.IMAGE_LOAD_ERROR, "调试期间使用连接代理或者网络不佳，导致图片加载错误，建议关闭代理或者确保网络状况良好再去请求广告，如仍有错误，请至反馈中心提单咨询。");
                                    case ErrorCode.TRAFFIC_CONTROL_HOUR /* 5009 */:
                                        return new AdError(ErrorCode.TRAFFIC_CONTROL_HOUR, "广告请求量或者消耗等超过小时限额，请下一小时再发起请求。");
                                    case ErrorCode.RENDER_TYPE_POSTYPE_NOTMATCH /* 5010 */:
                                        break;
                                    case ErrorCode.NATIVE_EXPRESS_DATA_AND_TEMPLATE_NOT_MATCHED_ERROR /* 5011 */:
                                        return new AdError(ErrorCode.NATIVE_EXPRESS_DATA_AND_TEMPLATE_NOT_MATCHED_ERROR, "原生模板渲染失败。");
                                    case ErrorCode.AD_DATA_EXPIRE /* 5012 */:
                                        return new AdError(ErrorCode.AD_DATA_EXPIRE, "广告已经过期，建议在调用show之前使用isValid方法判断下广告是否有效，广告有效再去拉取广告（如果开发者有使用预加载广告一定要先判断再展示）。");
                                    case ErrorCode.AD_REQUEST_THROTTLING /* 5013 */:
                                        return new AdError(ErrorCode.AD_REQUEST_THROTTLING, "当前广告请求过于频繁，建议适当降低请求频率。");
                                    case ErrorCode.NO_AD_FILL_FOR_INSTALLED /* 5014 */:
                                        return new AdError(ErrorCode.NO_AD_FILL_FOR_INSTALLED, "广告被定向过滤（多发生在下载类广告，如应用安装或未安装），属于一种正常现象，开发者可酌情忽略，也可以通过调整一次广告请求返回的广告数量进行缓解。");
                                    case ErrorCode.METHOD_CALL_ERROR /* 5024 */:
                                        return new AdError(ErrorCode.METHOD_CALL_ERROR, "广告位接口组合错误，请检查代码中是否存在开屏非全屏广告使用全屏接口的情况。");
                                    case ErrorCode.ServerError.POSID_STATE_ABNORMAL /* 100133 */:
                                        return new AdError(ErrorCode.ServerError.POSID_STATE_ABNORMAL, "请检查广告位ID的使用是否正确，并确保广告位处于开启状态（中途如有开关操作则需等待半小时后使用），如是新建广告位，请在新建30分钟后请求广告。");
                                    case ErrorCode.ServerError.ORENTATION_MISMATCH /* 100159 */:
                                        return new AdError(ErrorCode.ORENTATION_MISMATCH, "应用横竖方向参数与广告位支持方向不匹配。");
                                    case ErrorCode.ServerError.NO_MATCH_AD /* 102006 */:
                                        return new AdError(ErrorCode.ServerError.NO_MATCH_AD, "没有找到符合价格要求或体验要求的广告，也可能由于请求过于频繁或返回未曝光，且产生的收入低导致无广告返回。建议适当调整底价，并提升广告曝光率，或至平台广告中心检查核对屏蔽规则。");
                                    case ErrorCode.ServerError.JS_REQUEST_DOMAIN_NOT_MATCH /* 107009 */:
                                        return new AdError(ErrorCode.ServerError.JS_REQUEST_DOMAIN_NOT_MATCH, "JS请求域名不匹配，请检查JS请求域名是否正确，确保与在平台注册的域名一致。可先进行域名校验，成功后再进行广告请求。");
                                    case ErrorCode.ServerError.OS_TYPE_ERROR /* 107011 */:
                                        return new AdError(ErrorCode.ServerError.OS_TYPE_ERROR, "请求中的操作系统类型与广告位在优量汇平台的设置不匹配，请检查广告请求中的os字段是否正确。");
                                    case ErrorCode.ServerError.PACKAGE_NAME_ERROR /* 107030 */:
                                        return new AdError(ErrorCode.ServerError.PACKAGE_NAME_ERROR, "App包名无效,请参考app_bundle_id参数填写逻辑，请检查代码中使用的App包名是否和注册时填写的一致。");
                                    case ErrorCode.ServerError.ERROR_CALL_INTERFACE /* 107040 */:
                                        return new AdError(ErrorCode.ServerError.ERROR_CALL_INTERFACE, "错误的sdk接口调用，比如申请的广告位是原生自渲染，广告使用场景是信息流，却错误的调用了信息流的相关接口NativeExpressAD，就造成了广告位是自渲染，接口是模板渲染的不匹配情况。");
                                    case ErrorCode.ServerError.APPID_VALIDATION_FAILED /* 107065 */:
                                        return new AdError(ErrorCode.ServerError.APPID_VALIDATION_FAILED, "广告位ID与媒体的AppID不匹配或AppID缺失，请重点检查设置或下发的AppID与广告位ID正确且匹配，保证在广告请求之前SDK初始化时完成");
                                    case ErrorCode.ServerError.PACKAGE_NAME_MISMATCH_WITH_RECORD /* 107076 */:
                                        return new AdError(ErrorCode.ServerError.PACKAGE_NAME_MISMATCH_WITH_RECORD, "请求包名与在优量汇注册的媒体全包名一致才返回广告");
                                    case ErrorCode.ServerError.PACKAGE_NAME_SEGMENTS_VALIDATION_FAILED /* 107077 */:
                                        return new AdError(ErrorCode.ServerError.PACKAGE_NAME_SEGMENTS_VALIDATION_FAILED, "请求包名段数大于等于全包名段数，且和主包名左匹配一致才返回广告");
                                    case ErrorCode.ServerError.REQUEST_FREQUENTLY /* 109502 */:
                                        return new AdError(ErrorCode.ServerError.REQUEST_FREQUENTLY, "请求过于频繁或返回未曝光，且产生的收入低，触发平台出于成本考虑的填充限制。建议减少无效的重复请求，提升广告曝光率。");
                                    case ErrorCode.ServerError.TRAFFIC_CONTROL_DAY /* 109506 */:
                                        return new AdError(ErrorCode.TRAFFIC_CONTROL_DAY, "广告请求量或者消耗等超过日限额，请明天再请求广告。");
                                    case ErrorCode.ServerError.TRAFFIC_CONTROL_HOUR /* 109507 */:
                                        return new AdError(ErrorCode.TRAFFIC_CONTROL_HOUR, "广告请求量或者消耗等超过小时限额，请一小时后再请求广告。");
                                    case ErrorCode.ServerError.NOT_FOUND_SUITABLE_PT /* 109512 */:
                                        return new AdError(ErrorCode.ServerError.NOT_FOUND_SUITABLE_PT, "没有找到合适的素材类型或规格，例如非4G和WiFi网络，则无法返回视频广告。建议释放或调整广告位的素材要求。");
                                    case ErrorCode.ServerError.SERVER_BIDDING_TOKEN_MISSING /* 132005 */:
                                        return new AdError(ErrorCode.ServerError.SERVER_BIDDING_TOKEN_MISSING, "server bidding请求广告时，缺少token参数。");
                                    case ErrorCode.ServerError.SERVER_BIDDING_NOT_RECEIVE_VALID_AD /* 132007 */:
                                        return new AdError(ErrorCode.ServerError.SERVER_BIDDING_NOT_RECEIVE_VALID_AD, "server bidding请求没有收到有效的广告素材，请检查实例化广告对象时使用的token是否过期（token有效期为90s）。");
                                    case ErrorCode.ServerError.SERVER_BIDDING_TOKEN_PARSE_FAIL /* 132008 */:
                                        return new AdError(ErrorCode.ServerError.SERVER_BIDDING_TOKEN_PARSE_FAIL, "server bidding请求广告时，token参数解析失败，请使用线上环境请求价格时返回的token参数而非联调工具中的token参数。");
                                    case ErrorCode.AD_MANAGER_INIT_ERROR /* 200101 */:
                                        return new AdError(2001, "初始化错误，详细码：200101");
                                    case ErrorCode.PLUGIN_INIT_ERROR /* 200102 */:
                                        return new AdError(2001, "初始化错误，详细码：200102");
                                    case ErrorCode.POFACTORY_GET_INTERFACE_ERROR /* 200103 */:
                                        return new AdError(2001, "初始化错误，详细码：200103");
                                    case ErrorCode.NATIVE_PARSE_JS_PARAM_ERROR /* 200201 */:
                                        return new AdError(2002, "内部错误，详细码：200201");
                                    case ErrorCode.JS_PARSE_NATIVE_PARAM_ERROR /* 200202 */:
                                        return new AdError(2002, "内部错误，详细码：200202");
                                    case ErrorCode.AD_ERROR_EVENT_PARAM_ERROR /* 200203 */:
                                        return new AdError(2002, "内部错误，详细码：200203");
                                    case ErrorCode.POSID_NULL /* 400101 */:
                                    case ErrorCode.APPID_NULL /* 400102 */:
                                    case ErrorCode.CONTEXT_NULL /* 400103 */:
                                    case ErrorCode.SPLASH_CONTAINER_NULL /* 400104 */:
                                        return new AdError(4001, CtFAbx.ARc23Z(i, "传入的参数有错误。详细码："));
                                    default:
                                        switch (i) {
                                            case ErrorCode.ServerError.APPID_STATE_ABNORMAL /* 100135 */:
                                                return new AdError(ErrorCode.ServerError.APPID_STATE_ABNORMAL, "媒体未通过审核或广告位处于「封禁、暂停、冻结」等状态。建议检查媒体或广告位状态，如有疑问可联系运营人员或至反馈中心提单咨询。");
                                            case ErrorCode.ServerError.POSID_NOT_MATCH_SUITABLE_PT /* 100136 */:
                                                return new AdError(ErrorCode.ServerError.POSID_NOT_MATCH_SUITABLE_PT, "广告位未匹配到合适规格和样式的素材资源，建议调整或扩充广告的样式，如需了解详情，请至反馈中心提单咨询。");
                                            default:
                                                switch (i) {
                                                    case ErrorCode.ServerError.RENDER_TYPE_POSTYPE_NOTMATCH /* 107034 */:
                                                        break;
                                                    case ErrorCode.ServerError.NOT_SUPPORT_EXPRESS_VIDEO /* 107035 */:
                                                        return new AdError(ErrorCode.NOT_SUPPORT_EXPRESS_VIDEO, "在旧版SDK上使用了模板视频的广告位。请升级优量汇SDK版本至最新。");
                                                    default:
                                                        switch (i) {
                                                            case ErrorCode.ServerError.JS_OLD_ADMISSION_RULES_DEPRECATED /* 107049 */:
                                                                return new AdError(ErrorCode.ServerError.JS_OLD_ADMISSION_RULES_DEPRECATED, "JS旧准入规则已废弃，目前不支持iOS设备以及微信环境，请使用符合准入规则的测试设备如安卓版手机QQ、QQ浏览器。");
                                                            case ErrorCode.ServerError.POSID_NOT_MATCH_INTERFACE /* 107050 */:
                                                                return new AdError(ErrorCode.ServerError.POSID_NOT_MATCH_INTERFACE, "SDK接口与广告位不匹配，广告位是模板2.0广告位，请调用SDK模板2.0接口请求广告。发生此问题时可至反馈中心提交工单(同时提供广告请求和回包数据)联系技术支持定位处理。");
                                                            default:
                                                                return new AdError(ErrorCode.UNKNOWN_ERROR, CtFAbx.ARc23Z(i, "发生某些错误或问题，需要根据详细错误码来定位具体问题。详细码："));
                                                        }
                                                }
                                        }
                                }
                                return new AdError(ErrorCode.RENDER_TYPE_POSTYPE_NOTMATCH, "广告位与调用接口不匹配，导致广告样式校验失败，请检查是否存在广告形态与调用接口不一致的情况。比如，是否用插屏全屏广告位的实例化对象调用了插屏半屏接口loadAD()。");
                        }
                }
        }
    }

    public static AdError getAdError(ADEvent aDEvent) {
        if (aDEvent != null) {
            JSONObject jSONObject = (JSONObject) aDEvent.getParam(1, JSONObject.class);
            if (jSONObject != null) {
                int optInt = jSONObject.optInt(MediationConstant.KEY_ERROR_CODE);
                String optString = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
                if (!TextUtils.isEmpty(optString) && optInt > 0) {
                    return new AdError(optInt, optString);
                }
            }
            Integer num = (Integer) aDEvent.getParam(Integer.class);
            if (num != null) {
                return formatErrorCode(num.intValue());
            }
        }
        return formatErrorCode(ErrorCode.AD_ERROR_EVENT_PARAM_ERROR);
    }
}
