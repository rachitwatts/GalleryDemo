package sample.gallery;

import sample.gallery.Utils.MyImage;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.example.staggeredgridviewdemo.views.ScaleImageView;

public class GalleryPagerAdapter extends PagerAdapter { 
	private Context mContext;
	private MyImage[] files;
 
	public GalleryPagerAdapter(Context c) {
		mContext = c;
		files = Utils.getFiles(mContext);
	}
	
	public void refreshData(){
		files = Utils.getFiles(mContext);
		notifyDataSetChanged();
	}
 
	public int getCount() {
		return files.length;
	}

	public MyImage getItem(int position) {
		return files[position];
	}
	
	public String getItemCaption(int position) {
		return files[position].caption;
	}
	

	public long getItemId(int position) {
		return 0;
	}
    
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
    	ScaleImageView imgView = new ScaleImageView(container.getContext());
    	imgView.setImageBitmap(getItem(position).bmp);
		
    	RelativeLayout layout = new RelativeLayout(container.getContext());

    	LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    	lp.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
    	layout.addView(imgView, lp);
    	((ViewPager)container).addView(layout);
    	
    	return layout;
    }
 
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
 
 
    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }}
