import cliente.Cliente;
import ingressos.Ingresso;
import ingressos.LugarDisponivel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIngressos {

    Ingresso ingressos;

    @BeforeEach
    public void setUp(){
        ingressos =new Ingresso();
    }


    @Test
    public void VerificarSeoClienteVaiComprarOingresso(){

        Cliente cliente = new Cliente(18,true);
        ingressos.verificarCompra(cliente);
       Assertions.assertEquals(true,ingressos.getIngresso());

    }

    @Test
    public void VerificarSeAidadeDoClienteEmaiorQue18(){

        Cliente cliente = new Cliente(16,true);
        ingressos.verIdade(cliente);
        Assertions.assertEquals("É de menor",ingressos.getMaiorIdade());

    }

    @Test
    public void VerificarAcorDaPulseira(){
        Cliente cliente = new Cliente(18,true);
       // Cliente idade = new Cliente(18,true);

        ingressos.pegarPulseira(cliente);

        Assertions.assertEquals("Pulseira Verde",ingressos.getCorPulseira());
    }


    @Test
    public void VerificarAareaDoCliente(){

        LugarDisponivel lugar = Mockito.mock(LugarDisponivel.class);
        when(lugar.getLugarLivre()).thenReturn(10f);

        Cliente cliente = Mockito.mock(Cliente.class);
        when(cliente.getCompra()).thenReturn(false);

        Assertions.assertEquals("Sem Pulseira", ingressos.verificarArea(cliente,lugar)
        );
    }



}
