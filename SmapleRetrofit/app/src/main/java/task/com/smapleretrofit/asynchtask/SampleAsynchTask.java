package task.com.smapleretrofit.asynchtask;

import android.content.Context;
import android.os.AsyncTask;

import java.lang.ref.WeakReference;

import okhttp3.ResponseBody;
import retrofit2.Response;
import task.com.smapleretrofit.Utiles;

/**
 * Created by SAFACS on 6/16/2018.
 */

public class SampleAsynchTask extends AsyncTask<Object,Object,Object> {

    WeakReference<SampleResponse> weakReference;

    public SampleAsynchTask(SampleResponse sampleResponse) {
        this.weakReference = new WeakReference<>(sampleResponse);
    }

    @Override
    protected Object doInBackground(Object... objects) {
        Response<ResponseBody>  response = (Response<ResponseBody>)objects[0];
        String responsebody=   Utiles.convertStreamToString(response.body().byteStream());
        return responsebody;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        if(weakReference!=null && o!=null){
            SampleResponse sampleResponse = weakReference.get();
            sampleResponse.responcesample((String)o);
            weakReference.clear();
        }
    }

    public interface SampleResponse {
        void responcesample(String response);
    }
}
