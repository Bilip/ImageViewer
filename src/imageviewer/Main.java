package imageviewer;

import imageviewer.commands.ActionListenerFactory;
import imageviewer.commands.Command;
import imageviewer.commands.NextImageCommand;
import imageviewer.commands.PrevImageCommand;
import imageviewer.model.Image;
import imageviewer.persistence.ImageSetLoader;
import imageviewer.ui.ApplicationFrame;
import imageviewer.ui.ImagePanel;
import imageviewer.ui.ImageViewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private final String filename = "C:\\Users\\Alejandro\\Documents\\NetBeansProjects\\ImageViewer\\media";
    private ApplicationFrame frame;
    private Map<String, Command> commandMap;

    public static void main(String[] args) {
        new Main().execute();
    }

    public ImageViewer creImageViewer(Image image) {
        ImageViewer viewer = new ImagePanel();
        viewer.setImage(image);
        return viewer;
    }

    public void createCommands() {
        commandMap = new HashMap<>();
        commandMap.put("Previous Image", new PrevImageCommand(frame.getImageViewer()));
        commandMap.put("Next Image", new NextImageCommand(frame.getImageViewer()));
    }

    private void execute() {
        List<Image> images = new ImageSetLoader(filename).load();
        frame = createApplicationFrame();
        frame.getImageViewer().setImage(images.get(0));
        createCommands();
        frame.setVisible(true);
    }

    private ApplicationFrame createApplicationFrame() {
        return new ApplicationFrame(new ActionListenerFactory() {
            @Override
            public ActionListener createActionListener(final String action) {
                return new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Command command = commandMap.get(action);
                        if (command == null) {
                            return;
                        }
                        command.execute();
                    }
                };
            }
        });

    }

}
