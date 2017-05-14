package hu.gearxpert.tiszaujvarostourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment implements Serializable {


    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Creates a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.string.name_1, R.string.address_1, "+36309297590", "http://scarpaetterem.hu", 47.935827, 21.035148, R.string.description_1, R.drawable.scarpa1, R.drawable.scarpa1));
        places.add(new Place(R.string.name_2, R.string.address_2, "+36302210238", "http://www.mammarosa.hu", 47.929291, 21.041575, R.string.description_2, R.drawable.mammarosa1, R.drawable.mammarosa1));
        places.add(new Place(R.string.name_3, R.string.address_3, "+36309297590", "http://scarpaetterem.hu", 47.935827, 21.035148, R.string.description_3, R.drawable.scarpa1, R.drawable.scarpa1));
        places.add(new Place(R.string.name_4, R.string.address_4, "+36309297590", "http://scarpaetterem.hu", 47.935827, 21.035148, R.string.description_4, R.drawable.scarpa1, R.drawable.scarpa1));
        places.add(new Place(R.string.name_5, R.string.address_5, "+36309297590", "http://scarpaetterem.hu", 47.935827, 21.035148, R.string.description_5, R.drawable.scarpa1, R.drawable.scarpa1));
        places.add(new Place(R.string.name_6, R.string.address_6, "+36309297590", "http://scarpaetterem.hu", 47.935827, 21.035148, R.string.description_6, R.drawable.scarpa1, R.drawable.scarpa1));
        places.add(new Place(R.string.name_7, R.string.address_7, "+36309297590", "http://scarpaetterem.hu", 47.935827, 21.035148, R.string.description_7, R.drawable.scarpa1, R.drawable.scarpa1));

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
                Intent intent = new Intent(getContext(), InfoPage.class);
                intent.putExtra("Choosed_item", place);
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
