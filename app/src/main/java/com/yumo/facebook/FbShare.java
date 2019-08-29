package com.yumo.facebook;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.share.ShareApi;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

public class FbShare {
  private static final String TAG = "fbshare";
  private static CallbackManager callbackManager = CallbackManager.Factory.create();
  public static void share(Activity activity){
    ShareDialog shareDialog = new ShareDialog(activity);
    ShareLinkContent content = new ShareLinkContent.Builder()
        .setContentUrl(Uri.parse("https://developers.facebook.com"))
        .build();
    // this part is optional


    shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {

      @Override
      public void onSuccess(Sharer.Result result) {
        //分享成功的回调，在这里做一些自己的逻辑处理
        Log.i(TAG, "onSuccess");
      }

      @Override
      public void onCancel() {
        Log.i(TAG, "onCancel");

      }

      @Override
      public void onError(FacebookException error) {
        error.printStackTrace();
        Log.i(TAG, "onError:"+error.getMessage());
      }
    });
    shareDialog.show(content, ShareDialog.Mode.AUTOMATIC);

    testShareToFacebook(activity);
  }

  public static void testShareToFacebook(Activity activity){
    Uri imageUrl = Uri.parse("https://www.facebook.com/images/checkpoint/header/Header_Generic_Key.png");

    ShareLinkContent linkContent = new ShareLinkContent.Builder()
        .setContentTitle("test")
        .setContentDescription("test")
        .setContentUrl(imageUrl)
        .setImageUrl(imageUrl)
        .build();
    Profile profile = Profile.getCurrentProfile();
    if (ShareDialog.canShow(ShareLinkContent.class)) {
      ShareDialog shareDialog = new ShareDialog(activity);
      //shareDialog.registerCallback(mCallbackManager, mShareCallback);
      shareDialog.show(linkContent,ShareDialog.Mode.NATIVE);
    } else if (profile != null) {
      ShareApi.share(linkContent, null);
    } else {
      //            pendingAction = PendingAction.POST_STATUS_UPDATE;
    }
  }

}
