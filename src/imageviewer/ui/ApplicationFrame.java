package imageviewer.ui;

import imageviewer.commands.ActionListenerFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame {

    private final ActionListenerFactory factory;
    private ImageViewer imageViewer;

    public ApplicationFrame(ActionListenerFactory factory) {
        super("Image Viewer");
        this.factory = factory;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1024, 768);
        this.createComponents();
    }

    public ImageViewer getImageViewer() {
        return imageViewer;
    }

    private void createComponents() {
        this.add(createToolbarPanel(), BorderLayout.NORTH);
        this.add(createImagePanel());
    }

    private JPanel createToolbarPanel() {
        JPanel panel = new JPanel();
        panel.add(createPrevButton());
        panel.add(createNextButton());
        panel.setBackground(Color.white);
        return panel;
    }

    private JPanel createImagePanel() {
        ImagePanel imagePanel = new ImagePanel();
        this.imageViewer = imagePanel;
        return imagePanel;
    }

    private JButton createNextButton() {
        JButton button = new JButton("Next Image >");
        button.addActionListener(factory.createActionListener("Next Image"));
        button.setBackground(Color.white);
        return button;
    }

    private JButton createPrevButton() {
        JButton button = new JButton("< Previous Image");
        button.addActionListener(factory.createActionListener("Previous Image"));
        button.setBackground(Color.white);
        return button;
    }

}
