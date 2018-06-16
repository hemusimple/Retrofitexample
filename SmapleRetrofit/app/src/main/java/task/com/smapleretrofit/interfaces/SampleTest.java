package task.com.smapleretrofit.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by SAFACS on 6/16/2018.
 */

public interface SampleTest {

    @GET()
    Call<ResponseBody> sampleget(@Url String fileUrl);
}