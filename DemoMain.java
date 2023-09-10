import com.formdev.flatlaf.FlatIntelliJLaf;
import store.store;

import javax.swing.*;

public class DemoMain {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatIntelliJLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        store.init();
        new MainMenu().setVisible(true);
    }
}
