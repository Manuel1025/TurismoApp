package com.example.turismoapp.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.turismoapp.R;
import com.example.turismoapp.complementos.EstablecimientoAdapter;
import com.example.turismoapp.database.Establecimiento;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {
    private GalleryViewModel galleryViewModel;
    DatabaseReference myRef;
    public ListView ListHoteles;
    public ArrayList<Establecimiento> arrayListPub;
    ArrayAdapter arrayAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        Relaciones(root);
        CargarElementos();

        return root;
    }

    public void Relaciones(View r){
        arrayListPub = new ArrayList<Establecimiento>();
        ListHoteles = r.findViewById(R.id.ListaCaba);
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

    public void CargarElementos(){
        /*myRef.child("Hoteles").addValueEventListener(new ValueEventListener() {//Extraemos todas las publicaciones
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {*/
                //arrayListPub.clear();
                //for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    arrayListPub.add(new Establecimiento("Hotel lo lindo","Moñitos","Lo mas lindo que encontraras en este platanal"
                    ,"62000","3206738223","test@gmail.com","err/saad.jpg"));
                    arrayListPub.add(new Establecimiento("Hotel lo lindo","Moñitos","Lo mas lindo que encontraras en este platanal"
                ,"62000","3206738223","test@gmail.com","err/saad.jpg"));
                //}

                arrayAdapter = new EstablecimientoAdapter(getContext(), arrayListPub);
                ListHoteles.setAdapter(arrayAdapter);
            /*}

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("TAGLOG", "Error!", databaseError.toException());
            }
        });*/
    }
}