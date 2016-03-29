package oleg.hubal.com.tm_homework12;

import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import oleg.hubal.com.tm_homework12.fragments.AboutFragment;
import oleg.hubal.com.tm_homework12.database.DatabaseHeadlessFragment;
import oleg.hubal.com.tm_homework12.fragments.PreferenceFragment;
import oleg.hubal.com.tm_homework12.fragments.SignInFragment;
import oleg.hubal.com.tm_homework12.list.UserListFragment;

public class MainActivity extends AppCompatActivity{

    private SignInFragment signInFragment;
    private DatabaseHeadlessFragment dbFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment();

        if (savedInstanceState == null) {
            commitSignInFragment();
            commitDBHeadlessFragment();
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
                openFragment(new AboutFragment());
                return true;
            case R.id.menu_list:
                openFragment(new UserListFragment());
                return true;
            case R.id.menu_settings:
                getFragmentManager()
                        .beginTransaction()
                        .add(R.id.frgm_container_AM, new PreferenceFragment())
                        .addToBackStack(null)
                        .commit();
            default:
                return false;
        }
    }

    private void commitDBHeadlessFragment() {
        dbFragment = new DatabaseHeadlessFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(dbFragment, Constants.DB_HEADLESS_TAG)
                .commit();
    }

    private void openFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frgm_container_AM, fragment)
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
