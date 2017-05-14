package hu.gearxpert.tiszaujvarostourguide;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by melinda.kostenszki on 2017.05.09..
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    public PlaceAdapter(Activity context, ArrayList<Place> places) {
        super(context, 0, places);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the Place object located at this position in the list
        Place currentPlace = getItem(position);

        /**
         * These information will be displayed in the list_item xml
         */

            // Find the TextView in the layout with the ID name_text_view, and set the name
            TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
            nameTextView.setText(currentPlace.getName());

            // Find the TextView in the layout with the ID address_text_view, and set the address
            TextView addressTextView = (TextView) listItemView.findViewById(R.id.address_text_view);
            addressTextView.setText(currentPlace.getAddress());


            // Find the ImageView in the list_item.xml layout with the ID image, and set the small image
            ImageView smallImageTextView = (ImageView) listItemView.findViewById(R.id.image);
            smallImageTextView.setImageResource(currentPlace.getSmallImageResourceId());

        // Return the whole list item layout
        return listItemView;
    }
}
