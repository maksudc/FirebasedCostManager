package me.maksud.firebasecostmanagement.fragments.category;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

import me.maksud.firebasecostmanagement.R;
import me.maksud.firebasecostmanagement.adapters.category.CategoryListAdapter;
import me.maksud.firebasecostmanagement.factories.BigBangFactory;
import me.maksud.firebasecostmanagement.models.category.Category;

/**
 * A placeholder fragment containing a simple view.
 */
public class CategoryListFragment extends Fragment {

    private CategoryListAdapter adapter = null;

    private ChildEventListener childEventListener;

    private Firebase firebaseRef;

    public CategoryListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_category_list, container, false);

        adapter = new CategoryListAdapter(getActivity() , new ArrayList<Category>());

        ListView categoryListView = (ListView)view.findViewById(R.id.categoryListView);
        categoryListView.setAdapter(adapter);

        firebaseRef = BigBangFactory.getInstance(getActivity()).getFirebaseRef();


        /*
        firebaseRef.child(Category.PATH).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                adapter.clear();

                for(DataSnapshot childDataSnapshot: dataSnapshot.getChildren()){
                    Category citem = childDataSnapshot.getValue(Category.class);
                    adapter.add(citem);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }


        });*/

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Category citem = dataSnapshot.getValue(Category.class);
                adapter.add(citem);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

                Category removedItem = dataSnapshot.getValue(Category.class);

                int removedIndex = -1;

                for (int I = 0; I < adapter.getCount(); I++) {
                    Category item = adapter.getItem(I);
                    if (item.getName().equals(removedItem.getName())) {
                        removedIndex = I;
                        break;
                    }
                }

                if (removedIndex > 0) {
                    adapter.remove(adapter.getItem(removedIndex));
                }
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        };
        firebaseRef.child(Category.PATH).addChildEventListener(childEventListener);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        firebaseRef.child(Category.PATH).removeEventListener(childEventListener);
    }
}
