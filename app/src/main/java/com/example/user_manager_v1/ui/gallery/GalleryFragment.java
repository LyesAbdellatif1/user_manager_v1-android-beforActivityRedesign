package com.example.user_manager_v1.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.user_manager_v1.BlankFragmentDetail1;
import com.example.user_manager_v1.R;
import com.example.user_manager_v1.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment implements View.OnClickListener{




    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel = new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        TextView MyTextView= (TextView) root.findViewById(R.id.buttongo345);
         MyTextView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 //setReorderingAllowed(true)

                 getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_acceuil2, new BlankFragmentDetail1() ).addToBackStack("state1").commit();
             }
         });









        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View v) {

    }
}