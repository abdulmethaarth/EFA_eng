package com.affinity.efasample.activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.affinity.efasample.Constants;
import com.affinity.efasample.RetrofitClient;
import com.affinity.efasample.adapter.BestSellCustomAdapter;
import com.affinity.efasample.adapter.CustomAdapter;
import com.affinity.efasample.adapter.Home_BannerAdapter;
import com.affinity.efasample.adapter.Home_CatAdapter;
import com.affinity.efasample.R;
import com.affinity.efasample.adapter.TrendCustomAdapter;
import com.affinity.efasample.models.HomeCatList;
import com.affinity.efasample.models.HomeCatlistDtls;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static android.os.Build.VERSION_CODES.M;
import static com.affinity.efasample.Constants.language;

public class MainActivity extends AppCompatActivity {

    //Featured
    int[] images = {R.drawable.banner4, R.drawable.banner3, R.drawable.banner2, R.drawable.banner};
    String [] rate = {"SAR 32","SAR 29","SAR 34","SAR 31"};
    String [] name = {"Women T-Shirt","Men T-Shirt","Women T-Shirt","Blezer"};
    RecyclerView lView;
    CustomAdapter lAdapter;

     //Home Cat list
  //  int[] first_list_images = {R.drawable.accessories_outline, R.drawable.perfume_outline, R.drawable.soap_making_outline, R.drawable.gardening_outline,R.drawable.accessories_outline};
   // String [] catname = {"Accessories","Perfume","Soap Making","Gardening path","Accessories"};
    RecyclerView homeCatListview;
    Home_CatAdapter homelistAdapter;
    private ArrayList<HomeCatlistDtls> homeCatDetailsList;

    //Banners
    int[] first_listbanner_images = {R.drawable.banner, R.drawable.banner3, R.drawable.banner2, R.drawable.banner4};
    RecyclerView first_listbanner;
    Home_BannerAdapter first_listbannerAdapter;

    //Best sell
    int[] best_images = {R.drawable.best_sell1, R.drawable.best_sell2, R.drawable.best_sell3, R.drawable.featured4};
    String [] best_rate = {"SAR 32","SAR 29","SAR 34","SAR 31"};
    String [] best_name = {"Women T-Shirt","Men T-Shirt","Women T-Shirt","Blezer"};
    RecyclerView Best_lView;
    BestSellCustomAdapter Best_lAdapter;

    //Trending
    int[] trend_images = {R.drawable.banner1, R.drawable.banner2, R.drawable.banner4, R.drawable.banner3};
    /* String [] trend_rate = {"$32","$29","$34","31"};
     String [] trend_name = {"Women T-Shirt","Men T-Shirt","Women T-Shirt","Blezer"};*/
    RecyclerView Trend_lView;
    TrendCustomAdapter Trend_lAdapter;

    TextView cat_all,feature_all,best_all,trend_all;
    ImageView cart,loc,btm_home,btm_save,btm_notify,btm_account;
    LinearLayout logout;
    ArrayList<String> permissions = new ArrayList<>();
    ArrayList<String> permissionsToRequest;
    boolean isGPS = false;
    private LocationManager locManager;
    boolean isNetwork = false;
    LocationManager locationManager;
    final String TAG = "GPS";
    ProgressDialog progress;
    String languages ;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progress = new ProgressDialog(this);
        progress.setMessage("Please Wait.. :)");

        SharedPreferences prefs = getSharedPreferences(Constants.MY_PREFS_NAME, MODE_PRIVATE);
        languages = prefs.getString(language, "");

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        ImageView relativeLayout = (ImageView) findViewById(R.id.side_menu);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        locationManager = (LocationManager) getSystemService(Service.LOCATION_SERVICE);
        isGPS = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        isNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        permissionsToRequest = findUnAskedPermissions(permissions);

        loc = (ImageView) findViewById(R.id.loc);
        cart = (ImageView)findViewById(R.id.cart);
        btm_home = (ImageView)findViewById(R.id.btm_home);
        btm_save = (ImageView)findViewById(R.id.btm_save);
        btm_notify = (ImageView)findViewById(R.id.btm_notify);
        btm_account = (ImageView)findViewById(R.id.btm_account);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddToCartActivity.class));
                finish();
            }
        });
        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddressActivity.class));
                finish();
            }
        });

        btm_home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, MainActivity.class));
                        finish();
                    }
                });

        btm_save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, ProductListActivity.class));
                        finish();
                    }
                });

        btm_notify.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, NotificationActivity.class));
                        finish();
                    }
                });

        btm_account.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                        finish();
                    }
                });


        logout = (LinearLayout)findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setTitle("Logout");
                alertDialogBuilder.setMessage("Are you sure you want to logout");
                alertDialogBuilder.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                startActivity(new Intent(MainActivity.this, Splash.class));
                                finish();

                            }
                        });

                alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                        /*Intent logout = new Intent(getApplicationContext(), AboutActivity.class);
                        startActivity(logout);*/
                drawerLayout.closeDrawers();

            }
        });

        homeCatList();


        first_listbanner = (RecyclerView) findViewById(R.id.first_listbanner);
        first_listbannerAdapter = new Home_BannerAdapter(MainActivity.this, first_listbanner_images);
        LinearLayoutManager filayoutM= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        first_listbanner.setAdapter(first_listbannerAdapter);
        first_listbanner.setLayoutManager(filayoutM);


        lView = (RecyclerView) findViewById(R.id.list);
        Trend_lAdapter = new TrendCustomAdapter(MainActivity.this, images);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        lView.setAdapter(Trend_lAdapter);
        lView.setLayoutManager(layoutManager);

        Best_lView = (RecyclerView) findViewById(R.id.list_best_sell);
        Best_lAdapter = new BestSellCustomAdapter(MainActivity.this, best_images,best_rate,best_name);
        LinearLayoutManager layoutManagers= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        Best_lView.setAdapter(Best_lAdapter);
        Best_lView.setLayoutManager(layoutManagers);

        Trend_lView = (RecyclerView) findViewById(R.id.list_trending);
        Trend_lAdapter = new TrendCustomAdapter(MainActivity.this, trend_images);
        LinearLayoutManager layoutMan= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        Trend_lView.setAdapter(Trend_lAdapter);
        Trend_lView.setLayoutManager(layoutMan);


        cat_all = (TextView)findViewById(R.id.cat_all);
        feature_all = (TextView)findViewById(R.id.feature_all);
        best_all = (TextView)findViewById(R.id.best_all);
        trend_all = (TextView)findViewById(R.id.trend_all);

/*        cat_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                productListScren();
            }
        });*/

        cat_all.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                    startActivity(intent);
                }
            });


        feature_all.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    productListScren();
                }
            });

         best_all.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    productListScren();
                }
            });

        trend_all.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    productListScren();
                }
            });
/*
        filter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Coming soon", Toast.LENGTH_SHORT).show();
                }
            });*/

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                final String appPackageName = getPackageName();

                switch (item.getItemId()) {

                    case R.id.fav:
                        Intent dash = new Intent(getApplicationContext(), ProductListActivity.class);
                        startActivity(dash);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.reset_pass:
                        Intent reset_pass = new Intent(getApplicationContext(), ForgotActivity.class);
                        startActivity(reset_pass);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.your_orders:
                        Intent payments = new Intent(getApplicationContext(), YourOrdersActivity.class);
                        startActivity(payments);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.cart:
                        Intent your_ride = new Intent(getApplicationContext(), AddToCartActivity.class);
                        startActivity(your_ride);
                        drawerLayout.closeDrawers();
                        break;


                    case R.id.home:


                        break;

                }
                return false;
            }
        });
    }

    private void homeCatList() {
        progress.show();
        Call<HomeCatList> call = RetrofitClient.getApiService().getHomeCat(languages);

        call.enqueue(new Callback<HomeCatList>() {
            @Override
            public void onResponse(Call<HomeCatList> call, Response<HomeCatList> response) {
                HomeCatList data = response.body();
                progress.cancel();
                if (data.status.equalsIgnoreCase("true")) {
                    homeCatDetailsList = response.body().getHomeCatlistDtls();
                    homeCatListview = (RecyclerView) findViewById(R.id.home_listcat);
                    homelistAdapter = new Home_CatAdapter(homeCatDetailsList);
                    RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getApplicationContext());
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                    if(languages.equalsIgnoreCase("ar")){
                        linearLayoutManager.setReverseLayout(true);
                    }else{
                        linearLayoutManager.setReverseLayout(false );
                    }
                    homeCatListview.setLayoutManager(linearLayoutManager);
                    homeCatListview.setItemAnimator(new DefaultItemAnimator());
                    homeCatListview.setAdapter(homelistAdapter);
                    homeCatListview.addOnItemTouchListener(new MainActivity.RecyclerTouchListener(MainActivity.this,
                            homeCatListview, new MainActivity.ClickListener() {
                        @Override
                        public void onClick(View view, final int position) {

                        }
                        @Override
                        public void onLongClick(View view, int position) {
                        }
                    }));
                }else{
                    progress.cancel();
                    Toast.makeText(MainActivity.this, "Fetching failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<HomeCatList> call, Throwable t) {
                progress.cancel();
                Toast.makeText(MainActivity.this, "Check your internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList findUnAskedPermissions(ArrayList<String> wanted) {
        ArrayList result = new ArrayList();

        for (String perm : wanted) {
            if (!hasPermission(perm)) {
                result.add(perm);
            }
        }

        return result;
    }

    private boolean hasPermission(String permission) {
        if (canAskPermission()) {
            if (Build.VERSION.SDK_INT >= JELLY_BEAN) {
                if (Build.VERSION.SDK_INT >= M) {
                    return (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED);
                }
            }
        }
        return true;
    }
    private boolean canAskPermission() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }
    private void productListScren() {
        Intent intent = new Intent(MainActivity.this,ProductListActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("EXIT ?")
                .setMessage("Are you sure you want exit?")
                .setNegativeButton("NO", null)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        finishAffinity();
                        System.exit(0);
                    }
                }).create().show();
    }

    //Recycler view clicking functions
    public static interface ClickListener{
        public void onClick(View view,int position);
        public void onLongClick(View view,int position);
    }


    class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {
        private MainActivity.ClickListener clicklistener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView recycleView, final MainActivity.ClickListener clicklistener) {
            this.clicklistener = clicklistener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recycleView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clicklistener != null) {
                        clicklistener.onLongClick(child, recycleView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child=rv.findChildViewUnder(e.getX(),e.getY());
            if(child!=null && clicklistener!=null && gestureDetector.onTouchEvent(e)){
                clicklistener.onClick(child,rv.getChildAdapterPosition(child));
            }
            return false;
        }
        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }
        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!isGPS && !isNetwork) {
            Log.d(TAG, "Connection off");
            Toast.makeText(MainActivity.this, "Please enable your GPS", Toast.LENGTH_LONG).show();
            Intent viewIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(viewIntent);
        } else {
            Log.d(TAG, "Connection on");
            // MarkerAdd();

        }if (checkPermissions(false)) {
            if (!locManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                Toast.makeText(MainActivity.this, "Please enable your GPS", Toast.LENGTH_LONG).show();
                Intent viewIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(viewIntent);
            }
        }

    }
    private static final String[] permission = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.CAMERA,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.ACCESS_WIFI_STATE,
    };
    private boolean checkPermissions(boolean checked) {
        if (checked) {
            ActivityCompat.requestPermissions(this, permission, 100);
        } else {
            for (String permiss : permission) {
                if (ActivityCompat.checkSelfPermission(this, permiss) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, permission, 100);
                    return false;
                }
            }
        }
        return true;
    }
}