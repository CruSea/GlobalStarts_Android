package ds.gcme.com.globalstart.Menu_Options;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import ds.gcme.com.globalstart.Global_Start;
import ds.gcme.com.globalstart.Model.Testimony;
import ds.gcme.com.globalstart.R;

/**
 * Created by bengeos on 7/1/16.
 */

public class SendTestimony extends DialogFragment {

    private EditText Title,Content;
    private Button Send;
    private static final String TAG = "Send_Testimony";
    private ProgressDialog myProgressDialog;
    private Context myContext;
    private DatabaseReference myTestimonyRef;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myTestimonyRef = database.getReference("Testimonies");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        String txtTitle = getArguments().getString("Title");
        String txtMore = getArguments().getString("Detail");
        View view = inflater.inflate(R.layout.fragment_view_testimony,null);
        myProgressDialog = new ProgressDialog(getActivity());

        Title = (EditText) view.findViewById(R.id.testimony_title);
        Content = (EditText) view.findViewById(R.id.testimony_content);
        Send = (Button) view.findViewById(R.id.testimony_send);


        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myProgressDialog.show();
                myProgressDialog.setCancelable(false);
                myProgressDialog.setTitle("Sending your testimony");
                Testimony testimony = new Testimony();
                testimony.setTitle(Title.getText().toString());
                testimony.setDetail(Content.getText().toString());
                myTestimonyRef.push().setValue(testimony);
                myProgressDialog.cancel();
            }
        });
        builder.setView(view)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        SendTestimony.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}
