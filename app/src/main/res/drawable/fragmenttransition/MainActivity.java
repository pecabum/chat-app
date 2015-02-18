package drawable.fragmenttransition;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {

    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
//        mTabHost.setup(this, getSupportFragmentManager(), R.id.sample_content_fragment);
//
//        Bundle b = new Bundle();
//        b.putString("key", "Simple");
//        mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator("Simple"),
//                Fragment1.class, b);
//
//        b = new Bundle();
//        b.putString("key", "Contacts");
//        mTabHost.addTab(mTabHost.newTabSpec("contacts")
//                .setIndicator("Contacts"), Fragment3.class, b);

//        b = new Bundle();
//        b.putString("key", "Custom");
//        mTabHost.addTab(mTabHost.newTabSpec("custom").setIndicator("Custom"),
//                FragmentTransitionFragment.class, b);
////        mTabHost.setup(this,getSupportFragmentManager());
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            FragmentTransitionFragment fragment = new FragmentTransitionFragment();
            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();
        }
    }

}
