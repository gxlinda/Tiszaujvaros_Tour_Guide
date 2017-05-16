package hu.gearxpert.tiszaujvarostourguide;

/**
 * Created by melinda.kostenszki on 2017.05.09..
 */

public class Place {

    private int mName;
    private int mAddress;
    private int mPhoneNumber;
    private int mWebPage;
    private double mMap1;
    private double mMap2;
    private int mDescription;

    /** Constant variable that represents no image was provided for this place */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**Image resource ID for the place */
    private int mSmallImageResourceId = NO_IMAGE_PROVIDED;
    private int mBigImageResourceId = NO_IMAGE_PROVIDED;


    /**
     * Creates a new Place object with 9 parameters.
     **/
    public Place(int name, int address, int phoneNumber, int webPage, double map1, double map2, int description, int smallImageResourceId, int bigImageResourceId) {
        mName = name;
        mAddress = address;
        mPhoneNumber = phoneNumber;
        mWebPage = webPage;
        mMap1 = map1;
        mMap2 = map2;
        mDescription = description;
        mSmallImageResourceId = smallImageResourceId;
        mBigImageResourceId = bigImageResourceId;
    }

    /**
     * Get the name of the place.
     */
    public int getName() {
        return mName;
    }

    /**
     * Get the address of the place.
     */
    public int getAddress() {
        return mAddress;
    }

    /**
     * Get the phone number of the place.
     */
    public int getPhoneNumber() {
        return mPhoneNumber;
    }

    /**
     * Get the web URL of the place.
     */
    public int getWebPage() {
        return mWebPage;
    }

    /**
     * Get the first coordinate of the place.
     */
    public double getMap1() {
        return mMap1;
    }

    /**
     * Get the 2nd coordinate of the place.
     */
    public double getMap2() {
        return mMap2;
    }

    /**
     * Get the description of the place.
     */
    public int getDescription() {
        return mDescription;
    }

    /**
     * Get the small image of the place.
     */
    public int getSmallImageResourceId() {
        return mSmallImageResourceId;
    }

    /**
     * Get the big image of the place.
     */
    public int getBigImageResourceId() {
        return mBigImageResourceId;
    }


    /**
     +     * Returns whether or not there is an image for this place.
     +     */
    public boolean hasImage1() {
        return mSmallImageResourceId != NO_IMAGE_PROVIDED;
    }
    public boolean hasImage2() {
        return mBigImageResourceId != NO_IMAGE_PROVIDED;
    }

}
