package itsazakproduction.firebaseapp;


import android.nfc.Tag;
import android.provider.ContactsContract;
import android.util.Log;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

//imports for firebase
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//imports for face detection
import java.io.*;
import android.app.*;
import android.content.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.graphics.*;
import android.widget.*;
import android.provider.*;
import android.os.AsyncTask;


import com.microsoft.projectoxford.face.FaceServiceClient;
import com.microsoft.projectoxford.face.FaceServiceRestClient;
import com.microsoft.projectoxford.face.contract.Face;
import com.microsoft.projectoxford.face.contract.FaceRectangle;
import com.microsoft.projectoxford.face.contract.GroupResult;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import java.io.File;
import static android.R.attr.tag;

import android.util.Log;


public class GroupingActivity extends AppCompatActivity {
    public final String personGroupId = "myfriends";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grouping);

    }

    //Background task for face grouping.
    class GroupingTask extends AsyncTask<UUID, String, GroupResult> {
        public final String TAG = "My Activity: ";
        @Override
        protected GroupResult doInBackground(UUID... params) {
            FaceServiceClient faceServiceClient = SampleApp.getFaceServiceClient();
            Log.d(TAG, "Request: Grouping " + params.length + " face(s)");
            try {
                publishProgress("Grouping...");

                // Start grouping, params are face IDs.
                return faceServiceClient.group(params);
            } catch (Exception e) {
                Log.d(TAG, e.getMessage());
                publishProgress(e.getMessage());
                return null;
            }
        }
    }

}
