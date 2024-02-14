package ws.wolfsoft.e_books;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;

public class BookReadingActivity extends AppCompatActivity implements View.OnClickListener {


    TextView copytv;

    BottomBar bottomBar;

    boolean isSelected = false;


    private static final String SCREEN_BRIGHTNESS_VALUE_PREFIX = "Current device screen brightness value is ";


    SeekBar seekBar;
    TextView txtSeekBar;
    int textSize = 18;
    int saveProgress;

    private SharedPreferences prefs;


    TextView textView;

    Dialog slideDialog;

    LinearLayout linear1, linear2, linear3, linear4, linear;
    ImageView image1, image2, image3, image4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_reading);

        txtSeekBar = (TextView) findViewById(R.id.text);
        txtSeekBar.setTextIsSelectable(true);


        linear1 = findViewById(R.id.linear1);
        linear2 = findViewById(R.id.linear2);
        linear3 = findViewById(R.id.linear3);
        linear4 = findViewById(R.id.linear4);
        linear = findViewById(R.id.linear);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);


        linear1.setOnClickListener(this);
        linear2.setOnClickListener(this);
        linear3.setOnClickListener(this);
        linear4.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.linear1:


                if (!isSelected) {
                    linear.setBackgroundColor(Color.parseColor("#fffbe7"));

                    image1.setImageResource(R.drawable.ic_eye_orange);
                    image2.setImageResource(R.drawable.ic_font_1);
                    image3.setImageResource(R.drawable.ic_brightness_1);
                    image4.setImageResource(R.drawable.ic_zoom_1);

                    isSelected = true;
                } else if (isSelected) {
                    linear.setBackgroundColor(Color.parseColor("#ffffff"));

                    image1.setImageResource(R.drawable.ic_eye_1);
                    image2.setImageResource(R.drawable.ic_font_1);
                    image3.setImageResource(R.drawable.ic_brightness_1);
                    image4.setImageResource(R.drawable.ic_zoom_1);

                    isSelected = false;
                }


                break;


            case R.id.linear2:
                linear.setBackgroundColor(Color.parseColor("#ffffff"));

                image1.setImageResource(R.drawable.ic_eye_1);
                image2.setImageResource(R.drawable.ic_font_orange);
                image3.setImageResource(R.drawable.ic_brightness_1);
                image4.setImageResource(R.drawable.ic_zoom_1);


                slideDialog = new Dialog(BookReadingActivity.this, R.style.CustomDialogAnimation);
                slideDialog.setContentView(R.layout.zooming_popup1);
                slideDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams();
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                slideDialog.getWindow().getAttributes().windowAnimations = R.style.CustomDialogAnimation;
                layoutParams.copyFrom(slideDialog.getWindow().getAttributes());


                seekBar = (SeekBar) slideDialog.findViewById(R.id.seekBar1);


                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()


                {


                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {


                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        textSize = textSize + (progress - saveProgress);
                        saveProgress = progress;
                        txtSeekBar.setTextSize(textSize);


                    }
                });


                // int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.85);
                int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.18);


                layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                layoutParams.height = height;
                // layoutParams.width = width;
                layoutParams.gravity = Gravity.BOTTOM;


                slideDialog.getWindow().setAttributes(layoutParams);
                slideDialog.setCancelable(true);
                slideDialog.setCanceledOnTouchOutside(true);
                slideDialog.show();

                break;

            case R.id.linear3:

                image1.setImageResource(R.drawable.ic_eye_1);
                image2.setImageResource(R.drawable.ic_font_1);
                image3.setImageResource(R.drawable.ic_brightness_orange);
                image4.setImageResource(R.drawable.ic_zoom_1);

                slideDialog = new Dialog(BookReadingActivity.this, R.style.CustomDialogAnimation);
                slideDialog.setContentView(R.layout.zooming_popup);
                slideDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                setTitle("dev2qa.com - Seekbar Change Screen Brightness Example.");

                // Get display screen brightness value text view object.
                //final TextView screenBrightnessValueTextView = (TextView)findViewById(R.id.change_screen_brightness_value_text_view);

                // Get the seekbar instance.
                seekBar = (SeekBar) slideDialog.findViewById(R.id.seekBar1);
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                        Context context = getApplicationContext();

                        if (Build.VERSION.SDK_INT >= 23) {
                            // if (!Settings.canDrawOverlays(this)) {
                            //
                        } else {
                            // another similar method that supports device have API < 23
                        }

                        boolean canWriteSettings = Settings.System.canWrite(context);

                        if (canWriteSettings) {

                            // Because max screen brightness value is 255
                            // But max seekbar value is 100, so need to convert.
                            int screenBrightnessValue = i * 255 / 100;

                            // Set seekbar adjust screen brightness value in the text view.
                            //screenBrightnessValueTextView.setText(SCREEN_BRIGHTNESS_VALUE_PREFIX + screenBrightnessValue);

                            // Change the screen brightness change mode to manual.
                            Settings.System.putInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
                            // Apply the screen brightness value to the system, this will change the value in Settings ---> Display ---> Brightness level.
                            // It will also change the screen brightness for the device.
                            Settings.System.putInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, screenBrightnessValue);
                        } else {
                            // Show Can modify system settings panel to let user add WRITE_SETTINGS permission for this app.
                            Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                            context.startActivity(intent);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

                //Getting Current screen brightness.
                int currBrightness = Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 0);
                // Set current screen brightness value in the text view.
                // screenBrightnessValueTextView.setText( SCREEN_BRIGHTNESS_VALUE_PREFIX + currBrightness);
                // Set current screen brightness value to seekbar progress.
                seekBar.setProgress(currBrightness);


                WindowManager.LayoutParams layoutParams1 = new WindowManager.LayoutParams();
                slideDialog.getWindow().getAttributes().windowAnimations = R.style.CustomDialogAnimation;
                layoutParams1.copyFrom(slideDialog.getWindow().getAttributes());

                int width1 = (int) (getResources().getDisplayMetrics().widthPixels * 0.60);
                int height1 = (int) (getResources().getDisplayMetrics().heightPixels * 0.18);

                layoutParams1.width = WindowManager.LayoutParams.MATCH_PARENT;
                layoutParams1.height = height1;
                layoutParams1.gravity = Gravity.BOTTOM;


                slideDialog.getWindow().setAttributes(layoutParams1);
                slideDialog.setCancelable(true);
                slideDialog.setCanceledOnTouchOutside(true);
                slideDialog.show();


                break;

            case R.id.linear4:

                image1.setImageResource(R.drawable.ic_eye_1);
                image2.setImageResource(R.drawable.ic_font_1);
                image3.setImageResource(R.drawable.ic_brightness_1);
                image4.setImageResource(R.drawable.ic_zoom_orange);


                linear.setBackgroundColor(Color.parseColor("#ffffff"));

                slideDialog = new Dialog(BookReadingActivity.this, R.style.CustomDialogAnimation);
                slideDialog.setContentView(R.layout.zooming_popup2);
                slideDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
                slideDialog.getWindow().getAttributes().windowAnimations = R.style.CustomDialogAnimation;
                layoutParams2.copyFrom(slideDialog.getWindow().getAttributes());


                //  txtSeekBar.setTextScaleX(textSize);
                seekBar = (SeekBar) slideDialog.findViewById(R.id.seekBar1);
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    int p = 0;

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        // TODO Auto-generated method stub
                        if (p < 15) {
                            p = 15;
                            seekBar.setProgress(p);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        // TODO Auto-generated method stub
                    }

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        // TODO Auto-generated method stub
                        p = progress;
                        txtSeekBar.setTextSize(p);
                    }
                });


                int width2 = (int) (getResources().getDisplayMetrics().widthPixels * 0.60);
                int height2 = (int) (getResources().getDisplayMetrics().heightPixels * 0.18);

                layoutParams2.width = WindowManager.LayoutParams.MATCH_PARENT;
                layoutParams2.height = height2;
                layoutParams2.gravity = Gravity.BOTTOM;

                slideDialog.getWindow().setAttributes(layoutParams2);
                slideDialog.setCancelable(true);
                slideDialog.setCanceledOnTouchOutside(true);
                slideDialog.show();


                break;
        }
    }
}
