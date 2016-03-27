package oleg.hubal.com.tm_homework12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import oleg.hubal.com.tm_homework12.fragments.AboutFragment;
import oleg.hubal.com.tm_homework12.fragments.SignInFragment;

public class MainActivity extends AppCompatActivity{

    private SignInFragment signInFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment();

        if (savedInstanceState == null) {
            commitSignInFragment();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:
                openAboutFragment();
                return true;
            default:
                return false;
        }
    }

    private void openAboutFragment() {
        AboutFragment aboutFragment = new AboutFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frgm_container_AM, aboutFragment)
                .addToBackStack(null)
                .commit();
    }

    private void initFragment() {
        signInFragment = new SignInFragment();
    }

    private void commitSignInFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frgm_container_AM, signInFragment)
                .addToBackStack(null)
                .commit();
    }
}
