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
public class HotelsFragment extends Fragment {


    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.string.h_name_1, R.string.h_address_1, R.string.h_phone_1, R.string.h_web_1, 47.925999, 21.042791, R.string.h_description_1, R.drawable.veronika1, R.drawable.veronika2));
        places.add(new Place(R.string.h_name_2, R.string.h_address_2, R.string.h_phone_2, R.string.h_web_2, 47.931522, 21.037803, R.string.h_description_2, R.drawable.phonix1, R.drawable.phonix2));
        places.add(new Place(R.string.h_name_3, R.string.h_address_3, R.string.h_phone_3, R.string.h_web_3, 47.934709, 21.043667, R.string.h_description_3, R.drawable.garden1, R.drawable.garden2));
        places.add(new Place(R.string.h_name_4, R.string.h_address_4, R.string.h_phone_4, R.string.h_web_4, 47.936539, 21.030499, R.string.h_description_4, R.drawable.szalay1, R.drawable.szalay2));
        places.add(new Place(R.string.h_name_5, R.string.h_address_5, R.string.h_phone_5, R.string.h_web_5, 47.939945, 21.032897, R.string.h_description_5, R.drawable.kertvarosi1, R.drawable.kertvarosi2));

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