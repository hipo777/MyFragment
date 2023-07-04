package org.demre.myfragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.demre.myfragment.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {
    /*public FirstFragment() {
        // Required empty public constructor
    }*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentFirstBinding binding = FragmentFirstBinding.inflate(getLayoutInflater(), container, false);
        binding.btnIrWeb.setOnClickListener(v -> {
            String url = binding.editTextWeb.getText().toString();

            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                    SecondFragment.newInstance(url, ""), "").commit();

        });
        return binding.getRoot();
    }
}