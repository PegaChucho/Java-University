package test;

import domain.Persona;
import java.util.List;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class TestPersonaServiceRS {

    //variables
    private static final String URL_BASE = "http://localhost:8080/sga-jee-web/webservice";
    private static Client cliente;
    private static WebTarget webTarget;
    private static Persona persona;
    private static List<Persona> personas;
    private static Invocation.Builder invocationBuilder;
    private static Response response;

    public static void main(String[] args) {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder()
                .nonPreemptive().credentials("admin", "admin").build();

        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(feature);

        cliente = ClientBuilder.newClient(clientConfig);

        //Leer una persona (método get)
        webTarget = cliente.target(URL_BASE).path("/personas");
        //Proporcionamos un idPersona válido
        persona = webTarget.path("/1").request(MediaType.APPLICATION_XML).get(Persona.class);
        System.out.println("Persona recuperada: " + persona);

        //Leer todas las personas (método get con readEntity de tipo List<>
        personas = webTarget.request(MediaType.APPLICATION_XML).get(Response.class).readEntity(new GenericType<List<Persona>>() {
        });
        System.out.println("\nPersonas recuperadas:");
        imprimirpersonas(personas);

        //Agregar una persona POST
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre("Alvin");
        nuevaPersona.setApellido("Yakitori");
        nuevaPersona.setEmail("aydrake5@nikelodeon.com");
        nuevaPersona.setTelefono("55797638");

        invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        response = invocationBuilder.post(Entity.entity(nuevaPersona, MediaType.APPLICATION_XML));
        System.out.println("");
        System.out.println("Response: " + response.getStatus());
        //Recuperamos la persona recien agregada para despues modificarla y eliminarla
        Persona personaRecuperada = response.readEntity(Persona.class);
        System.out.println("Persona Agregada = " + personaRecuperada);

        //modificar la persona PUT
        //persona recuperada anteriormente
        Persona personaModificada = personaRecuperada;
        personaModificada.setNombre("Drake");
        String pathID = "/" + personaModificada.getIdPersona();
        invocationBuilder = webTarget.path(pathID).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.put(Entity.entity(personaModificada, MediaType.APPLICATION_XML));

        System.out.println("");
        System.out.println("Response: " + response.getStatus());
        System.out.println("Persona modificada: " + response.readEntity(Persona.class));

        //Eliminar una persona
        //Persona recuperada anteriormente
        Persona personaEliminada = personaRecuperada;
        String pathEliminarID = "/" + personaEliminada.getIdPersona();
        invocationBuilder = webTarget.path(pathEliminarID).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.delete();

        System.out.println("");
        System.out.println("Response: " + response.getStatus());
        System.out.println("Persona eliminada: " + personaEliminada);

    }

    private static void imprimirpersonas(List<Persona> personas) {
        for (Persona p : personas) {
            System.out.println("Persona: " + p);
        }
    }
}
