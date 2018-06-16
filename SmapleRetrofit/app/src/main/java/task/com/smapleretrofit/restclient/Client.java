package task.com.smapleretrofit.restclient;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import task.com.smapleretrofit.interfaces.SampleTest;

/**
 * Created by SAFACS on 6/16/2018.
 */

public class Client {

    public static final String BASEURL = "https://stg.api.bazaarvoice.com/";

    public static  SampleTest getInterfaceCallback(){
        SampleTest sampleTest = getRetrofitClient().create(SampleTest.class);
        return  sampleTest;
    }


    public interface GetServiceResponce {
        void onSuccess(Response<ResponseBody> response);

        void onFailure(Throwable t);

        void onFailure(String error);
    }

    public static Retrofit getRetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }


}
