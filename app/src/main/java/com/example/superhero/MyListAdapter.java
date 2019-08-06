package com.example.superhero;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyListAdapter extends ArrayAdapter<Hero> {
    List<Hero> heroList;
    Context context;
    int resource;

    public MyListAdapter(Context context, int resource, List<Hero>
            heroList) {
        super(context, resource,heroList);
        this.context = context;
        this.resource = resource;
        this.heroList = heroList;
    }

    @NonNull
    @Override

    public View getView(final int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(resource,null,false);

        ImageView imageView = view.findViewById(R.id.img);
        TextView textViewName = view.findViewById(R.id.Judul);
        TextView textViewTeam = view.findViewById(R.id.Konten);
        Button btnDelete = view.findViewById(R.id.btnDelete1);

        Hero hero = heroList.get(position);

        imageView.setImageDrawable(context.getResources().getDrawable(hero.getImage()));
        textViewName.setText(hero.getName());
        textViewTeam.setText(hero.getTeam());

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeHero(position);
            }
        });
        return view;
    }
    private void removeHero(final int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Apakah kamu yakin akan menghapus ini?");

        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                heroList.remove(position);
                notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
