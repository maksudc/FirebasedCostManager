package me.maksud.firebasecostmanagement.adapters.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import me.maksud.firebasecostmanagement.R;
import me.maksud.firebasecostmanagement.models.category.Category;

/**
 * Created by maksud on 10/3/15.
 */
public class CategoryListAdapter extends ArrayAdapter<Category> {

    public CategoryListAdapter(Context context , List<Category> objects){
        super(context , 0 , objects);
    }

    public CategoryListAdapter(Context context, int resource) {
        super(context, resource);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_category_list_item, parent, false);
        }

        Category category = getItem(position);

        TextView categoryListItemNameView = (TextView)convertView.findViewById(R.id.categoryListItemNameView);
        categoryListItemNameView.setText(category.getName());

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {

        View view = super.getDropDownView(position , convertView , parent);


        TextView labelView = (TextView) view;

        Category item = getItem(position);
        labelView.setText(item.getName());

        return view;
    }
}
