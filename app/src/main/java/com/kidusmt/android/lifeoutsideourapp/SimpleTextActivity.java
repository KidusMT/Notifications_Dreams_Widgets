package com.kidusmt.android.lifeoutsideourapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.TextView;

/**
 * Created by KidusMT on 8/1/2017.
 */

public class SimpleTextActivity extends AppCompatActivity {

    public static final String TITLE_EXTRA = "title extra";
    public static final String BODY_TEXT_EXTRA = "body of the extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_text);

        Intent createIntent = getIntent();
        String title = createIntent.getStringExtra(TITLE_EXTRA);
        String bodyText = createIntent.getStringExtra(BODY_TEXT_EXTRA);

        if(title != null)
            setTitle(title);
        if(bodyText != null)
            ((TextView)findViewById(R.id.bodyText)).setText(bodyText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.simple_menu, menu);
        return true;
    }
}
