package com.example.turismoapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.turismoapp.R;
import com.example.turismoapp.database.FirebaseGuardarLeer;
import com.example.turismoapp.database.Publicacion;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    public FirebaseGuardarLeer firebaseGuardarLeer;
    public static ListView ListPublicaciones;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        Relaciones(root);
        Eventos();

        return root;
    }

    public void Relaciones(View r){
        firebaseGuardarLeer = new FirebaseGuardarLeer();

        ListPublicaciones = r.findViewById(R.id.ListaPublicaciones);
        firebaseGuardarLeer.obtenerPublicaciones(ListPublicaciones,getContext());
    }

    public void Eventos(){
        /*guardarPublicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseGuardarLeer.nuevoPublicacion(cUser.getEmail(),"Ruta de la foto a cargar");
                Toast.makeText(getApplicationContext(),"Publicacion guardada",Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}