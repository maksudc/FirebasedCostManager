package me.maksud.firebasecostmanagement.fragments.core;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import me.maksud.firebasecostmanagement.R;
import me.maksud.firebasecostmanagement.activities.category.CategoryAddActivity;
import me.maksud.firebasecostmanagement.activities.category.CategoryListActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Button viewListButton = (Button)view.findViewById(R.id.viewCategoryListButton);
        Button addCategoryButton = (Button)view.findViewById(R.id.addCategoryButton);

        viewListButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity() , CategoryListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                getActivity().finish();
            }
        });

        addCategoryButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity() , CategoryAddActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                getActivity().finish();
            }
        });

        return view;
    }
}
