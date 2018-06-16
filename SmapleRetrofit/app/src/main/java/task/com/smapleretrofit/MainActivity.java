package task.com.smapleretrofit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Response;
import task.com.smapleretrofit.asynchtask.SampleAsynchTask;
import task.com.smapleretrofit.restclient.Client;
import task.com.smapleretrofit.restclient.ServiceCall;

public class MainActivity extends AppCompatActivity implements SampleAsynchTask.SampleResponse {
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        getserviceresponce();
    }

    public void getserviceresponce() {
        dialog.show();
        ServiceCall.getResponse(Utiles.GETURL, new Client.GetServiceResponce() {
            @Override
            public void onSuccess(Response<ResponseBody> response) {
                dialog.dismiss();
                if (response.isSuccessful()) {
                    try {
                        SampleAsynchTask sampleAsynchTask = new SampleAsynchTask(MainActivity.this);
                        sampleAsynchTask.execute(response);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }

            @Override
            public void onFailure(String error) {

            }
        });


    }

    @Override
    public void responcesample(String response) {
        //   Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
        TextView sample = (TextView) findViewById(R.id.test);
        sample.setText(response);
    }
}
