package com.theLads.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.theLads.spacetrader.R;
import com.theLads.spacetrader.entity.enums.ItemType;
import com.theLads.spacetrader.viewmodels.BuySellViewModel;


/**
 * This displays all students in the model, regardless of registration
 */
public class BuyActivity extends AppCompatActivity {

    /** a key for passing data */
    public static final String ITEM_DATA = "ITEM_DATA";
    /** an int for the request code */
    private static final int EDIT_REQUEST = 5;
    /** our data model */
    private BuySellViewModel viewModel;
    /** an adapter for the recycler view */
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);


        /*
         Set up our recycler view by grabbing the layout for a single item
         */
        /*
        RecyclerView recyclerView = findViewById(R.id.item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        // Setup the adapter for this recycler view
        adapter = new ItemAdapter();
        recyclerView.setAdapter(adapter);

        //grab our view model instance
        viewModel = ViewModelProviders.of(this).get(BuySellViewModel.class);

        Log.d("APP", viewModel.getMarketQuantities().toString());
        */
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.setItemList(viewModel.getMarketQuantities());

        adapter.setOnItemClickListener(new ItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(ItemType item) {
                Intent intent = new Intent(BuyActivity.this, BuyDetailActivity.class);
                intent.putExtra(ITEM_DATA, item);
                startActivityForResult(intent, EDIT_REQUEST);
            }
        });
    }
}
