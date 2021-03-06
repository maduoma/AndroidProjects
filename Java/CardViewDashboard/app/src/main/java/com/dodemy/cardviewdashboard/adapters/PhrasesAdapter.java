package com.dodemy.cardviewdashboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.dodemy.cardviewdashboard.R;
import com.dodemy.cardviewdashboard.classes.Phrases;
import com.dodemy.cardviewdashboard.fragments.CustomFragment;

import java.util.ArrayList;

public class PhrasesAdapter extends ArrayAdapter<String> {
    private String categories;
    public PhrasesAdapter(Context context, int num, ArrayList<String> phrases) {
        super(context, 0, phrases);
        categories = CustomFragment.categories;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        int phraseIndex = position;
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.entry_item, parent, false);
        }
        // Lookup view for data population
        ImageView deleteItemImgView = convertView.findViewById(R.id.delete_item_imageview);
        TextView phrasesTxtView = convertView.findViewById(R.id.phrase_textview);
        deleteItemImgView.setImageResource(R.drawable.ic_delete_black_24dp);

        phrasesTxtView.setText(Phrases.allPhrases.get(categories).get(position));

        deleteItemImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Phrases.allPhrases.get(categories).remove(position);
                notifyDataSetChanged();
            }
        });

        // Return the completed view to render on screen
        return convertView;
    }
}