package com.example.score2.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.score2.Firebase;
import com.example.score2.R;
import com.example.score2.ResultAdapter;
import com.example.score2.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home , container , false);

        Firebase firebase = new Firebase() ;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /*ListView lv = view.findViewById(R.id.resultList);
                ResultAdapter resultAdapter = new ResultAdapter(fb.getProductNames(), fb.getProductPrice(), fb.getProductPhotos(),
                        fb.getProductSale(), fb.getProductType(), getActivity());
                lv.setAdapter(resultAdapter);
                resultAdapter.notifyDataSetChanged();*/
            }
        },10);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}