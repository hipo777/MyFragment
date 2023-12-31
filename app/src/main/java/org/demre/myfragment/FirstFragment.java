package org.demre.myfragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.demre.myfragment.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentFirstBinding binding = FragmentFirstBinding.inflate(getLayoutInflater(), container, false);
        binding.btnIrWeb.setOnClickListener(v -> {
            String url = binding.editTextWeb.getText().toString();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    SecondFragment.newInstance(url, ""), "").addToBackStack(null).commit();

        });
        return binding.getRoot();
    }
}