package br.matheuscatossi.com.exampleretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.matheuscatossi.com.exampleretrofit.model.Person;
import br.matheuscatossi.com.exampleretrofit.webservices.APIClient;
import br.matheuscatossi.com.exampleretrofit.webservices.APIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tv_name, tv_age;
    private Button btn_update;

    private Call<Person> call;
    private APIInterface apiService;
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_update = (Button) findViewById(R.id.btn_update);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_age = (TextView) findViewById(R.id.tv_age);

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestInfo();
            }
        });

        requestInfo();
    }

    private void requestInfo(){
        apiService = APIClient.getService().create(APIInterface.class);
        call = apiService.getInfo();

        call.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {

                person = (Person) response.body();

                tv_name.setText("Name: " + person.getName());
                tv_age.setText("Age: " + person.getAge());

            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                Log.e("Networking", t.toString());

            }
        });

    }
}
