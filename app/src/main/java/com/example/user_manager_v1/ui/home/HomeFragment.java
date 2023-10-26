
package com.example.user_manager_v1.ui.home;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;

import com.example.user_manager_v1.R;
import com.example.user_manager_v1.SignInActivity;
import com.example.user_manager_v1.databinding.FragmentHomeBinding;

        public class HomeFragment extends Fragment {

            private FragmentHomeBinding binding;

            // put variables
            public View onCreateView(@NonNull LayoutInflater inflater,
                                     ViewGroup container, Bundle savedInstanceState) {

                HomeViewModel homeViewModel =
                        new ViewModelProvider(this).get(HomeViewModel.class);

                binding = FragmentHomeBinding.inflate(inflater, container, false);
                View root = binding.getRoot();

                final TextView textView = binding.textHome;
                homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

                TextView montantDesImayesTextView =(TextView) root.findViewById(R.id.Montant_des_imayes10);

                return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
/* Montant_des_imayes1 = root.findViewById(R.id.Montant_des_imayessss);
        Bundle args = getArguments();
        if (args != null) {
            Double montant_des_imayes = args.getDouble("montant_des_imayes", 0.0);
            Log.d("Debug", "montant_des_imayes: " + montant_des_imayes); // Log the value
            String textToDisplay = String.valueOf(montant_des_imayes);
            Log.d("Debug", "textToDisplay: " + textToDisplay); // Log the text
            Montant_des_imayes1.setText(textToDisplay);
        }*/
       /* Bundle args = getArguments();
        if (args != null) {
            double montantDesImayes = args.getDouble("montant_des_imayes", 0.0);// 0.0 is the default value if the argument is not provided.
            montantDesImayesTextView.setText("Montant des Imayes: " + montantDesImayes);
            // Now, you can use 'montantDesImayes' within your HomeFragment.
        }*/
       /* FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.nav_host_fragment_content_acceuil2, homeFragment);
        ft.commit();
        String montant_des_imayes = getArguments().getString("montant_des_imayes", "0");

*/
/*
                assert activity != null;
                Bundle results = activity.getMyData();
                String value1 = results.getString("val1");
                montantDesImayesTextView.setText(value1);

 */

// montantDesImayesTextView.setText("Montant des Imayes:");

                /*Bundle args = getArguments();
                if (args != null) {
                    double montant_des_imayes = args.getDouble("montant_des_imayes", 0.0);
                    // Add a log statement to print the value

                    String textToDisplay = "Montant des Imayes: " + montant_des_imayes;
                    Log.d("lyesfragmentlog", "textToDisplay: " + textToDisplay);
                    montantDesImayesTextView.setText(textToDisplay);
                }*/

/*
                Bundle bundle = getArguments();
                String message = bundle.getString("mText");
                Log.d("HomeFragment1002", "Fragment created");
                Log.d("lyesfragmentlog", "textToDisplay: " + strtext);// Add this line
*/


//View view = inflater.inflate(R.layout.fragment_home, container, false);
// SignInActivity activity = (SignInActivity) getActivity();
