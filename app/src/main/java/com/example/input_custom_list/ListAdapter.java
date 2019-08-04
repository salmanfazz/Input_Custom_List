package com.example.input_custom_list;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

//Extend
public class ListAdapter extends ArrayAdapter<Hero> {

    //List -> Hero
    List<Hero> heroList;

    //Activity Context
    Context context;

    //Resource file -> item
    int resource;

    //Initializing
    public ListAdapter(Context context, int resource, List<Hero>heroList) {
        super(context, resource, heroList);
        this.context = context;
        this.resource = resource;
        this.heroList = heroList;
    }

    //Return ListView Item as View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Get View xml
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //Get View
        View view = layoutInflater.inflate(resource, null, false);

        //Get View element
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewTeam = view.findViewById(R.id.textViewTeam);
        Button buttonDelete = view.findViewById(R.id.buttonDelete);

        //Get hero position
        Hero hero = heroList.get(position);

        //Add values to list item
        imageView.setImageDrawable(context.getResources().getDrawable(hero.getImage()));
        textViewName.setText(hero.getName());
        textViewTeam.setText(hero.getTeam());

        //Click listener for delete
        buttonDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Method remove
                removeHero(position);
            }
        });
        //Return the view
        return view;
    }
    //Remove item from list
    private void removeHero(final int position) {
        //Alert
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are You Sure want to Delete this?");

        //Alert positive respond
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface,int i){
                //Remove
                heroList.remove(position);
                //Reload
                notifyDataSetChanged();
            }
        });
        //Alert negative respond
        builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {

            }
        });

        //Display alert
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}