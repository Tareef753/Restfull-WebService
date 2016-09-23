/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RFPackage;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonString;
import javax.json.JsonValue;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import org.json.*;


/**
 * REST Web Service
 *
 * @author Android
 */
@Path("{par}")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of RFPackage.GenericResource
     *
     * @param par
     * @param inputJsonObj
     * @return an instance of java.lang.String
     * @throws org.json.JSONException
     */
    @GET
    @Path("/findSolution")
  
    @Produces("application/json") 
    public String getJson(@PathParam("par") String par) throws JSONException {
        
        JSONObject o = new JSONObject(par);
      double a ,b ,c;
      double delta,x1,x2;
       a =  Double.parseDouble(o.get("a")+".0");
      
           b =  Double.parseDouble(o.get("b")+".0");
      
           c =  Double.parseDouble(o.get("c")+".0");
       //System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
       
       if(a==0){return  "first degree";}
      delta = (b*b) - (4 * a *c);
      
      if(delta<0){
           delta=Math.abs(delta);
             x1=(-b+Math.sqrt(delta))/2*a;
             x2=(-b-Math.sqrt(delta))/2*a;
            return "The equation has no real root dalta<0:{'x1':'" + b + "+" + delta + "i /" + 2 * a + "','x2':'" + b + "-" + delta + "i /" + 2 * a + "'}";
        
      }
      
      else if(delta==0){
          x1 = b / (2 * a); 
          x2= b / (2 * a);
          return "The equation has one root {'x1':" + x1 + ",'x2':" + x2 + "}";
      }
      else {
          delta = Math.sqrt(delta);
          x1= (-b-delta) / (2*a);
          x2= (-b+delta) / (2*a);
          return "The equation has two real roots{'x1':" + x1 + ",'x2':" + x2 + "}";

      }
       
      
    }


    /**
     * PUT method for updating or creating an instance of GenericResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
