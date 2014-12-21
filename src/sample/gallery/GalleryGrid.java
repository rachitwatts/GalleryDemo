package sample.gallery;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.origamilabs.library.views.StaggeredGridView;
import com.origamilabs.library.views.StaggeredGridView.OnItemClickListener;

public class GalleryGrid extends Activity{

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Gallery");
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.grid_view);
        
        setProgressBarIndeterminateVisibility(Boolean.TRUE);
        Toast.makeText(this, "Fetching Captions", Toast.LENGTH_SHORT).show();
        fetchUserCaptionsServer();
 
        StaggeredGridView gridview = (StaggeredGridView) findViewById(R.id.gridview);
        GridAdapter adapter = new GridAdapter(this);
        
        gridview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        gridview.setSelector(null);
        gridview.setSelectionToTop();
        gridview.setColumnCount(2);
        
        int margin = 10;
        gridview.setItemMargin(margin); 
        gridview.setPadding(margin, 0, margin, 0); 
        
        gridview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(StaggeredGridView parent, View view,
					int position, long id) {
				Intent i = new Intent(getApplicationContext(),
						GalleryPager.class);
				i.putExtra("id", position);
				startActivity(i);
				overridePendingTransition(R.anim.slide_in, R.anim.fade_out);
			}
		});
    }
 
    void fetchUserCaptionsServer() {
		String url = "www.google.com";
		StringRequest stringRequest = new StringRequest(
				com.android.volley.Request.Method.POST, url,
				new Listener<String>() {
					@Override
					public void onResponse(String response) {
						setProgressBarIndeterminateVisibility(Boolean.FALSE); 
						try {
							JSONObject responseJson = new JSONObject(response);
							if(responseJson.optBoolean("status", false)){
							}
						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
				}, new com.android.volley.Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						new Handler().postDelayed(new Runnable() {
							
							@Override
							public void run() {
								setProgressBarIndeterminateVisibility(Boolean.FALSE);
							}
						}, 2000);
					}
				});
		RequestQueueProvider.getInstance(this).addToRequestQueue(stringRequest);
	}
}
