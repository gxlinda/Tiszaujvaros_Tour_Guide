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
public class BarsFragment extends Fragment {


    public BarsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.string.b_name_1, R.string.b_address_1, "+3649340331", "-", 47.932964, 21.038550, R.string.b_description_1, R.drawable.city1, R.drawable.city2));
        places.add(new Place(R.string.b_name_2, R.string.b_address_2, "+36205710341", "-", 47.930453, 21.031434, R.string.b_description_2, R.drawable.matyas1, R.drawable.matyas2));
        places.add(new Place(R.string.b_name_3, R.string.b_address_3, "+36705996932", "-", 47.930029, 21.032584, R.string.b_description_3, R.drawable.aszok1, R.drawable.aszok2));
        places.add(new Place(R.string.b_name_4, R.string.b_address_4, "-", "-", 47.933518, 21.035469, R.string.b_description_4, R.drawable.sorpatika1, R.drawable.sorpatika2));
        places.add(new Place(R.string.b_name_5, R.string.b_address_5, "+3649610736", "-", 47.929303, 21.039603, R.string.b_description_5, R.drawable.mangos1, R.drawable.mangos2));
        places.add(new Place(R.string.b_name_6, R.string.b_address_6, "+3649341033", "-", 47.929979, 21.044980, R.string.b_description_6, R.drawable.hbh1, R.drawable.hbh2));

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