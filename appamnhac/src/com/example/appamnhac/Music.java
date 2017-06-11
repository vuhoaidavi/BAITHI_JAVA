package com.example.appamnhac;

import java.util.ArrayList;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Music extends Activity {
	TextView txtloinhan;
	ListView lvbaihat;//xu ly nay o man hinh thu 2
	RelativeLayout mh;
	MediaPlayer song;
	
	ArrayList<String>mangtenbh, mangloinhan;
	ArrayList<Integer>mangMp3;
	
	public void Anhxa()
	{
		txtloinhan = (TextView) findViewById(R.id.txtloinhan);
		lvbaihat = (ListView) findViewById(R.id.lvbaihat);
		mh = (RelativeLayout) findViewById(R.id.manhinh);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music);
		
		//anh xa
		Anhxa();
		
		//hinh nen
		mh.setBackgroundResource(R.drawable.stmusic);
		
		//play nhac nen
		song = MediaPlayer.create(getApplicationContext(), R.raw.st1);
		song.start();
		//loi nhan
		txtloinhan.setText("chúc chị sẽ mãi thành công trên con đường ca hát!!!");

		
		
		Taomang();
		
		//listview
		ArrayAdapter<String> adapter = new ArrayAdapter<String>
				(getApplicationContext(), android.R.layout.simple_list_item_1,mangtenbh);
		lvbaihat.setAdapter(adapter);
		
		
		//listview on itemclick 
		lvbaihat.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent,View view, int position, long id) {
				// TODO Auto-generated method stub
				song.stop();
				song = MediaPlayer.create(getApplicationContext(), mangMp3.get(position));
				song.start();
				txtloinhan.setText(mangloinhan.get(position));
			//back
				txtloinhan.setOnClickListener(new View.OnClickListener() {
					public void Onclick (View v)
					{
						song.stop();
						Intent mhMain= new Intent(getApplicationContext(),MainActivity.class);
						startActivity(mhMain);
					}
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
					}
				});
			}
		});
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.music, menu);
		return true;
	}
//tao mang luu ten cac bai hat
	public void Taomang()
	{
		mangtenbh = new ArrayList<String>();
		mangloinhan = new ArrayList<String>();
		mangMp3 = new ArrayList<Integer>();
		
		mangMp3.add(R.raw.st2);
		mangtenbh.add("I need your love");
		mangloinhan.add("Sáng tác: Nguyễn Quốc Đạt .phát hành ngày 14.2.2017");
		
		mangMp3.add(R.raw.st3);
		mangtenbh.add("Feel your love");
		mangloinhan.add("Sáng tác: Kiên Trần .phát hành ngày 05.12.2012");
		
		mangMp3.add(R.raw.st4);
		mangtenbh.add("Cứ yêu đi");
		mangloinhan.add("Sáng tác: Nguyễn Hoàng Tôn .phát hành ngày 10.1.2016");
		
		
		mangMp3.add(R.raw.st5);
		mangtenbh.add("Chuyện buồn em phải quên");
		mangloinhan.add("Sáng tác: Đông Duy .phát hành tháng 7/2016");
		
		mangMp3.add(R.raw.st6);
		mangtenbh.add("Đêm nay ta say");
		mangloinhan.add("Sáng tác: Andy Trần .phát hành tháng 3/2016");
		
		mangMp3.add(R.raw.st7);
		mangtenbh.add("Em sợ");
		mangloinhan.add("Sáng tác: Nguyễn Hoàng Tôn .phát hành ngày 8.5.2012");
		
		mangMp3.add(R.raw.st8);
		mangtenbh.add("Gái già lắm chiêu");
		mangloinhan.add("Sáng tác: Andy Trần .phát hành ngày 1.1.2016");
		
		mangMp3.add(R.raw.st9);
		mangtenbh.add("Mùa  yêu cũ ");
		mangloinhan.add("Sáng tác: Tiên Tiên .phát hành ngày 28.5.2015");
		
		mangMp3.add(R.raw.st9);
		mangtenbh.add("Vẫn yêu như ngày nào ");
		mangloinhan.add("Sáng tác: Hoàng Tôn .phát hành ngày 30.5.2012");
	}
}
