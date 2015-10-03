package me.maksud.firebasecostmanagement.fragments.category;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

import me.maksud.firebasecostmanagement.R;
import me.maksud.firebasecostmanagement.factories.BigBangFactory;
import me.maksud.firebasecostmanagement.models.category.Category;

/**
 * A placeholder fragment containing a simple view.
 */
public class CategoryAddActivityFragment extends Fragment {

    private EditText categoryNameFieldView = null;
    private Button submitButtonView = null;

    private String categoryName;
    private Firebase firebaseRef = null;

    public CategoryAddActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_add, container, false);

        firebaseRef = BigBangFactory.getInstance(getActivity()).getFirebaseRef();

        categoryNameFieldView = (EditText)view.findViewById(R.id.categoryNameFieldView);
        submitButtonView = (Button) view.findViewById(R.id.submitButtonView);


        submitButtonView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(!TextUtils.isEmpty(categoryNameFieldView.getText().toString())){

                    Category item = new Category();
                    item.setName(categoryNameFieldView.getText().toString());

                    Firebase newCategoryRef = firebaseRef.child(Category.PATH).push();
                    newCategoryRef.setValue(item);

                    categoryNameFieldView.setText(null);
                }
            }
        });

        return view;
    }
}
