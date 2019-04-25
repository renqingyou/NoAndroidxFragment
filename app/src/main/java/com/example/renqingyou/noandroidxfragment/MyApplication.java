/**Created by wangzhuozhou on 2015/08/01.
 * Copyright © 2015－2018 Sensors Data Inc. All rights reserved. */
 
package com.example.renqingyou.noandroidxfragment;

import android.app.Application;

import android.content.Context;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王灼洲 on 2016/11/12
 */

public class MyApplication extends Application {
    /**
     * Sensors Analytics 采集数据的地址
     */
    private final static String SA_SERVER_URL = "https://test.kbyte.cn:4106/sa?project=default";

    /**
     * Sensors Analytics 配置分发的地址
     */
    private final static String SA_CONFIGURE_URL = "http://test-zouyuhan.cloud.sensorsdata.cn:8006/config/?project=wangzhuozhou";

    /**
     * Sensors Analytics DEBUG 模式
     * SensorsDataAPI.DebugMode.DEBUG_OFF - 关闭 Debug 模式
     * SensorsDataAPI.DebugMode.DEBUG_ONLY - 打开 Debug 模式，校验数据，但不进行数据导入
     * SensorsDataAPI.DebugMode.DEBUG_AND_TRACK - 打开 Debug 模式，校验数据，并将数据导入到 Sensors Analytics 中
     * 注意！请不要在正式发布的 App 中使用 Debug 模式！
     */
    private final SensorsDataAPI.DebugMode SA_DEBUG_MODE = SensorsDataAPI.DebugMode.DEBUG_AND_TRACK;

    @Override
    public void onCreate() {
        super.onCreate();
        initSensorsDataAPI();
    }

    /**
     * 初始化 Sensors Analytics SDK
     */
    private void initSensorsDataAPI() {
        SensorsDataAPI.sharedInstance(this, SA_SERVER_URL, SensorsDataAPI.DebugMode.DEBUG_AND_TRACK);                     // Debug 模式选项
        // 打开自动采集, 并指定追踪哪些 AutoTrack 事件
        List<SensorsDataAPI.AutoTrackEventType> eventTypeList = new ArrayList<SensorsDataAPI.AutoTrackEventType>();
        // $AppStart
        eventTypeList.add(SensorsDataAPI.AutoTrackEventType.APP_START);
        // $AppEnd
        eventTypeList.add(SensorsDataAPI.AutoTrackEventType.APP_END);
        // $AppViewScreen
        eventTypeList.add(SensorsDataAPI.AutoTrackEventType.APP_VIEW_SCREEN);
        // $AppClick
        eventTypeList.add(SensorsDataAPI.AutoTrackEventType.APP_CLICK);
        SensorsDataAPI.sharedInstance(this).enableAutoTrack(eventTypeList);

        SensorsDataAPI.sharedInstance(this).trackFragmentAppViewScreen();
        SensorsDataAPI.sharedInstance().enableLog(true);
        SensorsDataAPI.sharedInstance().enableHeatMap();
        SensorsDataAPI.sharedInstance().enableVisualizedAutoTrack();
        //构造 SSL 套接字工厂实例
        SSLSocketFactory socketFactory = ca(this);
        //SocketFactory socketFactory = bks(this);
        SensorsDataAPI.sharedInstance().setSSLSocketFactory(socketFactory);
    }

    public SSLSocketFactory ca(Context inputContext) {
        SSLContext context;
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            InputStream in = inputContext.getResources().openRawResource(R.raw.cer);
            Certificate ca = cf.generateCertificate(in);
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            keystore.load(null, null);
            keystore.setCertificateEntry("ca", ca);
            String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
            tmf.init(keystore);
            // Create an SSLContext that uses our TrustManager
            context = SSLContext.getInstance("TLS");
            context.init(null, tmf.getTrustManagers(), null);
            return context.getSocketFactory();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    public SSLSocketFactory bks(Context context){
        try {
            KeyStore ks = KeyStore.getInstance("BKS");
            InputStream stream = context.getResources().openRawResource(R.raw.bks);
            ks.load(stream, null);
            try {
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(ks);
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustManagerFactory.getTrustManagers(), null);
            return sc.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
