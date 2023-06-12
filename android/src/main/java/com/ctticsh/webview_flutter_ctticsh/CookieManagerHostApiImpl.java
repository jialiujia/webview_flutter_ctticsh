package com.ctticsh.webview_flutter_ctticsh;

import android.os.Build;
import android.webkit.CookieManager;

class CookieManagerHostApiImpl implements GeneratedAndroidWebView.CookieManagerHostApi {
    @Override
    public void clearCookies(GeneratedAndroidWebView.Result<Boolean> result) {
        CookieManager cookieManager = CookieManager.getInstance();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cookieManager.removeAllCookies(result::success);
        } else {
            final boolean hasCookies = cookieManager.hasCookies();
            if (hasCookies) {
                cookieManager.removeAllCookie();
            }
            result.success(hasCookies);
        }
    }

    @Override
    public void setCookie(String url, String value) {
        CookieManager.getInstance().setCookie(url, value);
    }
}
