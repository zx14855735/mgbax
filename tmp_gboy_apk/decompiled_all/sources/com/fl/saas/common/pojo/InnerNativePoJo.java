package com.fl.saas.common.pojo;

import KjUDno.A2egSU;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.fl.saas.base.widget.AdInfo;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.ydsdk.api.MediaExtraInfo;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class InnerNativePoJo implements MediaExtraInfo {
    private String acType;
    private Bitmap adLogoBitmap;
    private String adLogoUrl;
    private String adOriginName;
    private String appPage;
    private String btnText;
    private Bitmap cornerMark;
    private String desc;
    private int ecpm;
    private String iconUrl;
    private int imgHeight;
    private List<String> imgList;
    private String imgUrl;
    private int imgWidth;
    private String title;
    private double videoDuration;
    private int videoHeight;
    private int videoOrientation;
    private int videoWidth;

    @Override // com.fl.saas.ydsdk.api.MediaExtraInfo
    public final /* synthetic */ void biddingResultUpload(boolean z, int i, int i2) {
        A2egSU.A2egSU(this, z, i, i2);
    }

    @Deprecated
    public abstract void bindClickViews(List<View> list);

    @Deprecated
    public abstract void bindViewGroup(ViewGroup viewGroup);

    public void closeAd() {
    }

    @Deprecated
    public String getAcType() {
        return this.acType;
    }

    @Override // com.fl.saas.ydsdk.api.MediaExtraInfo
    public /* synthetic */ AdInfo getAdInfo() {
        return A2egSU.A4TApA(this);
    }

    @Deprecated
    public Bitmap getAdLogoBitmap() {
        return this.adLogoBitmap;
    }

    @Deprecated
    public String getAdLogoUrl() {
        return this.adLogoUrl;
    }

    @Deprecated
    public String getAdOriginName() {
        return this.adOriginName;
    }

    @Deprecated
    public abstract View getAdView();

    @Deprecated
    public String getAppPage() {
        return this.appPage;
    }

    @Deprecated
    public String getBtnText() {
        return this.btnText;
    }

    @Deprecated
    public Bitmap getCornerMark() {
        return this.cornerMark;
    }

    @Deprecated
    public String getDesc() {
        return this.desc;
    }

    @Override // com.fl.saas.ydsdk.api.MediaExtraInfo
    @Deprecated
    public int getECPM() {
        return this.ecpm;
    }

    @Deprecated
    public String getIconUrl() {
        return this.iconUrl;
    }

    @Deprecated
    public int getImgHeight() {
        return this.imgHeight;
    }

    @Deprecated
    public List<String> getImgList() {
        return this.imgList;
    }

    @Deprecated
    public String getImgUrl() {
        return this.imgUrl;
    }

    @Deprecated
    public int getImgWidth() {
        return this.imgWidth;
    }

    @Override // com.fl.saas.ydsdk.api.MediaExtraInfo
    public final /* synthetic */ String getMaterialJson() {
        return A2egSU.ADYaiT(this);
    }

    @Deprecated
    public String getTitle() {
        return this.title;
    }

    @Deprecated
    public double getVideoDuration() {
        return this.videoDuration;
    }

    @Deprecated
    public int getVideoHeight() {
        return this.videoHeight;
    }

    @Deprecated
    public int getVideoOrientation() {
        return this.videoOrientation;
    }

    @Deprecated
    public int getVideoWidth() {
        return this.videoWidth;
    }

    public void handleBindView(Context context, ViewGroup viewGroup, ViewGroup viewGroup2) {
        ViewGroup viewGroup3;
        try {
            ViewParent parent = viewGroup.getParent();
            if (parent != null) {
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                ViewHelper.removeParent(viewGroup);
                viewGroup2.addView(viewGroup);
                ((ViewGroup) parent).addView(viewGroup2, layoutParams);
                LogcatUtil.d("YdSDK-NativePoJo", "  handleBindView vg parent is not empty");
                return;
            }
            LogcatUtil.d("YdSDK-NativePoJo", "handleBindView vg parent is empty");
            ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
            ArrayList arrayList = new ArrayList();
            while (viewGroup.getChildCount() > 0) {
                View childAt = viewGroup.getChildAt(0);
                viewGroup.removeViewAt(0);
                arrayList.add(childAt);
            }
            try {
                viewGroup3 = (ViewGroup) viewGroup.getClass().getConstructor(Context.class).newInstance(context);
            } catch (Exception e) {
                e.printStackTrace();
                viewGroup3 = null;
            }
            if (viewGroup3 == null) {
                LogcatUtil.e("自渲染view创建异常");
                viewGroup3 = new FrameLayout(context);
            }
            for (int i = 0; i < arrayList.size(); i++) {
                if (viewGroup3.getClass() == viewGroup.getClass()) {
                    viewGroup3.addView((View) arrayList.get(i), ((View) arrayList.get(i)).getLayoutParams());
                } else {
                    viewGroup3.addView((View) arrayList.get(i));
                }
            }
            try {
                viewGroup2.addView(viewGroup3, layoutParams2);
            } catch (Exception e2) {
                viewGroup2.addView(viewGroup3);
                e2.printStackTrace();
            }
            try {
                viewGroup.addView(viewGroup2, layoutParams2);
            } catch (Exception e3) {
                viewGroup.addView(viewGroup2);
                e3.printStackTrace();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Deprecated
    public abstract void render();

    @Deprecated
    public void setAcType(String str) {
        this.acType = str;
    }

    @Deprecated
    public void setAdLogoBitmap(Bitmap bitmap) {
        this.adLogoBitmap = bitmap;
    }

    @Deprecated
    public void setAdLogoUrl(String str) {
        this.adLogoUrl = str;
    }

    @Deprecated
    public void setAdOriginName(String str) {
        this.adOriginName = str;
    }

    @Deprecated
    public void setAppPage(String str) {
        this.appPage = str;
    }

    @Deprecated
    public void setBtnText(String str) {
        this.btnText = str;
    }

    @Deprecated
    public void setCornerMark(Bitmap bitmap) {
        this.cornerMark = bitmap;
    }

    @Deprecated
    public void setDesc(String str) {
        this.desc = str;
    }

    @Deprecated
    public void setECPM(int i) {
        this.ecpm = i;
    }

    @Deprecated
    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    @Deprecated
    public void setImgHeight(int i) {
        this.imgHeight = i;
    }

    @Deprecated
    public void setImgList(List<String> list) {
        this.imgList = list;
    }

    @Deprecated
    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    @Deprecated
    public void setImgWidth(int i) {
        this.imgWidth = i;
    }

    @Deprecated
    public void setTitle(String str) {
        this.title = str;
    }

    @Deprecated
    public void setVideoDuration(double d) {
        this.videoDuration = d;
    }

    @Deprecated
    public void setVideoHeight(int i) {
        this.videoHeight = i;
    }

    @Deprecated
    public void setVideoOrientation(int i) {
        this.videoOrientation = i;
    }

    @Deprecated
    public void setVideoWidth(int i) {
        this.videoWidth = i;
    }
}
