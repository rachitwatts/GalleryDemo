package sample.gallery;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GalleryPager extends Activity {
	int position;
	TextView captionText;
	GalleryPagerAdapter pageradapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pager_view);

		setTitle("");
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		Intent p = getIntent();
		position = p.getExtras().getInt("id");

		captionText = (TextView) findViewById(R.id.txt_caption);
		
		pageradapter = new GalleryPagerAdapter(this);
		ViewPager viewpager = (ViewPager) findViewById(R.id.pager);
		viewpager.setAdapter(pageradapter);
		viewpager.setCurrentItem(position);
		showCaptionForPage(position);
		
		viewpager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				position = arg0;
				showCaptionForPage(position);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}
	
	void showCaptionForPage(int position){
		String caption = pageradapter.getItemCaption(position);
		if(caption == null || caption.equalsIgnoreCase("")){
			captionText.setVisibility(View.GONE);
		} else {
			captionText.setVisibility(View.VISIBLE);
			captionText.setText(caption);
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.pager_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			this.finish();
			return true;
		case R.id.menu_item_caption:
			editCaption();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	void editCaption(){
		AlertDialog.Builder alert = new AlertDialog.Builder(this);

		alert.setTitle("Edit Caption");
		alert.setMessage("Enter new caption for the Photo");

		final EditText input = new EditText(this);
		alert.setView(input);

		alert.setPositiveButton("Save", new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int whichButton) {
			String value = input.getText().toString();
			SPUtils.saveCaptionLocally(GalleryPager.this, pageradapter.getItem(position).filename, value);
			pageradapter.refreshData();
			if(value == null || value.equalsIgnoreCase("")){
				captionText.setVisibility(View.GONE);
			} else {
				captionText.setVisibility(View.VISIBLE);
				captionText.setText(value);
			}
			if(NetworkUtils.isConnectedToInternet(GalleryPager.this)){
				Toast.makeText(GalleryPager.this, "Saved", Toast.LENGTH_SHORT).show();
				NetworkUtils.saveUserCaptionsServer(GalleryPager.this);
			} else {
				Toast.makeText(GalleryPager.this, "No Internet, caption will be synced when Internet is available.", Toast.LENGTH_SHORT).show();
				SPUtils.saveCaptionToBeSynced(GalleryPager.this, pageradapter.getItem(position).filename);
			}
		  }
		});

		alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
		  public void onClick(DialogInterface dialog, int whichButton) {
		  }
		});

		alert.show();
	}
	

}
