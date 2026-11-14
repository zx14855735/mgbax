package com.kwad.components.core.innerEc;

import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class d {
    private l<b, InnerEcLoginBindResultDate> Rv;

    public final void a(final String str, final c cVar, final String str2) {
        l<b, InnerEcLoginBindResultDate> lVar = new l<b, InnerEcLoginBindResultDate>() { // from class: com.kwad.components.core.innerEc.d.1
            private static InnerEcLoginBindResultDate aw(String str3) {
                JSONObject jSONObject = new JSONObject(str3);
                InnerEcLoginBindResultDate innerEcLoginBindResultDate = new InnerEcLoginBindResultDate();
                innerEcLoginBindResultDate.parseJson(jSONObject);
                return innerEcLoginBindResultDate;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: qG, reason: merged with bridge method [inline-methods] */
            public b createRequest() {
                return new b(str, str2);
            }

            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ InnerEcLoginBindResultDate parseData(String str3) {
                return aw(str3);
            }
        };
        this.Rv = lVar;
        lVar.request(new o<b, InnerEcLoginBindResultDate>() { // from class: com.kwad.components.core.innerEc.d.2
            private void a(InnerEcLoginBindResultDate innerEcLoginBindResultDate) {
                if (cVar != null) {
                    if (innerEcLoginBindResultDate.isParseSuccess()) {
                        cVar.a(innerEcLoginBindResultDate.getData());
                    } else {
                        cVar.qF();
                    }
                }
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                a((InnerEcLoginBindResultDate) baseResultData);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(b bVar, int i, String str3) {
                super.onError(bVar, i, str3);
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.qF();
                }
            }
        });
    }
}
