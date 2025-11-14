package com.mieleria;

import com.mieleria.routes.*;
import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {

            config.plugins.enableCors(cors -> cors.add(it -> it.anyHost()));
        }).start(7000);

        app.before(ctx -> ctx.contentType("application/json"));

        new UserRoutes().register(app);
        new ProductRoutes().register(app);
        new CommentRoutes().register(app);
        new CartRoutes().register(app);
        new ShippingRoutes().register(app);
        new PaymentRoutes().register(app);
        new CancelledProductRoutes().register(app);


        System.out.println("🚀 API de Mielería corriendo en http://localhost:7000");
    }
}
