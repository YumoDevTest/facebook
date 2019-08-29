package com.yumo.facebook;
import android.content.Context;

import android.media.FaceDetector;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;

public class Analytics {

    private AppEventsLogger logger;
    public void init(Context context){
        logger = AppEventsLogger.newLogger(context);

        FacebookSdk.setIsDebugEnabled(true);
        FacebookSdk.addLoggingBehavior(LoggingBehavior.APP_EVENTS);
        FacebookSdk.getApplicationId();

       
    }

    public void logSentFriendRequestEvent (String event) {
        logger.logEvent(event);
    }
}
