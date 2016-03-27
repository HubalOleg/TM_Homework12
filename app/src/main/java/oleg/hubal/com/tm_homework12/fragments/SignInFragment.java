package oleg.hubal.com.tm_homework12.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import oleg.hubal.com.tm_homework12.R;

/**
 * Created by User on 13.03.2016.
 */
public class SignInFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button btnReg, btnLogin;
    private EditText etLogin, etPassword;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        initView();

        return view;
    }

    private void initView() {
        btnReg = (Button) view.findViewById(R.id.btn_register);
        btnLogin = (Button) view.findViewById(R.id.btn_login);
        etLogin = (EditText) view.findViewById(R.id.et_login);
        etPassword = (EditText) view.findViewById(R.id.et_pass);

        btnLogin.setOnClickListener(this);
        btnReg.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_register:
                openRegFragment();
                break;
            case R.id.btn_login:

                break;
        }
    }

    private void openRegFragment() {
        RegFragment regFragment = new RegFragment();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frgm_container_AM, regFragment)
                .addToBackStack(null)
                .commit();
    }

}
