package net.lrivas.reproductordemusica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;



    ArrayList<canlist> listacancion;
    TextView txcancion,txplays,txartis, txplay, txp;
    CardView card;
    ImageView imgcover,prew,next,play;
    RecyclerView recyclerView;



    static void enableInmersiveMode(Activity act, boolean drawBehindNavBar) {
        View rootView = act.getWindow().getDecorView().getRootView();
        int uiFlags = rootView.getSystemUiVisibility();
        int flags =0;
        if(drawBehindNavBar) { flags = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION; }
        flags = flags | uiFlags | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
        rootView.setSystemUiVisibility(flags);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        enableInmersiveMode(this, true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txcancion = findViewById(R.id.txtplaycan);
        txartis = findViewById(R.id.txtplayart);
        txplay = findViewById(R.id.txplays);
        txplays = findViewById(R.id.textView);
        prew = findViewById(R.id.imageViewprew);
        next = findViewById(R.id.imageViewnext);
        play = findViewById(R.id.imageViewplay);
        imgcover = findViewById(R.id.imageView3);

        prew.setVisibility(View.INVISIBLE);
        next.setVisibility(View.INVISIBLE);
        play.setVisibility(View.INVISIBLE);
        txplays.setVisibility(View.INVISIBLE);
    listacancion = new ArrayList<>();
    recyclerView = findViewById(R.id.rcanciones);

    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    
    cargarlista();

     adap adapter = new adap(listacancion);
     registerForContextMenu(recyclerView);


        adapter.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

            txcancion.setText(listacancion.get(recyclerView.getChildAdapterPosition(v)).getCancion());

            imgcover.setImageResource(listacancion.get(recyclerView.getChildAdapterPosition(v)).getImg());
            txartis.setText(listacancion.get(recyclerView.getChildAdapterPosition(v)).getArtista());
            txplay.setText(listacancion.get(recyclerView.getChildAdapterPosition(v)).getCancion());
            txcancion.setTextColor(getResources().getColor(R.color.buttons));
           
            //i=0;
            //txcancion.setText(Integer.toString(id.getAdapterPosition()));
            if (player!=null){
                if (player.isPlaying()){
                    player.release();
                    player = null;
                }
            }

            player = MediaPlayer.create(MainActivity.this, listacancion.get(recyclerView.getChildAdapterPosition(v)).getMusica());
            player.start();
            play.setImageResource(R.drawable.ic_action_musicstop);

             play.setVisibility(View.VISIBLE);
             txplays.setVisibility(View.VISIBLE);

         }


     });

     play.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            if (player.isPlaying()){
                //player.seekTo(000);
                player.pause();
                play.setImageResource(R.drawable.ic_action_play);
            }else{
                player.start();
                play.setImageResource(R.drawable.ic_action_musicstop);
            }

         }
     });


     recyclerView.setAdapter(adapter);



    }

    private void cargarlista() {

        listacancion.add(new canlist( getString( R.string.cancion_1), getString( R.string.album_1), getString(R.string.artista_1), R.drawable.cover1, R.raw.music1));
        listacancion.add(new canlist( getString( R.string.cancion_2), getString( R.string.album_2), getString(R.string.artista_2), R.drawable.cover2, R.raw.music2));
        listacancion.add(new canlist( getString( R.string.cancion_3), getString( R.string.album_3), getString(R.string.artista_3), R.drawable.cover3,R.raw.music3));
        listacancion.add(new canlist( getString( R.string.cancion_4), getString( R.string.album_4), getString(R.string.artista_4), R.drawable.cover5,R.raw.music4));
        listacancion.add(new canlist( getString( R.string.cancion_5), getString( R.string.album_5), getString(R.string.artista_5), R.drawable.cover6,R.raw.music5));

    }
}