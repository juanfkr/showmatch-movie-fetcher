package services;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Serialize {
    // Define padrão de nomenclatura do JSON p/ Upper Camel Case
    public static Gson upperCamelCase() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
    }
}
