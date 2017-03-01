package itsazakproduction.firebaseapp;

import android.app.Application;

import com.microsoft.projectoxford.face.FaceServiceClient;
import com.microsoft.projectoxford.face.FaceServiceRestClient;

/**
 * Created by shuss on 2/28/2017.
 */

public class SampleApp extends Application {
    @Override
        public void onCreate() {
        super.onCreate();
        sFaceServiceClient = new FaceServiceRestClient(getString(R.string.subscription_key));
        }

        public static FaceServiceClient getFaceServiceClient() {
            return sFaceServiceClient;
        }

        private static FaceServiceClient sFaceServiceClient;

}

