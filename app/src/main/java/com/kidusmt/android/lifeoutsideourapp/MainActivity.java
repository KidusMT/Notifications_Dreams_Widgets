package com.kidusmt.android.lifeoutsideourapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bt_remove,bt_notify, bt_personal, bt_multi, bt_big_text, bt_big_pic;
    private static final int NOTIFY_ID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_notify = (Button) findViewById(R.id.btn_first);
        bt_personal = (Button) findViewById(R.id.btn_second);
        bt_multi = (Button) findViewById(R.id.btn_third);
        bt_big_text = (Button) findViewById(R.id.btn_fourth);
        bt_big_pic = (Button) findViewById(R.id.btn_fiveth);
        bt_remove = (Button) findViewById(R.id.btn_sixth);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public void btnNotifyOnClick(View v){
        String title = "KidusMT";
        String text = "Sup everybody!!!";

        Intent intent = new Intent(this, SimpleTextActivity.class);
        intent.setAction("Notify");
        intent.putExtra(SimpleTextActivity.TITLE_EXTRA, title);
        intent.putExtra(SimpleTextActivity.BODY_TEXT_EXTRA, text);
        NotificationCompat.Builder builder = initBasicBuilder(title, text, intent);

        Notification notification = builder.build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFY_ID,notification);
    }


    public void btnNotfiyOnPersonalOnClick(Button b){

    }
    public void  btnNotifyMultiOnClick(Button b){

    }
    public void btnNotifyBigTextOnClick(Button b){

    }
    public void btnNotifyBitImageOnClick(Button b){

    }


    private NotificationCompat.Builder initBasicBuilder(String title, String text, Intent intent ){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.birdy_nofication_icon)
                .setContentTitle(title)
                .setContentText(text);
        if(intent != null){
            PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
            builder.setContentIntent(pendingIntent);
        }

        return builder;
    }

    public void btnRemoveNotificationOnClick(Button b){
    }
}
