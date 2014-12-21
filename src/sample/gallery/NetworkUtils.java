package sample.gallery;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.AuthFailureError;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class NetworkUtils {

	public static boolean isConnectedToInternet(Context _context) {
		ConnectivityManager connectivity = (ConnectivityManager) _context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity != null) {
			NetworkInfo[] info = connectivity.getAllNetworkInfo();
			if (info != null)
				for (int i = 0; i < info.length; i++)
					if (info[i].getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}

		}
		return false;
	}

	public static void saveUserCaptionsServer(final Context context) {
		// Request a string response from the provided URL.
		String url = "www.google.com";
		StringRequest stringRequest = new StringRequest(
				com.android.volley.Request.Method.POST, url,
				new Listener<String>() {
					@Override
					public void onResponse(String response) {
						try {
							JSONObject responseJson = new JSONObject(response);
							if(responseJson.optBoolean("statuc", false)){
								SPUtils.clearToBeSyncedCaptions(context);
							}
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}, new com.android.volley.Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
					}
				}){
			@Override
			protected Map<String, String> getParams()
					throws AuthFailureError {
				Set<String> captions = SPUtils.getToBeSyncedCaptions(context);
				HashMap<String, String> params = new HashMap<String, String>();
				for (String string : captions) {
					params.put(string, SPUtils.getCaptionLocally(context, string));
				}
				return params;
			}
		};
		
		RequestQueueProvider.getInstance(context).addToRequestQueue(stringRequest);
	}
}
