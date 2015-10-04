package me.maksud.firebasecostmanagement.adapters.currency;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import me.maksud.firebasecostmanagement.R;
import me.maksud.firebasecostmanagement.models.currency.Currency;

/**
 * Created by maksud on 10/4/15.
 */
public class CurrencyAdapter extends ArrayAdapter<Currency> {


    public CurrencyAdapter(Context context, int resource, List<Currency> objects) {
        super(context, resource, objects);
    }

    public CurrencyAdapter(Context context , List<Currency> objects){
        super(context , 0 , objects);
    }


    @Override
    public View getView(int position , View convertView , ViewGroup parent){

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_currency_list_item , parent , false);
        }

        Currency currency = getItem(position);

        TextView currencySymbolView = (TextView) convertView.findViewById(R.id.currencySymbolView);
        TextView currencyNativeSymbolView = ( TextView )convertView.findViewById(R.id.currencyNativeSymbolView);

        currencySymbolView.setText(currency.getSymbol());
        currencyNativeSymbolView.setText(currency.getSymbol_native());

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = super.getDropDownView(position, convertView, parent);

        Currency currency = getItem(position);

        TextView dropDownView = (TextView)view;
        dropDownView.setText(currency.getSymbol());

        return view;
    }
}
