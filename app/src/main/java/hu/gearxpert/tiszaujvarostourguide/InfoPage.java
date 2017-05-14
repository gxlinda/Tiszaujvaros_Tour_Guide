package hu.gearxpert.tiszaujvarostourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoPage extends AppCompatActivity {
    Place currentPlace = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);

        Intent intent = getIntent();
        currentPlace = (Place) intent.getSerializableExtra("Choosed_item");

        // Find the TextView in the layout with the ID detail_name_view, and set the name
        TextView name2TextView = (TextView) findViewById(R.id.detail_name_view);
        name2TextView.setText(currentPlace.getName());

        // Find the TextView in the layout with the ID detail_address_view, and set the address
        TextView address2TextView = (TextView) findViewById(R.id.detail_address_view);
        address2TextView.setText("Address: " + currentPlace.getAddress());

        // Find the TextView in the layout with the ID detail_phone_view, and set the number
        TextView phoneTextView = (TextView) findViewById(R.id.detail_phone_view);
        phoneTextView.setText("Phone: " + currentPlace.getPhoneNumber());

        // Find the TextView in the layout with the ID detail_web_view, and set the URL
        TextView webTextView = (TextView) findViewById(R.id.detail_web_view);
        webTextView.setText("Web: " + currentPlace.getWebPage());

        // Find the TextView in the layout with the ID description_view, and set the description
        TextView descriptionTextView = (TextView) findViewById(R.id.description_view);
        descriptionTextView.setText(currentPlace.getDescription());

        // Find the ImageView in the list_item.xml layout with the ID image, and set the small image
        ImageView smallImageTextView = (ImageView) findViewById(R.id.image);
        smallImageTextView.setImageResource(currentPlace.getSmallImageResourceId());

        // Find the ImageView in the activity_info_page.xml layout with the ID image_view, and set the big image
        ImageView bigImageTextView = (ImageView) findViewById(R.id.details_image);
        bigImageTextView.setImageResource(currentPlace.getBigImageResourceId());


        Button mapView = (Button) findViewById(R.id.showMap);

        // Set a click listener to open a new screen when the Show map view is clicked on
        mapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(InfoPage.this, MapsActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
