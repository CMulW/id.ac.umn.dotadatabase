package id.ac.umn.dotadatabase;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.FileNotFoundException;

public class EditProfileActivity extends AppCompatActivity {
    protected TextView editProfileTvUsername;
    protected ImageView editProfileIvBanner;
    protected ImageView editProfileIvDisplay;
    protected TextView editProfileTvEmail;
    protected Spinner editProfileSpinnerPreferedRole1;
    protected Spinner editProfileSpinnerPreferedRole2;
    protected Spinner editProfileSpinnerPreferedRole3;
    protected Spinner editProfileSpinnerPreferedRole4;
    protected Spinner editProfileSpinnerPreferedAttribute1;
    protected Spinner editProfileSpinnerPreferedAttribute2;

    protected Profile profile;

    //firebase singletons
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private FirebaseFirestore firestore;
    private FirebaseStorage firebaseStorage;

    //activity launchers
    ActivityResultLauncher<String> newDisplayPictureGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri uri) {
                    if (uri != null) {
                        try{
                            Bitmap imageBitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
                            editProfileIvDisplay.setImageBitmap(imageBitmap);
                            profile.SavePictureIntoInternal(imageBitmap, Profile.PICTURE_TYPE.DISPLAY_PICTURE, EditProfileActivity.this);
                        }catch(FileNotFoundException e){
                            e.printStackTrace();
                        }}}});
    ActivityResultLauncher<String> newBannerPictureGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri uri) {
                    if (uri != null) {
                        try{
                            Bitmap imageBitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
                            editProfileIvBanner.setImageBitmap(imageBitmap);
                            profile.SavePictureIntoInternal(imageBitmap, Profile.PICTURE_TYPE.BANNER_PICTURE, EditProfileActivity.this);
                        }catch(FileNotFoundException e){
                            e.printStackTrace();
                        }}}});
    protected ActivityResultLauncher<Intent> newDisplayPictureCamera = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == Activity.RESULT_OK){
                Bitmap imageBitmap = (Bitmap) result.getData().getExtras().get("data");
                editProfileIvDisplay.setImageBitmap(imageBitmap);
                profile.SavePictureIntoInternal(imageBitmap, Profile.PICTURE_TYPE.DISPLAY_PICTURE, EditProfileActivity.this);
            }}});
    protected ActivityResultLauncher<Intent> newBannerPictureCamera = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == Activity.RESULT_OK){
                Bitmap imageBitmap = (Bitmap) result.getData().getExtras().get("data");
                editProfileIvBanner.setImageBitmap(imageBitmap);
                profile.SavePictureIntoInternal(imageBitmap, Profile.PICTURE_TYPE.BANNER_PICTURE, EditProfileActivity.this);
            }}});

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        editProfileTvUsername = findViewById(R.id.editProfileTvUsername);
        editProfileIvBanner = findViewById(R.id.editProfileIvBanner);
        editProfileIvDisplay = findViewById(R.id.editProfileIvDisplay);
        editProfileTvEmail = findViewById(R.id.editProfileTvEmail);
        editProfileSpinnerPreferedRole1 = findViewById(R.id.editProfileSpinnerPreferedRole1);
        editProfileSpinnerPreferedRole2 = findViewById(R.id.editProfileSpinnerPreferedRole2);
        editProfileSpinnerPreferedRole3 = findViewById(R.id.editProfileSpinnerPreferedRole3);
        editProfileSpinnerPreferedRole4 = findViewById(R.id.editProfileSpinnerPreferedRole4);
        editProfileSpinnerPreferedAttribute1 = findViewById(R.id.editProfileSpinnerPreferedAttribute1);
        editProfileSpinnerPreferedAttribute2 = findViewById(R.id.editProfileSpinnerPreferedAttribute2);

        //firebase singletons
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firestore = FirebaseFirestore.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();

        /* Load profile data from the from firestore */
        firestore
                .collection("user_profile_data")
                .document(firebaseUser.getEmail())
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        DocumentSnapshot document = task.getResult();
                        if (task.isSuccessful() && document.exists()) {
                            profile = document.toObject(Profile.class);
                            Log.d("ProfileActivity:", "DocumentSnapshot data: " + document.getData());
                            Log.d("ProfileActivity:", "Preferred Position 1: " + profile.getPreferredRole1());

                            //set TextView texts and spinner selections
                            editProfileTvUsername.setText(profile.getUsername());
                            editProfileTvEmail.setText(profile.getEmail());
                            editProfileSpinnerPreferedRole1.setSelection(profile.getPreferredRole1());
                            editProfileSpinnerPreferedRole2.setSelection(profile.getPreferredRole2());
                            editProfileSpinnerPreferedRole3.setSelection(profile.getPreferredRole3());
                            editProfileSpinnerPreferedRole4.setSelection(profile.getPreferredRole4());
                            editProfileSpinnerPreferedAttribute1.setSelection(profile.getPreferredAttribute1());
                            editProfileSpinnerPreferedAttribute2.setSelection(profile.getPreferredAttribute2());

                            //take pictures from internal storage into ImageView
                            editProfileIvDisplay.setImageBitmap(profile.retrieveDisplayPictureBitmap(EditProfileActivity.this));
                            editProfileIvBanner.setImageBitmap(profile.retrieveBannerPictureBitmap(EditProfileActivity.this));

                            /* spinners onSelected */
                            editProfileSpinnerPreferedRole1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    profile.setPreferredRole1(position);
                                }
                                @Override public void onNothingSelected(AdapterView<?> parent) { }
                            });
                            editProfileSpinnerPreferedRole2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    profile.setPreferredRole2(position);
                                }
                                @Override public void onNothingSelected(AdapterView<?> parent) { }
                            });
                            editProfileSpinnerPreferedRole3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    profile.setPreferredRole3(position);
                                }
                                @Override public void onNothingSelected(AdapterView<?> parent) { }
                            });
                            editProfileSpinnerPreferedRole4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    profile.setPreferredRole4(position);
                                }
                                @Override public void onNothingSelected(AdapterView<?> parent) { }
                            });
                            editProfileSpinnerPreferedAttribute1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    profile.setPreferredAttribute1(position);
                                }
                                @Override public void onNothingSelected(AdapterView<?> parent) { }
                            });
                            editProfileSpinnerPreferedAttribute2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    profile.setPreferredAttribute2(position);
                                }
                                @Override public void onNothingSelected(AdapterView<?> parent) { }
                            });
                            /* End of section, spinners onSelected */
                        } else {
                            Log.d("MainActivity:", "get failed with ", task.getException());
                        }
                    }// End of onComplete()
                });// End of new onCompleteListener<>()
        /* End of section, Load profile data from the from firestore */

        /* Setup mechanism to change display picture and banner picture */
        //set the dialog that pops up when user taps the image
        View.OnClickListener displayAndBannerPictureOnClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Instantiate a new builder, Inflate the layout, create the AlertDialog
                AlertDialog alertDialog;
                AlertDialog.Builder builder;
                View dialogView;
                View tappedPicture = v;

                //setup the alert dialog
                builder = new AlertDialog.Builder(v.getContext());
                dialogView = LayoutInflater.from(v.getContext()).inflate(
                        R.layout.dialog_new_picture,
                        findViewById(android.R.id.content),
                        false
                );
                builder.setView(dialogView);
                alertDialog = builder.create();

                //find out the picture type by getting the tapped image's id

                //setup the button's onClicks
                dialogView
                        .findViewById(R.id.btnNewPictureDialogCamera)
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(tappedPicture.getId() == R.id.editProfileIvDisplay){
                                    newDisplayPictureCamera.launch(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
                                }else{
                                    newBannerPictureCamera.launch(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
                                }
                                alertDialog.dismiss();
                            }
                        });
                dialogView
                        .findViewById(R.id.btnNewPictureDialogFile)
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //if permisssion not granted, call requestPermissions() then dismiss the dialog,
                                if(
                                        checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                                                != PackageManager.PERMISSION_GRANTED
                                ){
                                    String[] requestedPermissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                                    requestPermissions(requestedPermissions, 999);
                                }else{
                                    if(tappedPicture.getId() == R.id.editProfileIvDisplay){
                                        newDisplayPictureGetContent.launch("image/");
                                    }else{
                                        newBannerPictureGetContent.launch("image/");
                                    }
                                }
                                alertDialog.dismiss();
                            }
                        });
                //show the AlertDialog
                alertDialog.show();
            }
        };/* End of Section, View.OnClickListener displayAndBannerPictureOnClickListener = new View.OnClickListener(){}; */
        //register the listener to both ImageViews
        editProfileIvDisplay.setOnClickListener(displayAndBannerPictureOnClickListener);
        editProfileIvBanner.setOnClickListener(displayAndBannerPictureOnClickListener);
        /* End of section, Setup mechanism to change display picture and banner picture */
    }//End of section, onCreate()

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        profile.SaveProfileData(this);
        profile.SyncPictureUp(Profile.PICTURE_TYPE.DISPLAY_PICTURE, this);
        profile.SyncPictureUp(Profile.PICTURE_TYPE.BANNER_PICTURE, this);
    }
}