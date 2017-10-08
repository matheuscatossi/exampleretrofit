package br.matheuscatossi.com.exampleretrofit.webservices;

import br.matheuscatossi.com.exampleretrofit.model.Person;
import br.matheuscatossi.com.exampleretrofit.utils.Constants;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by matheuscatossi on 08/10/17.
 */


public interface APIInterface {

    @GET(Constants.GET_INFO)
    Call<Person> getInfo();

}