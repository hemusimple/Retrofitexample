package task.com.smapleretrofit.restclient;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import task.com.smapleretrofit.interfaces.SampleTest;

/**
 * Created by SAFACS on 6/16/2018.
 */

public class ServiceCall {


      public  static  Call<ResponseBody>  getResponse(String url,Client.GetServiceResponce getServiceResponce){
          SampleTest sampleTest = Client.getInterfaceCallback();

        Call<ResponseBody> responseBodyCall=  sampleTest.sampleget(url);

        responseBodyCall.enqueue(getCallback(getServiceResponce));

        return  responseBodyCall;

      }



    public static Callback<ResponseBody> getCallback(final Client.GetServiceResponce getJsonResult) {
        Callback<ResponseBody> callback = new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    getJsonResult.onSuccess(response);
                } else {
                    getJsonResult.onFailure("");
                }
                call.cancel();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                getJsonResult.onFailure(t);
            }
        };
        return callback;
    }
}