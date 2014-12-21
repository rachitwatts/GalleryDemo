package sample.gallery;

import sample.gallery.Utils.MyImage;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.staggeredgridviewdemo.views.ScaleImageView;

public class GridAdapter extends BaseAdapter {

	private Context mContext;
	private MyImage[] files;

	public GridAdapter(Context c) {
		mContext = c;
		files = Utils.getFiles(mContext);
	}

	public int getCount() {
		return files.length;
	}

	public MyImage getItem(int position) {
		return files[position];
	}
	

	public long getItemId(int position) {
		return 0;
	}

	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;

		if (convertView == null) {
			LayoutInflater layoutInflator = LayoutInflater.from(mContext);
			convertView = layoutInflator.inflate(R.layout.item_album_single_image,
					null);
			holder = new ViewHolder();
			holder.imageView = (ScaleImageView) convertView .findViewById(R.id.imageView1);
			convertView.setTag(holder);
		}

		holder = (ViewHolder) convertView.getTag();
		holder.imageView.setImageBitmap(getItem(position).bmp);
		
		return convertView;
	}

	static class ViewHolder {
		ScaleImageView imageView;
	}
	
	
}
