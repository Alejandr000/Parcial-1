package net.lrivas.reproductordemusica;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adap extends RecyclerView.Adapter<adap.ViewHolder> implements View.OnClickListener {
    ArrayList<canlist> ListaCancion;
     View.OnClickListener listen;

    public adap(ArrayList<canlist> listaPersonaje) {
        ListaCancion = listaPersonaje;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listacancion, null, false);

        view.setOnClickListener(this);
        return new  ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      holder.cancion.setText(ListaCancion.get(position).getCancion());

      holder.album.setText( ListaCancion.get(position).getAlbum());

      holder.images.setImageResource(ListaCancion.get(position).getImg());



    }


    @Override
    public int getItemCount() {

        return ListaCancion.size();
    }

    public void setOnClickListener(View.OnClickListener listen) {
        this.listen = listen;
    }

    @Override
    public void onClick(View view) {
        if (listen != null){


            listen.onClick(view);

        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        CardView card;
        TextView cancion,album;
        ImageView images;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            cancion = itemView.findViewById(R.id.txtCan);
            album = itemView.findViewById(R.id.txtAlbum);
            images = itemView.findViewById(R.id.imgAlbum);






            itemView.setLongClickable(true);


        }


    }
}
