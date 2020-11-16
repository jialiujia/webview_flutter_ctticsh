package com.ctticsh.webview_flutter_ctticsh;

import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;

import androidx.annotation.NonNull;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.Result;

public class FlutterCookieManager implements MethodChannel.MethodCallHandler {

    private final MethodChannel methodChannel;

    FlutterCookieManager(BinaryMessenger messenger) {
        methodChannel = new MethodChannel(messenger, "plugins.flutter.io/cookie_manager");
        methodChannel.setMethodCallHandler(this);
    }

    @Override
    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        if ("clearCookies".equals(methodCall.method)) {
            clearCookies(result);
        } else {
            result.notImplemented();
        }
    }

    void dispose() {
        methodChannel.setMethodCallHandler(null);
    }

    private static void clearCookies(final Result result) {
        CookieManager cookieManager = CookieManager.getInstance();
        final boolean hasCookies = cookieManager.hasCookies();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cookieManager.removeAllCookies(
                    new ValueCallback<Boolean>() {
                        @Override
                        public void onReceiveValue(Boolean value) {
                            result.success(hasCookies);
                        }
                    });
        } else {
            cookieManager.removeAllCookie();
            result.success(hasCookies);
        }
    }
}
