package Services;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class HttpRequest {

    private RequestQueue queue = null;
    private String url ="http://opticare.9xlabs.com/api";
//    private String url ="http://192.168.1.7:3000/api";

    public HttpRequest(){}

    public String getUri(){
        return  url;
    }


    public HttpRequest(String uri){
        url = uri;
    }

    public void getRequest(){
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("That didn't work!");
            }
        });
        queue.add(stringRequest);
    }
}
