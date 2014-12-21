package sample.gallery;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class Utils {
	
	public static class MyImage{
		Bitmap bmp;
		String filename;
		String caption;
		
		public MyImage(Bitmap bmp, String filename, String caption) {
			super();
			this.bmp = bmp;
			this.filename = filename;
			this.caption = caption;
		}
		
	}

	public static MyImage[] getFiles(Context context){
		 AssetManager assetManager = context.getAssets();
		    String[] files = null;
		    try {
		        files = assetManager.list("");
		    } catch (IOException e) {
		        Log.e("tag", e.getMessage());
		    }
		    List<MyImage> it=new ArrayList<MyImage>();
		    
		    for(int i=0;i<files.length;i++)
	        {
	          String filename=files[i];
	          if(getImageFile(filename)){
	        	  it.add(new MyImage(getBitmapFromAsset(context, filename),filename, SPUtils.getCaptionLocally(context, filename)));  
	          }
	            
	        }
		    MyImage[] returnFiles = new MyImage[it.size()];
		    it.toArray(returnFiles);
			return returnFiles;
		} 
	
	private static boolean getImageFile(String fName)
 {
		boolean re;

		String end = fName
				.substring(fName.lastIndexOf(".") + 1, fName.length())
				.toLowerCase();

		if (end.equals("jpg") || end.equals("gif") || end.equals("png")
				|| end.equals("jpeg") || end.equals("bmp")) {
			re = true;
		} else {
			re = false;
		}
		return re;
	}
	
	
	public static Bitmap getBitmapFromAsset(Context context, String strName)
    {
        AssetManager assetManager = context.getAssets();
        InputStream istr = null;
        try {
            istr = assetManager.open(strName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(istr);
        return bitmap;
    }
	
	
}
