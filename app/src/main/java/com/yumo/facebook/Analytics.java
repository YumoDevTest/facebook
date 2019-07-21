package com.yumo.facebook;
import android.content.Context;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

public class Analytics {

    private AppEventsLogger logger;
    public void init(Context context){
        logger = AppEventsLogger.newLogger(context);
    }

    public void logSentFriendRequestEvent (String event) {
        logger.logEvent("sentFriendRequest");
    }
}
