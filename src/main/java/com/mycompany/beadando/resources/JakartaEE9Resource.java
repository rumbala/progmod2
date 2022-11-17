package com.mycompany.beadando.resources;

//import business.Token;
import business.CountryCodeEnum;
import business.Parkolo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import service.ParkoloService;

/**
 *
 * @author 
 */
@Path("jakartaee9")
public class JakartaEE9Resource {
    
    @GET
    public Response ping(){
        return Response
                .ok("ping Jakarta EE")
                .build();
    }
    
    @GET
    @Path("Szabadhely/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response freeSpace(@PathParam("id") Integer id){
        return Response.ok(new ParkoloService()
                .freeSpace(id)
                .toString())
                .build();
    }
    
    @GET
    @Path("getAllParkolo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLog(){
        return Response.ok(new ParkoloService()
                .getAllParkolo()
                .toString())
                .build();
    }
    
    //TODO 415 unsopported mediatype
    //TODO find parkolo from id, call vehicleLeave()
    @POST
    @Path("vehicleLeaveParkolo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response vehicleLeaveParkolo(Object o){
        JSONObject resp = new JSONObject(o);
        return Response
                .ok(o.toString())
                .build();
    }
    //TODO 415 unsopported mediatype
    //TODO find parkolo from id, call vehicleEnter()
    @POST
    @Path("vehicleEnterParkolo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response vehicleEnterParkolo(Object o){
        JSONObject resp = new JSONObject(o);
        return Response
                .ok(o.toString())
                .build();
    }
} 
