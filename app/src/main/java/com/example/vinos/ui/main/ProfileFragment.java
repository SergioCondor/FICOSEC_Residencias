package com.example.vinos.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.vinos.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {//@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the activity_login for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}
