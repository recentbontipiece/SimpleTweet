package com.codepath.apps.restclienttemplate;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.codepath.apps.restclienttemplate.models.Tweet;
import com.codepath.apps.restclienttemplate.util.Util;
import java.util.List;

public class TweetsAdapter extends  RecyclerView.Adapter<TweetsAdapter.ViewHolder> {


    //Pass in the context and list of tweets
    Context context;
    List<Tweet> tweets;

    private final String TAG = TweetsAdapter.class.getName();


    public TweetsAdapter(Context context, List<Tweet> tweets){
      this.context = context;
      this.tweets = tweets;
    }


    //for each row, inflate the Layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
        return new ViewHolder(view);
    }


    //Bind values based on the position
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      //Get the Data at position
      Tweet tweet = tweets.get(position);
      holder.bind(tweet);
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    //Define of viewHolder
    public class  ViewHolder extends RecyclerView.ViewHolder {
    ImageView ivProfileImage;
    TextView tvBody;
    TextView tvScreenName;

      public ViewHolder(@NonNull View itemView) {
         super(itemView);
         ivProfileImage = itemView.findViewById(R.id.imgProfile);
         tvScreenName   = itemView.findViewById(R.id.txtScreenName);
         tvBody         = itemView.findViewById(R.id.txtBody);
      }

      //    public static void loadImage(ImageView img, String url){
      public void bind(Tweet tweet) {
         tvBody.setText(tweet.body);
         tvScreenName.setText(tweet.user.screenName);
         Util.loadImage(ivProfileImage, tweet.user.profileImageUrl);
      }
    }




}
