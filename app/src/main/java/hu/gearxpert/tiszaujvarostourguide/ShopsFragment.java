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
public class ShopsFragment extends Fragment {


    public ShopsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Creates a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.string.s_name_1, R.string.s_address_1, R.string.s_phone_1, R.string.s_web_1, 47.934096, 21.034960, R.string.s_description_1, R.drawable.spar1_1, R.drawable.spar1_2));
        places.add(new Place(R.string.s_name_2, R.string.s_address_2, R.string.s_phone_1, R.string.s_web_1, 47.933308, 21.0446932, R.string.s_description_2, R.drawable.spar2_1, R.drawable.spar2_2));
        places.add(new Place(R.string.s_name_3, R.string.s_address_3, R.string.s_phone_1, R.string.s_web_1, 47.935683, 21.038568, R.string.s_description_3, R.drawable.penny1, R.drawable.penny2));
        places.add(new Place(R.string.s_name_4, R.string.s_address_4, R.string.s_phone_1, R.string.s_web_1, 47.931579, 21.034584, R.string.s_description_4, R.drawable.coop1_1, R.drawable.coop1_2));
        places.add(new Place(R.string.s_name_5, R.string.s_address_5, R.string.s_phone_1, R.string.s_web_1, 47.933000, 21.030638, R.string.s_description_5, R.drawable.coop2_1, R.drawable.coop2_2));
        places.add(new Place(R.string.s_name_6, R.string.s_address_6, R.string.s_phone_1, R.string.s_web_1, 47.931852, 21.024026, R.string.s_description_6, R.drawable.tesco1, R.drawable.tesco2));
        places.add(new Place(R.string.s_name_7, R.string.s_address_7, R.string.s_phone_1, R.string.s_web_1, 47.937454, 21.028109, R.string.s_description_7, R.drawable.lidl1, R.drawable.lidl2));

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
