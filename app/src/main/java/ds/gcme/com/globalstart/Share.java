package ds.gcme.com.globalstart;

import android.content.Intent;

/**
 * Created by Roger on 6/29/2016.
 */
public class Share {

    public static Intent share(String text){
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Global Start");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, text);
        return sharingIntent;
    }
}
