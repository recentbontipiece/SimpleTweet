package com.codepath.apps.restclienttemplate.util;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.codepath.apps.restclienttemplate.R;
//import androidx.swiperefreshlayout.widget.CircularProgressDrawable;


public class Util {


    //    public static void loadImage(ImageView img, String url, CircularProgressDrawable progressDrawable){
    public static void loadImage(ImageView img, String url){

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.loading_img)
                .error(R.drawable.ic_launcher);

        Glide.with(img.getContext())
                .setDefaultRequestOptions(options)
                .load(url)
                .into(img);
    }


//    public static CircularProgressDrawable getProgressDrawable(Context context){
//        CircularProgressDrawable cpd = new CircularProgressDrawable(context);
//        cpd.setStrokeWidth(10f);
//        cpd.setCenterRadius(50f);
//        cpd.start();
//        return cpd;
//    }
}
