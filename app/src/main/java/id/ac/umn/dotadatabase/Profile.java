package id.ac.umn.dotadatabase;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class Profile implements Serializable {
    protected String username;
    protected String email;
    protected int preferredRole1;
    protected int preferredRole2;
    protected int preferredRole3;
    protected int preferredRole4;
    protected int preferredAttribute1;
    protected int preferredAttribute2;

    /* helper functions, translates preferred role and attribute between index and its corresponding strings */
    public static String RoleFromIndex(int index){
        switch(index){
            case 0: return "Carry";
            case 1: return "Midlane";
            case 2: return "Offlane";
            case 3: return "Roam";
            case 4: default: return "Support";
        }
    }
    public static String AttributeFromIndex(int index){
        switch(index){
            case 0: return "Strength";
            case 1: return "Agility";
            case 2: default: return "Intelligence";
        }
    }
    public static int PositionToIndex(String position){
        if( position.equals(RoleFromIndex(0)) ){ return 0; }
        else if( position.equals(RoleFromIndex(1)) ){ return 1; }
        else if( position.equals(RoleFromIndex(2)) ){ return 2; }
        else if( position.equals(RoleFromIndex(3)) ){ return 3; }
        else{ return 4; }
    }
    public static int AttributeToIndex(String position){
        if( position.equals(AttributeFromIndex(0)) ){ return 0; }
        else if( position.equals(AttributeFromIndex(1)) ){ return 1; }
        else{ return 2; }
    }
    /* End of section, helper functions */

    /* basic constructors */
    public Profile(){}
    public Profile(
            String username,
            String email,
            int preferredRole1,
            int preferredRole2,
            int preferredRole3,
            int preferredRole4,
            int preferredAttribute1,
            int preferredAttribute2
    ){
        this.username = username;
        this.email = email;
        this.preferredRole1 = preferredRole1;
        this.preferredRole2 = preferredRole2;
        this.preferredRole3 = preferredRole3;
        this.preferredRole4 = preferredRole4;
        this.preferredAttribute1 = preferredAttribute1;
        this.preferredAttribute2 = preferredAttribute2;
    }
    /* basic constructors */

    // basic getters */
    public String getUsername(){ return username; }
    public String getEmail(){ return email; }
    public int getPreferredRole1(){ return preferredRole1; }
    public int getPreferredRole2(){ return preferredRole2; }
    public int getPreferredRole3(){ return preferredRole3; }
    public int getPreferredRole4(){ return preferredRole4; }
    public int getPreferredAttribute1(){ return preferredAttribute1; }
    public int getPreferredAttribute2(){ return preferredAttribute2; }

    // basic setters
    public void setPreferredRole1(int index){ this.preferredRole1 = index; }
    public void setPreferredRole2(int index){ this.preferredRole2 = index; }
    public void setPreferredRole3(int index){ this.preferredRole3 = index; }
    public void setPreferredRole4(int index){ this.preferredRole4 = index; }
    public void setPreferredAttribute1(int index){ this.preferredAttribute1 = index; }
    public void setPreferredAttribute2(int index){ this.preferredAttribute2 = index; }

    //updates profile data in firestore
    public void SaveProfileData(Context context){
        FirebaseFirestore.getInstance()
                .collection("user_profile_data")
                .document(email)
                .set(this);
        SyncPictureUp(PICTURE_TYPE.DISPLAY_PICTURE, context);
        SyncPictureUp(PICTURE_TYPE.BANNER_PICTURE,context);
    };

    /*
     * Pictures section
     */
    protected File prepareProfileDataDir(Context context){
        //File profileDataDir = new File(Environment.getDataDirectory(), "/data/id.ac.umn.dotadatabase/files/profile_data/" + email);
        File profileDataDir = new File(context.getFilesDir(), "/profile_data/" + email);
        if(!profileDataDir.exists()){ profileDataDir.mkdirs(); }
        return profileDataDir;
    }

    public Bitmap retrieveDisplayPictureBitmap(Context context){
        return BitmapFactory.decodeFile(prepareProfileDataDir(context).getPath()+"/display_picture.png");
    }
    public Bitmap retrieveBannerPictureBitmap(Context context){
        return BitmapFactory.decodeFile(prepareProfileDataDir(context).getPath()+"/banner_picture.png");
    }

    public static enum PICTURE_TYPE { DISPLAY_PICTURE, BANNER_PICTURE }

    protected void SyncPictureUp(PICTURE_TYPE pictureType, Context context){
        File profileDataDir = prepareProfileDataDir(context);
        //get a Uri to the file in internal storage
        Uri imageUri = Uri.fromFile(
                new File(
                        profileDataDir,
                        (pictureType==PICTURE_TYPE.DISPLAY_PICTURE)
                                ? "display_picture.png"
                                :"banner_picture.png"
                )
        );
        //imageUri = Uri.fromFile( new File(profileDataDir, "lol.png")); // debug
        //get a StorageReference
        StorageReference ref = FirebaseStorage.getInstance().getReference("user_profile_data/" + email)
                .child(
                        (pictureType==PICTURE_TYPE.DISPLAY_PICTURE)
                                ? "display_picture.png"
                                :"banner_picture.png"
                );
        //ref = FirebaseStorage.getInstance().getReference("user_profile_data/" + email).child("lol.png");
        ref.putFile(imageUri);
    }

    protected void SyncPictureDown(PICTURE_TYPE pictureType, Context context){
        //get a StorageReference
        StorageReference ref = FirebaseStorage.getInstance().getReference("user_profile_data/" + email)
                .child(
                        (pictureType==PICTURE_TYPE.DISPLAY_PICTURE)
                        ? "display_picture.png"
                        :"banner_picture.png"
                );
        //fire off the task
        ref.getBytes(1024*1024*50).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                //decode the byte[] into a Bitmap
                Bitmap imageBitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                //save to internal storage
                SavePictureIntoInternal(imageBitmap, pictureType, context);
            }
        });
    }

    //saves a bitmap into png file in internal storage, in this user's directory
    protected void SavePictureIntoInternal(Bitmap imageBitmap, PICTURE_TYPE pictureType, Context context){
        File profileDataDir = prepareProfileDataDir(context);
        try{
            File picture = null;
            if(pictureType == PICTURE_TYPE.DISPLAY_PICTURE){
                picture = new File(profileDataDir, "display_picture.png");
            }else{
                picture = new File(profileDataDir, "banner_picture.png");
            }
            FileOutputStream outputStream = new FileOutputStream(picture);
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            outputStream.flush(); outputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    /* DEBUG, Insert some profile pictures into wherever we want to - OLD */
    public static void GenerateDummyImages(String username, Context context){
        //Where we want this profile data to be written
        File profileDataDirectory = new File(context.getFilesDir(), "profile_data/"+username);
        //File profileDataDirectory = new File(getExternalFilesDir(null), "profile_data/"+profile.getUsername());
        //File profileDataDirectory = new File("/sdcard/Download", "profile_data/"+profile.getUsername());

        //Write profile data and images into files
        try{
            //prepare the directory
            profileDataDirectory.mkdirs();
            //get the pictures from resources using its id and
            //put them in profile object,
            //then write the them into internal storage
            Bitmap displayPictureBitmap =
                    ( (BitmapDrawable)context.getDrawable(R.drawable.dota_2) )
                            .getBitmap();
            Bitmap bannerPictureBitmap =
                    ( (BitmapDrawable)context.getDrawable(R.drawable.dota_2) )
                            .getBitmap();
            FileOutputStream displayPictureOutputStream =
                    new FileOutputStream(
                            new File(profileDataDirectory, "display_picture.png"));
            FileOutputStream bannerPictureOutputStream =
                    new FileOutputStream(
                            new File(profileDataDirectory, "banner_picture.png"));
            displayPictureBitmap.compress(Bitmap.CompressFormat.PNG, 100, displayPictureOutputStream);
            bannerPictureBitmap.compress(Bitmap.CompressFormat.PNG, 100, bannerPictureOutputStream);
            displayPictureOutputStream.flush(); displayPictureOutputStream.close();
            bannerPictureOutputStream.flush(); bannerPictureOutputStream.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }/* End of section, DEBUG, Insert some profile data into wherever we want to - OLD */
}
