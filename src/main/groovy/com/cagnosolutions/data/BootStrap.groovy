package com.cagnosolutions.data

import org.vertx.groovy.core.Vertx

/**
 * Created by Scott Cagno.
 * Copyright Cagno Solutions. All rights reserved.
 */

class BootStrap {
    def init = { servletContext ->
        def vertx = Vertx.newVertx()
        def httpServer = vertx.createHttpServer()
        vertx.createSockJSServer(httpServer).installApp(prefix: '/events') { sock ->
            sock.dataHandler { buff ->
                sock << buff
            }
        }
        httpServer.listen(8585)
    }
    def destroy = {
        // something goes in here
    }
}