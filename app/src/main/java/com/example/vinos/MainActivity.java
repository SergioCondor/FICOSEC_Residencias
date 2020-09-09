package com.example.vinos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vinos.activity.LoginActivity;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.*;
import com.facebook.login.widget.LoginButton;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Conexion conexion;
    SQLiteDatabase db;
    private LoginButton loginbutton;
    private CallbackManager callbackManager;
    private TextView info, correo;
    private ImageView fbimg;
    private static final String EMAIL = "email";
    @Override

   
        
    
    protected void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);

        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_main);
        info = (TextView) findViewById(R.id.info);
        correo = (TextView)findViewById(R.id.correo);
        fbimg= (ImageView) findViewById(R.id.fbimg);
        loginbutton =(LoginButton) findViewById(R.id.login_button);
        loginbutton.setReadPermissions(Arrays.asList(EMAIL,"public_profile"));

        loginbutton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

          // String imageURL ="https://graph.facebook.com/" +loginResult.getAccessToken().getUserId() + "/picture?return_ssl_resources=1";
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });


      /* new CountDownTimer(1000, 1000) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }

        }.start();*/
      // findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View v) {
              //  startActivity(new Intent(MainActivity.this, Principal.class));

          //  }
      //  });
        conexion = new Conexion(getApplicationContext());
      db = conexion.getWritableDatabase();
     // db.execSQL("insert into azucarvinos(1,'vinotest','seco')");
      //db.execSQL("insert into azucarvinos(2,'vinotests','semiseco')");
       Cursor cursor = db.rawQuery("select * from azucarvinos",null);
     if (cursor.moveToFirst()){
           do{
              String nombre=cursor.getString(0);
              Log.e("azucarvino",nombre);
           }while(cursor.moveToNext());
       }else{
           //Toast.makeText(getApplicationContext()," Sin registros",Toast.LENGTH_LONG).show();
        }
    }
    //facebook login
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
    AccessTokenTracker tokenTracker = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
        if(currentAccessToken == null){
        info.setText("");
        correo.setText("");
        Toast.makeText(MainActivity.this,"usuario deslogeado",Toast.LENGTH_LONG).show();

        }else
        loaduserProfile(currentAccessToken);
        }
    };
    private  void loaduserProfile (AccessToken newAccessToken){
        GraphRequest request = GraphRequest.newMeRequest(newAccessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {
                    String first_name= object.getString("first_name");
                    String last_name = object.getString("last_name");
                    String email = object.getString("email");
                    String id = object.getString("id");
                    String imageURL = "https://graph.facebook.com/" +id + "/picture?type=normal";

                    info.setText(first_name + " "+ last_name );
                    correo.setText(email);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        Bundle parameters = new  Bundle();
        parameters.putString("fields","first_name,last_name,email,id");
        request.setParameters(parameters);
        request.executeAsync();
    }

}
