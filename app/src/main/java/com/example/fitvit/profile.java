package com.example.fitvit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;
import java.util.InvalidPropertiesFormatException;

public class profile extends AppCompatActivity {
ImageButton profile_image;
Uri imageUri;
public static final int PICK_IMAGE=1;
EditText etname;
EditText ettitle;
EditText etbio;
EditText etheight;
EditText etweight;
EditText    etage;
EditText etstep;
SharedPreferences sharedPreferences;
static  final String mypreferences="mypref";
static final String Name="namekey";
static final String Title="titlekey";
        static final String Weight="weightkey";
static final String Height="heightkey";
static final String Age="age key";
static final String Step="stepkey";
static final String Bio="biokey";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
profile_image=findViewById(R.id.profile_img);
etname=findViewById(R.id.etname);
ettitle =findViewById(R.id.ettitle);
etheight=findViewById(R.id.etheight);
etweight=findViewById(R.id.etweight);
etage=findViewById(R.id.etage);
etbio=findViewById(R.id.etbio);
etstep=findViewById(R.id.etstep);
        sharedPreferences =getSharedPreferences(mypreferences, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(Name)){
            etname.setText(sharedPreferences.getString(Name,""));
        }
        if(sharedPreferences.contains(Title)){
            ettitle.setText(sharedPreferences.getString(Title,""));
        }
        if(sharedPreferences.contains(Age)){
            etage.setText(sharedPreferences.getString(Age,""));
        }
        if(sharedPreferences.contains(Weight)){
            etweight.setText(sharedPreferences.getString(Weight,""));
        }
        if(sharedPreferences.contains(Height)){
            etheight.setText(sharedPreferences.getString(Height,""));
        }
        if(sharedPreferences.contains(Bio)){
            etbio.setText(sharedPreferences.getString(Bio,""));
        }
        if(sharedPreferences.contains(Step)){
            etstep.setText(sharedPreferences.getString(Step,""));
        }



 profile_image.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         Intent gallary= new Intent();
         gallary.setType("image/*");
         gallary.setAction(Intent.ACTION_GET_CONTENT);
         startActivityForResult(Intent.createChooser(gallary,"select picture"),PICK_IMAGE);
     }
 });
    }
    @Override
    protected void onActivityResult(int requestcode,int resultcode,Intent data){
        super.onActivityResult(requestcode,resultcode,data);
        if(requestcode==PICK_IMAGE && resultcode==RESULT_OK){
             imageUri = data.getData();
            try{
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),imageUri);
                profile_image.setImageBitmap(bitmap);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public void save(View v){
 String n=etname.getText().toString();
 String t=ettitle.getText().toString();
 String b=etbio.getText().toString();
 String a=etage.getText().toString();
 String h=etheight.getText().toString();
 String w=etweight.getText().toString();
 String s=etstep.getText().toString();

 SharedPreferences.Editor editor=sharedPreferences.edit();
 editor.putString(Name,n);
 editor.putString(Age,a);
 editor.putString(Title,t);
 editor.putString(Weight,w);
 editor.putString(Height,h);
 editor.putString(Step,s);
 editor.putString(Bio,b);
 editor.commit();



    }

    public void clear (View v){
        etname.setText("");
        ettitle.setText("");
        etweight.setText("");
        etheight.setText("");
        etbio.setText("");
        etstep.setText("");
        etage.setText("");


    }
    public void retrive(View v){
sharedPreferences =getSharedPreferences(mypreferences, Context.MODE_PRIVATE);
if(sharedPreferences.contains(Name)){
etname.setText(sharedPreferences.getString(Name,""));
}
if(sharedPreferences.contains(Title)){
ettitle.setText(sharedPreferences.getString(Title,""));
    }
        if(sharedPreferences.contains(Age)){
etage.setText(sharedPreferences.getString(Age,""));
        }
        if(sharedPreferences.contains(Weight)){
etweight.setText(sharedPreferences.getString(Weight,""));
        }
        if(sharedPreferences.contains(Height)){
etheight.setText(sharedPreferences.getString(Height,""));
        }
        if(sharedPreferences.contains(Bio)){
etbio.setText(sharedPreferences.getString(Bio,""));
        }
        if(sharedPreferences.contains(Step)){
            etstep.setText(sharedPreferences.getString(Step,""));
        }

        }


}
