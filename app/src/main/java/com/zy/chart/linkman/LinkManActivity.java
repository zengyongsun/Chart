package com.zy.chart.linkman;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import com.zy.chart.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LinkManActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>,
    SearchView.OnQueryTextListener {

    @BindView(R.id.contractList) Button contractList;
    @BindView(R.id.contractListPhone) Button contractListPhone;
    @BindView(R.id.contractListEmail) Button contractListEmail;
    @BindView(R.id.searchContact) Button searchContact;
    @BindView(R.id.contactList) ListView contactList;
    @BindView(R.id.searchView) SearchView searchView;

    String mCurFilter;
    SimpleCursorAdapter mAdapter;
    @BindView(R.id.myEditText) MyEditText myEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_man);
        ButterKnife.bind(this);
        searchView.setOnQueryTextListener(this);
        mAdapter = new SimpleCursorAdapter(this,
            R.layout.link_man_item, null,
            new String[]{Contacts.DISPLAY_NAME, Contacts.CONTACT_STATUS, Contacts.HAS_PHONE_NUMBER},
            new int[]{R.id.textName, R.id.textStatus, R.id.textCount}, 0);
        contactList.setAdapter(mAdapter);

        // Prepare the loader.  Either re-connect with an existing one, or start a new one.
        getSupportLoaderManager().initLoader(0, null, this);

        contactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("LinkManActivity", "Item clicked: " + id);
            }
        });

        myEditText.setText("这是一个尝试的机会这是一个尝试的机会这是一个尝试的机会这是一个尝试的机会这是一个尝试的机会");
    }

    @Override public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override public boolean onQueryTextChange(String newText) {
        mCurFilter = !TextUtils.isEmpty(newText) ? newText : null;
        getSupportLoaderManager().restartLoader(0, null, this);
        return true;
    }

    @OnClick({R.id.contractList, R.id.contractListPhone, R.id.contractListEmail, R.id.searchContact})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.contractList:

                break;
            case R.id.contractListPhone:

                break;
            case R.id.contractListEmail:

                break;

            case R.id.searchContact:

                break;
        }
    }

    private void getContractList() {
        getContentResolver();
    }

    private void getContractListPhone() {

    }

    private void getContractListEmail() {

    }

    // These are the Contacts rows that we will retrieve.
    static final String[] CONTACTS_SUMMARY_PROJECTION = new String[]{
        Contacts._ID,
        Contacts.DISPLAY_NAME,
        Contacts.CONTACT_STATUS,
        Contacts.CONTACT_PRESENCE,
        Contacts.PHOTO_ID,
        Contacts.LOOKUP_KEY,
        Contacts.HAS_PHONE_NUMBER,
    };

    // If non-null, this is the current filter the user has provided.
    @Override public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Uri baseUri;
        if (mCurFilter != null) {
            baseUri = Uri.withAppendedPath(Contacts.CONTENT_FILTER_URI,
                Uri.encode(mCurFilter));
        } else {
            baseUri = Contacts.CONTENT_URI;
        }

        // Now create and return a CursorLoader that will take care of
        // creating a Cursor for the data being displayed.
        String select = "((" + Contacts.DISPLAY_NAME + " NOTNULL) AND ("
            + Contacts.HAS_PHONE_NUMBER + "=1) AND ("
            + Contacts.DISPLAY_NAME + " != '' ))";
        return new CursorLoader(this, baseUri,
            CONTACTS_SUMMARY_PROJECTION, select, null,
            Contacts.DISPLAY_NAME + " COLLATE LOCALIZED ASC");
    }

    @Override public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
    }

    @Override public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }

}
