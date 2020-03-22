package com.nozimy.techpark_android_hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements ItemsFragment.OnFragmentInteractionListener {

    boolean itemsListActive = false;
    Menu mMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment, new ItemsFragment())
                    .commit();
        }
    }

    @Override
    public void onFragmentInteraction(int position) {
        ItemDetailsFragment fragment = ItemDetailsFragment.newInstance(position);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, fragment)
                .addToBackStack(null)
                .commit();

        setItemsFragmentDisabled();
    }

    @Override
    public void setItemsFragmentEnabled() {
        itemsListActive = true;

        invalidateOptionsMenu();
    }

    public void setItemsFragmentDisabled(){
        itemsListActive = false;

        invalidateOptionsMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.items_fragment_menu, menu);

        mMenu = menu;

        if (itemsListActive){
            menu.findItem(R.id.action_add_number).setVisible(true);
        }else{
            menu.findItem(R.id.action_add_number).setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_add_number:
                ItemsFragment itemsFragment = (ItemsFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
                if (itemsFragment != null) {
                    DataHelper.createItem();
                    itemsFragment.notifyInserted(DataHelper.getItems().size());
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
