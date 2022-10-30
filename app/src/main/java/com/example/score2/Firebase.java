package com.example.score2;
import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.common.util.JsonUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class Firebase {
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance() ;
    private DatabaseReference databaseReference = firebaseDatabase.getReference("database") ;
    private String link = "";
    private String key ;
    private String password ;
    private String []playersMatch = new String[2];
    private User userInformation ;
    private User firstplayer ;
    private User secondPlayer ;
    private ArrayList<Match> matchs = new ArrayList<>();

    public Firebase(){ }

    public String addUser( String username , String password , String link){
        String key = databaseReference.push().getKey() ;
        User user = new User( username , password , generateKey(key) );
        user.setImage(link);
        databaseReference.child(username).setValue(user);
        return generateKey(key);
    }

    public String getPassword() {
        return password;
    }

    public void updatePassword(String username , String password){
        databaseReference.child(username).child("password").setValue(password);
    }

    public void getImage(String username){
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                link = dataSnapshot.child(username).child("image").getValue().toString() ;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void getKeyOfUser(String username) {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                try {
                    key = snapshot.child(username).child("key").getValue().toString() ;
                }catch (Exception ex){
                    key = "" ;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void getAllUserInformation(String username) {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                try {
                    userInformation = snapshot.child(username).getValue(User.class);
                } catch (Exception exception) {
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void getTheTwoUser(String username , String secondUsername) {
        System.out.println("**********************************");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                System.out.println("--------------------------------------");
                try {
                    firstplayer = snapshot.child(username).getValue(User.class);
                    secondPlayer = snapshot.child(secondUsername).getValue(User.class);
                    System.out.println(firstplayer.getImage()+" <===================");
                    System.out.println(firstplayer.getName()+" <===================");
                } catch (Exception exception) {
                    System.out.println(exception + " <===========");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("================> " + error );
            }
        });
    }

    public void getUserInformation(String username){
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                try {
                    password = snapshot.child(username).child("password").getValue().toString() ;
                    link     = snapshot.child(username).child("image").getValue().toString() ;
                }catch (Exception exception){

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public String getKey() {
        return key;
    }

    private String generateKey(String key) {
        return "" + key.charAt(6) + "" + key.charAt(1) + "" + key.charAt(2) + "" + key.charAt(3) +
        "" + key.charAt(4) + "" + key.charAt(5) ;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public User getUser() {
        return userInformation;
    }

    public void setUser(User userInformation) {
        this.userInformation = userInformation;
    }

    public void addMatch(Match match) {
        String key = "MATCH" + databaseReference.push().getKey() ;
        databaseReference.child(key).setValue(match);
        databaseReference.child(match.getPlayer2()).child("request").setValue(key + " " + match.getRequestsOfPlayer2());
    }

    public void getTwoPlayerMatchs(Match match){
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                try {
                    playersMatch[0] = snapshot.child(match.getPlayer1()).child("matchs").getValue().toString() ;
                    playersMatch[1] = snapshot.child(match.getPlayer2()).child("matchs").getValue().toString() ;
                }catch (Exception exception){

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void acceptRequest(Match match , String key , String request , String playersMatch[] ){
        match.getPlayer1();
        //old - key
        if(request.equals(null)){
            request = " " ;
        }
        databaseReference.child(match.getPlayer2()).child("request").setValue(request);
        //old + new
        databaseReference.child(match.getPlayer2()).child("matchs").setValue(key + " " + playersMatch[0]);
        databaseReference.child(match.getPlayer1()).child("matchs").setValue(key + " " + playersMatch[1]);
    }
    public void getMatchInformation(String []matchkey) {
        matchs.clear();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                try {
                    for(int i = 0 ; i < matchkey.length ; i++) {
                        matchs.add(snapshot.child(matchkey[i]).getValue(Match.class));
                    }
                } catch (Exception ex) {
                    System.out.println("???????????????????\n"+ex);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public User getFirstplayer() {
        return firstplayer;
    }

    public void setFirstplayer(User firstplayer) {
        this.firstplayer = firstplayer;
    }

    public User getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(User secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public ArrayList <Match> getMatch() {
        return matchs;
    }

    public void setMatch(ArrayList<Match> match) {
        this.matchs = match;
    }

    public String[] getPlayersMatch() {
        return playersMatch;
    }

    public void setPlayersMatch(String[] playersMatch) {
        this.playersMatch = playersMatch;
    }

}
