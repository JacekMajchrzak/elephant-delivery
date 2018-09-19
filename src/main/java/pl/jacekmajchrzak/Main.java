package pl.jacekmajchrzak;

import io.javalin.Javalin;
import pl.jacekmajchrzak.features.STATE;
import pl.jacekmajchrzak.features.TurnFeatureRequest;

import java.util.HashMap;
import java.util.Map;


public class Main {

    static Map<String, String> reservations = new HashMap<String, String>() {{
        put("saturday", "No reservation");
        put("sunday", "No reservation");
    }};
    
    static Map<String, STATE> features = new HashMap<String, STATE>() {{
        put("EXAMPLE", STATE.ON);
        put("EXAMPLE2", STATE.ON);
    }};

    public static void main(String[] args) {

        Javalin app = Javalin.create()
            .port(7070)
            .enableStaticFiles("/public")
            .start();

        app.post("/post-form", ctx -> {
            reservations.put(ctx.formParam("day"), ctx.formParam("time"));
            ctx.html("Your reservation has been saved");
        });
    
        app.get("/features", ctx -> {
            ctx.json(features);
        });
        
        app.post("/features/:key", ctx -> {
            TurnFeatureRequest turnFeatureRequest = ctx.bodyAsClass(TurnFeatureRequest.class);
            String featureToChange = ctx.pathParam("key");
            features.replace(featureToChange, turnFeatureRequest.getTurnToState());
        });

    }

}


