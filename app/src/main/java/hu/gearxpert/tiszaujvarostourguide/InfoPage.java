package hu.gearxpert.tiszaujvarostourguide;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class InfoPage extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private double map1;
    private double map2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Get the actual place coordinates from the fragment
        // Find the ImageView in the activity_info_page.xml layout with the ID image_view, and set the big image
        map1 = getIntent().getDoubleExtra("MAP1", 0);
        map2 = getIntent().getDoubleExtra("MAP2", 0);

        // Get the actual place name from the fragment
        // Find the TextView in the layout with the ID detail_name_view, and set the name
        String name = getString(getIntent().getIntExtra("NAME", 0));
        TextView nameTextView = (TextView) findViewById(R.id.detail_name_view);
        nameTextView.setText(name);

        // Get the actual place address from the fragment
        // Find the TextView in the layout with the ID detail_address_view, and set the address
        String address = getString(getIntent().getIntExtra("ADDRESS", 0));
        TextView addressTextView = (TextView) findViewById(R.id.detail_address_view);
        addressTextView.setText(R.string.address + address);

        // Get the actual place phone number from the fragment
        // Find the TextView in the layout with the ID detail_phone_view, and set the number
        String phoneNumber = getIntent().getStringExtra("PHONE_NUMBER");
        TextView phoneTextView = (TextView) findViewById(R.id.detail_phone_view);
        phoneTextView.setText(R.string.phone + phoneNumber);

        // Get the actual place web URL from the fragment
        // Find the TextView in the layout with the ID detail_web_view, and set the URL
        String webPage = getIntent().getStringExtra("WEBPAGE");
        TextView webTextView = (TextView) findViewById(R.id.detail_web_view);
        webTextView.setText(R.string.web + webPage);

        // Get the actual place description from the fragment
        // Find the TextView in the layout with the ID description_view, and set the description
        String description = getString(getIntent().getIntExtra("DESCRIPTION", 0));
        TextView descriptionTextView = (TextView) findViewById(R.id.description_view);
        descriptionTextView.setText(description);

        // Get the actual place big image ID from the fragment
        // Find the ImageView in the activity_info_page.xml layout with the ID image_view, and set the big image
        int bigImageId = getIntent().getIntExtra("BIG_IMAGE", 0);
        ImageView bigImageTextView = (ImageView) findViewById(R.id.details_image);
        bigImageTextView.setImageResource(bigImageId);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker to the current place position and move the camera
        LatLng place = new LatLng(map1, map2);
        mMap.addMarker(new MarkerOptions().position(place).title(getString(R.string.map_marking)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(place));
        mMap.setMinZoomPreference(15.0f);
        mMap.setMaxZoomPreference(20.0f);
    }
}
