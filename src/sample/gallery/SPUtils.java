package sample.gallery;

import java.util.HashSet;
import java.util.Set;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SPUtils {

	public static final String MyPrefs = "GalleryPrefs" ;
	public static final String CaptionsToBeSynced = "ToSyncCaptions" ;
	
	public static void saveCaptionLocally(Context context, String fileHash, String caption){
	      SharedPreferences sharedpreferences = context.getSharedPreferences(MyPrefs, Context.MODE_PRIVATE);
	      Editor editor = sharedpreferences.edit();
	      editor.putString(fileHash, caption);
	      editor.commit(); 
	}
	
	public static String getCaptionLocally(Context context, String fileHash){
	      SharedPreferences sharedpreferences = context.getSharedPreferences(MyPrefs, Context.MODE_PRIVATE);
	      return sharedpreferences.getString(fileHash, null);
	}
	
	
	public static void saveCaptionToBeSynced(Context context, String fileHash){
	      SharedPreferences sharedpreferences = context.getSharedPreferences(MyPrefs, Context.MODE_PRIVATE);
	      Set<String> filesHashes = getToBeSyncedCaptions(context);
	      if(filesHashes == null){
	    	  filesHashes = new HashSet<String>();
	      }
	      filesHashes.add(fileHash);
	      Editor editor = sharedpreferences.edit();
	      
	      editor.putStringSet(CaptionsToBeSynced, filesHashes);
	      editor.commit(); 
	}
	
	public static Set<String> getToBeSyncedCaptions(Context context){
	      SharedPreferences sharedpreferences = context.getSharedPreferences(MyPrefs, Context.MODE_PRIVATE);
	      return sharedpreferences.getStringSet(CaptionsToBeSynced, null);
	}
	
	public static void clearToBeSyncedCaptions(Context context){
	      SharedPreferences sharedpreferences = context.getSharedPreferences(MyPrefs, Context.MODE_PRIVATE);
	      Editor editor = sharedpreferences.edit();
	      editor.remove(CaptionsToBeSynced);
	      editor.commit();
	}
	
	
	
}
