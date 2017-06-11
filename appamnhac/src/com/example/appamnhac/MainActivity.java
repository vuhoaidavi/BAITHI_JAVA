package com.example.appamnhac;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	RelativeLayout mh;
	MediaPlayer song; //khai bao ten bien
	ImageView imageViewsithanh;
	
	public void AnhXa () //anh xa hinh anh
	{
		mh = (RelativeLayout) findViewById(R.id.manhinh);
		imageViewsithanh= (ImageView) findViewById(R.id.imageViewsithanh);
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
    
    //background
    mh.setBackgroundResource(R.drawable.sthd);
    
    //nhacnen cua app
    
    song = MediaPlayer.create(getApplicationContext(), R.raw.st1);
    song.start();
    //hieu ung sang tat cho anh tren app
    	Animation f =AnimationUtils.loadAnimation(this, R.anim.fade);
    	f.reset();
    	imageViewsithanh.clearAnimation();
    	imageViewsithanh.startAnimation(f);
    	// click man hinh se ra man hinh am nhac thu 2
    	imageViewsithanh.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent mhMusic= new Intent(getApplicationContext(),Music.class);
				startActivity(mhMusic);
				song.stop();
			}
		});
    }
    
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
