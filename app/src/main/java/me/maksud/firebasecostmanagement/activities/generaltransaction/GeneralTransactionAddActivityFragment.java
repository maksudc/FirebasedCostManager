package me.maksud.firebasecostmanagement.activities.generaltransaction;

import android.accounts.Account;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

import me.maksud.firebasecostmanagement.R;
import me.maksud.firebasecostmanagement.adapters.category.CategoryListAdapter;
import me.maksud.firebasecostmanagement.adapters.currency.CurrencyAdapter;
import me.maksud.firebasecostmanagement.factories.BigBangFactory;
import me.maksud.firebasecostmanagement.models.category.Category;
import me.maksud.firebasecostmanagement.models.currency.Currency;
import me.maksud.firebasecostmanagement.models.generaltransaction.GeneralTransaction;

/**
 * A placeholder fragment containing a simple view.
 */
public class GeneralTransactionAddActivityFragment extends Fragment {

    private Spinner accountSelectionFieldView;
    private Spinner categorySelectionFieldView;

    private TextView accountSelectionLabelFieldView;
    private TextView categorySelectionLabelFieldView;

    private Button transactionSubmitButtonView;

    private EditText transactionAmountFieldView;
    private EditText transactionDescriptionView;
    private Spinner transactionCurrencyFieldView;

    private Firebase firebaseRef;
    private CategoryListAdapter categoryArrayAdapter;
    private ArrayAdapter<Account> accountArrayAdapter;
    private ChildEventListener categoryChildEventListener;
    private ChildEventListener currencyChildeventListener;

    public String selectedCategoryKey;
    public String selectedAccountKey;
    public String selectedCurrencyKey;


    private CurrencyAdapter currencyAdapter;

    public GeneralTransactionAddActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_general_transaction_add, container, false);

        accountSelectionFieldView = ( Spinner )view.findViewById(R.id.accountSelectionFieldView);
        categorySelectionFieldView = ( Spinner )view.findViewById(R.id.categorySelectionFieldView);
        transactionCurrencyFieldView =(Spinner)view.findViewById(R.id.transactionCurrencyFieldView);

        accountSelectionLabelFieldView = (TextView)view.findViewById(R.id.accountSelectionLabelFieldView);
        categorySelectionLabelFieldView = (TextView)view.findViewById(R.id.categorySelectionLabelFieldView);

        transactionAmountFieldView = (EditText)view.findViewById(R.id.transactionAmountFieldView);
        transactionDescriptionView = (EditText)view.findViewById(R.id.transactionDescriptionFieldView);


        categoryArrayAdapter = new CategoryListAdapter(getActivity(),new ArrayList<Category>());
        categoryArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //accountArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySelectionFieldView.setAdapter(categoryArrayAdapter);

        accountSelectionFieldView.setAdapter(accountArrayAdapter);

        currencyAdapter = new CurrencyAdapter(getActivity() , 0 , new ArrayList<Currency>());
        currencyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        transactionCurrencyFieldView.setAdapter(currencyAdapter);

        transactionSubmitButtonView = (Button)view.findViewById(R.id.transactionSubmitButtonView);

        firebaseRef = BigBangFactory.getInstance(getActivity()).getFirebaseRef();

        categoryChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Category item = dataSnapshot.getValue(Category.class);
                item.setId(dataSnapshot.getKey());

                categoryArrayAdapter.add(item);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        };

        currencyChildeventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Currency currency = dataSnapshot.getValue(Currency.class);
                currencyAdapter.add(currency);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        };

        firebaseRef.child(Category.PATH).addChildEventListener(categoryChildEventListener);
        firebaseRef.child(Currency.PATH).addChildEventListener(currencyChildeventListener);

        categorySelectionFieldView.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Category selectedItem = (Category) parent.getItemAtPosition(position);
                selectedCategoryKey = selectedItem.getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        transactionCurrencyFieldView.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Currency currency = (Currency) parent.getItemAtPosition(position);

                selectedCurrencyKey = currency.getCode();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        transactionSubmitButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(selectedCategoryKey)  && !TextUtils.isEmpty(transactionAmountFieldView.getText().toString()) ) {

                    GeneralTransaction generalTransaction = new GeneralTransaction();
                    generalTransaction.setCategory(selectedCategoryKey);
                    generalTransaction.setDescription(transactionDescriptionView.getText().toString());
                    generalTransaction.setAmount(Double.valueOf(transactionAmountFieldView.getText().toString()));

                    Firebase transactionFirebaseRef = firebaseRef.child(GeneralTransaction.PATH).push();
                    generalTransaction.setId(transactionFirebaseRef.getKey());

                    transactionFirebaseRef.setValue(generalTransaction);

                    transactionAmountFieldView.setText(null);
                    transactionDescriptionView.setText(null);
                }
            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        firebaseRef.child(Category.PATH).removeEventListener(categoryChildEventListener);
        firebaseRef.child(Currency.PATH).removeEventListener(currencyChildeventListener);
    }
}
