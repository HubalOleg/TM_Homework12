package oleg.hubal.com.tm_homework12.fragments;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

/**
 * Created by User on 15.03.2016.
 */
public class GreetingDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        String user = bundle.getString("user");

        return new AlertDialog
                .Builder(getActivity())
                .setIcon(android.R.drawable.ic_btn_speak_now)
                .setMessage("user" + "\n" + user + "\n" + "registrated")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
    }
}
