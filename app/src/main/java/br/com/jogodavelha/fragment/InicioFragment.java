package br.com.jogodavelha.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.jogodavelha.R;
import br.com.jogodavelha.databinding.FragmentInicioBinding;
import br.com.jogodavelha.databinding.FragmentJogoBinding;
import br.com.jogodavelha.util.PrefsUtil;


public class InicioFragment extends Fragment {
    private FragmentInicioBinding binding;
    public InicioFragment() {
        // Required empty public constructor

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentInicioBinding.inflate(inflater,container,false);
        binding.btIniciar.setOnClickListener(v -> {
            PrefsUtil.setNumRodadas("7", getContext());
            NavHostFragment.findNavController(InicioFragment.this).
                    navigate(R.id.action_inicioFragment_to_jogoFragment);
        });
        return binding.getRoot();
    }
    @Override
    public void onStart(){
        super.onStart();
        //pega a referenia para a activity
        AppCompatActivity minhaActivity = (AppCompatActivity) getActivity();
        //oculta a action bar
        minhaActivity.getSupportActionBar().hide();

    }




}