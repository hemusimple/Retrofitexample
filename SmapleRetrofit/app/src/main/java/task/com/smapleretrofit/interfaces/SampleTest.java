package task.com.smapleretrofit.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;

import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by SAFACS on 6/16/2018.
 */

public interface SampleTest {
    @Headers({"Accept: application/json","Content-Type:application/json"})
    @GET()
    Call<ResponseBody> sampleget(@Url String fileUrl);

    @FormUrlEncoded
    @POST()
    Call<ResponseBody> samplepost(@Url String fileurl);
}