package com.desai.vatsal.mydynamictoast;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by vatsaldesai on 14-11-2016.
 */

public class MyDynamicToast {

    private static Context context;
    private static Toast toast;
    private static View toastRoot;
    private static ImageView iv_top_icon;
    private static ImageView iv_left_icon;
    private static ImageView iv_right_icon;
    private static ImageView iv_bottom_icon;
    private static TextView tv_msg;
    private static LinearLayout parent_layout;

    public static final int LENGTH_SHORT = Toast.LENGTH_SHORT;
    public static final int LENGTH_LONG = Toast.LENGTH_LONG;
    public static final int LENGTH_DEFAULT = LENGTH_SHORT;
    public static final String POSITION_LEFT = "left";
    public static final String POSITION_RIGHT = "right";
    public static final String POSITION_TOP = "top";
    public static final String POSITION_BOTTOM = "bottom";



    private static void init(Context context) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        toastRoot = inflater.inflate(R.layout.my_dynamic_toast, null);

        iv_top_icon = (ImageView) toastRoot.findViewById(R.id.iv_top_icon);
        iv_left_icon = (ImageView) toastRoot.findViewById(R.id.iv_left_icon);
        iv_right_icon = (ImageView) toastRoot.findViewById(R.id.iv_right_icon);
        iv_bottom_icon = (ImageView) toastRoot.findViewById(R.id.iv_bottom_icon);
        tv_msg = (TextView) toastRoot.findViewById(R.id.tv_msg);
        parent_layout = (LinearLayout) toastRoot.findViewById(R.id.parent_layout);
    }

    public static void errorMessage(Context context, String errorMsg) {
        errorMessage(context, errorMsg, LENGTH_DEFAULT);
    }

    public static void errorMessage(Context context, String errorMsg, int showtime) {

        init(context);

        iv_top_icon.setVisibility(View.GONE);
        iv_left_icon.setVisibility(View.VISIBLE);
        iv_right_icon.setVisibility(View.GONE);
        iv_bottom_icon.setVisibility(View.GONE);

        iv_left_icon.setImageResource(R.drawable.ic_error);
        tv_msg.setText(errorMsg);
        tv_msg.setTextColor(Color.WHITE);
        tv_msg.setTextSize(16);

//        parent_layout.setBackgroundDrawable(createToastBackground(context, parent_layout));
        parent_layout.setBackgroundResource(R.drawable.error_message_background);

        toast = new Toast(context);
        toast.setView(toastRoot);
        toast.setDuration(showtime);
        toast.show();

    }

    public static void warningMessage(Context context, String warningMsg) {
        warningMessage(context, warningMsg, LENGTH_DEFAULT);
    }

    public static void warningMessage(Context context, String warningMsg, int showtime) {

        init(context);

        iv_top_icon.setVisibility(View.GONE);
        iv_left_icon.setVisibility(View.VISIBLE);
        iv_right_icon.setVisibility(View.GONE);
        iv_bottom_icon.setVisibility(View.GONE);

        iv_left_icon.setImageResource(R.drawable.ic_warning);
        tv_msg.setText(warningMsg);
        tv_msg.setTextColor(Color.WHITE);
        tv_msg.setTextSize(16);

        parent_layout.setBackgroundResource(R.drawable.warning_message_background);

        toast = new Toast(context);
        toast.setView(toastRoot);
        toast.setDuration(showtime);
        toast.show();

    }

    public static void successMessage(Context context, String successMsg) {
        successMessage(context, successMsg, LENGTH_DEFAULT);
    }

    public static void successMessage(Context context, String successMsg, int showtime) {

        init(context);

        iv_top_icon.setVisibility(View.GONE);
        iv_left_icon.setVisibility(View.VISIBLE);
        iv_right_icon.setVisibility(View.GONE);
        iv_bottom_icon.setVisibility(View.GONE);

        iv_left_icon.setImageResource(R.drawable.ic_success);
        tv_msg.setText(successMsg);
        tv_msg.setTextColor(Color.WHITE);
        tv_msg.setTextSize(16);

        parent_layout.setBackgroundResource(R.drawable.success_message_background);

        toast = new Toast(context);
        toast.setView(toastRoot);
        toast.setDuration(showtime);
        toast.show();

    }

    public static void informationMessage(Context context, String informationMsg) {
        informationMessage(context, informationMsg, LENGTH_DEFAULT);
    }

    public static void informationMessage(Context context, String informationMsg, int showtime) {

        init(context);

        iv_top_icon.setVisibility(View.GONE);
        iv_left_icon.setVisibility(View.VISIBLE);
        iv_right_icon.setVisibility(View.GONE);
        iv_bottom_icon.setVisibility(View.GONE);

        iv_left_icon.setImageResource(R.drawable.ic_info);
        tv_msg.setText(informationMsg);
        tv_msg.setTextColor(Color.WHITE);
        tv_msg.setTextSize(16);

        parent_layout.setBackgroundResource(R.drawable.info_message_background);

        toast = new Toast(context);
        toast.setView(toastRoot);
        toast.setDuration(showtime);
        toast.show();

    }


    private static Drawable createToastBackground(Context context, View view) {

        Bitmap bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.RED);

        //border's properties
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(8);
        paint.setStyle(Paint.Style.STROKE);

        RectF rectangle = new RectF(0 - 3, 0, canvas.getWidth() + 3, canvas.getHeight());

        int cornerRadius = 50;

//        canvas.drawRect(rectangle, paint);
        canvas.drawRoundRect(rectangle, cornerRadius, cornerRadius, paint);


        BitmapDrawable drawable = new BitmapDrawable(context.getResources(), bitmap);


        return drawable;
    }


}
