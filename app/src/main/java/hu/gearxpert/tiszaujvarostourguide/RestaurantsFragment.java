package hu.gearxpert.tiszaujvarostourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {


    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Creates a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.string.r_name_1, R.string.r_address_1, R.string.r_phone_1, R.string.r_web_1, 47.935618, 21.035159, R.string.r_description_1, R.drawable.scarpa1, R.drawable.scarpa2));
        places.add(new Place(R.string.r_name_2, R.string.r_address_2, R.string.r_phone_2, R.string.r_web_2, 47.929097, 21.041575, R.string.r_description_2, R.drawable.mamma1, R.drawable.mamma2));
        places.add(new Place(R.string.r_name_3, R.string.r_address_3, R.string.r_phone_3, R.string.r_web_3, 47.910563, 21.075745, R.string.r_description_3, R.drawable.sziget1, R.drawable.sziget2));
        places.add(new Place(R.string.r_name_4, R.string.r_address_4, R.string.r_phone_4, R.string.r_web_4, 47.928318, 21.044218, R.string.r_description_4, R.drawable.nadas1, R.drawable.nadas2));
        places.add(new Place(R.string.r_name_5, R.string.r_address_5, R.string.r_phone_5, R.string.r_web_5, 47.931353, 21.035263, R.string.r_description_5, R.drawable.hollo1, R.drawable.hollo2));
        places.add(new Place(R.string.r_name_6, R.string.r_address_6, R.string.r_phone_6, R.string.r_web_6, 47.932562, 21.034258, R.string.r_description_6, R.drawable.lili1, R.drawable.lili2));
        places.add(new Place(R.string.r_name_7, R.string.r_address_7, R.string.r_phone_7, R.string.r_web_7, 47.933086, 21.038916, R.string.r_description_7, R.drawable.megzabal1, R.drawable.megzabal2));
        places.add(new Place(R.string.r_name_8, R.string.r_address_8, R.string.r_phone_8, R.string.r_web_8, 47.934328, 21.039482, R.string.r_description_8, R.drawable.castello1, R.drawable.castello2));

        // Creates a PlaceAdapter, whose data source is a list of Places. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        // Finds the ListView with the view ID called list, which is declared in the
        // place_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Makes the ListView use the PlaceAdapter, so that the ListView will display
        // list items for each Place in the list.
        listView.setAdapter(adapter);

        // Set a click listener to open a new screen when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the Place object at the given position the user clicked on
                Place place = places.get(position);
                Intent intent = new Intent(getActivity(), InfoPage.class);
                intent.putExtra("NAME", place.getName());
                intent.putExtra("ADDRESS", place.getAddress());
                intent.putExtra("PHONE_NUMBER", place.getPhoneNumber());
                intent.putExtra("WEBPAGE", place.getWebPage());
                intent.putExtra("DESCRIPTION", place.getDescription());
                intent.putExtra("BIG_IMAGE", place.getBigImageResourceId());
                intent.putExtra("MAP1", place.getMap1());
                intent.putExtra("MAP2", place.getMap2());
                startActivity(intent);
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
    }

}
