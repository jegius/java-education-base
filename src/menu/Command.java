package menu;

import java.io.IOException;

public interface Command {
    
    Command execute() throws IOException;
    
}
