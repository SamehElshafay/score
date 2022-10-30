package com.example.score2.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.score2.Firebase;
import com.example.score2.MainActivity;
import com.example.score2.Match;
import com.example.score2.R;
import com.example.score2.Requests;
import com.example.score2.User;
import com.example.score2.databinding.FragmentGalleryBinding;
import com.example.score2.LoadingDialog;
import com.example.score2.showKeyActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GalleryFragment extends Fragment {
    private FragmentGalleryBinding binding;
    private Match match = new Match();
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery , container , false);
        Firebase firebase = new Firebase() ;
        String username = getUserName() ;
        final User[] player1 = new User[1];
        final User[] player2 = new User[1];


        LoadingDialog loadingDialog = new LoadingDialog(getActivity()) ;
        loadingDialog.startLoadingDialog();

        ((TextView)view.findViewById(R.id.firstPlayerName)).setText(username);
        firebase.getAllUserInformation(username);
        final String[] requests = {""};
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                requests[0] = firebase.getUser().getRequest();
                ((TextView) view.findViewById(R.id.RequestNumber)).setText("you have a " + requests[0].split(" ").length  + " request" );
                loadingDialog.dismisDialog();
            }
        }, 3000);

        ((EditText) view.findViewById(R.id.secondPlayerName)).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    try {
                        firebase.getTheTwoUser(username ,((EditText) view.findViewById(R.id.secondPlayerName)).getText().toString().replaceAll(" " , "") );
                    }catch (Exception ex){
                        Toast.makeText(getActivity() , "playerNotFound" ,Toast.LENGTH_LONG).show();
                    }
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            player1[0] = firebase.getFirstplayer();
                            player2[0] = firebase.getSecondPlayer();
                            match.setPlayer1(player1[0].getName());
                            match.setPlayer2(player2[0].getName());
                        }
                    }, 3000);
                }
            }
        });

        view.findViewById(R.id.SendRequest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                match.setPlayer1Goals(((EditText) view.findViewById(R.id.firstResult)).getText().toString());
                match.setPlayer2Goals(((EditText) view.findViewById(R.id.secondResult)).getText().toString());

                match.setPlayer1Image(player1[0].getImage());
                match.setPlayer2Image(player2[0].getImage());

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String date = simpleDateFormat.format(new Date());

                System.out.println(player2[0].getRequest() + " =========================");
                match.setRequestsOfPlayer2(player2[0].getRequest());
                match.setDate(date);

                firebase.addMatch(match);

                Toast.makeText(getActivity() , "request has successfuly sent" , Toast.LENGTH_LONG).show();

                ((EditText) view.findViewById(R.id.firstResult)).setText("");
                ((EditText) view.findViewById(R.id.secondResult)).setText("");
                ((EditText) view.findViewById(R.id.secondPlayerName)).setText("");
            }
        });


        view.findViewById(R.id.YourRequest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity() , Requests.class);
                intent.putExtra("key" , requests[0] );
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    String getUserName(){
        String userName = "" ;
        try {
            userName = MainActivity.username;
        }catch (Exception ex){
            userName = showKeyActivity.username;
        }
        return userName ;
    }
}