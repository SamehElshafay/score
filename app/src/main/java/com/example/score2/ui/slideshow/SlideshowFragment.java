package com.example.score2.ui.slideshow;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.score2.Firebase;
import com.example.score2.MainActivity;
import com.example.score2.R;
import com.example.score2.User;
import com.example.score2.databinding.ActivityMainPageBinding;
import com.example.score2.mainPage;
import com.example.score2.showKeyActivity;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class SlideshowFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slideshow , container , false);


        String username = "" ;
        try {
            username = MainActivity.username;
        }catch (Exception ex){
            username = showKeyActivity.username;
        }


        Firebase firebase = new Firebase();
        firebase.getAllUserInformation(username.replace(" " , ""));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                User user = firebase.getUser();
                String username = user.getName() ;
                String matches = user.getMatchs() ;
                String imageLink = user.getImage() ;
                int noOfMatches = matches.split(" ").length ;
                double winPercentage  = Double.parseDouble(new DecimalFormat("##.##").format((Double.parseDouble(user.getWin())*100 )/noOfMatches));
                double losePercentage = Double.parseDouble(new DecimalFormat("##.##").format((Double.parseDouble(user.getLose())*100)/noOfMatches));
                double drawPercentage = Double.parseDouble(new DecimalFormat("##.##").format((Double.parseDouble(user.getDraw())*100)/noOfMatches));
                int goal = Integer.parseInt(user.getGoal());
                int goalIn = Integer.parseInt(user.getGoalIn());
                int goalD = goal - goalIn ;
                int cleansheets = Integer.parseInt(user.getCleansheets());
                int points = Integer.parseInt(user.getPoints());
                int rank = Integer.parseInt(user.getRank());



                ((TextView)view.findViewById(R.id.textWinDEC)) .setText(String.valueOf(Integer.parseInt(user.getWin())) + " match");
                ((TextView)view.findViewById(R.id.textLoseDEC)).setText(String.valueOf(Integer.parseInt(user.getLose()))+ " match");
                ((TextView)view.findViewById(R.id.textDrawDEC)).setText(String.valueOf(Integer.parseInt(user.getDraw()))+ " match");

                ((TextView)view.findViewById(R.id.percentageWin)).setText(String.valueOf(winPercentage)+"%");
                ((TextView)view.findViewById(R.id.percentageDraw)).setText(String.valueOf(drawPercentage)+"%");
                ((TextView)view.findViewById(R.id.percentageLose)).setText(String.valueOf(losePercentage)+"%");

                ProgressBar progressWin = view.findViewById(R.id.progressWin);
                ProgressBar progressDraw = view.findViewById(R.id.progressDraw);
                ProgressBar progressLose = view.findViewById(R.id.progressLose);

                progressWin.setProgress((int) winPercentage);
                progressLose.setProgress((int) losePercentage);
                progressDraw.setProgress((int) drawPercentage);

                ((TextView)view.findViewById(R.id.percentageGF)).setText(String.valueOf(goal));
                ((TextView)view.findViewById(R.id.percentageGA)).setText(String.valueOf(goalIn));
                ((TextView)view.findViewById(R.id.percentageGD)).setText(String.valueOf(goalD));

                ((TextView)view.findViewById(R.id.percentageCLEANSHEETS)).setText(String.valueOf(cleansheets));
                ((TextView)view.findViewById(R.id.percentagePOINTS)).setText(String.valueOf(points));
                ((TextView)view.findViewById(R.id.percentageMATCHES)).setText(String.valueOf(noOfMatches));

                ((TextView)view.findViewById(R.id.player_profile_username)).setText(username);
                ((TextView)view.findViewById(R.id.RANK)).setText(String.valueOf(rank));
                Picasso.get().load(imageLink).into((ImageView) view.findViewById(R.id.player_profile_img));
            }

        }, 2000);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //binding = null;
    }
}