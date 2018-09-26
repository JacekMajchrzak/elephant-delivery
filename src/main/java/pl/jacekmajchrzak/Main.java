package pl.jacekmajchrzak;

import io.javalin.Javalin;
import pl.jacekmajchrzak.features.STATE;
import pl.jacekmajchrzak.features.TurnFeatureRequest;

import java.util.HashMap;
import java.util.Map;


public class Main {

    static Map<String, STATE> features = new HashMap<String, STATE>() {{
        put("PRICE", STATE.OFF);
    }};

    public static void main(String[] args) {

        Javalin app = Javalin.create()
            .port(7070)
            .enableStaticFiles("/public")
            .start();
    
        app.get("/features", ctx -> {
            ctx.json(features);
        });
        
        app.post("/features/:key", ctx -> {
            TurnFeatureRequest turnFeatureRequest = ctx.bodyAsClass(TurnFeatureRequest.class);
            String featureToChange = ctx.pathParam("key");
            features.replace(featureToChange, turnFeatureRequest.getTurnToState());
        });
    
        app.post("/calculate", ctx -> {
            final String price = ctx.formParam("price");
            final String count = ctx.formParam("count");
            final String state = ctx.formParam("state");
            final double totalPrice = 10.0;
            ctx.json(totalPrice);
        });

    }

}


