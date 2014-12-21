package sample.gallery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {
        if(NetworkUtils.isConnectedToInternet(context)){
        	if(SPUtils.getToBeSyncedCaptions(context) != null){
        		Toast.makeText(context, "Internet connected, Syncing captions.", Toast.LENGTH_SHORT).show();
        		NetworkUtils.saveUserCaptionsServer(context);
        	}
        }
    }
}