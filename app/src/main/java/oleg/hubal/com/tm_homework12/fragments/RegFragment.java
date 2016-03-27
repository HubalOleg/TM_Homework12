package oleg.hubal.com.tm_homework12.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import oleg.hubal.com.tm_homework12.R;

/**
 * Created by User on 13.03.2016.
 */
public class RegFragment extends Fragment implements View.OnClickListener {

    private View view;
    private EditText etLogin, etPassword, etName, etSurname;
    private RadioGroup radioGroup;
    private Button btnCreate;
    private String login, password, name, surname;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sabedInstanceState) {
        view = inflater.inflate(R.layout.fragment_reg, container, false);

        initViews();

        return view;
    }

    private void initViews() {
        etLogin = (EditText) view.findViewById(R.id.et_reg_login);
        etPassword = (EditText) view.findViewById(R.id.et_reg_pass);
        etName = (EditText) view.findViewById(R.id.et_reg_name);
        etSurname = (EditText) view.findViewById(R.id.et_reg_surname);
        btnCreate = (Button) view.findViewById(R.id.btn_reg_reg);

        btnCreate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        getFieldValues();

        if(isEmptyFields())
            Toast.makeText(getActivity(), R.string.empty_field_toast, Toast.LENGTH_LONG).show();
        else {
//            Add to database
            showDialogFragment();
        }
    }

    private void showDialogFragment() {
        GreetingDialogFragment dialogFragment = new GreetingDialogFragment();

        Bundle bundle = new Bundle();
        bundle.putString("user", name + " " + surname);
        dialogFragment.setArguments(bundle);

        dialogFragment.show(getActivity().getFragmentManager(), "dialog");
    }

    private boolean isEmptyFields() {
        if(login.isEmpty() || password.isEmpty() || name.isEmpty()
                || surname.isEmpty())
            return true;
        else return false;
    }

    private void getFieldValues() {
        login = etLogin.getText().toString();
        password = etPassword.getText().toString();
        name = etName.getText().toString();
        surname = etSurname.getText().toString();
    }
}