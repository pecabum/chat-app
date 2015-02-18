package tabhostapp.com.tabhostapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TabHost;
import android.widget.Toast;

public class FragmentTransitionFragment extends BaseContainerFragment implements AdapterView.OnItemClickListener {

    private static final String TAB_1_TAG = "tab_1";
    private static final String TAB_2_TAG = "tab_2";

    private MeatAdapter mAdapter;
    OnHeadlineSelectedListener mCallback;
    public static FragmentTransitionFragment newInstance() {
        return new FragmentTransitionFragment();
    }



    // Container Activity must implement this interface
    public interface OnHeadlineSelectedListener {
        public void onArticleSelected(Meat meat);
    }




    public FragmentTransitionFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (OnHeadlineSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // This is the adapter we use to populate the grid.
        mAdapter = new MeatAdapter(inflater, R.layout.item_meat_grid);
        // Inflate the layout with a GridView in it.
        return inflater.inflate(R.layout.fragment_fragment_transition, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        GridView grid = (GridView) view.findViewById(R.id.grid);
        grid.setAdapter(mAdapter);
        grid.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Meat meat = mAdapter.getItem(position);
//
        FragmentTabHost host = (FragmentTabHost) getActivity().findViewById(android.R.id.tabhost);
        host.setCurrentTab(1);
        View widget = host.getTabWidget().getChildAt(1);
        Toast.makeText(getActivity(),host.getChildCount()+"",Toast.LENGTH_LONG).show();
      // We start the fragment transaction here. It is just an ordinary fragment transaction.
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace( getActivity().getSupportFragmentManager().findFragmentByTag(TAB_1_TAG).getId(),
                        DetailFragment.newInstance(meat.resourceId, meat.title,
                                (int) view.getX(), (int) view.getY(),
                                view.getWidth(), view.getHeight())
                )
////                // We push the fragment transaction to back stack. User can go back to the
////                // previous fragment by pressing back button.
                .addToBackStack("detail")
                .commit();
        mCallback.onArticleSelected(meat);
    }
//
    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return AnimationUtils.loadAnimation(getActivity(),
                enter ? android.R.anim.fade_in : android.R.anim.fade_out);
    }

}
