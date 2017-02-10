package ds.gcme.com.globalstart.Menu_Options;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ds.gcme.com.globalstart.R;


/**
 * Created by Roger on 3/18/2016.
 */
public class ContactUsOptions extends DialogFragment {
    Button fb, twitter, website;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        String txtTitle = getArguments().getString("Title");
        String txtMore = getArguments().getString("Detail");
        View view = inflater.inflate(R.layout.fragment_view_contact,null);

        fb = (Button) view.findViewById(R.id.menu_find_fb);
        twitter = (Button) view.findViewById(R.id.menu_find_twitter);
        website = (Button) view.findViewById(R.id.menu_find_website);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"FB touched", Toast.LENGTH_SHORT).show();
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Twitter touched", Toast.LENGTH_SHORT).show();
            }
        });

        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Website touched", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setView(view)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        ContactUsOptions.this.getDialog().cancel();
                    }
                });


        return builder.create();
    }
}
