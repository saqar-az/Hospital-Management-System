import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public interface Staff extends Serializable {
    ArrayList<String> un = new ArrayList<>();
    void deleteAccount() throws IOException;
}
