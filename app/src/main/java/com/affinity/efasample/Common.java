package com.affinity.efasample;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Common {
    public static BroadcastReceiver receiver;
    public static String device_token = "";
    public static String device_refresh_token = "";
    public static JSONArray CabDetail;
    public static String Currency = "";
    public static String Country = "";
    public static String StartDayTime = "";
    public static String EndDayTime = "";
    public static String ActiveActivity = "book my trips";
    public static int is_pusnotification = 0;
    public static int user_InActive = 0;
    public static String InActive_msg = "";

    /*Register page Variable*/
    public static String Name = "";
    public static String UserName = "";
    public static String Password = "";
    public static String Mobile = "";
    public static String CountryCode = "";
    public static String Email = "";
    public static String DateOfBirth = "";
    public static String Gender = "";
    public static String UserImage = "";
    public static String FacebookId = "";
    public static String TwitterId = "";
    public static double RegLattude;
    public static double RegLontude;

    public static RelativeLayout layout_book_my_trip;
    public static RelativeLayout layout_my_trip;
    public static RelativeLayout layout_rate_card;
    public static RelativeLayout layout_cahnge_password;
    public static RelativeLayout layout_footer_logout;
    public static RelativeLayout layout_cahnge_mobile;
    public static RelativeLayout rl_my_profile;
    public static RelativeLayout rl_addcard;

    public static JSONArray cardsArrays;

    public static Dialog dialogMain;

    public static void showLoginRegisterMkError(final Activity act, String message)
    {
        if(!act.isFinishing()){

            Animation slideUpAnimation;

            final Dialog MKInfoPanelDialog = new Dialog(act,android.R.style.Theme_Translucent_NoTitleBar);

            MKInfoPanelDialog.setContentView(R.layout.mkinfopanel);
            MKInfoPanelDialog.show();
            slideUpAnimation = AnimationUtils.loadAnimation(act.getApplicationContext(),
                    R.anim.slide_up_map);

            RelativeLayout layout_info_panel = (RelativeLayout) MKInfoPanelDialog.findViewById(R.id.layout_info_panel);
            layout_info_panel.startAnimation(slideUpAnimation);

            TextView subtitle = (TextView)MKInfoPanelDialog.findViewById(R.id.subtitle);
            subtitle.setText(message);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    try {
                        if(MKInfoPanelDialog.isShowing() && !act.isFinishing())
                            MKInfoPanelDialog.cancel();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 2000);

        }
    }

    public static void LoginMkError(final Activity act,String message,String code){

        Typeface OpenSans_Bold = Typeface.createFromAsset(act.getAssets(), "fonts/OpenSans-Bold_0.ttf");
        Typeface OpenSans_Regular = Typeface.createFromAsset(act.getAssets(), "fonts/OpenSans-Regular_0.ttf");

        final Dialog LoginErrorDialog = new Dialog(act,android.R.style.Theme_Translucent_NoTitleBar);
        LoginErrorDialog.setContentView(R.layout.login_error_dialog);
        TextView txt_invalid_login = (TextView)LoginErrorDialog.findViewById(R.id.txt_invalid_login);
        TextView txt_error_msg = (TextView)LoginErrorDialog.findViewById(R.id.txt_error_msg);
        Log.d("code","code = "+code);
        if(code.toString().toLowerCase().equals("invalid login")){
            txt_invalid_login.setText("invalid_login");
            txt_error_msg.setText("correct_login_detail");
        }else{
            txt_invalid_login.setText("recheck_your_login_detail_title");
            txt_error_msg.setText("recheck_your_login_detail");
        }
        txt_invalid_login.setTypeface(OpenSans_Bold);
        txt_error_msg.setTypeface(OpenSans_Regular);

        RelativeLayout layout_ok = (RelativeLayout)LoginErrorDialog.findViewById(R.id.layout_ok);
        layout_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginErrorDialog.cancel();
            }
        });

        LoginErrorDialog.show();
    }

    public static void showMkError(final Activity act, final String error_code)
    {
        String message = "";
        if(!act.isFinishing()){
            Log.d("error_code","error_code = "+error_code);
            if(error_code.equals("2")){
              //  message = act.getResources().getString(R.string.enter_correct_login_detail);
            }else if(error_code.equals("7")){
              //  message = act.getResources().getString(R.string.email_username_mobile_exit);
            }else if(error_code.equals("8")){
               // message = act.getResources().getString(R.string.email_username_exit);
            }else if(error_code.equals("9")){
               // message = act.getResources().getString(R.string.email_mobile_exit);
            }else if(error_code.equals("10")){
                //message = act.getResources().getString(R.string.mobile_username_exit);
            }else if(error_code.equals("11")){
                //message = act.getResources().getString(R.string.email_exit);
            }else if(error_code.equals("12")){
               // message = act.getResources().getString(R.string.user_exit);
            }else if(error_code.equals("13")){
               // message = act.getResources().getString(R.string.mobile_exit);
            }else if(error_code.equals("14")){
                //message = act.getResources().getString(R.string.somthing_worng);
            }else if(error_code.equals("15") || error_code.equals("16")){
               // message = act.getResources().getString(R.string.data_not_found);
            }else if(error_code.equals("19")){
               // message = act.getResources().getString(R.string.vehicle_numbet_exits);
            }else if(error_code.equals("20")){
              //  message = act.getResources().getString(R.string.license_numbet_exits);
            }else if(error_code.equals("22")){
               // message = act.getResources().getString(R.string.dublicate_booking);
            }else{
                message = error_code;
            }

            final SharedPreferences userPref = PreferenceManager.getDefaultSharedPreferences(act);

            Animation slideUpAnimation;

            final Dialog MKInfoPanelDialog = new Dialog(act,android.R.style.Theme_Translucent_NoTitleBar);

            MKInfoPanelDialog.setContentView(R.layout.mkinfopanel);
            MKInfoPanelDialog.show();
            slideUpAnimation = AnimationUtils.loadAnimation(act.getApplicationContext(),
                    R.anim.slide_up_map);

            RelativeLayout layout_info_panel = (RelativeLayout) MKInfoPanelDialog.findViewById(R.id.layout_info_panel);
            layout_info_panel.startAnimation(slideUpAnimation);

            RelativeLayout.LayoutParams buttonLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) act.getResources().getDimension(R.dimen.height_50));
            buttonLayoutParams.setMargins(0, (int) act.getResources().getDimension(R.dimen.height_50), 0, 0);
            layout_info_panel.setLayoutParams(buttonLayoutParams);

            TextView subtitle = (TextView)MKInfoPanelDialog.findViewById(R.id.subtitle);
            subtitle.setText(message);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    try {
                        if(MKInfoPanelDialog.isShowing() && !act.isFinishing())
                            MKInfoPanelDialog.cancel();

                        if(error_code.equals("1") || error_code.equals("5") ){
                            SharedPreferences.Editor editor = userPref.edit();
                            editor.clear();
                            editor.commit();

                            /*Intent logInt = new Intent(act, LoginOptionActivity.class);
                            logInt.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            logInt.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            logInt.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            act.startActivity(logInt);*/
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 2000);

        }
    }

    public static void showMkSucess(final Activity act,String message,String isHeader)
    {
        if(!act.isFinishing()){

            Animation slideUpAnimation;

            final Dialog MKInfoPanelDialog = new Dialog(act,android.R.style.Theme_Translucent_NoTitleBar);

            MKInfoPanelDialog.setContentView(R.layout.mkinfopanel);
            MKInfoPanelDialog.show();
            slideUpAnimation = AnimationUtils.loadAnimation(act.getApplicationContext(),
                    R.anim.slide_up_map);
            slideUpAnimation.setFillAfter(true);
            slideUpAnimation.setDuration(2000);

            RelativeLayout layout_info_panel = (RelativeLayout) MKInfoPanelDialog.findViewById(R.id.layout_info_panel);
            layout_info_panel.setBackgroundResource(R.color.alabaster);
            layout_info_panel.startAnimation(slideUpAnimation);

            if(isHeader.equals("yes")) {
                RelativeLayout.LayoutParams buttonLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) act.getResources().getDimension(R.dimen.height_50));
                buttonLayoutParams.setMargins(0, (int) act.getResources().getDimension(R.dimen.height_50), 0, 0);
                layout_info_panel.setLayoutParams(buttonLayoutParams);
            }

            TextView subtitle = (TextView)MKInfoPanelDialog.findViewById(R.id.subtitle);
            subtitle.setText(message);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (MKInfoPanelDialog.isShowing() && !act.isFinishing())
                            MKInfoPanelDialog.cancel();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 2000);

        }
    }

    public static boolean isNetworkAvailable(Activity act){

        ConnectivityManager connMgr = (ConnectivityManager)act.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            // fetch data
            return true;
        } else {
            // display error
            return false;
        }

    }

    public static void showInternetInfo(final Activity act,String message)
    {
        if(!act.isFinishing()){
            final InternetInfoPanel mk = new InternetInfoPanel(act, InternetInfoPanel.InternetInfoPanelType.MKInfoPanelTypeInfo, "SUCCESS!",message, 2000);
            mk.show();
            mk.getIv_ok().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    try {
                        if(mk.isShowing() && !act.isFinishing())
                            mk.cancel();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static boolean ShowHttpErrorMessage(Activity activity,String ErrorMessage){

        Log.d("ErrorMessage", "ErrorMessage = " + ErrorMessage);
        boolean Status = true;
        if (ErrorMessage != null && !ErrorMessage.equals("")) {
            if (ErrorMessage.contains("Connect to")) {
                Common.showInternetInfo(activity, "");
                Status = false;
            }else if(ErrorMessage.contains("failed to connect to")){
                Common.showInternetInfo(activity, "network not available");
                Status = false;
            }else if(ErrorMessage.contains("Internal Server Error")){
                Common.showMkError(activity, "Internal Server Error");
                Status = false;
            }else if(ErrorMessage.contains("Request Timeout")){
                Common.showMkError(activity, "Request Timeout");
                Status = false;
            }
        }else{
            Toast.makeText(activity, "Server Time Out", Toast.LENGTH_LONG).show();
            Status = false;
        }
        return Status;
    }


    public static Float getTotalPrice(String intailrate,float FirstKm,Float distance,String fromintailrate,String ride_time_rate,int totalTime){
        Float totlePrice;
        Float firstPrice = Float.parseFloat(intailrate);
        Float secoundPrice = null;
        Log.d("fromintailrate","fromintailrate FirstKm= "+FirstKm+"=="+distance);
        if(distance != 0) {
            if (FirstKm < distance) {
                Float afterkm = distance - FirstKm;
                Log.d("fromintailrate", "fromintailrate distance= " + fromintailrate + "==" + afterkm);
                if (fromintailrate.equals(""))
                    fromintailrate = "0";
                secoundPrice = Float.parseFloat(fromintailrate) * afterkm;
                Log.d("total price", "total price = " + distance + "==" + FirstKm + "==" + afterkm);
            }
        }

        Log.d("totalTime","totalTime = "+totalTime+"=="+ride_time_rate);
        float driverprice = Float.parseFloat(ride_time_rate) * totalTime;

        if(secoundPrice != null)
            totlePrice = firstPrice+secoundPrice+driverprice;
        else
            totlePrice = firstPrice+driverprice;

        return totlePrice;
    }

    public static int getDisplayHeight(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }

//    public static void HintFunction(final Activity activity, final EditText editText, final String HitMessage){
//        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (hasFocus)
//                {
//                    if(editText.getText().length() == 0)
//                        Common.showMkHitMessage(activity, HitMessage);
//                }
//            }
//        });
//    }

    public static void showMkHitMessage(final Activity act,String message)
    {
        if(!act.isFinishing()){

            Animation slideUpAnimation;

            final Dialog MKInfoPanelDialog = new Dialog(act,android.R.style.Theme_Translucent_NoTitleBar);

            MKInfoPanelDialog.setContentView(R.layout.mkinfopanel);
            MKInfoPanelDialog.show();
            slideUpAnimation = AnimationUtils.loadAnimation(act.getApplicationContext(),
                    R.anim.slide_up_map);

            RelativeLayout layout_info_panel = (RelativeLayout) MKInfoPanelDialog.findViewById(R.id.layout_info_panel);
            layout_info_panel.startAnimation(slideUpAnimation);

            layout_info_panel.setBackgroundResource(R.color.black);

            TextView subtitle = (TextView)MKInfoPanelDialog.findViewById(R.id.subtitle);
            subtitle.setText(message);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    try {
                        if(MKInfoPanelDialog.isShowing() && !act.isFinishing())
                            MKInfoPanelDialog.cancel();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 2000);

        }
    }



    public static void showMKPanelError(final Activity act, String message, final RelativeLayout rlMainView, TextView tvTitle, Typeface typeface) {
        if (!act.isFinishing() && (rlMainView.getVisibility() == View.GONE)) {

            Log.d("rlMainView", "rlMainView = " + rlMainView.getVisibility() + "==" + View.GONE);
            if ((rlMainView.getVisibility() == View.GONE)) {
                rlMainView.setVisibility(View.VISIBLE);
            }

            rlMainView.setBackgroundResource(R.color.black);
            tvTitle.setText(message);

            tvTitle.setTypeface(typeface);
            Animation slideUpAnimation = AnimationUtils.loadAnimation(act.getApplicationContext(), R.anim.slide_up_map);
            rlMainView.startAnimation(slideUpAnimation);

        }
    }

    public static void ValidationGone(final Activity activity, final RelativeLayout rlMainView, EditText edt_reg_username){
        edt_reg_username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("charSequence","charSequence = "+charSequence.length()+"=="+rlMainView.getVisibility()+"=="+View.VISIBLE);
                if(charSequence.length() > 0 && rlMainView.getVisibility() == View.VISIBLE){
                    if(!activity.isFinishing()){
                        TranslateAnimation slideUp = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -100);
                        slideUp.setDuration(10);
                        slideUp.setFillAfter(true);
                        rlMainView.startAnimation(slideUp);
                        slideUp.setAnimationListener(new Animation.AnimationListener() {

                            @Override
                            public void onAnimationStart(Animation animation) {
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                rlMainView.setVisibility(View.GONE);
                            }
                        });

                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public static boolean checkAndRequestPermissions(Activity activity)
    {

        int sms = ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_SMS);
        int loc = ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION);
        int loc2 = ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION);
        List<String> listPermissionsNeeded = new ArrayList<>();

        if (sms != PackageManager.PERMISSION_GRANTED)
        {
            listPermissionsNeeded.add(Manifest.permission.READ_SMS);
        }
        if (loc != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (loc2 != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }
        if (!listPermissionsNeeded.isEmpty())
        {
            ActivityCompat.requestPermissions(activity,listPermissionsNeeded.toArray(new
                    String[listPermissionsNeeded.size()]),3);
            return false;
        }
        return true;
    }

}
