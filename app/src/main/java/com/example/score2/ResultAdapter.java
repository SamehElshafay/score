package com.example.score2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ResultAdapter extends BaseAdapter {
    private Context con ;
    private ArrayList<Match> matchs = new ArrayList<>();

    ResultAdapter(ArrayList<Match> matchs , Context con ){
        this.matchs = matchs ;
        this.con = con ;
    }

    @Override
    public int getCount() {
        return matchs.size() ;
    }
    
    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(con).inflate(R.layout.result_card, parent , false);
        }
        TextView player1name = convertView.findViewById(R.id.player1Name);
        player1name.setText(matchs.get(position).getPlayer1());

        TextView player2name = convertView.findViewById(R.id.player2Name);
        player2name.setText(matchs.get(position).getPlayer2());



        ImageView player1image = convertView.findViewById(R.id.player1Image);
        Picasso.get().load(matchs.get(position).getPlayer1Image()).into(player1image);

        ImageView player2image = convertView.findViewById(R.id.player2Image);
        Picasso.get().load(matchs.get(position).getPlayer2Image()).into(player2image);



        TextView result1 = convertView.findViewById(R.id.result1);
        result1.setText(matchs.get(position).getPlayer1Goals());

        TextView result2 = convertView.findViewById(R.id.result2);
        result2.setText(matchs.get(position).getPlayer2Goals());


        String datet[] = matchs.get(position).getDate().split(" ");
        TextView dateText = convertView.findViewById(R.id.date);
        dateText.setText(datet[0] + "\n" + datet[1]);


        return convertView ;
    }
}
