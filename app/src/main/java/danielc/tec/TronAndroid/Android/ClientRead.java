package danielc.tec.TronAndroid.Android;

/**
 * Created by DanielC on 4/10/16.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientRead extends Thread {
    private final BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    private String serverIp;
    private int serverPort;
    private BufferedReader in;

    public ClientRead(BufferedReader in) {
        this.in = in;
    }


    @Override
    public void run() {
        if (TronClient.getInstance().isRunning()) {
            try {
                String line;
                while ((line = in.readLine()) != null) {
                    // Si el mensaje es un comando
                    if (line.substring(0, 1).equals("%")) {
                        if (line.substring(1, 1).equals("K")) {
                            TronClient.getInstance().stop();
                            //ControllerFacade.getInstance().kicked();
                        }
                    } else {
                        JsonParser.getInstance().parseJson(line);
                    }
                    // TODO: 10/3/16 ESTO HAY QUE QUITARLO Lol
                    //System.out.println(line);

                }
            } catch (IOException e) {
                //ControllerFacade.getInstance().serverDead();
                System.out.println("Se ha desconectado del servidor");
            }
        }
    }

}

