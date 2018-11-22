package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.wolfsoft1.instasample.R;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;

import java.util.ArrayList;

import Adapter.RecycleAdapter_GridHome;
import ModelClass.HomeGridModelClass;
//import design.ws.com.appstores.R;


public class HomeFragment extends Fragment {


    private BottomBar mBottomBar;
    private View view;

    private LinearLayout linearLayout;

    private ArrayList<HomeGridModelClass> homeGridModelClasses;

    private RecyclerView recyclerView;
    private RecycleAdapter_GridHome mAdapter;

    private Integer image[] = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,
            R.drawable.five, R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,
            R.drawable.food1,R.drawable.food2,R.drawable.food3,R.drawable.food4,R.drawable.food5,
            R.drawable.food6,R.drawable.m7,R.drawable.m8,R.drawable.m9};




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        linearLayout = (LinearLayout)view.findViewById(R.id.main);


        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        homeGridModelClasses = new ArrayList<>();
        setupBottomBar();



        for (int i = 0; i < image.length; i++) {
            HomeGridModelClass beanClassForRecyclerView_contacts = new HomeGridModelClass(image[i]);

            homeGridModelClasses.add(beanClassForRecyclerView_contacts);
        }


        mAdapter = new RecycleAdapter_GridHome(getActivity(),homeGridModelClasses);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setFocusable(false);

        return view;
    }
    private void setupBottomBar() {

        mBottomBar = (BottomBar)view.findViewById(R.id.bottombar1);

        for (int i = 0; i < mBottomBar.getTabCount(); i++) {
            BottomBarTab tab = mBottomBar.getTabAtPosition(i);
            tab.setGravity(Gravity.CENTER);

            View icon = tab.findViewById(com.roughike.bottombar.R.id.bb_bottom_bar_icon);

            icon.setPadding(0, icon.getPaddingTop(), 0, icon.getPaddingTop());

            View title = tab.findViewById(com.roughike.bottombar.R.id.bb_bottom_bar_title);
            title.setVisibility(View.GONE);
        }
    }


}
